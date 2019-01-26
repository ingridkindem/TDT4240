package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
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

    private BitmapFont font1;
    private BitmapFont font2;

    private int score1;
    private int score2;

    private Rectangle ballR;
    private Rectangle paddle1R;
    private Rectangle paddle2R;

    private static final Vector3 startPosition1 = new Vector3(15, Pong.HEIGHT / 2 - Paddle.HEIGHT / 2, 0);
    private static final Vector3 startPosition2 = new Vector3((Pong.WIDTH - 15 - Paddle.WIDTH), Pong.HEIGHT / 2 - Paddle.HEIGHT / 2, 0);
    public final static Vector3 startPositionBall = new Vector3(Pong.WIDTH / 2 - Ball.SIZE / 2, Pong.HEIGHT / 2 - Ball.SIZE / 2, 0);

    private Vector3 ballBounce;
    private Vector3 left = new Vector3(-20, 0, 0);
    private Vector3 right = new Vector3(20, 0, 0);

    public PlayState(GameStateManager gsm) {
        super(gsm);
        bg = new Texture("bgPong.png");
        cam.setToOrtho(false, Pong.WIDTH, Pong.HEIGHT);


        ball = new Ball();
        paddle1 = new Paddle(startPosition1);
        paddle2 = new Paddle(startPosition2);

        //Rectangle for each sprite
        ballR = new Rectangle(ball.startPositionBall.x, ball.startPositionBall.y,
                Ball.SIZE, Ball.SIZE);
        paddle1R = new Rectangle(startPosition1.x, startPosition1.y,
                Paddle.WIDTH, Paddle.HEIGHT);
        paddle2R = new Rectangle(startPosition2.x, startPosition2.y,
                Paddle.WIDTH, Paddle.HEIGHT);

        score1 = 0;
        score2 = 0;

        font1 = new BitmapFont();
        font1.getData().setScale(1);
        font1.setColor(Color.WHITE);
        font2 = new BitmapFont();
        font2.getData().setScale(1);
        font2.setColor(Color.WHITE);

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

    protected void ballOut() {
        if (ball.getPosition().x > Pong.WIDTH || ball.getPosition().x < 0) {
            if (ball.getPosition().x > Pong.WIDTH) {
                if (score1 == 2) {
                    gsm.set(new EndState(gsm, 1));
                    dispose();

                } else {
                    score1 += 1;
                }

            }
            if (ball.getPosition().x < 0) {
                if (score2 == 2) {
                    gsm.set(new EndState(gsm, 2));
                    dispose();

                } else {
                    score2 += 1;
                }

            }
            ball.setPosition(startPositionBall);
            ballBounce = new Vector3(-2 * ball.getVelocity().x + randomInt(), -2 * ball.getVelocity().y + randomInt(), 0);
            ball.addVelocity(ballBounce);


        }
    }

    public int randomInt() {

        return (int) (Math.random() * 150 + 1);
    }

    @Override
    protected void handleInput() {
        Vector3 tmp = new Vector3(paddle1.getPosition().x, Gdx.input.getY(), 0);
        cam.unproject(tmp);
        if (tmp.y > (Pong.HEIGHT - Paddle.HEIGHT)) {
            tmp.y = Pong.HEIGHT - Paddle.HEIGHT;
            paddle1.movePaddle(tmp);

        } else if (tmp.y < 0) {
            tmp.y = 0;
            paddle1.movePaddle(tmp);


        } else {
            paddle1.movePaddle(tmp);
        }

    }

    @Override
    public void update(float dt) {

        handleInput();
        collision();
        ballOut();

        ballR.setPosition(ball.getPosition().x, ball.getPosition().y);
        paddle1R.setPosition(paddle1.getPosition().x, paddle1.getPosition().y);
        paddle2R.setPosition(paddle2.getPosition().x, paddle2.getPosition().y);

        paddle1.update(dt);
        paddle2.follow(ball);
        paddle2.update(dt);
        ball.update(dt);


    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(bg, 0, 0, Pong.WIDTH, Pong.HEIGHT);
        sb.draw(ball.getTexture(), ball.startPositionBall.x, ball.startPositionBall.y, Ball.SIZE, Ball.SIZE);
        sb.draw(paddle1.getTexture(), startPosition1.x, startPosition1.y, Paddle.WIDTH, Paddle.HEIGHT);
        sb.draw(paddle2.getTexture(), startPosition2.x, startPosition2.y, Paddle.WIDTH, Paddle.HEIGHT);
        font1.draw(sb, "Player 1: " + score1, Pong.WIDTH / 2 - 95, Pong.HEIGHT - 20);
        font2.draw(sb, "Player 2: " + score2, Pong.WIDTH / 2 + 25, Pong.HEIGHT - 20);
        sb.end();

    }

    @Override
    public void dispose() {
        bg.dispose();
        ball.getTexture().getTexture().dispose();
        paddle1.getTexture().getTexture().dispose();
        paddle2.getTexture().getTexture().dispose();
        font1.dispose();
        font2.dispose();

    }
}
