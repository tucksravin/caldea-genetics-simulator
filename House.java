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
ArrayList<Caldean> theFolks;
private Population theHousesOfCaldea;

//constructor used at start of sim to build all houses, leads to
public House(Population soFar)
{

  theHousesOfCaldea = soFar;
  rankInit = soFar.size()+1;
  generateFamily();
  soFar.add(this);
}

//house
public House(int rI, Population houses)
{
  theHousesOfCaldea = houses;
  theHousesOfCaldea.add(this);
  rankInit=rI;
}

public boolean baby()
{
  Caldean addition = new Caldean(rex, is);

  if(hasDu()){
    return false;
  }

  else if(!hasDu()&&!hasEld()){
    eld = addition;
    restructureFam();
    return true;
  }

  else{
    du = addition;
    return true;
  }

}

public void succession(Caldean newIs)
{
  if(hasEld()){
    rex = eld;
    eld = null;
  }

  is = newIs;

  restructureFam();
}

public void removeDu()
{
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
  return theHousesOfCaldea.indexOf(this)+1;
}

public int getInitialRank()
{
  return rankInit;
}

public void aDeathInThe(Caldean deceased)
{
  if(deceased==rex)
    {
      rex = null;
      is = null;
    }

    else if(deceased==is)
        is = null;

    else if(deceased==eld)
        eld = null;

    else if(deceased==du)
        du = null;



  restructureFam();
}

private void restructureFam(){
  theFolks = new ArrayList<Caldean>();
  theFolks.add(rex);
  theFolks.add(is);
  theFolks.add(eld);
  theFolks.add(du);
}

//STUB, will generate a family of Caldeans for each house to start sim
public ArrayList<Caldean> generateFamily()
{
  ArrayList<Caldean> fam = new ArrayList<Caldean>();
  return fam;
}


//manual methods for Testing

public void setRex(Caldean a)
{
  rex = a;
  restructureFam();
}

public void addMember(Caldean a){
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
  Iterator<Caldean> senior = theFolks.iterator();
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
