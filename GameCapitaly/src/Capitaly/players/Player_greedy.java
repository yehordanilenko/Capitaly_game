package Capitaly.players;

import Capitaly.fields.*;


public class Player_greedy extends Player {

    public Player_greedy(String name) {
        super(name);
    }

    /**
     * Decide whether to buy a property as a greedy player.
     * This player type always attempts to buy properties if they can afford them.
     *
     * param field The property the player is considering buying.
     * return True if the player decides to buy the property, false otherwise.
     */
    @Override
    public boolean decideNeedToBuy(Field_property field) {
        if (this.isCanBuy(field)) {
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