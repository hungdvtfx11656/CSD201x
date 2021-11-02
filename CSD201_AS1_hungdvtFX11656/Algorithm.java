import java.io.*;
import java.util.*;

public class Algorithm {

    private static MyUtilities u = MyUtilities.getInstance();

    /**
     * Save text to file
     * @param value string to write to file
     * @param filename filename to save
     */
    public void saveString(String value, String filename) {
        try (
            FileOutputStream fos = new FileOutputStream(new File(filename));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        ) {
            bw.write(value);
            System.out.println("Saving to " + filename + " successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found!");
        } catch (Exception e) {
            System.out.println("Error: Unable to write!");
        }
    }

    /**
     * Save data from array to file
     * @param value string to write to file
     * @param filename filename to save
     */
    public void saveArray(float[] a, int n, String filename) {
        try (
            FileOutputStream fos = new FileOutputStream(new File(filename));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        ) {
            for (int i = 0; i < n; i++) {
                bw.write(a[i] + " ");
            }
            System.out.println("Saving to " + filename + " successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found!");
        } catch (Exception e) {
            System.out.println("Error: Unable to write!");
        }
    }

    /**
     * Load array element(s) from input.txt file to float array a
     * @param a destination float array
     * @param size size of array a
     * @param filename name of file to load
     */
    public void loadElement(float[] a, int n, String filename) {
        try (
            Scanner in = new Scanner(new File(filename));
        ) {
            for (int i = 0; i < n; i++) {
                a[i] = in.nextFloat();
            }
            System.out.println("Loading array from " + filename + " successfully!");
        } catch (Exception e) {
            System.out.println("Loading array from " + filename + " unsuccessfully!");
        }
    }

    /**
     * Load array length from input text file
     * @param filename name of file to load
     * @return length in int
     */
    public int loadLength(String filename) {
        try (
            Scanner in = new Scanner(new File(filename));
        ) {
            int i = -1;
            while (in.hasNextFloat()) {
                in.nextFloat();
                i++;
            }
            return (-1 < i) ? i + 1 : -1;
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * Sort array using bubble sort
     * and print each step to console
     * @param a float array to sort
     * @param n size of array a
     * @return method's execution time in nanoseconds
     */
    public long bubbleSort(float[] a, int n) {

        long startTime = System.nanoTime();

        /* Iterate for n - 1 time, for each time
        we move the largest element to the last */
        for (int i = 0; i < n - 1; i++) {

            /* Assume array is already sorted */
            boolean swapped = false;

            /* Compare adjacent elements to move larger element to the right */
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    swapped = true;
                    /* If elements are swapped, print this step to console */
                    display(a, n);
                }
            }
            System.out.print("Loop " + (i + 1) + " ->     ");
            display(a, n);

            /* If no elements is swapped, it means they are
            in the right position, break the loop */
            if (!swapped) break;

        }

        long endTime = System.nanoTime();
        return (endTime - startTime);
    }

    /**
     * Sort array using seletion sort
     * and print each step to console
     * @param a float array to sort
     * @param n size of array a
     * @return method's execution time in nanoseconds
     */
    public long selectionSort(float[] a, int n) {

        long startTime = System.nanoTime();

        /* Iterate for n - 1 time, for each time
        we move the smallest element to the start */
        for (int i = 0; i < n - 1; i++) {

            /* Initialize index of minimum value,
            assume value at i is the smallest */
            int minI = i;

            /* Find the index of minimum element in unsorted subarray */
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minI]) {
                    minI = j;
                }
            }

            /* If minimum value is not at start of subarray,
            then swap their value and display this step */
            if (minI != i) {
                swap(a, i, minI);
                display(a, n);
            }

            System.out.print("Loop " + (i + 1) + " ->     ");
            display(a, n);

        }

        long endTime = System.nanoTime();
        return (endTime - startTime);
    }

    /**
     * Sort array using insertion sort
     * and print each step to console
     * @param a float array to sort
     * @param n size of array a
     * @return method's execution time in nanoseconds
     */
    public long insertionSort(float[] a, int n) {

        long startTime = System.nanoTime();

        /* Iterate for n - 1 time start from index 1,
        for each time we have sorted subarray from index 0 to i */
        for (int i = 1; i < n; i++) {

            /* Initialize variables
            to compare sorted subarray with its next element */
            float key = a[i];
            int prev = i - 1;
            boolean move = false;

            /* Compare and keep moving larger element to the right
            and display the moving */
            while (prev >= 0 && a[prev] > key) {
                a[prev + 1] = a[prev];
                prev--;
                display(a, n);
                move = true;
            }

            /* If subarray is changed, then finish the swapping process
            and display the moving */
            if (move) {
                a[prev + 1] = key;
                display(a, n);
            }

            System.out.print("Loop " + i + " ->     ");
            display(a, n);

        }

        long endTime = System.nanoTime();
        return (endTime - startTime);

    }

    /**
     * Search and return indexs
     * which has element greater or equal to key value
     * @param a srray in float
     * @param key value to compare with elements in array
     * @param n size of array a
     * @return result in string
     */
    public String linearSearch(float[] a, float key, int n) {
        String result = "Matched index(s): ";
        boolean matched = false;
        for (int i = 0; i < n; i++) {
            if (a[i] > key) {
                result += (i + " ");
                matched = true;
            }
        }
        return matched ? result : "No matched element was found.";
    }

    /**
     * Search for first index element of array a
     * which matches with key value
     * @param a array in float
     * @param key value to found in array in float
     * @param n size of array a
     * @return result in string
     */
    public String binarySearch(float[] a, float key, int n) {

        /* Set left and right index */
        int l = 0, r = n - 1;

        /* Iterative loop for binary search */
        while (l <= r) {

            /* Get middle index */
            int mid = l + ((r - l) / 2);

            /* If key is found, then return middle index */
            if (a[mid] == key) {
                return "First occurrence index: " + mid;
            }
            /* If key is not found, set left or right middle
            and run the loop a gain */
            if (a[mid] < key) l = mid + 1;
            else r = mid - 1;
        }

        /* If loop is finished (left and right are crossed)
        then no matched element was found */
        return "No matched element was found.";

    }

    /**
     * Utility method to swap two elements in array
     * @param a float array to swap
     * @param i index of first element
     * @param j index of second element
     */
    private void swap(float[] a, int i, int j) {
        float temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * Custom display array
     * @param a array in float
     * @param n size of array a
     */
    public void display(float[] a, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + "\t");
        }
        System.out.println();
    }

    /**
     * Clone array
     * @param b array in float
     * @param n size of array b
     * @return array b in float which is identical with array a
     */
    public float[] clone(float[] b, int n) {
        float[] a = new float[n];
        for (int i = 0; i < n; i++) {
            a[i] = b[i];
        }
        return a;
    }

    /**
     * Sort array using insertion sort
     * without printing step and time execution
     * @param a array in float
     * @param n size of array a
     */
    public void sort(float[] a, int n) {
        for (int i = 1; i < n; i++) {
            float min = a[i];
            int prev = i - 1;
            while (prev >= 0 && a[prev] > min) {
                a[prev + 1] = a[prev];
                prev--;
            }
            a[prev + 1] = min;
        }
    }

    /**
     * Set float elements into array
     * @param a
     * @param n
     */
    public void fillArray(float[] a, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = u.inputFloat();
        }
    }

}
