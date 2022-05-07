package divingcalculations;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.EventListener;
import java.util.Scanner;
import java.util.concurrent.Flow;
import javax.swing.*;

public class GUI{
    GUI() {
        JFrame frame = new JFrame("Dive Formula Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setResizable(false);

        JMenuBar mb = new JMenuBar();
        JButton helpbt = new JButton("Help");
        helpbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame messFrame = new JFrame("Help");
                JOptionPane.showMessageDialog(messFrame,
                        "MOD :: (Maximum Operating Depth) for a supplied percentage of Oxygen and partial pressure. \n" +
                                "SMOD :: (Standard Maximum Operating Depth) for a supplied percentage of Oxygen and a standard 1.4 partial pressure. \n" +
                                "BM :: (Best Mix) for a dive with a supplied partial pressure and depth (in metres). \n" +
                                "PP :: (Partial Pressure) for a supplied percentage of Oxygen and depth (in metres). \n" +
                                "EAD :: (Equivalent Air Depth) for a supplied percentage of Oxygen and depth (in metres). \n");
            }
        });
        mb.add(helpbt);
        frame.setJMenuBar(mb);

        JPanel cbPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        frame.add(cbPanel, BorderLayout.NORTH);
        JLabel optionL = new JLabel("Choose the operation: ");
        cbPanel.add(optionL);
        String option[] = {"None","MOD", "SMOD", "BM", "PP", "EAD", "PPT", "EADT"};
        JComboBox cb = new JComboBox(option);
        cbPanel.add(cb);


        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        frame.add(panel);

        JLabel perOfOx = new JLabel("Enter the percentage of Oxygen: ");
        JTextField text1 = new JTextField(4);
        text1.setEnabled(false);
        panel.add(perOfOx);
        panel.add(text1);

        JLabel pressOfOx = new JLabel("Enter the partial pressure of Oxygen (between 1.1 and 1.6 inclusive ): ");
        JTextField text2 = new JTextField(4);
        text2.setEnabled(false);
        panel.add(pressOfOx);
        panel.add(text2);

        JLabel depth = new JLabel("Enter the depth of the dive (in metres): ");
        JTextField text3 = new JTextField(4);
        text3.setEnabled(false);
        panel.add(depth);
        panel.add(text3);

        JLabel per_start_end = new JLabel("Enter a start and end percentage of Oxygen: ");
        panel.add(per_start_end);

        JLabel per_startL = new JLabel("Start: ");
        panel.add(per_startL);
        JTextField per_startText = new JTextField(4);
        per_startText.setEnabled(false);
        panel.add(per_startText);

        JLabel per_endL = new JLabel("End: ");
        panel.add(per_endL);
        JTextField per_endText = new JTextField(4);
        per_endText.setEnabled(false);
        panel.add(per_endText);

        JLabel dep_start_end = new JLabel("Enter a start and end depth (in metres): ");
        panel.add(dep_start_end);

        JLabel dep_startL = new JLabel("Start: ");
        panel.add(dep_startL);
        JTextField dep_startText = new JTextField(4);
        dep_startText.setEnabled(false);
        panel.add(dep_startText);

        JLabel dep_endL = new JLabel("End: ");
        panel.add(dep_endL);
        JTextField dep_endText = new JTextField(4);
        dep_endText.setEnabled(false);
        panel.add(dep_endText);

        JButton btn = new JButton("Calculate");
        btn.setPreferredSize(new Dimension(475, 20));
        panel.add(btn);


        frame.setVisible(true);

        cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (cb.getSelectedItem().toString() == "None"){
                    text1.setEnabled(false);
                    text2.setEnabled(false);
                    text3.setEnabled(false);
                    per_startText.setEnabled(false);
                    per_endText.setEnabled(false);
                    dep_startText.setEnabled(false);
                    dep_endText.setEnabled(false);

                    JFrame err_frame = new JFrame("Error!");
                    JOptionPane.showMessageDialog(err_frame, "Please choose a correct choice.");
                }
                else if (cb.getSelectedItem().toString() == "MOD"){
                    text1.setEnabled(true);
                    text2.setEnabled(true);
                    text3.setEnabled(false);
                    per_startText.setEnabled(false);
                    per_endText.setEnabled(false);
                    dep_startText.setEnabled(false);
                    dep_endText.setEnabled(false);
                }
                else if (cb.getSelectedItem().toString() == "SMOD"){
                    text1.setEnabled(true);
                    text2.setEnabled(false);
                    text3.setEnabled(false);
                    per_startText.setEnabled(false);
                    per_endText.setEnabled(false);
                    dep_startText.setEnabled(false);
                    dep_endText.setEnabled(false);
                }
                else if (cb.getSelectedItem().toString() == "BM") {
                    text1.setEnabled(false);
                    text2.setEnabled(true);
                    text3.setEnabled(true);
                    per_startText.setEnabled(false);
                    per_endText.setEnabled(false);
                    dep_startText.setEnabled(false);
                    dep_endText.setEnabled(false);
                }
                else if (cb.getSelectedItem().toString() == "PP") {
                    text1.setEnabled(true);
                    text2.setEnabled(false);
                    text3.setEnabled(true);
                    per_startText.setEnabled(false);
                    per_endText.setEnabled(false);
                    dep_startText.setEnabled(false);
                    dep_endText.setEnabled(false);
                }
                else if (cb.getSelectedItem().toString() == "EAD") {
                    text1.setEnabled(true);
                    text2.setEnabled(false);
                    text3.setEnabled(true);
                    per_startText.setEnabled(false);
                    per_endText.setEnabled(false);
                    dep_startText.setEnabled(false);
                    dep_endText.setEnabled(false);
                }
                else if (cb.getSelectedItem().toString() == "PPT") {
                    text1.setEnabled(false);
                    text2.setEnabled(false);
                    text3.setEnabled(false);
                    per_startText.setEnabled(true);
                    per_endText.setEnabled(true);
                    dep_startText.setEnabled(true);
                    dep_endText.setEnabled(true);
                }
                else{
                    text1.setEnabled(false);
                    text2.setEnabled(false);
                    text3.setEnabled(false);
                    per_startText.setEnabled(true);
                    per_endText.setEnabled(true);
                    dep_startText.setEnabled(true);
                    dep_endText.setEnabled(true);
                }
            }
        });

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cb.getSelectedItem().toString() == "MOD"){
                    var a = Integer.parseInt(text1.getText());
                    var b = Integer.parseInt(text2.getText());
//                    DiveFormulas ins = new DiveFormulas();

                    System.out.println(a + " " + b);
                }
            }
        });
    }

    public static void main(String args[]) {
        new GUI();
    }
}

