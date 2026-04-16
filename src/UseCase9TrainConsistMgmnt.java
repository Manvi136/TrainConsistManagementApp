import java.util.*;
import java.util.stream.Collectors;

public class UseCase9TrainConsistMgmnt {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    public static Map<String, List<Bogie>> groupBogies(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
    }

    public static void main(String[] args) {

        System.out.println("UC9 Group Bogies by Type");

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));
        bogies.add(new Bogie("AC Chair", 60));

        System.out.println("\nAll Bogies:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        Map<String, List<Bogie>> grouped = groupBogies(bogies);

        System.out.println("\nGrouped Bogies:");
        for (Map.Entry<String, List<Bogie>> entry : grouped.entrySet()) {
            System.out.println("Bogie Type: " + entry.getKey());
            for (Bogie b : entry.getValue()) {
                System.out.println("Capacity -> " + b.capacity);
            }
        }

        System.out.println("\nUC9 grouping completed...");

        runTests();
    }

    public static void runTests() {
        testSingleEntryGrouping();
        testDuplicateTypesGrouping();
        testAllUniqueTypes();
        testOrderInsideGroup();

        System.out.println("\nAll 4 test cases passed successfully!");
    }

    //Test 1
    static void testSingleEntryGrouping() {
        List<Bogie> list = List.of(new Bogie("Sleeper", 72));

        Map<String, List<Bogie>> result = groupBogies(list);

        if (result.size() != 1) {
            throw new RuntimeException("testSingleEntryGrouping FAILED");
        }
    }

    //Test 2
    static void testDuplicateTypesGrouping() {
        List<Bogie> list = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 70)
        );

        Map<String, List<Bogie>> result = groupBogies(list);

        if (result.get("Sleeper").size() != 2) {
            throw new RuntimeException("testDuplicateTypesGrouping FAILED");
        }
    }

    //Test 3
    static void testAllUniqueTypes() {
        List<Bogie> list = List.of(
                new Bogie("A", 10),
                new Bogie("B", 20),
                new Bogie("C", 30)
        );

        Map<String, List<Bogie>> result = groupBogies(list);

        if (result.size() != 3) {
            throw new RuntimeException("testAllUniqueTypes FAILED");
        }
    }

    //Test 4
    static void testOrderInsideGroup() {
        List<Bogie> list = List.of(
                new Bogie("AC", 50),
                new Bogie("AC", 60)
        );

        Map<String, List<Bogie>> result = groupBogies(list);

        List<Bogie> acList = result.get("AC");

        if (acList.get(0).capacity != 50 || acList.get(1).capacity != 60) {
            throw new RuntimeException("testOrderInsideGroup FAILED");
        }
    }
}