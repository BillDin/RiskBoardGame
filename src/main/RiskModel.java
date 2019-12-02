package main;

import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * create the model(mostly based on the board)
 * @author Chengcheng Ding
 */
public class RiskModel {

    private Label territoryInfoLbl;
    private Board board;
    private ComboBox attackFromCBox;
    private ComboBox<String> attackToCBox;
    private TextField numAttackArmiesTField;
    private ComboBox<String> moveFromCBox;
    private ComboBox<String> moveToCBox;
    private TextField numMoveArmiesTField;

    public ComboBox getAttackFromCBox() {
        return attackFromCBox;
    }

    public ComboBox<String> getAttackToCBox() {
        return attackToCBox;
    }

    public TextField getNumAttackArmiesTField() {
        return numAttackArmiesTField;
    }

    public ComboBox<String> getMoveFromCBox() {
        return moveFromCBox;
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
        attackFromCBox = new ComboBox<>(FXCollections.observableArrayList(board.getTerritories().keySet()));
        attackFromCBox.setPrefWidth(5);
        attackToCBox = new ComboBox<>(FXCollections.observableArrayList(board.getTerritories().keySet()));
        attackToCBox.setPrefWidth(5);
        numAttackArmiesTField = new TextField();
        numAttackArmiesTField.setPrefColumnCount(2);
        moveFromCBox = new ComboBox<>(FXCollections.observableArrayList(board.getTerritories().keySet()));
        moveFromCBox.setPrefWidth(5);
        moveToCBox = new ComboBox<>(FXCollections.observableArrayList(board.getTerritories().keySet()));
        moveToCBox.setPrefWidth(5);
        numMoveArmiesTField = new TextField();
        numMoveArmiesTField.setPrefColumnCount(2);
    }

}
