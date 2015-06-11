package game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import libraries.GameObject;

class Player extends GameObject {

    private int upButton;
    private int downButton;
    private boolean leftPressed = false;

    public Player(float x, float y, Sprite img, int upButton, int downButton) {
        super(x, y, img);
        this.upButton = upButton;
        this.downButton = downButton;
    }

    @Override
    public void move() {
        if (Gdx.input.isKeyPressed(upButton)) {
            this.setY(this.getY() + 10);
        }
        if (Gdx.input.isKeyPressed(downButton)) {
            this.setY(this.getY() - 10);
        }
    }

//    public boolean isBallTouching() {
//        
//    }
    public float distanceFromCenter(Ball ball) {
        return ball.getY() - this.getY() - PongScene.PLAYER_HEIGHT / 2;
    }

}
