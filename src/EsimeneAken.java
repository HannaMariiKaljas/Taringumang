import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
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
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EsimeneAken extends Application {
    public String mängija1;
    public String mängija2;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Täringumäng");
        GridPane gridPane = tükid();
        Scene scene = new Scene(gridPane, 750, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane tükid() {
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
    return gridPane;
    }

    private GridPane mänguAken(){
        GridPane gridpane = new GridPane();
        gridpane.setStyle("-fx-background-color: #afeeee");
        gridpane.setPadding(new Insets(10,10,10,10));
        gridpane.setVgap(40);
        gridpane.setHgap(40);

        TableView tableView = new TableView();

        List<String> stringValues = Arrays.asList("Ühed", "Kahed", "Kolmed", "Neljad", "Viied", "Kuued", "Paar", "Kolmik", "Nelik", "Kaks+Kaks", "Maja", "Väike rida", "Suur rida",
                "Summa", "Ühe jospel", "Kahe jospel","Kolme jospel", "Nelja jospel", "Viie jospel", "Kuue jospel");

        TableColumn<Integer, String> reeglid = new TableColumn<>("Reegel");
        TableColumn<Integer, String> m1 = new TableColumn<>(mängija1);
        TableColumn<Integer, String> m2 = new TableColumn<>(mängija2);

        for (int i = 0; i < stringValues.size(); i++) {
            tableView.getItems().add(i);
        }
        reeglid.setCellValueFactory(cellData -> {
            Integer rowIndex = cellData.getValue();
            return new ReadOnlyStringWrapper(stringValues.get(rowIndex));
        });

        TableColumn m1esimene = new TableColumn("Esimene");
        TableColumn m1teine = new TableColumn("Teine");
        TableColumn m2esimene = new TableColumn("Esimene");
        TableColumn m2teine = new TableColumn("Teine");
        m1.getColumns().addAll(m1esimene,m1teine);
        m2.getColumns().addAll(m2esimene,m2teine);

        tableView.getColumns().addAll(reeglid,m1,m2);

        Button veeretaNupp = new Button("VEERETA");
        veeretaNupp.setPrefHeight(40);
        veeretaNupp.setDefaultButton(true);
        veeretaNupp.setPrefWidth(100);
        gridpane.add(veeretaNupp, 0, 2, 2, 1);
        GridPane.setHalignment(veeretaNupp, HPos.CENTER);
        GridPane.setMargin(veeretaNupp, new Insets(20, 0,20,0));

        Button lahkuNupp = new Button("Lahku mängust");
        lahkuNupp.setPrefHeight(30);
        lahkuNupp.setDefaultButton(true);
        lahkuNupp.setPrefWidth(100);
        gridpane.add(lahkuNupp, 0, 2, 2, 1);
        GridPane.setHalignment(lahkuNupp, HPos.RIGHT);

        veeretaNupp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ImageView üks = täring();
                ImageView kaks = täring();
                ImageView kolm = täring();
                ImageView neli = täring();
                ImageView viis = täring();
                ImageView kuus = täring();
                ImageView seitse = täring();
                GridPane.setConstraints(üks,1,0,2,6);
                GridPane.setConstraints(kaks,2,0,3,4);
                GridPane.setConstraints(kolm,4,0,5,5);
                GridPane.setConstraints(neli,3,0,3,2);
                GridPane.setConstraints(viis,2,0,3,3);
                GridPane.setConstraints(kuus,2,0,7,7);
                GridPane.setConstraints(seitse,3,0,3,5);

                gridpane.getChildren().addAll(üks,kaks,kolm,neli, viis, kuus, seitse);
            }
        });

        lahkuNupp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GridPane juur = tulemusteAken();
                Stage stage=new Stage();
                stage.setTitle("Täringumäng");
                stage.setScene(new Scene(juur, 600,600));
                stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
            }
        });

        gridpane.getChildren().addAll(tableView);
        return gridpane;
    }

    private ImageView täring(){
        Random ran=new Random();
        int vise = ran.nextInt(6)+1;
        ImageView täring;
        switch (vise){
            case 1: File täring1 = new File("dice1.png");
                täring = new ImageView(new Image(täring1.toURI().toString()));
                break;
            case 2: File täring2 = new File("dice2.png");
                täring = new ImageView(new Image(täring2.toURI().toString()));
                break;
            case 3: File täring3 = new File("dice3.png");
                täring = new ImageView(new Image(täring3.toURI().toString()));
                break;
            case 4: File täring4 = new File("dice4.png");
                täring = new ImageView(new Image(täring4.toURI().toString()));
                break;
            case 5: File täring5 = new File("dice5.png");
                täring = new ImageView(new Image(täring5.toURI().toString()));
                break;
            case 6: File täring6 = new File("dice6.png");
                täring = new ImageView(new Image(täring6.toURI().toString()));
                break;
                default: File täring7 = new File("dice6.png");
                    täring = new ImageView(new Image(täring7.toURI().toString()));
        }
        return täring;
    }
    private GridPane tulemusteAken(){
        GridPane gridpane = new GridPane();
        gridpane.setStyle("-fx-background-color: #afeeee");
        gridpane.setPadding(new Insets(10,10,10,10));
        gridpane.setVgap(80);
        gridpane.setHgap(50);

        Label pealkiri = new Label("Tulemused:");
        pealkiri.setFont(Font.font("Cooper Black", FontWeight.BOLD, 40));
        pealkiri.setTextFill(Color.TEAL);
        gridpane.add(pealkiri, 0,0,2,1);
        GridPane.setHalignment(pealkiri, HPos.CENTER);
        GridPane.setMargin(pealkiri, new Insets(20, 0,20,0));

        Button uusMäng = new Button("Uus mäng");
        uusMäng.setPrefHeight(30);
        uusMäng.setDefaultButton(true);
        uusMäng.setPrefWidth(100);
        gridpane.add(uusMäng, 3, 5, 2, 1);
        GridPane.setHalignment(uusMäng, HPos.RIGHT);
        uusMäng.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GridPane juur = tükid();
                Stage stage=new Stage();
                stage.setTitle("Täringumäng");
                stage.setScene(new Scene(juur, 600,600));
                stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
            }
        });

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