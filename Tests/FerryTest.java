import org.junit.Test;

import static org.junit.Assert.*;

public class FerryTest {
    Ferry ferry = new Ferry();

    @Test
    public void multipleVehiclesFIFOTest() throws Exception {
        TransportationVehicle car1 = new Volvo240();
        TransportationVehicle car2 = new Saab95();
        TransportationVehicle car3 = new Saab95();
        ferry.dropRamp();
        ferry.loadVehicle(car1);
        ferry.loadVehicle(car2);
        ferry.loadVehicle(car3);
        assertTrue(ferry.unloadFirstVehicle() == car1);
    }

    @Test
    public void moveRampOpenTest() throws Exception {
        double x = ferry.x;
        double y = ferry.y;
        ferry.dropRamp();
        ferry.startEngine();
        ferry.gas(2);
        ferry.move();
        assertTrue(ferry.x == x && ferry.y == y);
    }
}
