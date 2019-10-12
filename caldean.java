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
  private boolean oneChild;
  private boolean twoChild;
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
  if(eld.firstKid())
    oneChild = false;
  else
    oneChild = true;
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

//mix genes with spouse
public LinkedList<Gene> mixGametes()
{
  LinkedList<Gene> united = new LinkedList<Gene>();
  LinkedList<Gene> eldGenome = eld.getGenome();
  LinkedList<Gene> duGenome = du.getGenome();

  Iterator eldGamete = new eld.iterator();
  Iterator duGamete = new du.iterator();

  while(eldGamete.hasNext())
    {
      Gene curr = eldGamete.next();
      united.add(new Gene(curr.gamete(),duGamete.next().gamtete(), curr.getFitHet(), curr.getFitHomOne(), curr.getFitHomTwo()));
    }


}

public House getHouse()
{
  return family;
}

public boolean firstKid()
{
  return firstChild;
}

public LinkedList<Gene> getGenome()
{
  return myGenes;
}


}
