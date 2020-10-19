/*
               File: K2BBtnToolTip
        Description: K2BBtnToolTip
             Author: GeneXus Java Generator version 15_0_12-126726
       Generated on: September 23, 2020 13:37:30.99
       Program type: Callable routine
          Main DBMS: MySQL
*/
package com.quilmesportal ;
import com.quilmesportal.*;
import com.genexus.*;

public final  class gxdomaink2bbtntooltip
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new String((String)"Primera"), "First");
      domain.put(new String((String)"Anterior"), "Previous");
      domain.put(new String((String)"Siguiente"), "Next");
      domain.put(new String((String)"Última"), "Last");
      domain.put(new String((String)"Listado"), "List");
      domain.put(new String((String)"Actualizar"), "Refresh");
      domain.put(new String((String)"Agregar"), "New");
      domain.put(new String((String)"Ocultar Filtros"), "HideFilters");
      domain.put(new String((String)"Mostrar Filtros"), "ShowFilters");
      domain.put(new String((String)"Imprimir"), "Print");
      domain.put(new String((String)"\"; title=\""), "ToolTipText");
      domain.put(new String((String)"Soporte Técnico"), "TechSupport");
      domain.put(new String((String)"Ayuda"), "HelpHeader");
      domain.put(new String((String)"Cerrar"), "Close");
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

