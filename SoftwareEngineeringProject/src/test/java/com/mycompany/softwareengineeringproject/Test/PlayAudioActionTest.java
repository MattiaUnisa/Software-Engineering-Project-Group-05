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
    private final String valid = "C:\\Windows\\Media\\audio.mp3";
    private final String notValid = "";
    
    @Test
    public void testExecuteWIthMissingPath(){
        PlayAudioAction action = new PlayAudioAction(notValid);
        ActionContext context = new ActionContext();
        
        action.execute(context);
        
        assertTrue(context.getExecutionLog().contains("ERROR: The path of the audio file isn't define"));
    }
    
    @Test
    public void testExecuteWithPath(){
        PlayAudioAction action = new PlayAudioAction(valid);
        ActionContext context = new ActionContext();
        
        assertDoesNotThrow(() -> action.execute(context));
    }
    
    @Test
    public void TestStopWithoutStarting(){
        PlayAudioAction action = new PlayAudioAction(valid);
        
        assertDoesNotThrow(() -> action.stop());
    }
}
