import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.TimeUnit;

/**
 * Model of the game of breakout
 * @author Mike Smith University of Brighton
 */

public class Model extends Observable
{
    // Boarder
    private static final int B              = 6;  // Border offset
    private static final int M              = 40; // Menu offset

    // Size of things
    private static final float BALL_SIZE    = 30; // Ball side
    private static final float BRICK_WIDTH  = 50;//50 // Brick size
    private static final float BRICK_HEIGHT = 30;//30

    private static final int BAT_MOVE       = 8; // Distance to move bat

    // Scores
    private static final int HIT_BRICK      = 50;  // Score
    private static final int HIT_BOTTOM     = -200;// Score

    private GameObj ball;          // The ball
    private List<GameObj> bricks;  // The bricks
    private GameObj bat;           // The bat

    private boolean runGame = true; // Game running
    private boolean fast = false;   // Sleep in run loop

    private int score = 0;            //sets the score to 0;
    private int lives = 3;            //sets the player 3 lives.
    private int level = 1;            //begins the game on level 1.

    private final float W;         // Width of area
    private final float H;         // Height of area
    private float currentPositionOfBat;

    public Model( int width, int height )
    {
        this.W = width; this.H = height;
        currentPositionOfBat = width/2;
    }

    /**
     * Create in the model the objects that form the game
     */

    public void createGameObjects()
    {
        synchronized( Model.class )
        {
            ball   = new GameObj(W / 2, H / 2, BALL_SIZE, BALL_SIZE, Colour.RED );
            bat    = new GameObj(W / 2, H - BRICK_HEIGHT * 1.5f, BRICK_WIDTH * 3,
                BRICK_HEIGHT/4, Colour.GRAY);

            bricks = new ArrayList<>();

            /** Check level Place bricks **/
            if (getLevel() == 1)
            {
                level1();
            }
            if (getLevel() == 2)
            {
                level2();
            }
            if (getLevel() == 3)
            {
                level3();
            }
            if (getLevel() == 4)
            {
                level4();
            }
        }
    }

    private ActivePart active  = null;

    public void level1() 
    {
        for (int i = 0; i < 11; i++)
        {                                                                                               
            for (int j = 0; j < 2; j++)
            {                                                                             
                bricks.add(new GameObj(BRICK_WIDTH * (i) + 4 * i,
                        BRICK_HEIGHT * (j) + 4 * j + 100, 
                        BRICK_WIDTH,
                        BRICK_HEIGHT,
                        Colour.RED));
            }
        } 
    }

    public void level2()
    {
        for (int i = 0; i < 11; i++)
        {                                                                                               
            for (int j = 0; j < 2; j++)
            {                                                                             
                bricks.add(new GameObj(BRICK_WIDTH * (i) + 4 * i,
                        BRICK_HEIGHT * (j) + 4 * j + 100, 
                        BRICK_WIDTH,
                        BRICK_HEIGHT,
                        Colour.BLUE));
            }
        }    
    }

    public void level3()
    {
        for (int i = 0; i < 11; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                if (i == 3 || j  == 2)
                {
                    bricks.add(new GameObj(BRICK_WIDTH * (i) + 4 * i,
                            BRICK_HEIGHT * (j) + 4 * j + 100,
                            BRICK_WIDTH,
                            BRICK_HEIGHT,
                            Colour.BLUE));
                }
                else if (i < 3 || j < 2)
                {
                    bricks.add(new GameObj(BRICK_WIDTH * (i) + 4 * i,
                            BRICK_HEIGHT * (j) + 4 * j + 100,
                            BRICK_WIDTH,
                            BRICK_HEIGHT,
                            Colour.GRAY));
                }
                else
                {
                    bricks.add(new GameObj(BRICK_WIDTH * (i) + 4 * i,
                            BRICK_HEIGHT * (j) + 4 * j + 100,
                            BRICK_WIDTH,
                            BRICK_HEIGHT,
                            Colour.RED));
                }
            }
        }
    }

    public void level4()
    {
        stopGame();
    }

    public int getLives()
    {
        return lives;
    }

    public int getLevel() 
    {
        return level;
    }

    /**
     * Start the continuous updates to the game
     */
    public void startGame()
    {
        synchronized ( Model.class )
        {
            stopGame();
            active = new ActivePart();
            Thread t = new Thread( active::runAsSeparateThread );
            t.setDaemon(true);   // So may die when program exits
            t.start();
        }
    }

    /**
     * Stop the continuous updates to the game
     * Will freeze the game, and let the thread die.
     */
    public void stopGame()
    {
        synchronized ( Model.class )
        {
            if ( active != null ) 
            { 
                active.stop(); 
                active = null; 
            }
        }
    }

    public GameObj getBat()             {
        return bat; 
    }

    public GameObj getBall()            { 
        return ball;
    }

    public List<GameObj> getBricks()    { 
        return bricks; 
    }

    /**
     * Add to score n units
     * @param n units to add to score
     */
    protected void addToScore(int n)    {
        score += n; 
    }

    public int getScore()   { 
        return score; 
    }
   
    /**
     * Set speed of ball to be fast (true/ false)
     * @param fast Set to true if require fast moving ball
     */
    public void setFast(boolean fast)
    {
        this.fast = fast;
    }

    /**
     * Move the bat. (-1) is left or (+1) is right
     * @param direction - The direction to move
     */
    public void moveBat( int direction )
    {
        /** Prevent bat moving off-screen **/       
        float dist = direction * BAT_MOVE;
        Debug.trace( "Model: Move bat = %6.2f", dist );  

        // Prevent bat moving if bounds are exceeded, else move bat and recalculate position
        if (currentPositionOfBat + dist + BRICK_WIDTH*3 > W || currentPositionOfBat + dist < 0)
        {  
            //do nothing (prevent bat moving off of screen)                                                                                                               
        }
        else
        {
            bat.moveX(dist);
            currentPositionOfBat = currentPositionOfBat + dist;
        }
    }

    /**
     * This method is run in a separate thread
     * Consequence: Potential concurrent access to shared variables in the class
     */
    class ActivePart
    {
        private boolean runGame = true;
        public void stop()
        {
            runGame = false;
        }

        public void runAsSeparateThread()
        {
            final float S = 3; // Units to move (Speed)
            try
            {
                synchronized ( Model.class ) // Make thread safe
                {
                    GameObj       ball   = getBall();     // Ball in game
                    GameObj       bat    = getBat();      // Bat
                    List<GameObj> bricks = getBricks();   // Bricks
                }

                while (runGame)
                {
                    synchronized ( Model.class ) // Make thread safe
                    {
                        float x = ball.getX();  // Current x,y position
                        float y = ball.getY();
                        /** Deal with possible edge of board hit **/
                        if (x >= W - B - BALL_SIZE)  ball.changeDirectionX();
                        if (x <= 0 + B            )  ball.changeDirectionX();
                        if (y >= H - B - BALL_SIZE)  // Bottom
                        {
                            ball.changeDirectionY(); 
                            addToScore( HIT_BOTTOM );
                            lives--;
                        }
                        if (y <= 0 + M)  ball.changeDirectionY();

                        if (ball.hitBy(bat))
                        {
                            ball.changeDirectionY();
                        }
                        /** End Game if no lives are remaining **/

                        if (lives <= 0){
                            stopGame();
                            String gameOver = "GAME OVER!";
                            TimeUnit.SECONDS.sleep(5);
                            level = 1;
                            gameReset();
                        }
                        /** Check if bricks are visible **/
                        int numberBricks = bricks.size();           //Check how many bricks are on screen
                        for (GameObj e: bricks)
                        {                   
                            if( e.isVisible() == false) {           //if the brick is not visible
                                numberBricks--;                     //remove one brick from the total amount of bricks on screen
                            }
                        }
                        /** Stop the game when no bricks are remaining **/
                        if (numberBricks == 0){                     //if there are no bricks left on screen
                            stopGame();                             //stop the game
                            TimeUnit.SECONDS.sleep(1);              //wait 1 second.
                            level++;
                            gameReset();                            //reset the game.
                        }
                        /** Check if a visible brick has been hit by a ball **/
                        boolean hit = false;
                        boolean brickHit = false;
                        for (GameObj e : bricks) {                                                       
                            if (e.hitBy(ball) && e.isVisible() && (y > e.getY() ||
                                y < e.getY() + BRICK_HEIGHT) && (x < e.getX() ||
                                x > e.getX() + BRICK_WIDTH) && !hit)
                            {
                                ball.changeDirectionY();                                                  
                                ball.changeDirectionX(); 
                                /** Check the colour of the brick that has been hit and change appearance accordingly **/
                                if (e.getColour() == Colour.GRAY)
                                {
                                    e.colour = Colour.BLUE; //If hit brick is grey, change to blue
                                }
                                else if(e.getColour() == Colour.BLUE)
                                {
                                    e.colour = Colour.RED; //If hit brick is blue, change to red
                                }
                                else 
                                {
                                    e.setVisibility(false); //Otherwise change to invisible
                                }
                                hit = true;
                                addToScore(HIT_BRICK);
                            }
                            else if (e.hitBy(ball) && e.isVisible() && (y > e.getY() ||
                                y < e.getY() + BRICK_HEIGHT) && !hit)
                            {
                                ball.changeDirectionY();
                                if (e.getColour() == Colour.GRAY)
                                {
                                    e.colour = Colour.BLUE;
                                }
                                else if (e.getColour() == Colour.BLUE)
                                {
                                    e.colour = Colour.RED; //If hit brick is blue, change to red
                                }
                                else
                                { 
                                    e.setVisibility(false); //Otherwise change to invisible
                                }
                                hit = true;
                                addToScore(HIT_BRICK);
                            }
                            else if (e.hitBy(ball) && e.isVisible() && (x < e.getX() ||
                                x > e.getX() + BRICK_WIDTH) && !hit)
                            {
                                ball.changeDirectionX(); //change latitude direction if the width side of the brick is hit
                                if (e.getColour() == Colour.GRAY)
                                {
                                    e.colour = Colour.BLUE;
                                }
                                else if (e.getColour() == Colour.BLUE)
                                {
                                    e.colour = Colour.RED; //If hit brick is blue, change to grey
                                }
                                else 
                                {
                                    e.setVisibility(false); //Otherwise change to invisible
                                }
                                hit = true;
                                addToScore(HIT_BRICK);
                            }
                            modelChanged();
                        }                       
                    }
                    modelChanged();      // Model changed refresh screen
                    Thread.sleep( fast ? 2 : 20 );
                    ball.moveX(S);  ball.moveY(S);
                }
            } 
            catch (Exception e)
            {
                Debug.error("Model.runAsSeparateThread - Error\n%s", e.getMessage() );
            }
        }
    }

    /**
     * Model has changed so notify observers so that they
     *  can redraw the current state of the game
     */
    public void modelChanged()
    {
        setChanged(); 
        notifyObservers();
    }

    public void gameReset() 
    {
        score = 0;                                //reset score to 0;
        lives = 3;
        createGameObjects();                      //creates game Objects, i.e. blocks, ball and bat.
        startGame();                              //starts the game.
    }
}