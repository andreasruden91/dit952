import java.awt.*;

public class TransportTruck extends TransportationVehicle {
    protected Ramp r;
    protected Storage s;

    TransportTruck(){
        x = 0;
        y = 0;
        nrDoors = 2;
        enginePower = 1000;
        currentSpeed = 0;
        color = Color.red;
        modelName = "Transport Truck";

        r = new Ramp();
        s = new Storage(5);

        stopEngine();
    }

    @Override
    protected double speedFactor() {
        return 1;
    }

    public void dropRamp() {
        if (currentSpeed == 0) {
            r.rampLowered = true;
        }
    }

    public void loadUpACar(TransportationVehicle car) {
        if (r.rampLowered && getDistance(car) <= r.loadDistance) {
            s.storage.add(car);
            car.x = this.x;
            car.y = this.y;
        }
    }

    public void loadDownLastCar (TransportationVehicle car) {
        if (r.rampLowered && getDistance(car) <= r.loadDistance &&
                s.storage.get(s.storage.size() - 1) == car) {
            s.storage.remove(s.storage.size() - 1);
        }
    }
}
