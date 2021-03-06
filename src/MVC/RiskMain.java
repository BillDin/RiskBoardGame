package MVC;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * the main class that fires up the GUI. Standard and light. Nothing much to explain.
 * @author Chengcheng Ding
 */
public class RiskMain extends Application {

    RiskView theView;
    RiskModel theModel;
    RiskController theController;

    @Override
    public void init() throws Exception {
        super.init();
        theModel = new RiskModel();
        theView = new RiskView(theModel);
        theController = new RiskController(theModel, theView);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        theController.startGame();
        Scene scene = theView.getScene();
        primaryStage.setTitle("Risk Classic");
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }
}
