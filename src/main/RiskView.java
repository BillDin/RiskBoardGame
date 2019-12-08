package main;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

/**
 * A border pane view for the risk GUI
 * @author Chengcheng Ding
 */
public class RiskView {

    private Scene scene;
    private RiskModel theModel;
    private Button endTurnBtn;
    private Button moveBtn;
    private Button attackBtn;
    private Button claimBtn;
    private Button placeBtn;

    public Button getClaimBtn() {
        return claimBtn;
    }

    public Button getPlaceBtn() {
        return placeBtn;
    }

    public Button getEndTurnBtn() {
        return endTurnBtn;
    }

    public Button getMoveBtn() {
        return moveBtn;
    }

    public Button getAttackBtn() {
        return attackBtn;
    }

    public Scene getScene() {
        return scene;
    }

    public RiskView(RiskModel theModel) {

        this.theModel = theModel;
        this.endTurnBtn = new Button("End Turn");
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #dcc064");

        //left pane for config
        VBox leftLogPane = new VBox(5);
        TextArea logTxtArea = theModel.getLogTxtArea();
        logTxtArea.setPrefWidth(150);
        logTxtArea.setDisable(true);
        logTxtArea.setWrapText(true);
        logTxtArea.setStyle("-fx-opacity: 1;" +
                "-fx-background-color: #dcc064;" +
                "-fx-font-size: 13;");
        logTxtArea.appendText("Here are the logs!\n");
        leftLogPane.getChildren().add(logTxtArea);
        root.setLeft(leftLogPane);

        //top pane for control
        VBox topControlPane = new VBox(5);

        HBox attackHBox = new HBox(5);
        attackHBox.setAlignment(Pos.CENTER);
        attackBtn = new Button("Attack!");
        attackHBox.getChildren().addAll(new Label("Attack to "), theModel.getAttackToCBox(), new Label(" with "), theModel.getNumAttackArmiesTField(), new Label(" Armies."), attackBtn);


        HBox moveHBox = new HBox(5);
        moveHBox.setAlignment(Pos.CENTER);
        moveBtn = new Button("Move!");
        moveHBox.getChildren().addAll(new Label("Move to "), theModel.getMoveToCBox(), new Label(" with "), theModel.getNumMoveArmiesTField(), new Label(" Armies."), moveBtn);

        claimBtn = new Button("Claim!");
        placeBtn = new Button("Place!");

        topControlPane.getChildren().addAll(attackHBox, moveHBox, claimBtn, placeBtn);
        root.setTop(topControlPane);
        topControlPane.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(topControlPane, Pos.CENTER);

        //center map pane
        Pane mapPane = new Pane();
        mapPane.getChildren().addAll(theModel.getBoard().getTerritories().values());
        mapPane.setStyle("-fx-background-color: #00FFFF");
        root.setCenter(mapPane);

        //right info pane
        VBox rightInfoPane = new VBox();
        rightInfoPane.getChildren().add(theModel.getTerritoryInfoLbl());
        root.setRight(rightInfoPane);
        rightInfoPane.setAlignment(Pos.CENTER);
        rightInfoPane.setPrefWidth(150);
        BorderPane.setAlignment(rightInfoPane, Pos.CENTER);

        //bot pane for turn control and players
        HBox botTurnPane = new HBox(5);
        botTurnPane.getChildren().addAll(theModel.getPlayerNumLbl(), new Separator(), theModel.getGameStateInfoLbl(), endTurnBtn);
        botTurnPane.setAlignment(Pos.CENTER);
        root.setBottom(botTurnPane);
        BorderPane.setAlignment(botTurnPane, Pos.CENTER);


        scene = new Scene(root);
    }
}
