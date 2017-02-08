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
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    static ArrayList<TransportationVehicle> vehicles = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.vehicles.add(new Volvo240());
        cc.vehicles.add(new Scania());
        cc.vehicles.add(new Saab95());

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (TransportationVehicle vehicle : vehicles) {
                vehicle.move();
                int x = (int) Math.round(vehicle.getPosition()[0]);
                int y = (int) Math.round(vehicle.getPosition()[1]);
                frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    //TODO
    // Calls the gas method for each car once
    ArrayList<TransportationVehicle> getList() {
        return vehicles;
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
            vehicle.brake(amount);
        }
    }

    void turboOn() {
        for (TransportationVehicle vehicle : vehicles) {
            if (vehicle.getName().equals("Saab95")) {
                ((Saab95) vehicle).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (TransportationVehicle vehicle : vehicles) {
            if (vehicle.getName().equals("Saab95")) {
                ((Saab95) vehicle).setTurboOff();
            }
        }
    }

    void liftBed(int angle) {
        for (TransportationVehicle vechicle : vehicles) {
            if(vechicle.getName().equals("Scania")) {
                ((Scania) vechicle).raiseFlatBed(angle);
            }
        }
    }

    void lowerBed(int angle) {
        for (TransportationVehicle vechicle : vehicles) {
            if(vechicle.getName().equals("Scania")) {
                ((Scania) vechicle).lowerFlatBed(angle);
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
