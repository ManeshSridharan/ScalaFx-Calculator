package ch.makery.calculator.view
import scalafxml.core.macros.sfxml
import scalafx.event.ActionEvent
import ch.makery.calculator.MainApp
import scalafx.Includes._
import scalafx.scene.image.{Image, ImageView}


@sfxml
class Start(
    private var designImage: ImageView,
    private var designImage2: ImageView,
){

    designImage.image = new Image("file:resources/images/calc.png")
    designImage2.image = new Image("file:resources/images/calculatorgif.gif")
    
    
    def handleStart(action: ActionEvent){
        MainApp.showCalculator
    }

    def handleConverter(action: ActionEvent){
        MainApp.showConversionPage
    }

    def handleMinigame(action: ActionEvent){
        MainApp.showMinigamePage
    }
}