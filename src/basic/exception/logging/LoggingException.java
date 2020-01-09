package basic.exception.logging;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName loggingException
 * @date 2020/1/6 20:42
 */
public class LoggingException extends Exception {
    public static Logger logger = Logger.getLogger("LoggingException");

    LoggingException(){
        StringWriter stringWriter = new StringWriter();
        printStackTrace(new PrintWriter(stringWriter));
        logger.severe(stringWriter.toString());
    }

    public static void main(String[] args){
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught:"+e);
        }

        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught " + e);
        }

    }
}
