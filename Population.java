import java.util.*;

/*
A Population contains a list of houses and has methods that cycle
through the years and and can return statistics about different alleles.
*/

public class Population extends LinkedList<House>{

private int year;

/*
both life tables are taken from Louis Kantrow's paper 1989,
which builds their tables using fifteen economically central families in
Philadelphia from 1700 to 1800. They were quite rich, and insulated from the
lower classes. While not as extreme as what is found in Caldea, in terms of
medical technology and access to resources, this group seems a suitable group
to use as a rough model for average mortality. The resolution on the data is not
as sharp as would be preferable, and each period has been averaged out to get our
percentage life expectancy.
*/
private int[] mLifeTable;
private int[] fLifeTable;

public void nextYear()
{

  year++;
}

public Population()
{
  super();
  year = 0;
  lifeTables();
}

//manually adding all 100 points the data from Kantrow 89
public void lifeTables()
{
  //male table

  mLifeTable[0]=1000;


}



}
