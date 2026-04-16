import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UseCase8TrainConsistMgmnt {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    public static List<Bogie> filterBogies(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        System.out.println("UC8 Filter Passenger Bogies Using Streams");

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 98));

        // Display all
        System.out.println("\nAll Bogies:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        List<Bogie> filtered = filterBogies(bogies, 60);

        System.out.println("\nFiltered Bogies (Capacity > 60):");
        for (Bogie b : filtered) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        System.out.println("\nUC8 filtering completed...");

        runTests();
    }

    public static void runTests() {
        testZeroCapacity();
        testMixedData();
        testLargeDataset();
        testOrderPreserved();

        System.out.println("\nAll 4 test cases passed successfully!");
    }

    //Test 1
    static void testZeroCapacity() {
        List<Bogie> list = List.of(
                new Bogie("B1", 0),
                new Bogie("B2", 10)
        );

        List<Bogie> result = filterBogies(list, 0);

        if (result.size() != 1) {
            throw new RuntimeException("testZeroCapacity FAILED");
        }
    }

    //Test 2
    static void testMixedData() {
        List<Bogie> list = List.of(
                new Bogie("Valid", 80),
                new Bogie("Invalid", -20),
                new Bogie("Low", 30)
        );

        List<Bogie> result = filterBogies(list, 60);

        if (result.size() != 1) {
            throw new RuntimeException("testMixedData FAILED");
        }
    }

    //Test 3
    static void testLargeDataset() {
        List<Bogie> list = List.of(
                new Bogie("B1", 10),
                new Bogie("B2", 20),
                new Bogie("B3", 70),
                new Bogie("B4", 80),
                new Bogie("B5", 90)
        );

        List<Bogie> result = filterBogies(list, 60);

        if (result.size() != 3) {
            throw new RuntimeException("testLargeDataset FAILED");
        }
    }

    //Test 4
    static void testOrderPreserved() {
        List<Bogie> list = List.of(
                new Bogie("A", 70),
                new Bogie("B", 80),
                new Bogie("C", 50)
        );

        List<Bogie> result = filterBogies(list, 60);

        if (!result.get(0).name.equals("A") || !result.get(1).name.equals("B")) {
            throw new RuntimeException("testOrderPreserved FAILED");
        }
    }
}