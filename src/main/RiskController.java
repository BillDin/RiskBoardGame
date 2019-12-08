package main;

public class RiskController {

    RiskModel theModel;
    RiskView theView;

    public RiskController(RiskModel theModel, RiskView theView) {
        this.theModel = theModel;
        this.theView = theView;

        /**Show the info of a territory when clicked on.(Ding)*/
        for (SVGTerritory svgTerritory: theModel.getBoard().getTerritories().values()){
            svgTerritory.setOnMouseClicked(event -> {
                theModel.getTerritoryInfoLbl().setText(svgTerritory.toString());
                theModel.getBoard().setSelectedTerritory(svgTerritory.getName());
            });
        }

    }

}
