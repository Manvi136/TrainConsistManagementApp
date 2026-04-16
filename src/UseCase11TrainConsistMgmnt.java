import java.util.Scanner;
import java.util.regex.Pattern;

public class UseCase11TrainConsistMgmnt {

    static Pattern trainPattern = Pattern.compile("TRN-\\d{4}");
    static Pattern cargoPattern = Pattern.compile("PET-[A-Z]{2}");

    public static boolean isValidTrainId(String trainId) {
        return trainPattern.matcher(trainId).matches();
    }

    public static boolean isValidCargoCode(String cargoCode) {
        return cargoPattern.matcher(cargoCode).matches();
    }

    public static void main(String[] args) {

        System.out.println("UC11 Validate Train ID and Cargo Code");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        boolean trainValid = isValidTrainId(trainId);
        boolean cargoValid = isValidCargoCode(cargoCode);

        System.out.println("\nValidation Results:");
        System.out.println("Train ID Valid: " + trainValid);
        System.out.println("Cargo Code Valid: " + cargoValid);

        System.out.println("\nUC11 validation completed...");

        runTests();
    }

    public static void runTests() {
        testSpecialCharacters();
        testLowercaseTrainId();
        testExtraCharacters();
        testNumericCargoCode();

        System.out.println("\nAll 4 test cases passed successfully!");
    }

    //Test 1
    static void testSpecialCharacters() {
        String train = "TRN-12@4";
        boolean result = isValidTrainId(train);

        if (result) {
            throw new RuntimeException("testSpecialCharacters FAILED");
        }
    }

    //Test 2
    static void testLowercaseTrainId() {
        String train = "trn-1234";
        boolean result = isValidTrainId(train);

        if (result) {
            throw new RuntimeException("testLowercaseTrainId FAILED");
        }
    }

    //Test 3
    static void testExtraCharacters() {
        String train = "TRN-1234X";
        boolean result = isValidTrainId(train);

        if (result) {
            throw new RuntimeException("testExtraCharacters FAILED");
        }
    }

    //Test 4
    static void testNumericCargoCode() {
        String cargo = "PET-12";
        boolean result = isValidCargoCode(cargo);

        if (result) {
            throw new RuntimeException("testNumericCargoCode FAILED");
        }
    }
}