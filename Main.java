package sexbob.omb;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws AWTException {
	// write your code here
        /*
        Robot rob = new Robot();
        rob.setAutoDelay(100);
        //screenshot bind
        rob.keyPress(KeyEvent.VK_WINDOWS);
        rob.keyPress(KeyEvent.VK_SHIFT);
        rob.keyPress(KeyEvent.VK_S);
        rob.keyRelease(KeyEvent.VK_WINDOWS);
        rob.keyRelease(KeyEvent.VK_SHIFT);
        rob.keyRelease(KeyEvent.VK_S);
        //mouse dragging
        rob.mouseMove(0,0);
        rob.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        rob.mouseMove(1000,300);
        rob.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

         */
        //single monitor config
        Robot rob = new Robot();
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many columns of pixels would you like to scan?");
        int precision = scanner.nextInt();
        int increment = (840/precision);
        int greatestY = 0;
        Color white = new Color(255,255,255);
        long curTime = System.currentTimeMillis();
        for(int x = 430; x <= 1250;x+=increment){
            System.out.println(x);
            for(int y = 100; y <= 1050;y+=30){
                if(!rob.getPixelColor(x,y).equals(white) && y > greatestY){
                    greatestY = y;
                }
            }
        }
        long pastTime = System.currentTimeMillis();
        System.out.println(pastTime-curTime);
        rob.delay(100);
        //top-left full screen position
        rob.mouseMove(420,45);
        //bottom right full screen position
        rob.mouseMove(1260,greatestY+20);
        System.out.println(rob.getPixelColor(1260,45));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double h = screenSize.getHeight();
        double w = screenSize.getWidth();
        System.out.println(h + ", " + w);
        //multi monitor config
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
        System.out.println(height + ", " + width);
    }
}
