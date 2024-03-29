package box.task;

public class Protector {
    private Thing thing;

    public Protector(Thing thing) {
        this.thing = thing;
    }

    public Thing getThing() {
        return thing;
    }

    public void setThing(Thing thing) {
        this.thing = thing;
    }

    @Override
    public String toString() {
        return "\nProtector{" +
                "thing=" + thing.getName() +
                '}';
    }
}
