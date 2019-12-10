package MVC;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

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

    public RiskView(RiskModel Model) {

        this.theModel = Model;
        this.endTurnBtn = new Button("End Turn");
        root = new BorderPane();
        root.setStyle("-fx-background-color: #dcc064");
        root.setMinSize(960, 540);

        //map center pane
        setUpMapCenterPane();

        //right info pane
        setUpRightInfoPane();

        //bot pane for turn control and players
        setUpBotPane();


        scene = new Scene(root);
    }

    /**
     * set up the bottom pane designated for controls
     * @author Chengcheng Ding
     */
    private void setUpBotPane() {
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

        VBox claimPlaceVBox = new VBox(5);
        claimBtn = new Button("Claim!");
        placeBtn = new Button("Place!");
        claimPlaceVBox.getChildren().addAll(claimBtn, placeBtn);

        controlPane.getChildren().addAll(attackHBox, moveHBox);
        controlPane.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(controlPane, Pos.CENTER);

        botTurnPane.getChildren().addAll(controlPane, new Separator(Orientation.VERTICAL), claimPlaceVBox);
        botTurnPane.setAlignment(Pos.CENTER);
        root.setBottom(botTurnPane);
        BorderPane.setAlignment(botTurnPane, Pos.CENTER);
        BorderPane.setMargin(botTurnPane, new Insets(0));
    }

    /**
     * set up the right pane for infos and logs
     */
    private void setUpRightInfoPane() {
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
    }

    /**
     * set up the center pane for the map
     */
    private void setUpMapCenterPane() {
        mapPane = new Pane();
        mapPane.getChildren().addAll(theModel.getBoard().getTerritories().values());
        mapPane.setStyle("-fx-background-color: #00FFFF");
        BorderPane.setMargin(mapPane, new Insets(0));
        root.setCenter(mapPane);
    }
}
