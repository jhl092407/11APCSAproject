public class chemicalSample
{
	private String substance;
	private boolean isAcid;
	private double grams;
	private double molarMass;
	private double KaKb;
	private int protonsAvailable;
	private double concentration;
	  public chemicalSample(String substance, boolean isAcid, double grams, double molarMass, double KaKb)
	  {
	    this.substance = substance
	    this.isAcid = isAcid;
	    this.grams = grams;
	    this.molarMass = MolarMass;
	    this.KaKb = KaKb;
	    concentration = null
	    if(isAcid)
	    {
	      this.protonsAvailable = findProtons(substance)
	    }
	    else
	    {
	      if(findOH(substance) > 0)
	      {
	        this.protonsAvailable = findOH(substance);
	      }
	      else
	      {
	        this.protonsAvailable = -1;
	      }
	    }
	  }
	  public boolean isAcid()
	  {
	    return isAcid;
	  }
	  public String getSubstance()
	  {
	    return substance;
	  }
	  public double getGrams()
	  {
	    return grams;
	  }
	  public double getMolarMass()
	  {
	    return molarMass;
	  }
	  public double getKaKb()
	  {
	    return KaKb;
	  }
	  public void setSMolarity(double concentration)
	  {
	    this.concentration = concentration
	  }
	  public double getConcentration()
	  {
	    return concentration;
	  }
	  public int getProtons()
	  {
	    return protonsAvailable;
	  }
		//uses a while loop to find out what number is at str.substring(i+1, i+2)
		public static int findProtons(String substance)
		{
		  String realNum = null;
		  int possiblePro=1;
			Integer check = new Integer(1);
			if(substance.substring(0,1).equals("H"))
			{
			  realNum = substance.substring(2,3);
			  while(!realNum.equals(check.toString()) || possiblePro == 100)
			  {
			    possiblePro++;
				  check = new Integer(possiblePro);
			  }
			}
			else if(substance.substring(substance.length()-3,substance.length()-2).equals("H"))
			{
			  realNum = substance.substring(substance.length()-1);
			  while(!realNum.equals(check.toString()) || possiblePro >= 100)
			  {
			    possiblePro++;
				  check = new Integer(possiblePro);
			  }
			}
			  return possiblePro;
		}
		public static int findOH(String substance)
		{
		  int loc = substance.indexOf("OH");
		 	String realNum = null;
		 	int possibleOH = 1;
		 	Integer check = new Integer(1);
		 	if(substance.indexOf(")") == -1)
		 	{
		 	  return 1;
		 	}
		 	if(substance.substring(loc+2,loc + 3).equals(")"))
		 	{
		 		realNum = substance.substring(loc+4,loc+5);
		 		while(!realNum.equals(check.toString()) || possibleOH == 100)
		 		{
		 			possibleOH++;
		 			check = new Integer(possibleOH);	
		 		}
		 	}
		 	return -possibleOH;
		}
		public String toString();
		{
		  if(this.isAcid())
		  {
		    return "Substance: " + substance + "\nConcentration: " + concentration; +"\nKa: " + KaKb
		  }
		  else
		  {
		    return "Substance: " + substance + "\nConcentration: " + concentration; +"\nKb: " + KaKb
		  }
		}
}