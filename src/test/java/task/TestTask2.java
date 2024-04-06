package task;

import org.testng.Assert;
import org.testng.annotations.Test;
import tasks.Task1;
import tasks.Task2;

public class TestTask2 {

    private static final String INPUT = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green\n" +
            "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue\n" +
            "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red\n" +
            "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red\n" +
            "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green\n" +
            "Game 10: 5 blue, 1 green; 5 green, 4 blue, 4 red; 5 red, 5 blue, 1 green\n";

    @Test
    public void testSumOfIDsOfPossibleGames() {

        // Red 12, Green 13, Blue 14
        final Task2 task2 = new Task2();

        final String input1 = "Game 84: 5 blue, 1 green; 5 green, 4 blue, 7 red; 5 red, 5 blue, 1 green\n";
        final String input2 = "Game 200: 5 blue, 1 green; 5 green, 4 blue, 7 red; 5 red, 5 blue, 7 green\n";
        final String input3 = "Game 100: 6 red, 4 green; 3 red, 2 blue, 9 green; 1 blue, 5 green, 14 red; 1 blue, 2 red, 2 green; 9 red, 1 blue, 14 green; 2 blue, 11 green, 8 red\n";

        Assert.assertEquals(task2.executeSubTask1(input1), Integer.valueOf(84));
        Assert.assertEquals(task2.executeSubTask1(input2), Integer.valueOf(200));
        Assert.assertEquals(task2.executeSubTask1(input3), Integer.valueOf(0));
        Assert.assertEquals(task2.executeSubTask1(INPUT), Integer.valueOf(18));

    }

    @Test
    public void testCalibrationValueDigitsAndWords() {

        // Red 12, Green 13, Blue 14
        final Task2 task2 = new Task2();

        final String input1 = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green";
        final String input2 = "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue";
        final String input3 = "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red";
        final String input4 = "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red";
        final String input5 = "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green";


        //Assert.assertEquals(task2.executeSubTask2(input1), Integer.valueOf(48));
        //Assert.assertEquals(task2.executeSubTask2(input2), Integer.valueOf(12));
        //Assert.assertEquals(task2.executeSubTask2(input3), Integer.valueOf(1560));
        //Assert.assertEquals(task2.executeSubTask2(input4), Integer.valueOf(630));
        //Assert.assertEquals(task2.executeSubTask2(input5), Integer.valueOf(36));
        Assert.assertEquals(task2.executeSubTask2(INPUT), Integer.valueOf(2411));

    }


}
