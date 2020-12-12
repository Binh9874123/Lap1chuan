
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Reader {
    static boolean EOF ;
    public Reader(){EOF = false;}
    public boolean EOFCheck() {return EOF;}

    public byte[] Read(String ArgPath , int ReadBytesCount)throws IOException
    {
        File file = new File(String.valueOf(ArgPath));
        FileInputStream reader = null;
        byte[] buf = null;
        int temp = 0 ;
        try
        {
            reader = new FileInputStream(file);
            int c ;
            buf = new byte[(int)(file.length())];
            while ((c = reader.read(buf))!= -1 && temp < ReadBytesCount)
            {
                temp++;
            }
            if(c == -1)
                EOF = true ;



        } catch(IOException ex)
        {
            System.out.print("Err");
        }
        return buf ;

    }
}
