package main;

import javafx.beans.property.IntegerProperty;
import javafx.scene.shape.SVGPath;

public class SVGTerritory extends SVGPath {

    private Territory territory;
    private String name;
    private String continent;

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Territory getTerritory() {
        return territory;
    }

    public void setTerritory(Territory territory) {
        this.territory = territory;
    }

    public SVGTerritory() {
        super();
    }

    public SVGTerritory(Territory territory) {
        super();
        this.territory = territory;
    }

    @Override
    public String toString() {
        return String.format("Name: %s; Continent: %s", name, continent);
    }
}
