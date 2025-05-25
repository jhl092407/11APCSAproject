import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;
public class Solrunner
{
  	public static void main(String [] args)
	{
	  double volume = 0;
	  ArrayList<chemicalSample> chemicals = new ArrayList<chemicalSample>();
	  boolean check = true;
		Scanner scan = new Scanner(System.in);
		System.out.println("Salutations huzz, we are making a solution today. What will the volume be in litres");
		volume = scan.nextDouble();
		System.out.println("Now add the samples to be dissolved");
		double KaKb = 1.0;
    String substance = "H";
    double mass = 0;
    double MolarMass = 1;
    boolean isAcid = true;
		while(check)
		{
		  System.out.println("Enter substance formula");
		  System.out.println("Add underscores to denote substcripts.\nexample: H_2SO_4 would be sulfuric acid");
		  substance = scan.nextLine();
		  System.out.println("Enter the Ka/Kb of the substance");
		  KaKb = scan.nextDouble();
		  System.out.println("Enter the mass in grams");
		  mass = scan.nextDoublet();
		  System.out.println("Enter the molar mass in g/mol");
		  MolarMass = scan.nextDouble(); 
		  System.out.println("is this substance an Acid? \nEntern true for yes and false for no");
		  isAcid = scan.nextBoolean();
		  chemicals.add(new chemicalSample(substance, isAcid, mass, MolarMass, KaKb));
		  System.out.println("would you like to put something else in solution? true/false")
		  check = scan.nextBoolean();
		}
		Solution s = new Solution(chemicals, volume);
		s.setConcentrations();
		s.calculatepH();
		s.outputSolution();
	}
}