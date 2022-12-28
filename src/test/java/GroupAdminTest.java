import static org.junit.jupiter.api.Assertions.*;

import observer.ConcreteMember;
import observer.GroupAdmin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GroupAdminTest {
    GroupAdmin admin;
    ConcreteMember member1, member2;

    @BeforeEach
    void setUp() throws Exception {
        // Initialize the GroupAdmin and members before each test
        admin = new GroupAdmin();
        member1 = new ConcreteMember();
        member2 = new ConcreteMember();
    }

    @Test
    void testInsert() {
        // Register the members with the GroupAdmin
        admin.register(member1);
        admin.register(member2);
        admin.append(" World");
        admin.insert(0, "Hello");
        // Check that the members were updated with the new string
        assertEquals(member1.usb.toString(), "Hello World");
        assertEquals(member2.usb.toString(), "Hello World");
        assertEquals(2,admin.members.size());
        admin.unregister(member1);
        admin.unregister(member2);
        assertEquals(0,admin.members.size());

    }

    @Test
    void testAppend() {
        // Register the members with the GroupAdmin
        admin.register(member1);
        admin.register(member2);
        // Append a string to the UndoableStringBuilder
        admin.append("Hello");
        // Check that the members were updated with the new string
        assertEquals(member1.usb.toString(), "Hello");
        assertEquals(member2.usb.toString(), "Hello");
        admin.append(" World");
        assertEquals(member1.usb.toString(), "Hello World");
        assertEquals(member2.usb.toString(), "Hello World");
    }

    @Test
    void testDelete() {
        // Register the members with the GroupAdmin
        admin.register(member1);
        admin.register(member2);
        admin.append(" World");
        // Insert a string into the UndoableStringBuilder
        admin.insert(0, "Hello");
        // Delete a range of characters from the string
        admin.delete(0, 5);
        // Check that the members were updated with the new string
        assertEquals(member1.usb.toString(), " World");
        assertEquals(member2.usb.toString(), " World");
        admin.delete(0, 6);
        assertEquals(member1.usb.toString(), "");
        assertEquals(member2.usb.toString(), "");
    }

    @Test
    void testUndo() {
        // Register the members with the GroupAdmin
        admin.register(member1);
        admin.register(member2);
        // Insert a string into the UndoableStringBuilder
        admin.insert(0, "Hello");
        // Undo the insert action
        admin.undo();
        // Check that the members were updated with the new string
        assertEquals(member1.usb.toString(), "");
        assertEquals(member2.usb.toString(), "");
        admin.append("to be or not to be");
        admin.append(" or to eat or not to eat");
        admin.undo();
        admin.undo();
        assertEquals(member1.usb.toString(), "");
        assertEquals(member2.usb.toString(), "");

    }


}