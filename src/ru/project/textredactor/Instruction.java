package ru.project.textredactor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Instruction extends JFrame {
    public String helpMessage = """
            Небольшой инструктаж
            Для работы с текстовым редактором нужно:
            1 - Выбрать все необходимые параметры текста в нижней панели
            2 - Нажать кнопку \"Применить\", 
            и тогда все выбранные параметры отобразятся на тексте
            Сохранение файла:
            1 - Для создания нового файла нужно нажать 
            \"New File\" и выбрать папку сохранения
            2 - Важно! При любых изменениях текста обязательно нажимайте \"Save\"
            (автосохранения нет :( )""";
    Instruction(){
        JFrame message = new JFrame();
        message.setSize(500, 400);
        message.setTitle("Инструкция");

        JButton close = new JButton("Закрыть");
        close.setBounds(200, 300, 100, 50);

        JTextArea text = new JTextArea(helpMessage);
        text.setBounds(1, 1, 500, 300);

        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame.isOpenMessage = false;
                message.setVisible(false);
            }
        });
        message.add(text);
        message.add(close);

        message.setLayout(null);
        message.setVisible(true);
    }
}
