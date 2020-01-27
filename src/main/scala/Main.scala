//import Main.board


import java.awt.MouseInfo

import scalafx.application
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.paint.Color._
import scalafx.scene.shape.{Circle, Rectangle}
import scalafx.scene.layout.BorderPane


object Main extends JFXApp {
  implicit def superBoard(board: Array[Array[Int]]): ArrayAsBoard = new ArrayAsBoard(board)

  val root: BorderPane = new BorderPane()
  val board: Array[Array[Int]] = board.newEmptyBoard
  val pieces: Array[Array[Int]] = pieces.newPieces()

  root.center
  root.setStyle("-fx-border-color:DarkBlue; -fx-border-width: 40;")
  drawBoard(root)
  drawPieces(root)


  stage = new application.JFXApp.PrimaryStage {
    title = "cjekerz"
    scene = new Scene(root, 880, 880)
  }

  def drawPieces(root: BorderPane): Unit = {
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
            circle.onMouseDragged = e => {
              circle.centerX = MouseInfo.getPointerInfo.getLocation.x
              circle.centerY = MouseInfo.getPointerInfo.getLocation.y
            }
            circle.onMouseReleased = e => {
              circle.setStyle("-fx-fill: LightCoral;")
              circle.centerX = MouseInfo.getPointerInfo.getLocation.x
              circle.centerY = MouseInfo.getPointerInfo.getLocation.y
            }
            root.children.add(circle)
          case 2 =>
            circle.fill = LightSeaGreen
            circle.centerX = zeroX
            circle.centerY = zeroY
            circle.radius = 30
            circle.onMouseDragged = e => {
              circle.centerX = MouseInfo.getPointerInfo.getLocation.x
              circle.centerY = MouseInfo.getPointerInfo.getLocation.y
            }
            circle.onMouseReleased = e => {
              circle.setStyle("-fx-fill: LightSeaGreen;")
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
  }

}
