module com.beadando.javaeabeadando {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires weka.stable;
    requires v20;
    requires gson;
    requires httpcore;
    requires httpclient;

    opens com.beadando.javaeabeadando to javafx.fxml;
    exports com.beadando.javaeabeadando;
}