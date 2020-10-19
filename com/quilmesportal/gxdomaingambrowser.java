/*
               File: GAMBrowser
        Description: GAMBrowser
             Author: GeneXus Java Generator version 15_0_12-126726
       Generated on: September 23, 2020 13:37:30.44
       Program type: Callable routine
          Main DBMS: MySQL
*/
package com.quilmesportal ;
import com.quilmesportal.*;
import com.genexus.*;

public final  class gxdomaingambrowser
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new Short((short)0), "Unknown Agent");
      domain.put(new Short((short)1), "Internet Explorer");
      domain.put(new Short((short)2), "Netscape");
      domain.put(new Short((short)3), "Opera");
      domain.put(new Short((short)5), "Pocket IE");
      domain.put(new Short((short)6), "Firefox");
      domain.put(new Short((short)7), "Chrome");
      domain.put(new Short((short)8), "Safari");
      domain.put(new Short((short)9), "Edge");
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

