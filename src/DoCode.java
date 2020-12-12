import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DoCode {
    static ArrayList<String> config1 = new ArrayList<String>();
    public static byte[] ReadTable(String Arg , byte[]buf)
    {
        File file = new File(String.valueOf(Arg));
        FileInputStream reader = null;
        int temp = 0 ;
        try
        {
            reader = new FileInputStream(file);
            List<Integer> s1 = new ArrayList<Integer>();
            List<Integer> s2 = new ArrayList<Integer>();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(reader));
            String c;
            while ( ( c = bufferedReader.readLine()) != null )
            {
               s1.add((int)c.charAt(0));
               s2.add((int)c.charAt(2));
            }
            for(int i = 0 ; i < buf.length ; i++) {

                    for(int j = 0 ; j < s1.size() ; j++) {

                        if (buf[i] == s1.get(j)) {
                            buf[i] = s2.get(j).byteValue();

                        }
                    }

            }




        } catch(IOException ex)
        {
            System.out.print("Err");
        }
        return buf;



    }
}
