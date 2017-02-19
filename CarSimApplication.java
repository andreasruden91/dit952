public class CarSimApplication {

    public static void main(String[] args) {
        CarView view = new CarView("CarSim 1.0");
        CarController controller = new CarController(view);

        controller.addVehicle(new Volvo240(), 0, 0);
        controller.addVehicle(new Scania(), 0, 200);
        controller.addVehicle(new Saab95(), 0, 400);

        controller.run();
    }
}
