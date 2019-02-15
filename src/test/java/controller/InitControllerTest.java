package controller;

import model.Function;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class InitControllerTest {

    InitController initController;

    @Before
    public void setUp() throws Exception {
        initController = new InitController();
    }

    @Test
    public void isCustomSetting() {
        assertEquals(true,initController.isCustomSetting("//;\\n1;2;3"));
    }

    @Test
    public void initFunction(){
        Function function = initController.initFunction("1,2");
        String[] answer = new String[2];
        answer[0] = "1";
        answer[1] = "2";
        assertArrayEquals(answer,function.getNumbers());
    }

}