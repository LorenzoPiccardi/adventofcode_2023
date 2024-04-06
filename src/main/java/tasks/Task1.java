package tasks;

import java.util.*;

public class Task1 extends TaskBase {

    public static final String TASK_NAME = "Trebuchet?!";

    private static final List<String> NON_NUMERICAL_DIGITS = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
    private static final List<String> NUMERICAL_DIGITS = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");

    public Task1() {
        super(TASK_NAME, 1);
    }

    @Override
    public String getDay() {
        return String.valueOf(this.day);
    }

    @Override
    public void execute(final String input) {

        System.out.printf((DAILY_TASK_MESSAGE) + "%n", taskName, day);

        System.out.println(EXECUTE_FIRST_TASK_MESSAGE);
        final Integer calibration = executeSubTask1(input);
        System.out.printf("Calibration result: %d%n", calibration);

        System.out.println(EXECUTE_SECOND_TASK_MESSAGE);
        final Integer calibration2 = executeSubTask2(input);
        System.out.printf("Calibration result: %d%n%n", calibration2);

    }

    /**
     * The method executes the first subtask.
     * Give the input string it returns the sum of the 2 digits number formed of the first and last digit in the input string.
     * @param input input string.
     * @return the sum of the 2 digits number formed of the first and last digit in the input string.
     *
     * */
    @Override
    public Integer executeSubTask1(final String input) {
        return Arrays.stream(input.split("\\n")).mapToInt(line -> getDigits(line, false)).sum();
    }

    /**
     * The method executes the first subtask.
     * Give the input string it returns the sum of the 2 digits number formed of the first and last numeric and not-numeric digit input string.
     * @param input input string.
     * @return the sum of the 2 digits number formed of the first and last numeric and not-numeric digit in the input string.
     *
     * */
    @Override
    public Integer executeSubTask2(final String input) {
        return Arrays.stream(input.split("\\n")).mapToInt(line -> getDigits(line, true)).sum();
    }

    /**
     * Return the first and the second number found in the input string in two-digit format. Ex: 12, 32, etc...
     * @param input input string.
     * @param alphanumeric search for numeric numbers if false, extend the search to numeric and non-numbers id true.
     * @return the first and the second number found in the input string in two-digit format.
     *
     * */
    private Integer getDigits(final String input, final boolean alphanumeric) {

        final Integer firstDigit = findFirstNumber(input, alphanumeric);
        final Integer secondDigit = findLastNumber(input, alphanumeric);

        return firstDigit * 10 + secondDigit;

    }


    /**
     * Return the first numeric or non-numeric digit of the input string.
     * @param input input string.
     * @param alphanumeric search for numeric numbers if false, extend the search to numeric and non-numbers id true.
     * @return the first digit found in the input string.
     *
     * */
    private Integer findFirstNumber (final String input, final boolean alphanumeric) {

        final List<String> searchList = new ArrayList<>();
        searchList.addAll(NUMERICAL_DIGITS);
        if (alphanumeric) {
            searchList.addAll(NON_NUMERICAL_DIGITS);
        }

        int firstIndex = input.length();
        int digit = 0;

        for (String d : searchList) {
            int index = input.indexOf(d);
            if (index < firstIndex && index != -1) {
                firstIndex = index;
                digit = (searchList.indexOf(d) % 9) + 1;
            }
        }

        return digit;
    }

    /**
     * Return the last numeric or non-numeric digit of the input string.
     * @param input input string.
     * @param alphanumeric search for numeric numbers if false, extend the search to numeric and non-numbers id true.
     * @return the last digit found in the input string.
     *
     * */
    private Integer findLastNumber (final String input, final boolean alphanumeric) {

        final List<String> searchList = new ArrayList<>();
        searchList.addAll(NUMERICAL_DIGITS);
        if (alphanumeric) {
            searchList.addAll(NON_NUMERICAL_DIGITS);
        }

        int lastIndex = -1;
        int digit = 0;

        for (String d : searchList) {
            int index = input.lastIndexOf(d);
            if (index > lastIndex && index != -1) {
                lastIndex = index;
                digit = (searchList.indexOf(d) % 9) + 1;
            }
        }

        return digit;
    }

}
