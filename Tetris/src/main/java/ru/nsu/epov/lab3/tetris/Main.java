package ru.nsu.epov.lab3.tetris;

import javafx.application.Application;
import javafx.stage.Stage;
import ru.nsu.epov.lab3.tetris.V.MMC;

import java.io.IOException;

public class Main extends Application
{
    @Override
    public void start(Stage primaryStage) throws IOException
    {
        new MMC(primaryStage);



    }

    public static void main(String[] args)
    {
        launch();
    }
}
