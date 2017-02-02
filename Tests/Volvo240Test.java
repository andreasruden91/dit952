
import java.awt.*;

import static org.junit.Assert.*;

public class Volvo240Test {
    public static Volvo240 volvo = new Volvo240();

    @org.junit.Test
    public void getNrDoors() throws Exception {
        assertEquals(volvo.nrDoors, volvo.getNrDoors());
    }

    @org.junit.Test
    public void getEnginePower() throws Exception {
        assertEquals(volvo.enginePower, volvo.getEnginePower(), 0);
    }

    @org.junit.Test
    public void getCurrentSpeed() throws Exception {
        assertEquals(volvo.currentSpeed, volvo.getCurrentSpeed(), 0);
    }

    @org.junit.Test
    public void setGetColor() throws Exception {
        volvo.setColor(Color.cyan);
        assertEquals(volvo.getColor(), Color.cyan);
    }

    @org.junit.Test
    public void startStopEngine() throws Exception {
        volvo.startEngine();
        assertNotEquals(0, volvo.getCurrentSpeed(), 0);
        volvo.stopEngine();
        assertEquals(0, volvo.getCurrentSpeed(), 0);
    }

    @org.junit.Test
    public void gasBrake() throws Exception {
        volvo.startEngine();

        // Increment
        double speed = volvo.getCurrentSpeed();
        volvo.gas(1);
        assertTrue(volvo.getCurrentSpeed() > speed);
        // Decrement
        speed = volvo.getCurrentSpeed();
        volvo.brake(0.5);
        assertTrue(volvo.getCurrentSpeed() < speed);

        for (int i = 0; i < 200; ++i) {
            volvo.gas(i);
        }
        assertTrue(volvo.getCurrentSpeed() <= volvo.enginePower);

        volvo.stopEngine();
        volvo.startEngine();
        volvo.brake(1);
        assertTrue(volvo.getCurrentSpeed() == 0);
    }

    @org.junit.Test
    public void moveTurn() throws Exception {
        double x = volvo.x;
        double y = volvo.y;

        while (volvo.currentDirection != 0) {
            volvo.turnLeft();
        }

        volvo.startEngine();
        volvo.gas(1);

        volvo.move();
        assertTrue(volvo.y > y);
        volvo.turnRight();
        volvo.move();
        assertTrue(volvo.x > x);
    }
}
