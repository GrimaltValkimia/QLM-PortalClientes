/*
               File: TipoIngresoBruto
        Description: TipoIngresoBruto
             Author: GeneXus Java Generator version 15_0_12-126726
       Generated on: September 23, 2020 13:37:31.29
       Program type: Callable routine
          Main DBMS: MySQL
*/
package com.quilmesportal ;
import com.quilmesportal.*;
import com.genexus.*;

public final  class gxdomaintipoingresobruto
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new String((String)""), "(Ninguno)");
      domain.put(new String((String)"C"), "Convenio Multilateral");
      domain.put(new String((String)"E"), "Exento");
      domain.put(new String((String)"L"), "Local");
      domain.put(new String((String)"R"), "Régimen Simplificado");
      domain.put(new String((String)"O"), "Otro");
      domain.put(new String((String)"*"), "Sin Constancia Inscrip.");
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

