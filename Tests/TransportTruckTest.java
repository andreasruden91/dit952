import org.junit.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import static org.junit.Assert.*;

public class TransportTruckTest {
    TransportTruck truck = new TransportTruck();

    @Test
    public void loadVehicleTest() throws Exception {
        TransportationVehicle car = new Volvo240();
        truck.dropRamp();
        truck.loadVehicle(car);
        assertTrue(truck.unloadLastVehicle() == car);
    }

    @Test
    public void tooBigVehicleTest() throws Exception {
        TransportationVehicle car = new TransportTruck();
        truck.dropRamp();
        truck.loadVehicle(car);
        assertTrue(truck.unloadLastVehicle() == null);
    }

    @Test
    public void multipleVehiclesLIFOTest() throws Exception {
        TransportationVehicle car1 = new Volvo240();
        TransportationVehicle car2 = new Saab95();
        TransportationVehicle car3 = new Saab95();
        truck.dropRamp();
        truck.loadVehicle(car1);
        truck.loadVehicle(car2);
        truck.loadVehicle(car3);
        assertTrue(truck.unloadLastVehicle() == car3);
    }

    @Test
    public void rampStatusLoadingTest() throws Exception {
        TransportationVehicle car1 = new Volvo240();
        TransportationVehicle car2 = new Saab95();

        truck.dropRamp();
        truck.loadVehicle(car1);
        truck.raiseRamp();
        truck.loadVehicle(car2);
        truck.dropRamp();
        assertTrue(truck.unloadLastVehicle() == car1);
    }

    @Test
    public void loadingSameVehicleTest() throws Exception {
        TransportationVehicle car1 = new Volvo240();
        TransportationVehicle car2 = new Saab95();

        truck.dropRamp();
        truck.loadVehicle(car1);
        truck.loadVehicle(car2);
        truck.loadVehicle(car1);
        assertTrue(truck.unloadLastVehicle() == car2);
    }
}
