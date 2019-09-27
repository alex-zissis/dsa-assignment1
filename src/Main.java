/*************************************************************************
 *
 *  Pace University
 *  Fall 2019
 *  Data Structures and Algorithms
 *
 *  Course: CS 241
 *  Team Authors: Alex Zissis, Karl Eshwer, Kyle Pla
 *
 *  Assignment: 1
 *  Problem: Calculate and display the running time of various fibonacci methods.
 *
 *  Input: int n (the index of the fibonacci sequence you want to find)
 *  Output: void
 *
 *  Visible data fields: -
 *
 *
 *  Visible methods:
 *  public static void main(String[] args)
 *
 *************************************************************************/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.print("Enter number: ");
        Scanner scnr = new Scanner(System.in);
        int number = scnr.nextInt();

        long startTimeRec = System.nanoTime(); // your method call here
        Fibonacci.recursive(number);
        System.out.println("recursive : t = " + (System.nanoTime()-startTimeRec) + " nanosecs.\n");

        long startTimeNonRec = System.nanoTime(); // your method call here
        Fibonacci.nonRecursive(number);
        System.out.println("non recursive : t = " + (System.nanoTime()-startTimeNonRec) + " nanosecs.\n");

        long startTimeNonec01 = System.nanoTime(); // your method call here
        Fibonacci.nonRecursiveO1(number);
        System.out.println("non recursive (space of O(1)) : t = " + (System.nanoTime()-startTimeNonec01) + " nanosecs.\n");

    }
}
