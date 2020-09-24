package views.components;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class OperationsButtonsPanel extends JPanel implements ActionListener {

    private JTextField numberText;
    JComboBox operationsList;
    DefaultListCellRenderer listRenderer;
    JPanel submitArea;
    JButton submitButton;
    JButton backButton;

    public OperationsButtonsPanel(JTextField numberText) {
        this.numberText = numberText;
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(300, 0));
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        operationsList = new JComboBox<String>();
        listRenderer = new DefaultListCellRenderer();
        listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);

        operationsList.addItem("SELECT OPERATION");
        operationsList.addItem("SUM");
        operationsList.addItem("SUBTRACTION");
        operationsList.addItem("MULTIPLICATION");
        operationsList.addItem("DIVISION");

        operationsList.setFont(new Font("Roboto", Font.BOLD, 12));
        operationsList.setForeground(Color.white);
        operationsList.setRenderer(listRenderer);
        operationsList.setBackground(Color.black);
        operationsList.addItemListener(this::itemStateChanged);
        operationsList.setBorder(BorderFactory.createCompoundBorder(
                new CustomeBorder(),
                new EmptyBorder(new Insets(15, 20, 15, 20))));


        submitArea = new JPanel();
        submitArea.setLayout(new GridLayout(1, 3));
        submitArea.setPreferredSize(new Dimension(100, 0));
        submitArea.setBackground(Color.BLACK);

        backButton = new JButton("<-");
        backButton.setBorder(BorderFactory.createCompoundBorder(
                new CustomeBorder(),
                new EmptyBorder(new Insets(15, 20, 15, 20))));
        backButton.setBackground(new Color(254, 149, 31));
        backButton.setFont(new Font(null, Font.BOLD, 12));
        backButton.setForeground(Color.black);

        backButton.addActionListener(this::actionPerformed);

        submitButton = new JButton("CALCULATE");
        submitButton.setBorder(BorderFactory.createCompoundBorder(
                new CustomeBorder(),
                new EmptyBorder(new Insets(15, 20, 15, 20))));
        submitButton.setBackground(new Color(143, 43, 46));
        submitButton.setFont(new Font(null, Font.BOLD, 12));
        submitButton.setForeground(Color.black);

        submitArea.add(operationsList);
        submitArea.add(backButton);
        submitArea.add(submitButton);

        submitButton.addActionListener(this::actionPerformed);

        add(submitArea);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == submitButton) {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("js");

            Object result = null;

            try {
                result = engine.eval(numberText.getText());
            } catch (ScriptException e1) {
                e1.printStackTrace();
            }
            if (result != null) {
                numberText.setText(result.toString());
            }
        }
        else {
            numberText.setText(numberText.getText().substring(0, numberText.getText().length()-1));
        }
    }

    public void itemStateChanged(ItemEvent e) {

        if(e.getStateChange() == ItemEvent.SELECTED && e.getItem().toString() != "SELECT OPERATION")
            switch (e.getItem().toString()) {
                case "SUM":
                    numberText.setText(numberText.getText() + '+');
                    operationsList.setSelectedItem("SELECT OPERATION");
                    break;

                case "SUBTRACTION":
                    numberText.setText(numberText.getText() + '-');
                    operationsList.setSelectedItem("SELECT OPERATION");
                    break;

                case "MULTIPLICATION":
                    numberText.setText(numberText.getText() + '*');
                    operationsList.setSelectedItem("SELECT OPERATION");
                    break;

                case "DIVISION":
                    numberText.setText(numberText.getText() + '/');
                    operationsList.setSelectedItem("SELECT OPERATION");
                    break;
            }

    }


    class CustomeBorder extends AbstractBorder {
        @Override
        public void paintBorder(Component c, Graphics g, int x, int y,
                                int width, int height) {
            super.paintBorder(c, g, x, y, width, height);
            Graphics2D g2d = (Graphics2D)g;
            g2d.setStroke(new BasicStroke(12));
            g2d.setColor(Color.BLACK);
            g2d.drawRoundRect(x, y, width - 1, height - 1, 25, 25);
        }
    }
}
