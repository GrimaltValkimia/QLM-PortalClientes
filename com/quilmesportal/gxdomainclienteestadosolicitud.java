/*
               File: ClienteEstadoSolicitud
        Description: ClienteEstadoSolicitud
             Author: GeneXus Java Generator version 15_0_12-126726
       Generated on: September 23, 2020 13:37:30.7
       Program type: Callable routine
          Main DBMS: MySQL
*/
package com.quilmesportal ;
import com.quilmesportal.*;
import com.genexus.*;

public final  class gxdomainclienteestadosolicitud
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new String((String)"PEP"), "Pendiente Proceso");
      domain.put(new String((String)"PEA"), "Pendiente Autorización");
      domain.put(new String((String)"PET"), "Pendiente Truck");
      domain.put(new String((String)"OK"), "Finalizada");
      domain.put(new String((String)"ERR"), "Con Errores");
      domain.put(new String((String)"CAN"), "Cancelada");
      domain.put(new String((String)"REC"), "Rechazada");
      domain.put(new String((String)"REP"), "Reproceso Pendiente");
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

