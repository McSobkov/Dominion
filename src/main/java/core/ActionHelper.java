package core;

import java.util.ArrayList;

public final class ActionHelper {
    private ActionHelper(){}

    /**
     *
     * @param trash pile
     * @param card being trashed
     * @return success
     */
    public static boolean trashCard(ArrayList<Card> trash, Card card){
        if(card == null) return false;
        trash.add(card);
        return true;
    }

}
