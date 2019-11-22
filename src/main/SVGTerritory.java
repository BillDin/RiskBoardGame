package main;

import javafx.beans.property.IntegerProperty;
import javafx.scene.shape.SVGPath;

public class SVGTerritory extends SVGPath {

    private Territory territory;

    public String getName() {
        return territory.getName();
    }

    public Territory getTerritory() {
        return territory;
    }

    public void setTerritory(Territory territory) {
        this.territory = territory;
    }

    public SVGTerritory(Territory territory) {
        this.territory = territory;
    }

}
