/*
Testing fille
*/

class Test
{

  public static void main(String[] args)
  {
      Gene hidden = new Gene (100, 110, 50, 30);

      Locus one = new Locus(hidden, true, true);

      Locus two =  new Locus(hidden, true, false);

      Locus three =  new Locus(hidden, false, true);

      Locus four =  new Locus(hidden, false, false);



      System.out.println("\n" + one.toString());
      System.out.println("\n" + two.toString());
      System.out.println("\n" + three.toString());
      System.out.println("\n" + four.toString());
      System.out.println("\n" + hidden.toString());
  }
}
