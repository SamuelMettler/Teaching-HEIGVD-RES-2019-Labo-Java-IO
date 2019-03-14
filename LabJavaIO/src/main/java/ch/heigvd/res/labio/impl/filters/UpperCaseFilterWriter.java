package ch.heigvd.res.labio.impl.filters;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author Olivier Liechti
 */
public class UpperCaseFilterWriter extends FilterWriter {
  
  public UpperCaseFilterWriter(Writer wrappedWriter) {
    super(wrappedWriter);
  }

  @Override
  public void write(String str, int off, int len) throws IOException {
    String sub = str.toUpperCase();
    super.write(sub, off, len);
  }

  @Override
  public void write(char[] cbuf, int off, int len) throws IOException {
    String cbuf2 = new String(cbuf);
    cbuf2 = cbuf2.toUpperCase();
    super.write(cbuf2, off, len);
  }

  @Override
  public void write(int c) throws IOException {
    if(Character.isAlphabetic(c) || c == ' ')
      super.write(Character.toUpperCase(c));
  }

}
