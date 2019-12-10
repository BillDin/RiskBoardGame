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


package GameGadgets;

import MVC.SVGEnum;
import MVC.SVGTerritory;

import java.util.ArrayList;
import java.util.HashMap;

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

    private ArrayList<Territory> territoryList;
    private HashMap<String, SVGTerritory> territories;

    /**
     * Constructor, set everything up.
     */
    public Board(){
        territories = new HashMap<>();
        territoryList = new ArrayList<>();

        initTerritories();

        setupNorthAmerica();

        setupSouthAmerica();

        setupEurope();

        setupAfrica();

        setupAsia();

        setupAustralia();

        setupHashmap();

    }


    /**
     * initialize territories
     */
    private void initTerritories() {
        alaska = new Territory("Alaska");
        territoryList.add(alaska);
        alberta = new Territory("Alberta");
        territoryList.add(alberta);
        centralAmerica = new Territory("Central America");
        territoryList.add(centralAmerica);
        eastUS = new Territory("Eastern US");
        territoryList.add(eastUS);
        greenland = new Territory("Greenland");
        territoryList.add(greenland);
        northwestTerritory = new Territory("Northwest Territory");
        territoryList.add(northwestTerritory);
        ontario = new Territory("Ontario");
        territoryList.add(ontario);
        quebec = new Territory("Quebec");
        territoryList.add(quebec);
        westUS = new Territory("Western US");
        territoryList.add(westUS);
        argentina = new Territory("Argentina");
        territoryList.add(argentina);
        brazil = new Territory("Brazil");
        territoryList.add(brazil);
        peru = new Territory("Peru");
        territoryList.add(peru);
        venezuela = new Territory("Venezuela");
        territoryList.add(venezuela);
        greatBritain = new Territory("Great Britain");
        territoryList.add(greatBritain);
        iceland = new Territory("Iceland");
        territoryList.add(iceland);
        northEurope = new Territory("Northern Europe");
        territoryList.add(northEurope);
        scandanavia = new Territory("Scandinavia");
        territoryList.add(scandanavia);
        southEurope = new Territory("Southern Europe");
        territoryList.add(southEurope);
        ukraine = new Territory("Ukraine");
        territoryList.add(ukraine);
        westEurope = new Territory("Western Europe");
        territoryList.add(westEurope);
        congo = new Territory("Congo");
        territoryList.add(congo);
        eastAfrica = new Territory("East Africa");
        territoryList.add(eastAfrica);
        egypt = new Territory("Egypt");
        territoryList.add(egypt);
        madagascar = new Territory("Madagascar");
        territoryList.add(madagascar);
        northAfrica = new Territory("North Africa");
        territoryList.add(northAfrica);
        southAfrica = new Territory("South Africa");
        territoryList.add(southAfrica);
        afghanistan = new Territory("Afghanistan");
        territoryList.add(afghanistan);
        china = new Territory("China");
        territoryList.add(china);
        india = new Territory("India");
        territoryList.add(india);
        irkutsk = new Territory("Irkutsk");
        territoryList.add(irkutsk);
        japan = new Territory("Japan");
        territoryList.add(japan);
        kamchatka = new Territory("Kamchatka");
        territoryList.add(kamchatka);
        middleEast = new Territory("Middle East");
        territoryList.add(middleEast);
        mongolia = new Territory("Mongolia");
        territoryList.add(mongolia);
        siam = new Territory("Siam");
        territoryList.add(siam);
        siberia = new Territory("Siberia");
        territoryList.add(siberia);
        ural = new Territory("Ural");
        territoryList.add(ural);
        yakutsk = new Territory("Yakutsk");
        territoryList.add(yakutsk);
        eastAustralia = new Territory("Eastern Australia");
        territoryList.add(eastAustralia);
        indonesia = new Territory("Indonesia");
        territoryList.add(indonesia);
        newGuinea = new Territory("New Guinea");
        territoryList.add(newGuinea);
        westAustralia = new Territory("Western Australia");
        territoryList.add(westAustralia);
    }

    /**
     * Set up a continent, recording the adjacent territories
     */
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

    /**
     * Set up a continent, recording the adjacent territories
     */
    private void setupSouthAmerica(){
        //Argentina
        argentina.addAdjacent(peru);
        argentina.addAdjacent(brazil);

        //Brazil
        brazil.addAdjacent(northAfrica);
        brazil.addAdjacent(argentina);
        brazil.addAdjacent(peru);
        brazil.addAdjacent(venezuela);

        //Peru
        peru.addAdjacent(argentina);
        peru.addAdjacent(brazil);
        peru.addAdjacent(venezuela);

        //Venezuela
        venezuela.addAdjacent(centralAmerica);
        venezuela.addAdjacent(brazil);
        venezuela.addAdjacent(peru);
    }

    /**
     * Set up a continent, recording the adjacent territories
     */
    private void setupEurope(){
        //Iceland
        iceland.addAdjacent(greenland);
        iceland.addAdjacent(greatBritain);
        iceland.addAdjacent(scandanavia);

        //Great Britain
        greatBritain.addAdjacent(iceland);
        greatBritain.addAdjacent(scandanavia);
        greatBritain.addAdjacent(northEurope);
        greatBritain.addAdjacent(westEurope);

        //Western Europe
        westEurope.addAdjacent(northAfrica);
        westEurope.addAdjacent(greatBritain);
        westEurope.addAdjacent(northEurope);
        westEurope.addAdjacent(southEurope);

        //Northern Europe
        northEurope.addAdjacent(scandanavia);
        northEurope.addAdjacent(ukraine);
        northEurope.addAdjacent(southEurope);
        northEurope.addAdjacent(westEurope);
        northEurope.addAdjacent(greatBritain);

        //Scandanavia
        scandanavia.addAdjacent(iceland);
        scandanavia.addAdjacent(greatBritain);
        scandanavia.addAdjacent(northEurope);
        scandanavia.addAdjacent(ukraine);

        //Southern Europe
        southEurope.addAdjacent(northEurope);
        southEurope.addAdjacent(westEurope);
        southEurope.addAdjacent(egypt);
        southEurope.addAdjacent(middleEast);
        southEurope.addAdjacent(ukraine);

        //Ukraine
        ukraine.addAdjacent(ural);
        ukraine.addAdjacent(afghanistan);
        ukraine.addAdjacent(middleEast);
        ukraine.addAdjacent(southEurope);
        ukraine.addAdjacent(northEurope);
        ukraine.addAdjacent(scandanavia);
    }

    /**
     * Set up a continent, recording the adjacent territories
     */
    private void setupAfrica(){
        //Egypt
        egypt.addAdjacent(southEurope);
        egypt.addAdjacent(middleEast);
        egypt.addAdjacent(northEurope);
        egypt.addAdjacent(eastAfrica);

        //North Africa
        northAfrica.addAdjacent(westEurope);
        northAfrica.addAdjacent(brazil);
        northAfrica.addAdjacent(egypt);
        northAfrica.addAdjacent(eastAfrica);
        northAfrica.addAdjacent(congo);

        //East Africa
        eastAfrica.addAdjacent(middleEast);
        eastAfrica.addAdjacent(egypt);
        eastAfrica.addAdjacent(northAfrica);
        eastAfrica.addAdjacent(congo);
        eastAfrica.addAdjacent(southAfrica);
        eastAfrica.addAdjacent(madagascar);

        //Congo
        congo.addAdjacent(northAfrica);
        congo.addAdjacent(eastAfrica);
        congo.addAdjacent(southAfrica);

        //Madagascar
        madagascar.addAdjacent(eastAfrica);
        madagascar.addAdjacent(southAfrica);

        //South Africa
        southAfrica.addAdjacent(congo);
        southAfrica.addAdjacent(eastAfrica);
        southAfrica.addAdjacent(madagascar);
    }

    /**
     * Set up a continent, recording the adjacent territories
     */
    private void setupAsia(){
        //Middle East
        middleEast.addAdjacent(ukraine);
        middleEast.addAdjacent(southEurope);
        middleEast.addAdjacent(egypt);
        middleEast.addAdjacent(eastAfrica);
        middleEast.addAdjacent(afghanistan);
        middleEast.addAdjacent(india);

        //Afghanistan
        afghanistan.addAdjacent(ukraine);
        afghanistan.addAdjacent(middleEast);
        afghanistan.addAdjacent(india);
        afghanistan.addAdjacent(china);
        afghanistan.addAdjacent(ural);

        //India
        india.addAdjacent(middleEast);
        india.addAdjacent(afghanistan);
        india.addAdjacent(china);
        india.addAdjacent(siam);

        //Ural
        ural.addAdjacent(ukraine);
        ural.addAdjacent(siberia);
        ural.addAdjacent(china);
        ural.addAdjacent(afghanistan);

        //China
        china.addAdjacent(mongolia);
        china.addAdjacent(siberia);
        china.addAdjacent(ural);
        china.addAdjacent(afghanistan);
        china.addAdjacent(india);
        china.addAdjacent(siam);

        //Siberia
        siberia.addAdjacent(ural);
        siberia.addAdjacent(china);
        siberia.addAdjacent(mongolia);
        siberia.addAdjacent(irkutsk);
        siberia.addAdjacent(yakutsk);

        //Siam
        siam.addAdjacent(indonesia);
        siam.addAdjacent(india);
        siam.addAdjacent(china);

        //Mongolia
        mongolia.addAdjacent(china);
        mongolia.addAdjacent(siberia);
        mongolia.addAdjacent(irkutsk);
        mongolia.addAdjacent(kamchatka);
        mongolia.addAdjacent(japan);

        //Irkutsk
        irkutsk.addAdjacent(kamchatka);
        irkutsk.addAdjacent(yakutsk);
        irkutsk.addAdjacent(siberia);
        irkutsk.addAdjacent(mongolia);

        //Yakutsk
        yakutsk.addAdjacent(kamchatka);
        yakutsk.addAdjacent(irkutsk);
        yakutsk.addAdjacent(siberia);

        //Kamchatka
        kamchatka.addAdjacent(alaska);
        kamchatka.addAdjacent(yakutsk);
        kamchatka.addAdjacent(irkutsk);
        kamchatka.addAdjacent(mongolia);
        kamchatka.addAdjacent(japan);

        //Japan
        japan.addAdjacent(mongolia);
        japan.addAdjacent(kamchatka);
    }

    /**
     * Set up a continent, recording the adjacent territories
     */
    private void setupAustralia(){
        //Indonesia
        indonesia.addAdjacent(siam);
        indonesia.addAdjacent(newGuinea);
        indonesia.addAdjacent(westAustralia);

        //New Guinea
        newGuinea.addAdjacent(indonesia);
        newGuinea.addAdjacent(westAustralia);
        newGuinea.addAdjacent(eastAustralia);

        //Western Australia
        westAustralia.addAdjacent(indonesia);
        westAustralia.addAdjacent(newGuinea);
        westAustralia.addAdjacent(eastAustralia);

        //Eastern Australia
        eastAustralia.addAdjacent(newGuinea);
        eastAustralia.addAdjacent(westAustralia);
    }

    /**
     * This is where the model takes shape, connecting data to nodes.
     * @author Chengcheng Ding
     */
    private void setupHashmap(){
        for(int i = 0; i < territoryList.size(); i++){
            territories.put(territoryList.get(i).toString(), new SVGTerritory(territoryList.get(i)));
        }
        for (SVGEnum svgEnum: SVGEnum.values()) {
            try {
                territories.get(svgEnum.getId()).setContent(svgEnum.getsPath());
                territories.get(svgEnum.getId()).setContinent(svgEnum.getContinent());
            } catch (NullPointerException e) {
                System.out.println(svgEnum.getId());
            }
        }
    }

    public HashMap<String, SVGTerritory> getTerritories() {
        return territories;
    }

    public ArrayList<Territory> getTerritoryList() {
        return territoryList;
    }
}
