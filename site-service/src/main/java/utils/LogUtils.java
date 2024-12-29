package utils;

/**
 * @author wfli
 * @since 2024/12/29 15:37
 */
public class LogUtils
{
    public static String getBlock(Object msg)
    {
        if (msg == null)
        {
            msg = "";
        }
        return "[" + msg.toString() + "]";
    }
}

