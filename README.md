# Smart Parking System

This is a simple Java program that simulates a smart parking system.  
It lets you park cars, remove them, and see which slots are free or occupied.

---

## How it works
- You can park a car (it will get an auto car number if left blank).
- You can see the current parking status anytime.
- You can remove a car by entering the slot number.
- The program uses threads to handle cars parking at the same time.

---

## Files
- **ParkingLotSimulation.java** – main program and menu  
- **CarThread.java** – handles each car as a separate thread  
- **ParkingSlot.java** – stores details of each parking slot  

---

## Run the program
Make sure you have Java installed, then run:
```bash
javac *.java
java ParkingLotSimulation
