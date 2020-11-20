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

getPop()
returns population of that Caldean

seqGenome()
returns genome

marriage()
if eld and correct age, searches for du of correct age and sex
if du,

mortality()
returns chance of death, given age



*/

public class Caldean{

  private int birthYear;
  private boolean elder;
  private boolean female;
  private House family;
  private Caldean spouse;
  private LinkedList<Locus> myGenes;
  private Random fate;
  private Population myCity;

//natural Caldean
public Caldean(Caldean rex, Caldean is)
{
  myCity = rex.getPop();
  birthYear = myCity.getYear();
  family = rex.getHouse();
  female = myCity.fate.nextBoolean();
  myGenes = rex.mixGametes();
  elder = !family.hasEld();

}

//artificial Caldean
public Caldean(int a, boolean e, boolean f, House fam, LinkedList<Locus> mG, Population pop)
{
  birthYear = a;
  elder = e;
  female = f;
  family = fam;
  family.addMember(this);
  myGenes = mG;
  myCity = pop;
}


//advances year, checks if the caldean will die, will get married, or have children
//which are the things that this simulation cares about
public void anotherYear()
{
  //System.out.println("anotherYear run");

  if(elder)
  {
    if(lonely())
      marriage();

    if(spouse!=null && horny())
      family.baby();
  }

  if(mortality())
    die();
}

//mix genes with spouse and presents a new genome
public LinkedList<Locus> mixGametes()
{
  LinkedList<Locus> united = new LinkedList<Locus>();
  LinkedList<Locus> is = spouse.getGenome();

  Iterator<Locus> rexStrand = myGenes.iterator();
  Iterator<Locus> isStrand = is.iterator();

  while(rexStrand.hasNext())
    {
      Locus curr = rexStrand.next();
      united.add(new Locus(curr.getGene(), curr.gamete(myCity), isStrand.next().gamete(myCity)));
    }

  return united;
}


//Find data for this, for now, everbody is getting married at 20
private boolean lonely()
{
  if(spouse!=null||!family.hasEld())
    return false;
  else if(age()>19)
    return true;
  else
    return false;
}

//sends to datingScene, which checks the population for matches.
//right now datingScene is a stub, so just marries this back to itself.
public void marriage()
{
  spouse = myCity.datingScene(this);
  family.succession(spouse);
}


public House getHouse()
{
  return family;
}

public int getRank()
  {
    return family.getRank();
  }

public Population getPop()
{
  return myCity;
}


public LinkedList<Locus> getGenome()
{
  return myGenes;
}

public void die(){
  family.aDeathInThe(this);
}


//STUB: haven't implemented
private boolean horny(){
  return false;
}

private boolean mortality(){
  double chanceOfDeath = myCity.lifeTables(female, age());
  double theReaper = myCity.fate.nextDouble() * 1000;

  return theReaper > chanceOfDeath;
}

//for testing
public void arrangedMarriage(Caldean betrothed)
{

  spouse = betrothed;
  family.succession(spouse);
  spouse.becomeIs(this);
}

public void becomeIs(Caldean rex){
  spouse = rex;
  family = rex.getHouse();
}

public int age()
{
  return myCity.getYear()-birthYear;
}



//outputs a string that describes who this caldean is and accesses their genome
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

  output = output + "of House " + getRank() + " risen from "+ family.getInitialRank() + ".";
  output = output + "\n They are " + age() + " years old. \n \n";
  /*
  output = output + "Their genome is as follows: \n";

  Iterator<Locus> genome = myGenes.iterator();
  int i = 1;
  while(genome.hasNext())
  {
    output = output + "Gene "+ i + "\n" + genome.next().toString() +"\n \n";
    i++;
  }
  */

  return output;
}

}
