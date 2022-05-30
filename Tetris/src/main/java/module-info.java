module ru.nsu.epov.lab3.tetris {
    requires javafx.controls;
    requires javafx.fxml;

    opens ru.nsu.epov.lab3.tetris to javafx.fxml;

    exports ru.nsu.epov.lab3.tetris.V;
    opens ru.nsu.epov.lab3.tetris.V to javafx.fxml;
    exports ru.nsu.epov.lab3.tetris.C;
    opens ru.nsu.epov.lab3.tetris.C to javafx.fxml;
    exports ru.nsu.epov.lab3.tetris.M;
    opens ru.nsu.epov.lab3.tetris.M to javafx.fxml;
    exports ru.nsu.epov.lab3.tetris;
}
