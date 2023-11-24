module com.example.beadando_2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.beadando_2 to javafx.fxml;
    exports com.example.beadando_2;
}