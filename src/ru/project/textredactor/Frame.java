package ru.project.textredactor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;

import static java.awt.Font.PLAIN;


public class Frame extends JFrame {

    public String[] font = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    public String[] shr = {"Обычный", "Жирный", "Курсив"};

    public static boolean isOpen = false;
    public static boolean isOpenMessage = false;

    public static int red = 0;
    public static int green = 0;
    public static int blue = 0;

    public static int width = 800;
    public static int height = 500;

    public int outline;

    File file = new File("");

    public Frame () {
        // Форма
        JFrame fr = new JFrame("TextRedactor");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(width, height);
        // Text area
        JTextArea txt = new JTextArea();
        txt.setEditable(true);

        JScrollPane sbar = new JScrollPane(txt, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        fr.getContentPane().add(sbar);
        // Panel
        JPanel panel = new JPanel();

        JComboBox cmbx = new JComboBox<String>(font);

        JTextField size = new JTextField("14",3);
        size.setHorizontalAlignment(JTextField.CENTER);

        JLabel sizLb = new JLabel("Размер");
        JLabel cmbLb = new JLabel("Шрифт");
        JButton color = new JButton("Цвет");
        JButton accept = new JButton("Применить");
        JComboBox shrift = new JComboBox(shr);

        panel.add(cmbLb);
        panel.add(cmbx);
        panel.add(sizLb);
        panel.add(size);
        panel.add(color);
        panel.add(shrift);
        panel.add(accept);

        fr.getContentPane().add(BorderLayout.SOUTH, panel);
        // Menu
        JMenuBar mb = new JMenuBar();

        JMenu menu = new JMenu("File");
        JMenu aboutApp = new JMenu("About App");

        JMenuItem save = new JMenuItem("Save");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem newFile = new JMenuItem("New File");
        JMenuItem helper = new JMenuItem("Help");

        menu.add(save);
        menu.add(open);
        menu.add(newFile);

        aboutApp.add(helper);

        mb.add(menu);
        mb.add(aboutApp);

        fr.getContentPane().add(BorderLayout.NORTH, mb);
        //////////////////////////////Scripts
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.showOpenDialog(fr);
                file = chooser.getSelectedFile();
                try (FileReader reader = new FileReader(file)) {
                    byte[] all;
                    all = Files.readAllBytes(file.toPath());
                    String str = new String(all);
                    String datastr = str.split("\n")[0];
                    String data[] = datastr.split("\t");
                    System.out.println(datastr);
                    txt.setFont(new Font(data[0], Integer.valueOf(data[1]), Integer.valueOf(data[2])));
                    txt.setForeground(new Color(Integer.valueOf(data[3]), Integer.valueOf(data[4]), Integer.valueOf(data[5])));
                    txt.setText(str.substring(datastr.length()+1));
                }
                catch (Exception e2) {

                }
            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg) {
                String saveText = txt.getFont().getFamily() + "\t" // Имя шрифта
                        + txt.getFont().getStyle() + "\t" // Стиль шрифта
                        + txt.getFont().getSize() + "\t" // Размер шрифта
                        + red + "\t" // Red
                        + green + "\t" // Green
                        + blue + "\n" // Blue
                        + txt.getText(); // Текст
                try(FileWriter writer = new FileWriter(file)) {
                    writer.write(saveText);
                    writer.flush();
                }
                catch (Exception e) {

                }

            }
        });

        newFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    file = chooser.getSelectedFile();
                    try(FileWriter writer = new FileWriter(file)) {
                        writer.write("");
                        writer.flush();
                    }
                    catch (Exception e1) {

                    }
                }
            }
        });

        color.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOpen == false) {
                    Frame2 form2 = new Frame2("Цвет");
                    form2.pack();
                    form2.setVisible(true);
                    isOpen = true;
                }
            }
        });

        shrift.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String style;
                style = shrift.getSelectedItem().toString();
                switch (style){
                    case "Обычный":
                        outline = PLAIN;
                        break;
                    case "Курсив":
                        outline = Font.ITALIC;
                        break;
                    case "Жирный":
                        outline = Font.BOLD;
                        break;
                }
            }
        });

        helper.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOpenMessage == false) {
                    Instruction instruction = new Instruction();
                    instruction.pack();
                    instruction.setVisible(true);
                    isOpenMessage = true;
                }
            }
        });

        accept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txt.setForeground(new Color(red, green, blue));
                txt.setFont(new Font(cmbx.getSelectedItem().toString(), outline, Integer.parseInt(size.getText())));
            }
        });
        //////////////////////////////
        // Настройки формы
        fr.setVisible(true);
    }
}
