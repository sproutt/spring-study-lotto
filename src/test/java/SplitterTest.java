import org.junit.Test;
import utils.CustomSplitter;
import utils.DefaultSplitter;
import utils.Splitter;

import static org.junit.Assert.assertArrayEquals;

public class SplitterTest {
    private Splitter splitter;

    @Test
    public void defaultSplit() throws Exception {
        splitter = new DefaultSplitter();
        assertArrayEquals(new String[]{"1", "2", "3"}, splitter.split("1,2:3"));
    }

    @Test
    public void CustomSplitter() throws Exception {
        splitter = new CustomSplitter();
        assertArrayEquals(new String[]{"1", "2", "3"}, splitter.split("//;\n1;2;3"));
    }
}
