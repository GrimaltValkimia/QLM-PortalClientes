/*
               File: K2BThemeClasses
        Description: K2BThemeClasses
             Author: GeneXus Java Generator version 15_0_12-126726
       Generated on: September 23, 2020 13:37:31.12
       Program type: Callable routine
          Main DBMS: MySQL
*/
package com.quilmesportal ;
import com.quilmesportal.*;
import com.genexus.*;

public final  class gxdomaink2bthemeclasses
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new String((String)"TableNone"), "TableNone");
      domain.put(new String((String)"AttributeContainerTable"), "K2BTableGeneralData");
      domain.put(new String((String)"K2BButtonUp"), "K2BButtonUp");
      domain.put(new String((String)"K2BButtonDown"), "K2BButtonDown");
      domain.put(new String((String)"K2BError"), "K2BError");
      domain.put(new String((String)"K2BMessage"), "K2BMessage");
      domain.put(new String((String)"K2BWarning"), "K2BWarning");
      domain.put(new String((String)"K2BSelectedTab"), "K2BSelectedTab");
      domain.put(new String((String)"K2BUnselectedTab"), "K2BUnselectedTab");
      domain.put(new String((String)"FilterTabContainerTable"), "K2BTableTabFilter");
      domain.put(new String((String)"FilterContainerTable"), "K2BTableFilterGeneralData");
      domain.put(new String((String)"K2BConfirmation"), "K2BConfirmation");
      domain.put(new String((String)"K2BTableAttributeGroupDelimit"), "K2BTableAttributeGroupDelimit");
      domain.put(new String((String)"ReadOnlyK2BHeaderAttribute"), "K2BReadOnlyHeaderAttribute");
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

