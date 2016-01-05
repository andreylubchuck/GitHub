package Beta;

import com.angelx.builder.Barman;
import com.angelx.builder.Warehouseman;
import com.angelx.builder.ConnectToDatabase;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import javax.swing.*;

import java.awt.Container;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;

public class AuthorizationBeta extends JFrame {
    Handler1 handler = new Handler1();
    HandlerClose handlerclose = new HandlerClose();
    JButton auth = new JButton("Login");
    JButton close = new JButton("Close");
    JLabel l1 = new JLabel("Enter your login");
    JLabel l2 = new JLabel("Enter your password");
    JTextField t1 = new JTextField(20);
    JTextField t2 = new JTextField(20);
    JFrame frame = new JFrame("Authorization");

    public static void addComponentsToPane(Container jk) {
        jk.setLayout(null);
        AuthorizationBeta ar = new AuthorizationBeta();
        jk.add(ar.auth);
        jk.add(ar.close);
        jk.add(ar.l1);
        jk.add(ar.t1);
        jk.add(ar.l2);
        jk.add(ar.t2);

        Insets insets = jk.getInsets();
        Dimension size = ar.auth.getPreferredSize();
        ar.auth.setBounds(80 + insets.left, 125 + insets.top,
                size.width, size.height);

        size = ar.close.getPreferredSize();
        ar.close.setBounds(200 + insets.left, 125 + insets.top,
                size.width, size.height);

        size = ar.t1.getPreferredSize();
        ar.t1.setBounds(55 + insets.left, 45 + insets.top,
                size.width, size.height);

        size = ar.t2.getPreferredSize();
        ar.t2.setBounds(55 + insets.left, 90 + insets.top,
                size.width, size.height);

        size = ar.l1.getPreferredSize();
        ar.l1.setBounds(55 + insets.left, 15 + insets.top,
                size.width + 50, size.height + 20);

        size = ar.l2.getPreferredSize();
        ar.l2.setBounds(55 + insets.left, 60 + insets.top,
                size.width + 50, size.height + 20);

        ar.auth.addActionListener(ar.handler);
        ar.close.addActionListener(ar.handlerclose);
    }

    public static JFrame createAndShowGUI() {
        AuthorizationBeta f = new AuthorizationBeta();
        f.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(f.frame.getContentPane());

        Insets insets = f.frame.getInsets();
        f.frame.setSize(350 + insets.left + insets.right,
                225 + insets.top + insets.bottom);
        f.frame.setVisible(true);
        f.frame.setLocationRelativeTo(null);
        f.frame.setResizable(false);
        return f.frame;
    }

    public class Handler1 implements ActionListener {
        Connection connection = null;

        public void actionPerformed(ActionEvent e) {

            AuthorizationBeta r = new AuthorizationBeta();
            if (e.getSource() == auth) {
                createAndShowGUI().setVisible(false);

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

                                break;
                            } else if (roles == 2) {
                                Barman barman = new Barman("Barman");
                                barman.setVisible(true);
                                barman.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                barman.setSize(300, 200);
                                barman.setResizable(false);
                                barman.setLocationRelativeTo(null);
                                break;
                            } else if (roles == 3) {
                                Warehouseman warehouseman = new Warehouseman("Warehouseman");
                                warehouseman.setVisible(true);
                                warehouseman.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                warehouseman.setSize(300, 200);
                                warehouseman.setResizable(false);
                                warehouseman.setLocationRelativeTo(null);
                                break;
                            }
                        }

                        System.out.println("Oray)");
                    }
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

    public static void main(String[] args) {

    }

}

