public class Main {
    public static void main(String[] args) {
        // store the time now
        long startTimeNonRec = System.nanoTime(); // your method call here
        System.out.println(Fibonacci.nonRecursive(32));
        // display the time elapsed
        System.out.println("non recursive: t = " +(System.nanoTime() - startTimeNonRec) + " nanosecs.\n");

        long startTimeRec = System.nanoTime(); // your method call here
        System.out.println(Fibonacci.recursive(32));
        System.out.println("recursive: t = " +(System.nanoTime() - startTimeRec) + " nanosecs.\n");

        long startTimeNonRecO1 = System.nanoTime(); // your method call here
        System.out.println(Fibonacci.nonRecursiveO1(32));
        System.out.println("non recursive (space of O(1)): = " +(System.nanoTime() - startTimeNonRecO1) + " nanosecs.\n");
    }
}

