import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;
public class Solution
{
  private ArrayList<chemicalSample> inSolution;
  private double pH;
  private double volume; //in L
  private double Hconcentration;
  private double OHconcentration;
  String strongs = "HClHBrHIH_2SO_4HCLO_4HNO_3NaOHMgOH_2KOHCa(OH)_2RbOHSr(OH)_2CsOHBa(OH)_2FrOHRa(OH)_2";
  
  public Solution(ArrayList<chemicalSample> inSolution, double volume)
  {
    this.inSolution = inSolution;
    this.volume = volume;
    this.setConcentrations();
    this.pH = calculatepH();
  }
  public void addH(double num)
  {
    Hconcentration += num;
  }
  public void addOH(double num)
  {
    OHconcentration+= num;
  }
  public ArrayList<chemicalSample> getSampleList()
  {
    return inSolution;
  }
  public double getpH()
  {
    return pH;
  }
  public void addToSolution(chemicalSample sample)
  {
    SampleList.add(sample);
  }
  public void setConcentrations()
  {
    chemicalSample temp = inSolution.get(0)
    for(int i = 0; i < inSolution.size() i++)
    {
      temp = inSolution.get(i);
      temp.setSMolarity((temp.getGrams()/temp.getMolarMass())/volume);
    }
  }
  public double calculatepH()
  {
    calculateEQ();
    if(OHconcentration > Hconcentratino)
    {
      return 14 - Math.log10(OHconcentration);
    }
    else
    {
      return Math.log10(Hconcentration);
    }
  }
  public void runReaction()
  {
    if(Hconcentration == 0 || OHconcentration == 0)
    {
      return;
    }
    else if(Hconcentration > OHconcentration)
    {
      Hconcentration -= OHconcentration
      OHconcentration = 0;
    }
    else
    {
      OHconcentration -= Hconcentration
      Hconcentration = 0;
    }
  }
  public void calculateEQ()
  {
    chemicalSample x = null;
    double y = null;
    for(int i = 0; i < inSolution.size(); i++)
    {
      if(inSolution.get(i).isAcid())
      {
        y =inSolution.get(i).calculateBreakOff();
        addH(y);
        x = makeConjugate(inSolution.get(i));
        for(int j = 0; j < inSolution.size(); j++)
        {
          if(!(x.getSubstance().equals(inSolution.get(j).getSubstance())))
          {
            inSolution.add(x);
            x.setSMolarity(y);
          }
        }
      }
      else()
      {
        y =inSolution.get(i).calculateBreakOff();
        addH(y);
        x = makeConjugate(inSolution.get(i));
        for(int j = 0; j < inSolution.size(); j++)
        {
          if(!(x.getSubstance().equals(inSolution.get(j).getSubstance())))
          {
            inSolution.add(x);
            x.setSMolarity(y);
          }
        }
      }
      this.runReaction();
    }
  }
  public static double calculateBreakOff(chemicalSample sample)
  {
    if(strongs.indexOf(sample.getSubstance()) > -1)
    {
      if(sample.isAcid())
      {
        return sample.getConcentration();
      }
      else
      {
        return sample.getConcentration() * -sample.findOH();
      }
    }
    if(sample.getProtons() == 0;)
    {
      return 0;
    }
    return Math.sqrt(sample.getKaKb() * sample.getConcentration()); 
  }
  public static chemSample makeConjugate(chemSample sample)
  {
    Scanner scan = new Scanner(System.in);
    double KaKb = null;
    String substance = null;
    double mass = null;
    double MolarMass = null;
    boolean isAcid = null;
    int find= 0;
    if(sample.isAcid())
    {
      Integer x = sample.findProtons();
      find = sample.indexOf("H_" + x.toString())
      if(find == -1 
      && (substance.substring(0,1).equals("H")))
      {
        substance = sample.getSubstance().substring(1);
        isAcid = false;
      }
      else if(find == -1
      && substance.substring(substance.length()-1).equals("H"))
      {
        substance = sample.getSubstance().substring(0,sample.getSubstance().length()-1);
        isAcid = false;
      }
      else if(x == 2)
      {
        substance = "H" + sample.getSubstance().substring(3);
        isAcid = true;
      }
      else
      {
        substance = "H_" + (x -1).toString() + sample.getSubstance().substring(3);
        isAcid = true;
      }
      MolarMass = sample.getMolarMass() - 1.008;
      mass = (sample.getGrams()/sample.getMolarMass())*(MolarMass);
    }
    else
    {
      Integer x = sample.findOH();
      if(strongs.indexOf(sample.getSubstance()) > -1)
      {
        substance = sample.getSubstance().substring(0,sample.getSubstance.indexOf("O"))
        + x.toString() + "+";
        isAcid = true;
        MolarMass = sample.getMolarMass() - (17.008 * -x);
      mass = (sample.getGrams()/sample.getMolarMass())*(MolarMass);
      }
      else if(sample.getSubstance().equals("CH_3COO")
      {
        substance = "CH_3COOH";
        isAcid = true;
        MolarMass = sample.getMolarMass() + 1.008;
      mass = (sample.getGrams()/sample.getMolarMass())*(MolarMass);
      }
      else
      {
        substance = "H" + sample.getSubstance();
        isAcid = true;
        MolarMass = sample.getMolarMass() + 1.008;
      mass = (sample.getGrams()/sample.getMolarMass())*(MolarMass);
      }
    }
    System.out.println("enter the Ka/Kb for the new substance");
    KaKb = scan.nextLine();
    chemicalSample sub = new chemicalSample(substance, isAcid, mass, MolarMass, KaKb);
    return sub;
  }
  public String outputSolution()
  {
    String end = "volume: " + volume + "pH: " + pH + "\n\n";
    for(int i = 0; i < inSolution.size(); i++)
    {
      end += inSolution.get(i).toString();
      end += "\n\n";
    }
  }
}
