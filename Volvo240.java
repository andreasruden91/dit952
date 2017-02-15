import java.awt.*;

/**
 * A representation of a Volvo240
 */
public class Volvo240 extends Car {
    // State
    private final static double trimFactor = 1.25;

    /**
     * Construct a new Volvo240 instance
     */
    Volvo240() {
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
    }

    /**
     * Gets the width of the Volvo240
     * @return width of the Volvo240
     */
    @Override
    public int getWidth() { return 170; }
    /**
     * Gets the height of the Volvo240
     * @return Height of the Volvo240
     */
    @Override
    public int getHeight() { return 140; }
    /**
     * Gets the Depth of the Volvo240
     * @return Depth of the Volvo240
     */
    @Override
    public int getDepth() { return 240; }

    @Override
    protected double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }
}
