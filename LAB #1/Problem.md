In this lab, you will learn to use loops and conditional statements. You will also learn how to use the Scanner class for console I/O as well as to parse tokens from a String.

Background on String Tokenization

You may use the Scanner class to tokenize a string. To do that, you need to pass the string that you want to tokenize to the constructor of Scanner class. You may specify a delimeter that your Scanner object should use to separate the tokens. The delimeter is specified as a regular expression. See the Tokenizer.java as an example.

In this example, Scanner object for tokenization is created via new Scanner(str) call. Delimeter regular expression is specified with tokens.useDelimiter("\\s+") call.

Note there are other ways to tokenize strings. e.g. String.split() method, StringTokenizer class.

If you want to match the individual tokens to some patterns, you may use matches() method of the String class. In the example, token.matches("[0-9]+")) checks if the token string matches a regular expression for a number.

Problem Statement

Develop a simple calculator that takes an arithmetic expression as input and computes its result. Unlike the normal arithmetic operator precedence (e.g., multiplication precedes addition), this program computes in the order from left to right. Four different samples are shown in Scenarios 1 to 4.

![Screenshot 2023-11-11 150841](https://github.com/iAyushG/95712-Object-Oriented-Programming-in-Java/assets/66333673/7272ee68-03c3-45db-b4cf-2584a07ca941)

Solution Design: Please refer to code files for design details

Solution Constraints:

There are many relatively more efficient ways to solve this problem. However, the objective is to learn some simple concepts to solve a simple problem. Therefore, there are some restrictions imposed on your solution:

You cannot use arrays or collection classes.
The user input can only have numbers as operands and binary operators (+, -, *, /)
The user input must have operands and operators separated by spaces
The arithmetic expression will be computed from left to right, without considering operator precedence.
Suggestions:

Split the arithmetic expression string into tokens using space as default delimiter.
Use the matches() method of String class to match a token with a regular expression.
The regex to match a number: "[+-]?[0-9]+"
The regex to match any of the four operators: "[-+/*]"

Instructions:
Create package named lab1
Download and copy/import following files into the package:
1. Calculator.java
2. TestCalculator.java
Complete and test the code as needed
