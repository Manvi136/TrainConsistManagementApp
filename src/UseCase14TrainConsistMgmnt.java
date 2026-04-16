import java.util.ArrayList;
import java.util.List;

public class UseCase14TrainConsistMgmnt {

    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    static class PassengerBogie {
        String name;
        int capacity;

        PassengerBogie(String name, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Invalid capacity for " + name);
            }
            this.name = name;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("UC14 Handle Invalid Bogie Capacity (Custom Exception)");

        List<PassengerBogie> bogies = new ArrayList<>();

        try {
            bogies.add(new PassengerBogie("Sleeper", 72));
            bogies.add(new PassengerBogie("AC Chair", 56));

            //Invalid bogie (will throw exception)
            bogies.add(new PassengerBogie("Invalid Bogie", 0));

        } catch (InvalidCapacityException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        }

        System.out.println("\nValid Bogies in Train:");
        for (PassengerBogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        System.out.println("\nUC14 validation completed...");

        runTests();
    }

    public static void runTests() {
        testValidCapacityCreation();
        testZeroCapacityThrowsException();
        testNegativeCapacityThrowsException();
        testMultipleValidBogies();

        System.out.println("\nAll 4 test cases passed successfully!");
    }

    //Test 1
    static void testValidCapacityCreation() {
        try {
            PassengerBogie b = new PassengerBogie("A", 50);
        } catch (Exception e) {
            throw new RuntimeException("testValidCapacityCreation FAILED");
        }
    }

    //Test 2
    static void testZeroCapacityThrowsException() {
        try {
            new PassengerBogie("B", 0);
            throw new RuntimeException("testZeroCapacityThrowsException FAILED");
        } catch (InvalidCapacityException e) {
            // expected
        }
    }

    //Test 3
    static void testNegativeCapacityThrowsException() {
        try {
            new PassengerBogie("C", -10);
            throw new RuntimeException("testNegativeCapacityThrowsException FAILED");
        } catch (InvalidCapacityException e) {
            // expected
        }
    }

    //Test 4
    static void testMultipleValidBogies() {
        try {
            List<PassengerBogie> list = new ArrayList<>();
            list.add(new PassengerBogie("A", 10));
            list.add(new PassengerBogie("B", 20));

            if (list.size() != 2) {
                throw new RuntimeException("testMultipleValidBogies FAILED");
            }
        } catch (Exception e) {
            throw new RuntimeException("testMultipleValidBogies FAILED");
        }
    }
}