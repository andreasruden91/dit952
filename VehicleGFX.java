import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class VehicleGFX {
    // State
    BufferedImage img;
    TransportationVehicle vehicle;

    // Constructor
    public VehicleGFX(TransportationVehicle vehicle){
        try {
            img = ImageIO.read(new File("src\\pics\\" + vehicle.getName() + ".jpg"));
        }catch (IOException ex) {
            ex.printStackTrace();
        }
        this.vehicle = vehicle;
    }

    // Behaviors
    Point getPoint() {
        int x = (int) Math.round(vehicle.getPosition()[0]);
        int y = (int) Math.round(vehicle.getPosition()[1]);
        Point point = new Point(x,y);
        return point;
    }

    BufferedImage getImg () {
        return img;
    }
}
