import Main.board
import scalafx.scene.layout.BorderPane
import scalafx.scene.paint.Color.{Black, White}
import scalafx.scene.shape.Rectangle

class RootAsBoot (root: BorderPane) {

  def drawBoard(root: BorderPane): Unit = {
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
    root
  }

}
