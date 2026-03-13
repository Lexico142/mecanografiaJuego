module org.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens org.example.demo to javafx.fxml;
    exports org.example.demo;
    exports org.example.demo.modelo;
    opens org.example.demo.modelo to javafx.fxml;
    exports org.example.demo.controlador;
    opens org.example.demo.controlador to javafx.fxml;
}