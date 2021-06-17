/*
   * Returns the index of a peak in the array arr.
*/

  def solveLog[T](arr: Array[T])(implicit ord: Ordering[T]): Int = {
    require(arr.nonEmpty)

    def inner(from: Int, to: Int): Int = {
        val mid = from + (to - from) / 2
        if(mid == 0 && (to==arr.length - 1)){
          if(to == 1){
            if(ord.gteq(arr(mid), arr(mid+1))){
              return 0;
            }
            else{
              return mid+1;
            } 
          }
          else{
            if(ord.gteq(arr(mid), arr(mid-1))){
              return to;
            }
            else{
              return (to-1);
            }
        }
        }
        else if(mid == 0 && (to!=arr.length - 1)){
          if(ord.gteq(arr(mid), arr(mid+1))){
            return 0;
          }
          else{
            return mid+1;
          }
        }
        if (isPeak(arr, mid)) {
          return mid;
        }
        if(ord.gteq(arr(mid), arr(mid-1))){
          inner(mid + 1, to);
        } 
        else{
          inner(from, mid);
        }
      }
    if(arr.length == 1){
      return 0;
    }
    inner(0, arr.length - 1);
  }
