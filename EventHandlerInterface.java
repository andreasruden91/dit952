public interface EventHandlerInterface {
    void onGas(double amount);

    void onBrake(double amount);

    void onFlatbedToggle(boolean lifted);

    void onEngineToggle(boolean start);

    void onTurboToggle(boolean turbo);
}
