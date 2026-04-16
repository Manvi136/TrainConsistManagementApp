import java.util.*;
import java.util.stream.Collectors;

public class UseCase10TrainConsistMgmnt {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    public static int totalCapacity(List<Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
    }

    public static void main(String[] args) {

        System.out.println("======");
        System.out.println("UC10 Count Total Seats in Train");
        System.out.println("======");

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));

        System.out.println("\nBogies in Train:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        int total = totalCapacity(bogies);

        System.out.println("\nTotal Seating Capacity of Train: " + total);
        System.out.println("\nUC10 aggregation completed...");

        runTests();
    }

    public static void runTests() {
        testZeroCapacityList();
        testNegativeCapacityHandling();
        testMixedCapacities();
        testLargeNumbers();

        System.out.println("\nAll 4 test cases passed successfully!");
    }

    //Test 1
    static void testZeroCapacityList() {
        List<Bogie> list = List.of(
                new Bogie("A", 0),
                new Bogie("B", 0)
        );

        int result = totalCapacity(list);

        if (result != 0) {
            throw new RuntimeException("testZeroCapacityList FAILED");
        }
    }

    //Test 2
    static void testNegativeCapacityHandling() {
        List<Bogie> list = List.of(
                new Bogie("A", 50),
                new Bogie("B", -10)
        );

        int result = totalCapacity(list);

        if (result != 40) {
            throw new RuntimeException("testNegativeCapacityHandling FAILED");
        }
    }

    //Test 3
    static void testMixedCapacities() {
        List<Bogie> list = List.of(
                new Bogie("A", 10),
                new Bogie("B", 20),
                new Bogie("C", 30)
        );

        int result = totalCapacity(list);

        if (result != 60) {
            throw new RuntimeException("testMixedCapacities FAILED");
        }
    }

    //Test 4
    static void testLargeNumbers() {
        List<Bogie> list = List.of(
                new Bogie("A", 1000),
                new Bogie("B", 2000)
        );

        int result = totalCapacity(list);

        if (result != 3000) {
            throw new RuntimeException("testLargeNumbers FAILED");
        }
    }
}