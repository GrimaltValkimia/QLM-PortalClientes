/*
               File: GAMInternalGUIDs
        Description: GAMInternalGUIDs
             Author: GeneXus Java Generator version 15_0_12-126726
       Generated on: September 23, 2020 13:37:30.63
       Program type: Callable routine
          Main DBMS: MySQL
*/
package com.quilmesportal ;
import com.quilmesportal.*;
import com.genexus.*;

public final  class gxdomaingaminternalguids
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new String((String)"8d9934db-05db-4d64-adba-5e0466c3a56f"), "Application GAM Admnistrator");
      domain.put(new String((String)"8d9934db-05db-4d64-adba-5e0466c3appU"), "Application GAM User Backend");
      domain.put(new String((String)"8d9934db-05db-4d64-adba-5e0466gam001"), "Backend Main Menu");
      domain.put(new String((String)"8d9934db-05db-4d64-adba-5e0466gam002"), "Backend settings Menu");
      domain.put(new String((String)"8d9934db-05db-4d64-adba-5e0466gam003"), "Backend Menu Opt Users");
      domain.put(new String((String)"8d9934db-05db-4d64-adba-5e0466gam004"), "Backend Menu Opt Roles");
      domain.put(new String((String)"8d9934db-05db-4d64-adba-5e0466gam005"), "Backend Menu Opt Setings");
      domain.put(new String((String)"8d9934db-05db-4d64-adba-5e0466gam006"), "Backend Menu Opt Sec Pol");
      domain.put(new String((String)"8d9934db-05db-4d64-adba-5e0466gam007"), "Backend Menu Opt Applications");
      domain.put(new String((String)"8d9934db-05db-4d64-adba-5e0466gam008"), "Backend Menu Opt Rep Conf");
      domain.put(new String((String)"8d9934db-05db-4d64-adba-5e0466gam009"), "Backend Menu Opt Rep Conn");
      domain.put(new String((String)"8d9934db-05db-4d64-adba-5e0466gam010"), "Backend Menu Opt Auth Types");
      domain.put(new String((String)"8d9934db-05db-4d64-adba-5e0466gam011"), "Backend Menu Opt Change Pwd");
      domain.put(new String((String)"8d9934db-05db-4d64-adba-5e0466gam012"), "Backend Menu Opt Change WR");
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

