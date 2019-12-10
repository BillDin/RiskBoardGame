package main;

import javafx.scene.control.Alert;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;

/**
 * The controller for the risk
 * @author Chengcheng Ding
 */
public class RiskController {

    private RiskModel theModel;
    private RiskView theView;

    /**
     * initialize everything in the constructor
     * @param Model model of SVG
     * @param View view of SVG
     */
    public RiskController(RiskModel Model, RiskView View) {
        this.theModel = Model;
        this.theView = View;

        controlSVG();

        //Attack
        attackControl();

        //move
        moveControl();

        //claim
        claimControl();

        //place
        placeControl();

        //end turn
        endTurnControl();

    }

    /**
     * Set up the end turn button
     * @author Chengcheng Ding
     */
    private void endTurnControl() {
        theView.getEndTurnBtn().setOnAction(event -> {
            theModel.getGameManager().getLogStream().println("Turn ended for Player " + theModel.getGameManager().getCurPlayer());
            theModel.getGameManager().nextTurn();
            updateInfo();
        });
    }

    /**
     * Set up the place button
     * @author Chengcheng Ding
     */
    private void placeControl() {
        theView.getPlaceBtn().setOnAction(event -> {
            try {
                theModel.getGameManager().playerPlaceTroop();
                updateInfo();
            } catch (IlleagalTerritoryOpException e) {
                showAlert();
            }
        });
    }

    /**
     * set up the claim Button
     * @author Chengcheng Ding
     */
    private void claimControl() {
        theView.getClaimBtn().setOnAction(event -> {
            try {
                theModel.getGameManager().playerClaim();
                updateInfo();
            } catch (IlleagalTerritoryOpException e) {
                showAlert();
            }
        });
    }

    /**
     * set up the move control
     * @author Chengcheng Ding
     */
    private void moveControl() {
        theView.getMoveBtn().setOnAction(event -> {
            try {
                theModel.getGameManager().playerMoveArmies(theModel.getMoveToCBox().getValue(), Integer.parseInt(theModel.getNumMoveArmiesTField().getText()));
            } catch (IlleagalTerritoryOpException e) {
                showAlert();
            }
        });
    }

    /**
     * set up the attack button
     * @author Chengcheng Ding
     */
    private void attackControl() {
        theView.getAttackBtn().setOnAction(event -> {
            try {
                theModel.getGameManager().playerAttack(theModel.getAttackToCBox().getValue(), Integer.parseInt(theModel.getNumAttackArmiesTField().getText()));
            } catch (IlleagalTerritoryOpException e) {
                showAlert();
            }
        });
    }

    /**
     * resizing and hover on features for svg classes
     * @author Chengcheng Ding
     */
    private void controlSVG() {
        for (SVGTerritory svgTerritory: theModel.getBoard().getTerritories().values()) {
            svgTerritory.scaleXProperty().bind(theView.getMapPane().widthProperty().divide(1015));
            svgTerritory.scaleYProperty().bind(theView.getMapPane().heightProperty().divide(647));
        }

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
    }

    /**
     * show alert for the exception we designed
     * @author Chengcheng Ding
     */
    public void showAlert() {
        Alert illegalOpAlert = new Alert(Alert.AlertType.WARNING);
        illegalOpAlert.setHeaderText("Illegal territory operation!");
        illegalOpAlert.setTitle("Bad Boy!");
        illegalOpAlert.setContentText("Illegal Operation! Probably the territory is not owned by you!");
        illegalOpAlert.show();
    }

    /**
     * start the game for the GUI
     * @author Chengcheng Ding
     */
    public void startGame() {
        theModel.getGameManager().startGame();
        updateInfo();
    }

    /**
     * Update Info on the right
     * @author Chengcheng Ding
     */
    public void updateInfo() {
        theModel.getPlayerNumLbl().setText("Player " + theModel.getGameManager().getCurPlayer());
        theModel.getGameStateInfoLbl().setText("Current State: " + theModel.getGameManager().getState().toString());
        if (theModel.getGameManager().getState() == GameStateEnum.FINISHED) {
            Alert congrat = new Alert(Alert.AlertType.INFORMATION);
            congrat.setTitle("Congratulations!");
            congrat.setHeaderText("You won!");
            congrat.setContentText("The winner is: player " + theModel.getGameManager().getWinPlayer() + "!");
            congrat.show();
        }
    }

}
