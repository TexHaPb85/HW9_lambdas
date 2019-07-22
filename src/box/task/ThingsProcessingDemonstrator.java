package box.task;

import functionalinterface.example.Randomable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class ThingsProcessingDemonstrator {

    public static void demonstrateBoxTask() {

        List<Box> boxes = Arrays.asList(
                new Box(generateThings(100, "box one")),
                new Box(generateThings(50, "box two")),
                new Box(generateThings(75, "box three")));


        List<Protector> protectedThings = sortThingsInBoxes(boxes);

        System.out.println("Not Fragile Things:" + boxes);
        System.out.println("Protected fragile things" + protectedThings);
    }

    private static List<Protector> sortThingsInBoxes(List<Box> boxes) {

        List<Protector> protectedThings = boxes.stream()
                .flatMap(box -> box.getThings().stream())
                .filter(Thing::isFragile)
                .map(Protector::new)
                .collect(Collectors.toList());
        boxes.forEach(box -> box.getThings().removeIf(Thing::isFragile));

        return protectedThings;
    }

    /**
     * rand.getRandomInteger(1, 11) will return random value from 1 to 10,
     * so if it will be more than half of 10 method will return true, else - false.
     * 5 - half of 10;
     */
    private static boolean getRandomBoolean() {
        Randomable rand = (from, to) -> (int) (Math.random() * (to - from)) + from;
        return rand.getRandomInteger(1, 11) > 5;
    }

    private static List<Thing> generateThings(int amount, String boxName) {

        List<Thing> things = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            String thingName = "thing " + i + " from " + boxName;
            boolean isFragile = getRandomBoolean();
            things.add(new Thing(isFragile, thingName));
        }

        return things;
    }
}


/**
 * as this code is training, I`ll left that comment here to know two variants if task implementation
 *
 * List<Protector> protectedThings = new ArrayList<>();
 * boxes.forEach(box -> {
 * protectedThings.addAll(box.getThings().stream()
 * .filter(Thing::isFragile)
 * .map(Protector::new)
 * .collect(Collectors.toList()));
 * box.getThings().removeIf(Thing::isFragile);
 * });
 */
