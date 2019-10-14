/*
Testing fille
*/

class Test
{

  public static void main(String[] args)
  {
      Gene hidden = new Gene (100, 110, 50, 30);

      Gene uninteresting =  new Gene(100,100,100, 10);

      Locus one = new Locus(hidden, true, true);

      Locus two =  new Locus(uninteresting, true, false);

      Locus three =  new Locus(hidden, false, true);

      Locus four =  new Locus(uninteresting, false, false);

      LinkedList<Locus> DarinsGenes = new LinkedList<Locus>();
      DarinsGenes.add(one);
      DarinsGenes.add(two);

      LinkedList<Locus> ColisGenes = new LinkedList<Locus>();
      ColisGenes.add(three);
      ColisGenes.add(four);

      House San = new House();

      Caldean Darin = new Caldean(25, true, false, San, DarinsGenes);

      Caldean Colis =  new Caldean(23, false, true, San, ColisGenes);




      System.out.println("\n" + one.toString());
      System.out.println("\n" + two.toString());
      System.out.println("\n" + three.toString());
      System.out.println("\n" + four.toString());
      System.out.println("\n" + hidden.toString());
  }
}
