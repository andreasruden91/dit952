import java.awt.*;

public class Scania extends Car {
    Scania() {
        nrDoors = 2;
        enginePower = 730;
        currentSpeed = 0;
        color = Color.blue;
        modelName = "Scania R 730 V8";
        stopEngine();

        flatBedAngle = 0;
    }

    @Override
    protected double speedFactor() {
        if (flatBedAngle > 0) {
            return 0.0;
        }
        return 1.0;
    }

    private int flatBedAngle; // degrees [0, 70]

    /**
     * Get the flatbed's current angle.
     * @return current angle of flatbed
     */
    public double getFlatBedAngle() { return flatBedAngle; }

    /**
     * Raise the truck's flat bed.
     * @param angle raise the flatbed by amount degrees.
     */
    public void raiseFlatBed(int angle) {
        if (angle > 0 && flatBedAngle + angle <= 70 &&
                getCurrentSpeed() == 0) {
            flatBedAngle += angle;
        }
    }

    /**
     * Lower the truck's flat bed.
     * @param angle lower the flatbed by amount degrees.
     */
    public void lowerFlatBed(int angle) {
        if (angle > 0 && flatBedAngle - angle >= 0) {
            flatBedAngle -= angle;
        }
    }
}
