package functional_interface_example;
@FunctionalInterface
public interface Randomable {
    int getRandomInteger(int fromNum, int toNum);
}
