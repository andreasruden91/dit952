import org.junit.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import static org.junit.Assert.*;

public class TransportTruckTest {
    TransportTruck o = new TransportTruck();

    @Test
    public void dropRamp() throws Exception {
        o.currentSpeed = 1;
        o.dropRamp();
        assertTrue(!o.r.rampLowered);
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
        assertTrue(o.s.getStorageSize() == 0);
    }

    @Test
    public void loadDownLastCar() throws Exception {
        TransportationVehicle car1 = new Volvo240();
        TransportationVehicle car2 = new Saab95();
        o.dropRamp();
        o.loadUpACar(car1);
        o.loadUpACar(car2);
        o.loadDownLastCar(car1);
        assertTrue(o.s.getStorageSize() == 2);
    }
}
