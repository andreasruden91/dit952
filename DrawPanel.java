import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.List;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    List<BufferedImage> vehicleImages;
    // To keep track of a singel cars position
    Point vehiclePoint = new Point();

    // TODO: Make this genereal for all cars
    void moveit(int x, int y, ArrayList<TransportationVehicle> vehicles){
        for (TransportationVehicle vehicle : vehicles) {
            vehicle.x = x;
            vehicle.y = y;
        }
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<TransportationVehicle> vehicles) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "src\\pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            // Linux users need to modify \ to / in path string
            for (TransportationVehicle vehicle : vehicles) {
                vehicleImages.add(ImageIO.read(
                        new File("src\\pics\\" + vehicle.getName())));
            }
        }catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (BufferedImage vehicleImage : vehicleImages) {
            g.drawImage(vehicleImage, vehiclePoint.x, vehiclePoint.y, null); // see javadoc for more info on the parameters
        }
    }
}
