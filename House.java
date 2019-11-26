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

//constructor used at start of sim to build all houses, leads to
public House(Population soFar)
{
  theHousesOfCaldea = soFar;
  rankInit = soFar.size()+1;
  theFolks = generateFamily();
  Iterator<Caldean> senior = theFolks.iterator();
  rex = senior.next();
  is = senior.next();
  eld = senior.next();
  du = senior.next();
  soFar.add(this);
}

//house
public House(int rI, Population houses)
{
  theHousesOfCaldea = houses;
  theHousesOfCaldea.add(this);
  rankInit=rI;
}

public void baby(Caldean addition)
{
  if(hasEld())
    du = addition;

  else
    eld = addition;
}

public void succession(Caldean newIs)
{
  rex = eld;
  is = addition;
  eld = null;
}

public void removeDu()
{
  du = null;
}

public boolean hasEld()
{
  return eld!=null;
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

//STUB, will generate a family of Caldeans for each house to start sim
public ArrayList<Caldean> generateFamily()
{
  ArrayList<Caldean> fam = new ArrayList<Caldean>();
  return fam;
}



}
