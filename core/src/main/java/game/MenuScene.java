package game;

import game.MyGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import java.util.ArrayList;
import libraries.InputListener;
import libraries.MenuButton;
import libraries.Scene;
import libraries.StaticImage;

class MenuScene extends Scene {

    private ArrayList<MenuButton> buttonList;

    private InputListener inputListener;

    @Override
    public void initialize() {
        Sprite topicImg = new Sprite(new Texture("assets/topic.png"));
        StaticImage background = new StaticImage(0, 0, new Sprite(new Texture("assets/pong.png")));
        StaticImage topic = new StaticImage(MyGame.SCREEN_WIDTH / 2 - topicImg.getWidth() / 2, MyGame.SCREEN_HEIGHT - 100, topicImg);        
        addDrawable(background);
        addDrawable(topic);
        Sprite startImg = new Sprite(new Texture("assets/buttonStart.png"));
        Sprite startImgHover = new Sprite(new Texture("assets/buttonStartHover.png"));
        Sprite quitImg = new Sprite(new Texture("assets/buttonQuit.png"));
        Sprite quitImgHover = new Sprite(new Texture("assets/buttonQuitHover.png"));

        float buttonHeight = startImg.getHeight();
        float buttonWidth = startImg.getWidth();

        buttonList = new ArrayList<MenuButton>();
        buttonList.add(new MenuButton(MyGame.SCREEN_WIDTH / 2 - buttonWidth / 2, MyGame.SCREEN_HEIGHT / 2, startImg, startImgHover, "START"));
        buttonList.add(new MenuButton(MyGame.SCREEN_WIDTH / 2 - buttonWidth / 2, MyGame.SCREEN_HEIGHT / 2 - buttonHeight, quitImg, quitImgHover, "QUIT"));

        addButtons(buttonList);
        inputListener = new InputListener();
        Gdx.input.setInputProcessor(inputListener);
    }

    @Override
    public void updateScene() {

    }

    @Override
    public void checkInputs() {        
        for (MenuButton button : buttonList) {
            if (button.isMousePointerTouching(inputListener.getMouseX(), inputListener.getMouseY())) {
                button.setHover(true);
                //Checks if leftmouse is clicked while mousepointer is touching button and then checks which button it was.
                if (inputListener.isLeftMouseButtonClicked()) {
                    if ("QUIT".equals(button.getButtonText())) {
                        System.exit(0);
                    }
                    if ("START".equals(button.getButtonText())) {
                        MyGame.sceneManager.nextScene();
                    }
                }
            } else {
                button.setHover(false);
            }
        }
    }

}
