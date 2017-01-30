/**
 * Interface of any type of movable object
 */
public interface Movable {
    public static final double durationOfMovement = 5;

    /**
     * Move the Movable object one step in its current direction.
     */
    public void move();

    /**
     * Rotate the Movable 90 degrees to the left
     */
    public void turnLeft();

    /**
     * Rotate the Movable 90 degrees to the right
     */
    public void turnRight();
}
