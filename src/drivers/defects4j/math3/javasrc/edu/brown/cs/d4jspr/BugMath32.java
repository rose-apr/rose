/********************************************************************************/
/*                                                                              */
/*              BugMath32.java                                                  */
/*                                                                              */
/*      D4J Bug Math_32                                                         */
/*                                                                              */
/********************************************************************************/
/*      Copyright 2011 Brown University -- Steven P. Reiss                    */



package edu.brown.cs.d4jspr;

import java.util.ArrayList;

import org.apache.commons.math3.geometry.euclidean.threed.Euclidean3D;
import org.apache.commons.math3.geometry.euclidean.threed.Plane;
import org.apache.commons.math3.geometry.euclidean.threed.PolyhedronsSet;
import org.apache.commons.math3.geometry.euclidean.threed.SubPlane;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.apache.commons.math3.geometry.euclidean.twod.Euclidean2D;
import org.apache.commons.math3.geometry.euclidean.twod.PolygonsSet;
import org.apache.commons.math3.geometry.euclidean.twod.SubLine;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.geometry.partitioning.Region;
import org.apache.commons.math3.geometry.partitioning.SubHyperplane;

public class BugMath32 implements BugConstants
{

public static void main(String [] args)
{
   testMath32();
}


public static void testMath32()
{
   float[] coords = {
         1.000000f, -1.000000f, -1.000000f,
         1.000000f, -1.000000f, 1.000000f,
         -1.000000f, -1.000000f, 1.000000f,
         -1.000000f, -1.000000f, -1.000000f,
         1.000000f, 1.000000f, -1f,
         0.999999f, 1.000000f, 1.000000f,   // 1.000000f, 1.000000f, 1.000000f,
         -1.000000f, 1.000000f, 1.000000f,
         -1.000000f, 1.000000f, -1.000000f};
   int[] indices = {
         0, 1, 2, 0, 2, 3,
         4, 7, 6, 4, 6, 5,
         0, 4, 5, 0, 5, 1,
         1, 5, 6, 1, 6, 2,
         2, 6, 7, 2, 7, 3,
         4, 0, 3, 4, 3, 7};
   ArrayList<SubHyperplane<Euclidean3D>> subHyperplaneList = new ArrayList<SubHyperplane<Euclidean3D>>();
   for (int idx = 0; idx < indices.length; idx += 3) {
      int idxA = indices[idx] * 3;
      int idxB = indices[idx + 1] * 3;
      int idxC = indices[idx + 2] * 3;
      Vector3D v_1 = new Vector3D(coords[idxA], coords[idxA + 1], coords[idxA + 2]);
      Vector3D v_2 = new Vector3D(coords[idxB], coords[idxB + 1], coords[idxB + 2]);
      Vector3D v_3 = new Vector3D(coords[idxC], coords[idxC + 1], coords[idxC + 2]);
      Vector3D[] vertices = {v_1, v_2, v_3};
      Plane polyPlane = new Plane(v_1, v_2, v_3);
      ArrayList<SubHyperplane<Euclidean2D>> lines = new ArrayList<SubHyperplane<Euclidean2D>>();
      
      Vector2D[] projPts = new Vector2D[vertices.length];
      for (int ptIdx = 0; ptIdx < projPts.length; ptIdx++) {
         projPts[ptIdx] = polyPlane.toSubSpace(vertices[ptIdx]);
       }
      
      SubLine lineInPlane = null;
      for (int ptIdx = 0; ptIdx < projPts.length; ptIdx++) {
         lineInPlane = new SubLine(projPts[ptIdx], projPts[(ptIdx + 1) % projPts.length]);
         lines.add(lineInPlane);
       }
      Region<Euclidean2D> polyRegion = new PolygonsSet(lines);
      SubPlane polygon = new SubPlane(polyPlane, polyRegion);
      subHyperplaneList.add(polygon);
    }
   PolyhedronsSet polyhedronsSet = new PolyhedronsSet(subHyperplaneList);
   double sz = polyhedronsSet.getSize();
   double bsz = polyhedronsSet.getBoundarySize();
   assert Math.abs(sz-8.0) < 3.0e-6;
   assert Math.abs(bsz-24.0) < 5.0e-6;
}
   

}       // end of class BugMath32




/* end of BugMath32.java */

