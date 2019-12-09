package main;

import javafx.scene.control.Alert;

import java.util.ArrayList;

/**
 * @author Chengcheng Ding
 */
public class RiskController {

    RiskModel theModel;
    RiskView theView;

    public RiskController(RiskModel theModel, RiskView theView) {
        this.theModel = theModel;
        this.theView = theView;

        //TODO: use log stream to show logs on the left.

        //Show the info of a territory when clicked on.
        for (SVGTerritory svgTerritory: theModel.getBoard().getTerritories().values()){
            svgTerritory.setOnMouseClicked(event -> {
                theModel.getTerritoryInfoLbl().setText(svgTerritory.toString());
                theModel.getGameManager().setSelectedTerritory(svgTerritory.getName());
            });
        }

        //Attack
        theView.getAttackBtn().setOnAction(event -> {
            try {
                theModel.getGameManager().playerAttack(theModel.getAttackToCBox().getValue());
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
            } catch (IlleagalTerritoryOpException e) {
                showAlert();
            }
        });

        //place
        theView.getPlaceBtn().setOnAction(event -> {
            try {
                theModel.getGameManager().playerPlaceTroop();
            } catch (IlleagalTerritoryOpException e) {
                showAlert();
            }
        });

        theView.getEndTurnBtn().setOnAction(event -> {
            theModel.getGameManager().getLogStream().println("Turn ended for Player " + theModel.getGameManager().getCurPlayer());
            theModel.getGameManager().nextTurn();
            theModel.getPlayerNumLbl().setText("Player " + theModel.getGameManager().getCurPlayer());
            theModel.getGameStateInfoLbl().setText(theModel.getGameManager().getState().toString());
        });

    }

    public void showAlert() {
        Alert illegalOpAlert = new Alert(Alert.AlertType.WARNING);
        illegalOpAlert.setHeaderText("Illegal territory operation!");
        illegalOpAlert.setTitle("Bad Boy!");
        illegalOpAlert.setContentText("Illegal Operation! Probably the territory is not owned by you!");
        illegalOpAlert.show();
    }

}
