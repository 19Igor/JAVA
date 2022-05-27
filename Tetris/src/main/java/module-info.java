module ru.nsu.epov.lab3.tetris {
    requires javafx.controls;
    requires javafx.fxml;

    opens ru.nsu.epov.lab3.tetris to javafx.fxml;
    exports ru.nsu.epov.lab3.tetris;
}
