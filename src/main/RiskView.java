package main;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class RiskView {

    private Map map;
    private Scene scene;
    private RiskModel theModel;

    public Scene getScene() {
        return scene;
    }

    public RiskView(RiskModel theModel) {
        this.theModel = theModel;
        map = new Map();
        Pane pane = new Pane();
        pane.getChildren().addAll(map.getPathList());
        pane.setStyle("-fx-background-color: #00FFFF");
        scene = new Scene(pane);
    }
}
