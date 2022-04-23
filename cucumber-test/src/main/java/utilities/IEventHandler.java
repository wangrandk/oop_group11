package utilities;

public interface IEventHandler {

    /**
     * A listener class needs to implement this method.
     * Inside this is specified what to do when events that
     * are of interest to the listener class is published.
     * @param evt The event that is published.
     * @param o The first object that follows along with the published event.
     * @param o2 The second object that follows along with the published event.
     */
    void onEvent(EventList.Event evt, Object o1, Object o2);
}
