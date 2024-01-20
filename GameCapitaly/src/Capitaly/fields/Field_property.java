package Capitaly.fields;

import Capitaly.Capitaly;
import Capitaly.players.Player;


public class Field_property extends Field {
    protected boolean house;
    protected int priceHouse;
    protected Player owner;

    /**
     * Constructor for Field_property. Initializes the price, priceHouse, house, and owner.
     */
    public Field_property() {
        super();
        this.price = 1000;
        this.priceHouse = 4000;
        this.house = false;
        this.owner = null;
    }

    /**
     * Resets the owner and house status for the property.
     */
    public void loseOwner() {
        this.owner = null;
        this.house = false;
    }

    /**
     * Perform the action associated with the Property field when a player lands on it.
     *
     * param player The player who landed on the Property field.
     */
    @Override
    public void FieldAct(Player player) {
        if (this.hasOwner()) {
            if (!(player.isOwnerOf(this))) {
                Capitaly.printData(this.getPriceNeedToPay(), player + " pays " + this.owner, 1);
                player.Pay(this.getPriceNeedToPay(), this.owner);
            } else if (!this.house) {
                Capitaly.printData(this.getPriceNeedToBuy(), player + " buy a house ", 1);
                if (player.decideNeedToBuy(this)) {
                    this.house = true;
                }
            }
        } else {
            if (player.decideNeedToBuy(this)) {
                Capitaly.printData(this.getPriceNeedToBuy(), player + " buy a field ", 1);
                this.setOwner(player);
            }
        }
    }

    public Player getOwner() {
        return owner;
    }
    /**
     * Check if the property has an owner.
     *
     * return True if the property has an owner, false otherwise.
     */
    public boolean hasOwner() {
        return owner != null;
    }

    public void setOwner(Player player) {
        this.owner = player;
    }

    public boolean hasHouse() {
        return this.house;
    }

    public int getPriceNeedToPay() {
        if (!this.house) {
            return 500;
        } else {
            return 2000;
        }
    }

    public int getPriceNeedToBuy() {
        if (this.house) {
            return this.priceHouse;
        } else {
            return this.price;
        }
    }

    public int getPriceNeedToBuyHouse() {
        return this.priceHouse;
    }
    /**
     * Get a string representation of the Property field.
     *
     * return A string representation of the Property field.
     */
    @Override
    public String toString() {
        return "Field Property";
    }
}