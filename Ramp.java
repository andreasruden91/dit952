/**
 * Created by BenJ on 2017-02-02.
 */
public class Ramp {
    protected boolean rampLowered;
    protected double loadDistance;



    public Ramp() {
        rampLowered = false;
        loadDistance = 30;
    }

    public boolean isRampLowered() {
        return rampLowered;
    }
}
