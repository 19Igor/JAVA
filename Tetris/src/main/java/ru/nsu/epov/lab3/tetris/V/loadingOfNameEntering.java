package ru.nsu.epov.lab3.tetris.V;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import ru.nsu.epov.lab3.tetris.C.Controller;

import java.io.IOException;

public class loadingOfNameEntering {
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void setRoot(String fxml, Scene scene) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
}
