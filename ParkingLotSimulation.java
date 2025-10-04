import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParkingLotSimulation {

    private List<ParkingSlot> slots = new ArrayList<>();

    public ParkingLotSimulation(int totalSlots) {
        for (int i = 1; i <= totalSlots; i++) {
            slots.add(new ParkingSlot(i));
        }
    }

    public synchronized int assignSlot(String carNumber) {
        for (ParkingSlot slot : slots) {
            if (!slot.isOccupied()) {
                slot.assignCar(carNumber);
                return slot.getSlotId();
            }
        }
        return -1; 
    }

    public synchronized boolean releaseSlot(int slotId) {
        for (ParkingSlot slot : slots) {
            if (slot.getSlotId() == slotId && slot.isOccupied()) {
                System.out.println(slot.getCarNumber() + " is leaving from slot " + slotId);
                slot.releaseCar();
                return true;
            }
        }
        return false;
    }
    public synchronized void printStatus() {
        System.out.println("\nCurrent Parking Status:");
        for (ParkingSlot slot : slots) {
            System.out.println("Slot " + slot.getSlotId() + " -> " +
                    (slot.isOccupied() ? "Occupied by " + slot.getCarNumber() : "Available"));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingLotSimulation parkingLot = new ParkingLotSimulation(10);
        System.out.println("Welcome to Smart Parking System!");
        parkingLot.printStatus();

        int carCounter = 1;

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Park a car");
            System.out.println("2. Show parking status");
            System.out.println("3. Remove a car manually");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter car number (or leave blank to auto-generate): ");
                    String carNumber = scanner.nextLine().trim();
                    if (carNumber.isEmpty()) {
                        carNumber = "CAR-" + carCounter++;
                    }
                    new CarThread(parkingLot, carNumber).start();
                    break;
                case 2:
                    parkingLot.printStatus();
                    break;
                case 3:
                    parkingLot.printStatus();
                    System.out.print("Enter slot number to remove car from: ");
                    int slotId = scanner.nextInt();
                    scanner.nextLine(); 
                    boolean removed = parkingLot.releaseSlot(slotId);
                    if (!removed) {
                        System.out.println("Invalid slot or already empty.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, 3, or 4.");
            }
        }
    }
}