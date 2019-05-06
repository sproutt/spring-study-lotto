package model;

import util.SplitGenerator;

import java.util.Spliterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public int add(String input){
        if(isBlank(input))
            return 0;
        int result = 0;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);

            for (int i=0; i<tokens.length; i++){
                if(Integer.parseInt(tokens[i])<0){
                    throw new RuntimeException();
                }
                result+=Integer.parseInt(tokens[i]);
            }
        }else{
            String[] tokens = SplitGenerator.getSplitString(input, ",|:");
            for (int i=0; i<tokens.length; i++) {
                if (Integer.parseInt(tokens[i]) < 0) {
                    throw new RuntimeException();
                }
                result += Integer.parseInt(tokens[i]);
            }
        }
        return result;
    }

    private boolean isBlank(String input){
        if(input==null || input=="")
            return true;
        return false;
    }

}