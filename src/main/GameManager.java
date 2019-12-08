package main;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

public class GameManager {

    private Board board;
    private GameStateEnum state;
    private HashMap<Integer, Player> mapPlayers;
    private final int NUM_PLAYERS = 4;
    private String selectedTerritory;
    private int curPlayer;
    private PrintStream logStream;

    public GameStateEnum getState() {
        return state;
    }

    public int getCurPlayer() {
        return curPlayer;
    }

    public PrintStream getLogStream() {
        return logStream;
    }

    public String getSelectedTerritory() {
        return selectedTerritory;
    }

    public void setSelectedTerritory(String selectedTerritory) {
        this.selectedTerritory = selectedTerritory;
    }

    public GameManager(Board board){
        this.curPlayer = 0;
        mapPlayers = new HashMap<>();
        for (int i = 1; i <= NUM_PLAYERS; i++) {
            mapPlayers.put(i, new Player(0));
        }
    }

    /**
     * a player claim a territory
     * @throws IlleagalTerritoryOpException if the territory is already claimed
     * @author Chengcheng Ding
     */
    public void playerClaim() throws IlleagalTerritoryOpException {
        //TODO: printstreams
        if (this.state == GameStateEnum.CLAIM){
            if (board.getTerritories().get(selectedTerritory).getTerritory().isClaimed()) {
                throw new IlleagalTerritoryOpException();
            }
            else {
                mapPlayers.get(curPlayer).claim(selectedTerritory);
                board.getTerritories().get(selectedTerritory).getTerritory().claim();
            }
        }
    }

    /**
     * the player place troops
     * @throws IlleagalTerritoryOpException if the player does own the territory
     * @author Chengcheng Ding
     */
    public void playerPlaceTroop() throws IlleagalTerritoryOpException {
        //TODO: printstreams
        if (mapPlayers.get(curPlayer).owns(selectedTerritory) && state == GameStateEnum.SETUP) {
            board.getTerritories().get(selectedTerritory).getTerritory().increaseArmies(1);
        }
        else {
            throw new IlleagalTerritoryOpException();
        }
    }

    public void startGame(){
        this.state = GameStateEnum.CLAIM;
        this.curPlayer = 1;
    }

    public void nextTurn() {
        if (this.curPlayer == 4) {
            this.curPlayer = 1;
        }
        else {
            curPlayer += 1;
        }
    }

    //TODO: When to change state

    public void playerAttack(String territory) throws IlleagalTerritoryOpException {
        if (!mapPlayers.get(curPlayer).owns(territory) || this.state != GameStateEnum.PLAYING){
            throw new IlleagalTerritoryOpException();
        }
        else {
            Territory atkTerritory = board.getTerritories().get(selectedTerritory).getTerritory();
            Territory defTerritory = board.getTerritories().get(territory).getTerritory();
            DiceRoller.attack(atkTerritory,defTerritory,logStream);
        }
    }

}
