package se233.chapter5_2;

import javafx.geometry.Point2D;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se233.chapter5_2.model.Direction;
import se233.chapter5_2.model.Food;
import se233.chapter5_2.model.Snake;
import se233.chapter5_2.model.SpecialFood;

import static org.junit.jupiter.api.Assertions.*;

public class SnakeTest {
    private Snake snake;

    @BeforeEach
    public void setup(){
        snake = new Snake(new Point2D(0,0));
    }
    @Test
    public void initialPosition_shouldBe_atOrigin(){
        assertEquals(snake.getHead(), new Point2D(0,0));
    }
    @Test
    public void move_afterInitialized_headShouldBeInDownwardDirection(){
        snake.setDirection(Direction.DOWN);
        snake.move();
        assertEquals(snake.getHead(), new Point2D(0,1));
    }
    @Test
    public void grow_sholdIncressLengthByOne(){
        snake.grow();
        assertEquals(snake.getLength(), 2);
    }
    @Test
    public void grow_shouldIncreaseLengthToBody(){
        Point2D cur_head = snake.getHead();
        snake.move();
        snake.grow();
        assertTrue(snake.getBody().contains(cur_head));
    }
    @Test
    public void collided_withSnake_shouldBeDetected(){
        Food food = new Food(new Point2D(0,0));
        assertTrue(snake.collided(food));
    }
    @Test
    public void checkDead_ifHitGameBorder_snakeWillDie(){
        snake = new Snake(new Point2D(30,30));
        snake.setDirection(Direction.RIGHT);
        snake.move();
        assertTrue(snake.checkDead());
    }
    @Test
    public void checkDead_ifHitItself_snakeWillDie(){
        snake = new Snake(new Point2D(0,0));
        snake.setDirection(Direction.DOWN);
        snake.move();
        snake.grow();
        snake.setDirection(Direction.LEFT);
        snake.move();
        snake.grow();
        snake.setDirection(Direction.UP);
        snake.move();
        snake.grow();
        snake.setDirection(Direction.RIGHT);
        snake.move();
        snake.grow();
        assertTrue(snake.checkDead());
    }
    @Test
    public void checkScore_SnakeCollidedFood_scoreIncrease(){
        Food food  = new Food(new Point2D(0,0));
        snake.collided(food);
        assertEquals(1, snake.getScore());
    }
    @Test
    public void checkScore_SnakeCollidedSpecialFood_scoreIncreaseBy2(){
        SpecialFood specialFood = new SpecialFood(new Point2D(0,0));
        snake.collided(specialFood);
        assertEquals(2, snake.getScore());
    }
}
