package com.angelx.builder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Warehouseman extends JFrame {
    JButton menu, products, back;
    HandlerMenu handlermenu = new HandlerMenu();
    HandlerProducts handlerproducts = new HandlerProducts();
    HandlerBack handlerback = new HandlerBack();

    public Warehouseman(String s) {
        super(s);
        setLayout(new FlowLayout());
        menu = new JButton("Menu");
        products = new JButton("Products");
        back = new JButton("Back");
        add(menu);
        add(products);
        add(back);
        products.addActionListener(handlerproducts);
        menu.addActionListener(handlermenu);
        back.addActionListener(handlerback);
        //menu.addActionListener(menus);
    }

    public class HandlerMenu implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == menu) {
                setVisible(false);
                Menu menu = new Menu("Menu");
                menu.setVisible(true);
                menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                menu.setSize(300, 175);
                menu.setResizable(false);
                menu.setLocationRelativeTo(null);
            }
        }
    }

    public class HandlerBack implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == back) {
                setVisible(false);
                Authorization authorization = new Authorization("Authorization");
                authorization.setVisible(true);
                authorization.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                authorization.setSize(300, 175);
                authorization.setResizable(false);
                authorization.setLocationRelativeTo(null);
            }
        }
    }

    public class HandlerProducts implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == products) {
                setVisible(false);
                ProductsForm form = new ProductsForm("Products");
                form.setVisible(true);
                form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                form.setSize(375, 350);
                form.setLocationRelativeTo(null);
            }
        }
    }
}

