package tasks;

public interface TaskInterface {


    void execute(final String input);

    <T> T executeSubTask1(final String input);

    <T> T executeSubTask2(final String input);

}
