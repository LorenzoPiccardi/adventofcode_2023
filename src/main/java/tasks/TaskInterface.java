package tasks;

public interface TaskInterface {

    /**
     * Return the advent day number.
     * @return advent day number.
     */
    String getDay();

    /**
     * Execute the two subtasks of the day.
    */
    void execute(final String input);

    /**
     * Execute the first subtask of the day.
     * @param input string to process.
     * @return a generic object type according to the task requirement.
     *
     */
    <T> T executeSubTask1(final String input);

    /**
     * Execute the second subtask of the day.
     * @param input string to process.
     * @return a generic object type according to the task requirement.
     *
     */
    <T> T executeSubTask2(final String input);

}
