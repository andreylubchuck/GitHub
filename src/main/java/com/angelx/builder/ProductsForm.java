package com.angelx.builder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ProductsForm extends JFrame {
    protected static final String INSERT = "INSERT INTO products(name, quantity, price) VALUES(?, ?, ?)";
    JButton insert, close;
    JLabel l1, l2, l3;
    JTextField t1, t2, t3, j1;
    TextArea jt;

    public static String name, quantity, price;
    Handler handler = new Handler();
    HandlerClose handlerclose = new HandlerClose();

    public ProductsForm(String s) {
        super(s);
        setLayout(new FlowLayout());
        insert = new JButton("Insert");
        close = new JButton("Close");
        l1 = new JLabel("Insert name  pr");
        l2 = new JLabel("Insert quantity");
        l3 = new JLabel("Insert    price");
        j1 = new JTextField(20);
        t1 = new JTextField(20);
        t2 = new JTextField(20);
        t3 = new JTextField(20);
        jt = new TextArea(10,10);
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(insert);
        add(close);
        insert.addActionListener(handler);
        close.addActionListener(handlerclose);

        ArrayList<String> arrayString = new ArrayList<String>();

        Iterator iterator = arrayString.iterator();

        while (iterator.hasNext()) {
            for (int i = 1; i > 0; i++) {
                jt.append(i + ". " + iterator.next().toString() + '\n');
            }
        }
    }

    public class Handler implements ActionListener {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == insert) {
                name = t1.getText();
                quantity = t2.getText();
                price = t3.getText();

                try {
                    Drivers drivers = new Drivers();
                    connection = DriverManager.getConnection(ConnectToDatabase.URL, ConnectToDatabase.USERNAME, ConnectToDatabase.PASSWORD);
                    preparedStatement = connection.prepareStatement(INSERT);
                    String a = ProductsForm.name;
                    int b = Integer.parseInt(ProductsForm.quantity);
                    float c = Float.parseFloat(ProductsForm.price);
                    preparedStatement.setString(1, a);
                    preparedStatement.setDouble(2, b);
                    preparedStatement.setFloat(3, c);
                    preparedStatement.execute();

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    public class HandlerClose implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == close) {
                setVisible(false);
            }
        }
    }

    public static void main(String args[]){

    }
}
