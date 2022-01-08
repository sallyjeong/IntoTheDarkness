/* * * * * Imports * * * * */
import java.io.File;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

/**
 * [Sound.java]
 * This class holds the audio file for each sound
 * @author Peter Gao, Sally Jeong
 * @version 1.0
 * @since June 2021
 */
public class Sound {
    public static File playerDead, enemyDead, playerHit, enemyHit, button, doorOpen, win, winScreen, lose, menu, openChest, collect, game;
    private static AudioInputStream audioStream;
    private static Clip clip;
    private static Clip activeClip;
    
    /**
     * loadAudioFile
     * This method loads all the sound files
     */
    public static void loadAudioFile(){
        try {
            playerDead = new File("sound\\player dead.wav");
            enemyDead = new File("sound\\enemy dead.wav");
            playerHit = new File("sound\\player hit.wav");
            enemyHit = new File("sound\\enemy hit.wav");
            button = new File("sound\\button.wav");
            doorOpen = new File("sound\\door open.wav");
            win = new File("sound\\win.wav");
            winScreen = new File("sound\\win screen.wav");
            lose = new File("sound\\lose screen.wav");
            openChest = new File("sound\\open chest.wav");
            collect = new File("sound\\collect.wav");
            menu = new File ("sound\\menu.wav");
            game = new File ("sound\\game.wav");
        }catch (Exception e) {
            System.out.println("error loading audio");
            e.printStackTrace();
        }
    }
    
    /**
     * playPlayerDead
     * This method plays the player dead sound
     */
    public static void playPlayerDead (){
        loadAudioFile();
        try {
            audioStream = AudioSystem.getAudioInputStream(playerDead);
            DataLine.Info info = new DataLine.Info(Clip.class, audioStream.getFormat());
            clip = (Clip) AudioSystem.getLine(info);
            clip.addLineListener(new SoundListener());
            clip.open(audioStream);
            clip.start();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * playEnemyDead
     * This method plays the enemy dead sound
     */
    public static void playEnemyDead (){
        loadAudioFile();
        try {
            audioStream = AudioSystem.getAudioInputStream(enemyDead);
            DataLine.Info info = new DataLine.Info(Clip.class, audioStream.getFormat());
            clip = (Clip) AudioSystem.getLine(info);
            clip.addLineListener(new SoundListener());
            clip.open(audioStream);
            clip.start();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * playPlayerHit
     * This method plays the player hit sound
     */
    public static void playPlayerHit (){
        loadAudioFile();
        try {
            audioStream = AudioSystem.getAudioInputStream(playerHit);
            DataLine.Info info = new DataLine.Info(Clip.class, audioStream.getFormat());
            clip = (Clip) AudioSystem.getLine(info);
            clip.addLineListener(new SoundListener());
            clip.open(audioStream);
            clip.start();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * playEnemyHit
     * This method plays the enemy hit sound
     */
    public static void playEnemyHit (){
        loadAudioFile();
        try {
            audioStream = AudioSystem.getAudioInputStream(enemyHit);
            DataLine.Info info = new DataLine.Info(Clip.class, audioStream.getFormat());
            clip = (Clip) AudioSystem.getLine(info);
            clip.addLineListener(new SoundListener());
            clip.open(audioStream);
            clip.start();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * playButton
     * This method plays the button sound
     */
    public static void playButton (){
        loadAudioFile();
        try {
            audioStream = AudioSystem.getAudioInputStream(button);
            DataLine.Info info = new DataLine.Info(Clip.class, audioStream.getFormat());
            clip = (Clip) AudioSystem.getLine(info);
            clip.addLineListener(new SoundListener());
            clip.open(audioStream);
            clip.start();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * playDoorOpen
     * This method plays the door opening sound
     */
    public static void playDoorOpen (){
        loadAudioFile();
        try {
            audioStream = AudioSystem.getAudioInputStream(doorOpen);
            DataLine.Info info = new DataLine.Info(Clip.class, audioStream.getFormat());
            clip = (Clip) AudioSystem.getLine(info);
            clip.addLineListener(new SoundListener());
            clip.open(audioStream);
            clip.start();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * playOpenChest
     * This method plays the opening chest sound
     */
    public static void playOpenChest (){
        loadAudioFile();
        try {
            audioStream = AudioSystem.getAudioInputStream(openChest);
            DataLine.Info info = new DataLine.Info(Clip.class, audioStream.getFormat());
            clip = (Clip) AudioSystem.getLine(info);
            clip.addLineListener(new SoundListener());
            clip.open(audioStream);
            clip.start();
        }catch (Exception e) {
            e.printStackTrace();
        }
        playCollect();
    }

    /**
     * playCollect
     * This method plays the player collect sound
     */
    public static void playCollect (){
        loadAudioFile();
        try {
            audioStream = AudioSystem.getAudioInputStream(collect);
            DataLine.Info info = new DataLine.Info(Clip.class, audioStream.getFormat());
            clip = (Clip) AudioSystem.getLine(info);
            clip.addLineListener(new SoundListener());
            clip.open(audioStream);
            clip.start();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * playMenu
     * This method plays the menu music
     */
    public static void playMenu (){
        loadAudioFile();
        try {
            audioStream = AudioSystem.getAudioInputStream(menu);
            DataLine.Info info = new DataLine.Info(Clip.class, audioStream.getFormat());
            clip = (Clip) AudioSystem.getLine(info);
            clip.addLineListener(new SoundListener());
            clip.open(audioStream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            activeClip=clip;
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * playWin
     * This method plays the winning screen sound
     */
    public static void playWin (){
        loadAudioFile();
        try {
            audioStream = AudioSystem.getAudioInputStream(win);
            DataLine.Info info = new DataLine.Info(Clip.class, audioStream.getFormat());
            clip = (Clip) AudioSystem.getLine(info);
            clip.addLineListener(new SoundListener());
            clip.open(audioStream);
            clip.start();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * playWinScreen
     * This method plays the winning screen music
     */
    public static void playWinScreen (){
        activeClip.stop();
        playWin();
        loadAudioFile();
        try {
            audioStream = AudioSystem.getAudioInputStream(winScreen);
            DataLine.Info info = new DataLine.Info(Clip.class, audioStream.getFormat());
            clip = (Clip) AudioSystem.getLine(info);
            clip.addLineListener(new SoundListener());
            clip.open(audioStream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * playLose
     * This method plays the losing screen music
     */
    public static void playLose (){
        activeClip.stop();
        loadAudioFile();
        try {
            audioStream = AudioSystem.getAudioInputStream(lose);
            DataLine.Info info = new DataLine.Info(Clip.class, audioStream.getFormat());
            clip = (Clip) AudioSystem.getLine(info);
            clip.addLineListener(new SoundListener());
            clip.open(audioStream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * playGame
     * This method plays the background music during the game
     */
    public static void playGame(){
        activeClip.stop();
        loadAudioFile();
        try {
            audioStream = AudioSystem.getAudioInputStream(game);
            DataLine.Info info = new DataLine.Info(Clip.class, audioStream.getFormat());
            clip = (Clip) AudioSystem.getLine(info);
            clip.addLineListener(new SoundListener());
            clip.open(audioStream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            activeClip=clip;
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * [SoundListener.java]
     * This class creates a line listener
     * and implements LineListener
     * @author Peter Gao, Sally Jeong
     * @version 1.0
     * @since June 2021
     */
    static class SoundListener implements LineListener {
     /**
         * update
         * This method updates the line
         * @param event LineEvent
         */
        public void update(LineEvent event) {
            if (event.getType() == LineEvent.Type.STOP) {
                event.getLine().close();
            }
        }
    }

}

