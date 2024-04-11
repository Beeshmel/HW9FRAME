package test_frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrameCalculator extends JFrame {
    JLabel text1,text2, answer;
    JTextField field1, field2;
    JButton buttonMul, buttonDel, buttonPlus, buttonMinus;

    MyFrameCalculator(){
        setTitle("Калькулятор");
        setSize(400,300);
        setLocationRelativeTo(null);//для вывода окна по центру
//        setBounds(200,300,600,400);//для вывода окна с отступом от левого верхнего угла

        text1 = getLabel("Первое число");
        field1 = new JTextField(10);
        text2 = getLabel("Второе число");
        field2 = new JTextField(10);

        buttonMul = new JButton("Умножить");
        buttonDel = new JButton("Разделить");
        buttonPlus = new JButton("Сложить");
        buttonMinus = new JButton("Вычесть");

        answer =getLabel("Здесь будет ответ");
        Listener listener = new Listener();
        buttonMul.addActionListener(listener);//добавили слушатель события

        buttonMinus.addActionListener(listener);
        buttonPlus.addActionListener(listener);
        buttonDel.addActionListener(listener);
//        listener - это объект, который ожидает наступления события - клик мышки на кнопку
        Container container = getContentPane();
        container.setLayout(new FlowLayout(FlowLayout.CENTER,50,30));
//        Для размещения элементов в контейнере нужно выбрать менеджер размещения
//        Менеджер FlowLayout располагает элементы слева направо
        container.add(text1);
        container.add(field1);
        container.add(text2);
        container.add(field2);
        container.add(buttonPlus);
        container.add(buttonMinus);
        container.add(buttonMul);
        container.add(buttonDel);
        container.add(answer);

        setVisible(true);
    }

    class Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (isNumeric(field1.getText())&&isNumeric(field2.getText())) {
                if (e.getSource() == buttonPlus) {
                    int result = Integer.parseInt(field1.getText()) + Integer.parseInt(field2.getText());
                    //JOptionPane.showMessageDialog(null,result+"");
                    answer.setText("Ответ: " + result);
                }
                if (e.getSource() == buttonMinus) {
                    int result = Integer.parseInt(field1.getText()) - Integer.parseInt(field2.getText());
                    //JOptionPane.showMessageDialog(null,result+"");
                    answer.setText("Ответ: " + result);
                }
                if (e.getSource() == buttonMul) {
                    int result = Integer.parseInt(field1.getText()) * Integer.parseInt(field2.getText());
                    //JOptionPane.showMessageDialog(null,result+"");
                    answer.setText("Ответ: " + result);
                }
                if (e.getSource() == buttonDel) {
                    if (Integer.parseInt(field2.getText()) != 0) {
                        double result = (double) Integer.parseInt(field1.getText()) / Integer.parseInt(field2.getText());
                        //JOptionPane.showMessageDialog(null, result + "");
                        answer.setText("Ответ: " + result);
                    } else {
                        //JOptionPane.showMessageDialog(null, "Деление на ноль невозможно");
                        answer.setText("Деление на ноль невозможно");
                    }
                }
//            JOptionPane.showMessageDialog(null,"Привет!");

            }
        }
    }

    static JLabel getLabel(String text){
        var label = new JLabel(text);
        label.setFont(new Font("Arial",Font.BOLD|Font.PLAIN,14));
        label.setForeground(Color.BLACK);
        label.setToolTipText("Подсказка...");
        return label;
    }

    public static boolean isNumeric(String string) {
        int intValue;
        if(string == null || string.equals("")) {
            JOptionPane.showMessageDialog(null,"Пустая строка, введите целое число");
            return false;
        }

        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"Введите целое число");
        }
        return false;
    }

    public static void main(String[] args) {
        var obj = new MyFrameCalculator();
    }
}
