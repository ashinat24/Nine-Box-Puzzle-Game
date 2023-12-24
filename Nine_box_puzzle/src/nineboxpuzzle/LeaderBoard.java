/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nineboxpuzzle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class LeaderBoard extends JPanel {

    private ArrayList<Info> list;
    private final JFrame frame;
    private NineBoxPuzzle mainMenu;

    LeaderBoard(JFrame frame) {
        this.frame = frame;
        list = new ArrayList<>();
//        list.add(new Info("Aniket", 14));
        list.add(new Info("Aalok", 22));
        list.add(new Info("Jay", 10));
        list.add(new Info("Devendra", 38));
        setForeground(new java.awt.Color(25, 38, 64));
    }

    public void setMainMenu(NineBoxPuzzle panel) {
        mainMenu = panel;

    }

    public void addPlayerData(Info playerData) {
        list.add(playerData);
    }

    public void showList() {

        JPanel panel = this;
        panel.removeAll();
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
                        .addGroup(menubarLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(options, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(536, Short.MAX_VALUE))
        );
        menubarLayout.setVerticalGroup(
                menubarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(menubarLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(options, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(23, Short.MAX_VALUE))
        );
        JMenuItem newGameButton = new JMenuItem("Start New Game");
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                frame.setContentPane(new GameGrid(frame, mainMenu, (LeaderBoard) panel));
            }
        }
        );
//                newGameButton.setBackground(new java.awt.Color( 120, 200, 240));
        newGameButton.setForeground(new java.awt.Color(25, 38, 64));
        newGameButton.setFont(new java.awt.Font("Tahoma", 1, 18));
        options.add(newGameButton);

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
        frame.setJMenuBar(menubar);
        frame.validate();

        frame.repaint();

        Collections.sort(list, null);
        String col[] = {"Rank", "Name", "Number Of Moves"};
        DefaultTableModel model = new DefaultTableModel(col, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }

        };

        int rank = 1;
        for (Info playerData : list) {
            String row[] = new String[3];
            row[0] = "" + rank++;
            row[1] = playerData.getName();
            row[2] = "" + playerData.getScore();
            model.addRow(row);
        }

        JTable myTable = new JTable(model);
        setLayout(new BorderLayout());
        add(new JScrollPane(myTable), BorderLayout.CENTER);
        myTable.setBackground(new java.awt.Color(120, 200, 240));
        myTable.setForeground(new java.awt.Color(25, 38, 64));
        myTable.setFont(new java.awt.Font("Tahoma", 1, 24));
        myTable.setRowHeight(30);
        myTable.getTableHeader().setFont(new java.awt.Font("Tahoma",1, 24));
        setVisible(true);
    }

}
