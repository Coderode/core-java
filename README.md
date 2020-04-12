# core-java
core java programs

# Problems for the Assignments

## Assignment 1 (Matrix)
Write a menu driven program to create two m x n matrix, populate it with random integers and display their sum and product. Also display the time taken by the computer for the product operation. Make use of classes, constructors and necessary methods. Test your program for 500x500 matrix and display the computational time for the product operation.

## Assignment 2 (Constructor, Inheritance, etc.)

Define a class Graph that should model a Graph data structure and store its adjacency matrix, and have default (adjacency matrix should be a null matrix) as well as parameterized constructors. Graph class also has two method display() that displays the adjacency matrix, and isConnected() as predicate method that checks whether given graph is connected or not. Create two another classes namely DirectedGraph and WeightedGraph, both inherits Graph. DirectedGraph has two methods indegree() and outdegree() that calculates and indegree and outdegree of each node in the DirectedGraph. Similarly, WeightedGraph has a method shortestPath() that finds the shortest path between two given nodes using any of the algorithm known to you.
Write a Test program to demonstrate the working of all the three classes in your main program.

## Assignment 3 (String handling)
Given a string, find all distinct palindromic sub-strings of length>1. For example, str = "abaaa" then possible palindromic sub-strings are: aa, aaa, aba. Write an interactive Java Program which takes a long string as input and display all distinct palindromic substrings of length > 1. If students are highly motivated, they can write a GUI-based Java applications.

## Assignment 4 (string ,string tokenizer,filehandling etc)
The k-mer refers to all the possible substrings of length k that are contained in a string. In genomics, k-mers refer to all the possible subsequences (of length k) in a given DNA Sequence. The number of possible k-mers given n possibilities (n=4 in the case of DNA e.g. ACTG) is n^k. For example, if k=1, there are 4 k-mers possible (i.e. A, C, T, G), in case of k=2, 16 k-mers are possible (e.g. AA AT AC AG TA TT TC TG CA CT CC CG GA GT GC GG). Write a program which takes a DNA sequence file and value of k as input from the user, and calcualte the occurce of k-mers, and store it to a CSV file. [For example, if given DNA sequence S=ATTGCCC, k=2, then output should be as follows:
AA AT AC AG TA TT TC TG CA CT CC CG GA GT GC GG
0 1 0 0 0 1 0 1 0 0 2 0 0 0 1 0

## Assignment 5 (generic progamming)
Define a generic java class Matrix which resembles a 2D array of matrix of size mxn. The dimension of the matrix (m,n) can be taken as a constructor argument. The matrix class has a method called populateData() which generates the random values between a range and store it to the matrix. This class also overrides the toString() method so that matrix objects can be directly printed using System.out.println(). Create 20 objects of the matrix class and store it to an array list. Test your program for integer numbers as well as complex numbers.
[Hints: You need to define a class for complex numbers. The Matrix objects may be created as follows:

Matrix <Integer> m1 = new Matrix <Integer> (5, 6);
Matrix <Complex> M1 = new Matrix <Complex> (4, 6);
m1.populateData();
M2.populateData();
....
]
  
## Assignment 6 (Multithreading)
Write a multithreaded Java application to demonstrate synchronization in a Reader-Writer problem for a shared limited buffer.

## Assignment 7 (Multithreading)
Write multithreaded Java application for finding all the possible numbers of palindromes of size at least 3 in the given long string of DNA sequence. Take sequence input through file and store palindromes in a text file. Do you find multithreaded applications better than single threaded?

