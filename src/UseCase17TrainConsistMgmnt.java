import java.util.Arrays;

public class UseCase17TrainConsistMgmnt {

    public static void main(String[] args) {

        System.out.println("UC17 Sort Bogie Names Using Arrays.sort()");

        String[] bogies = {"Sleeper", "AC Chair", "First Class", "General"};

        System.out.println("\nOriginal Bogie Names:");
        System.out.println(Arrays.toString(bogies));

        Arrays.sort(bogies);

        System.out.println("\nSorted Bogie Names (Alphabetical):");
        System.out.println(Arrays.toString(bogies));

        System.out.println("\nUC17 sorting completed...");

        runTests();
    }

    public static void runTests() {
        testAlreadySorted();
        testReverseOrder();
        testDuplicateNames();
        testSingleElement();

        System.out.println("\nAll UC17 test cases passed!");
    }

    //Test 1: Already Sorted
    static void testAlreadySorted() {
        String[] arr = {"A", "B", "C"};
        Arrays.sort(arr);

        if (!arr[0].equals("A") || !arr[1].equals("B") || !arr[2].equals("C")) {
            throw new RuntimeException("testAlreadySorted FAILED");
        }
    }

    //Test 2: Reverse Order
    static void testReverseOrder() {
        String[] arr = {"C", "B", "A"};
        Arrays.sort(arr);

        if (!arr[0].equals("A") || !arr[1].equals("B") || !arr[2].equals("C")) {
            throw new RuntimeException("testReverseOrder FAILED");
        }
    }

    //Test 3: Duplicate Names
    static void testDuplicateNames() {
        String[] arr = {"Sleeper", "AC", "Sleeper"};
        Arrays.sort(arr);

        if (!arr[0].equals("AC") || !arr[1].equals("Sleeper") || !arr[2].equals("Sleeper")) {
            throw new RuntimeException("testDuplicateNames FAILED");
        }
    }

    //Test 4: Single Element
    static void testSingleElement() {
        String[] arr = {"OnlyOne"};
        Arrays.sort(arr);

        if (!arr[0].equals("OnlyOne")) {
            throw new RuntimeException("testSingleElement FAILED");
        }
    }
}