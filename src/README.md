# MTCollatz - Project 1

# Author: Roderick Davis

# Contains MTCollatz.java and Collatz.java

# Program is executed by running the MTCollatz program with two numeric arguments. args[0] represents the range of values tested and 
args[1] is the number of threads to be created. Program will calculate the frequency of stop times and execution time based on given values.

# Problems encountered with this code included handling exceptions with input values that did not meet the criteria required. 
Another probelm inlclude memory mmanagement, selecting very large values for input could lead to Overflow. Other problems encountered were
race conditions that were solved with mutex locks. 