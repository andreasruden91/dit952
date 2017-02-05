import java.awt.*;

/**
 * A representation of a Volvo240
 */
public class Volvo240 extends TransportationVehicle {
    // State
    private final static double trimFactor = 1.25;

    /**
     * Construct a new Volvo240 instance
     */
    public Volvo240() {
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
    }

    @Override
    public int getWidth() { return 170; }
    @Override
    public int getHeight() { return 140; }
    @Override
    public int getDepth() { return 240; }

    @Override
    protected double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }
}
