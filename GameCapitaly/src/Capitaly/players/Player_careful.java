package Capitaly.players;

import Capitaly.fields.Field_property;


public class Player_careful extends Player {

    public Player_careful(String name) {
        super(name);
    }

    /**
     * Decide whether to buy a property as a careful player.
     * This decision is based on the available balance.
     *
     * param field The property the player is considering buying.
     * return True if the player decides to buy the property, false otherwise.
     */
    @Override
    public boolean decideNeedToBuy(Field_property field) {
        if (this.balance / 2 > field.getPriceNeedToBuy()) {
            this.balance -= field.getPriceNeedToBuy();
            if (!field.hasHouse()) {
                this.properties.add(field);
            }
            return true;
        } else {
            return false;
        }
    }
}