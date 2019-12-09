package main;

import javafx.scene.control.Alert;
import javafx.scene.paint.Color;

public class RiskController {

    private RiskModel theModel;
    private RiskView theView;

    public RiskController(RiskModel Model, RiskView View) {
        this.theModel = Model;
        this.theView = View;

        //the resizing feature, has pros and cons...
        for (SVGTerritory svgTerritory: theModel.getBoard().getTerritories().values()) {
            svgTerritory.scaleXProperty().bind(theView.getMapPane().widthProperty().divide(1015));
            svgTerritory.scaleYProperty().bind(theView.getMapPane().heightProperty().divide(675));
        }

        //Show the info of a territory when hovered on.
        for (SVGTerritory svgTerritory: theModel.getBoard().getTerritories().values()){
            svgTerritory.setOnMouseEntered(event -> {
                theModel.getTerritoryInfoLbl().setText(svgTerritory.toString());
            });
            svgTerritory.setOnMouseClicked(event -> {
                theModel.getGameManager().setSelectedTerritory(svgTerritory.getName());
                for (SVGTerritory tempTerritory: theModel.getBoard().getTerritories().values()){
                    tempTerritory.setContinent(tempTerritory.getContinent());
                }
                svgTerritory.setFill(Color.GOLD);
            });
        }

        //Attack
        theView.getAttackBtn().setOnAction(event -> {
            try {
                theModel.getGameManager().playerAttack(theModel.getAttackToCBox().getValue(), Integer.parseInt(theModel.getNumAttackArmiesTField().getText()));
            } catch (IlleagalTerritoryOpException e) {
                showAlert();
            }
        });

        //move
        theView.getMoveBtn().setOnAction(event -> {
            //TODO
        });

        //claim
        theView.getClaimBtn().setOnAction(event -> {
            try {
                theModel.getGameManager().playerClaim();
                updateInfo();
            } catch (IlleagalTerritoryOpException e) {
                showAlert();
            }
        });

        //place
        theView.getPlaceBtn().setOnAction(event -> {
            try {
                theModel.getGameManager().playerPlaceTroop();
                updateInfo();
            } catch (IlleagalTerritoryOpException e) {
                showAlert();
            }
        });

        theView.getEndTurnBtn().setOnAction(event -> {
            theModel.getGameManager().getLogStream().println("Turn ended for Player " + theModel.getGameManager().getCurPlayer());
            theModel.getGameManager().nextTurn();
            updateInfo();
        });

    }

    public void showAlert() {
        Alert illegalOpAlert = new Alert(Alert.AlertType.WARNING);
        illegalOpAlert.setHeaderText("Illegal territory operation!");
        illegalOpAlert.setTitle("Bad Boy!");
        illegalOpAlert.setContentText("Illegal Operation! Probably the territory is not owned by you!");
        illegalOpAlert.show();
    }

    public void startGame() {
        theModel.getGameManager().startGame();
        updateInfo();
    }

    public void updateInfo() {
        theModel.getPlayerNumLbl().setText("Player " + theModel.getGameManager().getCurPlayer());
        theModel.getGameStateInfoLbl().setText("Current State: " + theModel.getGameManager().getState().toString());
    }

}
