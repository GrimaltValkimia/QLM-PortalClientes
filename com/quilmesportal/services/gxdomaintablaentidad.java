/*
               File: Services.TablaEntidad
        Description: TablaEntidad
             Author: GeneXus Java Generator version 15_0_12-126726
       Generated on: September 23, 2020 13:37:31.47
       Program type: Callable routine
          Main DBMS: MySQL
*/
package com.quilmesportal.services ;
import com.quilmesportal.*;
import com.genexus.*;

public final  class gxdomaintablaentidad
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new String((String)"PROVINCIA"), "Provincia");
      domain.put(new String((String)"LOCALIDAD"), "Localidad");
      domain.put(new String((String)"DEPTOLOCALIDAD"), "Relación Departamento Localidad");
      domain.put(new String((String)"GOOGLEKEY"), "Google KEY para Maps");
      domain.put(new String((String)"TIPONEGOCIO"), "Tipo de Negocio");
      domain.put(new String((String)"ALCOHOL_PAIS"), "Alcohol País");
      domain.put(new String((String)"ALCOHOL_PROVINCIA"), "Alcohol Provincia");
      domain.put(new String((String)"ALCOHOL_LOCALIDAD"), "Alcohol Localidad");
      domain.put(new String((String)"DEFAULT"), "Valores por Default");
      domain.put(new String((String)"INGRESOS_BRUTOS"), "Ingresos Brutos");
      domain.put(new String((String)"TIPO_DOCUMENTO"), "Tipo Documento");
      domain.put(new String((String)"ENTIDAD"), "Entidad");
      domain.put(new String((String)"ENTIDAD_SERVICIO"), "Entidad Servicio");
      domain.put(new String((String)"SUBCANALESVENTAS"), "Sub Canales Ventas+");
      domain.put(new String((String)"CLIENTE_POTENCIAL"), "Cliente Potencial");
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

