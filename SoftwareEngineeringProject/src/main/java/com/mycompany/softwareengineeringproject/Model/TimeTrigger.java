/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.softwareengineeringproject.Model;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author matda
 */
public class TimeTrigger implements Trigger{
    
    private LocalTime time;

    public TimeTrigger(LocalTime time) {
        this.time = time.truncatedTo(ChronoUnit.MINUTES);    
    }
    
    public LocalTime getTime() {
        return time;
    }
    
    @Override
    public boolean isTriggered(TriggerContext context){
        return context.getCurrentTime().truncatedTo(ChronoUnit.MINUTES).equals(time);
    }

    @Override
    public String toString() {
        return "TimeTrigger{" + "time=" + time + '}';
    }
    
}
