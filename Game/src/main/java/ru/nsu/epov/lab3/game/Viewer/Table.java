package ru.nsu.epov.lab3.game.Viewer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Table {
    private final String playersTablePath = "PlayersTop.txt";
    private String[] nicks = new String[20];
    private int[] scores = new int[20];
    private Scanner reader = null;
    private String separator = " ";
    ObservableList<Line> list;


    @FXML
    private TableView<Line> table;

    @FXML
    private TableColumn<Line, String> Nickname;

    @FXML
    private TableColumn<Line, Integer> Score;

    @FXML
    public void initialize()
    {
        Nickname.setCellValueFactory(new PropertyValueFactory<Line, String>("nickName"));
        Score.setCellValueFactory(new PropertyValueFactory<Line, Integer>("score"));
        table.setItems(list);
    }

    public Table() throws FileNotFoundException {

        for (int i = 0; i < 20; i++)
        {
            nicks[i] = "";
            scores[i] = 0;
        }


        String line = new String();
        reader = new Scanner(new File(playersTablePath));
        if (reader.hasNextLine())
            line = reader.nextLine();           // line = a 98 b 76 c 54 c 32 d 11

        String[] massiv = new String[20];
         massiv = line.split(separator);
        for (int i = 0, j = 0; i < massiv.length; i += 2, j++)
        {
            nicks[j] = massiv[i];
            scores[j] = Integer.parseInt(massiv[i + 1]);
        }

        list = FXCollections.observableArrayList(
                new Line(nicks[0], scores[0]),
                new Line(nicks[1], scores[1]),
                new Line(nicks[2], scores[2]),
                new Line(nicks[3], scores[3]),
                new Line(nicks[4], scores[4]),
                new Line(nicks[5], scores[5]),
                new Line(nicks[6], scores[6]),
                new Line(nicks[7], scores[7]),
                new Line(nicks[8], scores[8]),
                new Line(nicks[9], scores[9]),

                new Line(nicks[10], scores[11]),
                new Line(nicks[12], scores[12]),
                new Line(nicks[13], scores[13]),
                new Line(nicks[14], scores[14]),
                new Line(nicks[15], scores[15]),
                new Line(nicks[16], scores[16]),
                new Line(nicks[17], scores[17]),
                new Line(nicks[18], scores[18]),
                new Line(nicks[19], scores[19])
        );
    }
}
