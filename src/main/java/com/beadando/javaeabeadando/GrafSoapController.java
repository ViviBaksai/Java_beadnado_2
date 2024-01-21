package com.beadando.javaeabeadando;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class GrafSoapController {

    @FXML
    private LineChart<Number, Number> lineChart;

    @FXML
    protected void onGrafButtonClick() {
        // Törölje az esetleges korábbi adatokat
        lineChart.getData().clear();

        // USD árfolyamok
        double[] usdValues = {362.43, 361.4, 362.9, 360.07, 352.98, 351.15, 350.58, 347.2, 346.82};

        // Készítse el az XYChart.Series-t az adatokkal
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        for (int i = 1; i < usdValues.length; i++) {
            series.getData().add(new XYChart.Data<>(i + 1, usdValues[i]));
        }

        // Adja hozzá a Series-t a grafikonhoz
        lineChart.getData().add(series);
    }
}
