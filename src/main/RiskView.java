package main;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

/**
 * A border pane view for the risk GUI
 * @author Chengcheng Ding
 */
public class RiskView {

    private Scene scene;
    private RiskModel theModel;
    private Button endTuenBtn;

    public Scene getScene() {
        return scene;
    }

    public RiskView(RiskModel theModel) {

        this.theModel = theModel;
        this.endTuenBtn = new Button("End Turn");
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #dcc064");

        //left pane for config
        VBox leftConfigPane = new VBox(5);
        TextField numPlayersTField = new TextField("4");
        leftConfigPane.getChildren().addAll(numPlayersTField, new Label("Players"));
        Button restartBtn = new Button("Reconfigure!");
        leftConfigPane.getChildren().add(restartBtn);
        root.setLeft(leftConfigPane);
        leftConfigPane.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(leftConfigPane, Pos.CENTER);


        //top pane for control
        VBox topControlPane = new VBox(5);

        HBox attackHBox = new HBox(5);
        attackHBox.setAlignment(Pos.CENTER);
        Button attackGoBtn = new Button("Go!");
        attackHBox.getChildren().addAll(new Label(" Attack from "), theModel.getAttackFromCBox(), new Label(" to "), theModel.getAttackToCBox(), new Label(" with "), theModel.getNumAttackArmiesTField(), new Label(" Armies."), attackGoBtn);


        HBox moveHBox = new HBox(5);
        moveHBox.setAlignment(Pos.CENTER);
        Button moveGoBtn = new Button("Go!");
        moveHBox.getChildren().addAll(new Label("Move from"), theModel.getMoveFromCBox(), new Label(" to "), theModel.getMoveToCBox(), new Label(" with "), theModel.getNumMoveArmiesTField(), new Label(" Armies."), moveGoBtn);

        HBox diceHBox = new HBox(5);
        diceHBox.setAlignment(Pos.CENTER);
        diceHBox.getChildren().add(new Label("dices!"));

        topControlPane.getChildren().addAll(attackHBox, moveHBox, diceHBox);
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
        botTurnPane.getChildren().addAll(theModel.getPlayerNumLbl(), new Separator(), theModel.getPlayerInfoLbl(), endTuenBtn);
        botTurnPane.setAlignment(Pos.CENTER);
        root.setBottom(botTurnPane);
        BorderPane.setAlignment(botTurnPane, Pos.CENTER);


        scene = new Scene(root);
    }
}
