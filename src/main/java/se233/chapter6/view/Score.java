package se233.chapter6.view;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Score extends Pane {
    Text point;
    public Score(int x,int y) {
        point = new Text("0");
        setLayoutX(x);
        setLayoutY(y);
        point.setFont(Font.font("Verdana", FontWeight.BOLD,30));
        point.setFill(Color.web("#000"));
        getChildren().add(point);
    }

    public void setScore(int score) {
        this.point.setText(Integer.toString(score));
    }
}
