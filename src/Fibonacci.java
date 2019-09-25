public class Fibonacci {
    public static int nonRecursive(int n) {
        // initialise an array of size n
        int[] sequence = new int[n]; // 1
        int i; // 1

        // loop through from 0 to n
        for(i = 0; i < n; i++) { // n * t, t = 1, running time is n
            if (i <= 1) {
                // if i is 0 or 1, then the value is 1
                sequence[i] = 1;
            } else {
                // otherwise, sum the previous two values in the array to get the next value
                sequence[i] = sequence[i-1] + sequence[i-2];
            }
        }
        // at this point i = n, so sequence n (i-1+i-2) is the final element in the array, or F(n)
        return sequence[i-1] + sequence[i-2]; // 1
    }

    public static int nonRecursiveO1(int n) {
        // we're only concerned with the previous two values, not the whole sequence so we initialize them
        int prev = 0; //prev is F(n-1)
        int secondPrev = 0; //secondPrev is F(n-2)

        // we loop up to n to get F(n)
        for(int  i = 0; i < n; i++) {
            // if i is 0 or 1, then we need to set prev/secondPrev to 1
            if (i <= 1) {
                // if prev is not zero it means we already have assigned it to 1, this means we need to slide that to secondPrev
                if(prev != 0) {
                    secondPrev = prev;
                }
                prev = 1;
            } else {
                // simulate increasing n, which changes F(n-1) and F(n-2)
                int temp = prev + secondPrev;
                secondPrev = prev;
                prev = temp;
            }
        }
        // F(n) will be equal to F(n-1) + F(n-2), so we add the variables for those
        return prev + secondPrev;
    }


    public static int recursive(int n) {
        // if n is 1 or 0 we return 1 as that's the first 2 values in the Fibonacci sequence
       if (n == 1 || n == 0) {
           return 1;
       } else {
           // if n is more than 1 we recursively call this function again with n-1 and n-2, and this repeats until n is 0 or 1
           // when n is 0 or 1 it returns 1 and we add up all the values of 1 that the recursive function has returned which gives us F(n)
           return recursive(n-1) + recursive(n-2);
       }
    }
}
