def kColoring(g: Graph, k: Int): Option[Map[Int,Int]] = {
    require(g != null && g.nofVertices > 0)
    require(k >= 1 & k <= 64)
    val N = g.nofVertices
    val mapping = scala.collection.mutable.Map[Int, Int]();
    val colors = scala.collection.mutable.ArrayBuffer.fill(N)(-1);

    def inner(vertex: Int) : Boolean = {
      //check if we reach the end of the graph
      val note = scala.collection.mutable.Set[Int]();
      if(vertex == N){
        return true;
      }
      //if not go through all the neighbours and take note what color neighbours are.
      for(u <- g.neighbours(vertex)){
        //take the color of neighbour |colors(u)| and set that color to be true 
        note(colors(u)) = true;
      }
      var index = 0;
      while(index < k){
        if(note(index) == false){
          colors(vertex) = index;
          if(inner(vertex + 1) == true){
            return true;
          }
        }
        index += 1;
      }
      colors(vertex) = -1;
      return false;
    }
    if(inner(0)){
      //construct the mapping
      for(i <- 0 until N){
        mapping(i) = colors(i);
      }
      val toret = mapping.toMap;
      Some(toret);
    }
    else{
      None;
    }
  }
