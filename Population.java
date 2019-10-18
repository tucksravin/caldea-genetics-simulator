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
}

//manually adding all data from Kantrow 89, chance of surviving in a given year
public double lifeTables(boolean female,int age)
{
  if(female)
  {

  }
  else
    {
      if(age==1)
        return 846;
      else if(age<5)
        return 980;
      else if(age<10)
        return 994;
      else if(age<20)
        return 995;
      else if(age<30)
        return 994;
        //30-49 has a very similar mortality rate
      else if(age<50)
        return 986;
      else if(age<60)
        return 983;
      else if(age<70)
        return 962;
      else if(age<80)
        return 925;
      else if(age<90)
        return 829;
        //nobody makes it past ninety, sorry :/
      else
        return 0;


    }
}



}
