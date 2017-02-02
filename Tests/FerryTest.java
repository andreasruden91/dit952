import org.junit.Test;

import static org.junit.Assert.*;

public class FerryTest {
    Ferry o = new Ferry();

    @Test
    public void dropRamp() throws Exception {
        o.currentSpeed = 1;
        o.dropRamp();
        assertTrue(!o.isRampLowered());
    }

    @Test
    public void loadUpACar() throws Exception {
        TransportationVehicle car = new Volvo240();

        car.startEngine();
        for (int i = 0; i < 10; ++i) {
            car.gas(1);
        }
        car.move();
        car.stopEngine();

        o.dropRamp();
        o.loadUpACar(car);
        assertTrue(o.getStorageSize() == 0);
    }

    @Test
    public void loadDownFirstCar() throws Exception {
        TransportationVehicle car1 = new Volvo240();
        TransportationVehicle car2 = new Saab95();
        o.dropRamp();
        o.loadUpACar(car1);
        o.loadUpACar(car2);
        o.loadDownFirstCar(car2);
        assertTrue(o.getStorageSize() == 2);
    }
}
