package Capitaly;
import Capitaly.fields.*;
import Capitaly.players.*;

/**
 *
 * @author selez
// */

public class Capitaly {
    public static String gamePromotion = "";

    /**
     * Print game data with an object and a description.
     *
     * param o     The object to be printed.
     * param t     The description or title for the printed data.
     * param tabs  The number of tabs to indent the printed data.
     */
    public static void printData(Object o, String t, int tabs) {
        gamePromotion += t+ " ";
        gamePromotion += o.toString() + "\n";
    }

    /**
     * Print game data with a string and a description.
     *
     * param o     The string to be printed.
     * param t     The description or title for the printed data.
     * param tabs  The number of tabs to indent the printed data.
     */
    public static void printData(String o, String t, int tabs) {
        gamePromotion += t + " ";
        gamePromotion += o.toString() + "\n";
    }
}
