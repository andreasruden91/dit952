import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TransportTruck extends TransportationVehicle {
    private VehicleTransportationUnit storage;

    TransportTruck(){
        x = 0;
        y = 0;
        nrDoors = 2;
        enginePower = 1000;
        currentSpeed = 0;
        color = Color.red;
        modelName = "Transport Truck";

        storage = new VehicleTransportationUnit(this, 5);

        stopEngine();
    }

    @Override
    public int getWidth() { return 260; }
    @Override
    public int getHeight() { return 320; }
    @Override
    public int getDepth() { return 680; }

    @Override
    protected double speedFactor() {
        return 1;
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

    public TransportationVehicle unloadLastVehicle() { return storage.removeVehicleBack(); }
}
