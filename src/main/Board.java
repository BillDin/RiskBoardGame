/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Brian King
 * Section: 11 AM
 *
 * Name: John Owen
 * Date: 11/13
 * Time: 11:45 AM
 *
 * Project: csci205_Final_Project
 * Package: main
 * Class: Board
 *
 * Description:
 *
 * *****************************************/


package main;

public class Board {

    private Territory alaska;
    private Territory alberta;
    private Territory centralAmerica;
    private Territory eastUS;
    private Territory greenland;
    private Territory northwestTerritory;
    private Territory ontario;
    private Territory quebec;
    private Territory westUS;

    public Board(){
        alaska = new Territory("Alaska");
        alberta = new Territory("Alberta");
        centralAmerica = new Territory("Central America");
        eastUS = new Territory("Eastern US");
        greenland = new Territory("Greenland");
        northwestTerritory = new Territory("Northwest Territory");
        ontario = new Territory("Ontario");
        quebec = new Territory("Quebec");
        westUS = new Territory("Western US");
    }
}
