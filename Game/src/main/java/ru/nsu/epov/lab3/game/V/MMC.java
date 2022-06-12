package ru.nsu.epov.lab3.game.V;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import ru.nsu.epov.lab3.game.Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static java.lang.System.exit;
import static ru.nsu.epov.lab3.game.V.Tetris.XMAX;

public class MMC {

    private static final String backgroundPath = "fon.png";

    /**
     * Main Menu Creation
     * */
    public MMC(Stage primaryStage, Scene scene, Group root) throws FileNotFoundException
    {
        createBackGround(primaryStage, root);
        root.getChildren().add(createMMC_Buttons(scene));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void createBackGround(Stage primaryStage, Group group) throws FileNotFoundException
    {
        Image background = new Image(new FileInputStream(backgroundPath));
        ImageView backView = new ImageView(background);

        primaryStage.setTitle("Tetris");
        backView.setX(0);
        backView.setY(0);
        backView.setFitWidth(XMAX + 150);
        backView.setPreserveRatio(true);
        group.getChildren().add(backView);
    }

    public final Group createMMC_Buttons(Scene scene)
    {
        Group buttonGroup = new Group();
        Button start = new Button("Play");
        start.setLayoutX(120);
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
        top.setLayoutX(120);
        top.setLayoutY(300);
        top.setPrefWidth(200);
        top.setPrefHeight(50);
        top.setOnAction((ActionEvent e) ->{
            try {
                showTable(scene);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        top.setStyle(String.format("-fx-font-size: %dpx;", 30));  //  0.45 * 70 == 31,5
        buttonGroup.getChildren().add(top);

        Button about = new Button("About");
        about.setLayoutX(120);
        about.setLayoutY(400);
        about.setPrefWidth(200);
        about.setPrefHeight(50);
        about.setOnAction((ActionEvent e) ->{
            try{
                showDescription(scene);
            }catch(IOException ex){
                ex.printStackTrace();
            }

        });
        about.setStyle(String.format("-fx-font-size: %dpx;", 30));
        buttonGroup.getChildren().add(about);

        Button exit = new Button("Exit");
        exit.setLayoutX(120);
        exit.setLayoutY(500);
        exit.setPrefWidth(200);
        exit.setPrefHeight(50);
        exit.setOnAction((ActionEvent e) -> exit(0));
        exit.setStyle(String.format("-fx-font-size: %dpx;", 30));
        buttonGroup.getChildren().add(exit);

        return buttonGroup;
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void setRoot(String fxml, Scene scene) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private void enterNickName(Scene scene) throws IOException {
        setRoot("EnterNick", scene);
    }


    private void showTable(Scene scene) throws IOException {
        new Table();
        setRoot("PlayersTable", scene);
    }

    private void showDescription(Scene scene) throws IOException {

        setRoot("Description", scene);
    }
}
