import java.util.ArrayList;
import java.util.List;

/**
 * A storage unit that has a retractable Ramp where vehicles can be loaded onto
 * the storage unit, and then be transported along a secondary vehicle which
 * the storage unit is mounted on.
 */
public class StorageUnit {
    private static final int[] maxInputSize = {200, 200, 300}; // Width, Height, Depth
    private static int maxRampAngle = 130;

    private final int maxNumberOfSlots;
    private List<Vehicle> storage;
    private Ramp ramp;
    private Vehicle attachedTo;

    public StorageUnit(Vehicle attachedTo, int slots) {
        maxNumberOfSlots = slots;
        storage = new ArrayList<>();
        ramp = new Ramp(maxRampAngle);
        this.attachedTo = attachedTo;
    }

    /**
     * Callback when the vehicle this transportation unit is attached to moves.
     */
    protected void onMovement() {
        for (int i = 0; i < storage.size(); ++i) {
            storage.get(i).relocate(attachedTo.x, attachedTo.y);
        }
    }

    /**
     * Drop the ramp.
     */
    public void dropRamp() { ramp.lower(maxRampAngle); }

    /**
     * Raise the ramp.
     */
    public void raiseRamp() { ramp.raise(maxRampAngle); }

    /**
     * Is the ramp closed?
     */
    public boolean isRampClosed() { return ramp.isClosed(); }

    /**
     * Add a vehicle to the back of the transportation unit.
     * @param vehicle the vehicle to add
     */
    public void addVehicle(Vehicle vehicle) {
        if (ramp.isOpen() && acceptableDimensions(vehicle) &&
                attachedTo.getDistance(vehicle) <= ramp.getLoadDistance() &&
                !storage.contains(vehicle)) {
            vehicle.relocate(attachedTo.x, attachedTo.y);
            storage.add(vehicle);
        }
    }

    /**
     * Get the vehicle at the front of the transportation unit (first in first out)
     * @return vehicle that's been the longest time on the unit, or null if no vehicle could be retrieved
     */
    public Vehicle removeVehicleFront() {
        if (ramp.isOpen() && !storage.isEmpty()) {
            return storage.remove(0);
        }
        return null;
    }

    /**
     * Get the vehicle at the front of the transportation unit (last in first out)
     * @return vehicle that's been the shortest time on the unit, or null if no vehicle could be retrieved
     */
    public Vehicle removeVehicleBack() {
        if (ramp.isOpen() && !storage.isEmpty()) {
            return storage.remove(storage.size() - 1);
        }
        return null;
    }

    private boolean acceptableDimensions(Vehicle vehicle) {
        return vehicle.getWidth() <= maxInputSize[0] &&
                vehicle.getHeight() <= maxInputSize[1] &&
                vehicle.getDepth() <= maxInputSize[2];
    }
}
