package com.angelx.builder;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        /*Форма авторизации пользователя*/
        Authorization auth1 = new Authorization("Authorization");
        auth1.setVisible(true);
        auth1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        auth1.setSize(350, 225);
        auth1.setResizable(false);
        auth1.setLocationRelativeTo(null);

        /*Позиционирование элементов*/
        Insets insets = auth1.getInsets();
        Dimension size = auth1.auth.getPreferredSize();
        auth1.auth.setBounds(80 + insets.left, 105 + insets.top,
                size.width, size.height);

        size = auth1.close.getPreferredSize();
        auth1.close.setBounds(200 + insets.left, 105 + insets.top,
                size.width, size.height);

        size = auth1.t1.getPreferredSize();
        auth1.t1.setBounds(55 + insets.left, 25 + insets.top,
                size.width, size.height);

        size = auth1.t2.getPreferredSize();
        auth1.t2.setBounds(55 + insets.left, 70 + insets.top,
                size.width, size.height);

        size = auth1.l1.getPreferredSize();
        auth1.l1.setBounds(55 + insets.left, 3 + insets.top,
                size.width + 50, size.height + 3);

        size = auth1.l2.getPreferredSize();
        auth1.l2.setBounds(55 + insets.left, 40 + insets.top,
                size.width + 50, size.height + 20);
    }
}


