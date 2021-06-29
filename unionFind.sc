class UnionFind[E] {

  protected val parent = new scala.collection.mutable.HashMap[E,E]()
  protected val rank = new scala.collection.mutable.HashMap[E, Int]();
  protected var _nofSets = 0;


  def makeSet(element: E): Boolean = {
    
    if(parent.contains(element)){
      return false;
    }    
    else{
      parent(element) = element;
      rank(element) = 0;
      _nofSets += 1;
      return true;
    }
  }
  
  def findSet(element: E): E = {
    //raise error if element does not exist in any sets.

    def findandcompress(y : E) : E ={
      //y is the parent of itself, meaning its the root. return y
      if(parent(y) == y){
        return y;
      }
      else{
        //recursively go to the root of the tree, until we find the root.
        var r = findandcompress(parent(y));
        //set the parent of y as r
        parent(y) = r;
        return r;
      }
    }
    return findandcompress(element)
  }

  //O(log n) operation, where n is the number of elements in all the sets.
   
  def union(element1: E, element2: E): Unit = {
    //set xprime as the root of the tree with x [xprime  representative of the tree that contains x]
    var xprime = findSet(element1);
    //set yprime as the root of the tree with y [yprime is representative of the tree that contains y]
    var yprime = findSet(element2);
    if(xprime != yprime){
      if(rank(xprime) > rank(yprime)){
        parent(yprime) = xprime;
        _nofSets -= 1;
      }
      
      else{
        parent(xprime) = yprime;
        _nofSets -= 1;
        if(rank(xprime) == rank(yprime)){
        rank(yprime) += 1; 
        }
      }
    }
  }

  def nofElements: Int = {
    return parent.size;
  }

  def nofSets: Int = {
    return _nofSets;
  }
}
