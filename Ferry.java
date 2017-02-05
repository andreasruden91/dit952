import java.awt.*;

public class Ferry extends TransportationVehicle {
    private final int maxRampAngle = 130;
    protected Ramp ramp;
    protected Storage s;

    Ferry() {
        x = 0;
        y = 0;
        nrDoors = 2;
        enginePower = 1000;
        currentSpeed = 0;
        color = Color.red;
        modelName = "Ferry";

        ramp = new Ramp(maxRampAngle);
        s = new Storage(20);

        stopEngine();
    }

    @Override
    protected double speedFactor() {
        return 10;
    }

    @Override
    public boolean canMove() { return ramp.isClosed(); }

    public boolean isRampLowered() {
        return ramp.isOpen();
    }

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

    public int getStorageSize() {
        return s.getStorageSize();
    }

    public void loadUpACar(TransportationVehicle car) {
        if (ramp.isOpen() && getDistance(car) <= ramp.getLoadDistance()) {
            s.addACar(car);
            car.x = this.x;
            car.y = this.y;
        }
    }

    public void loadDownFirstCar(TransportationVehicle car) {
        if (ramp.isOpen() && getDistance(car) <= ramp.getLoadDistance() &&
                s.identityOfFirstCar() == car) {
            s.removeCar("first");
        }
    }
}
