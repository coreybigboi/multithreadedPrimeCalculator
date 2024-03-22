import java.util.ArrayList;
import java.util.List;

public class PrimeCalculator {
    private final int NUM_THREADS;
    private final int LOWER_BOUND;
    private final int UPPER_BOUND;
    private final List<Integer> primeList;


    public PrimeCalculator(int NUM_THREADS, int LOWER_BOUND, int UPPER_BOUND) {
        this.NUM_THREADS = NUM_THREADS;
        this.LOWER_BOUND = LOWER_BOUND;
        this.UPPER_BOUND = UPPER_BOUND;
        this.primeList = new ArrayList<>();
    }

    public void PerformPrimeCalculation() {

    }
}
