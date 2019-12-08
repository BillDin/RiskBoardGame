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


package main;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;

public class Territory {
    private ArrayList<Territory> adjacent;
    private String name;
    private int numArmies;
    private String owner;
    private SimpleIntegerProperty armyProperty;
    private SimpleBooleanProperty ownedProperty;

    public Territory(String title){
        adjacent = new ArrayList<>();
        name = title;
        owner = null;
        numArmies = 0;
        armyProperty = new SimpleIntegerProperty(numArmies);
        ownedProperty = new SimpleBooleanProperty(false);
    }

    public boolean isClaimed() {
        return ownedProperty.getValue();
    }

    public void claim() {
        ownedProperty.set(true);
        increaseArmies(1);
    }

    public SimpleIntegerProperty armyPropertyProperty() {
        return armyProperty;
    }

    public void setNumArmies(int num){
        numArmies = num;
        armyProperty.set(num);
    }

    public void increaseArmies(int num) {
        numArmies += num;
        armyProperty.set(numArmies);
    }

    public void decreaseArmies(int num) {
        numArmies -= num;
        if (numArmies < 0){
            numArmies = 0;
        }
        armyProperty.set(numArmies);
    }


    public int getArmies(){
        return numArmies;
    }

    public void setOwner(String newOwner){
        owner = newOwner;
    }

    public String getOwner(){
        return owner;
    }

    public boolean addAdjacent(Territory neighbor){
        return adjacent.add(neighbor);
    }

    public ArrayList<Territory> getAdjacent(){
        return adjacent;
    }

    public String toString(){
        return name;
    }

    public String getAdjacentString(){
        String retStr = "";
        for(int i = 0; i< adjacent.size(); i++){
            retStr += adjacent.get(i) +"\n";
        }
        return retStr;
    }

    public String getName() {
        return name;
    }
}
