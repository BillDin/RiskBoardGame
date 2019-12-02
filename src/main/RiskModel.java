package main;

import javafx.scene.control.Label;

public class RiskModel {

    private Label territoryInfoLbl;
    private Board board;

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

    }

}
