import java.util.ArrayList;
import java.util.List;


public class Storage {
    private List<TransportationVehicle> storage;
    private int maxNumberOfSlots;
    private static final int[] maxInputSize = {200, 200, 150}; // dimensions: width, height and depth

    public Storage(int maxNumberOfSlots) {
        this.maxNumberOfSlots = maxNumberOfSlots;
        this.storage = new ArrayList<>();
    }

    public void addACar(TransportationVehicle car) {
        storage.add(car);
    }

    public int getStorageSize(){
        return storage.size();
    }

    public TransportationVehicle identityOfLastCar() {
        return storage.get(this.getStorageSize() - 1);
    }

    public TransportationVehicle identityOfFirstCar () {
        return storage.get(0);
    }

    public void removeCar(String s) {
        switch (s) {
            case "first":
                storage.remove(0);
                break;
            case "last":
                storage.remove(this.getStorageSize()-1);
                break;
        }

    }

    public boolean acceptedSize(int width, int height, int depth) {
        boolean b0 = width  == maxInputSize[0];
        boolean b1 = height == maxInputSize[1];
        boolean b2 = depth  == maxInputSize[2];

        return b1 && b2 && b0;
    }
}
