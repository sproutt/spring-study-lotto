import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringParsingUtils {
    public static final String COMMA = ",";
    public static final String BLANK = " ";
    public static final String EMPTY = "";

    public static List<Integer> parseToNumber(String input) {
        String[] stringParsedInput = splitWithComma(removeBlank(input));
        return Arrays.stream(stringParsedInput)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static List<LottoNumber> parseToLottoNumber(String input) {
        String[] stringParsedInput = splitWithComma(removeBlank(input));
        return Arrays.stream(stringParsedInput)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public static String[] splitWithComma(String input) {
        return input.split(COMMA);
    }

    public static String removeBlank(String input) {
        return input.replaceAll(BLANK, EMPTY);
    }
}