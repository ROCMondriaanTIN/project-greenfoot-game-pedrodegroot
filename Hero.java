 
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;
    int player = 1; 

    public Hero() {
        super();
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        setImage("p1.png");
    }

    @Override
    public void act() {
        handleInput();
        
        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();

        for (Actor enemy : getIntersectingObjects(Enemy.class)) {
            if (enemy != null) {
                setLocation(300, 200);
                Greenfoot.setWorld(new gameover());
                break;
            }
        }
        for (Actor enemy : getIntersectingObjects(LiquidWater.class)) {
            if (enemy != null) {
                setLocation(300, 200); 
                Greenfoot.setWorld(new gameover());
                break;
            }
        } 
        for (Actor hero : getIntersectingObjects(redkey.class)) {
            if (hero != null) {
                removeTouching(redkey.class);
                break;
            }
        } 
        for (Actor hero : getIntersectingObjects(bluekey.class)) {
            if (hero != null) {
                removeTouching(bluekey.class);
                break;
            }
        } 
        for  (Actor hero : getIntersectingObjects(greenkey.class)) {
            if (hero != null) {
                removeTouching(greenkey.class);
                break;
            }
        } 
        for   (Actor hero : getIntersectingObjects(greenbox.class)) {
            if (hero != null) {
                removeTouching(greenbox.class);
                break;
            }
        }  
        for    (Actor hero : getIntersectingObjects(bluebox.class)) {
            if (hero != null) {
                removeTouching(bluebox.class);
                break;
            }
        } 
        for     (Actor hero : getIntersectingObjects(redbox.class)) {
            if (hero != null) {
                removeTouching(redbox.class);
                break;
            }
        } 
        for     (Actor hero : getIntersectingObjects(gem.class)) {
            if (hero != null) {
                removeTouching(gem.class);
                break;
            }
        }
        for     (Actor hero : getIntersectingObjects(deur.class)) {
            if (hero != null) {
                removeTouching(deur.class);
                setLocation(300, 200); 
                Greenfoot.setWorld(new lv2());
                
                break;
            }
        } 
        for     (Actor hero : getIntersectingObjects(Munt.class)) {
            if (hero != null) {
                removeTouching(Munt.class);
                player++;
                if(player == 2){
                    player = 2;
                    setImage("p2_jump.png");
                    setImage("p2_duck.png");   
                    setImage("p2_front.png");
                    setImage("p2_stand.png");
                }
                if(player == 3){
                setImage("p3_jump.png");
                setImage("p3_duck.png");   
                setImage("p3_front.png");
                setImage("p3_stand.png");
                }
            }
        }
        
    } 
        

    public void handleInput() {
        if (Greenfoot.isKeyDown("w")) {
            setImage("p"+ player +"_jump.png");
            velocityY = -20;
        } 
        if (Greenfoot.isKeyDown("s")) {
            setImage("p"+ player +"_duck.png");
            velocityY = 0;
        }

        if (Greenfoot.isKeyDown("a")) {
           setImage("p"+ player +"_front.png");
            velocityX = -2;
        } else if (Greenfoot.isKeyDown("d")) {
            setImage("p"+ player +"_stand.png");
            velocityX = 2;
        }
    }
    
    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }
}
