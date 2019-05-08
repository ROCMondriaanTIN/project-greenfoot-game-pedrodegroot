 
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
    int redkey = 0;
    boolean hasredkey = false;
    int bluekey = 0; 
    int greenkey = 0;
    
    boolean collisionActive = false;
    boolean a = true;
    
    
        
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
        
        p3lastX = p2lastX; p3lastY = p2lastY;
        p2lastX = plastX; p2lastY = plastY;
        plastX = lastX; plastY = lastY;
        lastX = getX(); lastY = getY(); 
         
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        
        applyVelocity();
        
       for (Actor hero : getIntersectingObjects(redbox.class)) {
        
            if(hero != null) {
                setLocation(p3lastX, p3lastY);  
             }
        }
         
        for (Actor hero : getIntersectingObjects(bluebox.class)) {
        
            if(hero != null) {
                setLocation(p3lastX, p3lastY);  
             }
        }
        
        for (Actor hero : getIntersectingObjects(greenbox.class)) {
        
            if(hero != null) {
                setLocation(p3lastX, p3lastY);  
             }
        }
        
        
        for (Actor enemy : getIntersectingObjects(Enemy.class)) {
            if (enemy != null) {
                setLocation(200, 1800);
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
                redkey=1;
              
                break;
            }
        } 
        for (Actor hero : getIntersectingObjects(bluekey.class)) {
            if (hero != null) {
                
                removeTouching(bluekey.class);
                bluekey=1;
                break;
            }
        } 
        for  (Actor hero : getIntersectingObjects(greenkey.class)) {
            if (hero != null) {
                removeTouching(greenkey.class);
                greenkey=1;
                break;
            }
        } 
        for   (Actor hero : getIntersectingObjects(greenbox.class)) {
            if (greenkey==1) {
                removeTouching(greenbox.class);
                break;
            }
        }  
        for    (Actor hero : getIntersectingObjects(bluebox.class)) {
            if (bluekey==1) {
                removeTouching(bluebox.class);
                break;
            }
        } 
        for     (Actor hero : getIntersectingObjects(redbox.class)) {
            if (redkey==1) {
                          
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
       public void actw() 
    {
        if (Greenfoot.isKeyDown("W"))
        {
            setLocation(getX(),(p3lastY)-2);
        }
        
        
        
    } 

    public void handleInput() {
        if (Greenfoot.isKeyDown("w")) {
            setImage("p"+ player +"_jump.png");
            
            velocityY = -2;
            actw(); 
 
        } 
        if (Greenfoot.isKeyDown("s")) {
            setImage("p"+ player +"_duck.png");
            
            velocityY = 2;
            actw();
 
            }

        if (Greenfoot.isKeyDown("a")) {
           setImage("p"+ player +"_front.png");
           
           velocityX = -2;

           actw();

           } 
        
        if (Greenfoot.isKeyDown("d")) {
            setImage("p"+ player +"_stand.png");
 
            velocityX = 2;
            actw();
 
            }
        
    }
   
    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }
}
