package exceptions;

import javafx.scene.control.Alert;

/**
 * exception for illegal operations
 */
public class IllegalTerritoryOpException extends Exception {

    public IllegalTerritoryOpException(){

    }

    /**
     * show alert for the exception we designed
     * @author Chengcheng Ding, John Owen
     */
    public void showAlert(String message) {
        Alert illegalOpAlert = new Alert(Alert.AlertType.WARNING);
        illegalOpAlert.setHeaderText("Illegal territory operation!");
        illegalOpAlert.setTitle("Bad Boy!");
        illegalOpAlert.setContentText(message);
        illegalOpAlert.show();
    }
}
