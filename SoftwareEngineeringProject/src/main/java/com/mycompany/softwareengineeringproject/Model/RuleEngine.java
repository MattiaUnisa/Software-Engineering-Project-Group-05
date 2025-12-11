/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.softwareengineeringproject.Model;

import java.time.LocalDateTime;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author matda
 */
public class RuleEngine {
    private static RuleEngine instance;
    private ObservableList<Rule> rules;
    // observer: the list updates automatically the view 
    
    private RuleEngine() {
        this.rules = FXCollections.observableArrayList();
    }
    
    // Singleton
    public static RuleEngine getInstance() {
        if (instance == null) {
            instance = new RuleEngine();
        }
        return instance;
    }
    
    public void addRule(Rule rule) {
        this.rules.add(rule);
    }
    
    public void deleteRule(Rule rule){
        this.rules.remove(rule);
    }

    public ObservableList<Rule> getRules(){
        return this.rules;
    }
    
    public void CheckAllRules(){
        for(Rule rule : rules){
            if(rule.getTrigger().isTriggered() && rule.isActive()){
                // Wrap the execution in Platform.runLater in the way that the RuleEngineThread verify if the trigger of a rule is triggered and
                // then the application thread execute it. So the application thread when is free show it on display, while the RuleEngineThread 
                // continues to check triggers
                LocalDateTime nextFireTime = null;
                
                if(rule.getRepetition().isOneTime() && rule.getRepetition().getLastExecution()!=null){
                    continue;
                }
                
                if(rule.getRepetition().getLastExecution()!=null && rule.getRepetition().getSleepPeriod()!=null){
                    nextFireTime = rule.getRepetition().getLastExecution().plus(rule.getRepetition().getSleepPeriod());
                    if (LocalDateTime.now().isBefore(nextFireTime)) {
                        continue;
                    }
                }
                
                if(rule.getRepetition().getCurrentRepetition()>=rule.getRepetition().getNumRepetition()){
                    continue;
                }
                Platform.runLater(() -> {
                    ActionContext actioncontext = new ActionContext();
                    rule.getAction().execute(actioncontext);
                    rule.getRepetition().setLastExecution(LocalDateTime.now());
                    int i = rule.getRepetition().getCurrentRepetition();
                    i++;
                    rule.getRepetition().setCurrentRepetition(i);
                    System.out.println(actioncontext.getExecutionLog());
                });
            }
        }
    }
    
    @Override
    public String toString() {
        return "RuleEngine{" + "rules=" + rules + '}';
    }
    
    
    
}
