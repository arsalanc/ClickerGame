package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import sun.audio.*;
import java.io.*;

public class window {
    static AudioStream as = null;
    private JButton button_msg;
    private JPanel main_window;
    private JTextPane points;
    private JLabel image;
    private JMenuBar menubar;
    private JPanel menupanel;
    private JMenu file;
    private JMenuItem restart;
    private JMenuItem sandwich;
    private JMenuItem coffee;
    private JMenuItem exit;
    private JMenu other;
    private JMenuItem credits;
    int pointvalue = 0;
    public window() {
        main_window.setBackground(Color.orange);
        points.setBackground(Color.orange);
        menupanel.setBackground(Color.orange);
        /*button_msg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null, "test 1");
                Color clr = new Color((int)(Math.random()*0x1000000));
                main_window.setBackground(clr);
                points.setBackground(clr);

            }
        });*/
        image.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pointvalue++;
                points.setText("points: "+ pointvalue);
                Color clr = new Color((int)(Math.random()*0x1000000));
                main_window.setBackground(clr);
                points.setBackground(clr);
                menupanel.setBackground(clr);
            }
        });
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pointvalue = 0;
                points.setText("points: "+ pointvalue);
                main_window.setBackground(Color.orange);
                points.setBackground(Color.orange);
                menupanel.setBackground(Color.orange);
                Icon coffeeicon = new ImageIcon(getClass().getClassLoader().getResource("res/coffee.png"));
                image.setIcon(coffeeicon);
                music(false);
                music(true);

            }
        });
        sandwich.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Icon sandwichicon = new ImageIcon(getClass().getClassLoader().getResource("res/sandwich.png"));
                image.setIcon(sandwichicon);

            }
        });
        coffee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Icon coffeeicon = new ImageIcon(getClass().getClassLoader().getResource("res/coffee.png"));
                image.setIcon(coffeeicon);

            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        credits.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = "Credits:\n\n" + "coffee cup: \n" +
                        "\thttps://www.clipartmax.com/middle/m2i8N4m2d3K9Z5K9_coffee-bean-graphic-clip-art-library-paper-coffee-cup-clip-art/"+"\nsandwich: \n" +
                        "\thttp://worldartsme.com/cartoon-sandwich-png-vector-clipart.html#gal_post_91373_cartoon-sandwich-png-vector-clipart-1.jpg\n" +
                        "music: \nhttps://www.bensound.com/royalty-free-music";
                JOptionPane.showMessageDialog(null, message);
            }
        });
        button_msg.setSize(new Dimension(100,20));
        button_msg.setVisible(false);
        points.setEditable(false);
        points.setSize(new Dimension(1,1));
        menubar.setVisible(true);
    }
    public static void open(){
        JFrame frame = new JFrame("window");
        frame.setContentPane(new window().main_window);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setPreferredSize(new Dimension(800,800));
        frame.setMinimumSize(new Dimension(800,800));
        frame.pack();
        frame.setVisible(true);
        music(true);
    }
    public static void music(boolean flag) {

        InputStream is = null;
        ContinuousAudioDataStream loop = null;
        try {
            is = window.class.getClassLoader().getResourceAsStream("res/memories.wav");
            if(flag == true)
                as = new AudioStream(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
            if (flag == true)
                AudioPlayer.player.start(as);
            else
                AudioPlayer.player.stop(as);
    }
}
