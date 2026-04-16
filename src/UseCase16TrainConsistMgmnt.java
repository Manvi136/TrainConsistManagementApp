public class UseCase16TrainConsistMgmnt {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        // Outer loop for passes
        for (int i = 0; i < n - 1; i++) {

            // Inner loop for comparison
            for (int j = 0; j < n - i - 1; j++) {

                // Swap if elements are in wrong order
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("UC16 Manual Sorting using Bubble Sort");

        int[] capacities = {72, 56, 24, 78, 60};

        System.out.println("\nOriginal Capacities:");
        for (int c : capacities) {
            System.out.print(c + " ");
        }

        bubbleSort(capacities);

        System.out.println("\n\nSorted Capacities (Ascending):");
        for (int c : capacities) {
            System.out.print(c + " ");
        }

        System.out.println("\n\nUC16 sorting completed...");

        runTests();
    }

    public static void runTests() {
        testAlreadySortedArray();
        testReverseSortedArray();
        testDuplicateValues();
        testSingleElementArray();

        System.out.println("\nAll 4 test cases passed successfully!");
    }

    //Test 1
    static void testAlreadySortedArray() {
        int[] arr = {10, 20, 30};
        bubbleSort(arr);

        if (arr[0] != 10 || arr[1] != 20 || arr[2] != 30) {
            throw new RuntimeException("testAlreadySortedArray FAILED");
        }
    }

    //Test 2
    static void testReverseSortedArray() {
        int[] arr = {30, 20, 10};
        bubbleSort(arr);

        if (arr[0] != 10 || arr[1] != 20 || arr[2] != 30) {
            throw new RuntimeException("testReverseSortedArray FAILED");
        }
    }

    //Test 3
    static void testDuplicateValues() {
        int[] arr = {20, 10, 20};
        bubbleSort(arr);

        if (arr[0] != 10 || arr[1] != 20 || arr[2] != 20) {
            throw new RuntimeException("testDuplicateValues FAILED");
        }
    }

    //Test 4
    static void testSingleElementArray() {
        int[] arr = {5};
        bubbleSort(arr);

        if (arr[0] != 5) {
            throw new RuntimeException("testSingleElementArray FAILED");
        }
    }
}