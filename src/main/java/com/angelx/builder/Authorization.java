package com.angelx.builder;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Authorization extends JFrame {
    JButton auth, close;
    JLabel l1, l2;
    JTextField t1, t2;
    Handler1 handler = new Handler1();
    HandlerClose handlerclose = new HandlerClose();

    public Authorization(String s) {
        super(s);
        setLayout(null);
        auth = new JButton("Login");
        close = new JButton("Close");
        l1 = new JLabel("Enter your login");
        l2 = new JLabel("Enter your password");
        t1 = new JTextField(20);
        t2 = new JPasswordField(20);
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(auth);
        add(close);
        auth.addActionListener(handler);
        close.addActionListener(handlerclose);
    }

    public class Handler1 implements ActionListener {
        Connection connection = null;

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == auth) {
                String query = "SELECT login, password, roles FROM users";

                try {
                    connection = DriverManager.getConnection(ConnectToDatabase.URL, ConnectToDatabase.USERNAME, ConnectToDatabase.PASSWORD);
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query);
                    Driver driver = new FabricMySQLDriver();
                    DriverManager.registerDriver(driver);
                    String log, pass;
                    Integer roles;

                    while (resultSet.next()) {
                        log = resultSet.getString("login");
                        pass = resultSet.getString("password");
                        roles = resultSet.getInt("roles");

                        if (log.equals(t1.getText()) && pass.equals(t2.getText())) {
                            if (roles == 1) {
                                setVisible(false);
                                User user = new User("Order Table");
                                user.setVisible(true);
                                user.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                user.setSize(350, 250);
                                user.setResizable(false);
                                user.setLocationRelativeTo(null);

                                Insets insets = user.getInsets();
                                Dimension size = user.menu.getPreferredSize();
                                user.menu.setBounds(10 + insets.left, 1 + insets.top,
                                        90, 25);

                                user.order.setBounds(10 + insets.left, 41 + insets.top,
                                        90, 25);

                                user.back.setBounds(10 + insets.left, 81 + insets.top,
                                        90, 25);

                                size = user.jt.getPreferredSize();
                                user.jt.setBounds(175 + insets.left, 1 + insets.top,
                                        size.width, size.height);

                                size = user.l1.getPreferredSize();
                                user.l1.setBounds(10 + insets.left, 125 + insets.top,
                                        size.width, size.height);

                                size = user.t1.getPreferredSize();
                                user.t1.setBounds(175 + insets.left, 125 + insets.top,
                                        size.width, size.height);

                                user.build.setBounds(140 + insets.left, 155 + insets.top,
                                        175, 15);
                                break;
                            } else if (roles == 2) {
                                setVisible(false);
                                Barman barman = new Barman("Barman");
                                barman.setVisible(true);
                                barman.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                barman.setSize(350, 225);
                                barman.setResizable(false);
                                barman.setLocationRelativeTo(null);
                                break;
                            } else if (roles == 3) {
                                setVisible(false);
                                Warehouseman warehouseman = new Warehouseman("Warehouseman");
                                warehouseman.setVisible(true);
                                warehouseman.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                warehouseman.setSize(350, 225);
                                warehouseman.setResizable(false);
                                warehouseman.setLocationRelativeTo(null);
                                break;
                            }
                        }
                    }

                /*try {
                    Drivers drivers = new Drivers();
                    connection = DriverManager.getConnection(ConnectToDatabase.URL, ConnectToDatabase.USERNAME, ConnectToDatabase.PASSWORD);
                    preparedStatement = connection.prepareStatement(Main.INSERT1);
                    preparedStatement.setString(1, login);
                    preparedStatement.setString(2, password);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }*/
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    public class HandlerClose implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
