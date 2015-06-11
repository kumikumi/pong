package game;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import libraries.Scene;
import libraries.StaticImage;

class PongScene extends Scene {

    private Player player1;
    private Player player2;
    private Ball ball;

    public static final int BALL_HEIGHT = 20;
    public static final int PLAYER_HEIGHT = 80;

    @Override
    public void initialize() {
        StaticImage background = new StaticImage(0, 0, new Sprite(new Texture("assets/pong.png")));
        addDrawable(background);

        Sprite mailaImage = new Sprite(new Texture("assets/maila.png"));

        Sprite ballImage = new Sprite(new Texture("assets/pallo.png"));

        player1 = new Player(20, 300, mailaImage, Keys.W, Keys.S);
        addDrawable(player1);

        player2 = new Player(1160, 220, mailaImage, Keys.UP, Keys.DOWN);
        addDrawable(player2);

        ball = new Ball(MyGame.SCREEN_WIDTH / 2, MyGame.SCREEN_HEIGHT / 2, ballImage);
        //ball = new Ball(0, 0, ballImage);
        addDrawable(ball);
    }

    @Override
    public void updateScene() {
        //System.out.println("update scene");
        player1.move();
        player2.move();
        ball.move();
//        ball.setX(MyGame.SCREEN_WIDTH - 60);
//        ball.setY(player2.getY());

        if (ball.getX() < 40 && Math.abs(player1.distanceFromCenter(ball)) < (PLAYER_HEIGHT + BALL_HEIGHT) / 2) {
            ball.setSpeedX(ball.getSpeedX() * -1 + 0.2f);
            ball.setSpeedY(player1.distanceFromCenter(ball) / 10);
            System.out.println(ball.getSpeedX());
        }
        if (ball.getX() > MyGame.SCREEN_WIDTH - 60 && Math.abs(player2.distanceFromCenter(ball)) < (PLAYER_HEIGHT + BALL_HEIGHT) / 2) {
            ball.setSpeedX(ball.getSpeedX() * -1 - 0.2f);
            ball.setSpeedY(player2.distanceFromCenter(ball) / 10);
            System.out.println(ball.getSpeedX());
        }
        
        if (ball.getY() < 0 || ball.getY() + BALL_HEIGHT > MyGame.SCREEN_HEIGHT) {
            ball.setSpeedY(ball.getSpeedY()*-1);
        }
        
        if (ball.getX() < 0 || ball.getX() + BALL_HEIGHT > MyGame.SCREEN_WIDTH) {
            System.out.println("peli loppui");
            ball.reset();
        }

//        if (ball.getX() < 40 && ball.getY() + BALL_HEIGHT > player1.getY() && ball.getY() - BALL_HEIGHT < player1.getY() + PLAYER_HEIGHT) {
//            ball.setSpeedX(ball.getSpeedX() * -1);
//            System.out.println(player1.distanceFromCenter(ball));
//        }
//        if (ball.getX() > MyGame.SCREEN_WIDTH - 60 && ball.getY() + BALL_HEIGHT > player2.getY() && ball.getY() - BALL_HEIGHT < player2.getY() + PLAYER_HEIGHT) {
//            ball.setSpeedX(ball.getSpeedX() * -1);
//            System.out.println(player2.distanceFromCenter(ball));
//        }
//        ball.setX(MyGame.SCREEN_WIDTH - 60);
//        player2.setBallToCenter(ball);
    }

    @Override
    public void checkInputs() {

    }

}
