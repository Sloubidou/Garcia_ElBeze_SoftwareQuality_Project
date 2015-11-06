/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garciaelbezeproject.model;

import java.util.Observable;

/**
 *
 * @author garcia
 */
public class GearSet extends Observable {

    private String gearState = "in";//in, out, moving
    private String doorState = "closed";//open, closed, moving
    private int state;
    private int id;

    public String getGearState() {
        return gearState;
    }

    public String getDoorState() {
        return doorState;
    }

    public void setGearState(String gearState) {
        this.gearState = gearState;
    }

    public void setDoorState(String doorState) {
        this.doorState = doorState;
    }

    public int getId() {
        return id;
    }

    public GearSet(int newId) {
        this.id = newId;
    }

    public void setState(int currentState, boolean handleState) {
        switch (currentState) {
            case 0:
                this.doorState = "moving";
                this.gearState = "in";
                if (handleState) {
                    this.state = 1;
                }
                break;
            case 1:
                this.doorState = "open";
                this.gearState = "moving";
                if (handleState) {
                    this.state = 2;
                } else {
                    this.state = 0;
                }
                break;
            case 2:
                this.doorState = "moving";
                this.gearState = "out";
                if (handleState) {
                    this.state = 3;
                } else {
                    this.state = 1;
                }
                break;
            case 3:
                this.doorState = "closed";
                this.gearState = "out";
                if (handleState) {
                    this.state = 4;
                } else {
                    this.state = 2;
                } 
                break;         
            case 4 :
                this.doorState = "closed";
                this.gearState = "out";
                if (!handleState) {
                    this.state = 3;
                }
                break;
            
        }
        setChanged();
        notifyObservers(this.state);
    }
}
