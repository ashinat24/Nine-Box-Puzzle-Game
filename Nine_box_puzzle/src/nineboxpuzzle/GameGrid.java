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

public class GameGrid extends JPanel {

    private Backend myGameEngine;
    private LeaderBoard statistics;
    private JFrame frame;
    private NineBoxPuzzle mainMenu;
    private JLabel score;

    GameGrid(JFrame frame, NineBoxPuzzle mainMenu, LeaderBoard statistics) {
        score = new JLabel("Moves Count : 0");
        score.setFont(new java.awt.Font("Tahoma", 1, 24));
        score.setForeground(new java.awt.Color(255, 255, 255));
        this.mainMenu = mainMenu;
        this.statistics = statistics;
        this.frame = frame;
        myGameEngine = new Backend(this, statistics);
        initializeComponents();
        setVisible(true);
        JPanel panel = this;
        JMenuBar menubar = new JMenuBar();

        JMenu options = new JMenu("Options");
        menubar.setBackground(new java.awt.Color(0, 0, 0));
        options.setBackground(new java.awt.Color(25, 17, 221));
        menubar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(25, 38, 64), 3));
        options.setForeground(new java.awt.Color(255, 255, 255));
        options.setFont(new java.awt.Font("Tahoma", 1, 24));

        javax.swing.GroupLayout menubarLayout = new javax.swing.GroupLayout(menubar);
        menubar.setLayout(menubarLayout);
        menubarLayout.setHorizontalGroup(
                menubarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menubarLayout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(options, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(119, 119, 119)
                                .addComponent(score, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(129, Short.MAX_VALUE))
        );
        menubarLayout.setVerticalGroup(
                menubarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(menubarLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(menubarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(score, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(options, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(23, Short.MAX_VALUE))
        );

        JMenuItem newGameButton = new JMenuItem("Start New Game");
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                frame.setContentPane(new GameGrid(frame, mainMenu, statistics));
            }
        }
        );
        newGameButton.setForeground(new java.awt.Color(25, 38, 64));
        newGameButton.setFont(new java.awt.Font("Tahoma", 1, 18));
        options.add(newGameButton);

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
        statisticsButton.setForeground(new java.awt.Color(25, 38, 64));
        statisticsButton.setFont(new java.awt.Font("Tahoma", 1, 18));
        options.add(statisticsButton);

        JMenuItem mainMenuButton = new JMenuItem("Back To Main Menu");
        mainMenuButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                frame.setContentPane(mainMenu);
                mainMenu.setMenu();
                mainMenu.setVisible(true);
            }
        }
        );
        mainMenuButton.setForeground(new java.awt.Color(25, 38, 64));
        mainMenuButton.setFont(new java.awt.Font("Tahoma", 1, 18));
        options.add(mainMenuButton);

        menubar.add(options);
        menubar.add(score);
        frame.setJMenuBar(menubar);
        frame.validate();
        frame.repaint();
    }

    private void initializeComponents() {
        setLayout(new GridLayout(3, 3));
        Block[][] boxes = myGameEngine.getBoxes();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                add(boxes[i][j]);
                boxes[i][j].addActionListener(new ActionHandler(myGameEngine, i, j));
            }
        }
        setVisible(true);
    }

    public void showWinningDialog() {
        JTextField name = new JTextField();
        Object[] input = {
            "Enter your name : ", name
        };
        int option = JOptionPane.showConfirmDialog(this, input, "You Won! Submit Score", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            myGameEngine.setPlayerData(name.getText().trim());
            JOptionPane.showMessageDialog(this, "Success!\n");
            setVisible(false);
            frame.setContentPane(statistics);
            statistics.setVisible(true);
            statistics.showList();
        }
    }

    public void setCount(int movesCount) {
        score.setText("Moves Count : " + movesCount);
    }
}
