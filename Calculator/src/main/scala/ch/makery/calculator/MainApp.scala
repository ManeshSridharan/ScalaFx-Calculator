package ch.makery.calculator

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.Includes._
import scalafxml.core.FXMLLoader
import scalafxml.core.NoDependencyResolver
import javafx.{scene => jfxs}
import scalafx.scene.image.Image



object MainApp extends JFXApp{

    val rootResource = getClass.getResource("view/RootLayout.fxml")

    val loader = new FXMLLoader(rootResource, NoDependencyResolver)
    loader.load()
    val roots = loader.getRoot[jfxs.layout.BorderPane]
    
    stage = new PrimaryStage(){
        title = "Calculator"
        icons += new Image("file:resources/images/calculatorIcon.png")
        scene = new Scene(987,682){
            root = roots
        }
    }

    def showCalculator() = {
        val resource = getClass.getResource("view/CalculatorPage.fxml")
        val loader = new FXMLLoader(resource, NoDependencyResolver)
        loader.load()
        val roots = loader.getRoot[jfxs.layout.AnchorPane]
        this.roots.setCenter(roots)
    }

    def showStartPage() = {
        val resource = getClass.getResource("view/StartPage.fxml")
        val loader = new FXMLLoader(resource, NoDependencyResolver)
        loader.load()
        val roots = loader.getRoot[jfxs.layout.AnchorPane]
        this.roots.setCenter(roots)
    }

    def showInfoPage() = {
        val resource = getClass.getResource("view/InfoPage.fxml")
        val loader = new FXMLLoader(resource, NoDependencyResolver)
        loader.load()
        val roots = loader.getRoot[jfxs.layout.AnchorPane]
        this.roots.setCenter(roots)
    }

    def showConversionPage() = {
        val resource = getClass.getResource("view/ConversionPage.fxml")
        val loader = new FXMLLoader(resource, NoDependencyResolver)
        loader.load()
        val roots = loader.getRoot[jfxs.layout.AnchorPane]
        this.roots.setCenter(roots)
    }

    def showMinigamePage() = {
        val resource = getClass.getResource("view/MinigamePage.fxml")
        val loader = new FXMLLoader(resource, NoDependencyResolver)
        loader.load()
        val roots = loader.getRoot[jfxs.layout.AnchorPane]
        this.roots.setCenter(roots)
    }

    def showWinScreen() = {
        val resource = getClass.getResource("view/WinScreen.fxml")
        val loader = new FXMLLoader(resource, NoDependencyResolver)
        loader.load()
        val roots = loader.getRoot[jfxs.layout.AnchorPane]
        this.roots.setCenter(roots)
    }

    showStartPage()
}

