
/*
A gene represents a point in the genome that can have either an effect on
fitness in the population, or just exist.

Fitness of heterozygote
Fitness of homozygote One
Fitness of homozygote Two
*/

import java.util.Random;

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

public int getFitHet()
{
  return fitHet;
}

public int getFitHomOne()
{
  return fitHomOne;
}

public int getFitHomTwo()
{
  return fitHomTwo;
}

public boolean gamete()
{
  Random fate = new Random();

  if(fate.nextBoolean())
    return alleleOne;
  else
    return alleleTwo;
}
}
