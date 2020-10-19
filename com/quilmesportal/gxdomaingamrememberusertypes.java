/*
               File: GAMRememberUserTypes
        Description: GAMRememberUserTypes
             Author: GeneXus Java Generator version 15_0_12-126726
       Generated on: September 23, 2020 13:37:30.72
       Program type: Callable routine
          Main DBMS: MySQL
*/
package com.quilmesportal ;
import com.quilmesportal.*;
import com.genexus.*;

public final  class gxdomaingamrememberusertypes
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new Byte((byte)1), "None");
      domain.put(new Byte((byte)2), "Login");
      domain.put(new Byte((byte)3), "Authentication");
   }

   public static String getDescription( com.genexus.internet.HttpContext httpContext ,
                                        byte key )
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

   public static GXSimpleCollection<Byte> getValues( )
   {
      GXSimpleCollection<Byte> value = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      java.util.Iterator itr = domain.keySet().iterator();
      while(itr.hasNext())
      {
         value.add((Byte) itr.next());
      }
      return value;
   }

}

