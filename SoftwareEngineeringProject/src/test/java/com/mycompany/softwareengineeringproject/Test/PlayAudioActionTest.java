/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.softwareengineeringproject.Test;

import com.mycompany.softwareengineeringproject.Model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author anton
 */
public class PlayAudioActionTest {
    private final String valid = "C:\\Users\\matda\\OneDrive\\Desktop\\Media.wav";
    private final String notValid = "";
    
    @Test
    public void testExecuteWithMissingPath(){
        PlayAudioAction action = new PlayAudioAction(notValid);
        ActionContext context = new ActionContext();
        
        action.execute(context);
        System.out.println("context.getExecutionLog()");
        assertTrue(context.getExecutionLog().contains("ERROR: Missing Path"));
    }
    
    @Test
    public void TestStopWithoutStarting(){
        PlayAudioAction action = new PlayAudioAction(valid);
        
        assertDoesNotThrow(() -> action.stop());
    }
}
