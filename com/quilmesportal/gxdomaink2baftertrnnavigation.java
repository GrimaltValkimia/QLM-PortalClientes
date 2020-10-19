/*
               File: K2BAfterTrnNavigation
        Description: K2BAfterTrnNavigation
             Author: GeneXus Java Generator version 15_0_12-126726
       Generated on: September 23, 2020 13:37:30.98
       Program type: Callable routine
          Main DBMS: MySQL
*/
package com.quilmesportal ;
import com.quilmesportal.*;
import com.genexus.*;

public final  class gxdomaink2baftertrnnavigation
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new Short((short)1), "Return To Caller");
      domain.put(new Short((short)2), "Entity Manager");
      domain.put(new Short((short)3), "Dynamic Link");
      domain.put(new Short((short)4), "Deprecated");
      domain.put(new Short((short)5), "None");
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

