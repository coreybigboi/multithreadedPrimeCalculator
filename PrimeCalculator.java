import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

        System.out.println("Using " + NUM_THREADS + " thread(s) to calculate all prime values between " + LOWER_BOUND + " and " + UPPER_BOUND + "\n");

        // create an executor service to manage the threads
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        // determine the size of work that each thread will perform
        final int chunkSize = (UPPER_BOUND - LOWER_BOUND + 1) / NUM_THREADS;

        // create the threads
        for (int i = 0; i < NUM_THREADS; i++) {
            final int start = LOWER_BOUND + i * chunkSize;
            final int end = (i != NUM_THREADS - 1) ? start + chunkSize - 1 : UPPER_BOUND;

            System.out.println("Thread " + i + " calculating primes between " + start + " and " + end);
            executor.execute(new PrimeCalculatorWorker(start, end, primeList));
        }

        executor.shutdown();
        System.out.println("\nCalculating...");

        // wait for threads to finish
        while(!executor.isTerminated()) {

        }

        printSummary();
    }

    private void printSummary () {
        System.out.println("Done!");
        System.out.println("\nBelow are all prime values between " + LOWER_BOUND + " and " + UPPER_BOUND + ":");
        Collections.sort(primeList);
        System.out.println(primeList);
    }
}
