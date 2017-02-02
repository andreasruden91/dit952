import java.awt.*;
import java.util.List;

/**
 * Created by BenJ on 2/1/17.
 */
public class transportTruck extends TransportationVehicle {
    private List<TransportationVehicle> storage;
    private int maxNumberOfSlots = 5;
    private int[] maxInputSize = {200, 200, 150}; // dimensions: width, height and depth
    private int rampStatus = 0; // 0 = undropped, 1 = dropped

    transportTruck(){
        x = 0;
        y = 0;
        nrDoors = 2;
        enginePower = 1000;
        currentSpeed = 0;
        color = Color.red;
        modelName = "Transport Truck";
        stopEngine();
    }

    @Override
    protected double speedFactor() {
        return 0;
    }

    protected void dropRamp() {
        if (currentSpeed == 0) {
            rampStatus = 1;
        }
    }

    protected int getRampStatus() {
        return rampStatus;
    }

    protected  void loadUpACar (int distanceInBetween, TransportationVehicle car) {
        if(rampStatus == 1 && distanceInBetween <= 30) {
            storage.add(car);
            car.x = this.x;
            car.y = this.y;
        }
    }

    protected void loadDownLastCar (int distance, TransportationVehicle car) {
        if(rampStatus == 1 && distance <= 30 && storage.get(storage.size() -1) == car) {
            storage.remove(storage.size()-1);
        }
    }

    protected int getStorageSize(){
        return storage.size();
    }



}
