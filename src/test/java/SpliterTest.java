import org.junit.Test;
import utils.CustomSplitter;
import utils.DefaultSplitter;
import utils.Spliter;

import static org.junit.Assert.assertArrayEquals;

public class SpliterTest {
    Spliter spliter;

    @Test
    public void defaultSplit(){
        spliter = new DefaultSplitter();
        assertArrayEquals(new String[]{"1","2","3"},spliter.split("1,2:3"));
    }

    @Test
    public void CustomSplitter(){
        spliter = new CustomSplitter();
        assertArrayEquals(new String[]{"1","2","3"},spliter.split("//;\n1;2;3"));
    }
}
