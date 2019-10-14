/*
Testing fille
*/

class Test
{

  public static void main(String[] args)
  {
      Gene one = new Gene (true, true, 100, 110, 75);

      Gene two = new Gene (false, true, 100, 110, 75);

      Gene three = new Gene (true, false, 100, 110, 75);

      Gene four = new Gene (false, false, 100, 110, 75);

      System.out.println("\n" + one.toString());
      System.out.println("\n" + two.toString());
      System.out.println("\n" + three.toString());
      System.out.println("\n" + four.toString());
  }
}
