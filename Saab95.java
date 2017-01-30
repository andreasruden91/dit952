import java.awt.*;

/**
 * A representation of a Saab95
 */
public class Saab95 extends Car {
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

    // Behaviors

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
