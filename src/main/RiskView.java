package main;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

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
        attackHBox.getChildren().add(new Label("attack!"));


        HBox moveHBox = new HBox(5);
        moveHBox.getChildren().add(new Label("move!"));

        HBox diceHBox = new HBox(5);
        diceHBox.getChildren().add(new Label("dices!"));

        leftControlPane.getChildren().addAll(attackHBox, moveHBox, diceHBox);
        root.setLeft(leftControlPane);
        leftControlPane.setPrefWidth(150);
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
