package com.blessing.calculator;

import com.blessing.calculator.GUI.CalculatorLayout;
import org.json.JSONObject;

import javax.swing.*;

/**
 * Created by blessingorazulume on 8/24/16.
 */
public class CalculatorApp {
    //entry point to the app
    //main method will be hear

    public static void main(String[] args){
        //we want to build our project here
        CalculatorLayout layout = new CalculatorLayout();
        layout.setSize(300, 500);
        layout.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        layout.setVisible(true);
        layout.setResizable(false);
    }
}
