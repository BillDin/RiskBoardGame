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

package main;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class DiceRoller {

    private static int checks = 0;
    private static int numDice = 0;

    public static int roll(PrintStream logStream){
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
        logStream.println("Defender Rolling.");
        ArrayList<Integer> rolls = new ArrayList<>();

        for (int i = 0; i < Math.min(2, defTerritory.getArmies()); i++){
            rolls.add(roll(logStream));
        }
        rolls.sort(Collections.reverseOrder());
        return rolls;
    }

    public static void attack(Territory atkTerritory, Territory defTerritory, int numArmies, PrintStream logStream) throws IlleagalTerritoryOpException {
        if (defTerritory.getArmies() == 0){
            throw new IlleagalTerritoryOpException();
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
