package tasks;

import utils.FileReader;

abstract class TaskBase implements TaskInterface {

    public static final String DAILY_TASK_MESSAGE = "Task \"%s\" of day %d";

    final protected String taskName;
    final protected int day;

    protected TaskBase(final String taskName, final int day){
        this.taskName = taskName;
        this.day = day;
    }

}
