/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garciaelbezeproject.controller;

import garciaelbezeproject.model.GearSet;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import garciaelbezeproject.view.mainJFrame;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
/**
 *
 * @author garcia
 */

public class Controller implements Observer, ChangeListener{
    private mainJFrame mainFrame;
    private ArrayList<GearSet> gearSetList;
    private boolean handleState;
    final boolean UP = false;
    final boolean DOWN = true;
    
    public Controller(mainJFrame mainFrame){
        this.mainFrame = mainFrame;
        gearSetList = new ArrayList<GearSet>();	
        gearSetList.add(new GearSet(0));
	gearSetList.add(new GearSet(1));
	gearSetList.add(new GearSet(2));
        
        for(GearSet gearSet : gearSetList){
            gearSet.addObserver(this);
        }
	mainFrame.slider.addChangeListener(this);
    } 
    
    @Override
    public void stateChanged(ChangeEvent event) {
	JSlider source = (JSlider)event.getSource();
	if(!source.getValueIsAdjusting()){
            switch(source.getValue()){
                case 0 :
                    handleState = UP;
                    for(GearSet gearSet : gearSetList){
                        gearSet.setDoorState("open");
                    }
                    break;
                case 1 : 
                    handleState = DOWN;
                    for(GearSet gearSet : gearSetList){
                        gearSet.setDoorState("open");
                    }
                    break;
            }
        }
    }
    
    @Override
    public void update(Observable o, Object arg) {
        System.out.println(arg);
        if (arg == "close"){
            System.out.println("CLOSE");
        }        
        else if (arg == "open"){
            System.out.println("OPEN");
        }        
        else if (arg == "moving"){
            System.out.println("moving");
        }
      
    }
    
}
