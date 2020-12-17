package basic.exception.logging;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName LoggingExceptions2
 * @date 2020/1/7 11:29
 */
public class LoggingExceptions2 extends Exception {
    public static Logger logger = Logger.getLogger("LoggingExceptions2");

    static void logException(Exception e){
        StringWriter s = new StringWriter();
        e.printStackTrace(new PrintWriter(s));
        logger.severe(s.toString());
    }

    public static void main(String[] args){
      try {
          throw new NullPointerException();
      }catch (NullPointerException e){
          logException(e);
      }
    }
}
