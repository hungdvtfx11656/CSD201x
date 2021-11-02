import java.util.Scanner;

public class Utilities {

    private static Utilities instance;

    private Utilities () {}

    public static Utilities getInstance() {
        if (instance == null) instance = new Utilities();
        return instance;
    }

    static Scanner console = new Scanner(System.in);

    public int intInput(String s, int min, int max) {
        System.out.print(s);
        try {
            int value = Integer.parseInt(console.nextLine());
            if (value < min && value > max) return intInput(s, min, max);
            return value;
        } catch (Exception e) {
            return intInput(s, min, max);
        }
    }

    public int intInput(String s) {
        return intInput(s, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public String stringInput(String s) {
        System.out.print(s);
        return console.nextLine();
    }

    public float floatInput(String s, float min, float max) {
        System.out.print(s);
        try {
            float value = Float.parseFloat(console.nextLine());
            if (value < min && value > max) return floatInput(s, min, max);
            return value;
        } catch (Exception e) {
            return floatInput(s, min, max);
        }
    }

    public float floatInput(String s) {
        return floatInput(s, Float.MAX_VALUE, Float.MAX_VALUE);
    }

}
