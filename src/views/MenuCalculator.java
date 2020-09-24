package views;

import views.components.ButtonsPanel;
import views.components.NumberField;
import views.components.NumbersButtonsPanel;
import views.components.OperationsButtonsPanel;

import javax.swing.*;
import java.awt.*;

public class MenuCalculator extends JPanel {

    NumberField numberField;
    ButtonsPanel buttonsPanel;
    NumbersButtonsPanel numbersButtonsPanel;
    OperationsButtonsPanel operationsButtonsPanel;

    public MenuCalculator() {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        numberField = new NumberField();
        buttonsPanel = new ButtonsPanel();

        numbersButtonsPanel = new NumbersButtonsPanel(numberField.getNumberTxt());
        operationsButtonsPanel = new OperationsButtonsPanel(numberField.getNumberTxt());

        buttonsPanel.add(operationsButtonsPanel);
        buttonsPanel.add(numbersButtonsPanel);


        add("North", numberField);
        add("Center", buttonsPanel);
    }
}
