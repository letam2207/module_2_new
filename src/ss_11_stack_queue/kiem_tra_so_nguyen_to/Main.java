package ss_11_stack_queue.kiem_tra_so_nguyen_to;

import java.util.*;

import static ss_11_stack_queue.kiem_tra_so_nguyen_to.PrimeNumber.getPrimeNumbers;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n;
        while (true) {
            System.out.print("Nhập n (n > 2): ");
            try {
                n = Integer.parseInt(scanner.nextLine());
                if (n > 2) break;
                System.out.println(" Vui lòng nhập số nguyên lớn hơn 2.");
            } catch (NumberFormatException e) {
                System.out.println(" Không hợp lệ. Vui lòng nhập số nguyên.");
            }
        }
        List<Integer> primes = getPrimeNumbers(n);
        Stack<Integer> primeStack = new Stack<>();
        Queue<Integer> primeQueue = new LinkedList<>();

        for (int prime : primes) {
            primeStack.push(prime);
            primeQueue.add(prime);
        }
        System.out.println("\n Các số nguyên tố (Stack - LIFO):");
        while (!primeStack.isEmpty()) {
            System.out.print(primeStack.pop() + " ");
        }

        System.out.println("\n\n Các số nguyên tố (Queue - FIFO):");
        while (!primeQueue.isEmpty()) {
            System.out.print(primeQueue.poll() + " ");
        }
    }
}
