/*
               File: TipoComprobante
        Description: TipoComprobante
             Author: GeneXus Java Generator version 15_0_12-126726
       Generated on: September 23, 2020 13:37:31.26
       Program type: Callable routine
          Main DBMS: MySQL
*/
package com.quilmesportal ;
import com.quilmesportal.*;
import com.genexus.*;

public final  class gxdomaintipocomprobante
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new Byte((byte)1), "Comprobante IVA");
      domain.put(new Byte((byte)2), "Comprobante IIBB");
      domain.put(new Byte((byte)3), "Comprobante Lic. Venta Alcohol");
      domain.put(new Byte((byte)4), "Exclusión IVA");
      domain.put(new Byte((byte)5), "Exclusión IIBB");
      domain.put(new Byte((byte)6), "Otro Archivo");
      domain.put(new Byte((byte)7), "Conformidad Baja");
   }

   public static String getDescription( com.genexus.internet.HttpContext httpContext ,
                                        byte key )
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

   public static GXSimpleCollection<Byte> getValues( )
   {
      GXSimpleCollection<Byte> value = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      java.util.Iterator itr = domain.keySet().iterator();
      while(itr.hasNext())
      {
         value.add((Byte) itr.next());
      }
      return value;
   }

}

