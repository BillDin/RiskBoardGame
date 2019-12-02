package main;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;

/**
 * The class that extends from the SVGPath class, storing information for usage.
 * @author Chengcheng Ding
 */
public class SVGTerritory extends SVGPath {

    private Territory territory;
    private String name;
    private String continent;
    private SimpleIntegerProperty armyProperty;

    public String getContinent() {
        return continent;
    }

    /**
     * set a continent of a SVG territory, updating the color based on the continent
     * @param continent the name of the continent
     */
    public void setContinent(String continent) {
        this.continent = continent;
        this.setStroke(Color.BLACK);
        //if (continent.equals("sea")){
            //this.setFill(Color.ROYALBLUE);
        //}
        if(continent.equals("Africa")) {
            this.setFill(Color.FIREBRICK);
        }
        else if(continent.equals("Asia")) {
            this.setFill(Color.DARKGOLDENROD);
        }
        else if(continent.equals("Australia")) {
            this.setFill(Color.RED);
        }
        else if(continent.equals("Europe")) {
            this.setFill(Color.ORCHID);
        }
        else if(continent.equals("NA")) {
            this.setFill(Color.BISQUE);
        }
        else if(continent.equals("SA")) {
            this.setFill(Color.SEAGREEN);
        }
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

    public SVGTerritory(Territory territory) {
        super();
        this.territory = territory;
        this.name = territory.getName();
        this.armyProperty = territory.armyPropertyProperty();


    }

    @Override
    public String toString() {
        return String.format("Name: %s; Continent: %s; number of armies: %s", name, continent, armyProperty.getValue());
    }
}
