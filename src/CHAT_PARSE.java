/**
 * Created by err0rless on 2015-10-13.
 * github.com/err0rless/Fuck-Java-Chat
 *
 * Parser
 *  .emoticons
 *  .images or files
 *  .e-mails
 *  .string
 */

import java.util.regex.*;

public class CHAT_PARSE
{
    private String keywords[] = {"(lol)", "(good)", "(bad)",
                                 "(what)", "(notgood)", "(prettygood)"};
    
    private String emoticon[] = {"XD", ":)", ":(",
                                 ":/", ":<", ":>"};

    CHAT_PARSE(){}

    public String Parse_string(String str)
    {
        final String EmoticonRegex = "\\([A-z]+\\)"; // "(emoticon)"

        Pattern p = Pattern.compile(EmoticonRegex);
        Matcher m = p.matcher(str);

        if (m.find(0))
        {
            return Parse_Emoticon(str);
        }
        else
        {
            return str;
        }
    }

    private String Parse_Emoticon(String str)
    {
        Pattern p = Pattern.compile("\\([A-z]+\\)"); // "(emoticon)"
        Matcher m = p.matcher(str);

        String s = "", t = "", e[];
        boolean emot = false;

        while (m.find()) s += m.group(0) + " ";

        str = m.replaceAll("(EMOTICON)");

        e = s.split(" ");
        for (int i = 0; i < e.length; i++)
        {
            for (int j = 0; j < keywords.length; j++)
            {
                if (e[i].equalsIgnoreCase(keywords[j]))
                {
                    t = emoticon[j];
                    emot = true;
                    break;
                }
            }

            if (!emot) t = e[i];
            emot = false;

            str = str.replaceFirst("\\(EMOTICON\\)", t);
        }

        return str;
    }
}