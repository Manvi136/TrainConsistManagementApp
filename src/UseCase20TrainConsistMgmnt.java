public class UseCase20TrainConsistMgmnt {

    // Search method with fail-fast validation
    public static boolean searchBogie(String[] arr, String key) {

        // FAIL-FAST: check empty array
        if (arr.length == 0) {
            throw new IllegalStateException("Train has no bogies. Cannot perform search.");
        }

        // Linear search
        for (String id : arr) {
            if (id.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println("UC20 Exception Handling During Search Operations");

        String[] bogieIds = {};
        String searchId = "BG101";

        try {
            boolean found = searchBogie(bogieIds, searchId);

            if (found) {
                System.out.println("Bogie FOUND");
            } else {
                System.out.println("Bogie NOT FOUND");
            }

        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nUC20 execution completed...");

        // Run tests
        runTests();
    }

    public static void runTests() {
        testEmptyArrayThrowsException();
        testSearchValidData();
        testSearchElementNotFound();
        testSingleElementSearch();

        System.out.println("\nAll UC20 test cases passed!");
    }

    //Test 1: Empty array should throw exception
    static void testEmptyArrayThrowsException() {
        String[] arr = {};
        try {
            searchBogie(arr, "A");
            throw new RuntimeException("testEmptyArrayThrowsException FAILED");
        } catch (IllegalStateException e) {
            // expected
        }
    }

    //Test 2: Valid search
    static void testSearchValidData() {
        String[] arr = {"A", "B", "C"};
        if (!searchBogie(arr, "B")) {
            throw new RuntimeException("testSearchValidData FAILED");
        }
    }

    //Test 3: Element not found
    static void testSearchElementNotFound() {
        String[] arr = {"A", "B", "C"};
        if (searchBogie(arr, "X")) {
            throw new RuntimeException("testSearchElementNotFound FAILED");
        }
    }

    //Test 4: Single element search
    static void testSingleElementSearch() {
        String[] arr = {"A"};
        if (!searchBogie(arr, "A")) {
            throw new RuntimeException("testSingleElementSearch FAILED");
        }
    }
}