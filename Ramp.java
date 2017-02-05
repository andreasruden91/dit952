/**
 * A generic Ramp class with controls to lower and raise the ramp.
 */
public class Ramp {
    private final int maxAngle;
    private final double loadDistance;
    private int angle;

    /**
     * Construct a new Ramp. A Ramp's angle can be in the span [0, maxAngle].
     * A ramp is in its "closed" position when the angle==0, and in its fully
     * "open"/"lowered" position when angle==maxAngle.
     * @param maxAngle the maximum angle the ramp can be lowered
     */
    public Ramp(int maxAngle) {
        this.maxAngle = maxAngle;
        loadDistance = 30;
    }

    /**
     * Is the ramp fully lowered?
     * @return true if the lamp is fully lowered
     */
    public boolean isOpen() {
        return angle == maxAngle;
    }

    /**
     * Is the ramp fully raised?
     * @return true if the lamp is fully raised
     */
    public boolean isClosed() {
        return angle == 0;
    }

    /**
     * Get ramp's angle.
     * @return current angle
     */
    public int getAngle() { return angle; }

    /**
     * Get ramp's effective load distance.
     * @return distance at which objects can be loaded onto ramp
     */
    public double getLoadDistance() {
        return loadDistance;
    }

    /**
     * Lower ramp.
     * @param angle lower ramp by this much (>0)
     */
    public void lower(int angle) {
        if (angle > 0 && this.angle + angle <= maxAngle) {
            this.angle += angle;
        }
    }

    /**
     * Raise ramp.
     * @param angle raise ramp by this much (>0)
     */
    public void raise(int angle) {
        if (angle > 0 && this.angle - angle >= 0) {
            this.angle -= angle;
        }
    }
}
