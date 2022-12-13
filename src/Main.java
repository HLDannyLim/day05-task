import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        String publisher = "" ;
        Scanner sr = new Scanner(System.in);
        publisher = sr.nextLine();
        readfile(publisher);

    }

    public static void readfile(String publisher) throws IOException{
        HashMap<String , List<String>> bookMap = new HashMap<String , List<String>>();
        String line ;
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\lim_d\\src\\day05-task\\books.csv"));
        
        while((line=br.readLine()) != null){
            String[] arrList ;
            ArrayList <String> bookDetails = new ArrayList<String>();
            arrList = line.split(",");

            for(String w:arrList){
                bookDetails.add(w);
            }
            bookMap.put(bookDetails.get(0), bookDetails);

        }
        br.close();

        File file = new File("C:\\Users\\lim_d\\src\\day05-task\\wtitefile.txt");
        // System.out.printf("\n\n> %s", bookMap.get("bookID"));
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        // Save the contents for this user in Map to a file.

        for(String w : bookMap.keySet()){
            List<String> bookDetailss = new ArrayList<String>();
            bookDetailss = bookMap.get(w);
            if(bookDetailss.contains(publisher)){
                System.out.println(bookMap.get(w)); 
                bw.write(bookMap.get(w) +"\n");
            }
        }
        fw.flush();
        fw.close();
    }



}
