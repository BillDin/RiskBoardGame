package main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;

public class RiskMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Map map = new Map();
        Pane pane = new Pane();
        pane.getChildren().addAll(map.getPathList());
        pane.setStyle("-fx-background-color: #00FFFF");
        Scene scene = new Scene(pane);
        primaryStage.setTitle("TestMap");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
