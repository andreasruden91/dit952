public interface ViewInterface {
    void registerEventHandler(EventHandlerInterface handler);

    float getWorldHeight();

    float getWorldWidth();

    void renderWorld();

    void addVehicle(Vehicle vehicle);

    void removeVehicle(int n);
}
