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
        final String input5 = "64eight6eight6gxdpmtnbfone";

        Assert.assertEquals(task1.executeSubTask1(input1),  Integer.valueOf(12));
        Assert.assertEquals(task1.executeSubTask1(input2),  Integer.valueOf(38));
        Assert.assertEquals(task1.executeSubTask1(input3),  Integer.valueOf(15));
        Assert.assertEquals(task1.executeSubTask1(input4),  Integer.valueOf(77));
        Assert.assertEquals(task1.executeSubTask1(input5),  Integer.valueOf(66));

        Assert.assertEquals(task1.executeSubTask1(String.join("\n", input1, input2, input3, input4)), Integer.valueOf(142));

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

        //Assert.assertEquals(task1.executeSubTask2(input9), "11");
        Assert.assertEquals(task1.executeSubTask2(input1), Integer.valueOf(29));
        Assert.assertEquals(task1.executeSubTask1(input2), Integer.valueOf(83));
        Assert.assertEquals(task1.executeSubTask1(input3), Integer.valueOf("13"));
        Assert.assertEquals(task1.executeSubTask1(input4), Integer.valueOf("24"));
        Assert.assertEquals(task1.executeSubTask1(input5), Integer.valueOf("42"));
        Assert.assertEquals(task1.executeSubTask2(input6), Integer.valueOf("14"));
        Assert.assertEquals(task1.executeSubTask2(input7), Integer.valueOf("76"));
        Assert.assertEquals(task1.executeSubTask2(input7), Integer.valueOf("76"));
        Assert.assertEquals(task1.executeSubTask2(input8), Integer.valueOf("49"));
        Assert.assertEquals(task1.executeSubTask2(input9), Integer.valueOf("18"));
        Assert.assertEquals(task1.executeSubTask2(input10), Integer.valueOf("77"));

        final String input = String.join("\n", input1, input2, input3, input4, input5, input6, input7, input8, input9);
        Assert.assertEquals(task1.executeSubTask2(input), Integer.valueOf(348));

    }


}
