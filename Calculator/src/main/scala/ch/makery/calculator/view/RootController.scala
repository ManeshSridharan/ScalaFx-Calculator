package ch.makery.calculator.view
import scalafxml.core.macros.sfxml
import scalafx.event.ActionEvent
import ch.makery.calculator.MainApp
import scalafx.Includes._



@sfxml
class RootController(){
    def handleExit(action: ActionEvent): Unit = {
        System.exit(0)
    }

    def handleInfo(action: ActionEvent): Unit = {
        MainApp.showInfoPage
    }

    def handleHome(action: ActionEvent): Unit = {
        MainApp.showStartPage
    }
    
    def handleConverter(action: ActionEvent): Unit = {
        MainApp.showConversionPage
    }

    def handleCalculator(action: ActionEvent): Unit = {
        MainApp.showCalculator
    }

    def handleMinigame(action: ActionEvent): Unit = {
        MainApp.showMinigamePage
    }
}