package task;

import org.testng.Assert;
import org.testng.annotations.Test;
import tasks.Task1;

public class TestTask1 {

    @Test
    public void testCalibrationValue() {

        final Task1 task1 = new Task1();

        final String input1 = "1abc2";
        final String input2 = "pqr3stu8vwx";
        final String input3 = "a1b2c3d4e5f";
        final String input4 = "treb7uchet";

        Assert.assertEquals(task1.executeSubTask1(input1), "12");
        Assert.assertEquals(task1.executeSubTask1(input2), "38");
        Assert.assertEquals(task1.executeSubTask1(input3), "15");
        Assert.assertEquals(task1.executeSubTask1(input4), "77");

        Assert.assertEquals(task1.executeSubTask1(String.join("\n", input1, input2, input3, input4)), "142");

    }

    @Test
    public void testCalibrationValueDigitsAndWords() {

        final Task1 task1 = new Task1();


        final String input0 = "onethreeeeeab75ctwo";
        final String input1 = "two1nine";
        final String input2 = "eightwothree";
        final String input3 = "abcone2threexyz";
        final String input4 = "xtwone3four";
        final String input5 = "4nineeightseven2";
        final String input6 = "zoneight234";
        final String input7 = "7pqrstsixteen";
        final String input8 = "four289";
        final String input9 = "oneight";
        final String input10 = "7k";

        //Assert.assertEquals(task1.replaceSpelledNumbers(input9), "11");
        Assert.assertEquals(task1.replaceSpelledNumbers(input1), "29");
        Assert.assertEquals(task1.replaceSpelledNumbers(input2), "83");
        Assert.assertEquals(task1.replaceSpelledNumbers(input3), "13");
        Assert.assertEquals(task1.replaceSpelledNumbers(input4), "24");
        Assert.assertEquals(task1.replaceSpelledNumbers(input5), "42");
        Assert.assertEquals(task1.replaceSpelledNumbers(input6), "14");
        Assert.assertEquals(task1.replaceSpelledNumbers(input7), "76");
        Assert.assertEquals(task1.replaceSpelledNumbers(input7), "76");
        Assert.assertEquals(task1.replaceSpelledNumbers(input8), "49");
        Assert.assertEquals(task1.replaceSpelledNumbers(input9), "18");
        Assert.assertEquals(task1.replaceSpelledNumbers(input10), "77");

        final String input = String.join("\n", input1, input2, input3, input4, input5, input6, input7, input8, input9);
        Assert.assertEquals(task1.executeSubTask2(input), "348");

    }


}
