/*
Name: Harlan Chang
Class: CS20B
Assignment: Project 1
*/
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Project1
{
	public static void main(String [] args)
	{
		try
		{
			Scanner sc = new Scanner(System.in); //used to get the input from the user for the file name
			String inputFile; //name of the file
			String line; //used to store each line of the input file
			char ch; //used to store each character in the line
			int letters = 0;
			int whiteSpace = 0;
			int digits = 0;
			int others = 0;
			int total = 0;
			double perLetter = 0;
			double perWhite = 0;
			double perDig = 0;
			double perOther = 0;
			
			System.out.print("Please enter file name: ");
			inputFile = sc.next(); //gets the file name
			
			File inputF = new File(inputFile); //used to get the input file 
			sc = new Scanner(inputF); //changes the scanner to read from the input file instead because we no longer need it to read input from the user
			
			while(sc.hasNextLine()) //checks to make sure there's a next line before getting it
			{
				line = sc.nextLine(); //gets each line from the input file 
				for(int i = 0; i < line.length(); i++) 
				//runs through every character of the line and checks to see what it is 
				{
					ch = line.charAt(i);
					if(((ch >= 65)&&(ch <= 90))||((ch >= 97)&&(ch<=122)))
					//check if it is either a lowercase or uppercase letter
					{
						letters++; //increases if its a letter
					}
					else if(ch == 32) //checks for a space
					{
						whiteSpace++; //increases for a white space
					}
					else if((ch >= 48)&&(ch<= 57)) //checks for numbers
					{
						digits++; //increases if theres a number
					}
					else
					{
						others++; //all other characters
					}
					total++; //gets the total characters so that we can divide by it to find a percentage
				}
			}
			
			perLetter = ((double)letters/total)*100; //converts to a percentage
			perWhite = ((double)whiteSpace/total)*100; //converts to a percentage
			perDig = ((double)digits/total)*100; //converts to a percentage
			perOther = ((double)others/total)*100; //converts to a percentage
			
			System.out.println("Statistics for file: " + inputFile);
			System.out.println("----------------------------------------------");
			System.out.println("Total # of characters in file: " + total);
			System.out.println("Category          How Many?       % of file");
			System.out.printf("Letters           " + letters + "              %.2f%%\n",perLetter);
			System.out.printf("White Space       " + whiteSpace + "              %.2f%%\n",perWhite);
			System.out.printf("Digits            " + digits + "               %.2f%%\n",perDig);
			System.out.printf("Other Characters  " + others + "               %.2f%%\n",perOther);
		}
		catch(FileNotFoundException exception)
		{
			System.out.println("That file does not exist"); //error message if the file the user inputs is not a valid input 
		}
	}
}