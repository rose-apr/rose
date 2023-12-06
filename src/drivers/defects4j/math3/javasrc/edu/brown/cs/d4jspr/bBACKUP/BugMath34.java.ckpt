/********************************************************************************/
/*                                                                              */
/*              BugMath34.java                                                  */
/*                                                                              */
/*      Defects4J Bug Math_34                                                   */
/*                                                                              */
/********************************************************************************/
/*      Copyright 2011 Brown University -- Steven P. Reiss                    */



package edu.brown.cs.d4jspr;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.math3.genetics.AbstractListChromosome;
import org.apache.commons.math3.genetics.BinaryChromosome;
import org.apache.commons.math3.genetics.Chromosome;
import org.apache.commons.math3.genetics.ListPopulation;
import org.apache.commons.math3.genetics.Population;

public class BugMath34 implements BugConstants
{


public static void main(String [] args)
{
   testMath34();
}


public static void testMath34()
{
   final ArrayList<Chromosome> chromosomes = new ArrayList<Chromosome>();
   chromosomes.add(new DummyBinaryChromosome(BinaryChromosome.randomBinaryRepresentation(3)));
   chromosomes.add(new DummyBinaryChromosome(BinaryChromosome.randomBinaryRepresentation(3)));
   chromosomes.add(new DummyBinaryChromosome(BinaryChromosome.randomBinaryRepresentation(3)));
   
   final ListPopulation population = new DummyListPop();
    
    population.addChromosomes(chromosomes);
    
    final Iterator<Chromosome> iter = population.iterator();
    try {
       while (iter.hasNext()) {
          iter.next();
          iter.remove();
        }
       System.err.println("REMOVE shouldn't work");
     }
    catch (UnsupportedOperationException e) { }
}


public static class DummyListPop extends ListPopulation {
   
   DummyListPop() {
      super(10);
    }
   
   public Population nextGeneration() {     
      return null;
    }
   
}



public static class DummyBinaryChromosome extends BinaryChromosome {

   public DummyBinaryChromosome(List<Integer> representation) {
      super(representation);
    }
   
   public DummyBinaryChromosome(Integer[] representation) {
      super(representation);
    }
   
   @Override
   public AbstractListChromosome<Integer> newFixedLengthChromosome(List<Integer> chromosomeRepresentation) {
      return new DummyBinaryChromosome(chromosomeRepresentation);
    }
   
   public double fitness() {
      // uninteresting
      return 0;
    }

}

}       // end of class BugMath34




/* end of BugMath34.java */

