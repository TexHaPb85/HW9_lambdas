package box.task;

import functionalinterface.example.Randomable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ThingsProcessingDemonstrator {

    public static void demonstrateBoxTask(){
        List<Thing> things  = generateThings(100);
        List<Protector> protectedThings;

        protectedThings=things.stream()
                .filter(Thing::isFragile)
                .map(Protector::new)
                .collect(Collectors.toList());

        things.removeIf(Thing::isFragile);

        System.out.println("Not Fragile Things:"+things
                +"\nProtected fragile things"+protectedThings);
    }

    private static List<Thing> generateThings(int howMany){
        List<Thing> things = new ArrayList<>();
        Randomable rand = (from, to) -> from + (int) (Math.random() * (to - from));
        for (int i = 0; i < howMany; i++) {
            String thingName = "thing"+i;
            boolean isFragile;
            if(rand.getRandomInteger(1,11)>5){
                isFragile=true;
            }else {
                isFragile=false;
            }
            things.add(new Thing(isFragile,thingName));
        }

        return things;
    }
}
