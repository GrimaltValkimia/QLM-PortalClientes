/*
               File: DOMParametroId
        Description: DOMParametroId
             Author: GeneXus Java Generator version 15_0_12-126726
       Generated on: September 23, 2020 13:37:30.13
       Program type: Callable routine
          Main DBMS: MySQL
*/
package com.quilmesportal ;
import com.quilmesportal.*;
import com.genexus.*;

public final  class gxdomaindomparametroid
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new Short((short)1), "Confirmación Email");
      domain.put(new Short((short)2), "Map - Google Api Key");
      domain.put(new Short((short)3), "Códigos Adicionales");
      domain.put(new Short((short)4), "Envío Mail Tercearizados");
      domain.put(new Short((short)5), "Encryption Key-Value");
      domain.put(new Short((short)6), "URL Confirmación");
      domain.put(new Short((short)7), "Capcha Private-Site Key");
      domain.put(new Short((short)8), "Fuerza Venta Activa");
      domain.put(new Short((short)9), "LogActivo - Path archivo de log");
      domain.put(new Short((short)10), "Base Url Desarrollo - Producción");
      domain.put(new Short((short)11), "Usuario para invocar el CL");
      domain.put(new Short((short)12), "KeyGam - Ldap - Host - PortLDAP");
      domain.put(new Short((short)13), "Potencial ACTIVO SiNo");
      domain.put(new Short((short)14), "Varios");
   }

   public static String getDescription( com.genexus.internet.HttpContext httpContext ,
                                        short key )
   {
      if (domain.containsKey( key ))
      {
         return (String)domain.get( key );
      }
      else
      {
         return "";
      }
   }

   public static GXSimpleCollection<Short> getValues( )
   {
      GXSimpleCollection<Short> value = new GXSimpleCollection<Short>(Short.class, "internal", "");
      java.util.Iterator itr = domain.keySet().iterator();
      while(itr.hasNext())
      {
         value.add((Short) itr.next());
      }
      return value;
   }

}

