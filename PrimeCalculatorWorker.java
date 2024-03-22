import java.util.ArrayList;
import java.util.List;

public class PrimeCalculatorWorker implements Runnable {
    private final int LOWER_BOUND;
    private final int UPPER_BOUND;

    private final List<Integer> primeList;

    public PrimeCalculatorWorker(int LOWER_BOUND, int UPPER_BOUND, List<Integer> primeList) {
        this.LOWER_BOUND = LOWER_BOUND;
        this.UPPER_BOUND = UPPER_BOUND;
        this.primeList = primeList;
    }

    boolean isPrime(int number) {
        if(number <= 1) return false;

        for (int i = 2; i < number; i++) {
            if (number % i == 0) return false;
        }

        return true;
    }
    @Override
    public void run() {
        List<Integer> localPrimes = new ArrayList<>();

        for(int i = LOWER_BOUND; i <= UPPER_BOUND; i++) {
            if (isPrime(i)) localPrimes.add(i);
        }

        synchronized (primeList) {
            primeList.addAll(localPrimes);
        }
    }
}
