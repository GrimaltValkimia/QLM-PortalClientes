/*
               File: GAMUserListOrder
        Description: GAMUserListOrder
             Author: GeneXus Java Generator version 15_0_12-126726
       Generated on: September 23, 2020 13:37:30.93
       Program type: Callable routine
          Main DBMS: MySQL
*/
package com.quilmesportal ;
import com.quilmesportal.*;
import com.genexus.*;

public final  class gxdomaingamuserlistorder
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new Byte((byte)0), "None");
      domain.put(new Byte((byte)1), "GUID_ Asc");
      domain.put(new Byte((byte)2), "GUID_ Desc");
      domain.put(new Byte((byte)3), "User Name_ Asc");
      domain.put(new Byte((byte)4), "User Name_ Desc");
      domain.put(new Byte((byte)5), "User Email_ Asc");
      domain.put(new Byte((byte)6), "User Email_ Desc");
      domain.put(new Byte((byte)7), "User First Name_ Asc");
      domain.put(new Byte((byte)8), "User First Name_ Desc");
      domain.put(new Byte((byte)9), "User Last Name_ Asc");
      domain.put(new Byte((byte)10), "User Last Name_ Desc");
      domain.put(new Byte((byte)11), "User External Id_Asc");
      domain.put(new Byte((byte)12), "User External Id_Desc");
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

