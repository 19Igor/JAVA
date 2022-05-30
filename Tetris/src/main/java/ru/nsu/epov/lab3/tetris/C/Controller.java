package ru.nsu.epov.lab3.tetris.C;

import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import java.io.IOException;

import static ru.nsu.epov.lab3.tetris.V.loadingOfNameEntering.*;

public class Controller
{
    private Group buttonGroup = new Group();
    /**
     *  On-screen button placement.
     * */
    public final Group createMMC_Buttons(Scene scene)
    {
        Button start = new Button("Play");
        start.setLayoutX(150);
        start.setLayoutY(200);
        start.setPrefWidth(200);
        start.setPrefHeight(50);
        start.setStyle(String.format("-fx-font-size: %dpx;", 30));
        start.setOnAction((ActionEvent e) -> {
            try {
                enterNickName(scene);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        buttonGroup.getChildren().add(start);

        Button top = new Button("Player's top");
        top.setLayoutX(150);
        top.setLayoutY(300);
        top.setPrefWidth(200);
        top.setPrefHeight(50);
        top.setStyle(String.format("-fx-font-size: %dpx;", 30));  //  0.45 * 70 == 31,5
        buttonGroup.getChildren().add(top);

        Button about = new Button("About");
        about.setLayoutX(150);
        about.setLayoutY(400);
        about.setPrefWidth(200);
        about.setPrefHeight(50);
        about.setStyle(String.format("-fx-font-size: %dpx;", 30));
        buttonGroup.getChildren().add(about);

        Button exit = new Button("Exit");
        exit.setLayoutX(150);
        exit.setLayoutY(500);
        exit.setPrefWidth(200);
        exit.setPrefHeight(50);
        exit.setStyle(String.format("-fx-font-size: %dpx;", 30));
        buttonGroup.getChildren().add(exit);

        return buttonGroup;
    }

    private void  enterNickName(Scene scene) throws IOException {

        setRoot("EnterNick", scene);
    }



}
