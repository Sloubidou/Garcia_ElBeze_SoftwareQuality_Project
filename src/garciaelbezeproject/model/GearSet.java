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
public class GearSet extends Observable{
    private String gearState;//lockedDown, lockedIn, moving
    private String doorState;//Open, closed
    private int id;

    public GearSet(int newId) {
        this.id = newId;
    }
    public void setGearState (String gearState){
        this.gearState = gearState;
        setChanged();
        notifyObservers(this.gearState);
    }
    public void setDoorState (String doorState){
        this.doorState = doorState;
        setChanged();
        notifyObservers(this.doorState);
    }
    
}
