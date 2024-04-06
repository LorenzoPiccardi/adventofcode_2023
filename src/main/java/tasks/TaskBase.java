package tasks;

abstract class TaskBase implements TaskInterface {

    public static final String DAILY_TASK_MESSAGE = "Task \"%s\" of day %d";
    public static final String EXECUTE_FIRST_TASK_MESSAGE = "Execute first sub-task";
    public static final String EXECUTE_SECOND_TASK_MESSAGE = "Execute second sub-task";

    final protected String taskName;
    final protected int day;

    protected TaskBase(final String taskName, final int day){
        this.taskName = taskName;
        this.day = day;
    }

}
