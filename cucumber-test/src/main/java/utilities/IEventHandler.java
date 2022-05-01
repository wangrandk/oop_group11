package utilities;

public interface IEventHandler {

    /**
     * A listener class needs to implement this method.
     * Inside this is specified what to do when events that
     */
    void onEvent(EventList.Event evt, Object o1, Object o2);
}
