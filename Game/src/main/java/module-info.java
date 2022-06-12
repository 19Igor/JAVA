module ru.nsu.epov.lab3.game {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.nsu.epov.lab3.game to javafx.fxml;
    exports ru.nsu.epov.lab3.game;
    exports ru.nsu.epov.lab3.game.C;
    opens ru.nsu.epov.lab3.game.C to javafx.fxml;
    exports ru.nsu.epov.lab3.game.M;
    opens ru.nsu.epov.lab3.game.M to javafx.fxml;
    exports ru.nsu.epov.lab3.game.V;
    opens ru.nsu.epov.lab3.game.V to javafx.fxml;
}