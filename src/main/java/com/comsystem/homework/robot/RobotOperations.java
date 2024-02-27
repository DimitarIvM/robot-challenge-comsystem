package com.comsystem.homework.robot;


import com.comsystem.homework.model.RobotAction;
import com.comsystem.homework.model.RobotPlan;

import java.util.ArrayList;
import java.util.List;

public class RobotOperations {

    /**
     * An algorithm that converts a number of days into an action plan.
     * @param days the number of days that the robot can work
     * @return The action plan <em>must maximize</em> the number of stones that the robot will dig. In other words, this
     *         algorithm must try to achieve the highest value of {@link RobotPlan#numberOfStones} possible for the
     *         number of provided days. The value of {@link RobotPlan#numberOfDays} is equal to the input
     *         days parameter
     * @see RobotPlan
     */
    public RobotPlan excavateStonesForDays(int days) {
        List<RobotAction> actionPlan = new ArrayList<>();
        int currentDay = 1;
        int stonesCollected = 0;
        int clonesCreated = 0;

        while (currentDay <= days) {
            int potentialStonesWithClone = stonesCollected + currentDay * 2;

            int stonesWithoutClone = stonesCollected + 1;

            if (potentialStonesWithClone >= stonesWithoutClone && currentDay < days) {
                actionPlan.add(RobotAction.CLONE);
                stonesCollected += currentDay * 2;
                clonesCreated++;
            } else {
                actionPlan.add(RobotAction.DIG);
                stonesCollected++;
            }
            currentDay++;
        }


        return new RobotPlan(days, stonesCollected, actionPlan);
    }


    /**
     * An algorithm that converts a number of stones into an action plan. Essentially this algorithm is the inverse of
     * {@link #excavateStonesForDays(int)}.
     * @param numberOfStones the number of stones the robot has to collect
     * @return The action plan <em>must minimize</em> the number of days necessary for the robot to dig the
     *         provided number of stones. In other words, this algorithm must try to achieve the lowest value of
     *         {@link RobotPlan#numberOfDays} possible for the number of provided stones. The value of
     *         {@link RobotPlan#numberOfStones} is equal to the numberOfStones parameter
     * @see RobotPlan
     */
    public RobotPlan daysRequiredToCollectStones(int numberOfStones) {
        List<RobotAction> actionPlan = new ArrayList<>();
        int remainingStones = numberOfStones;
        int currentDay = 1;


        while (remainingStones > 0) {

            int maxStonesToday = currentDay * 2;


            if (maxStonesToday >= remainingStones) {

                actionPlan.add(RobotAction.CLONE);
                remainingStones -= currentDay;
            } else {

                actionPlan.add(RobotAction.DIG);
                remainingStones -= 1;
            }


            currentDay++;
        }


        return new RobotPlan(currentDay - 1//because I start counting from 1
                , numberOfStones, actionPlan);
    }
    }


