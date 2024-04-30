public class Pair {

    Double first;
    Double second;


    public Pair(Double first, Double second) {
        this.first = first;
        this.second = second;
    }

    public double getFirst(){
        return first;
    }

    public double getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
