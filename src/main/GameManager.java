package main;

import javafx.beans.property.SimpleIntegerProperty;

import java.io.PrintStream;
import java.util.HashMap;

/**
 * @author Chengcheng Ding
 */
public class GameManager {

    private Board board;
    private GameStateEnum state;
    private HashMap<Integer, Player> mapPlayers;
    private final int NUM_PLAYERS = 4;
    private final int NUM_ARMIES = 50;
    private String selectedTerritory;
    private SimpleIntegerProperty curPlayer;
    private PrintStream logStream;
    private int numTerritoryClaimed;
    private HashMap<Integer,Integer> reinforcementMap;
    private int winPlayer;

    public int getWinPlayer() {
        return winPlayer;
    }

    public GameStateEnum getState() {
        return state;
    }

    public int getCurPlayer() {
        return curPlayer.getValue();
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

    public GameManager(Board board, TextFieldPrintStream textFieldPrintStream){
        this.board = board;
        this.curPlayer = new SimpleIntegerProperty(0);
        this.logStream = textFieldPrintStream;
        mapPlayers = new HashMap<>();
        for (int i = 1; i <= NUM_PLAYERS; i++) {
            String playerName = "Player " + i;
            mapPlayers.put(i, new Player(NUM_ARMIES, playerName));
        }
        numTerritoryClaimed = 0;
        reinforcementMap = new HashMap<>();
        for (int i = 1; i < 42; i++) {
            if (i < 12){
                reinforcementMap.put(i,3);
            }
            else if (i < 15) {
                reinforcementMap.put(i,4);
            }
            else if (i < 18) {
                reinforcementMap.put(i,5);
            }
            else if (i < 21) {
                reinforcementMap.put(i,6);
            }
            else if (i < 24) {
                reinforcementMap.put(i,7);
            }
            else if (i < 27) {
                reinforcementMap.put(i,8);
            }
            else if (i < 30) {
                reinforcementMap.put(i,9);
            }
            else if (i < 33) {
                reinforcementMap.put(i,10);
            }
            else if (i < 36) {
                reinforcementMap.put(i,11);
            }
            else if (i < 39) {
                reinforcementMap.put(i,12);
            }
            else {
                reinforcementMap.put(i,13);
            }
        }
    }

    /**
     * a player claim a territory
     * @throws IlleagalTerritoryOpException if the territory is already claimed
     * @author Chengcheng Ding
     */
    public void playerClaim() throws IlleagalTerritoryOpException {
        if (this.state == GameStateEnum.CLAIM){
            if (board.getTerritories().get(selectedTerritory).getTerritory().isClaimed()) {
                throw new IlleagalTerritoryOpException();
            }
            else {
                mapPlayers.get(curPlayer.getValue()).claim(selectedTerritory);
                board.getTerritories().get(selectedTerritory).getTerritory().claim();
                numTerritoryClaimed += 1;
                logStream.println("Player" + curPlayer.getValue() + " claimed " + selectedTerritory);
                board.getTerritories().get(selectedTerritory).getTerritory().setOwner(mapPlayers.get(curPlayer.getValue()).getName());;

                nextTurn();
            }
        }
    }

    /**
     * the player place troops
     * @throws IlleagalTerritoryOpException if the player does own the territory
     * @author Chengcheng Ding
     */
    public void playerPlaceTroop() throws IlleagalTerritoryOpException {
        if (mapPlayers.get(curPlayer.getValue()).owns(selectedTerritory) && (state == GameStateEnum.SETUP || state == GameStateEnum.PLAYING)&& mapPlayers.get(curPlayer.getValue()).getNumArmyLeft() > 0) {
            board.getTerritories().get(selectedTerritory).getTerritory().increaseArmies(1);
            logStream.println("Player" + curPlayer.getValue() + " placed a troop at " + selectedTerritory);
            if (state == GameStateEnum.SETUP) {
                nextTurn();
            }
        }
        else {
            throw new IlleagalTerritoryOpException();
        }
    }

    public void startGame(){
        this.state = GameStateEnum.CLAIM;
        this.curPlayer.set(1);
    }

    public void nextTurn() {
        if (this.mapPlayers.get(curPlayer.get()).getTerritoryOwned().size() == board.getTerritoryList().size()) {
            logStream.println(String.format("Player %s has won! Congratulation!", curPlayer.get()));
            state = GameStateEnum.FINISHED;
            winPlayer = curPlayer.get();
        }
        else {
            if (this.curPlayer.getValue() == 4) {
                this.curPlayer.set(1);
            } else {
                this.curPlayer.set(curPlayer.getValue() + 1);
            }
            startTurn();
        }
    }

    public void startTurn() {
        if (numTerritoryClaimed >= board.getTerritoryList().size() && state == GameStateEnum.CLAIM) {
            state = GameStateEnum.SETUP;
        }
        if (mapPlayers.get(curPlayer.getValue()).getNumArmyLeft() <= 0) {
            if (state == GameStateEnum.SETUP) {
                state = GameStateEnum.PLAYING;
            }
        }
        if (state == GameStateEnum.PLAYING) {
            mapPlayers.get(curPlayer.get()).addNumArmyLeft(reinforcementMap.get(mapPlayers.get(curPlayer.get()).getTerritoryOwned().size()));
        }
    }


    public void playerMoveArmies(String territory, int numArmies) throws IlleagalTerritoryOpException {
        if (state == GameStateEnum.PLAYING && mapPlayers.get(curPlayer.getValue()).owns(selectedTerritory) && mapPlayers.get(curPlayer.getValue()).owns(territory) && board.getTerritories().get(selectedTerritory).getTerritory().getArmies() - 1 >= numArmies){
            board.getTerritories().get(selectedTerritory).getTerritory().decreaseArmies(numArmies);
            board.getTerritories().get(territory).getTerritory().increaseArmies(numArmies);
            //TODO: find out if a territory is reachable
        }
        else {
            throw new IlleagalTerritoryOpException();
        }
    }

    public void playerAttack(String territory, int numArmies) throws IlleagalTerritoryOpException {
        if (!mapPlayers.get(curPlayer.getValue()).owns(territory) || this.state != GameStateEnum.PLAYING){
            throw new IlleagalTerritoryOpException();
        }
        else {
            Territory atkTerritory = board.getTerritories().get(selectedTerritory).getTerritory();
            Territory defTerritory = board.getTerritories().get(territory).getTerritory();
            DiceRoller.attack(atkTerritory,defTerritory,numArmies,logStream);
        }
    }

}
