/**
 * Created by BenJ on 2017-02-02.
 */
public class Ramp {
    private boolean rampLowered;
    private double loadDistance;



    public Ramp() {
        rampLowered = false;
        loadDistance = 30;
    }

    public boolean isRampLowered() {
        return rampLowered;
    }

    public double getLoadDisttance() {
        return loadDistance;
    }

    public void lowerRamp() {
        rampLowered = true;
    }

    public void raiseRamp() {
        rampLowered = false;
    }

}
