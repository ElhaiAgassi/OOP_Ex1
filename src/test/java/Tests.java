/**
 * In this class we are testing the various methods of the GroupAdmin class, including register,
 * insert, append, delete, and undo.
 * we are also testing the unregister method to ensure that it correctly removes a member from
 * the list of registered members.
 *
 * For each of these actions, we are using the JvmUtilities class to log information about the
 * Java Virtual Machine (JVM) and the objects being tested.
 * Specifically, we are logging the JVM info, the total size of the objects in memory,
 * and the footprint of the objects in memory.
 */


import observer.ConcreteMember;
import observer.GroupAdmin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    // stub method to check external dependencies compatibility

    GroupAdmin admin;
    ConcreteMember member1, member2, member3;


    @BeforeEach
    void setUp() throws Exception {
        // Initialize the GroupAdmin and members before each test
        admin = new GroupAdmin();
        member1 = new ConcreteMember();
        member2 = new ConcreteMember();
        member3 = new ConcreteMember();
    }

    @Test
    void testGroupAdmin() {
        // size of admin
        logger.info(()->JvmUtilities.objectTotalSize(admin));

        // register the members
        admin.register(member1);
        admin.register(member2);

        // append a string
        admin.append("hell ");

        // insert a string at index 4
        admin.insert(4, "o");
        logger.info(()->"the size after insert action :");
        logger.info(()->JvmUtilities.objectTotalSize(member1));
        logger.info(()->JvmUtilities.objectTotalSize(member2));
        // check if they both have the same size after insert
        assertEquals(JvmUtilities.objectTotalSize(member1),JvmUtilities.objectTotalSize(member2));

        // append a string
        admin.append(" world");
        logger.info(()->"the size after append action :");
        logger.info(()->JvmUtilities.objectTotalSize(member1));
        logger.info(()->JvmUtilities.objectTotalSize(member2));
        // check if they both have the same size after append
        assertEquals(JvmUtilities.objectTotalSize(member1),JvmUtilities.objectTotalSize(member2));


        // undo the delete action
        admin.undo();
        assertEquals("hello ",member1.usb.toString());
        logger.info(()->JvmUtilities.objectTotalSize(member1));

       // delete a range of characters
        admin.delete(0,1);
        assertEquals("ello ", member1.usb.toString());
        assertEquals(member1.usb.toString(),member2.usb.toString());

        // register a member
        admin.register(member3);
        logger.info(()->"the size after register a member :");
        logger.info(()->JvmUtilities.objectTotalSize(admin));

        // unregister a member
        admin.unregister(member3);
        logger.info(()->"the size after unregister a member :");
        logger.info(()->JvmUtilities.objectTotalSize(admin));

   }
    }


