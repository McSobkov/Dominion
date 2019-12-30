package core;

/**
 * Names of cards in game
 */
public enum CardName {
    COPPER, SILVER, GOLD,                                                               // Treasure
    CURSE,                                                                              // Curse
    ESTATE, DUCHY, PROVINCE,                                                            // Victory
    CELLAR, CHAPEL, MOAT,                                                               // 2 Cost
    HARBINGER, MERCHANT, VASSAL, VILLAGE, WORKSHOP,                                     // 3 Cost
    BUREAUCRAT, GARDENS, MILITIA, MONEYLENDER, POACHER, REMODEL, SMITHY, THRONE_ROOM,   // 4 Cost
    BANDIT, COUNCIL_ROOM, FESTIVAL, LABORATORY, LIBRARY, MARKET, MINE, SENTRY, WITCH,   // 5 Cost
    ARTISAN;                                                                             // 6 Cost

    /**
     * @param name of card
     * @return the enumeration of the card name
     */
    public static CardName nameFromString(String name){
        switch (name){
            case "Copper": return COPPER;
            case "Silver": return SILVER;
            case "Gold": return GOLD;

            case "Curse": return CURSE;

            case "Estate": return ESTATE;
            case "Duchy": return DUCHY;
            case "Province": return PROVINCE;

            case "Cellar": return CELLAR;
            case "Chapel": return CHAPEL;
            case "Moat": return MOAT;

            case "Harbinger": return HARBINGER;
            case "Merchant": return MERCHANT;
            case "Vassal": return VASSAL;
            case "Village": return VILLAGE;
            case "Workshop": return WORKSHOP;

            case "Bureaucrat": return BUREAUCRAT;
            case "Gardens": return GARDENS;
            case "Militia": return MILITIA;
            case "Moneylender": return MONEYLENDER;
            case "Poacher": return POACHER;
            case "Remodel": return REMODEL;
            case "Smithy": return SMITHY;
            case "Throne_Room": return THRONE_ROOM;

            case "Bandit": return BANDIT;
            case "Council_Room": return COUNCIL_ROOM;
            case "Festival": return FESTIVAL;
            case "Laboratory": return LABORATORY;
            case "Library": return LIBRARY;
            case "Market": return MARKET;
            case "Mine": return MINE;
            case "Sentry": return SENTRY;
            case "Witch": return WITCH;

            case "Artisan": return ARTISAN;

            default: return null;

        }
    }
}
