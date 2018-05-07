import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;

public class EsimeneAken extends Application {
    public String mängija1;
    public String mängija2;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Täringumäng");
        GridPane gridPane = TeeGrid();
        tükid(gridPane);
        Scene scene = new Scene(gridPane, 750, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private GridPane TeeGrid() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(100, 100, 100, 10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        ColumnConstraints columnOneConstraints = new ColumnConstraints(150, 150, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(300,300, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }

    private void tükid(GridPane gridPane) {
        Label pealkiri = new Label("TÄRINGUMÄNG");
        pealkiri.setFont(Font.font("Cooper Black", FontWeight.BOLD, 40));
        pealkiri.setTextFill(Color.TEAL);
        gridPane.setStyle("-fx-background-color: #afeeee");
        gridPane.add(pealkiri, 0,0,2,1);
        GridPane.setHalignment(pealkiri, HPos.CENTER);
        GridPane.setMargin(pealkiri, new Insets(20, 0,20,0));

        Label nimi1 = new Label("Esimene mängija: ");
        nimi1.setFont(Font.font("Cooper Black", FontWeight.BOLD, 15));
        nimi1.setTextFill(Color.TEAL);
        gridPane.add(nimi1, 0,1);

        TextField nimiesimene = new TextField();
        nimiesimene.setPrefHeight(40);
        gridPane.add(nimiesimene, 1,1);

        Label nimi2 = new Label("Teine mängija: ");
        nimi2.setFont(Font.font("Cooper Black", FontWeight.BOLD, 15));
        nimi2.setTextFill(Color.TEAL);
        gridPane.add(nimi2, 0, 2);

        TextField nimiteine = new TextField();
        nimiteine.setPrefHeight(40);
        gridPane.add(nimiteine, 1, 2);

        Button mangimaNupp = new Button("MÄNGIMA");
        mangimaNupp.setPrefHeight(40);
        mangimaNupp.setDefaultButton(true);
        mangimaNupp.setPrefWidth(100);
        gridPane.add(mangimaNupp, 0, 4, 2, 1);
        GridPane.setHalignment(mangimaNupp, HPos.CENTER);
        GridPane.setMargin(mangimaNupp, new Insets(20, 0,20,0));

        mangimaNupp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(nimiesimene.getText().isEmpty()) {
                    Veateade(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Viga!", "Sisesta esimese mängija nimi");
                    return;
                }else{
                    mängija1 = nimiesimene.getText();
                }
                if(nimiteine.getText().isEmpty()) {
                    Veateade(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Viga!", "Sisesta teise mängija nimi");
                    return;
                }else{
                    mängija2 = nimiteine.getText();
                }
                GridPane juur = mänguAken();
                Stage stage=new Stage();
                stage.setTitle("Täringumäng");
                stage.setScene(new Scene(juur, 600,600));
                stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
            }
        });
    }

    private GridPane mänguAken(){
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(10,10,10,10));
        gridpane.setVgap(50);
        gridpane.setHgap(50);

        TableView tableView = new TableView();

        TableColumn reegel = new TableColumn("Reegel");
        TableColumn m1 = new TableColumn(mängija1);
        TableColumn m2 = new TableColumn(mängija2);

        TableColumn m1esimene = new TableColumn("Esimene");
        TableColumn m1teine = new TableColumn("Teine");
        TableColumn m2esimene = new TableColumn("Esimene");
        TableColumn m2teine = new TableColumn("Teine");
        m1.getColumns().addAll(m1esimene,m1teine);
        m2.getColumns().addAll(m2esimene,m2teine);

        File file = new File("dice1.png"); // peab välja mõtlema, kuidas ära siduda pildid ja täringute väärtused ja panna need gridpane'i
        ImageView üks = new ImageView(new Image(file.toURI().toString()));

        GridPane.setConstraints(üks,1,0);

        tableView.getColumns().addAll(reegel,m1,m2);


        gridpane.getChildren().addAll(tableView,üks);

        return gridpane;
    }
    private void Veateade(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}