
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ReadingPoints {

    public static String fileName = "/Users/johnchandlerphillips/Desktop/inputfile.txt";
    public static String outputFileName = "/Users/johnchandlerphillips/Desktop/outputfile.txt";
    public static List<Point> pointList = new ArrayList<Point>();

    public static void readFileContents() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(fileName)); //reading files in specified directory
        String ln;
        while ((ln = br.readLine()) != null) //file reading
        {
            String[] values = ln.split(",");
            double xConvert = Double.parseDouble(values[0]);
            double yConvert = Double.parseDouble(values[1]);
            pointList.add(new Point(xConvert, yConvert));
            
        }
    }
    
    public static void writeFileContents() throws IOException {
        try {
            // Assume default encoding.
            FileWriter fileWriter
                    = new FileWriter(outputFileName);

            // Always wrap FileWriter in BufferedWriter.
            PrintWriter bufferedWriter
                    = new PrintWriter(fileWriter);
            

            // Note that write() does not automatically
            // append a newline character.
            for (Point p : pointList) {
                String stringX = String.valueOf(p.x);
                String stringY = String.valueOf(p.y);
                bufferedWriter.println(stringX + "," + stringY);
            }

            // Always close files.
            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println(
                    "Error writing to file '"
                    + outputFileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }
    

    public static void main(String[] args) {
        try {
            readFileContents();
        } catch (IOException e) {
            System.out.println("File not found.\n");
        }

        // Print to console.
        for (Point p : pointList) {
            System.out.println(p.x + " " + p.y);
        }

        try {
            writeFileContents();
        } catch (IOException e) {
            System.out.println("Cannot write.\n");
        }
    }
}