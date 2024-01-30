import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class helloworld {
    public static void main(String[] args) {
        try {
            Robot robot = new Robot();
            
            // Simulate pressing 'H', 'e', 'l', 'l', 'o', ',', ' ', 'W', 'o', 'r', 'l', 'd', '!'
            typeString(robot, "I Hate You");
            
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
    
    public static void typeString(Robot robot, String text) {
        char[] characters = text.toCharArray();
        for (char c : characters) {
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
            if (KeyEvent.CHAR_UNDEFINED != keyCode) {
                robot.keyPress(keyCode);
                robot.keyRelease(keyCode);
            }
        }
    }
}
