import java.awt.*;

public class Scania extends Truck {
    private Ramp flatbed;
    protected static final int maxAngle = 70;

    /**
     * Construct a new Scania instance
     */
    Scania() {
        nrDoors = 2;
        enginePower = 730;
        currentSpeed = 0;
        color = Color.blue;
        modelName = "Scania";
        stopEngine();

        flatbed = new Ramp(maxAngle);
    }

    @Override
    protected double speedFactor() {
        return 1.0;
    }

    /**
     * The Scania is able to move if the flatbed is closed
     *
     * @return Scania can move
     */
    @Override
    public boolean canMove() {
        return flatbed.isClosed();
    }

    /**
     * Gets the width of the Scania
     *
     * @return width of the Scania
     */
    @Override
    public int getWidth() {
        return 260;
    }

    /**
     * Gets the height of the Scania
     *
     * @return Height of the Scania
     */
    @Override
    public int getHeight() {
        return 320;
    }

    /**
     * Gets the depth of the Scania
     *
     * @return Depth of the Scania
     */
    @Override
    public int getDepth() {
        return 680;
    }

    /**
     * Get angle of flatbed.
     *
     * @return current angle
     */
    public int getFlatbedAngle() {
        return flatbed.getAngle();
    }

    /**
     * Raise the truck's flat bed.
     *
     * @param angle raise the flatbed by amount degrees.
     */
    public void raiseFlatBed(int angle) {
        flatbed.raise(angle);
    }

    /**
     * Lower the truck's flat bed.
     *
     * @param angle lower the flatbed by amount degrees.
     */
    public void lowerFlatBed(int angle) {
        flatbed.lower(angle);
    }
}
