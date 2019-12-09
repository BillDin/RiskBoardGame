package main;

import java.util.ArrayList;

public class Player {

    private int numArmyLeft;
    private ArrayList<String> territoryOwned;
    private boolean win;
    private String name;

    public Player(int numArmyLeft, String name) {
        this.numArmyLeft = numArmyLeft;
        this.territoryOwned = new ArrayList<>();
        this.name = name;
    }

    public void claim(String territory) {
        territoryOwned.add(territory);
        numArmyLeft -= 1;
    }

    public boolean owns(String territory) {
        return territoryOwned.contains(territory);
    }

    public int getNumArmyLeft() {
        return numArmyLeft;
    }

    public void setNumArmyLeft(int numArmyLeft) {
        this.numArmyLeft = numArmyLeft;
    }

    public String getName(){
        return name;
    };
}