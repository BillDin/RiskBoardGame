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
        if (mapPlayers.get(curPlayer.getValue()).owns(selectedTerritory) && state == GameStateEnum.SETUP && mapPlayers.get(curPlayer.getValue()).getNumArmyLeft() > 0) {
            board.getTerritories().get(selectedTerritory).getTerritory().increaseArmies(1);
            logStream.println("Player" + curPlayer.getValue() + " placed a troop at " + selectedTerritory);

            nextTurn();
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
        if (this.curPlayer.getValue()==4) {
            this.curPlayer.set(1);
        }
        else {
            this.curPlayer.set(curPlayer.getValue() + 1);
        }
        startTurn();
        //TODO: When to finish game
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
    }


    public void playerMoveArmies(String territory, int numArmies) throws IlleagalTerritoryOpException {
        if (state == GameStateEnum.PLAYING && mapPlayers.get(curPlayer.getValue()).owns(selectedTerritory) && mapPlayers.get(curPlayer.getValue()).owns(territory) && board.getTerritories().get(selectedTerritory).getTerritory().getArmies() - 1 >= numArmies){
            board.getTerritories().get(selectedTerritory).getTerritory().decreaseArmies(numArmies);
            board.getTerritories().get(territory).getTerritory().increaseArmies(numArmies);
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
