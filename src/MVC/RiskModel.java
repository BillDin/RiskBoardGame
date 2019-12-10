package MVC;

import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import GameGadgets.Board;
import GamePlay.GameManager;

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
    private TextFieldPrintStream textFieldPrintStream;

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

    /**
     * Constructor of the model, setting up everything
     * @author Chengcheng Ding
     */
    public RiskModel() {

        territoryInfoLbl = new Label("Click on a territory to see its info!");
        territoryInfoLbl.setWrapText(true);

        logTxtArea = new TextArea();
        this.textFieldPrintStream = new TextFieldPrintStream(System.out ,logTxtArea);
        this.board = new Board();
        this.gameManager = new GameManager(board, textFieldPrintStream);

        attackToCBox = createTerritoryBox();
        numAttackArmiesTField = new TextField();
        numAttackArmiesTField.setPrefColumnCount(2);
        moveToCBox = createTerritoryBox();
        numMoveArmiesTField = new TextField();
        numMoveArmiesTField.setPrefColumnCount(2);

        playerNumLbl = new Label("Player #");
        gameStateInfoLbl = new Label("Current Game State");
        gameStateInfoLbl.setWrapText(true);

    }

    /**
     * Create a combo box for all territories, useful for many situations
     * @return the combo box of all territories
     */
    public ComboBox<String> createTerritoryBox(){
        return new ComboBox<>(FXCollections.observableArrayList(board.getTerritories().keySet()));
    }

}
