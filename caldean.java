import java.util.Random;
import java.util.Scanner;

/*
Any caldean object represents an individual caldean living at the time of the simulator.
This simulation prioritizes birth order over gender, so instead of classifying each Caldean as
male or female, they are either eld or du. Additionally, their membership in a house is established
through the progeny method. Partners are determined through the marriage method, and each Caldean
has a simplified, Mendelian genome, running from a to b.

Methods:

eld()
returns true if eld, false if du

getAge()
returns age

getSex()
returns sex

getSpouse()
returns caldeans spouse

getHouse()
returns house

seqGenome()
returns genome

marriage()
if eldis and correct age, searches for duis of correct age

progeny()
if married, creates new Caldean



*/

public class Caldean{

  private int age;
  private boolean eld;
  private boolean sex;
  private House family;
  private Caldean spouse;
  private Genome myGenes;

}
