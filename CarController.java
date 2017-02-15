import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    private final int delay = 50;
    private Timer timer = new Timer(delay, new TimerListener());

    static CarView frame;
    static ArrayList<TransportationVehicle> vehicles = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
        cc.vehicles.add(new Volvo240());
        cc.vehicles.get(0).relocate(0, 0);

        cc.vehicles.add(new Scania());
        cc.vehicles.get(1).relocate(0, 200);

        cc.vehicles.add(new Saab95());
        cc.vehicles.get(2).relocate(0, 400);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < vehicles.size(); i++) {
                TransportationVehicle vehicle = vehicles.get(i);
                vehicle.move();
                int x = (int) Math.round(vehicle.getPosition()[0]);
                int y = (int) Math.round(vehicle.getPosition()[1]);
                if (x > frame.getWidth() * 0.85 || x < 0 || y < 0 || y > frame.getHeight() * 0.625) {
                    vehicle.reverseDirection();
                }
                frame.drawPanel.repaint();
            }
        }
    }

    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (TransportationVehicle vehicle : vehicles) {
            vehicle.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = (double) amount/2.0;
        for (TransportationVehicle vehicle : vehicles) {
            vehicle.brake(brake);
        }
    }

    void turboOn() {
        for (TransportationVehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (TransportationVehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOff();
            }
        }
    }

    void liftBed(int angle) {
        for (TransportationVehicle vehicle : vehicles) {
            if(vehicle instanceof Scania) {
                ((Scania) vehicle).raiseFlatBed(angle);
            }
        }
    }

    void lowerBed(int angle) {
        for (TransportationVehicle vehicle : vehicles) {
            if(vehicle instanceof Scania) {
                ((Scania) vehicle).lowerFlatBed(angle);
            }
        }
    }

    void startAll() {
        for (TransportationVehicle vehicle : vehicles) {
            vehicle.startEngine();
        }
    }

    void stopAll() {
        for (TransportationVehicle vehicle : vehicles) {
            vehicle.stopEngine();
        }
    }
}
