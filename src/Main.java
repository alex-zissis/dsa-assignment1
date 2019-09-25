import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.print("Enter number: ");
        Scanner scnr = new Scanner(System.in);
        int number = scnr.nextInt();

        // store the time now
        long startTimeNonRec = System.nanoTime(); // your method call here
        System.out.println(Fibonacci.nonRecursive(number));
        // display the time elapsed
        System.out.println("non recursive: t = " +(System.nanoTime() - startTimeNonRec) + " nanosecs.\n");

        long startTimeRec = System.nanoTime(); // your method call here
        System.out.println(Fibonacci.recursive(number));
        System.out.println("recursive: t = " +(System.nanoTime() - startTimeRec) + " nanosecs.\n");

        long startTimeNonRecO1 = System.nanoTime(); // your method call here
        System.out.println(Fibonacci.nonRecursiveO1(number));
        System.out.println("non recursive (space of O(1)): = " +(System.nanoTime() - startTimeNonRecO1) + " nanosecs.\n");
    }
}

