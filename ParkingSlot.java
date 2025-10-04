public class ParkingSlot {
    private int slotId;
    private boolean isOccupied;
    private String carNumber;

    public ParkingSlot(int slotId) {
        this.slotId = slotId;
        this.isOccupied = false;
        this.carNumber = null;
    }

    public int getSlotId() {
        return slotId;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void assignCar(String carNumber) {
        this.carNumber = carNumber;
        this.isOccupied = true;
    }

    public void releaseCar() {
        this.carNumber = null;
        this.isOccupied = false;
    }

    public String getCarNumber() {
        return carNumber;
    }
}