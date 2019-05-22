package model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PersonTest {

    Person person;

    @Before
    public void setUp(){
        person = new Person();
    }

    @Test
    public void buyLotto_AutoLottoTest(){
        assertEquals(10, person.buyLotto(10000, new ArrayList<>()).size());
    }

    @Test
    public void buyLotto_DirectLottoTest(){
        List<String> lottoNumbers = new ArrayList<>();
        lottoNumbers.add("1, 2, 3, 4, 5, 6");
        List<String> history = person.buyLotto(10000, lottoNumbers);
        assertEquals(10, history.size());
        assertTrue(history.contains("[1, 2, 3, 4, 5, 6]"));
    }
}