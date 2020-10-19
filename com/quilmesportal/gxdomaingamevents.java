/*
               File: GAMEvents
        Description: GAMEvents
             Author: GeneXus Java Generator version 15_0_12-126726
       Generated on: September 23, 2020 13:37:30.49
       Program type: Callable routine
          Main DBMS: MySQL
*/
package com.quilmesportal ;
import com.quilmesportal.*;
import com.genexus.*;

public final  class gxdomaingamevents
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new String((String)"user-update"), "User - Update");
      domain.put(new String((String)"user-insert"), "User - Insert");
      domain.put(new String((String)"user-delete"), "User - Delete");
      domain.put(new String((String)"user-updateroles"), "User - Update Roles");
      domain.put(new String((String)"user-getcustominfo"), "User - Get Custom Information on GAMRemote Server");
      domain.put(new String((String)"user-savecustominfo"), "User - Save Custom Information on GAMRemote Client");
      domain.put(new String((String)"role-insert"), "Role - Insert");
      domain.put(new String((String)"role-update"), "Role - Update");
      domain.put(new String((String)"role-delete"), "Role - Delete");
      domain.put(new String((String)"repository-login"), "Repository - Login");
      domain.put(new String((String)"repository-logout"), "Repository - Logout");
      domain.put(new String((String)"application-checkprmfail"), "Application - Check Permission Fail");
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

