# bunchofstuff
various algorithms, data structures, solutions etc.

3wayquickparallelquicksort

              -sorts 100.000.000 integers in 0.691025 s.


peakFinder 

              -Tested whether log-time Peak finding algorithm uses at most 3*log(n) comparisons
               on arrays with 1.000.000 elements and only one peak
               Executed 10 tests on such arrays.
               Total time spent in the test: 4.661
              
              
3wayquicksort

        (All values are average of 10 test runs.)
        
        -3.5 times faster than the approach based on scala.util.Array.sort on sequences of 1,000,000 integers.
        
        -5.79 times faster than the approach based on scala.util.Array.sort on almost sorted sequences of 1,000,000 integers.
        
        -1.47 times faster than the approach based on scala.util.Array.sort on sequences of 1,000,000 small integers(meaning, there are lots of values that are              same).

         
