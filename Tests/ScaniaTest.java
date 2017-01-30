import static org.junit.Assert.*;

public class ScaniaTest {
    public static Scania scania = new Scania();

    @org.junit.Test
    public void testFlatBed() throws Exception {
        scania.raiseFlatBed(30);
        scania.raiseFlatBed(130); // Remains 30
        scania.lowerFlatBed(15); // angle == 15
        scania.gas(0.5);

        assertTrue(scania.getCurrentSpeed() == 0 &&
                scania.getFlatBedAngle() == 15);
    }
}