/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Brian King
 * Section: 11 AM
 *
 * Name: John Owen
 * Date: 11/14
 * Time: 10:11 PM
 *
 * Project: csci205_Final_Project
 * Package: main
 * Class: Territory
 *
 * Description:
 *
 * *****************************************/


package GameGadgets;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;

/**
 * Class to represent each territory space on the board
 * @author John Owen
 */

public class Territory {
    private ArrayList<Territory> adjacent;
    private String name;
    private int numArmies;
    private String owner;
    private SimpleIntegerProperty armyProperty;
    private SimpleBooleanProperty ownedProperty;

    /**
     * Constructor for territory class
     * @param title Name of the territory
     */

    public Territory(String title){
        adjacent = new ArrayList<>();
        name = title;
        owner = null;
        numArmies = 0;
        armyProperty = new SimpleIntegerProperty(numArmies);
        ownedProperty = new SimpleBooleanProperty(false);
    }

    /**
     * Indicated whether or not the territory is currently claimed
     * @return true if the territory has an owner, false otherwise
     */
    public boolean isClaimed() {
        return ownedProperty.getValue();
    }

    /**
     * Sets the territory to be claimed and places a single army there
     */
    public void claim() {
        ownedProperty.set(true);
        increaseArmies(1);
    }

    /**
     * returns a SimpleIntegerProperty representing the number of armies on the territory
     * @return SimpleIntegerProperty representing the number of armies on the territory
     */
    public SimpleIntegerProperty armyPropertyProperty() {
        return armyProperty;
    }

    /**
     * Sets the number of armies to the value of num
     * @param num number of armies
     */
    public void setNumArmies(int num){
        numArmies = num;
        armyProperty.set(num);
    }

    /**
     * increases the number of armies by the value of num
     * @param num number of armies
     */
    public void increaseArmies(int num) {
        numArmies += num;
        armyProperty.set(numArmies);
    }

    /**
     * decreases the number of armies by the value of num, won't go below zero
     * @param num number of armies
     */
    public void decreaseArmies(int num) {
        numArmies -= num;
        if (numArmies < 0){
            numArmies = 0;
        }
        armyProperty.set(numArmies);
    }

    /**
     * returns the number of armies
     * @return number of armies
     */
    public int getArmies(){
        return numArmies;
    }

    /**
     * sets the owner to newOwner
     * @param newOwner String representing the owner of the space
     */
    public void setOwner(String newOwner){
        owner = newOwner;
    }

    /**
     * returns the name of the owner
     * @return a String representing the owner
     */
    public String getOwner(){
        return owner;
    }

    /**
     * adds a territory to the arraylist of adjacent territories
     * @param neighbor Territory to add to the list
     * @return boolean to indicate if it was added properly
     */
    public boolean addAdjacent(Territory neighbor){
        return adjacent.add(neighbor);
    }

    /**
     * returns the arraylist representing the adjacent territories
     * @return arraylist of adjacent territories
     */
    public ArrayList<Territory> getAdjacent(){
        return adjacent;
    }

    public String toString(){
        return name;
    }

    /**
     * returns a String representing the adjacent territories
     * @return String of territories
     */
    public String getAdjacentString(){
        String retStr = "";
        for(int i = 0; i< adjacent.size(); i++){
            retStr += adjacent.get(i) +"\n";
        }
        return retStr;
    }

    /**
     * returns the name of the territory
     * @return name of territory
     */
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        return this.name.equals(((Territory)obj).getName());
    }
}
