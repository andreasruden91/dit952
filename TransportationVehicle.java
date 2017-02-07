import java.awt.*;

public abstract class TransportationVehicle implements Movable {
    // Movable data
    protected int currentDirection;
    protected double x;
    protected double y;
    // TransportationVehicle data
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the vehicle
    protected String modelName; // The vehicle model name

    /**
     * Construct a new TransportationVehicle.
     */
    public TransportationVehicle() {
        currentDirection = 0;
        x = 0;
        y = 0;
    }

    // Abstract methods
    protected abstract double speedFactor();

    /**
     * Get width in centimeters.
     * @return width in cm
     */
    public abstract int getWidth();

    /**
     * Get height in centimeters.
     * @return height in cm
     */
    public abstract int getHeight();

    /**
     * Get depth in centimeters.
     * @return length in cm
     */
    public abstract int getDepth();

    // Override this if movement is dependent on certain conditions.
    protected boolean canMove() { return true; }

    // Behaviors

    /**
     * Get the number of doors
     * @return number of doors
     */
    public int getNrDoors() {
        return nrDoors;
    }

    /**
     * Get the engine power
     * @return horse power (hk)
     */
    public double getEnginePower() {
        return enginePower;
    }

    /**
     * Get the current speed of the car
     * @return speed in (km/h)
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * Get the color of the car
     * @return car's color
     */
    public Color getColor() {
        return color;
    }

    public double[] getPosition() {
        double[] array = {x,y};
        return array;
    }

    public String getName() {
        return modelName;
    }

    /**
     * Set the color of the car
     * @param clr new color
     */
    public void setColor(Color clr) {
        color = clr;
    }

    /**
     * Starts the car's engine
     */
    public void startEngine() {
        currentSpeed = 0.1;
    }

    /**
     * Stops the car's engine
     */
    public void stopEngine() {
        currentSpeed = 0;
    }

    /**
     * Increase speed of TransportationVehicle.
     * @param amount speed increase
     */
    private void incrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    /**
     * Decrease speed of TransportationVehicle.
     * @param amount speed decrease
     */
    private void decrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    /**
     * Relocate the vehicle. An outside force (like a tornado or a transportation unit) relocated the vehicle.
     * @param newX our new X coordinate
     * @param newY our new Y coordinate
     */
    public void relocate(double newX, double newY) {
        x = newX;
        y = newY;
    }

    // Movable Interface Methods

    /**
     * Move the car in its current direction.
     */
    @Override
    public void move() {
        if (!canMove()) {
            return;
        }

        switch (currentDirection) {
            case 0: // 0 = North
                y += currentSpeed*durationOfMovement;
                break;
            case 1: // 1 = East
                x += currentSpeed*durationOfMovement;
                break;
            case 2: // 2 = South
                y -= currentSpeed*durationOfMovement;
                break;
            case 3: // 3 = West
                x -= currentSpeed*durationOfMovement;
                break;
        }
    }

    /**
     * Turn the car 90 degrees left.
     */
    @Override
    public void turnLeft() {
        currentDirection = (currentDirection-1) % 4;
        move();
    }

    /**
     * Turn the car 90 degrees right.
     */
    @Override
    public void turnRight() {
        currentDirection = (currentDirection+1) % 4;
        move();
    }

    /**
     * Get the distance between vehicles.
     * @param other the vehicle we're checking distance to
     * @return distance between vehicles
     */
    public double getDistance(TransportationVehicle other) {
        double dx = Math.pow(x - other.x, 2);
        double dy = Math.pow(y - other.y, 2);
        return Math.sqrt(dx + dy);
    }

    /**
     * Give gas, increasing the TransportationVehicle's speed
     * @param amount percentage of gas pressure (0..1)
     */
    public void gas(double amount) {
        if (!canMove()) {
            return;
        }

        if (amount > 0) {
            if (amount > 1)
                amount = 1;
            incrementSpeed(amount);
            currentSpeed = Math.min(currentSpeed, enginePower);
        }
    }

    /**
     * Slows down the car, decreasing its speed
     * @param amount percentage of break pressure (0..1)
     */
    public void brake(double amount){
        if (amount > 0) {
            if (amount > 1)
                amount = 1;
            decrementSpeed(amount);
            currentSpeed = Math.max(currentSpeed, 0);
        }
    }
}
