package util;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StreamGeneratorTest {

    @Test
    public void toIntListTest() {
        List<Integer> str = StreamGenerator.toIntList(new String[]{"1", "2", "3", "4"});
        assertEquals(4, str.size());
    }
}