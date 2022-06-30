module ru.nsu.epov.lab3.game {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.nsu.epov.lab3.game to javafx.fxml;
    exports ru.nsu.epov.lab3.game;
    exports ru.nsu.epov.lab3.game.Controller;
    opens ru.nsu.epov.lab3.game.Controller to javafx.fxml;
    exports ru.nsu.epov.lab3.game.Model;
    opens ru.nsu.epov.lab3.game.Model to javafx.fxml;
    exports ru.nsu.epov.lab3.game.Viewer;
    opens ru.nsu.epov.lab3.game.Viewer to javafx.fxml;
}