/*
               File: GAMAuthenticationTypes
        Description: GAMAuthenticationTypes
             Author: GeneXus Java Generator version 15_0_12-126726
       Generated on: September 23, 2020 13:37:30.41
       Program type: Callable routine
          Main DBMS: MySQL
*/
package com.quilmesportal ;
import com.quilmesportal.*;
import com.genexus.*;

public final  class gxdomaingamauthenticationtypes
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new String((String)"Custom"), "Custom");
      domain.put(new String((String)"ExternalWebService"), "External Web Service");
      domain.put(new String((String)"Facebook"), "Facebook");
      domain.put(new String((String)"GAMLocal"), "GAM Local");
      domain.put(new String((String)"GAMRemote"), "GAM Remote");
      domain.put(new String((String)"Google"), "Google");
      domain.put(new String((String)"Twitter"), "Twitter");
      domain.put(new String((String)"Oauth20"), "Oauth 2.0");
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

