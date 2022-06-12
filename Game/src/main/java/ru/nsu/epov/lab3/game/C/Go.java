package ru.nsu.epov.lab3.game.C;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ru.nsu.epov.lab3.game.V.Tetris;
import ru.nsu.epov.lab3.game.C.PlayersTop;

import ru.nsu.epov.lab3.game.Main;


public class Go
{
    public Button goes;
    @FXML
    private TextField name;

    public void pressGo()
    {
        PlayersTop.nick = name.getText();
        Tetris game  = new Tetris();
        game.startTheGame(Main.primaryStage);
        System.out.println(Tetris.score);
    }
}
