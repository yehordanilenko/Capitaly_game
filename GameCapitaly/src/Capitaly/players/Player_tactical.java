package Capitaly.players;

import Capitaly.fields.Field_property;


public class Player_tactical extends Player {
    private boolean isBuyingTime;

    public Player_tactical(String name) {
        super(name);
        this.isBuyingTime = true;
    }

    /**
     * Decide whether to buy a property as a tactical player.
     * Tactical players alternate between buying and not buying properties.
     *
     * param field The property the player is considering buying.
     * return True if the player decides to buy the property, false otherwise.
     */
    @Override
    public boolean decideNeedToBuy(Field_property field) {
        if (isBuyingTime) {
            isBuyingTime = !isBuyingTime;
            if (this.isCanBuy(field)) {
                if (field.hasHouse()) {
                    this.balance -= field.getPriceNeedToBuyHouse();
                } else {
                    this.balance -= field.getPriceNeedToBuy();
                    this.properties.add(field);
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
