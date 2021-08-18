  def minimumSpanningTree: Set[(Int,Int,Int)] = {
    require(isConnected)
    val pq = scala.collection.mutable.PriorityQueue[(Int, Int, Int)]()(Ordering.by[(Int, Int, Int), Int](_._2).reverse);
    //vertex , distance, parent(vertex)
    val mstSet = scala.collection.mutable.Set[(Int, Int, Int)](); 
    val visited = scala.collection.mutable.ArrayBuffer.fill(nofVertices)(-1);
    pq.enqueue((0,0,-1));
    visited(0) = 1;

    while(!pq.isEmpty){
      val u = pq.dequeue
      if(u._1 != 0 && visited(u._1) != 1){
        var temp = (u._1 , u._2, u._3);
        mstSet += temp;
      }
      if(visited(u._1) != 1 || u._1 == 0){
        visited(u._1) = 1;
        for(edge <- neighbours(u._1)){
          val v = edge._2;
          val weight = edge._1;
          if(visited(v) != 1){
            var temporary = (v, weight, u._1);
            pq.enqueue(temporary);
            }
        }
      } 
    }
    return mstSet.toSet;  
  }
