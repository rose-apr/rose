/********************************************************************************/
/*                                                                              */
/*              BugMockito05.java                                               */
/*                                                                              */
/*      D4J problem Mockito_5                                                   */
/*                                                                              */
/********************************************************************************/


package edu.brown.cs.d4jspr;

import org.hamcrest.Matcher;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.cglib.proxy.Enhancer;
import org.objenesis.Objenesis;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Set;


public class BugMockito05 implements BugConstants
{

public static void main(String [] args) throws Throwable
{
   ClassLoader classLoader_without_JUnit = ClassLoaders.excludingClassLoader()
                .withCodeSourceUrlOf(
                      Mockito.class,
                      Matcher.class,
                      Enhancer.class,
                      Objenesis.class
                )
                .without("junit", "org.junit")
                .build();
   
   testMockito05(classLoader_without_JUnit);
}


public static void testMockito05(ClassLoader clr) throws ClassNotFoundException,
        URISyntaxException, IOException
{
   Set<String> pureMockitoAPIClasses = ClassLoaders.in(clr).
      omit("runners", "junit", "JUnit").listOwnedClasses();
         
   for (String pureMockitoAPIClass : pureMockitoAPIClasses) {
      checkDependency(clr, pureMockitoAPIClass);
    }
}


private static void checkDependency(ClassLoader classLoader_without_JUnit, String pureMockitoAPIClass) throws ClassNotFoundException {
   try {
      Class.forName(pureMockitoAPIClass, true, classLoader_without_JUnit);
    } catch (Throwable e) {
       throw new AssertionError(String.format("'%s' has some dependency to JUnit", pureMockitoAPIClass), e);
     }
}


}       // end of class BugMockito05




/* end of BugMockito05.java */

