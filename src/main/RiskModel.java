package main;

import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * create the model(mostly based on the board)
 * @author Chengcheng Ding
 */
public class RiskModel {

    private Label territoryInfoLbl;
    private Board board;
    private ComboBox<String> attackToCBox;
    private TextField numAttackArmiesTField;
    private ComboBox<String> moveToCBox;
    private TextField numMoveArmiesTField;
    private Label playerNumLbl;
    private Label gameStateInfoLbl;
    private TextArea logTxtArea;
    private GameManager gameManager;

    public GameManager getGameManager() {
        return gameManager;
    }

    public TextArea getLogTxtArea() {
        return logTxtArea;
    }

    public Label getPlayerNumLbl() {
        return playerNumLbl;
    }

    public Label getGameStateInfoLbl() {
        return gameStateInfoLbl;
    }

    public ComboBox<String> getAttackToCBox() {
        return attackToCBox;
    }

    public TextField getNumAttackArmiesTField() {
        return numAttackArmiesTField;
    }

    public ComboBox<String> getMoveToCBox() {
        return moveToCBox;
    }

    public TextField getNumMoveArmiesTField() {
        return numMoveArmiesTField;
    }

    public Board getBoard() {
        return board;
    }

    public Label getTerritoryInfoLbl() {
        return territoryInfoLbl;
    }

    public RiskModel() {

        territoryInfoLbl = new Label("Click on a territory to see its info!");
        territoryInfoLbl.setWrapText(true);

        this.board = new Board();
        this.gameManager = new GameManager(board);

        attackToCBox = createTerritoryBox();
        numAttackArmiesTField = new TextField();
        numAttackArmiesTField.setPrefColumnCount(2);
        moveToCBox = createTerritoryBox();
        numMoveArmiesTField = new TextField();
        numMoveArmiesTField.setPrefColumnCount(2);

        playerNumLbl = new Label("Player #");
        gameStateInfoLbl = new Label("Current Game State");
        gameStateInfoLbl.setWrapText(true);

        logTxtArea = new TextArea();
    }

    public ComboBox<String> createTerritoryBox(){
        return new ComboBox<>(FXCollections.observableArrayList(board.getTerritories().keySet()));
    }

}
