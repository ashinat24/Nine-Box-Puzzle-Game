/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nineboxpuzzle;

import java.util.Comparator;

public class Info implements Comparable<Info> {

    private String name;
    private int score;

    public Info(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return name + "\t" + score;
    }

    @Override
    public int compareTo(Info o) {
        return this.getScore() - o.getScore();
    }
}
