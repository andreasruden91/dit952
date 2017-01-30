import org.testng.annotations.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class Saab95Test {
    public static Saab95 saab = new Saab95();

    @org.junit.Test
    public void getNrDoors() throws Exception {
        assertEquals(saab.nrDoors, saab.getNrDoors());
    }

    @org.junit.Test
    public void getEnginePower() throws Exception {
        assertEquals(saab.enginePower, saab.getEnginePower(), 0);
    }

    @org.junit.Test
    public void getCurrentSpeed() throws Exception {
        assertEquals(saab.currentSpeed, saab.getCurrentSpeed(), 0);
    }

    @org.junit.Test
    public void setGetColor() throws Exception {
        saab.setColor(Color.cyan);
        assertEquals(saab.getColor(), Color.cyan);
    }

    @org.junit.Test
    public void startStopEngine() throws Exception {
        saab.startEngine();
        assertNotEquals(0, saab.getCurrentSpeed(), 0);
        saab.stopEngine();
        assertEquals(0, saab.getCurrentSpeed(), 0);
    }

    @org.junit.Test
    public void gasBrake() throws Exception {
        saab.startEngine();

        // Increment
        double speed = saab.getCurrentSpeed();
        saab.gas(1);
        assertTrue(saab.getCurrentSpeed() > speed);
        // Decrement
        speed = saab.getCurrentSpeed();
        saab.brake(0.5);
        assertTrue(saab.getCurrentSpeed() < speed);

        for (int i = 0; i < 200; ++i) {
            saab.gas(i);
        }
        assertTrue(saab.getCurrentSpeed() <= saab.enginePower);

        saab.stopEngine();
        saab.startEngine();
        saab.brake(1);
        assertTrue(saab.getCurrentSpeed() == 0);
    }

    @org.junit.Test
    public void moveTurn() throws Exception {
        double x = saab.x;
        double y = saab.y;

        while (saab.currentDirection != 0) {
            saab.turnLeft();
        }

        saab.startEngine();
        saab.gas(1);

        saab.move();
        assertTrue(saab.y > y);
        saab.turnRight();
        saab.move();
        assertTrue(saab.x > x);
    }

    @org.junit.Test
    public void turboOnOff() throws Exception {
        // With turbo
        saab.startEngine();
        saab.setTurboOn();
        saab.gas(1);
        double withTurbo = saab.getCurrentSpeed();

        // Without turbo
        saab.stopEngine();
        saab.startEngine();
        saab.setTurboOff();
        saab.gas(1);
        assertTrue(withTurbo > saab.getCurrentSpeed());
    }
}
