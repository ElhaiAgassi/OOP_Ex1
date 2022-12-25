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
    ConcreteMember member1, member2;


    @BeforeEach
    void setUp() throws Exception {
        // Initialize the GroupAdmin and members before each test
        admin = new GroupAdmin();
        member1 = new ConcreteMember();
        member2 = new ConcreteMember();
    }
    @Test
    void test1() {
        // Register the members with the GroupAdmin
        admin.register(member1);
        admin.register(member2);
        // The total size of the 2 objects
        logger.info(()->JvmUtilities.objectTotalSize(member1,member2));
        logger.info(()->JvmUtilities.objectTotalSize(admin));
        admin.append("Hello");
        logger.info(()->JvmUtilities.objectTotalSize(admin));
        admin.unregister(member1);
        logger.info(()->JvmUtilities.objectTotalSize(admin));
        logger.info(() -> JvmUtilities.jvmInfo());
    }

    @Test
    void Test2(){
        // Register the members with the GroupAdmin
        admin.register(member1);
        admin.register(member2);
        admin.append("Hello ");
        admin.insert(5, " World");
        // Object total size with Insert
        logger.info(()->JvmUtilities.objectTotalSize(admin));
        admin.delete(0,6);
        // Object total size with Delete
        logger.info(()->JvmUtilities.objectTotalSize(admin));
        admin.undo();
        // Object total size with Undo
        logger.info(()->JvmUtilities.objectTotalSize(admin));
        admin.undo();
        admin.undo();
        logger.info(()->JvmUtilities.objectTotalSize(admin));
        logger.info(()->JvmUtilities.objectTotalSize(member1,member2));
    }




    }


