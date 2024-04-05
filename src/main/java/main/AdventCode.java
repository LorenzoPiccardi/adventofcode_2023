package main;

import tasks.Task1;
import tasks.TaskInterface;
import utils.FileReader;

import java.util.ArrayList;
import java.util.List;

public class AdventCode {

    public static void main(String[] args) {

        List<TaskInterface> taskList = new ArrayList<>();

        final String input1 = FileReader.readFile(String.format("task_%d.txt", 1));
        taskList.add(new Task1());

        //Execute all tasks
        taskList.forEach(task -> task.execute(input1));
    }

}
