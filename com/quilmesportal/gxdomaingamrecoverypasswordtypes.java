/*
               File: GAMRecoveryPasswordTypes
        Description: GAMRecoveryPasswordTypes
             Author: GeneXus Java Generator version 15_0_12-126726
       Generated on: September 23, 2020 13:37:30.71
       Program type: Callable routine
          Main DBMS: MySQL
*/
package com.quilmesportal ;
import com.quilmesportal.*;
import com.genexus.*;

public final  class gxdomaingamrecoverypasswordtypes
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new String((String)"NewPassword"), "Return new random password");
      domain.put(new String((String)"KeyToChange"), "Return key to change password");
      domain.put(new String((String)"Question"), "Return question to change password");
   }

   public static String getDescription( com.genexus.internet.HttpContext httpContext ,
                                        String key )
   {
      if (domain.containsKey( key.trim() ))
      {
         return (String)domain.get( key.trim() );
      }
      else
      {
         return "";
      }
   }

   public static GXSimpleCollection<String> getValues( )
   {
      GXSimpleCollection<String> value = new GXSimpleCollection<String>(String.class, "internal", "");
      java.util.Iterator itr = domain.keySet().iterator();
      while(itr.hasNext())
      {
         value.add((String) itr.next());
      }
      return value;
   }

}

