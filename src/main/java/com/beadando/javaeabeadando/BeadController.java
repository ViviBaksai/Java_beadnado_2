package com.beadando.javaeabeadando;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.SMO;
import weka.classifiers.lazy.IBk;
import weka.classifiers.trees.J48;
import weka.classifiers.trees.RandomForest;
import weka.core.Utils;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.*;

public class BeadController implements Initializable {
    @FXML public TableView tv1;
    @FXML public GridPane gr1;
    @FXML public GridPane gr2;
    @FXML public GridPane gr3;
    @FXML public GridPane gr4;
    @FXML public GridPane gr5;
    @FXML public GridPane gr6;
    @FXML public GridPane gr7;
    @FXML public GridPane gr8;
    @FXML public GridPane gr9;
    @FXML public GridPane gr10;
    @FXML public GridPane gr11;
    @FXML public GridPane gr12;
    @FXML public GridPane gr13;
    @FXML public GridPane gr14;
    @FXML public GridPane gr15;
    @FXML public GridPane gr16;
    @FXML public GridPane gr17;
    @FXML public GridPane gr18;
    @FXML public TextField tf1;
    @FXML public TextField tf2;
    @FXML public TextField tf3;
    @FXML public TextField tf4;
    @FXML public TextField tf5;
    @FXML public TextField tf6;
    @FXML public TextField tf7;
    @FXML public TextField tf8;
    @FXML public TextField tf9;
    @FXML public TextField tf10;
    @FXML public TextField tf11;
    @FXML public TextField tf12;
    @FXML public TextField tf13;
    @FXML public TextField tf14;
    @FXML public TextField tf15;
    @FXML public TextField tf16;
    @FXML public TextField tf17;
    @FXML public TextField tf18;
    @FXML public TextField tf19;
    @FXML public TextField tf20;
    @FXML public TextField tf21;
    @FXML public TextField tf22;
    @FXML public TextField tf23;
    @FXML public TextArea ta1;
    @FXML public TextArea ta2;
    @FXML public TextArea ta3;
    @FXML public TextArea ta4;
    @FXML public TextArea ta5;
    @FXML public TextArea ta6;
    @FXML public TextArea ta7;
    @FXML public TextArea ta8;
    @FXML public TextArea ta9;
    @FXML public TextArea ta10;
    @FXML public TextArea ta11;
    @FXML public ComboBox cb1;
    @FXML public ComboBox cb2;
    @FXML public ComboBox cb3;
    @FXML public ComboBox cb4;
    @FXML public ComboBox cb5;



    @FXML public ToggleGroup group;
    @FXML public Button btnSzuro;
    @FXML public Label errorForSzures;
    @FXML public Label errorForsutizoHozzaadas;
    @FXML public Label msgForsutizoHozzaadas;
    @FXML public Label errorForsutizoModositas;
    @FXML public Label msgForsutizoModositas;
    @FXML public Label msgForsutiTorles;
    @FXML public Label errorForsutiTorles;
    @FXML public Label errorForsutiTorles2;
    @FXML public Label döntésiFaMsg;


    @FXML
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ElemekTörlése();
        cb5.getItems().addAll("Döntési fa", "Support-vector machine", "NaiveBayes", "K-legközelebbi szomszéd", "RandomForest");
        cb5.getSelectionModel().select("Döntési fa");
    }


    final String token = "cf80eff8acb5840b59b220e16e409ea4589bae9a86bc4a4cf4c806f8edfe23b8";
    HttpsURLConnection httpsURLConnection;
    protected void ElemekTörlése() {
        gr1.setVisible(false);
        gr1.setManaged(false);
        gr2.setVisible(false);
        gr2.setManaged(false);
        gr3.setVisible(false);
        gr3.setManaged(false);
        gr4.setVisible(false);
        gr4.setManaged(false);
        gr5.setVisible(false);
        gr5.setManaged(false);
        gr6.setVisible(false);
        gr6.setManaged(false);
        gr7.setVisible(false);
        gr7.setManaged(false);
        gr8.setVisible(false);
        gr8.setManaged(false);
        gr9.setVisible(false);
        gr9.setManaged(false);
        gr10.setVisible(false);
        gr10.setManaged(false);
        gr11.setVisible(false);
        gr11.setManaged(false);
        gr12.setVisible(false);
        gr12.setManaged(false);
        gr13.setVisible(false);
        gr13.setManaged(false);
        gr14.setVisible(false);
        gr14.setManaged(false);
        gr15.setVisible(false);
        gr15.setManaged(false);
        gr16.setVisible(false);
        gr16.setManaged(false);
        gr17.setVisible(false);
        gr17.setManaged(false);
        gr18.setVisible(false);
        gr18.setManaged(false);
        tv1.setVisible(false);
        tv1.setManaged(false);
        errorForSzures.setVisible(false);
        errorForSzures.setManaged(false);
        errorForsutizoHozzaadas.setVisible(false);
        errorForsutizoHozzaadas.setManaged(false);
        msgForsutizoHozzaadas.setVisible(false);
        msgForsutizoHozzaadas.setManaged(false);
        errorForsutizoModositas.setVisible(false);
        errorForsutizoModositas.setManaged(false);
        msgForsutizoModositas.setVisible(false);
        msgForsutizoModositas.setManaged(false);
        msgForsutiTorles.setVisible(false);
        msgForsutiTorles.setManaged(false);
        errorForsutiTorles.setVisible(false);
        errorForsutiTorles.setManaged(false);
        errorForsutiTorles2.setVisible(false);
        errorForsutiTorles2.setManaged(false);
    }

    protected void clearControlUIData(TextField... tfList) {
        for(TextField tf : tfList) tf.setText("");
    }
    protected void setTimerForLabel(Label label) {
        Timer tm = new Timer();
        tm.schedule(new TimerTask(){
            @Override
            public void run() {
                Platform.runLater(() -> {
                    label.setText("");
                });
            }
        },3000);
    }

    protected void segéd1(){
        httpsURLConnection.setRequestProperty("Content-Type", "application/json");
        httpsURLConnection.setRequestProperty("Authorization", "Bearer " + token);
        httpsURLConnection.setUseCaches(false);
        httpsURLConnection.setDoOutput(true);
    }
    protected void segéd2(String params) throws IOException {
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(httpsURLConnection.getOutputStream(), "UTF-8"));
        wr.write(params);
        wr.close();
        httpsURLConnection.connect();
    }
    protected String segéd3(int code) throws IOException {
        int statusCode = httpsURLConnection.getResponseCode();
        System.out.println("statusCode: "+statusCode);
        if (statusCode == code) {
            BufferedReader in = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
            StringBuilder jsonResponseData = new StringBuilder();
            String readLine = null;
            while ((readLine = in.readLine()) != null)
                jsonResponseData.append(readLine);
            in.close();
            httpsURLConnection.disconnect();
            return jsonResponseData.toString();
        } else {
            httpsURLConnection.disconnect();
            return "Hiba!!!";
        }
    }
    
    @FXML
    protected void rest1MenuCreateClick() {
        ElemekTörlése();
        clearControlUIData(tf7, tf8, tf9, tf10);
        ta2.setText("");
        gr7.setVisible(true);
        gr7.setManaged(true);
    }
    @FXML
    protected void btnRest1MenuCreateClick() throws IOException {
        ta2.setText("");
        URL postUrl = new URL("https://gorest.co.in/public/v1/users");
        httpsURLConnection = (HttpsURLConnection) postUrl.openConnection();
        httpsURLConnection.setRequestMethod("POST");
        segéd1();
        String name = tf7.getText();
        String gender = tf8.getText();
        String email = tf9.getText();
        String status = tf10.getText();
        String params = "{\"name\":\""+name+"\", \"gender\":\""+gender+"\", \"email\":\""+email+"\", \"status\":\""+status+"\"}";
        segéd2(params);
        String response = segéd3(HttpsURLConnection.HTTP_CREATED);
        if(!response.equals("Hiba!!!")) {
            ta2.setText(response);
        } else {
            ta2.setText("Az új user létrehozása sajnos nem sikerült.");
        }
    }
    @FXML
    protected void rest1MenuReadClick() {
        ElemekTörlése();
        clearControlUIData(tf6);
        ta1.setText("");
        gr6.setVisible(true);
        gr6.setManaged(true);
    }
    @FXML
    protected void btnRest1MenuReadClick() throws IOException {
        ta1.setText("");
        String url = "https://gorest.co.in/public/v1/users";
        String ID = tf6.getText();
        if(ID != null)
            url = url + "/" + ID;
        URL usersUrl = new URL(url);
        httpsURLConnection = (HttpsURLConnection) usersUrl.openConnection();
        httpsURLConnection.setRequestMethod("GET");
        if(ID != null)
            httpsURLConnection.setRequestProperty("Authorization", "Bearer " + token);
        String response = segéd3(HttpsURLConnection.HTTP_OK);
        if(!response.equals("Hiba!!!")) {
            ta1.setText(response);
        } else {
            ta1.setText("Nincs user ilyen ID-val az adatbázisban.");
        }
    }
    @FXML
    protected void rest1MenuUpdateClick() {
        ElemekTörlése();
        clearControlUIData(tf11, tf12, tf13, tf14, tf15);
        ta3.setText("");
        gr8.setVisible(true);
        gr8.setManaged(true);
    }
    @FXML
    protected void btnRest1MenuUpdateClick() throws IOException {
        ta3.setText("");
        String ID = tf11.getText();
        String name = tf12.getText();
        String gender = tf13.getText();
        String email = tf14.getText();
        String status = tf15.getText();
        String url = "https://gorest.co.in/public/v1/users"+"/"+ID;
        URL postUrl = new URL(url);
        httpsURLConnection = (HttpsURLConnection) postUrl.openConnection();
        httpsURLConnection.setRequestMethod("PUT");
        segéd1();
        String params = "{\"name\":\""+name+"\", \"gender\":\""+gender+"\", \"email\":\""+email+"\", \"status\":\""+status+"\"}";
        segéd2(params);
        String response = segéd3(HttpsURLConnection.HTTP_OK);
        if(!response.equals("Hiba!!!")) {
            ta3.setText(response);
        } else {
            ta3.setText("A user módosítása sajnos nem sikerült.");
        }
    }
    @FXML
    protected void rest1MenuDeleteClick() {
        ElemekTörlése();
        clearControlUIData(tf16);
        ta4.setText("");
        gr9.setVisible(true);
        gr9.setManaged(true);
    }
    @FXML
    protected void btnRest1MenuDeleteClick() throws IOException {
        ta4.setText("");
        String ID = tf16.getText();
        String url = "https://gorest.co.in/public/v1/users"+"/"+ID;
        URL postUrl = new URL(url);
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) postUrl.openConnection();
        httpsURLConnection.setRequestMethod("DELETE");
        segéd1();
        String response = segéd3(HttpsURLConnection.HTTP_NO_CONTENT);
        if(!response.equals("Hiba!!!")) {
            ta4.setText("Sikeresen törölte a user-t!");
        } else {
            ta4.setText("A user törlése sajnos nem sikerült.");
        }
    }

    @FXML
    protected void rest2MenuCreateClick() {
        ElemekTörlése();
        clearControlUIData(tf17, tf18);
        ta5.setText("");
        gr10.setVisible(true);
        gr10.setManaged(true);
    }
    @FXML
    protected void btnRest2MenuCreateClick() throws IOException {
        ta5.setText("");
        String nev = tf17.getText();
        String osztaly = tf18.getText();

    }
    @FXML
    protected void rest2MenuReadClick() {
        ElemekTörlése();
        clearControlUIData(tf19);
        ta6.setText("");
        gr11.setVisible(true);
        gr11.setManaged(true);
    }
    @FXML
    protected void btnRest2MenuReadClick() throws IOException {
        ta6.setText("");
    }

    @FXML
    protected void rest2MenuUpdateClick() {
        ElemekTörlése();
        clearControlUIData(tf20, tf21, tf22);
        ta7.setText("");
        gr12.setVisible(true);
        gr12.setManaged(true);
    }
    @FXML
    protected void btnRest2MenuUpdateClick() throws IOException {
        ta7.setText("");
        String ID = tf20.getText();
        String nev = tf21.getText();
        String osztaly = tf22.getText();

    }
    @FXML
    protected void rest2MenuDeleteClick() {
        ElemekTörlése();
        clearControlUIData(tf23);
        ta8.setText("");
        gr13.setVisible(true);
        gr13.setManaged(true);
    }
    @FXML
    protected void btnRest2MenuDeleteClick() throws IOException {
        ta8.setText("");
        String ID = tf23.getText();

        ta8.setText("A süti törlése sajnos nem sikerült.");

    }


    @FXML
    protected void soapKliensMenuLetöltés() {
        ElemekTörlése();
        gr17.setVisible(true);
        gr17.setManaged(true);
    }
    @FXML
    protected void btnsoapKliensMenuLetöltés() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("soap.fxml"));
        Scene scene = new Scene(root, 575, 292);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }





    @FXML
    protected void soapKliensMenuLetöltés2() {


    }
    @FXML
    protected void soapKliensMenuGrafikon() {
        ElemekTörlése();
        gr18.setVisible(true);
        gr18.setManaged(true);

    }
    @FXML
    protected void btnsoapKliensMenuGrafikon() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("graf.fxml"));
        Scene scene = new Scene(root, 600, 400);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void adatbányászatMenuDöntésiFa() {
        ElemekTörlése();
        döntésiFaMsg.setText("");
        gr14.setVisible(true);
        gr14.setManaged(true);
    }
    @FXML
    protected void btnAdatbányászatMenuDöntésiFa() {
        String fájlNév = "data/vote.arff";
        int classIndex = 16;
        new GépiTanulás1(fájlNév, classIndex);
        döntésiFaMsg.setText("Elvileg sikerült a művelet!");
        setTimerForLabel(döntésiFaMsg);
    }
    @FXML
    protected void adatbányászatMenuTöbbAlgoritmus() {
        ElemekTörlése();
        gr15.setVisible(true);
        gr15.setManaged(true);
    }
    @FXML
    protected void btnAdatbányászatMenuTöbbAlgoritmus() throws Exception {
        String fájlNév = "data/vote.arff";
        int classIndex = 16;
        PrintWriter kiir = new PrintWriter("Gépi tanulás.txt");
        String bestCorrectlyCIClassName = "";
        List<String[]> list = new ArrayList<String[]>();
        String[] arr1 = new GépiTanulás2CrossValidation(fájlNév, classIndex, new J48(), kiir, "Döntési fa").getImportantData();
        String[] arr2 = new GépiTanulás2CrossValidation(fájlNév, classIndex, new SMO(), kiir, "Support-vector machine").getImportantData();
        String[] arr3 = new GépiTanulás2CrossValidation(fájlNév, classIndex, new NaiveBayes(), kiir, "NaiveBayes").getImportantData();
        IBk classifier = new IBk();
        classifier.setOptions(Utils.splitOptions("-K 10"));
        String[]arr4 = new GépiTanulás2CrossValidation(fájlNév, classIndex, classifier, kiir, "K-legközelebbi szomszéd").getImportantData();
        String[] arr5 = new GépiTanulás2CrossValidation(fájlNév, classIndex, new RandomForest(), kiir, "RandomForest").getImportantData();
        kiir.close();
        double bestCorrClassIns = 0.0;
        list.add(arr1);
        list.add(arr2);
        list.add(arr3);
        list.add(arr4);
        list.add(arr5);
        for(int i = 0; i < list.size(); i++) {
            double value = Double.parseDouble(list.get(i)[0]);
            if(value > bestCorrClassIns) {
                bestCorrClassIns = value;
                bestCorrectlyCIClassName = list.get(i)[1];
            }
        }
        ta9.setText(bestCorrectlyCIClassName);
        ta9.setFont(new Font(36.0));
    }
    @FXML
    protected void adatbányászatMenuTöbbAlgoritmus2() {
        ElemekTörlése();
        gr16.setVisible(true);
        gr16.setManaged(true);
        ta10.setText("");
    }
    @FXML
    protected void btnAdatbányászatMenuTöbbAlgoritmus2() throws Exception {
        String fájlNév = "data/vote.arff";
        int classIndex = 16;
        ta10.setText("");
        List<String> data = new ArrayList<String>();
        String algoritmus = cb5.getValue() + "";
        switch(algoritmus) {
            case "Döntési fa":
                data = new GépiTanulás3CrossValidation(fájlNév, classIndex, new J48()).getData();
                break;
            case "Support-vector machine":
                data = new GépiTanulás3CrossValidation(fájlNév, classIndex, new SMO()).getData();
                break;
            case "NaiveBayes":
                data = new GépiTanulás3CrossValidation(fájlNév, classIndex, new NaiveBayes()).getData();
                break;
            case "K-legközelebbi szomszéd":
                IBk classifier = new IBk();
                classifier.setOptions(Utils.splitOptions("-K 10"));
                data = new GépiTanulás3CrossValidation(fájlNév, classIndex, classifier).getData();
                break;
            case "RandomForest":
                data = new GépiTanulás3CrossValidation(fájlNév, classIndex, new RandomForest()).getData();
                break;
        }
        setTextArea10(data);
    }
    protected void setTextArea10(List<String> data) {
        String text = "";
        for(String d : data) text += d;
        ta10.setText(text);
        ta10.setFont(new Font(25.0));
    }
    @FXML
    protected void egyébMenuPárhuzamos() {
        ElemekTörlése();
        gr5.setVisible(true);
        gr5.setManaged(true);
    }

    @FXML
    protected void btnPárhuzamosStart() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("parallel.fxml"));
        Scene scene = new Scene(root, 600, 400);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void egyébMenuStream() {

    }

    public void vissza_click(ActionEvent actionEvent) {
    }
    
}