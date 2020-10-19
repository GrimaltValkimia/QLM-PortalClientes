/*
               File: GAMTracing
        Description: GAMTracing
             Author: GeneXus Java Generator version 15_0_12-126726
       Generated on: September 23, 2020 13:37:30.88
       Program type: Callable routine
          Main DBMS: MySQL
*/
package com.quilmesportal ;
import com.quilmesportal.*;
import com.genexus.*;

public final  class gxdomaingamtracing
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new Short((short)0), "0 - Off");
      domain.put(new Short((short)1), "1 - Debug");
   }

   public static String getDescription( com.genexus.internet.HttpContext httpContext ,
                                        short key )
   {
      if (domain.containsKey( key ))
      {
         return (String)domain.get( key );
      }
      else
      {
         return "";
      }
   }

   public static GXSimpleCollection<Short> getValues( )
   {
      GXSimpleCollection<Short> value = new GXSimpleCollection<Short>(Short.class, "internal", "");
      java.util.Iterator itr = domain.keySet().iterator();
      while(itr.hasNext())
      {
         value.add((Short) itr.next());
      }
      return value;
   }

}

