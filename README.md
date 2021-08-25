# bunchofstuff
various algorithms, data structures, solutions etc.

*3wayquickparallelquicksort

              -sorts 100.000.000 integers in 0.691025 s.


*peakFinder 

              -Tested whether log-time Peak finding algorithm uses at most 3*log(n) comparisons
               on arrays with 1.000.000 elements and only one peak
               Executed 10 tests on such arrays.
               Total time spent in the test: 4.661
              
              
*3wayquicksort

        (All values are average of 10 test runs.)
        
        -3.5 times faster than the approach based on scala.util.Array.sort on sequences of 1,000,000 integers.
        
        -5.79 times faster than the approach based on scala.util.Array.sort on almost sorted sequences of 1,000,000 integers.
        
        -1.47 times faster than the approach based on scala.util.Array.sort on sequences of 1,000,000 small integers(meaning, there are lots of values that are  same).

         
*Union Find with Disjoint Sets data structure implemeneted. Uses both rank balancing and path compression.

*Find shortest missing string    

  `-Finds the shortest missing string over alpabet a. This implementation assumes you have a function that can generate all possible strings of length l over an alphabet a with m symbols. (That is done with the class StringEnumerator in this implementation) 
  -HashSet was used for the implementation. Compared to a naive approach of iterating over the possible substrings, HashSet was tested to be 12.852 times faster in the average of 10 tests.

* Minimum spanning tree generator.
  `Prim's algorithm was used for the mst generation. This piece of code assumes you already have a 'Graph' class where you generate a graph with G = (V, E, w) where V is the set of vertices, E is the set of edges and w is the corresponding weights to these edges. mstGenerator will return a set with the data (v,distance, parent(v)). Testing mstGenerator 10 times on random graphs with 100.000 vertices and 500.000 edges gave performance average of 0.9148642315 seconds. 
  
  
  * k-coloring solver. 
 `given a graph G and an integer k, solves if G can be colored with k different colors. Returns mapping from vertices to colors if possible. if it's not, returns false. Recursively backtrack searches all possible colorings. `
