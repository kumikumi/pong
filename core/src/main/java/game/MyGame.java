
package game;

import game.VictoryScene;
import com.badlogic.gdx.Game;
import libraries.SceneManager;

class MyGame extends Game{

    static final int SCREEN_WIDTH = 1200;    
    static final int SCREEN_HEIGHT = 900;
    
    static SceneManager sceneManager;
    
    

    @Override
    public void create() {        
        sceneManager = new SceneManager();
        MenuScene menu = new MenuScene();
        menu.initialize();
        sceneManager.addScene(menu);
        
        PongScene rallyGame = new PongScene();
        sceneManager.addScene(rallyGame);
        rallyGame.initialize();
        
        VictoryScene victory = new VictoryScene();
        sceneManager.addScene(victory);
        victory.initialize();
    }

    @Override
    public void render(){
        sceneManager.getCurrentScene().render(30);
    }
    
}
