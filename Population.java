import java.util.*;

/*
A Population contains a list of houses and has methods that cycle
through the years and and can return statistics about different alleles.
*/

public class Population{

private int year;
private ArrayList<Caldean> eligibleDuas;
private ArrayList<Caldean> eligibleDuises;
private LinkedList<House> theHouses;
double rankWeightSum;
double ageWeightSum;
Random fate;

/*
both life tables are taken from Louis Kantrow's paper 1989,
which builds their tables using fifteen established and economically central
Philadelphia families from 1800-1850. They were quite rich, and insulated from the
lower classes. While not as extreme as what is found in Caldea, in terms of
medical technology and access to resources, this group seems a suitable group
to use as a rough model for average mortality. The resolution on the data is not
as sharp as would be preferable, and each period has been averaged out to get our
percentage life expectancy.
*/

public Population()
{
  year = 0;
  fate = new Random();
  eligibleDuas = new ArrayList<Caldean>();
  eligibleDuises =  new ArrayList<Caldean>();
  theHouses = new LinkedList<House>();
}

public Population(int y)
{
  year = y;
  fate = new Random();
  eligibleDuas = new ArrayList<Caldean>();
  eligibleDuises =  new ArrayList<Caldean>();
  theHouses = new LinkedList<House>();
}

public void nextYear()
{

  year++;
  Iterator<House> houses = theHouses.iterator();

while(houses.hasNext())
  if(houses.next().timePasses())
    houses.remove();
}

public int getYear()
{
  return year;
}

public LinkedList<House> getHouses()
{
  return theHouses;
}

//adds dus to their respective lists
public void comingOfAge(Caldean du){
  if(du.isFemale())
    eligibleDuas.add(du);

  else
    eligibleDuises.add(du);

    System.out.println("coming of age");
    System.out.println(eligibleDuas.size());
}

//removes dus from their respective lists
public void takenOrDead(Caldean du)
{
  if(du.isFemale())
    eligibleDuas.remove(du);

  else
    eligibleDuises.remove(du);

}



//builds an array of compatability scores for each eligible du
//then randomly assigns a partner, using compatability scores
//to find the probabilities.
public Caldean datingScene(Caldean theBachelor){

  ArrayList<Double> compChart = new ArrayList();

  ArrayList<Caldean> theSuitors;
  if(theBachelor.isFemale())
    theSuitors = eligibleDuises;
  else
    theSuitors = eligibleDuas;

  if(theSuitors.size()!=0){

  System.out.print("courting");

  Iterator<Caldean> paradise = theSuitors.iterator();

  rankWeightSum= 0;
  ageWeightSum = 0;

  while(paradise.hasNext())
  {
    howManyFishInThePond(theBachelor, paradise.next());
  }

  paradise = theSuitors.iterator();

  while(paradise.hasNext()){
    compChart.add(butAreYouAGemini(theBachelor, paradise.next()));
  }

  double myDesire = fate.nextDouble();
  double myDuty = 0;
  int andTheLuckyWinnerIs = 0;


  for(int i = 0; myDuty>myDesire; i++){
    myDuty = myDuty + compChart.get(i);
    andTheLuckyWinnerIs = i;
  }

  return theSuitors.get(andTheLuckyWinnerIs);
}
else
  return null;
}

//
private void howManyFishInThePond(Caldean theBachelor, Caldean aSuitor){
  double likenessInDignity = Math.exp(Math.abs(theBachelor.getHouse().getRank()-aSuitor.getHouse().getRank()));
  double ageIsJustANumber = Math.exp(Math.abs(theBachelor.getAge()-aSuitor.getAge()));

  rankWeightSum = rankWeightSum + likenessInDignity;
  ageWeightSum = ageWeightSum + ageIsJustANumber;

}

private double butAreYouAGemini(Caldean theBachelor, Caldean aSuitor){
  double likenessInDignity = Math.exp(0-Math.abs(theBachelor.getHouse().getRank()-aSuitor.getHouse().getRank()));
  double ageIsJustANumber = Math.exp(0-Math.abs(theBachelor.getAge()-aSuitor.getAge()));

  likenessInDignity = likenessInDignity/rankWeightSum*0.5;
  ageIsJustANumber = ageIsJustANumber/ageWeightSum*0.5;
  return likenessInDignity + ageIsJustANumber;
}

//manually adding all data from Kantrow '89, chance of surviving in a given year (out of 1000)
public double lifeTables(boolean female,int age)
{
  if(female)
  {
    if(age==1)
      return 837;
    else if(age<5)
      return 967;
    else if(age<10)
      return 992;
    else if(age<20)
      return 996;
    else if(age<30)
      return 992;
    else if(age<40)
      return 990;
    else if(age<50)
      return 988;
    else if(age<60)
      return 987;
    else if(age<70)
      return 970;
    else if(age<80)
      return 942;
    else if(age<90)
      return 812;
      //nobody makes it past ninety, sorry :/
    else
      return 0;
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
