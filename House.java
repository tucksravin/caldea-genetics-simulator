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

public House()
{
  //blank house;
}

//gives current rank
public int getRank()
{
  return theHousesOfCaldea.indexOf(this);
}

public int getInitialRank()
{
  return rankInit;
}

public LinkedList<Caldean> generateFamily()
{
  
}
}
