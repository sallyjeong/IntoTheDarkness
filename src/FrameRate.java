/* * * * * Imports * * * * */
import java.awt.*;

/**
 * [FrameRate.java]
 * This class finds the frame rate
 * @author Peter Gao, Sally Jeong
 * @version 1.0
 * @since June 2021
 */
public class FrameRate {
    private String frameRate; //to display the frame rate to the screen
    private long lastTimeCheck; //store the time of the last time the time was recorded
    private long deltaTime; //to keep the elapsed time between current time and last time
    private int frameCount; //used to cound how many frame occurred in the elasped time (fps)
    private Font font = new Font("SansSerif", Font.PLAIN, 15);

    /**
     * Constructs frame rate
     */
    public FrameRate() {
        lastTimeCheck = System.currentTimeMillis();
        frameCount = 0;
        frameRate = "0 fps";
    }

    /**
     * update
     * This method calculates the FPS
     */
    public void update() {
        long currentTime = System.currentTimeMillis();  //get the current time
        deltaTime += currentTime - lastTimeCheck; //add to the elapsed time
        lastTimeCheck = currentTime; //update the last time var
        frameCount++; // everytime this method is called it is a new frame
        if (deltaTime >= 1000) { //when a second has passed, update the string message
            frameRate = frameCount + " fps";
            frameCount = 0; //reset the number of frames since last update
            deltaTime = 0;  //reset the elapsed time
        }
    }
    
    /**
     * draw
     * This method displays the fps value
     * @param g Graphics for drawing
     */
    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.setFont(font);
        g.drawString(frameRate, 15, 20);
    }

}