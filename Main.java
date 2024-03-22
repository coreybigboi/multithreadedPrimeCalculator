import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean agrees = true;

        System.out.println("Welcome to the Prime calculator app!");

        while (agrees) {
            startProgram(scanner);

            System.out.println("\nWould you like to try again? (y/n)");
            String choice = scanner.next();
            agrees = choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes");
        }

        System.out.println("\nSee ya :)");
    }

    private static void startProgram(Scanner scanner) {
        int threads = 0, lower = 0, upper = 0;

        System.out.println("\nChoose a range and this app will calculate what prime numbers exist in that range.");
        System.out.println("Choose the number of CPU threads to use for this calculation (more threads = better performance)");
        System.out.println("\nPlease type in the following parameters separated by spaces: [number-of-threads] [lower-bound] [upper-bound]");

        do {
            try{
                threads = scanner.nextInt();
                lower = scanner.nextInt();
                upper = scanner.nextInt();
            } catch (Exception e) {
                threads = -1;
                lower = -1;
                upper = -1;
            }
        } while (!validArguments(threads, lower, upper));

        System.out.println();

        PrimeCalculator primeCalculator = new PrimeCalculator(threads, lower, upper);
        primeCalculator.PerformPrimeCalculation();
    }

    private static boolean validArguments(int threads, int lower, int upper) {
        if (threads < 1 ) return false;
        if (upper < lower) return false;
        return true;
    }
}
