package main;

import javafx.scene.control.Label;

public class RiskModel {

    private Label territoryInfoLbl;

    public Label getTerritoryInfoLbl() {
        return territoryInfoLbl;
    }

    public RiskModel() {

        territoryInfoLbl = new Label("Hover over a territory to see its info!");
        territoryInfoLbl.setWrapText(true);

    }

}
