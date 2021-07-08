/**
   * Find a shortest string
   * - whose characters are from the alphabet and
   * - that is not a substring of the string str.
   */
  def findOne(str: String, alphabet: Set[Char]): String = {
    require(alphabet.nonEmpty)
    require(str.forall(c => alphabet contains c))
    val n = str.length
    val m = alphabet.size
    var myHashSet = new scala.collection.mutable.HashSet[String]
    var length = 1

    while true do{
      val iter = new StringEnumerator(length, alphabet)
      while iter.hasNext do{
        val s = iter.next()
        myHashSet.add(s);
      }
      var i = 0;
      var sizee = str.size;
      while((i + length != str.size - 1) && !(myHashSet.isEmpty)){
        val subsstr = str.substring(i, i+length)
        if(myHashSet.contains(subsstr)){
          myHashSet.remove(subsstr);
        }
        i += 1
      }
      if(!myHashSet.isEmpty){
        return myHashSet.head
      }
      length += 1;
    }
    var s = "we should never be here"
    return s;
  }
