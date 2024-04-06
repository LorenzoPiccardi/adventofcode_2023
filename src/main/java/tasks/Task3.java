package tasks;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Task3 extends TaskBase {

    public static final String TASK_NAME = "Gear rations";

    /**
     * The innerclass Engine models the engine structure.
     *
     * */
    private static class Engine {

        private final String engineStructure;
        private final int width;
        private final int height;
        private final List<Integer> parts;
        private final HashMap<String, List<Integer>> gearMaps;


        public Engine(final String input) {

            this.height = input.split("\n").length;
            this.width = input.split("\n")[0].length();

            this.engineStructure = input.replace("\n", "");

            this.parts = new ArrayList<>();
            this.gearMaps = new HashMap<>();

            getEngineParts();
        }

        /**
         * Find the engine's parts number and sum all them up.
         * The engine structure is stored as string, but traversed as a table.
         * <b>Example</b>
         *    X
         *   -------->
         * Y |  .....
         *   |  ..*5.
         *   |  .....
         *   |  .....
         *   |  617..
         *   V
         *
         *
         * When a part number if found, the surrounding neighbours are Evaluated to see if they contain validator chars.
         * */
        private void getEngineParts() {

            int index = 0;
            while (index < engineStructure.length()) {
                char c = engineStructure.charAt(index);
                if (Character.isDigit(c)) {
                    String partNumber = readPartNumber(engineStructure, index);

                    final List<Point> surrounding = surroundingCoordinates(index, partNumber.length());
                    if (isValidPart(engineStructure, surrounding, Integer.valueOf(partNumber))) {
                        this.parts.add(Integer.valueOf(partNumber));
                    }
                    index += partNumber.length();

                } else {
                    index++;
                }
            }
        }

        /**
         * Given the first index of the digit, the method return the number.
         * @param engine string of engine structure
         * @param startIndex of fist digit of a number
         * @return the number as a string
         *
         * */
        private String readPartNumber(final String engine, final int startIndex){

            int index = startIndex;
            final StringBuilder partBuilder = new StringBuilder();
            while (Character.isDigit(engine.charAt(index)) && (index % width) < width){
                partBuilder.append(engine.charAt(index++));
            }

            return partBuilder.toString();
        }

        /**
         * Validate is the part number is surrounded by a validator char.
         * @param engine a string containing the ending structure.
         * @param neighbours list of surrounding neighbours.
         * @return true if one of the neighbours contains a validator char.
         * */
        private boolean isValidPart(final String engine, final List<Point> neighbours, final Integer partNumber) {

            boolean isValid = false;

            for (Point point : neighbours) {
                final char c = engine.charAt(point.x + point.y * width);
                if (!Character.isDigit(c) && c != '.') {
                    isValid = true;
                }
                if (c == '*') {
                    final String gearCoordinate = String.format("x:%d,y:%d", point.x, point.y);
                    this.gearMaps.computeIfAbsent(gearCoordinate, k -> new ArrayList<>());
                    this.gearMaps.get(gearCoordinate).add(partNumber);
                }
            }

            return isValid;

        }

        /**
         * Given the index of the first digit of a number and number of digits,
         * the methods returns a list on neighbours as a list of points.
         * @param index index of the first digit of a number.
         * @param size the number of digits in the numbers.
         *
         * */
       private List<Point> surroundingCoordinates(final int index, final int size) {

            final List<Point> coordinates = new ArrayList<>();

            for (int x = -1; x < size + 1; x++) {
                for (int y = -1; y < 2; y++) {
                    coordinates.add(new Point((index % width) + x,(index / height) + y));
                }
            }

           return coordinates.stream().filter(p -> p.x >= 0 && p.x < width && p.y >= 0 && p.y < height)
                   .collect(Collectors.toList());

       }

        public List<Integer> getParts() {
            return parts;
        }

        public HashMap<String, List<Integer>> getGearMaps() {
            return gearMaps;
        }
    }

    public Task3() {
        super(TASK_NAME, 3);
    }

    @Override
    public String getDay() {
        return String.valueOf(this.day);
    }

    @Override
    public void execute(String input) {
        System.out.printf((DAILY_TASK_MESSAGE) + "%n", taskName, day);

        System.out.println(EXECUTE_FIRST_TASK_MESSAGE);
        final Integer enginePartsSum = executeSubTask1(input);
        System.out.printf("Engine part numbers sum: %s%n", enginePartsSum);

        System.out.println(EXECUTE_SECOND_TASK_MESSAGE);
        Integer gearRatioSum = executeSubTask2(input);
        System.out.printf("Gear ration sum result: %s%n%n", gearRatioSum);
    }

    /**
     * The method executes the first subtask.
     * Give the input string it returns the sum of parts numbers.
     * @param input engine structure.
     * @return the sum of the sum of the Give the input string it returns the sum of parts numbers.
     *
     * */
    @Override
    public Integer executeSubTask1(String input) {
        return new Engine(input).getParts().stream().mapToInt(p -> p).sum();
    }

    @Override
    public  Integer executeSubTask2(String input) {
        return new Engine(input).getGearMaps().values().stream()
                .filter(integers -> integers.size() > 1)
                .mapToInt(integers -> integers.stream()
                        .reduce(1, (a, b) -> a * b))
                .sum();
    }
}
