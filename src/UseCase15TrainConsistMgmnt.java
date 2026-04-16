import java.util.ArrayList;
import java.util.List;

public class UseCase15TrainConsistMgmnt {

    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    static class GoodsBogie {
        String shape;
        String cargo;

        GoodsBogie(String shape) {
            this.shape = shape;
        }

        // Assign cargo with safety handling
        void assignCargo(String cargo) {
            try {
                // Rule: Rectangular cannot carry Petroleum
                if (shape.equalsIgnoreCase("Rectangular") &&
                    cargo.equalsIgnoreCase("Petroleum")) {
                    throw new CargoSafetyException("Unsafe cargo assignment!");
                }

                this.cargo = cargo;
                System.out.println("Cargo assigned: " + cargo + " to " + shape);

            } catch (CargoSafetyException e) {
                System.out.println("Exception Caught: " + e.getMessage());

            } finally {
                System.out.println("Assignment attempt completed.\n");
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("UC15 Safe Cargo Assignment Using try-catch-finally");

        List<GoodsBogie> bogies = new ArrayList<>();

        GoodsBogie b1 = new GoodsBogie("Rectangular");
        GoodsBogie b2 = new GoodsBogie("Cylindrical");

        bogies.add(b1);
        bogies.add(b2);

        // Assign cargo
        b1.assignCargo("Coal");        // valid
        b2.assignCargo("Petroleum");   // valid
        b1.assignCargo("Petroleum");   // invalid

        System.out.println("UC15 execution continues safely...\n");

        runTests();
    }

    public static void runTests() {
        testValidAssignment();
        testInvalidAssignmentHandled();
        testMultipleAssignments();
        testCaseInsensitiveCheck();

        System.out.println("All 4 test cases passed successfully!");
    }

    //Test 1
    static void testValidAssignment() {
        GoodsBogie b = new GoodsBogie("Rectangular");
        b.assignCargo("Coal");

        if (!"Coal".equalsIgnoreCase(b.cargo)) {
            throw new RuntimeException("testValidAssignment FAILED");
        }
    }

    //Test 2
    static void testInvalidAssignmentHandled() {
        GoodsBogie b = new GoodsBogie("Rectangular");
        b.assignCargo("Petroleum");

        if (b.cargo != null) {
            throw new RuntimeException("testInvalidAssignmentHandled FAILED");
        }
    }

    //Test 3
    static void testMultipleAssignments() {
        GoodsBogie b = new GoodsBogie("Cylindrical");
        b.assignCargo("Petroleum");
        b.assignCargo("Water");

        if (!"Water".equalsIgnoreCase(b.cargo)) {
            throw new RuntimeException("testMultipleAssignments FAILED");
        }
    }

    //Test 4
    static void testCaseInsensitiveCheck() {
        GoodsBogie b = new GoodsBogie("rectangular");
        b.assignCargo("petroleum");

        if (b.cargo != null) {
            throw new RuntimeException("testCaseInsensitiveCheck FAILED");
        }
    }
}