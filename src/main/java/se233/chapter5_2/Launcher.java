package se233.chapter5_2;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.stage.Stage;
import se233.chapter5_2.controller.GameLoop;
import se233.chapter5_2.model.Food;
import se233.chapter5_2.model.Snake;
import se233.chapter5_2.model.SpecialFood;
import se233.chapter5_2.view.GameStage;

public class Launcher extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        GameStage gameStage = new GameStage();
        Snake snake = new Snake(new Point2D(gameStage.WIDTH / 2, gameStage.HEIGHT / 2));
        Food food = new Food();
        SpecialFood specialFood = new SpecialFood();

        GameLoop gameLoop = new GameLoop(gameStage, snake, food , specialFood);

        Scene scene = new Scene(
                gameStage,
                gameStage.WIDTH * gameStage.TILE_SIZE,
                gameStage.HEIGHT * gameStage.TILE_SIZE
        );

        // Set key event listeners for controlling the snake
        scene.setOnKeyPressed(event -> gameStage.setKey(event.getCode()));
        scene.setOnKeyReleased(event -> gameStage.setKey(null));

        stage.setTitle("Snake Game");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        // Start the game loop in a separate thread
        (new Thread(gameLoop)).start();
    }
}
