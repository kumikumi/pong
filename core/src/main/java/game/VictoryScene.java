
package game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import libraries.Scene;
import libraries.StaticImage;

class VictoryScene extends Scene {

    @Override
    public void initialize() {
        StaticImage bg = new StaticImage(0, 0, new Sprite(new Texture("assets/victory.png")));
        addDrawable(bg);
    }

    @Override
    public void updateScene() {

    }

    @Override
    public void checkInputs() {
        if(Gdx.input.isKeyPressed(Keys.ENTER)){
            for (Scene scene : MyGame.sceneManager.getScenes()) {
                scene.initialize();
                MyGame.sceneManager.setCurrentScene(0);
            }
        }
    }
    
}
