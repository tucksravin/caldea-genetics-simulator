/*
A gene represents a point in the genome that can have either an effect on
fitness in the population, or just exist.

Fitness of heterozygote
Fitness of homozygote One
Fitness of homozygote Two
*/

public class Gene
{
private boolean alleleOne;
private boolean alleleTwo;
private int fitHet;
private int fitHomOne;
private int fitHomTwo;

public int fitness()
  {
    if(alleleOne&&alleleTwo)
      return fitHomOne;

    else if(!(alleleOne||alleleTwo))
      return fitHomTwo;

    else
      return fitHet;
  }

public Gene(boolean one, boolean two, int het, int homOne, int homTwo)
  {
    alleleOne = one;
    alleleTwo = two;
    fitHet = het;
    fitHomOne = homOne;
    fitHowTwo = homTwo;
  }
}
