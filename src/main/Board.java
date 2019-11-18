/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Brian King
 * Section: 11 AM
 *
 * Name: John Owen
 * Date: 11/13
 * Time: 11:45 AM
 *
 * Project: csci205_Final_Project
 * Package: main
 * Class: Board
 *
 * Description:
 *
 * *****************************************/


package main;

public class Board {

    //North America
    private Territory alaska;
    private Territory alberta;
    private Territory centralAmerica;
    private Territory eastUS;
    private Territory greenland;
    private Territory northwestTerritory;
    private Territory ontario;
    private Territory quebec;
    private Territory westUS;

    //South America
    private Territory argentina;
    private Territory brazil;
    private Territory peru;
    private Territory venezuela;

    //Europe
    private Territory greatBritain;
    private Territory iceland;
    private Territory northEurope;
    private Territory scandanavia;
    private Territory southEurope;
    private Territory ukraine;
    private Territory westEurope;

    //Africa
    private Territory congo;
    private Territory eastAfrica;
    private Territory egypt;
    private Territory madagascar;
    private Territory northAfrica;
    private Territory southAfrica;

    //Asia
    private Territory afghanistan;
    private Territory china;
    private Territory india;
    private Territory irkutsk;
    private Territory japan;
    private Territory kamchatka;
    private Territory middleEast;
    private Territory mongolia;
    private Territory siam;
    private Territory siberia;
    private Territory ural;
    private Territory yakutsk;

    //Australia
    private Territory eastAustralia;
    private Territory indonesia;
    private Territory newGuinea;
    private Territory westAustralia;

    public Board(){
        initTerritories();

        setupNorthAmerica();

        //setupSouthAmerica();
    }

    private void initTerritories() {
        alaska = new Territory("Alaska");
        alberta = new Territory("Alberta");
        centralAmerica = new Territory("Central America");
        eastUS = new Territory("Eastern US");
        greenland = new Territory("Greenland");
        northwestTerritory = new Territory("Northwest Territory");
        ontario = new Territory("Ontario");
        quebec = new Territory("Quebec");
        westUS = new Territory("Western US");
        argentina = new Territory("Argentina");
        brazil = new Territory("Brazil");
        peru = new Territory("Peru");
        venezuela = new Territory("Venezuela");
        greatBritain = new Territory("Great Britain");
        iceland = new Territory("Iceland");
        northEurope = new Territory("Northern Europe");
        scandanavia = new Territory("Scandanavia");
        southEurope = new Territory("Southern Europe");
        ukraine = new Territory("Ukraine");
        westEurope = new Territory("Western Europe");
        congo = new Territory("Congo");
        eastAfrica = new Territory("East Africa");
        egypt = new Territory("Egypt");
        madagascar = new Territory("Madagascar");
        northAfrica = new Territory("North Africa");
        southAfrica = new Territory("South Africa");
        afghanistan = new Territory("Afghanistan");
        china = new Territory("China");
        india = new Territory("India");
        irkutsk = new Territory("Irkutsk");
        japan = new Territory("Japan");
        kamchatka = new Territory("Kamchatka");
        middleEast = new Territory("Middle East");
        mongolia = new Territory("Mongolia");
        siam = new Territory("Siam");
        siberia = new Territory("Siberia");
        ural = new Territory("Ural");
        yakutsk = new Territory("Yakutsk");
        eastAustralia = new Territory("Eastern Australia");
        indonesia = new Territory("Indonesia");
        newGuinea = new Territory("New Guinea");
        westAustralia = new Territory("Western Australia");
    }

    private void setupNorthAmerica() {
        //Alaska
        alaska.addAdjacent(kamchatka);
        alaska.addAdjacent(northwestTerritory);
        alaska.addAdjacent(alberta);

        //Alberta
        alberta.addAdjacent(alaska);
        alberta.addAdjacent(northwestTerritory);
        alberta.addAdjacent(ontario);
        alberta.addAdjacent(westUS);

        //Central America
        centralAmerica.addAdjacent(venezuela);
        centralAmerica.addAdjacent(westUS);
        centralAmerica.addAdjacent(eastUS);

        //Eastern US
        eastUS.addAdjacent(centralAmerica);
        eastUS.addAdjacent(ontario);
        eastUS.addAdjacent(westUS);
        eastUS.addAdjacent(quebec);

        //Greenland
        greenland.addAdjacent(iceland);
        greenland.addAdjacent(northwestTerritory);
        greenland.addAdjacent(ontario);
        greenland.addAdjacent(quebec);

        //Northwest Territory
        northwestTerritory.addAdjacent(alaska);
        northwestTerritory.addAdjacent(alberta);
        northwestTerritory.addAdjacent(ontario);
        northwestTerritory.addAdjacent(greenland);

        //Ontario
        ontario.addAdjacent(northwestTerritory);
        ontario.addAdjacent(alberta);
        ontario.addAdjacent(quebec);
        ontario.addAdjacent(westUS);
        ontario.addAdjacent(eastUS);

        //Quebec
        quebec.addAdjacent(ontario);
        quebec.addAdjacent(eastUS);
        quebec.addAdjacent(greenland);

        //Western US
        westUS.addAdjacent(alberta);
        westUS.addAdjacent(ontario);
        westUS.addAdjacent(eastUS);
        westUS.addAdjacent(centralAmerica);
    }

    /*private void setupSouthAmerica(){

    }*/
}
