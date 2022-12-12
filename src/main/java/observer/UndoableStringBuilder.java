package observer;
import java.util.EmptyStackException;
import java.util.Stack;

/*
 * @author Elhai Agassi & Danielle Musai
 */
public class UndoableStringBuilder {
    StringBuilder the_string;
    Stack<String> memory;

    public UndoableStringBuilder() {
        the_string = new StringBuilder();
        memory = new Stack<>();
    }

    public UndoableStringBuilder(String str) {
        the_string = new StringBuilder();
        memory = new Stack<>();
        memory.push(the_string.append(str).toString());

    }

    @Override
    public String toString() {
        return this.the_string.toString();
    }

    /**
     * appends the specified string to this character sequence
     *
     * @param str an absolute URL giving the base location of the image
     * @see StringBuilder
     * StringBuilder
     */

    public void append(String str) {
        memory.add(this.the_string.append(str).toString());
    }

    /**
     * Removes the characters in a substring of this sequence. The substring begins
     * at the specified start and extends to the character at index
     * end - 1 or to the end of the sequence if no such character exists.
     * If start is equal to end, no changes are made.
     * <p>
     * StringIndexOutOfBoundsException - if start is negative,greater than length(), or greater than end.
     *
     * @param start - the first number
     * @param end   - the second number
     * @return what we get from those numbers
     */

    public StringBuilder delete(int start, int end) throws Exception {
        if (0 > start || start >= the_string.length() || start > end) {
            throw new Exception("Out of bound Exception");
        } else {
            memory.add(the_string.delete(start, end).toString());
            return the_string;
        }
    }

    /**
     * Inserts the string into this character sequence.
     * StringIndexOutOfBoundsException - if the offset is invalid.
     *
     * @param offset - the first number
     * @param str    - the string who get into this sentence
     * @return - what we get from the combination those two.
     */

    public StringBuilder insert(int offset, String str) throws Exception {
        if (the_string.length() - 1 < offset) {
            throw new Exception("Out of bound Exception");
        } else {
            memory.add(the_string.insert(offset, str).toString());
            return the_string;
        }
    }

    /**
     * Replaces the characters in a substring of this sequence with characters in
     * the specified String. The substring begins at the specified start and
     * extends to the character at index end - 1 or to the end of the sequence if
     * no such character exists. First the characters in the substring are removed
     * and then the specified String is inserted at start. (This sequence will be
     * lengthened to accommodate the specified String if necessary).
     * StringIndexOutOfBoundsException - if start is negative, greater than length(), or greater than end.
     *
     * @param start - the first number
     * @param end   - the second number
     */

    public void replace(int start, int end, String str) throws Exception {
        if (0 > start || start > the_string.length() || start > end) {
            throw new Exception("Out of bound Exception");
        } else {
            memory.add(this.the_string.replace(start, end, str).toString());
        }
    }

    /**
     * Causes this character sequence to be replaced by the reverse of the
     * sequence.
     */

    public void reverse() {
        memory.add(the_string.reverse().toString());
    }

    /**
     * undo allows users to correct their mistakes and also to try out different aspects of the
     * application without risk of repercussions. At minimum, an undo/redo mechanism should provide
     * users with the ability to: Un-execute (undo) the last action they just performed.
     * Re-execute (redo) the last undone action
     */

    public void undo() {
        try {
            this.memory.pop();
            this.the_string = (new StringBuilder());
            this.the_string.append(this.memory.peek());
        } catch (EmptyStackException e) {
            System.out.println("No changes happened earlier");
        }
    }
}

