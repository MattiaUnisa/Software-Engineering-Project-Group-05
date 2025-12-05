/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.softwareengineeringproject.Test;

import com.mycompany.softwareengineeringproject.Model.*;
import java.time.LocalTime;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.temporal.ChronoUnit;


public class TimeTriggerTest {

    @Test
    public void testTriggerAtExactTime() {
        LocalTime now = LocalTime.now().truncatedTo(ChronoUnit.MINUTES);
        TimeTrigger trigger = new TimeTrigger(now);

        assertTrue(trigger.isTriggered());
    }

    @Test
    public void testTriggerAtDifferentTime() {
        LocalTime triggerTime = LocalTime.of(10, 30);
        TimeTrigger trigger = new TimeTrigger(triggerTime);
        
        assertFalse(trigger.isTriggered());
    }
}
