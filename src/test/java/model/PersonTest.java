package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    Person person;

    @Before
    public void setUp(){
        person = new Person();
    }

//    @Test
//    public void buyAutoLottoTest(){
//        int beforeLottoCount = person.getHistory().size();
//        person.buyAutoLotto();
//        int afterLottoCount = person.getHistory().size();
//        assertEquals(1, afterLottoCount-beforeLottoCount);
//    }
//
//    @Test
//    public void buyDirectLottoTest(){
//        int beforeLottoCount = person.getHistory().size();
//        person.buyDirectLotto("1, 2, 3, 4, 5, 6");
//        int afterLottoCount = person.getHistory().size();
//        assertEquals(1, afterLottoCount-beforeLottoCount);
//    }
}