package Capitaly.fields;

import Capitaly.Capitaly;
import Capitaly.players.Player;

public class Field_service extends Field {

    /**
     * Constructor for Field_service.
     *
     * param price The price associated with the Service field.
     */
    public Field_service(int price) {
        super();
        this.price = price;
    }

    /**
     * Perform the action associated with the Service field when a player lands on it.
     *
     * param player The player who landed on the Service field.
     */
    @Override
    public void FieldAct(Player player) {
        Capitaly.printData(this.price, player + " pay ", 1);
        player.Pay(this.price);
    }

    /**
     * Get a string representation of the Service field.
     *
     * return A string representation of the Service field.
     */
    @Override
    public String toString() {
        return "Field Service";
    }
}
