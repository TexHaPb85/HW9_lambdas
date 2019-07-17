package box.task;

public class Thing {
    private boolean isFragile;
    private String thingName;

    public Thing(boolean isFragile, String thingName) {
        this.isFragile = isFragile;
        this.thingName = thingName;
    }

    public boolean isFragile() {
        return isFragile;
    }

    public void setFragile(boolean fragile) {
        isFragile = fragile;
    }

    public String getThingName() {
        return thingName;
    }

    public void setThingName(String thingName) {
        this.thingName = thingName;
    }

    @Override
    public String toString() {
        return "\nThing{" +
                "isFragile=" + isFragile +
                ", thingName='" + thingName + '\'' +
                '}';
    }
}
