package se233.chapter5_2.model;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class SpecialFood extends Food{
    private static final int POINTS = 2;
    private static final Color COLOR = Color.BLACK;

    public SpecialFood(Point2D position) {
        super(position);
    }

    public SpecialFood() {
        super();
    }
}
