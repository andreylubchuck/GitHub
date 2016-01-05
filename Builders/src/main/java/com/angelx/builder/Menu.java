package com.angelx.builder;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Menu extends JFrame {
    JButton menu, back;
    JTextArea jt;
    HandlerMenu handlermenu = new HandlerMenu();
    HandlerBack handlerback = new HandlerBack();


    public Menu(String s) {
        super(s);
        setLayout(new FlowLayout());
        menu = new JButton("Menu");
        back = new JButton("Exit");
        jt = new JTextArea(10, 10);
        add(menu);
        add(back);
        add(jt);
        menu.addActionListener(handlermenu);
        back.addActionListener(handlerback);
        /*
        ArrayList<String> arrayString = new ArrayList<String>();
        ConnectToDatabase worker = new ConnectToDatabase();
        String query = "SELECT login, password, roles FROM users";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(ConnectToDatabase.URL, ConnectToDatabase.USERNAME, ConnectToDatabase.PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

            while (resultSet.next()) {
                arrayString.add(resultSet.getString("login"));
            }

            Iterator iterator = arrayString.iterator();

            while (iterator.hasNext()) {
                for (int i = 1; i > 0; i++) {
                    jt.append(i + ". " + iterator.next().toString() + '\n');
                }
            }
            add(jt);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }*/
    }

    public class HandlerMenu implements ActionListener {
        public void actionPerformed(ActionEvent e) {

        }
    }

    public class HandlerBack implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == back) {
                setVisible(false);
                User user = new User("Order Table");
                user.setVisible(true);
                user.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                user.setSize(300, 175);
                user.setResizable(false);
                user.setLocationRelativeTo(null);
            }
        }
    }

    public class Menus {
        public void main() {
            Connection connection = null;
            ArrayList<String> arrayString = new ArrayList<String>();
            String query = "SELECT login FROM users";
            try {
                connection = DriverManager.getConnection(ConnectToDatabase.URL, ConnectToDatabase.USERNAME, ConnectToDatabase.PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                Driver driver = new FabricMySQLDriver();
                DriverManager.registerDriver(driver);

                while (resultSet.next()) {
                    arrayString.add(resultSet.getString("login"));
                }

                Iterator iterator = arrayString.iterator();

                while (iterator.hasNext()) {
                    for (int i = 1; i > 0; i++) {
                        jt.append(i + ". " + iterator.next().toString() + '\n');
                    }
                }
                add(jt);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
