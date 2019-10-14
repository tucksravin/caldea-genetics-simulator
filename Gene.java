
/*
A gene represents a point in the genome that can have either an effect on
fitness in the population, or just exist.




*/

import java.util.Random;

public class Gene
{

//Mendelian genetics, with only two alleles.
//False is the rarer allele, true is WT.
private boolean alleleOne;
private boolean alleleTwo;

//original frequency of the rarer allele
private int originalRarity;

//Fitness of heterozygote (gtype 3)
private int fitHet;

//Fitness of homozygote One(gtype 1)
private int fitHomOne;

//Fitness of homozygote Two(gtype 2)
private int fitHomTwo;


//constructs gene when given all variables
//(the macrocreation of a Gene is done in the population constructor)
public Gene(boolean one, boolean two, int het, int homOne, int homTwo)
  {
    alleleOne = one;
    alleleTwo = two;
    fitHet = het;
    fitHomOne = homOne;
    fitHowTwo = homTwo;
  }

public int genotype()
  {
    if(alleleOne&&alleleTwo)
      return 1;

    else if(!(alleleOne||alleleTwo))
      return 2;

    else
      return 3;
  }

public int fitness()
{
  int g = genotype();
  if(g==1)
    return fitHomOne;
  if(g==2)
    return fitHomTwo;
  else
    return fitHet;
}

public boolean gamete()
{
  Random fate = new Random();

  if(fate.nextBoolean())
    return alleleOne;
  else
    return alleleTwo;
}

public String toString()
{
  int g = genotype();
  String output = new String("This individual is ");

  if(g==1||g==2)
  {
    output = output+ "homozygous for the ";
    if(g==1)
      output = output + "wildtype allele. ";
    else
      output = output + "rare allele. ";
  }
  else
    output = output + "a heterozygote. ";

  int f=fitness();

  if(f==100)
    output = output + "This has no signicant fitness effect. %n";
  else
  {
    output = output + "This gives a fitness ";

    if(f<100)
      output = output + "disadvantage of ";
    else
      output = output + "advantage of ";

    output = output + Math.abs(100-f) + " points. %n"
  }


}
}
