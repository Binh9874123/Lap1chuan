import java.io.FileOutputStream;
import java.io.IOException;

public class Writer {
    public void Write(String arg , byte[] str )throws IOException
    {
        FileOutputStream out = new FileOutputStream(arg);
        out.write(str);
        out.close();
    }
}
