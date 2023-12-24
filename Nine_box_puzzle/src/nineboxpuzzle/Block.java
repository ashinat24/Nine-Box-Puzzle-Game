/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nineboxpuzzle;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Block extends JButton {

    private int positionX;
    private int positionY;

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    Block(int positionX, int positionY, int num) {
        super(String.valueOf(num));
        this.positionX = positionX;
        this.positionY = positionY;
        setBackground(new java.awt.Color(120, 200, 240));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
//        setBackground(Color.PINK);
        setFont(new Font("Tahoma", Font.BOLD, 48));
//        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 204), 4));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(25, 38, 64), 4));
        setFocusable(false);
    }
}
