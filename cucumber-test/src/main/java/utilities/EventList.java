package utilities;

import java.util.ArrayList;

public class EventList {

    private static EventList tram;
    private boolean trace = true;
    private final ArrayList<IEventHandler> handlers = new ArrayList<>();

    public static EventList getInstance(){
        if (tram == null){
            tram = new EventList();
        }
        return tram;
    }

    public enum Event {

        PRINT_MESSAGE,

        
        MAP_SELECTED,

        MODEL_CREATED,

        START_GAME,

        SHOW_GAMEPANEL,

        NEW_ROUND,

        PICK_CARDS,

        PLAYER_PICKED_CARDS,

        NEW_TURN,

        UPDATE_BOARD,
        
        UPDATE_STATUS,

        VICTORY
    }

    public void register(IEventHandler handler){
        handlers.add(handler);
    }

    /**
     * Use this to unregister a class as a listener for events.
     */
    public void unRegister(IEventHandler handler){
        handlers.remove(handler);
    }

    /**
     * Call this method to publish an event.
     */
    public void publish(Event evt, Object data, Object data2){

        if (trace && evt != Event.PRINT_MESSAGE){
            System.out.println(evt);
        }
        for (int i = 0; i < handlers.size(); i++) {
            IEventHandler handler = handlers.get(i);
            handler.onEvent(evt, data, data2);
        }
    }

    /**
     * If this is enabled all the events that occur will be printed to the terminal.
     */
    public void setTrace(boolean b){
        this.trace = b;
    }
}
