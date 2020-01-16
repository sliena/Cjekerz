//import Main.board

import javafx.scene.Node
import scalafx.application
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.effect.GaussianBlur
import scalafx.scene.paint.Color._
import scalafx.scene.shape.Rectangle
import scalafx.scene.layout.BorderPane
import scalafx.Includes._

object Main extends JFXApp {
  implicit def superBoard(board: Array[Array[Int]]): ArrayAsBoard = new ArrayAsBoard(board)

  val root: BorderPane = new BorderPane()
  val board: Array[Array[Int]] = board.newEmptyBoard

  addBoardAsChildrenToRoot(board)

  stage = new application.JFXApp.PrimaryStage {
    title = "cjekerz"
    scene = new Scene(root, 800, 800)
  }

  board.state()


  // pass array board as parameter and add children to root
  def addBoardAsChildrenToRoot(board: Array[Array[Int]]): Unit = {
    var zeroX = 0
    var zeroY = 0
    for (i <- board.indices) {
      for (j <- board.indices) {
        board(i)(j) match {
          case 0 =>
            val rect = new Rectangle {
                fill = Black
                x = zeroX
                y = zeroY
                width = 100
                height = 100
              }
            root.children.add(rect)
          case 1 =>
            val rect = new Rectangle {
                fill = White
                x = zeroX
                y = zeroY
                width = 100
                height = 100
              }
            rect.onMouseClicked = e => {
              rect.setStyle("-fx-fill: red; ")
            }
            root.children.add(rect)
        }
        zeroX += 100
      }
      zeroX = 0
      zeroY += 100
    }
  }

  //  stage = new application.JFXApp.PrimaryStage {
  //
  //    title.value = "Cjekerz"
  //    width = 800
  //    height = 800
  //
  //    scene = new Scene {
  //      fill = White
  //      var field = new ListBuffer[Rectangle]
  //      var zeroX = 0
  //      var zeroY = 0
  //      for (i <- board.indices) {
  //        for (j <- board.indices) {
  //           board(i)(j) match {
  //            case 0 => {
  //              field.append(
  //                new Rectangle {
  //                  fill = Black
  //                  x = zeroX
  //                  y = zeroY
  //                  width = 100
  //                  height = 100
  //                })
  //            }
  //            case 1 => {
  //              field.append(
  //                new Rectangle {
  //                  fill = White
  //                  x = zeroX
  //                  y = zeroY
  //                  width = 100
  //                  height = 100
  //                })
  //            }
  //            case 2 => {
  //              field.append(
  //                new Rectangle {
  //                  fill = Blue
  //                  x = zeroX
  //                  y = zeroY
  //                  width = 100
  //                  height = 100
  //                })
  //            }
  //            case 3 => {
  //              field.append(
  //                new Rectangle {
  //                  fill = Green
  //                  x = zeroX
  //                  y = zeroY
  //                  width = 100
  //                  height = 100
  //                })
  //            }
  //          }
  //          zeroX += 100
  //        }
  //        zeroX = 0
  //        zeroY += 100
  //      }
  //      content = field
  //    }

  //    scene = new Scene {
  //      fill = White
  //      var checks = new ListBuffer[Rectangle]
  //      var zeroToForty = 0
  //      var zeroToSixty = 0
  //      for (i <- 0 to 8) {
  //        for (j <- 0 to 8) {
  //          if (((i & 1) == 0 && (j & 1) == 0) ||
  //            ((i & 1) != 0 && (j & 1) != 0)) {
  //            checks.append(Rectangle(40, 40,  i * zeroToSixty, i * zeroToForty))
  //          }
  //        }
  //        zeroToForty += 40
  //        zeroToSixty += 80
  //      }
  //      content = checks
  //    }


  //  }

}
