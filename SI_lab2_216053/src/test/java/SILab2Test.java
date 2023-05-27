import org.junit.jupiter.api.Test;

import java.lang.reflect.Executable;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;



class SILab2Test {

    @Test
    void functionEveryBranch() {
        User user0 = null;
        List<User> list0 = new ArrayList<User>();
        User userInList0 = new User("pero@gmail.com","gbyukj","pero@gmail.com");
        list0.add(userInList0);
        RuntimeException ex = assertThrows(RuntimeException.class, () -> SILab2.function(user0,list0));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        User user1 = new User(null,"hyt6ry","pero@gmail.com");
        List<User> list1 = new ArrayList<User>();
        User userInList1 = new User("pero@gmail.com","gbyukj","pero@gmail.com");
        list1.add(userInList1);
        assertFalse(SILab2.function(user1, list1));

        User user2 = new User("pero","hyt6rhughyuky","pero@gmail.com");
        List<User> list2 = new ArrayList<User>();
        User userInList2 = new User("pero12@gmail.com","gbyukj","pero123@gmail.com");
        list2.add(userInList2);
        assertFalse(SILab2.function(user2, list2));

        User user3 = new User("pero","hyt6rhu ghyuky","pero.gmail.com");
        List<User> list3 = new ArrayList<User>();
        User userInList3 = new User("pero12@gmail.com","gbyukj","pero123@gmail.com");
        list3.add(userInList3);
        assertFalse(SILab2.function(user3, list3));

        User user4 = new User("pero","hyt6r!ughyuky","pero.gmail.com");
        List<User> list4 = new ArrayList<User>();
        User userInList4 = new User("pero12@gmail.com","gbyukj","pero123@gmail.com");
        list4.add(userInList4);
        assertFalse(SILab2.function(user4, list4));
    }

    @Test
    void functionMultipleCondition(){

        //T || X || X
        User user0 = null;
        List<User> list0 = new ArrayList<User>();
        RuntimeException ex0 = assertThrows(RuntimeException.class, () -> SILab2.function(user0,list0));
        assertTrue(ex0.getMessage().contains("Mandatory information missing!"));

        //F || T || X
        User user1 = new User("hgtdbgd",null,"pero@gmail.com");
        List<User> list1 = new ArrayList<User>();
        RuntimeException ex1 = assertThrows(RuntimeException.class, () -> SILab2.function(user1,list1));
        assertTrue(ex1.getMessage().contains("Mandatory information missing!"));

        //F || F || T
        User user2 = new User("hgtdbgd","vgtyuibuk",null);
        List<User> list2 = new ArrayList<User>();
        RuntimeException ex2 = assertThrows(RuntimeException.class, () -> SILab2.function(user2,list2));
        assertTrue(ex2.getMessage().contains("Mandatory information missing!"));

        //F || F || F
        User user3 = new User("hgtdbgd","vgtyuibuk","pero@gmail.com");
        List<User> list3 = new ArrayList<User>();
        User userInList3 = new User("pero12@gmail.com","gbyukj","pero123@gmail.com");
        list3.add(userInList3);
        assertFalse(SILab2.function(user3, list3));
    }
}