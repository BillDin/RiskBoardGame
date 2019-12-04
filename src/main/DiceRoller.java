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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class DiceRoller {

    public static int roll(){
        Random random = new Random();
        int result = 0;
        for (int i = 0; i < 10; i++) {
            result = random.nextInt(6);
            result++;
            // System.out.println(result);
        }
        System.out.println("Roll result was: " + result);
        return result;
    }
    public static ArrayList<Integer> attackRoll(Territory atkTerritory){
        System.out.println("Attacker Rolling.");

        ArrayList<Integer> rolls = new ArrayList<>();

        if (atkTerritory.getArmies()>= 4){
            for (int i = 0; i < 3; i++){
                rolls.add(roll());
            }
        }
        else if (atkTerritory.getArmies() == 3){
            for (int i = 0; i < 2; i++){
                rolls.add(roll());
            }
        }
        else if (atkTerritory.getArmies() == 2){
            rolls.add(roll());
        }
        else{
            System.out.println("Not Enough Armies to Attack.");
            return null;
        }
        Collections.sort(rolls,Collections.reverseOrder());
        return rolls;
    }
    public static ArrayList<Integer> defenseRoll( Territory defTerritory){
        System.out.println("Defender Rolling.");
        ArrayList<Integer> rolls = new ArrayList<>();

        for (int i = 0; i < Math.min(2, defTerritory.getArmies()); i++){
            rolls.add(roll());
        }
        Collections.sort(rolls,Collections.reverseOrder());
        return rolls;
    }

    public static void attack(Territory atkTerritory, Territory defTerritory){
        ArrayList<Integer> atkRolls = attackRoll(atkTerritory);
        ArrayList<Integer> defRolls = defenseRoll(defTerritory);
        int numComparison = Math.min(atkRolls.size(), defRolls.size());
        for (int i = 0; i < numComparison; i++){
            if (atkRolls.get(i) > defRolls.get(i)){
                defTerritory.decreaseArmies(1);
                System.out.println("Attacker Wins the Attack.");
            }
            else{
                atkTerritory.decreaseArmies(1);
                System.out.println("Defender Wins the Attack.");
            }
        }
    }
}
