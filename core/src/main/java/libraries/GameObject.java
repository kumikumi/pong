
package libraries;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class GameObject implements Movable{
    
    private float x, y;
    private Sprite img;
    private Rectangle collisionArea;
    protected SpriteBatch batch = new SpriteBatch();
    
    
    public GameObject(float x, float y, Sprite img) {
        this.x = x;
        this.y = y;
        this.img = img;
        this.collisionArea = new Rectangle(x, y, img.getWidth(), img.getHeight());
    }

    
    public void draw(){
        batch.begin();
        batch.draw(getImage(), getX(), getY());
        batch.end();
    }
    public void setX(float x){
        this.x = x;
    }
    public void setY(float y){
        this.y = y;
    }
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
    public Sprite getImage(){
        return this.img;
    }

    public Rectangle getCollisionArea(){
        return this.collisionArea;
    }
    
    @Override
    public void move(){
        
    }
}
