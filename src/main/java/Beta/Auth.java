package Beta;

import com.angelx.builder.ConnectToDatabase;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Auth {
  /*  public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                final JFrame frame = new JFrame();
                Dimension size = new Dimension(200, 100);
                frame.setMinimumSize(size);
                frame.setPreferredSize(size);
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                Container contentPane = frame.getContentPane();
                contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

                final JTextField login1 = new JTextField(10);
                contentPane.add(login1);
                final JTextField password = new JTextField(10);
                contentPane.add(password);

                Button ok = new Button("Ok");
                contentPane.add(ok);
                final String k1;
                ConnectToDatabase worker = new ConnectToDatabase();
                String query = "SELECT login, password FROM users";
                ConnectToDatabase main = new ConnectToDatabase();
                //try {
                    /*Auth auth = new Auth();
                    main.connection = DriverManager.getConnection(ConnectToDatabase.URL, ConnectToDatabase.USERNAME, ConnectToDatabase.PASSWORD);
                    Statement statement = main.connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query);
                    Driver driver = new FabricMySQLDriver();
                    DriverManager.registerDriver(driver);
                    while (resultSet.next()) {
                        //k1 = resultSet.getString("login");
                    }

                    ok.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Auth auth = new Auth();

                            /*if (k1.equals(login1.getText()) && "password".equals(password.getText())) {

                            } else {
                                System.out.println("invalid credentials");
                                System.exit(0);
                            }*/


/*
                        public void showMainForm() {
                            frame.dispose();
                            System.out.println("showing main form");
                            JFrame mainFrame = new JFrame();

                            Dimension size = new Dimension(400, 200);
                            mainFrame.setMinimumSize(size);
                            mainFrame.setPreferredSize(size);
                            mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                            mainFrame.add(new Label("Main Frame"));
                            mainFrame.pack();
                            mainFrame.setVisible(true);
                        }
                    });
                    frame.pack();
                    frame.setVisible(true);

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}*/
}
