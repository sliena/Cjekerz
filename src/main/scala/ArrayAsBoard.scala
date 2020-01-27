import Main.{board, pieces}
import scalafx.scene.layout.BorderPane
import scalafx.scene.paint.Color.{Black, LightCoral, LightSeaGreen, White}
import scalafx.scene.shape.{Circle, Rectangle}

class ArrayAsBoard(board: Array[Array[Int]]) {

  // return new populated board as Array[Array[Int]]
  def newBoard(): Array[Array[Int]] = {
    val arr: Array[Array[Int]] = Array.ofDim[Int](8, 8)
    for (i <- arr.indices) {
      for (j <- arr.indices) {
        if (i == 0 || i == 1) arr(i)(j) = 2
        else if (i == 6 || i == 7) arr(i)(j) = 3
        else if (((i == 3 || i == 5) && (j & 1) != 0) ||
          ((i == 2 || i == 4) && (j & 1) == 0)) arr(i)(j) = 1
      }
    }
    arr
  }

  def newPieces(): Array[Array[Int]] = {
    val arr: Array[Array[Int]] = Array.ofDim[Int](8, 8)
    for (i <- arr.indices) {
      for (j <- arr.indices) {
        if (i == 0 || i == 1) arr(i)(j) = 1
        else if ((i == 6) || (i == 7)) arr(i)(j) = 2
      }
    }
    arr
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

  def addPieces(root: BorderPane): Unit = {
    var zeroX = 90
    var zeroY = 90
    for (i <- 0 to 7) {
      for (j <- 0 to 7) {
        val circle = new Circle {}
        pieces(i)(j) match {
          case 1 =>
            circle.fill = LightCoral
            circle.centerX = zeroX
            circle.centerY = zeroY
            circle.radius = 30
            circle.onMouseClicked = e => {
              circle.setStyle("-fx-fill: green; ")
            }
            root.children.add(circle)
          case 2 =>
            circle.fill = LightSeaGreen
            circle.centerX = zeroX
            circle.centerY = zeroY
            circle.radius = 30
            circle.onMouseClicked = e => {
              circle.setStyle("-fx-fill: green; ")
            }
            root.children.add(circle)
          case 0 =>
        }
        zeroX += 100
      }
      zeroX = 90
      zeroY += 100
    }
  }


  // pass array board as parameter and add children to root
  def addBoard(root: BorderPane): Unit = {
    var zeroX = 40
    var zeroY = 40
    for (i <- 0 to 7) {
      for (j <- 0 to 7) {
        val rect = new Rectangle {}
        board(i)(j) match {
          case 0 =>
            rect.fill = Black
            rect.x = zeroX
            rect.y = zeroY
            rect.width = 100
            rect.height = 100
            rect.onMouseClicked = e => {
              rect.setStyle("-fx-fill: red; ")
            }
            root.children.add(rect)
          case 1 =>
            rect.fill = White
            rect.x = zeroX
            rect.y = zeroY
            rect.width = 100
            rect.height = 100
            rect.onMouseClicked = e => {
              rect.setStyle("-fx-fill: green; ")
            }
            root.children.add(rect)
        }
        zeroX += 100
      }
      zeroX = 40
      zeroY += 100
    }
  }

}


