package com.comsystem.homework;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.Test;
import com.comsystem.homework.model.RobotAction;
import com.comsystem.homework.model.RobotPlan;
import com.comsystem.homework.robot.RobotOperations;

public class RobotOperationsTest {

    @Test
    void testExcavateStonesForDays() {

        RobotOperations robotOperations = new RobotOperations();


        int numberOfDays = 5;
        RobotPlan expectedPlan = new RobotPlan(numberOfDays, 15, List.of(
                RobotAction.CLONE, RobotAction.CLONE, RobotAction.CLONE,
                RobotAction.CLONE, RobotAction.CLONE));
        RobotOperations mockRobotOperations = mock(RobotOperations.class);
        when(mockRobotOperations.excavateStonesForDays(numberOfDays)).thenReturn(expectedPlan);


        RobotPlan actualPlan = mockRobotOperations.excavateStonesForDays(numberOfDays);
        assertEquals(expectedPlan, actualPlan);
    }

    @Test
    void testDaysRequiredToCollectStones() {

        RobotOperations robotOperations = new RobotOperations();


        int numberOfStones = 10;
        RobotPlan expectedPlan = new RobotPlan(4, 10, List.of(
                RobotAction.CLONE, RobotAction.CLONE, RobotAction.DIG, RobotAction.DIG));
        RobotOperations mockRobotOperations = mock(RobotOperations.class);
        when(mockRobotOperations.daysRequiredToCollectStones(numberOfStones)).thenReturn(expectedPlan);


        RobotPlan actualPlan = mockRobotOperations.daysRequiredToCollectStones(numberOfStones);
        assertEquals(expectedPlan, actualPlan);
    }
}
