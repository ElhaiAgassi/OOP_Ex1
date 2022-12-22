package observer;

/**
 * A concrete implementation of the Member interface.
 * <p>
 * This class represents a member who is registered to receive updates from a SharedUndoableStringBuilder object.
 */
public class ConcreteMember implements Member {
    public UndoableStringBuilder usb;

    public ConcreteMember() {
        this.usb = new UndoableStringBuilder();
    }

    /**
     * Updates the member with the latest state of the shared UndoableStringBuilder object.
     *
     * @param usb The shared UndoableStringBuilder object.
     */
    @Override
    public void update(UndoableStringBuilder usb) {
        this.usb = usb;
        System.out.println(this+" got the message: "+usb.toString());
    }
}

