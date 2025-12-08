/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.softwareengineeringproject.Model;

import java.time.LocalTime;

/**
 *
 * @author matda
 */

//This class is a container of data and consent us to expand only this class in order to avoide changes in other classes
public class TriggerContext {
    
    private final LocalTime currentTime;
    
    public TriggerContext(LocalTime currentTime){
        this.currentTime = currentTime;
    }
    
    public LocalTime getCurrentTime() {
        return currentTime;
        }
}
