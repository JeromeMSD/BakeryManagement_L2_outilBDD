/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakerymanager;

import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

/**
 *
 * @author jmddu
 */
public class NumberField extends TextField{
    public NumberField(){
    }
    
    @Override
    public void replaceText(int i, int i1, String string){
        if(string.matches("[0-9]") || string.isEmpty())
            super.replaceText(i, i1, string);
        else if(string.matches("[\b|/]"))
            super.replaceText(i, i1, "");
    }
    
    @Override
    public void replaceSelection(String string){
           super.replaceSelection(string);
    }
    
}
