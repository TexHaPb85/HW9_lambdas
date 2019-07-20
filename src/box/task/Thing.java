package box.task;

public class Thing {
    private boolean isFragile;
    private String name;

    public Thing(boolean isFragile, String thingName) {
        this.isFragile = isFragile;
        this.name = thingName;
    }

    public boolean isFragile() {
        return isFragile;
    }

    public void setFragile(boolean fragile) {
        isFragile = fragile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "\nThing{" +
                "isFragile=" + isFragile +
                ", name='" + name + '\'' +
                '}';
    }
}
