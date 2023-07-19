package Utils;
import java.io.*;
public class TextReader {
    private BufferedReader inputReader;
    public TextReader(String filePath){
        try {
            inputReader = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    public int readNextChar(){
        try {
            return inputReader.read();
        } catch (IOException e){
            return -1;
        }
    }

    public void close(){
        try {
            inputReader.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
