package test;

import java.awt.Rectangle;

public class Food {
    private int x;
    private int y;

    public Food(Snake player) {
        this.random_spawn(player);
    }

    public void random_spawn(Snake player) {


        boolean onSnake = false;

        while (!onSnake) {
            x = (int) (Math.random() * Game.width);
            y = (int) (Math.random() * Game.height);
            for (Rectangle r : player.getBody()) {
                if (r.x == x && r.y == y) {
                    onSnake = true;
                }
            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

