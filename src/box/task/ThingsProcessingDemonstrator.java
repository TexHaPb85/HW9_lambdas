package box.task;

import functionalinterface.example.Randomable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class ThingsProcessingDemonstrator {

    public static void demonstrateBoxTask() {
        List<Box> boxes = Arrays.asList(
                new Box(generateThings(100, "box one")),
                new Box(generateThings(50, "box two")),
                new Box(generateThings(75, "box three")));

/**      as this code is training, I`ll left that comment here to know two variants if task implementation
        List<Protector> protectedThings = new ArrayList<>();
        boxes.forEach(box -> {
            protectedThings.addAll(box.getThings().stream()
                    .filter(Thing::isFragile)
                    .map(Protector::new)
                    .collect(Collectors.toList()));
            box.getThings().removeIf(Thing::isFragile);
        });*/

        List<Protector> protectedThings = boxes.stream()
                .flatMap(box -> box.getThings().stream())
                .filter(Thing::isFragile)
                .map(Protector::new)
                .collect(Collectors.toList());
        boxes.forEach(box -> box.getThings().removeIf(Thing::isFragile));

        System.out.println("Not Fragile Things:" + boxes);
        System.out.println("Protected fragile things" + protectedThings);
    }

    private static List<Thing> generateThings(int howMany, String boxName) {
        List<Thing> things = new ArrayList<>();
        Randomable rand = (from, to) -> (int) (Math.random() * (to - from))+from;
        for (int i = 0; i < howMany; i++) {
            String thingName = "thing " + i + " from " + boxName;
            boolean isFragile = rand.getRandomInteger(1, 11) > 5;
            things.add(new Thing(isFragile, thingName));
        }

        return things;
    }
}
