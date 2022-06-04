import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

public class StringParsingUtils {
    public static final String COMMA = ",";
    public static final String BLANK = " ";
    public static final String EMPTY = "";

    public List<Integer> stringParsing(String string) {
        String[] winningLottoNumberArray = removeBlank(string).split(SPLIT_SIGN);
        List<Integer> winningLottoNumberList = new ArrayList<>();
        for (String s : winningLottoNumberArray) {
            winningLottoNumberList.add(parseInt(s));
        }
        return winningLottoNumberList;
    }

    private String removeBlank(String string){

        return string.replaceAll(" ", "");
    }
}