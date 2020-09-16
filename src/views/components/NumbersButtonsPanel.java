package views.components;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class NumbersButtonsPanel extends JPanel implements ActionListener {
    public static final Color buttonBackgorundColor = new Color(33, 32, 37);
    public static final Font buttonFont = new Font("Roboto", Font.BOLD, 17);
    private JTextField numberText;
    GridLayout gridNumbersLayout;

    public NumbersButtonsPanel(JTextField numberText) {
        this.numberText = numberText;
        setBackground(Color.BLACK);

        gridNumbersLayout = new GridLayout();
        gridNumbersLayout.setRows(4);
        gridNumbersLayout.setColumns(3);
        setLayout(gridNumbersLayout);

        JButton button7 = new JButton("7");
        button7.addActionListener(this::actionPerformed);
        button7.setBorder(getCompoundBorder());
        button7.setForeground(Color.gray);
        button7.setBackground(buttonBackgorundColor);
        button7.setFont(buttonFont);
        button7.addMouseListener(new MouseAdapter());
        add(button7);

        JButton button8 = new JButton("8");
        button8.addActionListener(this::actionPerformed);
        button8.setBorder(getCompoundBorder());
        button8.setForeground(Color.gray);
        button8.setBackground(buttonBackgorundColor);
        button8.setFont(buttonFont);
        button8.addMouseListener(new MouseAdapter());
        add(button8);

        JButton button9 = new JButton("9");
        button9.addActionListener(this::actionPerformed);
        button9.setBorder(getCompoundBorder());
        button9.setForeground(Color.gray);
        button9.setBackground(buttonBackgorundColor);
        button9.setFont(buttonFont);
        button9.addMouseListener(new MouseAdapter());
        add(button9);

        JButton button4 = new JButton("4");
        button4.addActionListener(this::actionPerformed);
        button4.setBorder(getCompoundBorder());
        button4.setForeground(Color.gray);
        button4.setBackground(buttonBackgorundColor);
        button4.setFont(buttonFont);
        button4.addMouseListener(new MouseAdapter());
        add(button4);

        JButton button5 = new JButton("5");
        button5.addActionListener(this::actionPerformed);
        button5.setBorder(getCompoundBorder());
        button5.setForeground(Color.gray);
        button5.setBackground(buttonBackgorundColor);
        button5.setFont(buttonFont);
        button5.addMouseListener(new MouseAdapter());
        add(button5);

        JButton button6 = new JButton("6");
        button6.addActionListener(this::actionPerformed);
        button6.setBorder(getCompoundBorder());
        button6.setForeground(Color.gray);
        button6.setBackground(buttonBackgorundColor);
        button6.setFont(buttonFont);
        button6.addMouseListener(new MouseAdapter());
        add(button6);

        JButton button1 = new JButton("1");
        button1.addActionListener(this::actionPerformed);
        button1.setBorder(getCompoundBorder());
        button1.setForeground(Color.gray);
        button1.setBackground(buttonBackgorundColor);
        button1.setFont(buttonFont);
        button1.addMouseListener(new MouseAdapter());
        add(button1);

        JButton button2 = new JButton("2");
        button2.addActionListener(this::actionPerformed);
        button2.setBorder(getCompoundBorder());
        button2.setForeground(Color.gray);
        button2.setBackground(buttonBackgorundColor);
        button2.setFont(buttonFont);
        button2.addMouseListener(new MouseAdapter());
        add(button2);

        JButton button3 = new JButton("3");
        button3.addActionListener(this::actionPerformed);
        button3.setBorder(getCompoundBorder());
        button3.setForeground(Color.gray);
        button3.setBackground(buttonBackgorundColor);
        button3.setFont(buttonFont);
        button3.addMouseListener(new MouseAdapter());
        add(button3);

        JButton button0 = new JButton("0");
        button0.addActionListener(this::actionPerformed);
        button0.setBorder(getCompoundBorder());
        button0.setForeground(Color.gray);
        button0.setBackground(buttonBackgorundColor);
        button0.setFont(buttonFont);
        button0.addMouseListener(new MouseAdapter());
        add(button0);

        JButton buttonPoint = new JButton(".");
        buttonPoint.addActionListener(this::actionPerformed);
        buttonPoint.setBorder(getCompoundBorder());
        buttonPoint.setForeground(Color.gray);
        buttonPoint.setBackground(buttonBackgorundColor);
        buttonPoint.setFont(buttonFont);
        buttonPoint.addMouseListener(new MouseAdapter());
        add(buttonPoint);

        JButton buttonC = new JButton("C");
        buttonC.addActionListener(this::actionPerformed);
        buttonC.setBorder(getCompoundBorder());
        buttonC.setForeground(Color.black);
        buttonC.setBackground(new Color(254, 149, 31));
        buttonC.setFont(buttonFont);
        add(buttonC);

        setBackground(Color.black);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String number = button.getText();
        if(number != "C")
            numberText.setText(numberText.getText() + number);
        else
            numberText.setText("");
    }

    private CompoundBorder getCompoundBorder() {
        return BorderFactory.createCompoundBorder(
                new CustomeBorder(),
                new EmptyBorder(new Insets(15, 25, 15, 25)));
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

    class MouseAdapter extends java.awt.event.MouseAdapter {

        JButton button;
        Color buttonColor;

        public void mouseEntered(MouseEvent e) {
            button = (JButton) e.getSource();
            buttonColor = button.getBackground();
            button.setBackground(new Color(47, 27, 37));
        }

        public void mouseExited(MouseEvent e) {
            JButton button = (JButton) e.getSource();
            button.setBackground(buttonColor);
        }
    }
}

