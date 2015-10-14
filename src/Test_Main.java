/**
 * Created by err0rless on 2015-10-13.
 *
 * Main class for testing
 */

public class Test_Main
{
    public static void main(String args[])
    {
        CHAT_PARSE chatParse = new CHAT_PARSE();
        String chat = "This is not good (notgood), what is it?! (what)";

        //chat = chatParse.Parse_string(chat);
        //System.out.println(chat);

        GUI gui = new GUI(chat);
    }
}