import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    List<VehicleGFX> GFXs = new ArrayList<>();

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.WHITE);

    }
    public void addVehicle(Vehicle vehicle) {
        VehicleGFX gfx = new VehicleGFX(vehicle);
        GFXs.add(gfx);
    }
    public void removeVehicle(int n) {
        GFXs.remove(n);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (VehicleGFX gfx : GFXs) {
            BufferedImage img = gfx.getImg();
            Point vehiclePoint = gfx.getPoint();
            g.drawImage(img, vehiclePoint.x, vehiclePoint.y, null); // see javadoc for more info on the parameters
        }
    }
}
