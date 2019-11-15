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

public class diceRoller {

    public int roll(){
        int result = 0;
        for (int i = 0; i > 10; i++) {
            result = Random.nextInt(6);
            result++;
            System.out.println(result);
        }
        return result;
    }
    public ArrayList<Integer> attackRoll(Territory atkTerritory){

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
        Collections.sort(rolls);
        return rolls;
    }
    public ArrayList<Integer> defenseRoll( Territory defTerritory){
        ArrayList<Integer> rolls = new ArrayList<>();

        for (int i = 0; i < Math.min(2, defTerritory.getArmies())){
            rolls.add(roll());
        }
        Collections.sort(rolls);
        return rolls;
    }

    public
}
