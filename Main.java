package application;
	
import java.util.ArrayList;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;


public class Main extends Application {
	
		
	public void start(Stage primaryStage) {
		
		CategoryAxis yAxis = new CategoryAxis();
        yAxis.setLabel("Palabras");

        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("Frecuencia");

       
		BarChart<Number, String> chart = new BarChart<Number, String>(xAxis, yAxis);
        chart.setTitle("Ánalisis de comentarios Amazon");
        // agregamos datos 
        chart.setData(obtenerDatos());
        
        // Paneles
        StackPane root = new StackPane();
        root.getChildren().add(chart);
        
        // Tamaño del Frame
        Scene scene = new Scene(root, 640, 427);

        primaryStage.setTitle("Gráfica.exe");
        primaryStage.setScene(scene);
        primaryStage.show();
        
	}
	@SuppressWarnings("unchecked")
	public static ObservableList<XYChart.Series<Number, String>> obtenerDatos() {
		
        XYChart.Series<Number, String> frecuenciasPalabras = new XYChart.Series<>();
        frecuenciasPalabras.setName("Cantidad Palabras");
        
        Analisis obj1 = new Analisis();
        ArrayList<String> list = obj1.readFile("C:\\Users\\JuanC\\Downloads\\train.csv");
        ArrayList<String> arrayClean = obj1.removeSpecialChars(list);
        ArrayList<String> wordList = obj1.readWordFile("C:\\Users\\JuanC\\Downloads\\palabras.txt");
        ArrayList<Integer> countList = obj1.countCoincidences(arrayClean, wordList);
        for(int i=0;i<wordList.size();i++)
        {
        	frecuenciasPalabras.getData().add(new XYChart.Data<>(countList.get(i),wordList.get(i)));
        }
        ObservableList<XYChart.Series<Number, String>> data = FXCollections.observableArrayList();
        data.addAll(frecuenciasPalabras);

        return data;
    }
	

	
	public static void main(String[] args) {
		launch(args);
	}
}
