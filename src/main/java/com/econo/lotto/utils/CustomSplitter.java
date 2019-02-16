package com.econo.lotto.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSplitter implements Splitter {

    @Override
    public boolean supports(String string) {

        return Pattern.compile("//(.)\n(.*)").matcher(string).find();
    }

    @Override
    public String[] split(String string) {

        return toStringWithoutSeparator(string).split(getSeparator(string));
    }

    public String toStringWithoutSeparator(String string) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(string);
        matcher.matches();

        return matcher.group(2);
    }

    public String getSeparator(String stringWithSeparator) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(stringWithSeparator);
        matcher.matches();

        return matcher.group(1);
    }
}
