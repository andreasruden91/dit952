import java.awt.*;

public class Ferry extends TransportationVehicle {
    protected Ramp r;
    protected Storage s;

    Ferry() {
        x = 0;
        y = 0;
        nrDoors = 2;
        enginePower = 1000;
        currentSpeed = 0;
        color = Color.red;
        modelName = "Ferry";

        r = new Ramp();
        s = new Storage(20);

        stopEngine();
    }

    @Override
    protected double speedFactor() {
        return 2;
    }

    public void dropRamp() {
        if (currentSpeed == 0) {
            r.rampLowered = true;
        }
    }

    public  void loadUpACar(TransportationVehicle car) {
        if (r.rampLowered && getDistance(car) <= r.loadDistance &&
                s.storage.size() < s.maxNumberOfSlots) {
            s.storage.add(car);
            car.x = this.x;
            car.y = this.y;
        }
    }

    public void loadDownFirstCar(TransportationVehicle car) {
        if (r.rampLowered && getDistance(car) <= r.loadDistance &&
                s.storage.get(0) == car) {
            s.storage.remove(0);
        }
    }
}
