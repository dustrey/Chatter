import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
public class User
{
    private JTextArea userText;

    public void createWindow(String userID,  HashMap<String, JFrame> textFrames, HashMap<String, JTextArea> textDisplays)
    {
        //window
        JFrame userFrame = new JFrame(userID);
        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userFrame.setSize(400,300);
        userFrame.setLayout(new BorderLayout());
        userFrame.setLocationRelativeTo(null);

        JPanel textPanel = new JPanel(new BorderLayout()); // panel
        userFrame.add(textPanel, BorderLayout.CENTER);

        //send button
        JButton send = new JButton("Send");
        send.setBounds(75,150,75,45);
        userFrame.add(send, BorderLayout.SOUTH);


        userText = new JTextArea();
        textPanel.add(userText, BorderLayout.SOUTH);
        //add behavior for button
        send.addActionListener(e ->
        {
            String textMessage = userText.getText();
            for(String key : textDisplays.keySet())
            {
                JTextArea textArea = textDisplays.get(key);
                textArea.append(userID + ": " + textMessage + "\n");
                JFrame frame = textFrames.get(key);
                frame.repaint();
            }
            userText.setText("");
        });

        textDisplays.put(userID, new JTextArea());
        textDisplays.get(userID).setEditable(false);

        //scrollbar
        JScrollPane textScroller = new JScrollPane(textDisplays.get(userID));
        textScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        textPanel.add(textScroller, BorderLayout.CENTER);

        textFrames.put(userID, userFrame);
        userFrame.setVisible(true);
    }

}