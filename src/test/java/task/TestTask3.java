package task;

import org.testng.Assert;
import org.testng.annotations.Test;
import tasks.Task3;

public class TestTask3 {

    final String input1 = "abcde\n" +
            "fg*5.\n" +
            ".....\n" +
            ".....\n" +
            "617..\n";

    final String input2 = "467..114..\n" +
            "...*......\n" +
            "..35..633.\n" +
            "......#...\n" +
            "617*......\n" +
            ".....+.58.\n" +
            "..592.....\n" +
            "......755.\n" +
            "...$.*....\n" +
            ".664.598..";

    @Test
    public void testCoordinateConversion() {

        final Task3 task3 = new Task3();

        Assert.assertEquals(task3.executeSubTask1(input1), Integer.valueOf(5));
        Assert.assertEquals(task3.executeSubTask1(input2), Integer.valueOf(4361));

    }

    @Test
    public void testGearRation() {

        final Task3 task3 = new Task3();

        Assert.assertEquals(task3.executeSubTask2(input1), Integer.valueOf(0));
        Assert.assertEquals(task3.executeSubTask2(input2), Integer.valueOf(467835));

    }


}
