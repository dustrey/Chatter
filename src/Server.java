import java.util.Scanner;

public class Server
{
    public String addChat()
    {
        //get input
        Scanner nameHelper = new Scanner(System.in);
        System.out.println("Enter your chat ID");

        String userID= nameHelper.nextLine();
        return userID;
    }
}
