package com.econo.lotto.utils;

import java.util.regex.Pattern;

public interface Splitter {
    public static final Pattern pattern =  Pattern.compile("//(.)\n(.*)");

    public boolean supports(String string);

    public String[] split(String string);

}
