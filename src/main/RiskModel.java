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
    private ComboBox AttackFromCBox;
    private ComboBox<String> AttackToCBox;
    private TextField numAttackArmiesTField;
    private ComboBox<String> MoveFromCBox;
    private ComboBox<String> MoveToCBox;
    private TextField numMoveArmiesTField;

    public ComboBox getAttackFromCBox() {
        return AttackFromCBox;
    }

    public ComboBox<String> getAttackToCBox() {
        return AttackToCBox;
    }

    public TextField getNumAttackArmiesTField() {
        return numAttackArmiesTField;
    }

    public ComboBox<String> getMoveFromCBox() {
        return MoveFromCBox;
    }

    public ComboBox<String> getMoveToCBox() {
        return MoveToCBox;
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
        AttackFromCBox = new ComboBox<>(FXCollections.observableArrayList(board.getTerritories().keySet()));
        AttackToCBox = new ComboBox<>(FXCollections.observableArrayList(board.getTerritories().keySet()));
        numAttackArmiesTField = new TextField();
        numAttackArmiesTField.setPrefColumnCount(2);
        MoveFromCBox = new ComboBox<>(FXCollections.observableArrayList(board.getTerritories().keySet()));
        MoveToCBox = new ComboBox<>(FXCollections.observableArrayList(board.getTerritories().keySet()));
        numMoveArmiesTField = new TextField();
        numMoveArmiesTField.setPrefColumnCount(2);
    }

}
