import javax.swing.*;
import java.util.HashMap;

public class Main
{
    public static void main(String[] args)
    {
        HashMap<String, JFrame> textFrames = new HashMap<>();
        HashMap<String, JTextArea> textDisplays = new HashMap<>();
        Server chat = new Server();
        User user1 = new User();
        String userID = chat.addChat();
        user1.createWindow(userID,textFrames ,textDisplays);
        User user2 = new User();
        userID = chat.addChat();
        user2.createWindow(userID,textFrames, textDisplays);
        User user3 = new User();
        userID = chat.addChat();
        user3.createWindow(userID,textFrames, textDisplays);
    }
}