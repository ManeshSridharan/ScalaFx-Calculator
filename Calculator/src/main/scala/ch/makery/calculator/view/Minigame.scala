package ch.makery.calculator.view
import scalafxml.core.macros.sfxml
import scalafx.event.ActionEvent
import ch.makery.calculator.MainApp
import scalafx.scene.control.{Button, TextField}
import scalafx.scene.text.Text
import scalafx.Includes._
import scalafx.scene.image.{Image, ImageView}
import scala.util.Random


@sfxml
class Minigame(
    private var randomValue : Int,
    private var guessValue: Int,
    private val userGuess : TextField,
    private val higherDisplay: Text,
    private val lowerDisplay: Text,
    private val displayError: Text,
    private val designImage: ImageView
){

    randomValue = Random.nextInt(99999) // used to generate a random 5 digit number
    designImage.image = new Image("file:resources/images/Guessing.png")


    def play (action: ActionEvent): Unit = {
        try{
            lowerDisplay.setText("")
            higherDisplay.setText("")
            displayError.setText("")
            guessValue = userGuess.getText().toInt

            if (randomValue < guessValue){
                higherDisplay.setText("Guess again! the value you inputted is HIGHER than the goal")
            }
            else if (randomValue > guessValue){
                lowerDisplay.setText("Guess again! the value you inputted is LOWER than the goal")
            }
            else if (randomValue == guessValue){
                MainApp.showWinScreen
            }
            } catch {
                case x: NumberFormatException =>
                displayError.setText("ERROR: Enter an Integer")
                userGuess.setText("")
            }

    }


}
