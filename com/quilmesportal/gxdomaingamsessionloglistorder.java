/*
               File: GAMSessionLogListOrder
        Description: GAMSessionLogListOrder
             Author: GeneXus Java Generator version 15_0_12-126726
       Generated on: September 23, 2020 13:37:30.81
       Program type: Callable routine
          Main DBMS: MySQL
*/
package com.quilmesportal ;
import com.quilmesportal.*;
import com.genexus.*;

public final  class gxdomaingamsessionloglistorder
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new Byte((byte)0), "None");
      domain.put(new Byte((byte)1), "Token_Asc");
      domain.put(new Byte((byte)2), "Token_Desc");
      domain.put(new Byte((byte)3), "Date_Asc");
      domain.put(new Byte((byte)4), "Date_Desc");
      domain.put(new Byte((byte)5), "User_Asc");
      domain.put(new Byte((byte)6), "User_Desc");
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

