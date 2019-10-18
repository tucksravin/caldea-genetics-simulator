import java.util.*;

/*
A house object is representative of a family name and those caldeans
who find themselves under it. A house will have an initial rank, a method to get the current rank,
members who currently fill out the current roles of rex, is, eld, and du, if they are filled.
*/

public class House{

private int rankInit;
private Caldean rex;
private Caldean is;
private Caldean eld;
private Caldean du;
private Population theHousesOfCaldea;

public House(Population soFar)
{
  theHousesOfCaldea = soFar;
  rankInit = soFar.size()+1;
  LinkedList<Caldean> theFolks = generateFamily();
  Iterator<Caldean> senior = theFolks.iterator();
  rex = senior.next();
  is = senior.next();
  eld = senior.next();
  du = senior.next();
  soFar.add(this);
}

//artificial house
public House(int rI, Population houses)
{
  theHousesOfCaldea = houses;
  theHousesOfCaldea.add(this);
  rankInit=rI;
}

//gives current rank
public int getRank()
{
  return theHousesOfCaldea.indexOf(this)+1;
}

public int getInitialRank()
{
  return rankInit;
}

public LinkedList<Caldean> generateFamily()
{
  LinkedList<Caldean> fam = new LinkedList<Caldean>();
  fam.add(rex);
  fam.add(is);
  fam.add(eld);
  fam.add(du);
  return fam;
}



}
