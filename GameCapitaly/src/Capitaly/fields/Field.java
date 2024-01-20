package Capitaly.fields;

import Capitaly.players.Player;

/**
 *
 * @author selez
 */

public abstract class Field {
    protected int price;

    public Field() {

    }

    /**
     * Perform the action associated with the field when a player lands on it.
     *
     * param player The player who landed on the field.
     */
    public abstract void FieldAct(Player player);
}
