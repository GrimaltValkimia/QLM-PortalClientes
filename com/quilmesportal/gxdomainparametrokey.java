/*
               File: ParametroKEY
        Description: ParametroKEY
             Author: GeneXus Java Generator version 15_0_12-126726
       Generated on: September 23, 2020 13:37:31.18
       Program type: Callable routine
          Main DBMS: MySQL
*/
package com.quilmesportal ;
import com.quilmesportal.*;
import com.genexus.*;

public final  class gxdomainparametrokey
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new String((String)"1-1"), "Confirm MAIL_Host_Port");
      domain.put(new String((String)"1-2"), "Confirm MAIL_Secure_Sender");
      domain.put(new String((String)"1-3"), "ConfirmMAIL_ Auth_ User");
      domain.put(new String((String)"1-4"), "Confirm MAIL_Subject_Urlconfirm");
      domain.put(new String((String)"2-1"), "Google Maps_API_Key");
      domain.put(new String((String)"2-2"), "Posicion Inicial del mapa");
      domain.put(new String((String)"3-1"), "Cod Adicional_Campo");
      domain.put(new String((String)"3-2"), "Cod Adicional_Caract_Y");
      domain.put(new String((String)"3-3"), "Cod Adicional_Caract_X");
      domain.put(new String((String)"3-4"), "Menu_Id");
      domain.put(new String((String)"3-6"), "Buscar Deposito Zona Visita FUERA de los MAPAS S/N");
      domain.put(new String((String)"4-1"), "Mail_Tercer_Port_Host");
      domain.put(new String((String)"4-2"), "Mail_Tercer_Secure_Sender");
      domain.put(new String((String)"4-3"), "Mail_Tercer_Auth_User");
      domain.put(new String((String)"4-4"), "Mail_Tercer_Subject_Urlconfir");
      domain.put(new String((String)"4-5"), "Mail_Doc_Rechazado");
      domain.put(new String((String)"4-6"), "Mails Destino Creación Código Adicional");
      domain.put(new String((String)"5-1"), "Encryption Key");
      domain.put(new String((String)"5-2"), "Encryption Vector");
      domain.put(new String((String)"6-1"), "URLConfirmacion");
      domain.put(new String((String)"7-1"), "Capcha_Private_Key");
      domain.put(new String((String)"7-2"), "Capcha_Site_Key");
      domain.put(new String((String)"8-1"), "Fuerza Venta Activa");
      domain.put(new String((String)"8-2"), "Perfiles Impositivos (Default MD)");
      domain.put(new String((String)"8-3"), "Tipos Documento con Longitud Fija");
      domain.put(new String((String)"8-4"), "Permite alta con Documento inactivo");
      domain.put(new String((String)"8-5"), "Roles no ventas");
      domain.put(new String((String)"9-1"), "Log Activo_S/ N");
      domain.put(new String((String)"9-2"), "Path Archivo Log");
      domain.put(new String((String)"9-3"), "Path Temporales");
      domain.put(new String((String)"9-4"), "Hace un Log Detallado del proceso");
      domain.put(new String((String)"9-9"), "Path Temporales Docker");
      domain.put(new String((String)"9-10"), "Depura Proceso y LogProceso");
      domain.put(new String((String)"10-1"), "Minutos Token Activo para WS");
      domain.put(new String((String)"10-2"), "Máxima cantidad solicitudes/Clientes en WS");
      domain.put(new String((String)"11-1"), "Usuario_Invocar_CL");
      domain.put(new String((String)"12-1"), "GAM_KEY");
      domain.put(new String((String)"12-2"), "Ldap Ad Server");
      domain.put(new String((String)"12-3"), "LDAP_Host_Port");
      domain.put(new String((String)"13-1"), "ClientePotencialAct_ SN");
      domain.put(new String((String)"13-2"), "Sub Regiones Unificadas_SN");
      domain.put(new String((String)"13-3"), "Valida relación Territorio y Subregion de usuario");
      domain.put(new String((String)"14-1"), "Rol_Default");
      domain.put(new String((String)"14-2"), "Reintentos Respuesta Truck");
      domain.put(new String((String)"14-3"), "Reintentos Respuesta Truck Submit");
      domain.put(new String((String)"15-1"), "Google_Location Type");
      domain.put(new String((String)"16-1"), "Ultimo_NroSolicitud");
      domain.put(new String((String)"16-2"), "Extensiones Validas para Adjuntos");
      domain.put(new String((String)"17-1"), "Poner APP en mantenimiento");
      domain.put(new String((String)"17-2"), "WS AFIP activo");
      domain.put(new String((String)"18-1"), "Minutos que el Cliente permanece Bloqueado");
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

