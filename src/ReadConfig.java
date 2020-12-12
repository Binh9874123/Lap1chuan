import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.BufferedReader;
public class ReadConfig {
    private final static String[] token = {"INPUT" , "OUTPUT" ,"TABLE", "BUFFER"};
    private static enum tokenEn {INPUT , OUTPUT ,TABLE , BUFFER };
    private static String INPUT;
    public final String GetInput()
    {
        return INPUT;
    }
    private static String OUTPUT;
    public final String GetOutput()
    {
        return OUTPUT;

    }
    private static String TABLE;
    public final String GetTable()
    {
        return TABLE;

    }
    private static String BUFFER;
    public final int GetBuffer()
    {
        return Integer.parseInt(BUFFER);
    }
    public static boolean IsInt(String str)
    {
        try{
            Integer.parseInt(str);
            return true ;
        }catch (NumberFormatException e ){
            return false;
        }
    }
    public static boolean IsFile(String str)
    {
        File file = new File(str);
        if(file.exists() && !file.isDirectory() )
        {
            return true ;
        }
        else {
            return false;
        }
    }


    public static boolean Read(String Arg )throws IOException {

        int count = 3;
        FileInputStream fileInputStream = null;
        BufferedReader bufferedReader = null;
        ArrayList<String> config1 = new ArrayList<String>();
        //String[] config1 = new String[3];

        try {
            fileInputStream = new FileInputStream(Arg);
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String c;

            while ((c = bufferedReader.readLine()) != null) {
                config1.add(c);


            }

        } catch (FileNotFoundException ex) {
            System.out.print("Err");
        } catch (IOException ex) {

            System.out.print("Err");
        }
        ArrayList<ArrayList<String>> config2 = new ArrayList<ArrayList<String>>();
        for (String i : config1) {
            String[] S = i.split("\\s");
            ArrayList<String> config3 = new ArrayList(Arrays.asList(S));
            config2.add(config3);

        }
        for(ArrayList<String> arr : config2) {
            if (arr.get(0).equals(token[tokenEn.INPUT.ordinal()])) {
                INPUT = arr.get(2);
            }
            if (arr.get(0).equals(token[tokenEn.OUTPUT.ordinal()])) {
                OUTPUT = arr.get(2);
            }
            if (arr.get(0).equals(token[tokenEn.TABLE.ordinal()])) {
                TABLE = arr.get(2);
            }
            if (arr.get(0).equals(token[tokenEn.BUFFER.ordinal()])) {
                BUFFER = arr.get(2);
            }

        }

        if(IsInt(BUFFER) && IsFile(INPUT) && IsFile(TABLE))
        {

            return true;
        }
        else
        {
            System.out.println("Err.Can't do anything");
            return false;
        }
    }










}
