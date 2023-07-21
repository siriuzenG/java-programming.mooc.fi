/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mooc.logic;

import mooc.ui.UserInterface;
/**
 *
 * @author SAM
 */
public class ApplicationLogic {            
    private UserInterface userInterface;

    public ApplicationLogic(UserInterface ui) {
        this.userInterface = ui;
    }

    public void execute(int times) {
        for (int i = 0; i < times; i++) {
            System.out.println("Application logic is working");
            userInterface.update();
        }
    }
}
