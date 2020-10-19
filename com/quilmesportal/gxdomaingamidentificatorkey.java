/*
               File: GAMIdentificatorKey
        Description: GAMIdentificatorKey
             Author: GeneXus Java Generator version 15_0_12-126726
       Generated on: September 23, 2020 13:37:30.61
       Program type: Callable routine
          Main DBMS: MySQL
*/
package com.quilmesportal ;
import com.quilmesportal.*;
import com.genexus.*;

public final  class gxdomaingamidentificatorkey
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new String((String)"Repository"), "Repository");
      domain.put(new String((String)"SecurityPolicy"), "Security Policy");
      domain.put(new String((String)"Role"), "Role");
      domain.put(new String((String)"AppType"), "Application Type");
      domain.put(new String((String)"AppTypeResource"), "Application Type Resource");
      domain.put(new String((String)"AppTypeAction"), "Application Type Action");
      domain.put(new String((String)"Application"), "Application");
      domain.put(new String((String)"AppEnv"), "Application Environment");
      domain.put(new String((String)"AppMenu"), "Application Menu");
      domain.put(new String((String)"AppMenuOption"), "Application Menu Option");
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

