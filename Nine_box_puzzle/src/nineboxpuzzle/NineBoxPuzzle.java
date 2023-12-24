/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nineboxpuzzle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class NineBoxPuzzle extends JPanel {

    private JFrame frame;
    private LeaderBoard statistics;
    private NineBoxPuzzle panel;

    NineBoxPuzzle(JFrame frame, LeaderBoard statistics) {
        super();
        this.frame = frame;
        this.statistics = statistics;
        panel = this;
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagLayout = new GridBagConstraints();
        gridBagLayout.fill = GridBagConstraints.VERTICAL;

        JButton startButton = new JButton("Start Game");
        startButton.setFocusable(false);
        startButton.setBackground(new java.awt.Color(120, 200, 240));

        startButton.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        startButton.setForeground(new java.awt.Color(25, 38, 64));

//        setText("devendra");
//        startButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(232, 104, 255), 2, true));
        startButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        startButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                frame.setContentPane(new GameGrid(frame, panel, statistics));
            }

        });
        gridBagLayout.weightx = 0.5;
        gridBagLayout.gridx = 0;
        gridBagLayout.gridy = 0;
//        gridBagLayout.insets = new Insets(5,5,5,5);
        add(startButton, gridBagLayout);

        JButton scoresButton = new JButton("View Scores");
        scoresButton.setBackground(new java.awt.Color(120, 200, 240));
        scoresButton.setFocusable(false);

        scoresButton.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        scoresButton.setForeground(new java.awt.Color(25, 38, 64));

//        setText("devendra");
//         scoresButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(232, 104, 255), 2, true));
        scoresButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        scoresButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                frame.setContentPane(statistics);
                statistics.showList();
                statistics.setVisible(true);
            }

        });
        gridBagLayout.gridy = 0;
        gridBagLayout.gridx = 1;
        gridBagLayout.gridwidth = 2;
        add(scoresButton, gridBagLayout);

//        JButton exitButton = new JButton(" Exit ");
        gridBagLayout.gridy = 2;
//        add(exitButton, gridBagLayout);

        setBackground(new java.awt.Color(25, 38, 64));
        scoresButton.setPreferredSize(new Dimension(260, 80));
    }

    public void setMenu() {
        NineBoxPuzzle panel = this;
        JMenuBar menubar = new JMenuBar();
//        JMenu options = new JMenu("Options");
        JLabel options1 = new JLabel("Nine Box Puzzle");
        menubar.setBackground(new java.awt.Color(0, 0, 0));
//        options.setBackground(new java.awt.Color(25, 17, 221));
        options1.setBackground(new java.awt.Color(25, 17, 221));
        menubar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(25, 38, 64), 3));
//         options.setForeground(new java.awt.Color(  255,255,255));
        options1.setForeground(new java.awt.Color(255, 255, 255));
//         options.setFont(new java.awt.Font("Tahoma", 3, 24));
        options1.setFont(new java.awt.Font("Tahoma", 4, 48));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(menubar);
        menubar.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(227, 227, 227)
                                .addComponent(options1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(278, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(options1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(23, Short.MAX_VALUE))
        );

        JMenuItem newGameButton = new JMenuItem("Start New Game");
        newGameButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                frame.setContentPane(new GameGrid(frame, panel, statistics));
            }
        }
        );
//        options.add(newGameButton);

        JMenuItem statisticsButton = new JMenuItem("Show Scores");
        statisticsButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                frame.setContentPane(statistics);
                statistics.showList();
                statistics.setVisible(true);
            }
        }
        );
//        options.add(statisticsButton);

//        menubar.add(options);
        frame.setJMenuBar(menubar);
        frame.validate();
        frame.repaint();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame = new JFrame();
        LeaderBoard statistics = new LeaderBoard(frame);
        frame.setTitle("Nine Box Puzzle!");
        NineBoxPuzzle panel = new NineBoxPuzzle(frame, statistics);
        statistics.setMainMenu(panel);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.yellow);
        frame.setVisible(true);
        panel.setMenu();
    }

}
