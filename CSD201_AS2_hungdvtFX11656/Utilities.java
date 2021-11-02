import java.io.*;
import java.util.*;

public class Utilities {

    private static Scanner console = new Scanner(System.in);

    private static Utilities instance;

    private Utilities(){}

    public static Utilities getInstance() {
        if (instance == null) instance = new Utilities();
        return instance;
    }

    public int inputInt(int min, int max) {
        int value;
        try {
            String s = console.nextLine();
            appendToFile(s + "\n");
            value = Integer.parseInt(s);
            if (value < min || value > max) {
                printLog("Error: value must between " + min + " and " + max + ". Try again: ");
                return inputInt(min, max);
            } else {
                return value;
            }
        } catch (Exception ex) {
            printLog("Error: wrong input. Try again: ");
        }
        return inputInt(min, max);
    }

    public int inputInt() {
        return inputInt(0, Integer.MAX_VALUE);
    }

    public float inputFloat(float min, float max) {
        float value;
        try {
            String s = console.nextLine();
            appendToFile(s + "\n");
            value = Float.parseFloat(s);
            if (value < min || value > max) {
                printLog("Error: value must between " + min + " and " + max + ". Try again: ");
                return inputFloat(min, max);
            } else {
                return value;
            }
        } catch (Exception ex) {
            printLog("Error: wrong input. Try again: ");
        }
        return inputFloat(min, max);
    }

    public float inputFloat() {
        return inputFloat(0, Float.MAX_VALUE);
    }

    public double inputDouble(double min, double max) {
        double value;
        try {
            String s = console.nextLine();
            appendToFile(s + "\n");
            value = Double.parseDouble(s);
            if (value < min || value > max) {
                printLog("Error: value must between " + min + " and " + max + ". Try again: ");
                return inputDouble(min, max);
            } else {
                return value;
            }
        } catch (Exception ex) {
            printLog("Error: wrong input. Try again: ");
        }
        return inputDouble(min, max);
    }

    public double inputDouble() {
        return inputDouble(0, Double.MAX_VALUE);
    }

    public String inputString() {
        String s = console.nextLine();
        appendToFile(s + "\n");
        return s;
    }

    public boolean printLog(String filename, String s) {
        System.out.print(s);
        return appendToFile(filename, s);
    }

    public boolean printLog(String s) {
        System.out.print(s);
        return appendToFile(s);
    }

    public boolean appendToFile(String filename, String s) {
        try (
            FileWriter fw = new FileWriter(filename, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)
        ) {
            out.print(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean appendToFile(String s) {
        return appendToFile("out_put.txt", s);
    }

}
