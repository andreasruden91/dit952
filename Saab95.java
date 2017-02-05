import java.awt.*;

/**
 * A representation of a Saab95
 */
public class Saab95 extends TransportationVehicle {
    // State
    private boolean turboOn;

    /**
     * Construct a new Saab95 instance
     */
    public Saab95() {
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        turboOn = false;
        modelName = "Saab95";
        stopEngine();
    }

    @Override
    public int getWidth() { return 170; }
    @Override
    public int getHeight() { return 140; }
    @Override
    public int getDepth() { return 240; }

    /**
     * Activate the Saab's turbo function
     */
    public void setTurboOn(){
        turboOn = true;
    }

    /**
     * Turn off the Saab's turbo function
     */
    public void setTurboOff(){
        turboOn = false;
    }

    @Override
    protected double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
}
