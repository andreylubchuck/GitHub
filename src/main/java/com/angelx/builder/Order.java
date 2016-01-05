package com.angelx.builder;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Order extends JFrame {
    JButton menu, order, back;
    TextArea jt;
    HandlerMenu handlermenu = new HandlerMenu();
    HandlerBack handlerback = new HandlerBack();
    HandlerOrder handlerorder = new HandlerOrder();

    public Order(String s) {
        super(s);
        setLayout(null);
        menu = new JButton("Menu");
        order = new JButton("Order");
        back = new JButton("Back");
        jt = new TextArea(6, 18);
        add(menu);
        add(order);
        add(back);
        add(jt);
        menu.addActionListener(handlermenu);
        back.addActionListener(handlerback);
    }

    public class HandlerOrder implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            Connection connection = null;
            ArrayList<String> arrayString = new ArrayList<String>();
            String query = "SELECT name FROM menu";

            try {
                connection = DriverManager.getConnection(ConnectToDatabase.URL, ConnectToDatabase.USERNAME, ConnectToDatabase.PASSWORD);

            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public class HandlerMenu implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            Connection connection = null;
            ArrayList<String> arrayString = new ArrayList<String>();
            String query = "SELECT name FROM menu";

            try {
                connection = DriverManager.getConnection(ConnectToDatabase.URL, ConnectToDatabase.USERNAME, ConnectToDatabase.PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                Driver driver = new FabricMySQLDriver();
                DriverManager.registerDriver(driver);

                while (resultSet.next()) {
                    arrayString.add(resultSet.getString("name"));
                }

                Iterator iterator = arrayString.iterator();

                Dimension n = getSize();
                System.out.print(n);

                while (iterator.hasNext()) {
                    for (int i = 1; i < 100; i++) {
                        jt.append(i + ". " + iterator.next().toString() + '\n');
                    }
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public class HandlerBack implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == back) {
                setVisible(false);
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
    }

    //:3 nya ~(^_^)~
    public class HandlerProducts implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == order) {
                setVisible(false);

            }
        }
    }

    public static void main(String[] args0) {

    }
}

