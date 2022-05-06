package divingcalculations;
import java.awt.*;
import javax.swing.*;

public class GUI{
    GUI(){
        JFrame frame = new JFrame("Dive Formula Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 150);
        frame.setResizable(false);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        frame.add(panel);

        JLabel perOfOx = new JLabel("Enter the percentage of Oxygen: ");
        JTextField text1 = new JTextField(4);
        panel.add(perOfOx);
        panel.add(text1);

        JLabel pressOfOx = new JLabel("Enter the partial pressure of Oxygen (between 1.1 and 1.6 inclusive): ");
        JTextField text2 = new JTextField(4);
        panel.add(pressOfOx);
        panel.add(text2);

        JLabel depth = new JLabel("Enter the depth of the dive (in metres): ");
        JTextField text3 = new JTextField(4);
        panel.add(depth);
        panel.add(text3);

        frame.setVisible(true);
    }

    public static void main(String args[]) {
        new GUI();
    }
}

