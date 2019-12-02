package main;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

/**
 * A border pane view for the risk GUI
 * @author Chengcheng Ding
 */
public class RiskView {

    private Scene scene;
    private RiskModel theModel;

    public Scene getScene() {
        return scene;
    }

    public RiskView(RiskModel theModel) {

        this.theModel = theModel;
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #DC143C");

        //top pane for config
        HBox topConfigPane = new HBox(5);
        topConfigPane.getChildren().add(new Label("This is supposed to be the config node."));
        Button restartBtn = new Button("Restart the game with the configs!");
        topConfigPane.getChildren().add(restartBtn);
        root.setTop(topConfigPane);
        topConfigPane.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(topConfigPane, Pos.CENTER);


        //left pane for info display
        VBox leftControlPane = new VBox(5);

        HBox attackHBox = new HBox(5);
        Button attackGoBtn = new Button("Go!");
        attackHBox.getChildren().addAll(new Label(" Attack from "), theModel.getAttackFromCBox(), new Label(" to "), theModel.getAttackToCBox(), new Label(" with "), theModel.getNumAttackArmiesTField(), new Label(" Armies."), attackGoBtn);


        HBox moveHBox = new HBox(5);
        Button moveGoBtn = new Button("Go!");
        moveHBox.getChildren().addAll(new Label("Move from"), theModel.getMoveFromCBox(), new Label(" to "), theModel.getMoveToCBox(), new Label(" with "), theModel.getNumMoveArmiesTField(), new Label(" Armies."), moveGoBtn);

        HBox diceHBox = new HBox(5);
        diceHBox.getChildren().add(new Label("dices!"));

        leftControlPane.getChildren().addAll(attackHBox, moveHBox, diceHBox);
        root.setLeft(leftControlPane);
        //leftControlPane.setPrefWidth(200);
        leftControlPane.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(leftControlPane, Pos.CENTER);

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

        scene = new Scene(root);
    }
}
