import java.util.*;

/*
Testing fille
*/

class Test
{

  public static void main(String[] args)
  {
      Gene hidden = new Gene(100, 110, 50, 30);

      Gene uninteresting =  new Gene(100,100,100, 10);

      Locus one = new Locus(hidden, true, true);

      Locus two =  new Locus(uninteresting, true, false);

      Locus three =  new Locus(hidden, false, true);

      Locus four =  new Locus(uninteresting, true, false);

      LinkedList<Locus> DarinsGenes = new LinkedList<Locus>();
      DarinsGenes.add(one);
      DarinsGenes.add(two);

      LinkedList<Locus> ColisGenes = new LinkedList<Locus>();
      ColisGenes.add(three);
      ColisGenes.add(four);

      Population theCity = new Population();

      House San = new House(1, theCity);
      House Folin = new House(3, theCity);

      Caldean Darin = new Caldean(18, true, false, San, DarinsGenes, theCity);


      Caldean Colis =  new Caldean(16, false, true, Folin, ColisGenes, theCity);


      boolean married = false;


    while(!married)
    {

      theCity.nextYear();



      if(San.getIs()!=null){
        int cAge = theCity.getYear()+23;
        System.out.println("Colis got married at "+ cAge);
        break;
      }

      if(theCity.getYear()>100){
        System.out.println("Reached year 100. \n");
        break;}
    }


      //System.out.println("\n" + one.toString());
      //System.out.println("\n" + two.toString());
      //System.out.println("\n" + three.toString());
      //System.out.println("\n" + four.toString());
      //System.out.println("\n" + hidden.toString());
      //System.out.println("\n" + Darin.toString());
      //System.out.println("\n" + Colis.toString());
      //System.out.println("\n" + San.toString());

  }
}
