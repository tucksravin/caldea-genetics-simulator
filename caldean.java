import java.util.*;

/*
A caldean object represents an individual caldean living at the time of the simulator.
This simulation prioritizes birth order over gender, so instead of classifying each Caldean as
male or female, they are either eld or du. Additionally, their membership in a house is established
through the progeny method. Partners are determined through the marriage method, and each Caldean
has a simplified, Mendelian genome, running from a to b.

Methods:

eld()
returns true if eld, false if du

getAge()
returns age

getSex()
returns sex

getSpouse()
returns caldeans spouse

getHouse()
returns house

seqGenome()
returns genome

marriage()
if eld and correct age, searches for du of correct age and sex

progeny()
if married, creates new Caldean



*/

public class Caldean{

  private int age;
  private boolean elder;
  private boolean female;
  private boolean firstChild;
  private boolean secondChild;
  private House family;
  private Caldean spouse;
  private LinkedList<Locus> myGenes;
  private Random fate;

//natural Caldean
public Caldean(Caldean eld, Caldean du)
{
  fate = new Random();
  age = 0;
  firstChild=false;
  secondChild=false;
  family = eld.getHouse();
  female = fate.nextBoolean();
  myGenes = eld.mixGametes();
  elder = !eld.firstKid();
}

//artificial Caldean
public Caldean(int a, boolean e, boolean f, House fam, LinkedList<Locus> mG)
{
  age = a;
  elder = e;
  female = f;
  family = fam;
  myGenes = mG;
}

//mix genes with spouse
public LinkedList<Locus> mixGametes()
{
  LinkedList<Locus> united = new LinkedList<Locus>();
  LinkedList<Locus> is = spouse.getGenome();

  Iterator<Locus> rexStrand = myGenes.iterator();
  Iterator<Locus> isStrand = is.iterator();

  while(rexStrand.hasNext())
    {
      Locus curr = rexStrand.next();
      united.add(new Locus(curr.getGene(), curr.gamete(), isStrand.next().gamete()));
    }

  return united;

}

public House getHouse()
{
  return family;
}

public int getRank()
  {
    return family.getRank();
  }

public boolean firstKid()
{
  return firstChild;
}

public LinkedList<Locus> getGenome()
{
  return myGenes;
}

public String toString()
{
  String output = new String();
  output = output + "This is the ";

  if(elder)
    if(spouse==null)
      output = output + "eld";
    else
      output = output + "rex";
  else
    if(spouse==null)
      output=output + "du";
    else
      output=output + "is";


  if(female)
    output = output + "a ";
  else
    output = output +"is ";

  output = output + "of House " + getRank() + " risen from "+ family.getInitialRank();
  output = output + ". Their genome is as follows: %n";

  Iterator<Locus> genome = myGenes.iterator();
  while(genome.hasNext())
  {
    int i = 1;
    output = output + "Gene "+ i + "%n" + genome.next().toString() +"%n %n";
    i++;
  }

  return output;
}

}
