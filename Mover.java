
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Mover extends Actor {

    public int screenX;
    public int screenY;
    public double velocityX;
    public double velocityY;
    protected Camera camera;
    public int lastX, lastY, plastX, plastY, p2lastX, p2lastY, p3lastX, p3lastY;

    private int worldX;
    private int worldY;
    private boolean firstLocation = true;
    private boolean hasCamera;

    public void Label(String text)
    {
     
        GreenfootImage img = new GreenfootImage(100,30);
        img.drawString(text,2,20);
        setImage(img);
    }
          
    /**
     * Methode to set the camera a Mover can have
     *
     * @param camera A Camera class
     */
    public void setCamera(Camera camera) {
        this.camera = camera;
        hasCamera = true;
    }

    /**
     * Removes the camera if a camera has been set
     */
    public void removeCamera() {
        if (hasCamera) {
            this.camera = null;
            hasCamera = false;
        }
    }

    /**
     * Apply change in position based on velocityX and velocityY
     */
    public void applyVelocity() {
        if (Math.abs(velocityX) < 0.01) {
            velocityX = 0;
        }
        if (Math.abs(velocityY) < 0.01) {
            velocityY = 0;
        }
       
        setLocation(getX() + (int)velocityX, getY() + (int)velocityY);
        
    }

    @Override
    public void setLocation(int x, int y) {
        if (firstLocation == true) {
            firstLocation = false;
            screenX = x;
            screenY = y;
        }
        super.setLocation(screenX, screenY);
        this.worldX = x;
        this.worldY = y;
    }

    @Override
    public int getX() {
        return this.worldX;
    }

    @Override
    public int getY() {
        return this.worldY;
    }

    /**
     * Returns the x position based on the screen
     *
     * @return
     */
    public int getScreenX() {
        return this.screenX;
    }

    /**
     * Returns the y position based on the screen
     *
     * @return
     */
    public int getScreenY() {
        return this.screenY;
    }

    @Override
    public String toString() {
        return "X: " + getX() + "\n"
                + "Y: " + getY() + "\n"
                + "screenX: " + getScreenX() + "\n"
                + "screenY: " + getScreenY() + "\n"
                + "velocityX: " + velocityX + "\n"
                + "velocityY: " + velocityY + "\n";
    }
}
