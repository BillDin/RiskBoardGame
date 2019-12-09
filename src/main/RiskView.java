package main;

import javafx.geometry.Insets;
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
    private Pane mapPane;
    private BorderPane root;

    public BorderPane getRoot() {
        return root;
    }

    public Pane getMapPane() {
        return mapPane;
    }

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
        root = new BorderPane();
        root.setStyle("-fx-background-color: #dcc064");

        //map pane
        mapPane = new Pane();
        mapPane.getChildren().addAll(theModel.getBoard().getTerritories().values());
        mapPane.setStyle("-fx-background-color: #00FFFF");
        BorderPane.setMargin(mapPane, new Insets(0));
        root.setCenter(mapPane);

        //right info pane
        VBox rightInfoPane = new VBox();
        TextArea logTxtArea = theModel.getLogTxtArea();
        logTxtArea.setPrefWidth(150);
        logTxtArea.setDisable(true);
        logTxtArea.setWrapText(true);
        logTxtArea.setStyle("-fx-opacity: 1;" +
                "-fx-background-color: #dcc064;" +
                "-fx-font-size: 13;");
        logTxtArea.appendText("Here are the logs!\n");
        rightInfoPane.getChildren().add(logTxtArea);


        rightInfoPane.getChildren().add(theModel.getTerritoryInfoLbl());
        rightInfoPane.getChildren().addAll(theModel.getPlayerNumLbl(), theModel.getGameStateInfoLbl(), endTurnBtn);
        root.setRight(rightInfoPane);
        rightInfoPane.setAlignment(Pos.CENTER);
        rightInfoPane.setPrefWidth(150);
        BorderPane.setAlignment(rightInfoPane, Pos.CENTER);
        BorderPane.setMargin(rightInfoPane, new Insets(0));

        //bot pane for turn control and players
        HBox botTurnPane = new HBox(5);

        VBox controlPane = new VBox(5);

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

        controlPane.getChildren().addAll(attackHBox, moveHBox, claimBtn, placeBtn);
        controlPane.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(controlPane, Pos.CENTER);

        botTurnPane.getChildren().add(controlPane);
        botTurnPane.setAlignment(Pos.CENTER);
        root.setBottom(botTurnPane);
        BorderPane.setAlignment(botTurnPane, Pos.CENTER);
        BorderPane.setMargin(botTurnPane, new Insets(0));


        scene = new Scene(root);
    }
}
