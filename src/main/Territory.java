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

import java.util.ArrayList;

public class Territory {
    private ArrayList<Territory> adjacent;
    private String name;
    private int numArmies;
    private String owner;

    public Territory(String title){
        adjacent = new ArrayList<>();
        name = title;
        owner = null;
        numArmies = 0;
    }

    public void setNumArmies(int num){
        numArmies = num;
    }

    public void increaseArmies(int num) {
        numArmies += num;
    }

    public void decreaseArmies(int num) {
        numArmies -= num;
        if (numArmies < 0){
            numArmies = 0;
        }
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
}
