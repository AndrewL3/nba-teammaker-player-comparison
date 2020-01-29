//package tests;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import model.Guard;
//import model.ListOfPlayer;
//import model.Player;
//import Exceptions.TooFullException;
//
//import static org.jsoup.helper.Validate.fail;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//
//public class TestListOfPlayer {
//
//    private ListOfPlayer lop;
//    private Player p;
//    private Guard g;
//    String nom = "";
//    int pts = 0;
//    String pos = "";
//
//
//    @BeforeEach
//    public void setup() {
//
//        lop = new ListOfPlayer();
//        g = new Guard(nom, pts, pos, points);
//
//    }
//
//    @Test
//    public void TestEmpty (){
//        assertTrue(lop.size() == 0);
//
//    }
//
//
//
//    @Test
//    public void TestFullTeamCausesTooFullException () {
//        if (lop.size() > lop.MAX_SIZE) {
//            try {
//                lop.addPlayer(g);
//                fail("Did not catch exception");
//            } catch (TooFullException e) {
//
//            } catch (Exception e) {
//                fail("Wrong exception");
//
//
//            }
//        }
//
//    }
//
//
//}
