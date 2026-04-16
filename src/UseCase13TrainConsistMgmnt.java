import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UseCase13TrainConsistMgmnt {

    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    public static List<Bogie> filterUsingLoop(List<Bogie> bogies, int threshold) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > threshold) {
                result.add(b);
            }
        }
        return result;
    }

    public static List<Bogie> filterUsingStream(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        System.out.println("UC13 Performance Comparison (Loops vs Streams)");

        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            bogies.add(new Bogie("Type" + i, i % 100));
        }

        long startLoop = System.nanoTime();
        List<Bogie> loopResult = filterUsingLoop(bogies, 50);
        long endLoop = System.nanoTime();

        long startStream = System.nanoTime();
        List<Bogie> streamResult = filterUsingStream(bogies, 50);
        long endStream = System.nanoTime();

        long loopTime = endLoop - startLoop;
        long streamTime = endStream - startStream;

        System.out.println("\nLoop Execution Time (ns): " + loopTime);
        System.out.println("Stream Execution Time (ns): " + streamTime);

        System.out.println("\nUC13 benchmarking completed...");

        runTests();
    }

    public static void runTests() {
        testSameResultLoopVsStream();
        testEmptyDataset();
        testAllBelowThreshold();
        testAllAboveThreshold();

        System.out.println("\nAll 4 test cases passed successfully!");
    }

    //Test 1
    static void testSameResultLoopVsStream() {
        List<Bogie> list = List.of(
                new Bogie("A", 10),
                new Bogie("B", 70),
                new Bogie("C", 80)
        );

        List<Bogie> loop = filterUsingLoop(list, 50);
        List<Bogie> stream = filterUsingStream(list, 50);

        if (loop.size() != stream.size()) {
            throw new RuntimeException("testSameResultLoopVsStream FAILED");
        }
    }

    //Test 2
    static void testEmptyDataset() {
        List<Bogie> list = new ArrayList<>();

        if (!filterUsingLoop(list, 50).isEmpty() ||
            !filterUsingStream(list, 50).isEmpty()) {
            throw new RuntimeException("testEmptyDataset FAILED");
        }
    }

    //Test 3
    static void testAllBelowThreshold() {
        List<Bogie> list = List.of(
                new Bogie("A", 10),
                new Bogie("B", 20)
        );

        if (!filterUsingLoop(list, 50).isEmpty()) {
            throw new RuntimeException("testAllBelowThreshold FAILED");
        }
    }

    //Test 4
    static void testAllAboveThreshold() {
        List<Bogie> list = List.of(
                new Bogie("A", 60),
                new Bogie("B", 70)
        );

        if (filterUsingStream(list, 50).size() != 2) {
            throw new RuntimeException("testAllAboveThreshold FAILED");
        }
    }
}