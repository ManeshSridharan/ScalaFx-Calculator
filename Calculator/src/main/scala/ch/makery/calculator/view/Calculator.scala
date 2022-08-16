package ch.makery.calculator.view
import scalafxml.core.macros.sfxml
import scalafx.scene.control.{Button, TextField}
import ch.makery.calculator.MainApp
import scalafx.event.ActionEvent
import scalafx.Includes._
import scala.math._
import scala.collection.mutable.ListBuffer
import scalafx.scene.text.Text


@sfxml
class Calculator ( 
    private var operation: String,
    private var num1 : Double,
    private var num2 : Double,
    private var answer: Double,
    private val secondDisplay : TextField,
    private val display : TextField,
    private val buttonZero: Button,
    private val buttonOne: Button,
    private val buttonTwo: Button,
    private val buttonThree: Button,
    private val buttonFour: Button,
    private val buttonFive: Button,
    private val buttonSix: Button,
    private val buttonSeven: Button,
    private val buttonEight: Button,
    private val buttonNine: Button,
    private val savedValues: Text
){

    /* List Buffer used to store operations performed by users */
    var savedCalculations: ListBuffer[String] = ListBuffer[String]()

    /* Index used to keep track of the index of which the item is added to the list buffer*/
    var index: Int = 0

    /* For the number inputs on action display the specific values to the display */
    buttonZero.onAction = (action: ActionEvent) =>{
        display.appendText("0")
    }

    buttonOne.onAction = (action: ActionEvent) =>{
        display.appendText("1")
    }
    
    buttonTwo.onAction = (action: ActionEvent) =>{
        display.appendText("2")
    }

    buttonThree.onAction = (action: ActionEvent) =>{
        display.appendText("3")
    }

    buttonFour.onAction = (action: ActionEvent) =>{
        display.appendText("4")
    }

    buttonFive.onAction = (action: ActionEvent) =>{
        display.appendText("5")
    }

    buttonSix.onAction = (action: ActionEvent) =>{
        display.appendText("6")
    }

    buttonSeven.onAction = (action: ActionEvent) =>{
        display.appendText("7")
    }

    buttonEight.onAction = (action: ActionEvent) =>{
        display.appendText("8")
    }

    buttonNine.onAction = (action: ActionEvent) =>{
        display.appendText("9")
    }

    def point (action: ActionEvent): Unit = {
        display.appendText(".")
    }

    /* For the operations that require 2 outputs, this function stores the first 
    value inputted by the users and clears the display for the second ouput */
    def addition (action: ActionEvent): Unit = {
        try{
            num1 = display.getText().toDouble
            display.setText("")
            secondDisplay.setText(num1.toString + " + ")
            operation = "+"
        } catch {
            case x: NumberFormatException =>
                secondDisplay.setText("ERROR: Enter a value first!")
                display.setText("") 
        }
    }


    def subtraction (action: ActionEvent): Unit = {
        try{
            num1 = display.getText().toDouble
            display.setText("")
            secondDisplay.setText(num1.toString + " - ")
            operation = "-"
        } catch {
            case x: NumberFormatException =>
                secondDisplay.setText("ERROR: Enter a value first!")
                display.setText("") 
        }
    }


    def division (action: ActionEvent): Unit = {
        try{
            num1 = display.getText().toDouble
            display.setText("")
            secondDisplay.setText(num1.toString + " ÷ ")
            operation = "÷"
        } catch {
            case x: NumberFormatException =>
                secondDisplay.setText("ERROR: Enter a value first!")
                display.setText("") 
        }
    }

    def multiplication (action: ActionEvent): Unit = {
        try{
            num1 = display.getText().toDouble
            display.setText("")
            secondDisplay.setText(num1.toString + " x ")
            operation = "x"
        } catch {
            case x: NumberFormatException =>
                secondDisplay.setText("ERROR: Enter a value first!")
                display.setText("") 
        }
    }


    def clear (action: ActionEvent): Unit = {
        display.setText("")
        secondDisplay.setText("")
    }

    
    /* For this operations that require a single input, the input is get using getText() and calculations is performed */

    def square (action: ActionEvent): Unit = {
        try{
            num1 = display.getText().toDouble
            secondDisplay.setText(num1 + "²")
            answer = num1 * num1 
            display.setText(answer.toString)
            savedCalculations += (secondDisplay.getText() + " =" + answer.toString + "\n")
            index += 1
            savedValues.text = savedValues.getText() + savedCalculations(index - 1)
        } catch {
            case x: NumberFormatException =>
                secondDisplay.setText("ERROR: Enter a value first!")
                display.setText("") 
        }
    }


    def cube (action: ActionEvent): Unit = {
        try{
            num1 = display.getText().toDouble
            secondDisplay.setText(num1 + "³")
            answer = num1 * num1 * num1
            display.setText(answer.toString)
            savedCalculations += (secondDisplay.getText() + " =" + answer.toString + "\n")
            index += 1
            savedValues.text = savedValues.getText() + savedCalculations(index - 1)
        } catch {
            case x: NumberFormatException =>
                secondDisplay.setText("ERROR: Enter a value first!")
                display.setText("") 
        }
    }


    def percentage (action: ActionEvent): Unit = {
        try{
            num1 = display.getText().toDouble
            secondDisplay.setText(num1 + "%")
            answer = num1 / 100
            display.setText(answer.toString)
            savedCalculations += (secondDisplay.getText() + " =" + answer.toString + "\n")
            index += 1
            savedValues.text = savedValues.getText() + savedCalculations(index - 1)
        } catch {
            case x: NumberFormatException =>
                secondDisplay.setText("ERROR: Enter a value first!")
                display.setText("") 
        }
    }


    def squareRoot(action: ActionEvent): Unit = {
        try{
            num1 = display.getText().toDouble
            secondDisplay.setText("√" + num1)
            answer = math.sqrt(num1)
            display.setText(answer.toString)
            savedCalculations += (secondDisplay.getText() + " =" + answer.toString + "\n")
            index += 1
            savedValues.text = savedValues.getText() + savedCalculations(index - 1)

        } catch {
            case x: NumberFormatException =>
                secondDisplay.setText("ERROR: Enter a value first!")
                display.setText("") 
        }
    }


    def cubeRoot (action: ActionEvent): Unit = {
        try{
            num1 = display.getText().toDouble
            secondDisplay.setText("∛" + num1)
            answer = math.cbrt(num1)
            display.setText(answer.toString)
            savedCalculations += (secondDisplay.getText() + " =" + answer.toString + "\n")
            index += 1
            savedValues.text = savedValues.getText() + savedCalculations(index - 1)
        } catch {
            case x: NumberFormatException =>
                secondDisplay.setText("ERROR: Enter a value first!")
                display.setText("") 
        }
    }



    def negative (action: ActionEvent): Unit = {
        try{
            num1 = display.getText().toDouble
            answer = num1 * (-1)
            display.setText(answer.toString)
            savedCalculations += (secondDisplay.getText() + " =" + answer.toString + "\n")
            index += 1
            savedValues.text = savedValues.getText() + savedCalculations(index - 1)
        } catch {
            case x: NumberFormatException =>
                secondDisplay.setText("ERROR: Enter a value first!")
                display.setText("") 
        }
    }


    def log (action: ActionEvent): Unit = {
        try{
            num1 = display.getText().toDouble
            secondDisplay.setText("Log " + num1)
            answer = math.log10(num1)
            display.setText(answer.toString)
            savedCalculations += (secondDisplay.getText() + " =" + answer.toString + "\n")
            index += 1
            savedValues.text = savedValues.getText() + savedCalculations(index - 1)
        } catch {
            case x: NumberFormatException =>
                secondDisplay.setText("ERROR: Enter a value first!")
                display.setText("") 
        }
    }


    def sin (action: ActionEvent): Unit = {
        try{
            num1 = display.getText().toDouble
            secondDisplay.setText("sin " + num1)
            answer = math.sin(num1)
            display.setText(answer.toString)
            savedCalculations += (secondDisplay.getText() + " =" + answer.toString + "\n")
            index += 1
            savedValues.text = savedValues.getText() + savedCalculations(index - 1)
        } catch {
            case x: NumberFormatException =>
                secondDisplay.setText("ERROR: Enter a value first!")
                display.setText("") 
        }
    }


    def tan (action: ActionEvent): Unit = {
        
        try{
            num1 = display.getText().toDouble
            secondDisplay.setText("tan " + num1)
            answer = math.tan(num1)
            display.setText(answer.toString)
            savedCalculations += (secondDisplay.getText() + " =" + answer.toString + "\n")
            index += 1
            savedValues.text = savedValues.getText() + savedCalculations(index - 1)
        } catch {
            case x: NumberFormatException =>
                secondDisplay.setText("ERROR: Enter a value first!")
                display.setText("") 
        }
    }


    def cos (action: ActionEvent): Unit = {
        try{
            num1 = display.getText().toDouble
            secondDisplay.setText("cos " + num1)
            answer = math.cos(num1)
            display.setText(answer.toString)
            savedCalculations += (secondDisplay.getText() + " =" + answer.toString + "\n")
            index += 1
            savedValues.text = savedValues.getText() + savedCalculations(index - 1)
        } catch {
            case x: NumberFormatException =>
                secondDisplay.setText("ERROR: Enter a value first!")
                display.setText("") 
        }
    }


    def delete (action: ActionEvent): Unit = {
        try{
            display.setText(display.getText(0, display.getLength()-1))

        } catch {
            case x: NumberFormatException =>
                secondDisplay.setText("ERROR: Enter a value first!")
                display.setText("") 
        }
    }
    
    
    /* This function is the second part after the operation is choosed for the 2 input operations, 
    where it will get the second value and perform the specific task once the equals button is clicked. */
    def equal(action: ActionEvent): Unit = {
        secondDisplay.setText("")
        operation match{
            case "+" => {
                num2 = display.getText().toDouble
                secondDisplay.setText(num1 + " + " + num2)
                answer = num1 + num2
                display.setText(answer.toString)
                savedCalculations += (secondDisplay.getText() + " =" + answer.toString + "\n")
                index += 1
            }

            case "-" => {
                num2 = display.getText().toDouble
                secondDisplay.setText(num1 + " - " + num2)
                answer = num1 - num2
                display.setText(answer.toString)
                savedCalculations += (secondDisplay.getText() + " =" + answer.toString + "\n")
                index += 1
            }

            case "÷" =>  {
                num2 = display.getText().toDouble
                secondDisplay.setText(num1 + " ÷ " + num2)
                answer = num1 / num2
                display.setText(answer.toString)
                savedCalculations += (secondDisplay.getText() + " =" + answer.toString + "\n")
                index += 1
            }

            case "x" => {
                num2 = display.getText().toDouble
                secondDisplay.setText(num1 + " x " + num2)
                answer = num1 * num2
                display.setText(answer.toString)
                savedCalculations += (secondDisplay.getText() + " =" + answer.toString + "\n")
                index += 1
            }

        }
        savedValues.text = savedValues.getText() + savedCalculations(index - 1)       
    }

    def clearStorage (action: ActionEvent): Unit = {
        savedValues.setText("")
    }

    def handleMinigame(action: ActionEvent): Unit = {
        MainApp.showMinigamePage
    }

    def handleConverter(action: ActionEvent): Unit = {
        MainApp.showConversionPage
    }
    
}