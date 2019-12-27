package core;

/**
 * Generic Core.Card class
 */
public final class Card {

    /**
     * Builder For Core.Card
     */
    public static class CardBuilder{

        private String name;
        private CardType type;
        private int cost;

        private int gold;
        private int action;
        private int buy;
        private int draw;
        private CardAction cardAction;

        /**
         * Builder to create a card
         * @param name of Core.Card
         * @param type of Core.Card
         * @param cost of Core.Card
         */
        public CardBuilder(String name, CardType type, int cost){
            this.name = name;
            this.type = type;
            this.cost = cost;
        }

        /**
         * @param extra gold on buy period
         * @return builder
         */
        public CardBuilder extraGold(int extra){
            if(type == CardType.KINGDOM){
                gold = extra;
            }
            return this;
        }

        /**
         * @param extra actions on action period
         * @return builder
         */
        public CardBuilder extraAction(int extra){
            if(type == CardType.KINGDOM){
                action = extra;
            }
            return this;
        }

        /**
         * @param extra buy on buy period
         * @return builder
         */
        public CardBuilder extraBuy(int extra){
            if(type == CardType.KINGDOM){
                buy = extra;
            }
            return this;
        }

        /**
         * @param extra cards on action period
         * @return builder
         */
        public CardBuilder extraCard(int extra){
            if(type == CardType.KINGDOM){
                draw = extra;
            }
            return this;
        }

        /**
         *
         * @param cardAction being employed
         * @return builder
         */
        public CardBuilder addCardAction(CardAction cardAction){
            this.cardAction = cardAction;
            return this;
        }

        /**
         * builds card
         * @return instance of card
         */
        public Card build(){
            Card card = new Card();
            card.name = this.name;
            card.type = this.type;
            card.cost = this.cost;

            card.gold = this.gold;
            card.action = this.action;
            card.buy = this.buy;
            card.draw = this.draw;
            card.cardAction = this.cardAction;

            return card;
        }



    }

    private String name;
    private CardType type;
    private int cost;

    private int gold;
    private int action;
    private int buy;
    private int draw;
    private CardAction cardAction;

    private Card(){}

    /**
     * Accessor card name
     * @return name of card
     */
    public String getName() { return name; }

    /**
     * Accessor for gold gained on turn
     * @return additional gold gained
     */
    public int getGold() { return gold; }

    /**
     * Accessor for actions gained on turn
     * @return additional actions gained
     */
    public int getAction() { return action; }

    /**
     * Accessor for buys gained on turn
     * @return additional buys gained
     */
    public int getBuy() { return buy; }

    /**
     * Accessor for draws
     * @return additional draws
     */
    public int getDraw() { return draw; }

    /**
     * Accessor for card action
     * @return action a card takes
     */
    public CardAction getCardAction() {
        return cardAction;
    }
}
