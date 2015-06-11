package libraries;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import java.util.ArrayList;

public abstract class Scene implements Screen {

    private ArrayList<GameObject> allDrawables;

    public Scene() {
        allDrawables = new ArrayList<GameObject>();
    }

    public abstract void initialize();

    public abstract void updateScene();

    public abstract void checkInputs();

    public void addDrawable(GameObject image) {
        allDrawables.add(image);
    }

    //REFACTOR THIS AWAY TO THE ONE BELOW THIS METHOD
    public void addButtons(ArrayList<MenuButton> buttons) {
        allDrawables.addAll(buttons);
    }
    
    public void addDrawables(ArrayList<GameObject> players) {
        allDrawables.addAll(players);
    }

    @Override
    public void render(float f) {
        checkInputs();
        updateScene();
        flush();
        for (GameObject drawable : allDrawables) {
            drawable.draw();
        }
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }

    private void flush() {
        Gdx.gl.glClearColor(255, 255, 255, 0);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
    }
}
