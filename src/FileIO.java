import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO
{
    public void saveData(ArrayList<String> data, String path, String header)
    {
        try
        {
            // Create a FileWriter object to write to the specified file path
            FileWriter writer = new FileWriter(path);

            // Write the header line followed by a newline
            writer.write(header + "\n");

            // Iterate over each string in the data list and write it to the file
            for (String s : data)
            {
                writer.write(s + "\n");
            }

            // Close the writer
            writer.close();

        } catch (IOException e)
        {
            // Handle exceptions related to file writing errors
            System.err.println("Could not write file");
        }
    }

    public ArrayList<String> readData(String path)
    {
        // Initialize an ArrayList to hold the lines read from the file (excluding header)
        ArrayList<String> data = new ArrayList<>();
        File file = new File(path);

        try
        {
            // Create a Scanner object to read from the file
            Scanner scan = new Scanner(file);

            if(scan.hasNextLine()) // Check if header line exists before skipping
                scan.nextLine();   // Skip the header line

            // Read each remaining line and add it to the data list
            while (scan.hasNextLine())
            {
                String line = scan.nextLine();
                data.add(line);
            }

        }
        catch (FileNotFoundException e)
        {
            // Handle case where the file does not exist or can't be found
            System.out.println("File not found: " + path);
        }

        // Return the list of data lines (without header)
        return data;
    }

}

