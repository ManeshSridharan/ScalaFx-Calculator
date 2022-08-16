package ch.makery.calculator.view
import scalafxml.core.macros.sfxml
import scalafx.event.ActionEvent
import ch.makery.calculator.MainApp
import scalafx.scene.control.{Button, TextField}
import scalafx.scene.text.Text
import scalafx.Includes._


@sfxml
class Conversion(
    private var celsius : Double,
    private var fahrenheit : Double,
    private var liters : Double,
    private var milliliters : Double,
    private var meters : Double,
    private var kilometres : Double,
    private var answer: String,
    private var answer2: String,
    private var answer3: String,
    private val celsiusDisplay : TextField,
    private val fahrenheitDisplay : TextField,
    private val litersDisplay : TextField,
    private val millilitersDisplay : TextField,
    private val metersDisplay : TextField,
    private val kilometresDisplay : TextField,
    private val displayError : Text,
    private val displayError2 : Text,
    private val displayError3 : Text
){

    def celsiusToFahrenheit (action: ActionEvent): Unit = {
            try{
                displayError.setText("")
                celsius = celsiusDisplay.getText().toDouble
                fahrenheit = (celsius * 1.8) + 32
                answer = fahrenheit.toString
                fahrenheitDisplay.setText(answer)
            } catch {
                case x: NumberFormatException =>
                displayError.setText("ERROR: Enter an Integer")
                fahrenheitDisplay.setText("")
            }
        }
    
    def litersToMilliliters (action: ActionEvent): Unit = {
            try{
                displayError2.setText("")
                liters = litersDisplay.getText().toDouble
                milliliters = (liters * 1000)
                answer2 = milliliters.toString
                millilitersDisplay.setText(answer2)
            } catch {
                case x: NumberFormatException =>
                displayError2.setText("ERROR: Enter an Integer")
                millilitersDisplay.setText("")
            }
    }

    def metersToKilometres (action: ActionEvent): Unit = {
            try{
                displayError3.setText("")
                meters = metersDisplay.getText().toDouble
                kilometres = (meters / 1000)
                answer3 = kilometres.toString
                kilometresDisplay.setText(answer3)
            } catch {
                case x: NumberFormatException =>
                displayError3.setText("ERROR: Enter an Integer")
                kilometresDisplay.setText("")
            }
    }
}
