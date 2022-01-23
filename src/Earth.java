import javafx.animation.AnimationTimer;
import javafx.geometry.Point2D;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;

import java.util.ArrayList;

public class Earth extends Group {

    //Attributs
    private Sphere sph;
    private ArrayList<Sphere> yellowSphere;
    private PhongMaterial terre = new PhongMaterial();
    private PhongMaterial col = new PhongMaterial();
    private long rotation = 0;
    private int rayonTerre = 300;

    private Point3D coordinates;
    private Node node;
    double posXLattitude;
    double posYLongitude;
    double Lattitude;
    double Longitude;


    public Earth(){
        sph = new Sphere(300);
        this.getChildren().add(sph);
        Image img = new Image("earth_lights_4800.png");
        terre.setDiffuseMap(img);
        sph.setMaterial(terre);
    }

    public Sphere getSph() {
        return sph;
    }

    public Sphere createSphere(Aeroport a, Color color){
        Sphere sphere = new Sphere(2);
        col.setDiffuseColor(color);
        sphere.setMaterial(col);
        return sphere;
    }

    public void displayRedSphere(Aeroport a){
        double coordX = rayonTerre*Math.cos(a.getLongitude()-13)*Math.sin(a.getLattitude());
        double coordY = -rayonTerre*Math.sin(a.getLongitude()-13);
        double coordZ = -rayonTerre*Math.cos(a.getLongitude()-13)*Math.sin(a.getLattitude());

        Sphere sphere = createSphere(a, Color.CORAL);
        sphere.setTranslateX(coordX);
        sphere.setTranslateY(coordY);
        sphere.setTranslateZ(coordZ);
        this.getChildren().add(sphere);
    }

}
