import java.util.ArrayList;
import java.util.List;


public class Storage {
    protected List<TransportationVehicle> storage;
    protected int maxNumberOfSlots;
    protected static final int[] maxInputSize = {200, 200, 150}; // dimensions: width, height and depth

    public Storage(int maxNumberOfSlots) {
        this.maxNumberOfSlots = maxNumberOfSlots;
        this.storage = new ArrayList<>();
    }

    public int getStorageSize(){
        return storage.size();
    }
}
