package main;

import java.util.ArrayList;

public class Player {

    private int numArmyLeft;
    private ArrayList<String> territoryOwned;
    private boolean win;

    public Player(int numArmyLeft) {
        this.numArmyLeft = numArmyLeft;
        this.territoryOwned = new ArrayList<>();
    }

    public void claim(String territory) {
        territoryOwned.add(territory);
    }

    public boolean owns(String territory) {
        return territoryOwned.contains(territory);
    }

    private void deployment(String territory){

    }

    public int getNumArmyLeft() {
        return numArmyLeft;
    }

    public void setNumArmyLeft(int numArmyLeft) {
        this.numArmyLeft = numArmyLeft;
    }
}