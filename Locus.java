import java.util.*;

/*
The locus class simply stores two booleans and the Gene that it is a representative of.
It represents the specific alleles a Caldean may have.
*/

public class Locus
{

  //Mendelian genetics, with only two alleles.
  //False is the rarer allele, true is WT.
  private boolean a;
  private boolean b;
  Gene g;

  Locus(Gene whatAmI, boolean first, boolean second)
  {
    g = whatAmI;
    a=first;
    b=second;
  }

  public Gene getGene()
  {
    return g;
  }

  public int genotype()
    {
      if(a&&b)
        return 1;

      else if(!(a||b))
        return 2;

      else
        return 3;
    }


  public boolean gamete()
  {
    Random fate = new Random();

    if(fate.nextBoolean())
      return a;
    else
      return b;
  }

  public String toString()
  {
    int gt = genotype();
    String output = new String("This individual is ");

    if(gt==1||gt==2)
    {
      output = output+ "homozygous for the ";
      if(gt==1)
        output = output + "wildtype allele. ";
      else
        output = output + "rare allele. ";
    }
    else
      output = output + "a heterozygote. ";

    int f=g.fitness(gt);

    if(f==100)
      output = output + "This has no signicant fitness effect. \n";
    else
    {
      output = output + "This gives a fitness ";

      if(f<100)
        output = output + "disadvantage of ";
      else
        output = output + "advantage of ";

      output = output + Math.abs(100-f) + " percent. \n";
    }

      return output;
  }


}
