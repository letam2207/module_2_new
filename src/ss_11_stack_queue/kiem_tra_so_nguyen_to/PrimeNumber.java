package ss_11_stack_queue.kiem_tra_so_nguyen_to;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static List<Integer> getPrimeNumbers(int n) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }
}
