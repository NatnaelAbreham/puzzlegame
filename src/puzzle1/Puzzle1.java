 
package puzzle1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import java.awt.Dimension;

 
public class Puzzle1 extends JFrame{
   
    JButton[] button = new JButton[9];
    JPanel p1, p2;
    int second = 60, minute = 9,doempty;
    Timer timer;
    int[] choose = new int[10];//storing generated random number
    static JFrame frame;
    Puzzle1() { 
        
        super("Puzzle Game");
        p1 = new JPanel(new GridLayout(3, 3,5,5));
        
        for (int i = 0; i < 9; i++) {
            button[i] = new JButton("");
            button[i].setBackground(new Color(0,153,152));
            button[i].setFont(new Font("Serif",3,100));
        }

        get7RandomNumber();
        
        //generating random empty button
        doempty = (int)(Math.random()*9);
         
        //assigning random number to the button
        for (int i = 0; i < 8; i++) {
            if(i == doempty)
                button[i].setText("");   
            else
                button[i].setText(""+choose[i]);   
        }
         if(doempty <8)
           button[8].setText(""+choose[doempty]); 
         
        for (int i = 0; i < 9; i++) {
            p1.add(button[i]);
        }

        p1.setBorder(new LineBorder(Color.LIGHT_GRAY, 15));
        
        p2 = new DateDisplay();
        p2.setFont(new Font("Serif", 2, 44));
        p2.setBackground(Color.BLACK);
        p2.setForeground(Color.LIGHT_GRAY);
        p2.setBorder(new LineBorder(Color.LIGHT_GRAY, 10));
        
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
        
        ButtonListener listener = new ButtonListener();

        for (int i = 0; i < 9; i++) {
            button[i].addActionListener(listener);
        }

    }
    public static void main(String[] args) {
        frame = new Puzzle1();

        frame.setSize(600, 680);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public class DateDisplay extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            String ss = "";
            if (second < 10) {
                ss = "0";
            }

            FontMetrics fontmetrics = g.getFontMetrics();

            int stringwidth = fontmetrics.stringWidth(String.valueOf(second));
            int stringascent = fontmetrics.getAscent();

            int xcoordinate = getWidth() / 2 - stringwidth;
            int ycoordinate = getHeight() / 2 + stringascent / 2;

            g.drawString(String.valueOf("0" + minute + ":" + ss + second), xcoordinate, ycoordinate);
        }
        
        @Override
        public Dimension getPreferredSize(){
            return new Dimension(100,100);
        }
        
        DateDisplay() {
            timer = new Timer(1000, new TimerListener());
            second = 60;
            minute = 9;
            timer.start();
        }

        public class TimerListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                second--;
                if (second >= 0) {
                    repaint();
                } else {
                    minute--;
                    second = 60;
                    if (minute < 0) {
                        timer.stop();
                         timer.stop();
                        JOptionPane.showMessageDialog(null, "Times up!!");
                        int yes = JOptionPane.showConfirmDialog(null, "do you went to Continue");

                        switch (yes) {
                            case JOptionPane.YES_OPTION:  
                                resetGame();
                                break;
                            case JOptionPane.NO_OPTION: 
                                timer.stop();
                                System.exit(0);
                                break;
                            case JOptionPane.CANCEL_OPTION: 
                                timer.stop();
                                break;
                            default:
                                break;
                        }
                    }
                     
                }
            }
        }
    }
    private void get7RandomNumber() {

        for (int i = 0; i < 4; i++) {
            choose[i] = (int) (Math.random() * 8);
        }

        for (int i = 0; i < 10; i++) {
            switch (i) {
                case 0:
                    choose[i] = (int) (Math.random() * 8);
                    break;
                case 1:
                    if (choose[0] == choose[1]) {
                        while (true) {
                            choose[i] = (int) (Math.random() * 8);
                            if (choose[0] != choose[1]) {
                                break;
                            }
                        }
                    }
                    break;
                case 2:
                    if (choose[0] == choose[2] || choose[1] == choose[2]) {
                        while (true) {
                            choose[i] = (int) (Math.random() * 8);
                            if (choose[0] != choose[2] && choose[1] != choose[2]) {
                                break;
                            }
                        }
                    }
                    break;
                case 3:
                    if (choose[0] == choose[3] || choose[1] == choose[3] || choose[2] == choose[3]) {
                        while (true) {
                            choose[i] = (int) (Math.random() * 8);
                            if (choose[0] != choose[3] && choose[1] != choose[3] && choose[2] != choose[3]) {
                                break;
                            }
                        }
                    }
                    break;
                case 4:
                    if (choose[0] == choose[4] || choose[1] == choose[4] || choose[2] == choose[4] || choose[3] == choose[4]) {
                        while (true) {
                            choose[i] = (int) (Math.random() * 8);
                            if (choose[0] != choose[4] && choose[1] != choose[4] && choose[2] != choose[4] && choose[3] != choose[4]) {
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    if (choose[0] == choose[5] || choose[1] == choose[5] || choose[2] == choose[5] || choose[3] == choose[5] || choose[4] == choose[5]) {
                        while (true) {
                            choose[i] = (int) (Math.random() * 8);
                            if (choose[0] != choose[5] && choose[1] != choose[5] && choose[2] != choose[5] && choose[3] != choose[5] && choose[4] != choose[5]) {
                                break;
                            }
                        }
                    }
                    break;
                case 6:
                    if (choose[0] == choose[6] || choose[1] == choose[6] || choose[2] == choose[6] || choose[3] == choose[6] || choose[4] == choose[6] || choose[5] == choose[6]) {
                        while (true) {
                            choose[i] = (int) (Math.random() * 8);
                            if (choose[0] != choose[6] && choose[1] != choose[6] && choose[2] != choose[6] && choose[3] != choose[6] && choose[4] != choose[6] && choose[5] != choose[6]) {
                                break;
                            }
                        }
                    }
                    break;
                case 7:
                    if (choose[0] == choose[7] || choose[1] == choose[7] || choose[2] == choose[7] || choose[3] == choose[7] || choose[4] == choose[7] || choose[5] == choose[7] || choose[6] == choose[7]) {
                        while (true) {
                            choose[i] = (int) (Math.random() * 8);
                            if (choose[0] != choose[7] && choose[1] != choose[7] && choose[2] != choose[7] && choose[3] != choose[7] && choose[4] != choose[7] && choose[5] != choose[7] && choose[6] != choose[7]) {
                                break;
                            }
                        }
                    }
                    break;
                 
                default:
                    break;
            }

        }

    }
    private void resetGame() {
        minute = 9;
        second = 61;
        timer.start();   
         
        for (int i = 0; i < 8; i++) {
           choose[i] = 0;
            button[i].setText("");
        }
        get7RandomNumber();
        
         //generating random empty button
        doempty = (int)(Math.random()*9);
         
        //assigning random number to the button
        for (int i = 0; i < 8; i++) {
            if(i == doempty)
                button[i].setText("");   
            else
                button[i].setText(""+choose[i]);   
        }
         if(doempty <8)
           button[8].setText(""+choose[doempty]); 
      
    }
    public class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            for (int i = 0; i < 9; i++) {
                if (e.getSource() == button[i]) {
                    if (button[i].getText().equals("")) {
                        return;
                    }else {
                        for(int j=0;j<9;j++){
                                
                             if("".equals(button[j].getText()) && (2 > Math.abs(i - j)||3 == Math.abs(i - j))){
                                if(i == 6 && j ==5)
                                    continue;
                                if(i == 5 && j == 6)
                                    continue;
                                if(i == 3 && j ==2)
                                    continue;
                                if(i == 2 && j ==3)
                                    continue;
                                button[j].setText(button[i].getText());
                                button[i].setText("");
                                
                               break;
                            } 
                        }
                    }
                }
                    boolean tv = true;
                    for (int m = 0; m < 8; m++) {
                        if (button[m].getText().equals(String.valueOf(m))) {
                            tv = false;
                        } else {
                            tv = true;
                            break;
                        }
                    } 

                    if (!tv) {
                         
                        button[8].setText(""+8);
                        timer.stop();
                        JOptionPane.showMessageDialog(null, "You finished the Puzzle!\nin " + (9-minute) + " minutes and " +(60-second)+" seconds");
                        int yes = JOptionPane.showConfirmDialog(null, "do you went to Continue");

                        switch (yes) {
                            case JOptionPane.YES_OPTION:  
                                resetGame();
                                break;
                            case JOptionPane.NO_OPTION: 
                                timer.stop();
                                System.exit(0);
                                return;
                            case JOptionPane.CANCEL_OPTION:
                                timer.stop();
                               return;
                            default:
                                break;
                        }
                    }
                }
            }
        }
    
}
