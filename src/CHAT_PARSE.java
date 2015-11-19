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
        str = Parse_Emoticon(str);
        str = Parse_Email(str);
        str = Parse_phoneNumber(str);

        return str;
    }

    private String Parse_Emoticon(String str)
    {
        Pattern p = Pattern.compile("\\([A-z]+\\)"); // "(emoticon)"
        Matcher m = p.matcher(str);

        if (m.find(0) == false) return str;

        String s = "", t = "", e[];
        boolean emot = false;

        p = Pattern.compile("\\([A-z]+\\)"); // "(emoticon)"
        m = p.matcher(str);
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

            if (emot == false) t = e[i];
            emot = false;

            str = str.replaceFirst("\\(EMOTICON\\)", t);
        }

        return str;
    }

    private String Parse_Email(String str)
    {
        String mail_to;
        final String pattern = "[_a-z0-9-]+@[_a-z0-9-]+.[_a-z0-9-]+";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(str);

        if (m.find(0) == false) return str;

        p = Pattern.compile(pattern);
        m = p.matcher(str);

        while (m.find())
        {
            mail_to = "<a href=\"mailto:"+m.group(0)+"\">";
            str = m.replaceFirst(mail_to + "<font color=blue><i>" + m.group(0) + "</i></font></a>");
        }

        System.out.println(str);
        return str;
    }

    private String Parse_phoneNumber(String str)
    {
        final String pattern = "[0-9]+-[0-9]+-[0-9]+";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(str);

        if (m.find(0) == false) return str;

        p = Pattern.compile(pattern);
        m = p.matcher(str);

        while (m.find())
        {
            str = m.replaceFirst("<font color=orange><i>" + m.group(0) + "</i></font>");
        }

        System.out.println(str);
        return str;
    }
}