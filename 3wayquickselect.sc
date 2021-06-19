package object quickSelect {

  /*
    *Returns the kth smallest element. 
    *example, a list contains 20 elements.
    *find(list, 0) -> returns the smallest element,
    *find(list, 19) --> returns the largest element,
    *find(list, 6) --> returns the 7th smallest element,
    *in the list.
  */

  def swap(a: Array[Int], i: Int, j: Int): Unit = {
    val t = a(i); a(i) = a(j); a(j) = t
  }
  // A pseudo-random number generator with a fixed seed
  // so that error situations can be reproduced easier
  //the seed should, obviously, be modified before usage
  val rand = new scala.util.Random(21)


  def partition(a: Array[Int], lo: Int, hi: Int): (Int,Int) = {
    var size = hi + 1;
    var i = lo;
    var k = lo;
    var n = hi - lo + 1;
    var p = hi;

    var pivotLocation = rand.nextInt(n);
    swap(a,pivotLocation + lo, hi);
    while((i < size) && (i != p)){
      if(a(i) < a(hi)){
        swap(a,i,k);
        i += 1;
        k += 1;
      }
      else if(a(i) == a(hi)){
        p -= 1;
        swap(a,i,p);
      }
      else{
        i += 1;
      }
    }
    var numberofPivots = hi - p + 1;
    var o = 0;
    while(o < numberofPivots){
      swap(a,k + o,p+o);
      o +=1;
    }
    return(k, k+numberofPivots);
  }

  def find(seq: Seq[Int], k: Int): Int = {
    require(0 <= k && k < seq.length)
    val a: Array[Int] = seq.toArray
    def quickselect(a: Array[Int]): Int = {
      def _quickselect(lo: Int, hi: Int): Int = {

        val (pivotStart , pivotEnd) = partition(a, lo, hi)
        if (k < pivotStart){
          _quickselect(lo, pivotStart - 1);
        }
        else if((k >= pivotStart) && (k < pivotEnd)){
          return a(k);
        }
        else{
          _quickselect(pivotEnd, hi);
        }
      }
      if(a.length >= 2){
        _quickselect(0, a.length - 1)}
      else{
        return a(0);
      }
    }
    quickselect(a);
  }
}
