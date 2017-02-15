import java.awt.*;

public abstract class Car extends Vehicle {
    protected int nrDoors; // Number of doors on the car
    protected Color color; // Color of the vehicle

    /**
     * Get the number of doors
     * @return number of doors
     */
    public int getNrDoors() {
        return nrDoors;
    }

    /**
     * Get the color of the car
     * @return car's color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Set the color of the car
     * @param clr new color
     */
    public void setColor(Color clr) {
        color = clr;
    }
}
