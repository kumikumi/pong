/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import libraries.GameObject;

public class Ball extends GameObject {

    private float speedX;
    private float speedY;

    public Ball(float x, float y, Sprite img) {
        super(x, y, img);
        this.reset();
    }

    public void reset() {
        this.setX(MyGame.SCREEN_WIDTH / 2);
        this.setY(MyGame.SCREEN_HEIGHT / 2);
        this.speedX = 5;
        this.speedY = 0;
    }

    @Override
    public void move() {
        this.setX(this.getX() + this.speedX);
        this.setY((this.getY() + this.speedY));
    }

    public float getSpeedX() {
        return speedX;
    }

    public void setSpeedX(float speedX) {
        this.speedX = speedX;
    }

    public float getSpeedY() {
        return speedY;
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }

}
