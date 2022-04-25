package model.main;

import java.util.ArrayList;
import java.util.Iterator;

import model.Game;
import model.board.Board;
import utilities.EventList;
import utilities.GameSettings;

public class Turn {
	private final Game model;
    private final ArrayList<Player> players;
    private final int turnIndex;
    private final ArrayList<RegisterCard> activeCards = new ArrayList<>();
    private final Map<RegisterCard,Player> activeCardPlayer = new HashMap<>();
    private final Board board;

    /**
     * Creates the turn and runs the start method that performs all tasks needed for a turn.
     * @param model The top model class of the current game that holds useful information.
     * @param turnIndex The index of the turn in the current round. Can be 1 to 5.
     */
    public Turn(Game model, int turnIndex) {
        this.model = model;
        this.board = model.getBoard();
        this.players = this.model.getPlayers();
        this.turnIndex = turnIndex;
        startTurn();
    }

    /*
    Main method
     */

    /**
     * Main method that calls all the help methods to perform the tasks needed for a turn.
     */
    private void startTurn() {
        revealProgrammedCards();
        sortActiveCards();
        executeActiveCards();
        executeBoardElements();
        new FireLasers(players);
        checkIfOnlyOneSurvivor();
        EventTram.getInstance().publish(EventTram.Event.UPDATE_BOARD, null, null);
        EventTram.getInstance().publish(EventTram.Event.UPDATE_STATUS, null, null);
    }

    /*
    Help methods
     */

    /**
     * Loop through all player and their cards and set card with the turnIndex
     * to visible for all players. Also adds them to a list for sorting.
     */
    private void revealProgrammedCards() {
        for (Player player : players) {
            RegisterCard card = player.getProgrammedCard(turnIndex);
            card.setHidden(false);
            activeCards.add(card);
            activeCardPlayer.put(card,player);
            System.out.println("picked card with index " + turnIndex + " from " + player.getName());
        }
    }

    /**
     * Sorts the active cards to bring the card with highest priority to the top.
     * This will be the card that will be executed first.
     */
    private void sortActiveCards() {
        Collections.sort(activeCards, new RegisterCardCompare());
    }

    /**
     * Loops through the sorted cards and calls the execute method if a player is alive.
     */
    private void executeActiveCards() {
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, "ANALYSING CARDS" + "\n", Color.MAGENTA);
        for (RegisterCard card : activeCards) {
            Player player = activeCardPlayer.get(card);
            if (player.isAlive()) {
                ArrayList<GameAction> actions = card.getActions();
                EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, "Priority " + card.getPoints() + ": \n", null);
                EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE,  player.getName() + " ", player.getColor());
                EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE,  card.getMessage() + "\n", null);
                for (GameAction action : actions) {
                    player.setMovingDirection(player.getDirection());
                    executeAction(action,player);
                }
            }
        }
    }

    /**
     * Performs the given action for the given player.
     * If the action is a move action the method checks if the player can
     * move there. If it can it checks if there is another player present
     * at the new position. If there is, it calls itself again on that player.
     * This creates the "pushing" logic on the board.
     * If any of these modes fail the methods returns false which causes
     * all of the movement for all players in the chain to be aborted.
     * This creates the "hitting a wall" logic on the board.
     * @param action The game action to be performed.
     * @param player The player to be affected by the action.
     * @return True if all whole action chain is good, false if any action fails.
     */
    private boolean executeAction(GameAction action, Player player) {
        action.doAction(player);
        if (action instanceof MovePlayer || action instanceof BackUpPlayer) {
            if (!playerIsHittingWall(player)) {
                if (enemyAtNextPosition(player.getNextPosition()) != null) {
                    Player enemy = enemyAtNextPosition(player.getNextPosition());
                    enemy.setMovingDirection(player.getMovingDirection());
                    if (executeAction(new MovePlayer(), enemy)) {
                        player.setPosition(player.getNextPosition().clone());
                        for (GameAction tileBeforeAction : board.getTile(player.getPosition()).getBeforeAction()) {
                            tileBeforeAction.doAction(player);
                        }
                        return true;
                    }
                } else {
                    player.setPosition(player.getNextPosition().clone());
                    try {

                        for (GameAction tileBeforeAction : board.getTile(player.getPosition()).getBeforeAction()) {
                            tileBeforeAction.doAction(player);
                        }
                        return true;

                    } catch (ArrayIndexOutOfBoundsException e) {
                        // If player is out of bounds we kill him
                        System.out.println("Player fell of board and died");
                        player.kill();
                    }
                }
            }
        }
        return false;
    }

    /**
     * Returns if a player is hitting a wall when moving to its new position.
     * @param player The player to check.
     * @return True if player would hit a wall, false if not.
     */
    private boolean playerIsHittingWall(Player player) {
        for (Attribute attribute: model.getBoard().getTile(player.getPosition()).getBeforeAttributes()) {
            if (attribute instanceof WallAttribute) {
                if (player.getMovingDirection() == (((WallAttribute) attribute).getDirection())){
                    return true;
                }
            }
        }
        try {
            for (Attribute attribute: model.getBoard().getTile(player.getNextPosition()).getBeforeAttributes()) {
                if (attribute instanceof WallAttribute) {
                    if (player.getMovingDirection() == (((WallAttribute) attribute).getDirection().getOpposite())) {
                        return true;
                    }
                }
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Check if there is another player at a position and returns that player if there is.
     * @param position The position to check.
     * @return A player if found, otherwise null.
     */
    private Player enemyAtNextPosition(Position position) {
        for (Player enemy : players) {
            if (position.equals(enemy.getPosition())) {
                return enemy;
            }
        }
        return null;
    }

    // TODO Give priority to gametiles so we can execute some tiles before others
    private void executeBoardElements() {
        EventList.getInstance().publish(EventList.Event.PRINT_MESSAGE, "TILE ACTIONS" + "\n" , Color.MAGENTA);
        for (Player player : players) {
            if (player.isAlive()) {
                try {
                    for (GameAction action : model.getBoard().getTile(player.getPosition()).getActions()) {
                        // TODO Set player moving direction from tiles direction
                        executeAction(action, player);
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Player fell and died");
                    player.kill();
                }
            }
        }
    }

    /**
     * Checks if only one player is dead and all others are alive
     */ 
    /* [James] complete this method */
    private void checkIfSomeoneDead() {
        int nbrPlayersKaput = 0;
        for (Player player : players) {
            if (player.getPlayerStatus() == GameSettings.PlayerStatus.DEAD) {
                nbrPlayersKaput++;
            }
        }
        if (nbrPlayersKaput != 0) {
            endGameSurvivor();
        } else {
            System.out.print("Everybody not dead, continue ");
        }
    }

    /**
     * Method only called when one player is dead
     */
    private void endGameSurvivor() {
    	Iterator<Player> itr = players.iterator();
        while(itr.hasNext()) {
        	Player player = itr.next();
            if (player.getPlayerStatus() == GameSettings.PlayerStatus.DEAD) {
                itr.remove();
            }
        }
        for(Player player : players) {
        	EventList.getInstance().publish(EventList.Event.VICTORY, player, null);
        	/*[James] Not sure is this method work as still not very know how the "publish" works.
        	 * Maybe need to modify*/
        }  
    }
}
