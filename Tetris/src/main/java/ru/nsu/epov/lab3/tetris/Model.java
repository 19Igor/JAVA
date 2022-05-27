package ru.nsu.epov.lab3.tetris;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Model extends Application
{
    private final int lateralMenu = 150;
    private final int primeMenu = 350;

    @Override
    public void start(Stage stage) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(Model.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), primeMenu + lateralMenu, primeMenu * 2);
        stage.setTitle("Tetris !");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }
}