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
import javax.swing.JLabel;
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
	this.mainFrame.slider.addChangeListener(this);
    } 
    
    @Override
    public void stateChanged(ChangeEvent e) {                   
	JSlider source = (JSlider)e.getSource(); 

        if(!source.getValueIsAdjusting()){
         
            switch(source.getValue()){
                case 1 :
                    handleState = UP;
                    this.bringInGearSet();
                    break;
                case 0 : 
                    handleState = DOWN;                
                        this.bringOutGearSet();
                    break;
            }
        }
    }
    public void bringInGearSet(){
        for(GearSet gearSet : gearSetList){         
            gearSet.setState(4, handleState);
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {}

        for(GearSet gearSet : gearSetList){         
            gearSet.setState(3, handleState);
        }
        try {
             Thread.sleep(5000);
        } catch (InterruptedException e) {} 
        
        for(GearSet gearSet : gearSetList){        
            gearSet.setState(2, handleState);
        }
        try {
             Thread.sleep(5000);
         } catch (InterruptedException e) {}  
        for(GearSet gearSet : gearSetList){         
            gearSet.setState(1, handleState);
        }
    }
    
    
    public void bringOutGearSet(){
        for(GearSet gearSet : gearSetList){         
            gearSet.setState(0, handleState);
        }
      
        for(GearSet gearSet : gearSetList){         
            gearSet.setState(1, handleState);
        }
     try {
           Thread.sleep(5000);
        } catch (InterruptedException e) {} 
      
        for(GearSet gearSet : gearSetList){        
            gearSet.setState(2, handleState);
        }

        try {
            Thread.sleep(5000);
         } catch (InterruptedException e) {} 
               
        for(GearSet gearSet : gearSetList){         
            gearSet.setState(3, handleState);
        }
    }
    @Override
    public void update(Observable o, Object arg) {
            if(handleState=UP){
            }
            else if(handleState=DOWN){
                
                if((int)arg==0){
                System.out.println("0");
                }
                if((int)arg==1){
                mainFrame.jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("../View/feu_orange.jpg")));
                mainFrame.porte1.setIcon(new javax.swing.ImageIcon(getClass().getResource("../View/door2_moving.jpg")));
                mainFrame.porte2.setIcon(new javax.swing.ImageIcon(getClass().getResource("../View/door2_moving.jpg")));
                mainFrame.porte3.setIcon(new javax.swing.ImageIcon(getClass().getResource("../View/door2_moving.jpg")));

                System.out.println("1");
      
                }
                if((int)arg==2){
                mainFrame.porte1.setIcon(new javax.swing.ImageIcon(getClass().getResource("../View/door2_opened.jpg")));
                mainFrame.porte2.setIcon(new javax.swing.ImageIcon(getClass().getResource("../View/door2_opened.jpg")));
                mainFrame.porte3.setIcon(new javax.swing.ImageIcon(getClass().getResource("../View/door2_opened.jpg")));
                System.out.println("2");
                
                }
                if((int)arg==3){
                mainFrame.porte1.setIcon(new javax.swing.ImageIcon(getClass().getResource("../View/door2_moving.jpg")));
                mainFrame.porte2.setIcon(new javax.swing.ImageIcon(getClass().getResource("../View/door2_moving.jpg")));
                mainFrame.porte3.setIcon(new javax.swing.ImageIcon(getClass().getResource("../View/door2_moving.jpg")));
                System.out.println("3");
                
                }
                if((int)arg==4){
                mainFrame.porte1.setIcon(new javax.swing.ImageIcon(getClass().getResource("../View/door2_closed.jpg")));
                mainFrame.porte2.setIcon(new javax.swing.ImageIcon(getClass().getResource("../View/door2_closed.jpg")));
                mainFrame.porte3.setIcon(new javax.swing.ImageIcon(getClass().getResource("../View/door2_closed.jpg")));
                mainFrame.jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("../View/feu_vert.jpg")));
                System.out.println("4");
                }
            }
    }
}