/**
 * GroupAdmin class is a sender that implements the Sender interface. It contains a list of members and an
 * UndoableStringBuilder object. GroupAdmin has methods to register and unregister members, insert and append
 * strings to the UndoableStringBuilder, delete strings from the UndoableStringBuilder, and undo previous
 * actions on the UndoableStringBuilder. It also has a notifyObservers method to update all registered members
 * with the current state of the UndoableStringBuilder.
 */
package observer;

import java.util.ArrayList;
import java.util.List;

public class GroupAdmin implements Sender {
    public List<Member> members;
    public UndoableStringBuilder usb;

    public GroupAdmin() {
        members = new ArrayList<>();
        usb = new UndoableStringBuilder();
    }

    /**
     * Registers a new member to the group.
     *
     * @param obj The member to be added to the group.
     */
    @Override
    public void register(Member obj) {
        members.add(obj);
    }

    /**
     * Removes a member from the group.
     *
     * @param obj The member to be removed from the group.
     */
    @Override
    public void unregister(Member obj) {
        members.remove(obj);
    }

    /**
     * Inserts a string into the shared UndoableStringBuilder object at the specified offset.
     *
     * @param offset The index at which the string should be inserted.
     * @param obj    The string to be inserted.
     */
    @Override
    public void insert(int offset, String obj) {
        try {
            usb.insert(offset, obj);
            notifyObservers();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Appends a string to the end of the shared UndoableStringBuilder object.
     *
     * @param obj The string to be appended.
     */
    @Override
    public void append(String obj) {
        usb.append(obj);
        notifyObservers();
    }

    /**
     * Deletes a specified range of characters from the shared UndoableStringBuilder object.
     *
     * @param start The index of the first character to be deleted.
     * @param end   The index of the last character to be deleted.
     */
    @Override
    public void delete(int start, int end) {
        try {
            usb.delete(start, end);
            notifyObservers();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Reverts the shared UndoableStringBuilder object to its previous state.
     */
    @Override
    public void undo() {
        usb.undo();
        notifyObservers();
    }

    /**
     * Notifies all registered members of changes to the shared UndoableStringBuilder object.
     */
    private void notifyObservers() {
        for (Member member : members) {
            member.update(this.usb);
        }
    }
}


