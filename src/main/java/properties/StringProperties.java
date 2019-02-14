package properties;

public class StringProperties {

    private final char CUSTOMSTARTER = '\\';
    private final char CUSTOMFINISHER = '\n';
    private final char INITADDERFIRST = ':';
    private final char INITADDERSECOND = ',';
    private final int CUSTOMSTARTPOSITION = 0;
    private final int CUSTOMFINISHPOSITION = 1;
    private final int CUSTOMPOSITION = 2;
    private final int FUNCTIONSTARTPOSITION = 3;

    public char getCUSTOMSTARTER() {
        return CUSTOMSTARTER;
    }

    public char getCUSTOMFINISHER() {
        return CUSTOMFINISHER;
    }

    public char getINITADDERFIRST() {
        return INITADDERFIRST;
    }

    public char getINITADDERSECOND() {
        return INITADDERSECOND;
    }

    public int getCUSTOMSTARTPOSITION() {
        return CUSTOMSTARTPOSITION;
    }

    public int getCUSTOMFINISHPOSITION() {
        return CUSTOMFINISHPOSITION;
    }

    public int getCUSTOMPOSITION() {
        return CUSTOMPOSITION;
    }

    public int getFUNCTIONSTARTPOSITION() {
        return FUNCTIONSTARTPOSITION;
    }

}
