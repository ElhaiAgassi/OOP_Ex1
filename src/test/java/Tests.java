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
//    // stub method to check external dependencies compatibility

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
    void testGroupAdmin() {

        // register the members
        admin.register(member1);
        admin.register(member2);

        // insert a string at index 2
        admin.insert(2, "hello");
        logger.info(()->JvmUtilities.jvmInfo());
        logger.info(()->JvmUtilities.objectTotalSize(admin,member1,member2));
        logger.info(()->JvmUtilities.objectFootprint(admin, member1, member2));

        // append a string
        admin.append("world");
        logger.info(()->JvmUtilities.jvmInfo());
        logger.info(()->JvmUtilities.objectTotalSize(admin,member1,member2));
        logger.info(()->JvmUtilities.objectFootprint(admin, member1, member2));

        // delete a range of characters
        admin.delete(2, 5);
        logger.info(()->JvmUtilities.jvmInfo());
        logger.info(()->JvmUtilities.objectTotalSize(admin,member1,member2));
        logger.info(()->JvmUtilities.objectFootprint(admin, member1, member2));

        // undo the delete action
        admin.undo();
        logger.info(()->JvmUtilities.jvmInfo());
        logger.info(()->JvmUtilities.objectTotalSize(admin,member1,member2));
        logger.info(()->JvmUtilities.objectFootprint(admin, member1, member2));

        // unregister a member
        admin.unregister(member2);
        logger.info(()->JvmUtilities.jvmInfo());
        logger.info(()->JvmUtilities.objectTotalSize(admin,member1,member2));
        logger.info(()->JvmUtilities.objectFootprint(admin, member1));
    }
    }


