
import java.io.*;


public class EncodingConverter {
    public void EConverter(String inputFile, String outputFile, String firstEncoding, String secondEncoding){
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), firstEncoding));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), secondEncoding));
            String s;
            while((s = br.readLine()) != null){
                bw.write(s);
                bw.flush();
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
