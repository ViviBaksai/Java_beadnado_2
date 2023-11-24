package com.example.beadando_2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.io.IOException;

public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Beadando_2");

        MenuBar menuBar = new MenuBar();

        Menu crudMenu = new Menu("CRUD");

        MenuItem readItem = new MenuItem("Olvas");
        crudMenu.getItems().add(readItem);
        readItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        Scene scene = null;
        primaryStage.setScene(scene);
        primaryStage.show();

        MenuItem read2Item = new MenuItem("Olvas2");
        crudMenu.getItems().add(read2Item);

        MenuItem writeItem = new MenuItem("Ír");
        crudMenu.getItems().add(writeItem);

        MenuItem editItem = new MenuItem("Módosit");
        crudMenu.getItems().add(editItem);

        MenuItem deleteItem = new MenuItem("Töröl");
        crudMenu.getItems().add(deleteItem);

        Menu rest1Menu = new Menu("Rest1");

        MenuItem rest1readItem = new MenuItem("Olvas");
        rest1Menu.getItems().add(rest1readItem);

        MenuItem rest1read2Item = new MenuItem("Olvas2");
        rest1Menu.getItems().add(rest1read2Item);

        MenuItem rest1writeItem = new MenuItem("Ír");
        rest1Menu.getItems().add(rest1writeItem);

        MenuItem rest1editItem = new MenuItem("Módosit");
        rest1Menu.getItems().add(rest1editItem);

        MenuItem rest1deleteItem = new MenuItem("Töröl");
        rest1Menu.getItems().add(rest1deleteItem);

        Menu soapkliensMenu = new Menu("SoapKliens");

        MenuItem downloadItem = new MenuItem("Letöltés");
        soapkliensMenu.getItems().add(downloadItem);

        MenuItem download2Item = new MenuItem("Letöltés2");
        soapkliensMenu.getItems().add(download2Item);

        MenuItem graficsItem = new MenuItem("Grafikon");
        soapkliensMenu.getItems().add(graficsItem);

        Menu dataminigMenu = new Menu("Adatbányászat");

        MenuItem decesiontreeItem = new MenuItem("Döntési fa");
        dataminigMenu.getItems().add(decesiontreeItem);

        MenuItem algorythmicsItem = new MenuItem("Több algoritmus");
        dataminigMenu.getItems().add(algorythmicsItem);

        Menu moreMenu = new Menu("Egyéb");

        MenuItem paralelItem = new MenuItem("Párhuzamos");
        moreMenu.getItems().add(paralelItem);

        MenuItem streamItem = new MenuItem("Stream");
        moreMenu.getItems().add(streamItem);

        // Add the menus to the menu bar
        menuBar.getMenus().addAll(crudMenu, rest1Menu, soapkliensMenu, dataminigMenu, moreMenu);

        // Create the main layout
        VBox layout = new VBox(menuBar);

        // Create the scene
        scene = new Scene(layout, 400, 300);

        // Set the scene
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
    }

}

