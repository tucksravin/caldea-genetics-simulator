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

      Population theCity = new Population(4);

      House San = new House(1, theCity);
      House Cras = new House(2, theCity);
      House Folin = new House(3, theCity);

      Caldean Darin = new Caldean(0, true, false, San, DarinsGenes, theCity);


      Caldean Colis =  new Caldean(2, false, true, Folin, ColisGenes, theCity);

      Caldean Polis =  new Caldean(2, false, true, Cras, ColisGenes, theCity);

      boolean married = false;

      System.out.println(San.toString());


    while(!married)
    {

      theCity.nextYear();
      System.out.println(theCity.getYear());
      System.out.println("San");
      System.out.println(San.toString());
      System.out.println("Cras");
      System.out.println(Cras.toString());
      System.out.println("Folin");
      System.out.println(Folin.toString());




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
