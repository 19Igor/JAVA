package ru.nsu.epov.lab3.game;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import ru.nsu.epov.lab3.game.Viewer.MMC;


import java.io.FileNotFoundException;


public class Main extends Application {
    private static final int SIZE = 25;
    private static int XMAX = SIZE * 12;
    private static int lateralMenu = 150;
    private static int YMAX = SIZE * 24;
    public static Stage primaryStage;

    @Override
    public void start(Stage stage) throws FileNotFoundException {
        primaryStage = stage;
        Group root = new Group();
        Scene scene = new Scene(root, XMAX + lateralMenu, YMAX);
        new MMC(stage, scene, root);

    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
