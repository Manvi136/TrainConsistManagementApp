import java.util.ArrayList;
import java.util.List;

public class UseCase12TrainConsistMgmnt {

    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }

    public static boolean isSafe(List<GoodsBogie> goodsBogies) {
        return goodsBogies.stream()
                .allMatch(b ->
                        !(b.type.equalsIgnoreCase("Cylindrical") &&
                          !b.cargo.equalsIgnoreCase("Petroleum"))
                );
    }

    public static void main(String[] args) {

        System.out.println("UC12 Safety Compliance Check for Goods Bogies");

        List<GoodsBogie> goodsBogies = new ArrayList<>();

        goodsBogies.add(new GoodsBogie("Rectangular", "Coal"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Rectangular", "Steel"));

        System.out.println("\nGoods Bogies:");
        for (GoodsBogie b : goodsBogies) {
            System.out.println(b.type + " -> " + b.cargo);
        }

        boolean safe = isSafe(goodsBogies);

        System.out.println("\nIs Train Safety Compliant? " + safe);
        System.out.println("\nUC12 safety validation completed...");

        runTests();
    }

    public static void runTests() {
        testAllValidBogies();
        testInvalidCylindricalCargo();
        testMixedValidInvalid();
        testEmptyList();

        System.out.println("\nAll 4 test cases passed successfully!");
    }

    //Test 1
    static void testAllValidBogies() {
        List<GoodsBogie> list = List.of(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Rectangular", "Coal")
        );

        if (!isSafe(list)) {
            throw new RuntimeException("testAllValidBogies FAILED");
        }
    }

    //Test 2
    static void testInvalidCylindricalCargo() {
        List<GoodsBogie> list = List.of(
                new GoodsBogie("Cylindrical", "Coal")
        );

        if (isSafe(list)) {
            throw new RuntimeException("testInvalidCylindricalCargo FAILED");
        }
    }

    //Test 3
    static void testMixedValidInvalid() {
        List<GoodsBogie> list = List.of(
                new GoodsBogie("Rectangular", "Steel"),
                new GoodsBogie("Cylindrical", "Water") // invalid
        );

        if (isSafe(list)) {
            throw new RuntimeException("testMixedValidInvalid FAILED");
        }
    }

    //Test 4
    static void testEmptyList() {
        List<GoodsBogie> list = new ArrayList<>();

        if (!isSafe(list)) {
            throw new RuntimeException("testEmptyList FAILED");
        }
    }
}