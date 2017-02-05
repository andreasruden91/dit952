import java.awt.*;

public class Scania extends TransportationVehicle {
    private Ramp flatbed;

    Scania() {
        nrDoors = 2;
        enginePower = 730;
        currentSpeed = 0;
        color = Color.blue;
            modelName = "Scania R 730 V8";
        stopEngine();

        flatbed = new Ramp(70);
    }

    @Override
    protected double speedFactor() { return 1.0; }

    @Override
    public boolean canMove() { return flatbed.isClosed(); }

    @Override
    public int getWidth() { return 260; }
    @Override
    public int getHeight() { return 320; }
    @Override
    public int getDepth() { return 680; }

    /**
     * Get angle of flatbed.
     * @return current angle
     */
    public int getFlatbedAngle() { return flatbed.getAngle(); }

    /**
     * Raise the truck's flat bed.
     * @param angle raise the flatbed by amount degrees.
     */
    public void raiseFlatBed(int angle) { flatbed.raise(angle); }

    /**
     * Lower the truck's flat bed.
     * @param angle lower the flatbed by amount degrees.
     */
    public void lowerFlatBed(int angle) { flatbed.lower(angle); }
}
