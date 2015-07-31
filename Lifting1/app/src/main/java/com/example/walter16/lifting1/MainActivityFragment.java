package com.example.walter16.lifting1;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */


public class MainActivityFragment extends Fragment {

    private class CycleCalculator extends AsyncTask<Double, Void, ArrayList<String>> {
        //type in

        @Override
        protected ArrayList<String> doInBackground(Double...oneRM) {
            Double oneLiftMax = oneRM[0];
            LiftCalculations liftCalculations = new LiftCalculations();
            Double[] liftArray = new Double[12];
            liftCalculations.cycleSets(oneLiftMax, liftArray);

            ArrayList<String> cycleList = new ArrayList<>();

            populateList(cycleList, liftArray);

            return cycleList;
        }

        protected void onPostExecute(ArrayList<String> result) {
            // set the ListView
            ArrayAdapter<String> cycleAdapter = new ArrayAdapter<String>(getActivity(),
                    R.layout.list_item_cycle_info, R.id.cycleListView, result);


            ListView cycleListView = (ListView) getView().findViewById(R.id.cycleListView);
            cycleListView.setAdapter(cycleAdapter);

        }

            public void populateList(ArrayList<String> cycleList, Double[] liftArray) {
                cycleList.add("1 x " + liftArray[0] + " x 5");
                cycleList.add("1 x " + liftArray[1] + " x 5");
                cycleList.add("1 x " + liftArray[2] + " x 5+");

                cycleList.add("1 x " + liftArray[3] + " x 3");
                cycleList.add("1 x " + liftArray[4] + " x 3");
                cycleList.add("1 x " + liftArray[5] + " x 3+");

                cycleList.add("1 x " + liftArray[6] + " x 5");
                cycleList.add("1 x " + liftArray[7] + " x 3");
                cycleList.add("1 x " + liftArray[8] + " x 1+");

                cycleList.add("1 x " + liftArray[9] + " x 5");
                cycleList.add("1 x " + liftArray[10] + " x 5");
                cycleList.add("1 x " + liftArray[11] + " x 5");
            }



    }

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_main, container, false);
        Button button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText editText = null;
                        editText = (EditText) editText.findViewById(R.id.editText);
                        String oneRMString = editText.getText().toString();
                        Double oneRM = Double.parseDouble(oneRMString);
                        ArrayList<String> cycleLiftList = new ArrayList<String>();
                        CycleCalculator cycleCalculator = new CycleCalculator();
                        cycleCalculator.execute(oneRM);
                    }
                }
        );

        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    public void calculateClicked(View view) {
        // create intent
        EditText editText = null;
        editText = (EditText) editText.findViewById(R.id.editText);
        String oneRMString = editText.getText().toString();
        Double oneRM = Double.parseDouble(oneRMString);
        ArrayList<String> cycleLiftList = new ArrayList<String>();
        CycleCalculator cycleCalculator = new CycleCalculator();
        cycleCalculator.execute(oneRM);

    }

}
