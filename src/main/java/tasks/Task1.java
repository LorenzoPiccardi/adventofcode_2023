package tasks;

import java.util.*;

public class Task1 extends TaskBase {

    public static final String TASK_NAME = "Trebuchet?!";

    private static class Digit {

        private static final List<String> LETERAL_DIGITS = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
        private static final List<String> NUMERICAL_DIGITS = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
        private static final Map<String, Integer> CONVERSION_MAP = new HashMap<>();
        static {
            CONVERSION_MAP.put("one", 1);
            CONVERSION_MAP.put("two", 2);
            CONVERSION_MAP.put("three", 3);
            CONVERSION_MAP.put("four", 4);
            CONVERSION_MAP.put("five", 5);
            CONVERSION_MAP.put("six", 6);
            CONVERSION_MAP.put("seven", 7);
            CONVERSION_MAP.put("eight", 8);
            CONVERSION_MAP.put("nine", 9);
            CONVERSION_MAP.put("1", 1);
            CONVERSION_MAP.put("2", 2);
            CONVERSION_MAP.put("3", 3);
            CONVERSION_MAP.put("4", 4);
            CONVERSION_MAP.put("5", 5);
            CONVERSION_MAP.put("6", 6);
            CONVERSION_MAP.put("7", 7);
            CONVERSION_MAP.put("8", 8);
            CONVERSION_MAP.put("9", 9);
        }

        private String value;
        private int index;
        private int bulk;

        public Digit(final String value, final int index) {
            this.value = value;
            this.index = index;
        }

        public Digit(final int index) {
            this(null, index);
        }

        public Integer getNumericalValue() {
            return CONVERSION_MAP.get(value);
        }

        public String getValue() {
            return value;
        }

        public int getIndex() {
            return index;
        }

        public int getBulk() {
            return bulk;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public void setBulk(int bulk) {
            this.bulk = bulk;
        }
    }



    public Task1() {
        super(TASK_NAME, 1);

    }

    @Override
    public void execute(final String input) {

        System.out.printf((DAILY_TASK_MESSAGE) + "%n", taskName, day);

        System.out.println("Execute first sub-task");
        String calibration = executeSubTask1(input);
        System.out.printf("Calibration result: %s%n", calibration);

        System.out.println("Execute second sub-task");
        String calibration2 = executeSubTask2(input);
        System.out.printf("Calibration result: %s%n", calibration2);

    }

    @Override
    public String executeSubTask1(final String input) {
        return getCalibrationValue(input);
    }

    @Override
    public String executeSubTask2(final String input) {
        return getCalibrationValueDigitAndSpelled(input);
    }

    public String replaceSpelledNumbers(final String string) {

        // Search for the first letter occurrence
        final Digit firstLiteralDigit = new Digit(string.length());
        for (String value : Task1.Digit.LETERAL_DIGITS) {
            int digitIndex = string.indexOf(value);
            if (digitIndex != -1 && digitIndex < firstLiteralDigit.getIndex()) {
                firstLiteralDigit.setIndex(digitIndex);
                firstLiteralDigit.setValue(value);
            }
        }

        // Search for the first numeric occurrence
        final Digit firstNumericDigit = new Digit(string.length());
        for (String value : Task1.Digit.NUMERICAL_DIGITS) {
            int digitIndex = string.indexOf(value);
            if (digitIndex != -1 && digitIndex < firstNumericDigit.getIndex()) {
                firstNumericDigit.setIndex(digitIndex);
                firstNumericDigit.setValue(value);
            }
        }

        // Search for the first digit
        final Digit firstDigit;
        if (firstLiteralDigit.getIndex() < firstNumericDigit.getIndex()) {
            firstDigit = firstLiteralDigit;
        } else {
            firstDigit = firstNumericDigit;
        }

        // Search for the last letter occurrence
        final Digit lastLiteralDigit = new Digit(-1);
        for (String value : Task1.Digit.LETERAL_DIGITS) {
            int digitIndex = string.lastIndexOf(value);
            if (digitIndex != -1 && digitIndex > lastLiteralDigit.getIndex()) {
                lastLiteralDigit.setIndex(digitIndex);
                lastLiteralDigit.setValue(value);
            }
        }

        // Search for the last Numeric occurrence
        final Digit lastNumericDigit = new Digit(-1);
        for (String value : Digit.NUMERICAL_DIGITS) {
            int digitIndex = string.lastIndexOf(value);
            if (digitIndex != -1 && digitIndex > lastNumericDigit.getIndex()) {
                lastNumericDigit.setIndex(digitIndex);
                lastNumericDigit.setValue(value);
            }
        }

        // Search for the first digit
        Digit lastDigit;
        if (lastLiteralDigit.getIndex() > lastNumericDigit.getIndex()) {
            lastDigit = lastLiteralDigit;
        } else {
            lastDigit = lastNumericDigit;
        }

        // Check if the second digit doesn't exist
        if (lastDigit.getValue() == null) {
            lastDigit = firstDigit;
        }

        return "" + (firstDigit.getNumericalValue() * 10 + lastDigit.getNumericalValue());
    }

    public String getCalibrationValueDigitAndSpelled(final String input) {
        final int calibrationValue = Arrays.stream(input.split("\\n"))
                .map(this::replaceSpelledNumbers)
                .mapToInt(Integer::parseInt).sum();
        return String.valueOf(calibrationValue);
    }

    public String getCalibrationValue(final String input) {
        final int calibrationValue = Arrays.stream(input.split("\\n")).map(this::getDigits).mapToInt(Integer::parseInt).sum();
        return String.valueOf(calibrationValue);
    }

    private String getDigits(final String input) {
        return "" + getFirstDigit(input) + getLastDigit(input);
    }

    private char getFirstDigit(final String input) {

        int i = 0;

        while (i < input.length()) {
            if (Character.isDigit(input.charAt(i))){
                return input.charAt(i);
            }
            i++;
        }

        return '\0';
    }

    private char getLastDigit(final String input) {

        int i = input.length() - 1;

        while (i > -1) {
            if (Character.isDigit(input.charAt(i))){
                return input.charAt(i);
            }
            i--;
        }

        return '\0';
    }

}
