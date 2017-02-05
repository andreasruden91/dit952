import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TransportTruck extends TransportationVehicle {
    private final int maxNumberOfSlots = 5;
    private final int[] maxInputSize = {200, 200, 150}; // dimensions: width, height and depth
    private final double loadDistance = 30;

    private List<TransportationVehicle> storage;
    private boolean rampLowered;

    TransportTruck(){
        x = 0;
        y = 0;
        nrDoors = 2;
        enginePower = 1000;
        currentSpeed = 0;
        color = Color.red;
        modelName = "Transport Truck";

        storage = new ArrayList<>();
        rampLowered = false;

        stopEngine();
    }

    @Override
    protected double speedFactor() {
        return 1;
    }

    public void dropRamp() {
        if (currentSpeed == 0) {
            rampLowered = true;
        }
    }

    public boolean isRampLowered() {
        return rampLowered;
    }

    public void loadUpACar(TransportationVehicle car) {
        if (rampLowered && getDistance(car) <= loadDistance) {
            storage.add(car);
            car.x = this.x;
            car.y = this.y;
        }
    }

    public void loadDownLastCar (TransportationVehicle car) {
        if (rampLowered && getDistance(car) <= loadDistance &&
                storage.get(storage.size() - 1) == car) {
            storage.remove(storage.size() - 1);
        }
    }

    public int getStorageSize(){
        return storage.size();
    }
}
