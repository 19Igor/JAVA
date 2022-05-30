package ru.nsu.epov.lab3.tetris.V;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import ru.nsu.epov.lab3.tetris.M.*;
import ru.nsu.epov.lab3.tetris.C.*;

import static ru.nsu.epov.lab3.tetris.M.Model.backView;


public class MMC
{
    private final Group root = new Group();
    private final Stage primaryStage;
    private Scene scene;
    /**
     * Main Menu Creation
     * */
    public MMC(Stage primaryStage){
        Controller buttons = new Controller();
        this.primaryStage = primaryStage;
        this.createBackground();
        this.scene = new Scene(root, Model.primeMenu + Model.lateralMenu, Model.primeMenu * 2);

        Group butGroup = buttons.createMMC_Buttons(scene);
        root.getChildren().add(butGroup);
        this.primaryStage.setScene(this.scene);
        this.primaryStage.show();
    }

    /**
     * Creating of game's background.
     * */
    private final void createBackground(){
        primaryStage.setTitle("Tetris");
        backView.setX(0);
        backView.setY(0);
        backView.setFitWidth(Model.primeMenu + Model.lateralMenu);
        backView.setPreserveRatio(true);
        root.getChildren().add(backView);
    }
}
