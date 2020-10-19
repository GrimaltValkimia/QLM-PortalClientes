/*
               File: K2BPage
        Description: K2BPage
             Author: GeneXus Java Generator version 15_0_12-126726
       Generated on: September 23, 2020 13:37:31.7
       Program type: Callable routine
          Main DBMS: MySQL
*/
package com.quilmesportal ;
import com.quilmesportal.*;
import com.genexus.*;

public final  class gxdomaink2bpage
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new Short((short)20), "Rows");
      domain.put(new Short((short)1), "FirstPage");
      domain.put(new Short((short)0), "NoPage");
      domain.put(new Short((short)-1), "NoMaxPage");
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

