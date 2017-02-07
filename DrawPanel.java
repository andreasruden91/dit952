import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    BufferedImage vehicleImage;
    // To keep track of a singel cars position
    Point vehiclePoint = new Point();

    // TODO: Make this genereal for all cars
    void moveit(int x, int y, TransportationVehicle car){
        car.x = x;
        car.y = y;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, TransportationVehicle car) {
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
            String fileName = car.getName() + ".jpg";
            vehicleImage = ImageIO.read(new File("src\\pics\\" + fileName));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(vehicleImage, vehiclePoint.x, vehiclePoint.y, null); // see javadoc for more info on the parameters
    }
}
