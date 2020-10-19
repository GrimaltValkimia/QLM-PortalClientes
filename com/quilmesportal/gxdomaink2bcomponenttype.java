/*
               File: K2BComponentType
        Description: K2BComponentType
             Author: GeneXus Java Generator version 15_0_12-126726
       Generated on: September 23, 2020 13:37:31.1
       Program type: Callable routine
          Main DBMS: MySQL
*/
package com.quilmesportal ;
import com.quilmesportal.*;
import com.genexus.*;

public final  class gxdomaink2bcomponenttype
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new Byte((byte)1), "SubWorkWith");
      domain.put(new Byte((byte)2), "UserDefined");
      domain.put(new Byte((byte)3), "MainTransaction");
      domain.put(new Byte((byte)4), "ParalelTransaction");
      domain.put(new Byte((byte)5), "History");
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

