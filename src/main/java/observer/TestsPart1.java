package observer;

import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class TestsPart1 {
    GroupAdmin admin = new GroupAdmin();
    ConcreteMember member1 = new ConcreteMember();
    ConcreteMember member2 = new ConcreteMember();

    @Test
    public void registerUnregister() {
        // Test registering and unregistering members
        admin.register(member1);
        admin.register(member2);
        assertEquals(2, admin.members.size());
        admin.unregister(member1);
        assertEquals(1, admin.members.size());
        admin.unregister(member2);
        assertEquals(0,admin.members.size());
    }

    @Test
    public void insert() {
        // Test insert & append method
        admin.register(member2);
        admin.append("Hello  ");
        member2.update(admin.usb);
        assertEquals(member2.usb.toString(),admin.usb.toString());
        assertEquals("Hello  ", "Hello  ");
        admin.append("world");
        assertEquals("Hello world", "Hello world");
        admin.insert(6, "-");
        assertEquals("Hello - world", admin.usb.toString());
        assertEquals(admin.usb.toString(),member2.usb.toString());
        admin.undo();
        assertEquals("Hello  world", admin.usb.toString());
        admin.register(member1);
        member1.update(admin.usb);
        assertEquals(member1.usb.toString(),admin.usb.toString());
        assertEquals(member1.usb.toString(),member2.usb.toString());

    }
    @Test
    public void delete(){
        // Test delete method
        admin.register(member2);
        admin.append("Hello World");
        admin.delete(5, 11);
        assertEquals("Hello", member2.usb.toString());
        admin.delete(0,5);
        assertEquals("", member2.usb.toString());
        admin.undo();
        assertEquals("Hello", member2.usb.toString());


    }
}

