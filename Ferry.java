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
        return 10;
    }

    @Override
    public void move() {
        if (!this.r.isRampLowered())
            super.move();
    }

    public boolean isRamplowered() {
        return r.isRampLowered();
    }

    public void dropRamp() {
        if (currentSpeed == 0) {
            r.lowerRamp();
        }
    }

    public void raiseRamp() {
        if (currentSpeed == 0) {
            r.raiseRamp();
        }
    }

    public int getStorageSize() {
        return s.getStorageSize();
    }

    public void loadUpACar(TransportationVehicle car) {
        if (r.isRampLowered() && getDistance(car) <= r.getLoadDisttance()) {
            s.addACar(car);
            car.x = this.x;
            car.y = this.y;
        }
    }

    public void loadDownFirstCar(TransportationVehicle car) {
        if (r.isRampLowered() && getDistance(car) <= r.getLoadDisttance() &&
                s.identityOfFirstCar() == car) {
            s.removeCar("first");
        }
    }
}
