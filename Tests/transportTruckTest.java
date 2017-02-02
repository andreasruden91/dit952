import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by BenJ on 2/1/17.
 */
public class transportTruckTest {
    transportTruck o = new transportTruck();

    @Test
    public void dropRamp() throws Exception {
        o.currentSpeed = 1;
        o.dropRamp();
        assertTrue(o.getRampStatus() == 0);
    }

    @Test
    public void loadUpACar() throws Exception {
        TransportationVehicle car = new Volvo240();
        o.loadUpACar(40, car);
        assertTrue(o.getStorageSize() == 0);

    }

    @Test
    public void loadDownLastCar() throws Exception {
        TransportationVehicle car1 = new Volvo240();
        TransportationVehicle car2 = new Saab95();
        o.dropRamp();
        o.loadUpACar(1,car1);
        o.loadUpACar(1, car2);
        o.loadDownLastCar(1, car1);
        assertTrue(o.getStorageSize() == 2);

    }

}