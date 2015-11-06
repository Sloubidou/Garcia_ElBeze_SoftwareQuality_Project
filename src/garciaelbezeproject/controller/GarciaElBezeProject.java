/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garciaelbezeproject.controller;

import javax.swing.JFrame;
import garciaelbezeproject.controller.Controller;
import garciaelbezeproject.view.mainJFrame;
import java.awt.Color;
/**
 *
 * @author garcia
 */
public class GarciaElBezeProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        mainJFrame mainFrame = new mainJFrame();
        Controller myController = new Controller(mainFrame);
        mainFrame.setVisible(true);
    }
    
}
