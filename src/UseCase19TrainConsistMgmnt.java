import java.util.Arrays;

public class UseCase19TrainConsistMgmnt {

    // Binary Search method
    public static boolean binarySearch(String[] arr, String key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int cmp = key.compareTo(arr[mid]);

            if (cmp == 0) {
                return true; // Found
            } else if (cmp < 0) {
                high = mid - 1; // Search left
            } else {
                low = mid + 1; // Search right
            }
        }

        return false; // Not found
    }

    public static void main(String[] args) {

        System.out.println("UC19 Binary Search for Bogie ID");

        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        Arrays.sort(bogieIds);

        String key = "BG309";

        System.out.println("\nSorted Bogie IDs:");
        for (String id : bogieIds) {
            System.out.print(id + " ");
        }

        boolean found = binarySearch(bogieIds, key);

        System.out.println("\n\nSearching for: " + key);

        if (found) {
            System.out.println("Bogie FOUND using Binary Search");
        } else {
            System.out.println("Bogie NOT FOUND");
        }

        System.out.println("\nUC19 search completed...");

        runTests();
    }

    public static void runTests() {
        testMiddleElement();
        testElementNotPresent();
        testSingleElementArray();
        testCaseSensitivity();

        System.out.println("\nAll UC19 test cases passed!");
    }

    //Test 1: Middle Element
    static void testMiddleElement() {
        String[] arr = {"A", "B", "C"};
        Arrays.sort(arr);

        if (!binarySearch(arr, "B")) {
            throw new RuntimeException("testMiddleElement FAILED");
        }
    }

    //Test 2: Element Not Present
    static void testElementNotPresent() {
        String[] arr = {"A", "B", "C"};
        Arrays.sort(arr);

        if (binarySearch(arr, "X")) {
            throw new RuntimeException("testElementNotPresent FAILED");
        }
    }

    //Test 3: Single Element Array
    static void testSingleElementArray() {
        String[] arr = {"A"};
        Arrays.sort(arr);

        if (!binarySearch(arr, "A")) {
            throw new RuntimeException("testSingleElementArray FAILED");
        }
    }

    //Test 4: Case Sensitivity Check
    static void testCaseSensitivity() {
        String[] arr = {"apple", "banana", "cherry"};
        Arrays.sort(arr);

        if (binarySearch(arr, "Banana")) { // different case
            throw new RuntimeException("testCaseSensitivity FAILED");
        }
    }
}