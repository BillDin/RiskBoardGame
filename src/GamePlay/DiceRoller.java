/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: Zachary Prince
 * Section: 11am
 * Date: 11/14/2019
 * Time: 11:15 PM
 *
 * Project: csci205FinalProject
 * Package: main
 * Class: diceRoller
 *
 * Description:
 *
 * ****************************************
 */

package GamePlay;

import exceptions.IllegalTerritoryOpException;
import GameGadgets.Territory;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class DiceRoller {

    private static int checks = 0;
    private static int numDice = 0;

    public static int roll(PrintStream logStream){
        /**
         * Generates a random number to create the result of a roll. Generates a number between 1-6, 10 times.
         * to create the effect that a die is being rolled and it changes result 10 times before coming to a stop.
         * @param logStream takes in the PrintStream to allow for the result to be sent to the log in the UI.
         */
        Random random = new Random();
        int result = 0;
        for (int i = 0; i < 10; i++) {
            result = random.nextInt(6);
            result++;
            logStream.println(result);
        }
        logStream.println("Roll result was: " + result);
        return result;
    }

    public static ArrayList<Integer> attackRoll(Territory atkTerritory, int numArmies, PrintStream logStream){
        /**
         * Function for the attack roll. It checks the territory and how many armies the player wants to attack with.
         * Places all rolls inside of an ArrayList of Integers to compare results later.
         * @param atkTerritory takes in the territory that is making an attack roll.
         * @param numArmies takes in an int in which is the number of armies that wants to attack with.
         * @param logStream takes in the PrintStream to allow for the result to be sent to the log in the UI.
         */
        checks = numArmies;
        logStream.println("Attacker Rolling.");

        ArrayList<Integer> rolls = new ArrayList<>();

        if (atkTerritory.getArmies()>= 4){
            for (int i = 0; i < 3; i++){
                rolls.add(roll(logStream));
            }
            numDice = 3;
        }
        else if (atkTerritory.getArmies() >= 3 && numArmies == 2){
            for (int i = 0; i < 2; i++){
                rolls.add(roll(logStream));
            }
            numDice = 2;
        }
        else if (atkTerritory.getArmies() >= 2 && numArmies == 1){
            rolls.add(roll(logStream));
            numDice = 1;
        }
        else{
            System.out.println("Not Enough Armies to Attack.");
            return null;
        }
        rolls.sort(Collections.reverseOrder());
        return rolls;
    }

    public static ArrayList<Integer> defenseRoll( Territory defTerritory, PrintStream logStream){
        /**
         * Function for the defense roll. It checks the territory and how many armies the player can defend with.
         * Places all rolls inside of an ArrayList of Integers to compare results later.
         * @param defTerritory takes in the territory that is making a defense roll.
         * @param logStream takes in the PrintStream to allow for the result to be sent to the log in the UI.
         */
        logStream.println("Defender Rolling.");
        ArrayList<Integer> rolls = new ArrayList<>();

        for (int i = 0; i < Math.min(2, defTerritory.getArmies()); i++){
            rolls.add(roll(logStream));
        }
        rolls.sort(Collections.reverseOrder());
        return rolls;
    }

    public static void attack(Territory atkTerritory, Territory defTerritory, int numArmies, PrintStream logStream) throws IllegalTerritoryOpException {
        /**
         * Function that makes the attack. It takes the rolls of both an attack and defense and compare them.
         * It uses the highest rolls on each side and compares them and decides the results.
         * @param atkTerritory takes in the territory that is making an attack roll.
         * @param defTerritory takes in the territory that is making a defense roll.
         * @param numArmies takes in the number of armies that are attacking.
         * @param logStream takes in the PrintStream to allow for the result to be sent to the log in the UI.
         */
        if (defTerritory.getArmies() == 0){
            throw new IllegalTerritoryOpException();
        }
        ArrayList<Integer> atkRolls = attackRoll(atkTerritory, numArmies, logStream);
        ArrayList<Integer> defRolls = defenseRoll(defTerritory, logStream);
        int numComparison = Math.min(atkRolls.size(), defRolls.size());
        for (int i = 0; i < numComparison; i++){
            if (atkRolls.get(i) > defRolls.get(i)){
                defTerritory.decreaseArmies(1);
                logStream.println("Attacker Wins the Attack.");
            }
            else{
                atkTerritory.decreaseArmies(1);
                logStream.println("Defender Wins the Attack.");
            }
        }
        if (defTerritory.getArmies() == 0){
            setControl(atkTerritory, defTerritory, numArmies);
        }
    }
    public static void setControl (Territory atkTerritory, Territory defTerritory, int numArmies){
        /**
         * Function that sets the control of a territory after an attack. Checks to see if the number of armies
         * being moved is a valid number.
         * It uses the highest rolls on each side and compares them and decides the results.
         * @param atkTerritory takes in the territory that is gaining control of defTerritory.
         * @param defTerritory takes in the territory that is losing control to atkTerritory.
         * @param numArmies takes in the number of armies that being moved to defTerritory.
         */
        if (numArmies > checks){
            System.out.println("You do not have enough armies.");
            setControl(atkTerritory, defTerritory, numArmies);
        }
        else if (numArmies < numDice){
            System.out.println("You need to garleast arison at rmies equal to the number of dice you rolled. You rolled: " + numDice + " dice.");
            setControl(atkTerritory, defTerritory, numArmies);
        }
        else {
            defTerritory.setOwner("Placeholder");
            defTerritory.setNumArmies(numArmies);
            atkTerritory.setNumArmies(atkTerritory.getArmies()-numArmies);
            System.out.println(defTerritory.getOwner() + " now controls the territory.");
        }
    }
    /*
        Territory t1 = new Territory("Engineering");
        Territory t2 = new Territory("Arts and Sciences");
        t1.setNumArmies(5);
        t2.setNumArmies(3);
        System.out.println(t1.getArmies());
        System.out.println(t2.getArmies());

        DiceRoller.attack(t1,t2, 4);
        System.out.println(t1.getArmies());
        System.out.println(t2.getArmies());
        DiceRoller.attack(t1,t2, 3);
        System.out.println(t1.getArmies());
        System.out.println(t2.getArmies());
        DiceRoller.attack(t1,t2,1);
        System.out.println(t1.getArmies());
        System.out.println(t2.getArmies());
     */
}
