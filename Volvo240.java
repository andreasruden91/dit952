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
    public Volvo240() {
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
    }

    // Behaviors
    @Override
    protected double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }
}
