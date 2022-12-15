package observer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        GroupAdmin admin = new GroupAdmin();

        ConcreteMember member1 = new ConcreteMember();
        ConcreteMember member2 = new ConcreteMember();

        admin.register(member1);
        admin.register(member2);

        admin.append("I am your father");
        admin.delete(0,2);


    }
}
