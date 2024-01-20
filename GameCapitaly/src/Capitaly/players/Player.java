package Capitaly.players;

import Capitaly.fields.*;
import java.util.ArrayList;

/**
 *
 * @author selez
 */

public abstract class Player {
    protected String name;
    protected int balance;
    protected ArrayList<Field_property> properties;
    protected boolean loseGame;
    protected int position;

    protected Player(String name) {
        this.name = name;
        this.balance = 10000;
        this.properties = new ArrayList<>();
        this.loseGame = false;
        this.position = 0;
    }

    /**
     * Move the player to a new position on the game board.
     *
     * param number The number of positions to move.
     */
    public void Moving(int number) {
        position += number;
    }

    public int getPosition() {
        return position;
    }

    public int getBalance(){
        return balance;
    }
    /**
     * Get a string representation of the player's properties.
     *
     * return A string representing the player's properties.
     */
    public String getProp(){
        String s = "";
        for (int i = 0; i < properties.size(); i++) {
            s+=properties.get(i) + " ";
        }
        return s;
    }
    public void getPayment(int amount) {
        this.balance += amount;
    }

    /**
     * Pay a specified price to another player.
     *
     * param price  The price to be paid.
     * param player The player to whom the payment is made.
     */
    public void Pay(int price, Player player) {
        int sum = this.balance - price;
        if (sum <= 0) {
            player.getPayment(this.balance);
            this.Losed();
        } else {
            player.getPayment(price);
            this.balance = sum;
        }
    }
    /**
     * Pay a specified price without involving another player.
     *
     * param price The price to be paid.
     */
    public void Pay(int price) {
        int sum = this.balance - price;
        if (sum <= 0) {
            this.Losed();
        } else {
            this.balance = sum;
        }
    }

    /**
     * Handle the player's loss in the game.
     * Mark the player as lost and release ownership of properties.
     */
    private void Losed() {
        this.loseGame = true;
        for (Field_property field : properties) {
            field.loseOwner();
        }
    }

    public boolean isLost() {
        return this.loseGame;
    }

    /**
     * Check if the player is the owner of a property.
     *
     * param field The field to check ownership for.
     * return True if the player is the owner, false otherwise.
     */
    public boolean isOwnerOf(Field field) {
        if (!(field instanceof Field_property)) {
            return false;
        }

        return (((Field_property) field).getOwner() == this);
    }

    /**
     * Check if the player can buy a property.
     *
     * param field The property to check affordability for.
     * return True if the player can afford to buy the property, false otherwise.
     */
    public boolean isCanBuy(Field_property field) {
        return this.balance - field.getPriceNeedToBuy() > 0;
    }

    /**
     * Determine if the player wants to buy a property.
     *
     * param field The property the player is considering.
     * return True if the player wants to buy the property, false otherwise.
     */
    public abstract boolean decideNeedToBuy(Field_property field);

    /**
     * Get a string representation of the player.
     *
     * return The player's name.
     */
    @Override
    public String toString() {
        return this.name;
    }
}
