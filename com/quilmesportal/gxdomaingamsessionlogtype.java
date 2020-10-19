/*
               File: GAMSessionLogType
        Description: GAMSessionLogType
             Author: GeneXus Java Generator version 15_0_12-126726
       Generated on: September 23, 2020 13:37:30.83
       Program type: Callable routine
          Main DBMS: MySQL
*/
package com.quilmesportal ;
import com.quilmesportal.*;
import com.genexus.*;

public final  class gxdomaingamsessionlogtype
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new String((String)"CheckPermissionFail"), "Check Permission Fail");
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

