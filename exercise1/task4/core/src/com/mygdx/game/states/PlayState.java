package com.mygdx.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Pong;
import com.mygdx.game.sprites.Ball;
import com.mygdx.game.sprites.Paddle;

public class PlayState extends State {
    public Texture bg;

    private Ball ball;

    //Left-paddle = 1 and right-paddle = 2
    private Paddle paddle1;
    private Paddle paddle2;

    private Rectangle ballR;
    private Rectangle paddle1R;
    private Rectangle paddle2R;

    private static final Vector3 startPosition1 = new Vector3(15, Pong.HEIGHT / 2 - Paddle.HEIGHT / 2, 0);
    private static final Vector3 startPosition2 = new Vector3((Pong.WIDTH - 15 - Paddle.WIDTH), Pong.HEIGHT / 2 - Paddle.HEIGHT / 2, 0);

    private Vector3 ballBounce;
    private Vector3 left = new Vector3(-10, 0, 0);
    private Vector3 right = new Vector3(10, 0, 0);

    public PlayState(GameStateManager gsm) {
        super(gsm);
        bg = new Texture("bgPong.png");

        ball = new Ball();
        paddle1 = new Paddle(startPosition1);
        paddle2 = new Paddle(startPosition2);

        //Rectangle for each sprite
        ballR = new Rectangle(Ball.startPositionBall.x, Ball.startPositionBall.y,
                Ball.SIZE, Ball.SIZE);
        paddle1R = new Rectangle(startPosition1.x, startPosition1.y,
                Paddle.WIDTH, Paddle.HEIGHT);
        paddle2R = new Rectangle(startPosition2.x, startPosition2.y,
                Paddle.WIDTH, Paddle.HEIGHT);

    }

    protected void collision() {
        if (paddle1R.overlaps(ballR) || paddle2R.overlaps(ballR)) {

            if (paddle1R.overlaps(ballR)) {
                ball.addPosition(right);

            }
            if (paddle2R.overlaps(ballR)) {
                ball.addPosition(left);

            }

            ballBounce = new Vector3(-2 * ball.getVelocity().x + randomInt(), -2 * ball.getVelocity().y + randomInt(), 0);
            ball.addVelocity(ballBounce);
        }

    }



    public int randomInt() {

        return (int) (Math.random() * 50 + 1);
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
        handleInput();
        collision();

        ballR.setPosition(ball.getPosition().x, ball.getPosition().y);
        paddle1R.setPosition(paddle1.getPosition().x, paddle1.getPosition().y);
        paddle2R.setPosition(paddle2.getPosition().x, paddle2.getPosition().y);

        ball.update(dt);
        paddle1.update(dt);
        paddle2.update(dt);

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(bg, 0, 0, Pong.WIDTH, Pong.HEIGHT);
        sb.draw(ball.getTexture(), Ball.startPositionBall.x, Ball.startPositionBall.y, Ball.SIZE, Ball.SIZE);
        sb.draw(paddle1.getTexture(), startPosition1.x, startPosition1.y, Paddle.WIDTH, Paddle.HEIGHT);
        sb.draw(paddle2.getTexture(), startPosition2.x, startPosition2.y, Paddle.WIDTH, Paddle.HEIGHT);

        sb.end();

    }

    @Override
    public void dispose() {

    }
}
