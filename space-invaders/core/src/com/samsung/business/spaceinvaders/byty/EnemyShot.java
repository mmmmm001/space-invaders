package com.samsung.business.spaceinvaders.byty;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.samsung.business.spaceinvaders.zarzadzanie.GraphicsManager;

/**
 * Created by lb_lb on 01.11.17.
 */
public class EnemyShot implements Shot {
    private Rectangle rectangle;
    private GraphicsManager.Graphics graphics;

    public EnemyShot(GraphicsManager.Graphics graphics, float originX, float originY) {
        this.graphics = graphics;
        rectangle = new Rectangle();
        rectangle.x = originX;
        rectangle.y = originY;
        rectangle.height = 10;
        rectangle.width = 10;
    }


    @Override
    public void render(SpriteBatch batch, float animationTime) {
        TextureRegion enemyShotFrame = graphics.frameToRender(animationTime);
        batch.draw(enemyShotFrame, rectangle.x, rectangle.y);
    }

    @Override
    public void updateState() {
        this.rectangle.y -= 200 * Gdx.graphics.getDeltaTime();
    }

    @Override
    public boolean hitIn(Targetable targetableObject) {
        return targetableObject.checkHit(this.rectangle, targetableObject.rectangle());
    }

    public boolean isOutsideScreen() {
        return this.rectangle.y + 10 < 0;
    }
}
