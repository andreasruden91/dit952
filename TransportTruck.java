import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TransportTruck extends TransportationVehicle {
    private final int maxNumberOfSlots = 5;
    private final int[] maxInputSize = {200, 200, 150}; // dimensions: width, height and depth
    private final int maxRampAngle = 130;

    private List<TransportationVehicle> storage;
    Ramp ramp;

    TransportTruck(){
        x = 0;
        y = 0;
        nrDoors = 2;
        enginePower = 1000;
        currentSpeed = 0;
        color = Color.red;
        modelName = "Transport Truck";

        storage = new ArrayList<>();
        ramp = new Ramp(maxRampAngle);

        stopEngine();
    }

    @Override
    protected double speedFactor() {
        return 1;
    }

    @Override
    public boolean canMove() { return ramp.isClosed(); }

    public void dropRamp() {
        if (currentSpeed == 0) {
            ramp.lower(maxRampAngle);
        }
    }

    public void raiseRamp() {
        if (currentSpeed == 0) {
            ramp.raise(maxRampAngle);
        }
    }

    public boolean isRampLowered() {
        return ramp.isOpen();
    }

    public void loadUpACar(TransportationVehicle car) {
        if (ramp.isOpen() && getDistance(car) <= ramp.getLoadDistance()) {
            storage.add(car);
            car.x = this.x;
            car.y = this.y;
        }
    }

    public void loadDownLastCar (TransportationVehicle car) {
        if (ramp.isOpen() && getDistance(car) <= ramp.getLoadDistance() &&
                storage.get(storage.size() - 1) == car) {
            storage.remove(storage.size() - 1);
        }
    }

    public int getStorageSize(){
        return storage.size();
    }
}
