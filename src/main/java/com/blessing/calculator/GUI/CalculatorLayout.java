package com.blessing.calculator.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Dimension2D;
import java.awt.geom.Ellipse2D;

import com.blessing.calculator.*;
import org.json.JSONObject;


/**
 * Created by blessingorazulume on 7/18/16.
 */

public class CalculatorLayout extends JFrame {
    private JPanel contentPanel;
    private JLabel projectName;
    private JComboBox convertFrom;
    private JComboBox convertTo;
    private JButton button1, button2, button3, button4, button5, button6,  button7, button8,
            button9, button0, calculate, clear;
    private JTextField getValueToConvert;
    private JTextField showResult;

    private String getNumberFromButton = "";

    public CalculatorLayout() {
        super("converter");

        //Labels
        projectName = new JLabel("Converter calculator");

        //Combo boxes
        convertFrom = new JComboBox();
        convertFrom.addItem("USD");
        convertFrom.addItem("USD");

        convertTo = new JComboBox();
        convertTo.addItem("NGN");
        convertTo.addItem("AED");
        convertTo.addItem("AFN");
        convertTo.addItem("AMD");
        convertTo.addItem("ANG");
        convertTo.addItem("AOA");
        convertTo.addItem("ARS");
        convertTo.addItem("AUD");
        convertTo.addItem("AWG");
        convertTo.addItem("AZN");
        convertTo.addItem("BAM");
        convertTo.addItem("BBD");
        convertTo.addItem("BDT");
        convertTo.addItem("BGN");
        convertTo.addItem("BHD");
        convertTo.addItem("BIF");
        convertTo.addItem("BMD");
        convertTo.addItem("BND");
        convertTo.addItem("BOB");

        //Textfields
        getValueToConvert = new JTextField();
        getValueToConvert.setEditable(false);

        showResult = new JTextField();
        showResult.setEditable(false);


        //Buttons
        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        calculate = new JButton(">>>");
        clear = new JButton("Clear");

        Dimension  dimension = new Dimension(300, 50);
        projectName.setPreferredSize(dimension);

        convertFrom.setPreferredSize(new Dimension(125, 25));
        convertTo.setPreferredSize(new Dimension(125, 25));

        getValueToConvert.setPreferredSize(new Dimension(90, 25));
        calculate.setPreferredSize(new Dimension(90, 25));
        showResult.setPreferredSize(new Dimension(90, 25));

        Dimension dimension1 = new Dimension(95, 35);
        button1.setPreferredSize(dimension1);
        button2.setPreferredSize(dimension1);
        button3.setPreferredSize(dimension1);
        button4.setPreferredSize(dimension1);
        button5.setPreferredSize(dimension1);
        button6.setPreferredSize(dimension1);
        button7.setPreferredSize(dimension1);
        button8.setPreferredSize(dimension1);
        button9.setPreferredSize(dimension1);

        button0.setPreferredSize(new Dimension(125, 35));
        clear.setPreferredSize(new Dimension(125, 35));

        //Action listeners
        Numbers n = new Numbers();
        Clear cl =  new Clear();

        Calculate cal = new Calculate();

        //Adding action-listeners to the button
        button0.addActionListener(n);
        button1.addActionListener(n);
        button2.addActionListener(n);
        button3.addActionListener(n);
        button4.addActionListener(n);
        button5.addActionListener(n);
        button6.addActionListener(n);
        button7.addActionListener(n);
        button8.addActionListener(n);
        button9.addActionListener(n);

        clear.addActionListener(cl);
        calculate.addActionListener(cal);

        //Panels for content
        contentPanel = new JPanel();
        contentPanel.setBackground(Color.orange);
        contentPanel.setLayout(new FlowLayout());

        //adding the widgets to the content panel
        contentPanel.add(projectName, BorderLayout.NORTH);
        contentPanel.add(convertFrom);
        contentPanel.add(convertTo);
        contentPanel.add(getValueToConvert);
        contentPanel.add(calculate);
        contentPanel.add(showResult);
        contentPanel.add(button1);
        contentPanel.add(button2);
        contentPanel.add(button3);
        contentPanel.add(button4);
        contentPanel.add(button5);
        contentPanel.add(button6);
        contentPanel.add(button7);
        contentPanel.add(button8);
        contentPanel.add(button9);
        contentPanel.add(button0);
        contentPanel.add(clear);

        this.setContentPane(contentPanel);
    }

    private class Numbers implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton src = (JButton) e.getSource();
            getNumberFromButton += src.getText().trim();
            getValueToConvert.setText(getNumberFromButton);
        }
    }

    private class Clear implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            getValueToConvert.setText("");
            showResult.setText("");
            getNumberFromButton = "";
        }
    }

    private class Calculate implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            final String getSelectedCurrencyToConvert = "USD"+String.valueOf(convertTo.getSelectedItem());

            Caller caller = new Caller();
            caller.makeAPICall(new OnResponse() {
                @Override
                public void response(JSONObject jsonResponse) {

                    int amountToConvert = Integer.parseInt(getNumberFromButton);

                    int result = amountToConvert * Integer.valueOf(jsonResponse.optInt(getSelectedCurrencyToConvert));

                    showResult.setText(""+result);
                }
            });

        }
    }
}
