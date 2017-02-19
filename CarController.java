import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController implements EventHandlerInterface {
    private final int delay = 50;
    private Timer timer = new Timer(delay, new TimerListener());

    ViewInterface view;
    ArrayList<Vehicle> vehicles = new ArrayList<>();

    // Constructor:
    CarController(ViewInterface view) {
        view.registerEventHandler(this);
        this.view = view;
    }

    public void run() {
        timer.start();
    }

    public void addVehicle(Vehicle vehicle, float x, float y) {
        vehicle.relocate(x, y);
        vehicles.add(vehicle);
        view.addVehicle(vehicle);
    }

    @Override
    public void onGas(double amount) {
        for (Vehicle vehicle : vehicles) {
            vehicle.gas(amount);
        }
    }

    @Override
    public void onBrake(double amount) {
        for (Vehicle vehicle : vehicles) {
            vehicle.brake(amount);
        }
    }

    @Override
    public void onFlatbedToggle(boolean lifted) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Scania) {
                if (lifted) {
                    ((Scania) vehicle).raiseFlatBed(Scania.maxAngle);
                } else {
                    ((Scania) vehicle).lowerFlatBed(Scania.maxAngle);
                }
            }
        }
    }

    @Override
    public void onEngineToggle(boolean start) {
        for (Vehicle vehicle : vehicles) {
            if (start) {
                vehicle.startEngine();
            } else {
                vehicle.stopEngine();
            }
        }
    }

    @Override
    public void onTurboToggle(boolean turbo) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95) {
                if (turbo) {
                    ((Saab95) vehicle).setTurboOn();
                } else {
                    ((Saab95) vehicle).setTurboOff();
                }
            }
        }
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < vehicles.size(); i++) {
                Vehicle vehicle = vehicles.get(i);
                vehicle.move();
                int x = (int) Math.round(vehicle.getPosition()[0]);
                int y = (int) Math.round(vehicle.getPosition()[1]);
                if (x > view.getWorldWidth() || x < 0 || y < 0 || y > view.getWorldHeight()) {
                    vehicle.reverseDirection();
                }
                view.renderWorld();
            }
        }
    }
}
