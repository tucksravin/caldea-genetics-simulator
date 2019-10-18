import java.util.*;

/*
A gene represents a point in the genome that can have either an effect on
fitness in the population, or just exist.




*/

import java.util.Random;

public class Gene
{

//original frequency of the rarer allele
private int originalRarity;

//Fitness is out of 1000

//Fitness of heterozygote (gtype 3)
private int fitHet;

//Fitness of homozygote One(gtype 1)
private int fitHomOne;

//Fitness of homozygote Two(gtype 2)
private int fitHomTwo;


//constructs gene when given all variables
//(the macrocreation of a Gene is done in the population constructor)
public Gene( int homOne, int het, int homTwo, int originalRarity)
  {
    fitHet = het;
    fitHomOne = homOne;
    fitHomTwo = homTwo;
  }



public int fitness(int g)
{

  if(g==1)
    return fitHomOne;
  if(g==2)
    return fitHomTwo;
  else
    return fitHet;
}

public String toString()
{
  String output = new String("Original frequency of the rare allele was ");
  output = output + originalRarity + " percent. ";

    output = output + "Homozygous WT fitness is " + fitHomOne + " percent. ";

    output = output + "Homozygous rare fitness is " + fitHomTwo + " percent. ";

    output = output + "Heterozygous fitness is " + fitHet + " percent. ";

    return output;

}


}
