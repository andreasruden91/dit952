public class Ferry extends Boat {
    protected StorageUnit storage;

    Ferry() {
        x = 0;
        y = 0;
        enginePower = 1000;
        currentSpeed = 0;
        modelName = "Ferry";

        storage = new StorageUnit(this, 20);

        stopEngine();
    }

    /**
     * Gets the width of the Ferry
     *
     * @return width of Ferry
     */
    @Override
    public int getWidth() {
        return 16000;
    }

    /**
     * Gets the height of the Ferry
     *
     * @return height of Ferry
     */
    @Override
    public int getHeight() {
        return 4000;
    }

    /**
     * Gets the depth of the Ferry
     *
     * @return depth of Ferry
     */
    @Override
    public int getDepth() {
        return 24000;
    }

    @Override
    protected double speedFactor() {
        return 10;
    }

    /**
     * Ferry is eligible to move if ramp is closed
     *
     * @return Ferry can move
     */
    @Override
    public boolean canMove() {
        return storage.isRampClosed();
    }

    /**
     * Move ferry.
     */
    @Override
    public void move() {
        super.move();
        storage.onMovement();
    }

    /**
     * Can drop the ramp if the Ferry is on standby
     */
    public void dropRamp() {
        if (currentSpeed == 0) {
            storage.dropRamp();
        }
    }

    /**
     * Can raise the ramp if the Ferry is on standby
     */
    public void raiseRamp() {
        if (currentSpeed == 0) {
            storage.raiseRamp();
        }
    }
    //Storage has a inbuilt ramp

    /**
     * Loads vehicle on to the Ferry if ramp is down
     *
     * @param vehicle loads onto the Ferry
     */
    public void loadVehicle(Vehicle vehicle) {
        storage.addVehicle(vehicle);
    }

    /**
     * unloads the first vehicle if ramp is down
     *
     * @return unload first vehicle from Ferry
     */
    public Vehicle unloadFirstVehicle() {
        return storage.removeVehicleFront();
    }
}
