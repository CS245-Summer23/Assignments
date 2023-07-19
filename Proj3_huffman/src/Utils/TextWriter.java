package Utils;

import java.awt.geom.IllegalPathStateException;
import java.io.*;

public class TextWriter {
    private BufferedWriter outputWriter;
    public TextWriter(String filePath){
        try {
            outputWriter = new BufferedWriter(new FileWriter(filePath));
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
            System.exit(1);
        } catch(IOException e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    public void writeChar(int c){
        try {
            outputWriter.write((char) c);
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void close(){
        try {
            outputWriter.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
