import java.util.*;

public class Utilities {

    private static Scanner console = new Scanner(System.in);

    private static Utilities instance;

    private Utilities(){}

    public static Utilities getInstance() {
        if (instance == null) instance = new Utilities();
        return instance;
    }

    /**
     * Utility method to validate integer input
     */
    int inputInt(int min, int max) {
        int value;
        try {
            value = Integer.parseInt(console.nextLine());
            if (value < min || value > max) {
                System.out.print("Error: value must between " + min + " and " + max + ". Try again: ");
                return inputInt(min, max);
            } else {
                return value;
            }
        } catch (Exception ex) {
            System.out.print("Error: wrong input. Try again: ");
        }
        return inputInt(min, max);
    }

    int inputInt() {
        return inputInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Utility method to validate float input
     */
    float inputFloat(float min, float max) {
        float value;
        try {
            value = Float.parseFloat(console.nextLine());
            if (value < min || value > max) {
                System.out.print("Error: value must between " + min + " and " + max + ". Try again: ");
                return inputFloat(min, max);
            } else {
                return value;
            }
        } catch (Exception ex) {
            System.out.print("Error: wrong input. Try again: ");
        }
        return inputFloat(min, max);
    }

    float inputFloat(Scanner console) {
        return inputFloat(Float.MIN_NORMAL, Float.MAX_VALUE);
    }

}
