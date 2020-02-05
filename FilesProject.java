/*
 * Name: Rayshaad Thomas
 * ID: 892564854
 * Lab Section: 1
 * Lab Assignment 1
 * Submission time: 6:02
 */
package filesproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Random;

/**
 *
 * @author rtho137
 */
public class FilesProject
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException 
    {
        Scanner in = new Scanner (System.in);
        
        System.out.print("Please enter the number of files: ");
        int numFiles = in.nextInt();
        
        System.out.print("Enter the size of your file: ");
        int sizeFiles = in.nextInt();
        
        populateFiles (numFiles, sizeFiles);
        calculateStat (numFiles, sizeFiles);
    }
    /**
     *
     * @param N
     * @param S
     * @throws java.io.FileNotFoundException
     */
    @SuppressWarnings("empty-statement")
    //populates a number of files with a random amount of integers between 1 and 10.
    public static void populateFiles (int N, int S) throws FileNotFoundException 
    {
        for(int i=1; i<=N; i++)
        {
            PrintWriter outFile = new PrintWriter("numbers_" + i + ".txt");
            Random rand = new Random();
            
            for (int j=0; j<S; j++)
            {
                outFile.println(rand.nextInt(9) + 1);
            }  
            
        outFile.close();
        }
    }
    //reads files and calculates summation and mean of the numbers inside the file.
    public static void calculateStat (int N, int S) throws FileNotFoundException
    {
        PrintWriter outFile = new PrintWriter("stats.txt");
        
        for (int i=1; i<=N; i++)
        {
            File inputFile = new File("numbers_" + i + ".txt");
            Scanner in = new Scanner(inputFile);
            
             int sum = 0;
            
            while(in.hasNextInt())
            {
                sum += in.nextInt();
            }              
            double average = (double)sum/S;
            outFile.printf("%s\t%d\t%.3f%n", "number_" + i + ".txt", sum, average);
        }
        outFile.close();
    }  
}
