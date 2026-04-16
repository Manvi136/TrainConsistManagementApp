public class UseCase18TrainConsistMgmnt {

    // Linear Search method
    public static boolean linearSearch(String[] arr, String key) {
        for (String id : arr) {
            if (id.equals(key)) {
                return true; // Found → stop early
            }
        }
        return false; // Not found
    }

    public static void main(String[] args) {

        System.out.println("======");
        System.out.println("UC18 Linear Search for Bogie ID");
        System.out.println("======");

        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // Search key
        String searchId = "BG309";

        System.out.println("\nAvailable Bogie IDs:");
        for (String id : bogieIds) {
            System.out.print(id + " ");
        }

        boolean found = linearSearch(bogieIds, searchId);

        System.out.println("\n\nSearching for: " + searchId);

        if (found) {
            System.out.println("Bogie FOUND in train consist");
        } else {
            System.out.println("Bogie NOT FOUND");
        }

        System.out.println("\nUC18 search completed...");

        runTests();
    }

    public static void runTests() {
        testElementPresent();
        testElementAbsent();
        testFirstElementMatch();
        testLastElementMatch();

        System.out.println("\nAll UC18 test cases passed!");
    }

    //Test 1: Element Present
    static void testElementPresent() {
        String[] arr = {"A", "B", "C"};
        if (!linearSearch(arr, "B")) {
            throw new RuntimeException("testElementPresent FAILED");
        }
    }

    //Test 2: Element Absent
    static void testElementAbsent() {
        String[] arr = {"A", "B", "C"};
        if (linearSearch(arr, "X")) {
            throw new RuntimeException("testElementAbsent FAILED");
        }
    }

    //Test 3: First Element Match
    static void testFirstElementMatch() {
        String[] arr = {"A", "B", "C"};
        if (!linearSearch(arr, "A")) {
            throw new RuntimeException("testFirstElementMatch FAILED");
        }
    }

    //Test 4: Last Element Match
    static void testLastElementMatch() {
        String[] arr = {"A", "B", "C"};
        if (!linearSearch(arr, "C")) {
            throw new RuntimeException("testLastElementMatch FAILED");
        }
    }
}