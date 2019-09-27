/*************************************************************************
 *
 *  Pace University
 *  Fall 2019
 *  Data Structures and Algorithms
 *
 *  Course: CS 241
 *  Team Authors: Alex Zissis, Karl Eshwer, Kyle Pla
 *  Collaborators: none
 *
 *  Assignment: 1
 *  Problem: Calculate the a Fibonacci value using various methods
 *
 *  Input: see table below
 *  Output: see table below
 *
 *  Visible data fields: -
 *
 *
 *  Visible methods:
 *  public static int nonRecursive(int n)
 *  public static int nonRecursiveO1(int n)
 *  public static int recursive(int n)
 *
 *   Remarks
 *   -------
 *   2)
 *
 *   | n                  | 0     | 1     | 2     | 4     | 8     | 16     | 32       | 38        | 45         |
 *   |--------------------|-------|-------|-------|-------|-------|--------|----------|-----------|------------|
 *   | recursive          | 27423 | 22569 | 29427 | 37478 | 47892 | 295058 | 13391270 | 203934014 | 5699334968 |
 *   | non-recursive      | 20671 | 23011 | 25084 | 27049 | 31289 | 33539  | 40756    | 42620     | 36820      |
 *   | non-recursive O(1) | 21695 | 23964 | 26327 | 30654 | 31077 | 32082  | 32566    | 32830     | 28534      |
 *
 *   3)
 *   a)
 *   The Big-O time complexity for the recursive function is O(2^n). This is because the function is recursive where
 *   T(n) = T(n-1) + T(n-2), so the function will continue call itself 2 times and reducing n until n = 1 or n = 0.
 *   This means the functions will be called 2^n times, and every time n is increased, the number of operations
 *   increases by an order of magnitude. The counting for the recursive function isn't easy. There is an if statement so
 *   you find the section with the maximum running call. The first section has one return statement so we assign it a
 *   value if 1. The second has two method calls, so what we have to do is look at the method definition to see what
 *   that method is doing. As it is recursive, that method is just the same function called again. Eventually the
 *   method will hit the "return 1" part of the if statement, but the method will be called 2^n times before that
 *   happens. Because the cost of "return 1" is 1, and it is called 2^n times, the Big-O for this function is O(2^n).
 *
 *   b)
 *   The measurement for the recursive method is somewhat consistent with the big-O running time. I ran the test 5 times
 *   for each n value and took the mean result as the results were sometimes inconsistent. If we look at the
 *   "recursive" row in the table above we see that when n is small (<=8) the jump between numbers is not exponential,
 *   in fact in some cases, such as (n=0) -> (n=1), the running time decreases from 27423 to 22569 as n increases.
 *   However with larger n values, we see a jump in running time much more consistent with the Big-O notation. When n
 *   is doubled from (n=8) -> (n=16), the running time jumps from 47892 to 295058, which shows exponential style growth.
 *   When n is further doubled from (n=16) -> (n=32) the running time jumps from 295058 to 13391270, which again is
 *   an exponential style jump. With n at smaller values we struggle to see an exponential growth, but as n increases,
 *   it becomes more and more clear.
 *
 *   c)
 *   The Big-O for the non-recursive method is O(n), which we call linear growth. This method is much easier to apply
 *   the counting rules towards. At the start of the method is an if statement. We apply the rule for this, which is
 *   to take whichever part of the if statement will have the maximum running time. The body of the "if" is one return
 *   statement so it has a cost of 1. The body of the presumed "else" contains 4 statements and a for loop, so it is
 *   obvious we use this, and have to calculate the cost of this section, to get the big O of the function. As stated
 *   there are 4 consecutive statements, so the cost of those is a constant, 4. We then come across a for loop, which
 *   we can calculate the time by number of iterations * running time of body. Looking at the body of the for loop,
 *   it is one statement, which has a cost of 1. So we multiply 1 by the number of iterations, which in my case is
 *   (n-2). (n-2) * 1 = n-2. Now we sum the for loop with the consecutive statements to get (n-2)+4. When we write this
 *   in Big O notation we ignore the constants so it becomes O(n). This makes sense as we loop from 2 to n to find F(n)
 *   so if n increases, we add an extra iteration.
 *
 *   d)
 *   The measurements for this method, minus a few outliers, follow closely enough the expected Big-O notation. As n
 *   increases we see an increase in the running time. The bigger the jump between n we tend to see a bigger difference
 *   as well. Looking at the "non-recursive" row above, when we go from (n=2) -> (n=4) the running time jumps from
 *   25084 to 27049, but when we go from (n=16) -> (n=32) the running time makes a larger jump from 33539 to 40756.
 *   This is the behaviour we'd expect to see from a O(n) function. Again, I was originally receiving erratic results
 *   for the running time, so I ran each test 5 times with the same n and then took the mean results.
 *
 *   4)
 *   a)
 *   The BigO of the non-recrusive method using O(1) space, basically just the non-recursive without using an array,
 *   is also O(n). It is for the exact same reason as above. This time we only have 3 consecutive statements, outside
 *   of the loop and another 3 inside the loop. The loop also runs (n-2) times. So we end up with 3(n-2) + 3. We ignore
 *   constants again and end up with O(n).
 *
 *   b) The running time of this method is loosely correlated to the Big O notation. As n increases we see for the most
 *   part the running time also increases, however compared to the "non-recursive" row we don't see as big a jump.
 *   When we look at the "non-recursive O(1)" row, and go from (n=2) -> (n=4) the running time jumps from
 *   26327 to 30654. but when we go from (n=16) -> (n=32) the running time makes a much smaller jump from
 *   32082 to 32566. So yes, the running time increases as we increase, however for the numbers observed it does not
 *   seem to be closely related to how big the n difference is, as we observed with the normal non-recursive method.
 *
 *
 *************************************************************************/

public class Fibonacci {
    public static int nonRecursive(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        // initialise an array of size n
        int[] sequence = new int[n+1];
        int i = 2; // 1

        sequence[0] = 1;
        sequence[1] = 1;
        // loop through from 0 to n
        for(i = 2; i <= n; i++) { // n * t, t = 1, running time is n
            // otherwise, sum the previous two values in the array to get the next value
            sequence[i] = sequence[i-1] + sequence[i-2];
        }
        // at this point i = n, so sequence n (i-1+i-2) is the final element in the array, or F(n)
        return sequence[n];
    }

    public static int nonRecursiveO1(int n){
        // return 1 if the value is 0 or 1
        if(n == 0 || n == 1){
            return 1;
        }

        // initialise values used for F(n-1), F(n-2) and F(n)
        int fibo1=1, fibo2=1, fibonacci=1;

        //loop up to n, calculating F(i-1) + F(i-2) to get F(i). Final F(i) value is F(n)
        for(int i = 2; i <= n; i++){
            fibonacci = fibo1 + fibo2;
            fibo1 = fibo2;
            fibo2 = fibonacci;
        }

        return fibonacci;
    }

    public static int recursive(int n) {
        // if n is 1 or 0 we return 1 as that's the first 2 values in the Fibonacci sequence
       if (n == 0 || n == 1) {
           return 1;
       } else {
           // if n is more than 1 we recursively call this function again with n-1 and n-2, and this repeats until n is 0 or 1
           // when n is 0 or 1 it returns 1 and we add up all the values of 1 that the recursive function has returned which gives us F(n)
           return recursive(n-1) + recursive(n-2);
       }
    }
}
