import java.awt.*;

public class Ferry extends TransportationVehicle {
    protected VehicleTransportationUnit storage;

    Ferry() {
        x = 0;
        y = 0;
        nrDoors = 2;
        enginePower = 1000;
        currentSpeed = 0;
        color = Color.red;
        modelName = "Ferry";

        storage = new VehicleTransportationUnit(this, 20);

        stopEngine();
    }

    @Override
    public int getWidth() { return 16000; }
    @Override
    public int getHeight() { return 4000; }
    @Override
    public int getDepth() { return 24000; }

    @Override
    protected double speedFactor() {
        return 10;
    }

    @Override
    public boolean canMove() { return storage.isRampClosed(); }

    public void dropRamp() {
        if (currentSpeed == 0) {
            storage.dropRamp();
        }
    }

    public void raiseRamp() {
        if (currentSpeed == 0) {
            storage.raiseRamp();
        }
    }

    public void loadVehicle(TransportationVehicle vehicle) { storage.addVehicle(vehicle); }

    public TransportationVehicle unloadFirstVehicle() { return storage.removeVehicleFront(); }
}
