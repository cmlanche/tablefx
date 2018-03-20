package sample;

import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.Glow;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StageMenu extends Stage {

    private Stage stage;

    private Text quit = new Text("quit");
    private Text cancel = new Text("cancel");

    public StageMenu() {
        minWidthProperty().bind(Bindings.max(quit.wrappingWidthProperty(), cancel.wrappingWidthProperty()));
//        minHeightProperty().bind(quit.prefHeightProperty().add(cancel.prefHeightProperty()));
//        setHeight(height);

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vBox);
//        scene.setFill(Color.TRANSPARENT);

        vBox.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
        this.setScene(scene);

        this.initStyle(StageStyle.TRANSPARENT);

//        double fontSize = Util.getFontSize(getHeight() * 20);
        double fontSize = 200;
        Font titleFont = Font.font("Arial Black", FontWeight.BOLD, fontSize);
        Glow titleGlow = new Glow(70.0);
        Stop[] stops = new Stop[]{new Stop(0, Color.WHITE),
                new Stop(0.55, Color.DARKGRAY),
                new Stop(0.56, Color.DIMGRAY),
                new Stop(1.0, Color.WHITE)
        };

        LinearGradient gradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, stops);

        Font titleFont1 = Font.font(titleFont.getFamily(), FontWeight.BOLD, fontSize / 2);

        Font hintFont = Font.font("Arial", fontSize / 8);

        quit.setFont(titleFont);
        quit.setEffect(titleGlow);
        cancel.setFont(titleFont);
        cancel.setEffect(titleGlow);

//        cancel.setOnMouseClicked(value ->stagge.setPaused(false));

        vBox.getChildren().addAll(quit, cancel);
    }

    public void display(Stage stage) {
        this.stage = stage;
//        this.setOnCloseRequest(value ->stage.setPaused(false));
        this.setAlwaysOnTop(true);
//        this.initStyle(StageStyle.TRANSPARENT);
        this.show();
    }

}