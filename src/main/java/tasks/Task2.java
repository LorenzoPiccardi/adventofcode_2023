package tasks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Task2 extends TaskBase {

    public static final String TASK_NAME = "Cube Conundrum";

    private static final int RED_CUBES = 12;
    private static final int GREEN_CUBES = 13;
    private static final int BLUE_CUBES = 14;

    public static final String RED = "red";
    public static final String GREEN = "green";
    public static final String BLUE = "blue";

    /**
     * The innerclass Game models the cube extraction game format.
     *
     * */
    public static class Game {

        private static final String SUBSET_SEPARATOR = ",";
        private static final String SET_SEPARATOR = ";";

        private final int gameLimitRed;
        private final int gameLimitGreen;
        private final int gameLimitBlue;

        private final Integer gameID;
        private boolean possible;

        private final Map<String, Integer> minCubePerColorMap;

        public Game(final String game, final int gameLimitRed, final int gameLimitGreen, final int gameLimitBlue){


            this.gameLimitRed = gameLimitRed;
            this.gameLimitGreen = gameLimitGreen;
            this.gameLimitBlue = gameLimitBlue;

            this.minCubePerColorMap = new HashMap<>();
            minCubePerColorMap.put(RED, 0);
            minCubePerColorMap.put(GREEN, 0);
            minCubePerColorMap.put(BLUE, 0);

            this.possible = true;

            final String[] g = game.split(":");
            this.gameID = Integer.valueOf(g[0].replace("Game ", "").trim());
            evaluateSet(g[1].trim());
        }

        public Integer getGameID() {
            return gameID;
        }

        public boolean isPossible() {
            return possible;
        }

        /**
         * Parse the game sets.
         * @param gameSet game result sets.
         *
         * */
        private void evaluateSet(final String gameSet){
            Arrays.stream(gameSet.split(SET_SEPARATOR)).forEach(this::evaluateSubset);
        }

        /**
         * Parse the game sub sets.
         * @param gameSubset game result sets.
         *
         * */
        private void evaluateSubset(final String gameSubset) {
            Arrays.stream(gameSubset.split(SUBSET_SEPARATOR)).forEach(this::evaluateExtraction);
        }

        /**
         * Memorize the fewer number of cube by color per each set, and check if the game is possible to be played.
         * @param cubeCount game result sets.
         *
         * */
        private void evaluateExtraction(final String cubeCount) {
            final String[] c = cubeCount.trim().split(" ");
            setFewestNumberOfCubePerColor(c[1], Integer.parseInt(c[0]));
            this.possible = this.possible && isPossible(c[1], Integer.parseInt(c[0]));
        }

        /**
         * Verify if the game result is possible according number of cubes predefined.
         * @param color cube color.
         * @param cubeCount number of cube for color.
         * @return true if the game is possible to be played otherwise returns false.
         *
         * */
        private boolean isPossible(final String color, final Integer cubeCount) {

           if (RED.equals(color)) {
               return this.gameLimitRed >= cubeCount;
           } else if (GREEN.equals(color)) {
               return this.gameLimitGreen >= cubeCount;
           } else if (BLUE.equals(color)) {
                return this.gameLimitBlue >= cubeCount;
           }

           return false;
        }

        /**
         * Set the fewest number of cube per color.
         * @param color cube color.
         * @param cubeCount cubeCount number of cube for color.
         *
         * */
        private void setFewestNumberOfCubePerColor(final String color, final Integer cubeCount) {
            final Integer minCubePerColor = this.minCubePerColorMap.get(color);
            this.minCubePerColorMap.put(color, Math.max(minCubePerColor, cubeCount));
        }

        /**
         * Calculate and return the "power" of the cubes.
         * @return the "power" (multiplication) of the cubes.
         *
         */
        private Integer getPowerOnFewestCubes() {
            return this.minCubePerColorMap.values().stream().reduce(1, (a, b) -> a * b);
        }

    }

    public Task2() {
        super(TASK_NAME, 2);
    }

    @Override
    public String getDay() {
        return String.valueOf(this.day);
    }

    @Override
    public void execute(String input) {

        System.out.printf((DAILY_TASK_MESSAGE) + "%n", taskName, day);

        System.out.println(EXECUTE_FIRST_TASK_MESSAGE);
        final Integer gameIDsSum = executeSubTask1(input);
        System.out.printf("Game IDs sum: %s%n", gameIDsSum);

        System.out.println(EXECUTE_SECOND_TASK_MESSAGE);
        final Integer cubePowerSum = executeSubTask2(input);
        System.out.printf("Cube power sum result: %s%n%n", cubePowerSum);
    }

    /**
     * The method executes the first subtask.
     * Give the input string it returns the sum of the games ID that are possible to play.
     * @param input input string.
     * @return the sum of the sum of the possible games ID.
     *
     * */
    @Override
    public Integer executeSubTask1(String input) {
        return Arrays.stream(input.split("\\n")).map(game -> new Game(game, RED_CUBES, GREEN_CUBES, BLUE_CUBES))
                .filter(Game::isPossible).
                mapToInt(Game::getGameID).sum();
    }

    /**
     * The method executes the second subtask.
     * Give the input string it returns the sum of the "power" of games ID that are possible to play.
     * @param input input string.
     * @return the sum of the "power" (multiplication) of the possible games ID.
     *
     * */
    @Override
    public Integer executeSubTask2(String input) {
        return Arrays.stream(input.split("\\n")).map(game -> new Game(game, RED_CUBES, GREEN_CUBES, BLUE_CUBES))
                .mapToInt(Game::getPowerOnFewestCubes).sum();
    }


}
