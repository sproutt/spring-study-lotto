package util;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class SplitGeneratorTest {

    @Test
    public void customSplitStringTest() {
        assertThat(SplitGenerator.splitWithSign("1:2:3", ":")).contains("1","2","3");
        assertThat(SplitGenerator.splitWithSign("1,2,3", ",")).contains("1","2","3");
    }

    @Test
    public void customMixSplitStringTest() {
        assertThat(SplitGenerator.splitWithSign("1:2,3", ",|:")).contains("1","2","3");
    }
}