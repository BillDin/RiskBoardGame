/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: Chengcheng Ding
 * Section: 11:00a.m.
 * Date: 11/13/2019
 * Time: 8:17 PM
 *
 * Project: csci205FinalProject
 * Package: Board
 * Class: Map
 *
 * Description:
 *
 * ****************************************
 */
package Board;

import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;

import java.util.ArrayList;

public class Map {

    ArrayList<SVGPath> pathList;

    public ArrayList<SVGPath> getPathList() {
        return pathList;
    }

    public Map() {
        pathList = new ArrayList<>();
        for (SVGEnum svgEnum: SVGEnum.values()) {
            SVGPath path = svgEnum.getPath();
            path.setStroke(Color.BLACK);
            if (svgEnum.getContinent().equals("sea")){
                path.setFill(Color.ROYALBLUE);
            }
            else if(svgEnum.getContinent().equals("Africa")) {
                path.setFill(Color.FIREBRICK);
            }
            else if(svgEnum.getContinent().equals("Asia")) {
                path.setFill(Color.DARKGOLDENROD);
            }
            else if(svgEnum.getContinent().equals("Australia")) {
                path.setFill(Color.RED);
            }
            else if(svgEnum.getContinent().equals("Europe")) {
                path.setFill(Color.ORCHID);
            }
            else if(svgEnum.getContinent().equals("NA")) {
                path.setFill(Color.BISQUE);
            }
            else if(svgEnum.getContinent().equals("SA")) {
                path.setFill(Color.SEAGREEN);
            }
            path.setOnMouseClicked(event -> {
                System.out.println("Clicked on: " + svgEnum.getId() + " Continent: " + svgEnum.getContinent());
            });
            pathList.add(path);
        }
    }

}