package ch.heigvd.res.labio.impl;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Olivier Liechti
 */
public class Utils {

  private static final Logger LOG = Logger.getLogger(Utils.class.getName());

  /**
   * This method looks for the next new line separators (\r, \n, \r\n) to extract
   * the next line in the string passed in arguments. 
   * 
   * @param lines a string that may contain 0, 1 or more lines
   * @return an array with 2 elements; the first element is the next line with
   * the line separator, the second element is the remaining text. If the argument does not
   * contain any line separator, then the first element is an empty string.
   */
  public static String[] getNextLine(String lines) {
    String[] ret = new String[2];

    Pattern toFind = Pattern.compile("\r\n|\n|\r");
    Matcher matched = toFind.matcher(lines);

    if(matched.find()){
      ret[0] = lines.substring(0, matched.end());
      ret[1] = lines.substring(matched.end());
    }
    else{
      ret[0] = "";
      ret[1] = lines;
    }
    //throw new UnsupportedOperationException("The student has not implemented this method yet.");
    return ret;
  }

}
