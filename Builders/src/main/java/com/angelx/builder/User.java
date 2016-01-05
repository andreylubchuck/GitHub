package com.angelx.builder;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

public class User extends JFrame {
    JButton menu, order, back;
    TextArea jt;
    JTextArea build;
    JTextField t1;
    JLabel l1;
    HandlerMenu handlermenu = new HandlerMenu();
    HandlerOrder handlerorder = new HandlerOrder();
    HandlerBack handlerback = new HandlerBack();

    public User(String s) {
        super(s);
        setLayout(null);
        menu = new JButton("Menu");
        order = new JButton("Order");
        back = new JButton("Back");
        jt = new TextArea(6, 18);
        t1 = new JTextField(5);
        l1 = new JLabel("Enter cocktails number: ");
        build = new JTextArea();
        add(menu);
        add(order);
        add(back);
        add(jt);
        add(l1);
        add(t1);
        add(build);
        menu.addActionListener(handlermenu);
        order.addActionListener(handlerorder);
        back.addActionListener(handlerback);
    }

    public class HandlerMenu implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Connection connection = null;
            ArrayList<String> arrayString = new ArrayList<String>();
            String query = "SELECT id, name, price FROM menu";

            try {
                connection = DriverManager.getConnection(ConnectToDatabase.URL, ConnectToDatabase.USERNAME, ConnectToDatabase.PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                Driver driver = new FabricMySQLDriver();
                DriverManager.registerDriver(driver);
                String nc = t1.getText();
                String nameb = "";
                while (resultSet.next()) {
                    String id = resultSet.getString("id");
                    nameb = resultSet.getString("name");
                    Double price = resultSet.getDouble("price");
                    arrayString.add(resultSet.getString("name"));
                    System.out.print(t1.getText());
                    if (id.equals(nc)) {
                        Coctails coctails = new CoctailsBuilder()
                                .buildName(nameb)
                                .buildIngridiens(Ingridients.Martiny)
                                .buildPrice(price)
                                .build();

                        String builder = coctails.toString();
                        build.append(builder);
                    }
                }

                String a = nameb;

                Iterator iterator = arrayString.iterator();

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

    public class HandlerOrder implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Connection connection = null;
            ArrayList<String> arrayString = new ArrayList<String>();
            String query = "SELECT id, name, price FROM menu";

            try {
                connection = DriverManager.getConnection(ConnectToDatabase.URL, ConnectToDatabase.USERNAME, ConnectToDatabase.PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                Driver driver = new FabricMySQLDriver();
                DriverManager.registerDriver(driver);
                String nc = t1.getText();

                while (resultSet.next()) {
                    String id = resultSet.getString("id");
                    String nameb = resultSet.getString("name");
                    Double price = resultSet.getDouble("price");
                    arrayString.add(resultSet.getString("name"));
                    System.out.print(t1.getText());
                    if (id.equals(nc)) {
                        Coctails coctails = new CoctailsBuilder()
                                .buildName(nameb)
                                .buildIngridiens(Ingridients.Martiny)
                                .buildPrice(price)
                                .build();

                        String builder = coctails.toString();
                        build.append(builder);
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
                Authorization auth1 = new Authorization("Authorization");
                auth1.setVisible(true);
                auth1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                auth1.setSize(350, 225);
                auth1.setResizable(false);
                auth1.setLocationRelativeTo(null);

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
}

