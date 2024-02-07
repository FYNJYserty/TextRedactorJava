package ru.project.textredactor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame2 extends JFrame {

    public String[] colors = {"BLACK", "BLUE", "CYAN", "DARK GRAY", "GRAY", "GREEN", "LIGHT GRAY",
    "MAGENTA", "ORANGE", "PINK", "RED", "WHITE", "YELLOW"};

    public int colorRed = 0;
    public int colorGreen = 0;
    public int colorBlue = 0;

    Frame2(String title) {
        JFrame fr2 = new JFrame(title);
        fr2.setSize(400, 300);

        JLabel alarm = new JLabel("Введите цвет в формате RGB");
        alarm.setBounds(30, 30, 250, 20);

        JLabel rgb1 = new JLabel("R = ");
        rgb1.setBounds(10, 50, 40, 20);
        JTextField tf1 =new JTextField();
        tf1.setBounds(50,50,150,20);
        JLabel rgb2 = new JLabel("G = ");
        rgb2.setBounds(10, 100, 40, 20);
        JTextField tf2 =new JTextField();
        tf2.setBounds(50,100,150,20);
        JLabel rgb3 = new JLabel("B = ");
        rgb3.setBounds(10, 150, 40, 20);
        JTextField tf3 =new JTextField();
        tf3.setBounds(50,150,150,20);

        JComboBox col = new JComboBox<String>(colors);
        col.setBounds(250, 100, 130, 20);

        JLabel warning = new JLabel();
        warning.setBounds(50, 230, 250, 20);

        JButton pre = new JButton("V");
        pre.setBounds(200, 90, 40, 40);

        JButton accept = new JButton("Принять");
        accept.setBounds(50, 200, 100, 20);

        JTextField colorArea = new JTextField();
        colorArea.setBounds(180, 190, 40, 40);
        colorArea.setEditable(false);
        colorArea.setBackground(new Color(colorRed, colorGreen, colorBlue));

        fr2.add(colorArea);
        fr2.add(col);

        fr2.add(pre);

        fr2.add(alarm);

        fr2.add(warning);

        fr2.add(rgb1);
        fr2.add(rgb2);
        fr2.add(rgb3);

        fr2.add(tf1);
        fr2.add(tf2);
        fr2.add(tf3);
        fr2.add(accept);
        //////////////Scripts
        pre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) throws NumberFormatException {
                try {
                    int color1 = Integer.parseInt(tf1.getText());
                    int color2 = Integer.parseInt(tf2.getText());
                    int color3 = Integer.parseInt(tf3.getText());
                    if (color1 >= 0 && color2 >= 0 && color3 >= 0 && color1 <= 255 && color2 <= 255 && color3 <= 255) {
                        colorArea.setBackground(new Color(color1, color2, color3));
                        warning.setText("");
                    }
                    else {
                        warning.setText("Числа не входят в диапозон цветов");
                    }
                }
                catch (NumberFormatException e2) {
                    warning.setText("Неправильный формат ввода");
                }
            }
        });

        accept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame.isOpen = false;
                fr2.setVisible(false);
                Frame.red = Integer.parseInt(tf1.getText());
                Frame.green = Integer.parseInt(tf2.getText());
                Frame.blue = Integer.parseInt(tf3.getText());
            }
        });

        col.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = col.getSelectedItem().toString();
                switch (result) {
                    case "BLACK":
                        colorArea.setBackground(Color.BLACK);
                        colorRed = Color.BLACK.getRed();
                        colorGreen = Color.BLACK.getGreen();
                        colorBlue = Color.BLACK.getBlue();
                        tf1.setText(String.valueOf(colorRed));
                        tf2.setText(String.valueOf(colorGreen));
                        tf3.setText(String.valueOf(colorBlue));
                        break;
                    case "BLUE":
                        colorArea.setBackground(Color.BLUE);
                        colorRed = Color.BLUE.getRed();
                        colorGreen = Color.BLUE.getGreen();
                        colorBlue = Color.BLUE.getBlue();
                        tf1.setText(String.valueOf(colorRed));
                        tf2.setText(String.valueOf(colorGreen));
                        tf3.setText(String.valueOf(colorBlue));
                        break;
                    case "CYAN":
                        colorArea.setBackground(Color.CYAN);
                        colorRed = Color.CYAN.getRed();
                        colorGreen = Color.CYAN.getGreen();
                        colorBlue = Color.CYAN.getBlue();
                        tf1.setText(String.valueOf(colorRed));
                        tf2.setText(String.valueOf(colorGreen));
                        tf3.setText(String.valueOf(colorBlue));
                        break;
                    case "DARK GRAY":
                        colorArea.setBackground(Color.DARK_GRAY);
                        colorRed = Color.DARK_GRAY.getRed();
                        colorGreen = Color.DARK_GRAY.getGreen();
                        colorBlue = Color.DARK_GRAY.getBlue();
                        tf1.setText(String.valueOf(colorRed));
                        tf2.setText(String.valueOf(colorGreen));
                        tf3.setText(String.valueOf(colorBlue));
                        break;
                    case "GRAY":
                        colorArea.setBackground(Color.GRAY);
                        colorRed = Color.GRAY.getRed();
                        colorGreen = Color.GRAY.getGreen();
                        colorBlue = Color.GRAY.getBlue();
                        tf1.setText(String.valueOf(colorRed));
                        tf2.setText(String.valueOf(colorGreen));
                        tf3.setText(String.valueOf(colorBlue));
                        break;
                    case "GREEN":
                        colorArea.setBackground(Color.GREEN);
                        colorRed = Color.GREEN.getRed();
                        colorGreen = Color.GREEN.getGreen();
                        colorBlue = Color.GREEN.getBlue();
                        tf1.setText(String.valueOf(colorRed));
                        tf2.setText(String.valueOf(colorGreen));
                        tf3.setText(String.valueOf(colorBlue));
                        break;
                    case "LIGHT GRAY":
                        colorArea.setBackground(Color.LIGHT_GRAY);
                        colorRed = Color.LIGHT_GRAY.getRed();
                        colorGreen = Color.LIGHT_GRAY.getGreen();
                        colorBlue = Color.LIGHT_GRAY.getBlue();
                        tf1.setText(String.valueOf(colorRed));
                        tf2.setText(String.valueOf(colorGreen));
                        tf3.setText(String.valueOf(colorBlue));
                        break;
                    case "MAGENTA":
                        colorArea.setBackground(Color.MAGENTA);
                        colorRed = Color.MAGENTA.getRed();
                        colorGreen = Color.MAGENTA.getGreen();
                        colorBlue = Color.MAGENTA.getBlue();
                        tf1.setText(String.valueOf(colorRed));
                        tf2.setText(String.valueOf(colorGreen));
                        tf3.setText(String.valueOf(colorBlue));
                        break;
                    case "ORANGE":
                        colorArea.setBackground(Color.ORANGE);
                        colorRed = Color.ORANGE.getRed();
                        colorGreen = Color.ORANGE.getGreen();
                        colorBlue = Color.ORANGE.getBlue();
                        tf1.setText(String.valueOf(colorRed));
                        tf2.setText(String.valueOf(colorGreen));
                        tf3.setText(String.valueOf(colorBlue));
                        break;
                    case "PINK":
                        colorArea.setBackground(Color.PINK);
                        colorRed = Color.PINK.getRed();
                        colorGreen = Color.PINK.getGreen();
                        colorBlue = Color.PINK.getBlue();
                        tf1.setText(String.valueOf(colorRed));
                        tf2.setText(String.valueOf(colorGreen));
                        tf3.setText(String.valueOf(colorBlue));
                        break;
                    case "RED":
                        colorArea.setBackground(Color.RED);
                        colorRed = Color.RED.getRed();
                        colorGreen = Color.RED.getGreen();
                        colorBlue = Color.RED.getBlue();
                        tf1.setText(String.valueOf(colorRed));
                        tf2.setText(String.valueOf(colorGreen));
                        tf3.setText(String.valueOf(colorBlue));
                        break;
                    case "WHITE":
                        colorArea.setBackground(Color.WHITE);
                        colorRed = Color.WHITE.getRed();
                        colorGreen = Color.WHITE.getGreen();
                        colorBlue = Color.WHITE.getBlue();
                        tf1.setText(String.valueOf(colorRed));
                        tf2.setText(String.valueOf(colorGreen));
                        tf3.setText(String.valueOf(colorBlue));
                        break;
                    case "YELLOW":
                        colorArea.setBackground(Color.YELLOW);
                        colorRed = Color.YELLOW.getRed();
                        colorGreen = Color.YELLOW.getGreen();
                        colorBlue = Color.YELLOW.getBlue();
                        tf1.setText(String.valueOf(colorRed));
                        tf2.setText(String.valueOf(colorGreen));
                        tf3.setText(String.valueOf(colorBlue));
                        break;
                }
            }
        });
        //////////////
        fr2.setLayout(null);
        fr2.setVisible(true);
    }
}
