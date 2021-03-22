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
private LinkedList<Caldean> theFam;
private Population theCity;

//constructor used at start of sim to build all houses, leads to
public House(Population soFar)
{

  theCity = soFar;
  rankInit = soFar.getHouses().size()+1;
  generateFamily();
  soFar.getHouses().add(this);
  theFam = new LinkedList<Caldean>();
}

//house
public House(int rI, Population city)
{
  theCity = city;
  theCity.getHouses().add(this);
  rankInit=rI;
  theFam = new LinkedList<Caldean>();
}

public boolean baby()
{
  Caldean addition = new Caldean(rex, is);

  theFam.add(addition);

  if(hasDu()){
    return false;
  }

  else if(!hasDu()&&!hasEld()){
    eld = addition;
    return true;
  }

  else{
    du = addition;
    return true;
  }

}

public boolean timePasses()
{
  boolean theEnd = true;
  if(rex!=null){
    rex.anotherYear();
    theEnd = false;
  }


  if(is!=null){
    is.anotherYear();
    theEnd = false;
  }

  if(eld!=null){
    eld.anotherYear();
    theEnd = false;
  }

  if(du!=null){
    du.anotherYear();
    theEnd = false;
  }

  return theEnd;
}

public void succession(Caldean newIs)
{
  if(rex==null)
  {rex = eld;
  eld = null;}
  is = newIs;
  theFam.add(is);
}

public void removeDu()
{
  theFam.remove(du);
  du = null;
}

public boolean hasDu(){
  return du!=null;
}

public boolean hasEld()
{
  return eld!=null;
}

public Caldean getRex(){
  return rex;
}

public Caldean getIs(){
  return is;
}

public Caldean getEld(){
  return eld;
}

public Caldean getDu(){
  return du;
}

//gives current rank
public int getRank()
{
  return theCity.getHouses().indexOf(this)+1;
}

public int getInitialRank()
{
  return rankInit;
}

public void aDeathInThe(Caldean deceased)
{
  if(deceased==rex)
    {
      theFam.remove(rex);
      theFam.remove(is);
      rex = null;
      is = null;

    }

    else if(deceased==is){
      theFam.remove(is);
      is = null;
    }


    else if(deceased==eld){
          theFam.remove(eld);
          eld = du;
          du = null;
        }

    else if(deceased==du){
        theCity.takenOrDead(deceased);
        theFam.remove(du);
        du = null;
      }

}


//STUB, will generate a family of Caldeans for each house to start sim
public LinkedList<Caldean> generateFamily()
{
  LinkedList<Caldean> fam = new LinkedList<Caldean>();
  theFam = fam;
  return fam;
}


//manual methods for Testing

public void setRex(Caldean a)
{
  rex = a;
}

public void addMember(Caldean a){
  theFam.add(a);

  if(rex==null)
    rex = a;
  else if (is==null)
    is = a;
  else if (eld==null)
    eld = a;
  else
    du = a;
}

public String toString()
{
  String output = "This house is comprised of: \n";

  if(rex!=null)
  output = output + rex.toString() + "\n";

  if(is!=null)
  output = output + is.toString() + "\n";

  if(eld!=null)
  output = output + eld.toString() + "\n";

  if(du!=null)
  output = output + du.toString() + "\n";

  //while(senior.hasNext())
  //  output = output + "\n" + senior.next().toString();

return output;
}
}
