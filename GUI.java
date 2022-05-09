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

public class GUI extends DiveFormulas{
    GUI() {
        JFrame frame = new JFrame("Dive Formula Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
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
        JTextField text1 = new JTextField("0",4);
        text1.setEnabled(false);
        panel.add(perOfOx);
        panel.add(text1);

        JLabel pressOfOx = new JLabel("Enter the partial pressure of Oxygen (between 1.1 and 1.6 inclusive ): ");
        JTextField text2 = new JTextField("0",4);
        text2.setEnabled(false);
        panel.add(pressOfOx);
        panel.add(text2);

        JLabel depth = new JLabel("Enter the depth of the dive (in metres): ");
        JTextField text3 = new JTextField("0",4);
        text3.setEnabled(false);
        panel.add(depth);
        panel.add(text3);

        JLabel per_start_end = new JLabel("Enter a start and end percentage of Oxygen: ");
        panel.add(per_start_end);

        JLabel per_startL = new JLabel("Start: ");
        panel.add(per_startL);
        JTextField per_startText = new JTextField("0",4);
        per_startText.setEnabled(false);
        panel.add(per_startText);

        JLabel per_endL = new JLabel("End: ");
        panel.add(per_endL);
        JTextField per_endText = new JTextField("0",4);
        per_endText.setEnabled(false);
        panel.add(per_endText);

        JLabel dep_start_end = new JLabel("Enter a start and end depth (in metres): ");
        panel.add(dep_start_end);

        JLabel dep_startL = new JLabel("Start: ");
        panel.add(dep_startL);
        JTextField dep_startText = new JTextField("0",4);
        dep_startText.setEnabled(false);
        panel.add(dep_startText);

        JLabel dep_endL = new JLabel("End: ");
        panel.add(dep_endL);
        JTextField dep_endText = new JTextField("0",4);
        dep_endText.setEnabled(false);
        panel.add(dep_endText);

        JButton btn = new JButton("Calculate");
        btn.setPreferredSize(new Dimension(475, 20));
        panel.add(btn);

        JLabel outL = new JLabel("Results will be shown here.", SwingConstants.CENTER);
        outL.setPreferredSize(new Dimension(475, 20));
        panel.add(outL);

        JTextArea output = new JTextArea(3, 4);
        output.setFont(new Font("Monospaced", Font.PLAIN, 15));
        output.setLineWrap(true);
        output.setWrapStyleWord(true);
        output.setPreferredSize(new Dimension(475, 20));
        panel.add(output);



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

                    output.setText("Please choose a correct operation.");
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
                    try{
                        double oxPercentage= Double.parseDouble(text1.getText());
                        double parPressure = Double.parseDouble(text2.getText());
                        if (oxPercentage >= 0 && oxPercentage <= 100){
                            if (parPressure >= 1.1 && parPressure <= 1.6){
                                double res = calculateMOD(oxPercentage, parPressure);
                                output.setText("Maximum operating depth (MOD) for a dive with " + oxPercentage + "% O2 and a partial pressure of " + parPressure + " is " + (int)res + " mertres.");
                            }
                            else{
                                output.setText("Invalid partial pressure as input!");
                                text2.setText("0");
                            }
                        }
                        else{
                            output.setText("Invalid percentage of Oxygen as input!");
                            text1.setText("0");
                        }
                    }
                    catch (NumberFormatException n){
                        output.setText("Invalid input!");
                        text1.setText("0");
                        text2.setText("0");
                    }
                }
                else if (cb.getSelectedItem().toString() == "SMOD"){
                    try{
                        double oxPercentage= Double.parseDouble(text1.getText());
                        if (oxPercentage >= 0 && oxPercentage <= 100){
                            double res = calculateSMOD(oxPercentage);
                            output.setText("Maximum operating depth (SMOD) for a dive with " + oxPercentage + "% O2 and a partial pressure of 1.4 is " + (int)res + " mertres.");
                        }
                        else{
                            output.setText("Invalid percentage of Oxygen as input!");
                            text1.setText("0");
                        }
                    }
                    catch (NumberFormatException n){
                        output.setText("Invalid input!");
                        text1.setText("0");
                    }
                }
                else if (cb.getSelectedItem().toString() == "BM"){
                    try{
                        double parPressure= Double.parseDouble(text2.getText());
                        double depth= Double.parseDouble(text3.getText());
                        if (parPressure >= 1.1 && parPressure <= 1.6){
                            if (depth >= 0){
                                double res = calculateBM(parPressure, depth);
                                output.setText("Best mix for a dive to " + depth + " metres with a partial pressure of " + parPressure + " is " + (int)res + "% O2.");
                            }
                            else{
                                output.setText("Invalid depth as input!");
                                text3.setText("0");
                            }
                        }
                        else{
                            output.setText("Invalid partial pressure of Oxygen as input!");
                            text2.setText("0");
                        }
                    }
                    catch (NumberFormatException n){
                        output.setText("Invalid input!");
                        text2.setText("0");
                        text3.setText("0");
                    }
                }
                else if (cb.getSelectedItem().toString() == "PP"){
                    try{
                        double oxPercentage= Double.parseDouble(text1.getText());
                        double depth= Double.parseDouble(text3.getText());
                        if (oxPercentage >= 0 && oxPercentage <= 100){
                            if (depth >= 0){
                                double res = calculatePP(oxPercentage, depth);
                                output.setText("Best mix for a dive to " + depth + " metres with a percentage of Oxygen of " + oxPercentage + "% is " + String.format("%.2f",res) + " ata.");
                            }
                            else{
                                output.setText("Invalid depth as input!");
                                text3.setText("0");
                            }
                        }
                        else{
                            output.setText("Invalid percentage of Oxygen as input!");
                            text1.setText("0");
                        }
                    }
                    catch (NumberFormatException n){
                        output.setText("Invalid input!");
                        text1.setText("0");
                        text3.setText("0");
                    }
                }
                else if (cb.getSelectedItem().toString() == "EAD"){
                    try{
                        double oxPercentage= Double.parseDouble(text1.getText());
                        double depth= Double.parseDouble(text3.getText());
                        if (oxPercentage >= 0 && oxPercentage <= 100){
                            if (depth >= 0){
                                double res = calculateEAD(oxPercentage, depth);
                                output.setText("Equivalent Air Depth for a dive with " + oxPercentage + "% O2 to a depth of " + depth + " metres is " + String.format("%.2f",res) + " metres.");
                            }
                            else{
                                output.setText("Invalid depth as input!");
                                text3.setText("0");
                            }
                        }
                        else{
                            output.setText("Invalid percentage of Oxygen as input!");
                            text1.setText("0");
                        }
                    }
                    catch (NumberFormatException n){
                        output.setText("Invalid input!");
                        text1.setText("0");
                        text3.setText("0");
                    }
                }
                else if (cb.getSelectedItem().toString() == "PPT"){
                    try{
                        int start_oxPer= Integer.parseInt(per_startText.getText());
                        int end_oxPer= Integer.parseInt(per_endText.getText());
                        int start_depth= Integer.parseInt(dep_startText.getText());
                        int end_depth= Integer.parseInt(dep_endText.getText());
                        if (start_oxPer >= 0 && end_oxPer <= 100 && start_oxPer <= end_oxPer){
                            if (start_depth >= 0 && start_depth <= end_depth){
                                String[][] arr = makePPT(start_oxPer, end_oxPer, start_depth, end_depth);
                                table(arr, start_oxPer, end_oxPer, start_depth, end_depth, "PPT");
                            }
                            else{
                                output.setText("Invalid depth as input!");
                                dep_startText.setText("0");
                                dep_endText.setText("0");
                            }
                        }
                        else{
                            output.setText("Invalid percentage of Oxygen as input!");
                            per_startText.setText("0");
                            per_endText.setText("0");
                        }
                    }
                    catch (NumberFormatException n){
                        output.setText("Invalid input!");
                        per_startText.setText("0");
                        per_endText.setText("0");
                        dep_startText.setText("0");
                        dep_endText.setText("0");
                    }
                }
                else if (cb.getSelectedItem().toString() == "EADT"){
                    try{
                        int start_oxPer= Integer.parseInt(per_startText.getText());
                        int end_oxPer= Integer.parseInt(per_endText.getText());
                        int start_depth= Integer.parseInt(dep_startText.getText());
                        int end_depth= Integer.parseInt(dep_endText.getText());
                        if (start_oxPer >= 0 && end_oxPer <= 100 && start_oxPer <= end_oxPer){
                            if (start_depth >= 0 && start_depth <= end_depth){
                                String[][] arr = makeEADT(start_oxPer, end_oxPer, start_depth, end_depth);
                                table(arr, start_oxPer, end_oxPer, start_depth, end_depth, "EADT");
                            }
                            else{
                                output.setText("Invalid depth as input!");
                                dep_startText.setText("0");
                                dep_endText.setText("0");
                            }
                        }
                        else{
                            output.setText("Invalid percentage of Oxygen as input!");
                            per_startText.setText("0");
                            per_endText.setText("0");
                        }
                    }
                    catch (NumberFormatException n){
                        output.setText("Invalid input!");
                        per_startText.setText("0");
                        per_endText.setText("0");
                        dep_startText.setText("0");
                        dep_endText.setText("0");
                    }
                }
                else{
                    output.setText("Please choose a correct operation.");
                }
            }
        });
    }

    public void table(String[][] arr, int start_oxPer, int end_oxPer, int start_depth, int end_depth, String tableName){
        int n = (int)(((end_depth-start_depth)/3)+2);
        String[] columnNames = new String[n];
        columnNames[0] = "Oxygen(%)";
        int idx = 1;
        for(int i = start_depth; idx < columnNames.length; i = i+3){
            columnNames[idx++] = "Depth- " + i;
        }

        JTable table = new JTable(arr, columnNames);
        table.getTableHeader().setFont(new Font("Serif", Font.BOLD, 15));
        table.setFont(new Font("Serif", Font.PLAIN, 15));
        JFrame tableWin = new JFrame(tableName +" for " + start_oxPer + " to " + end_oxPer + " percent Oxygen and depths of " + start_depth + " to " + end_depth + " metres");
        tableWin.setSize(500, 200);
        JScrollPane sp = new JScrollPane(table);
        sp.setPreferredSize(new Dimension(475, 200));
        tableWin.add(sp);
        tableWin.setVisible(true);
    }
    public static void main(String args[]) {
        new GUI();
    }
}

