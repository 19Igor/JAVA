package ru.nsu.epov.lab3.tetris.M;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import ru.nsu.epov.lab3.tetris.C.Controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Model{
    public static final int lateralMenu = 150;
    public static final int primeMenu = 350;

    public static final String backgroundPath = "fon.png";
    private final Stage primaryStage;

    public Model(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
    }
    /**
     *  For createBackground
     * */
    private static Image background;
    static {
        try {
            background = new Image(new FileInputStream(Model.backgroundPath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ImageView backView = new ImageView(background);

}
