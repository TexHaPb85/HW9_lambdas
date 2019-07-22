package box.task;

import java.util.List;

public class Box {
    private List<Thing> things;

    public Box(List<Thing> things) {
        this.things = things;
    }

    public List<Thing> getThings() {
        return things;
    }

    public void setThings(List<Thing> things) {
        this.things = things;
    }

    @Override
    public String toString() {
        return things.toString();


    }
}
