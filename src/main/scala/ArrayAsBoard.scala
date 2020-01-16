class ArrayAsBoard(board: Array[Array[Int]]) {

  // return new populated board as Array[Array[Int]]
  def newBoard(): Array[Array[Int]] = {
    val b: Array[Array[Int]] = Array.ofDim[Int](8, 8)
    for (i <- b.indices) {
      for (j <- b.indices) {
        if (i == 0 || i == 1) b(i)(j) = 2
        else if (i == 6 || i == 7) b(i)(j) = 3
        else if (((i == 3 || i == 5) && (j & 1) != 0) ||
          ((i == 2 || i == 4) && (j & 1) == 0)) b(i)(j) = 1
      }
    }
    b
  }

  // return new unpopulated board
  def newEmptyBoard: Array[Array[Int]] = {
    val b: Array[Array[Int]] = Array.ofDim[Int](8, 8)
    for (i <- b.indices) {
      for (j <- b.indices) {
        if (((i & 1) == 0 && (j & 1) == 0) ||
          ((i & 1) != 0 && (j & 1) != 0)) b(i)(j) = 1
      }
    }
    b
  }

  // print current board state
  def state(): Unit = {
    for (i <- board.indices) {
      for (j <- board.indices) {
        print(board(i)(j))
      }
      println
    }
  }

  // swap two pieces
  def move(n: Int, n2: Int, n3: Int, n4: Int): Unit = {
    val temp = board(n3)(n4)
    board(n3)(n4) = board(n)(n2)
    board(n)(n2) = temp
  }

}


