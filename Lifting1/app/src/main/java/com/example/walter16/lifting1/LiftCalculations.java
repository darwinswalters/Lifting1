package com.example.walter16.lifting1;

/**
 * Created by walter16 on 7/26/15.
 */
public class LiftCalculations {

    public Double oneRepMax(int repNum, Double repWeight) {
        Double oneRM = (repWeight * repNum * .0333) + repWeight;
        return oneRM;
    }

    // Calculations for weekly warmup and work sets
	/*
	 *    : warmup sets
	 *    : wk 1
	 * 	 6 - 8 : wk 2
	 * 	 9 - 11: wk 3
	 *   12 - 14: wk 4
	 *   15 : BBB
	 */

    public Double[] warmupSets(Double oneRepMax, Double[] liftArray) {
        return null;
    }

    // CHANGE TO PRIVATE
    public Double weightRound(Double weight) {
        // rounds to nearest and lowest multiple of 5
        return Math.floor(weight / 5) * 5;
    }

    public void cycleSets(Double oneRepMax, Double[] liftArray) {

        liftArray[0] = weightRound(oneRepMax * .65);
        liftArray[1] = weightRound(oneRepMax * .75);
        liftArray[2] = weightRound(oneRepMax * .85);

        liftArray[3] = weightRound(oneRepMax * .70);
        liftArray[4] = weightRound(oneRepMax * .80);
        liftArray[5] = weightRound(oneRepMax * .90);


        liftArray[6] = weightRound(oneRepMax * .75);
        liftArray[7] = weightRound(oneRepMax * .85);
        liftArray[8] = weightRound(oneRepMax * .95);

        liftArray[9] = weightRound(oneRepMax * .40);
        liftArray[10] = weightRound(oneRepMax * .50);
        liftArray[11] = weightRound(oneRepMax * .60);
    }

    public void Calculate(Double benchOneRM, Double ohpOneRM,
                          Double squatOneRM, Double deadOneRM){
        //weekOneSets(benchOneRM, CycleNumbers);


    }
}