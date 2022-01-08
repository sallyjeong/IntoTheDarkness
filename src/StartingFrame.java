/* * * * * Imports * * * * */
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.MouseListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
/**
 * [StartingFrame.java]
 * This class creates the starting frame menu
 * @author Peter Gao, Sally Jeong
 * @version 1.0
 * @since June 2021
 */
public class StartingFrame extends JFrame {
    static JFrame thisFrame;
    /**
     * Constructs a starting frame
     */
    public StartingFrame() {
        setTitle("Menu Screen");
        setSize(1024, 760);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        getContentPane().add(new MenuPanel());
        setVisible(true);
        this.setLocationRelativeTo(null); 
        this.setResizable(false);
        thisFrame = this;
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        this.add(mainPanel);
        this.setVisible(true);
        this.requestFocusInWindow();
    }
    
    /**
     * [MenuPanel.java]
     * This inner class creates the JFrame to draw the menu on
     * @author Peter Gao, Sally Jeong
     * @version June 2021
     */
    static class MenuPanel extends JPanel implements MouseListener, MouseMotionListener, Drawable {
        private int[] startButton = {565,480}; //top X, top Y
        private int[] exitButton = {89,480};
        private int buttonWidth = 370;
        private int buttonHeight = 135;
        private Color WHITE = new Color(255, 255, 255);
        private Color DARK_BLUE = new Color(23, 46, 76, 218);
        private Color BLUE = new Color(38, 64, 102, 218);
        private BufferedImage menu;
        private Font font = new Font("SansSerif", Font.BOLD, 65);
        private boolean hoverStart = false; // true if the mouse hovered over the Play button
        private boolean hoverExit = false;
        
        /**
         * Constructs a menu panel
         */
        public MenuPanel() {
            setPreferredSize(new Dimension(1024, 768));
            addMouseListener(this);
            addMouseMotionListener(this);
            setFocusable(true);
            requestFocusInWindow();
            Sound.playMenu();
        }
        
        /**
         * paintComponent
         * This method draws to the screen
         * @param g, Graphics for drawing
         */
        public void paintComponent(Graphics g) {
            super.paintComponent(g); 
            draw(g);
            //request a repaint
            repaint();
        }
        
        /**
         * loadMenu
         * This method loads the menu image
         */
        public void loadMenu() {
            try {
                menu = ImageIO.read(new File("graphics\\menu.jpg"));
            } catch (Exception e) {
                System.out.println("error loading menu");
            }
        }
        
        /**
         * draw
         * This method draws the menu image
         * and the start/exit buttons
         * @param g, Graphics for drawing
         */
        public void draw(Graphics g) {
            g.setColor(BLUE);
            g.setFont(font);
            loadMenu();
            g.drawImage(menu, 0, 0, null);
            g.fillRect(startButton[0], startButton[1], buttonWidth, buttonHeight);
            g.fillRect(exitButton[0], exitButton[1], buttonWidth, buttonHeight);
            g.setColor(WHITE);
            g.drawString("START", 650, 570);
            g.drawString("EXIT", 195, 570);
            if (hoverStart) {
                g.setColor(DARK_BLUE);
                g.fillRect(startButton[0], startButton[1], buttonWidth, buttonHeight);
                g.setColor(WHITE);
                g.drawString("START", 650, 570);
            }
            if (hoverExit) {
                g.setColor(DARK_BLUE);
                g.fillRect(exitButton[0], exitButton[1], buttonWidth, buttonHeight);
                g.setColor(WHITE);
                g.drawString("EXIT", 195, 570);
            }
        }

        /**
         * mouseClicked
         * This method is invoked when the mouse button has been clicked on a component
         * @param e, MouseEvent indicates that an action occurred
         */
        public void mouseClicked(MouseEvent e) {
            if (hoverStart) {
                Sound.playButton();
                System.out.println("Starting New Game");
                thisFrame.dispose();
                new GameWindow(); //create a new frame after removing the current one
            }
            if (hoverExit) {
                Sound.playButton();
                System.out.println("Exit");
                System.exit(0);
            }
        }
        
        /**
         * mousePressed
         * This method is invoked when the mouse button has been pressed on a component
         * @param e, MouseEvent indicates that an action occurred
         */
        public void mousePressed(MouseEvent e) {
        }

        /**
         * mouseReleased
         * This method is invoked when the mouse button has been released 
         * @param e, MouseEvent indicates that an action occurred
         */
        public void mouseReleased(MouseEvent e) {
        }

        /**
         * mouseEntered
         * This method is invoked when the mouse enters a component
         * @param e, MouseEvent indicates that an action occurred
         */
        public void mouseEntered(MouseEvent e) {
        }

        /**
         * mouseExited
         * This method is invoked when the mouse exits a component
         * @param e, MouseEvent indicates that an action occurred
         */
        public void mouseExited(MouseEvent e) {
        }

        /**
         * mouseDragged
         * This method is invoked when a mouse button is pressed on a component and then dragged
         * @param e, MouseEvent indicates that an action occurred
         */
        public void mouseDragged(MouseEvent e) {
        }
        
        /**
         * mouseMoved
         * This method is invoked when the mouse cursor has been moved onto a component 
         * @param e, MouseEvent indicates that an action occurred
         */
        public void mouseMoved(MouseEvent e) {
            if ((e.getX() >= startButton[0]) && (e.getX() <= startButton[0] + buttonWidth) &&
                    (e.getY() >= startButton[1]) && (e.getY() <= startButton[1] + buttonHeight)) {
                hoverStart = true;
            } else {
                hoverStart = false;
            }
            if ((e.getX() >= exitButton[0]) && (e.getX() <= exitButton[0] + buttonWidth) &&
                    (e.getY() >= exitButton[1]) && (e.getY() <= exitButton[1] + buttonHeight)) {
                hoverExit = true;
            } else {
                hoverExit = false;
            }
        }
    }
    
    //Main method starts this application
    public static void main(String[] args) {
        new StartingFrame();
    }
}

