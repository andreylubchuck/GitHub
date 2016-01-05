package Beta;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class test extends JFrame{

    JTextArea textArea;
    JButton button;
    ArrayList<String> arrayList;

    test(){
        textArea = new JTextArea();
        button = new JButton("Click me!");
        arrayList = new ArrayList<String>();

        this.setSize(250,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.add(button);
        textArea.setText("- - - - - - - - - - - JTextArea - - - - - - - - - - " + '\n');
        this.add(textArea);

        arrayList.add("Кто-то на форуме любит печеньки");
        arrayList.add("Я тоже люблю печеньки");
        arrayList.add("А вы их любите?");

        this.setVisible(true);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                Iterator iterator = arrayList.iterator();
                while (iterator.hasNext()){
                    textArea.append(iterator.next().toString()+ '\n');
                }
            }
        });
    }

    public static void main(String args[]){
        SwingUtilities.invokeLater( new Runnable(){
            public void run(){
                new test();
            }
        });
    }
}