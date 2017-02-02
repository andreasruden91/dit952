import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Ferry extends TransportationVehicle {
    private final int maxNumberOfSlots = 5;
    private final int[] maxInputSize = {200, 200, 150}; // dimensions: width, height and depth
    private final double loadDistance = 30;

    private List<TransportationVehicle> storage;
    private boolean rampLowered;

    Ferry() {
        x = 0;
        y = 0;
        nrDoors = 2;
        enginePower = 1000;
        currentSpeed = 0;
        color = Color.red;
        modelName = "Ferry";

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

    public boolean isRampLowered() { return rampLowered; }

    public  void loadUpACar(TransportationVehicle car) {
        if (rampLowered && getDistance(car) <= loadDistance &&
                storage.size() < maxNumberOfSlots) {
            storage.add(car);
            car.x = this.x;
            car.y = this.y;
        }
    }

    public void loadDownFirstCar(TransportationVehicle car) {
        if (rampLowered && getDistance(car) <= loadDistance &&
                storage.get(0) == car) {
            storage.remove(0);
        }
    }

    public int getStorageSize(){
        return storage.size();
    }
}
