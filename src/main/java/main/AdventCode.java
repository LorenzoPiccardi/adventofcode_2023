package main;

import tasks.Task1;

import tasks.Task2;
import tasks.Task3;
import tasks.TaskInterface;
import utils.FileReader;

import java.util.ArrayList;
import java.util.List;

public class AdventCode {

    public static void main(String[] args) {

        List<TaskInterface> taskList = new ArrayList<>();

        //Task list
        taskList.add(new Task1());
        taskList.add(new Task2());
        taskList.add(new Task3());

        //Execute all tasks
        taskList.forEach(task -> {
            final String input = FileReader.readFile(String.format("task_%s.txt", task.getDay()));
            task.execute(input);
        });

    }

}
