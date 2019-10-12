import java.util.Random;
import java.util.Scanner;

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
  private boolean sex;
  private boolean firstChild;
  private boolean secondChild;
  private House family;
  private Caldean spouse;
  private LinkedList<Gene> myGenes;
  private Random fate;

//natural Caldean
public Caldean(Caldean eld, Caldean du)
{
  fate = new Random();
  age = 0;
  firstChild=false;
  secondChild=false;
  family = eld.getHouse();
  sex = fate.nextBoolean();
  myGenes = eld.mixGametes();
}

//artificial Caldean
public Caldean(int a, boolean e, boolean s, House fam, Genome mG)
{
  fate = new Random();
  age = a;
  elder = e;
  sex = s;
  family = fam;
  myGenes = mG;
}

//returns house
public House getHouse()
{
  return family;
}

//mix genes with spouse
public Genome mixGametes()
{

}

}
