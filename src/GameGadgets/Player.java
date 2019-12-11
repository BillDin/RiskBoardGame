package GameGadgets;

import java.util.ArrayList;

public class Player {

    private int numArmyLeft;
    private ArrayList<String> territoryOwned;
    private String name;

    public ArrayList<String> getTerritoryOwned() {
        return territoryOwned;
    }

    /**
     * main constructor for player class
     * @param numArmyLeft num army left
     * @param name name of the territory
     * @author Zeming Chen
     */
    public Player(int numArmyLeft, String name) {
        this.numArmyLeft = numArmyLeft;
        this.territoryOwned = new ArrayList<>();
        this.name = name;
    }

    /**
     * a function to claim territory, adjust the number of army as well
     * @param territory territory
     * @author Zeming Chen
     */
    public void claim(String territory) {
        territoryOwned.add(territory);
        numArmyLeft -= 1;
    }

    /**
     * whether the territory is owned by anyone
     * @param territory
     * @return whether the territory is owned by anyone
     * @author Zeming Chen
     */
    public boolean owns(String territory) {
        return territoryOwned.contains(territory);
    }

    /**
     * getter method for number of army left
     * @return int
     */
    public int getNumArmyLeft() {
        return numArmyLeft;
    }

    /**
     * add army into their owned territory
     * @param numArmy
     */
    public void addNumArmyLeft(int numArmy) {
        this.numArmyLeft += numArmy;
    }

    /**
     * setter method for num army
     * @param numArmyLeft
     */
    public void setNumArmyLeft(int numArmyLeft) {
        this.numArmyLeft = numArmyLeft;
    }

    public String getName(){
        return name;
    };
}