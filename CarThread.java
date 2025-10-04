public class CarThread extends Thread {
    private ParkingLotSimulation parkingLot;
    private String carNumber;

    public CarThread(ParkingLotSimulation parkingLot, String carNumber) {
        this.parkingLot = parkingLot;
        this.carNumber = carNumber;
    }

    @Override
    public void run() {
        int slot = parkingLot.assignSlot(carNumber);
        if (slot != -1) {
            System.out.println(carNumber + " parked at slot " + slot);
        } else {
            System.out.println("No available parking for " + carNumber);
        }
    }
}