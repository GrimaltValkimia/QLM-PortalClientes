/*
               File: GAMErrorMessages
        Description: GAMErrorMessages
             Author: GeneXus Java Generator version 15_0_12-126726
       Generated on: September 23, 2020 13:37:30.46
       Program type: Callable routine
          Main DBMS: MySQL
*/
package com.quilmesportal ;
import com.quilmesportal.*;
import com.genexus.*;

public final  class gxdomaingamerrormessages
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new Long((long)1), "No se ha especificado la conexión al GAM, por favor contacte al administrador del GAM.");
      domain.put(new Long((long)2), "Repositorio %1 no encontrado, por favor contacte al administrador.");
      domain.put(new Long((long)3), "El tipo de autenticación no fue encontrado, por favor contacte al administrador.");
      domain.put(new Long((long)4), "Función del tipo de autenticación no encontrada.");
      domain.put(new Long((long)5), "El identificador de usuario no es válido.");
      domain.put(new Long((long)6), "El nombre de usuario no puede ser nulo.");
      domain.put(new Long((long)7), "Usuario no encontrado.");
      domain.put(new Long((long)8), "Usuario desconocido.");
      domain.put(new Long((long)9), "El Usuario no está activo, contacte al administrador.");
      domain.put(new Long((long)10), "El Usuario está bloqueado, contacte al administrador.");
      domain.put(new Long((long)11), "El usuario o la contraseña no es correcta.");
      domain.put(new Long((long)12), "Error al ejecutar el servicio de autenticación, contacte al administrador.");
      domain.put(new Long((long)13), "La sesión de usuario ha expirado, autentíquese nuevamente.");
      domain.put(new Long((long)14), "La sesión de usuario no existe, autentíquese nuevamente.");
      domain.put(new Long((long)15), "Tipo de sesión de usuario no válido, autentíquese nuevamente.");
      domain.put(new Long((long)16), "Error en la sesión de usuario, por favor contacte al administrador.");
      domain.put(new Long((long)18), "El usuario o la contraseña no es correcta.");
      domain.put(new Long((long)17), "Usuario no autorizado.");
      domain.put(new Long((long)19), "Reto de la conexión no encontrado, por favor contacte al administrador del GAM.");
      domain.put(new Long((long)20), "Modo de conexión al GAM no es válido, por favor contacte al administrador del GAM.");
      domain.put(new Long((long)21), "La sesión de usuario ha finalizado, autentíquese nuevamente.");
      domain.put(new Long((long)22), "El repositorio no tiene configurado el usuario anónimo, por favor contacte al administrador.");
      domain.put(new Long((long)23), "La contraseña debe ser cambiada, por favor cámbiela.");
      domain.put(new Long((long)24), "La contraseña ha expirado, por favor cámbiela.");
      domain.put(new Long((long)25), "La sesión del usuario fue bloqueada, cierre el navegador e intente autenticarse nuevamente.");
      domain.put(new Long((long)26), "No se permite cambiar la contraseña.");
      domain.put(new Long((long)27), "El nombre de usuario es muy corto, mínimo debe tener %1 caracteres.");
      domain.put(new Long((long)28), "El nombre de usuario no debe contener caracteres especiales.");
      domain.put(new Long((long)30), "La conexión al GAM no fue encontrada, por favor contacte al administrador del GAM.");
      domain.put(new Long((long)31), "Tipo de conexión al GAM no encontrado, por favor contacte al administrador del GAM.");
      domain.put(new Long((long)32), "El usuario de la conexión del repositorio no es válido (usuario:%1), contacte al administrador.");
      domain.put(new Long((long)33), "La contraseña de la conexión del usuario %1 no es correcta, por favor contacte al administrador del GAM.");
      domain.put(new Long((long)34), "El usuario de la conexión remota del repositorio no es válido (usuario:%1).");
      domain.put(new Long((long)35), "Tipo de autenticación no válido, por favor contacte al administrador.");
      domain.put(new Long((long)36), "Tipo de 'recordar usuario' no válido, por favor contacte al administrador.");
      domain.put(new Long((long)37), "Versión del servicio de autenticación no encontrada.");
      domain.put(new Long((long)38), "Versión del servicio de autenticación no soportada, contacte al administrador.");
      domain.put(new Long((long)39), "Aplicación no encontrada, por favor contacte al administrador.");
      domain.put(new Long((long)40), "Error en la respuesta del servicio de autenticación, por favor contacte al administrador de la aplicación.");
      domain.put(new Long((long)41), "Error en el usuario anónimo, favor contacte al administrador.");
      domain.put(new Long((long)42), "Error:");
      domain.put(new Long((long)43), "La clave para cambiar la contraseña del usuario es incorrecta, obtenga otra.");
      domain.put(new Long((long)44), "La clave para cambiar la contraseña del usuario ha expirado, obtenga otra.");
      domain.put(new Long((long)45), "La respuesta para recuperar la contraseña del usuario es incorrecta.");
      domain.put(new Long((long)46), "El espacio de nombres no puede ser nulo.");
      domain.put(new Long((long)47), "La descripción no puede ser nula.");
      domain.put(new Long((long)48), "Modo del API no reconocido, por favor contacte al administrador.");
      domain.put(new Long((long)49), "El nombre de usuario ya existe, por favor seleccione otro.");
      domain.put(new Long((long)50), "La cuenta de usuario ya se encuentra activada.");
      domain.put(new Long((long)51), "La clave de activación de usuario es incorrecta, debe registrarse nuevamente o contactarse con el administrador.");
      domain.put(new Long((long)52), "La clave de activación de usuario ha expirado, debe registrarse nuevamente o contactarse con el administrador.");
      domain.put(new Long((long)53), "El espacio de nombres no es válido, por favor contacte al administrador de la aplicación.");
      domain.put(new Long((long)54), "Error OpenId.");
      domain.put(new Long((long)55), "Identidad OpenId no corresponde, intente nuevamente.");
      domain.put(new Long((long)56), "Error en el Modo OpenId.");
      domain.put(new Long((long)57), "OpenId retornó un error: %1.");
      domain.put(new Long((long)59), "Error en la firma de OpenId.");
      domain.put(new Long((long)60), "Falta un dato requerido (%1).");
      domain.put(new Long((long)62), "Error en la sintaxis del correo electrónico, verifíquelo.");
      domain.put(new Long((long)63), "El correo electrónico es requerido, por favor ingrese uno.");
      domain.put(new Long((long)64), "La contrseña del usuario es requerida.");
      domain.put(new Long((long)65), "El primer nombre del usuario es requerido.");
      domain.put(new Long((long)66), "El apellido del usuario es requerido.");
      domain.put(new Long((long)67), "La fecha de nacimeinto es requerida.");
      domain.put(new Long((long)68), "El género del usuario es requerido.");
      domain.put(new Long((long)69), "El número de teléfono del usuario es requerido.");
      domain.put(new Long((long)70), "La dirección es requerida, debe ingresar una.");
      domain.put(new Long((long)71), "La Ciudad es requerida, ingrese una.");
      domain.put(new Long((long)72), "El estado/departamento/provincia es requerido, seleccione uno.");
      domain.put(new Long((long)73), "El País es requerido, ingrese uno.");
      domain.put(new Long((long)74), "El código postal del usuario es requerido.");
      domain.put(new Long((long)75), "El idioma del usuario es requerido, ingrese uno.");
      domain.put(new Long((long)76), "La zona horaria del usuario es requerida.");
      domain.put(new Long((long)77), "La foto del usuario es requerida.");
      domain.put(new Long((long)78), "Ya existe un usuario registrado con ese correo electrónico, seleccione otro.");
      domain.put(new Long((long)79), "Debe ingresar el nombre de usuario.");
      domain.put(new Long((long)80), "La aplicación padre no puede ser una aplicación base.");
      domain.put(new Long((long)81), "La aplicación padre no existe.");
      domain.put(new Long((long)82), "La aplicación base no es válida.");
      domain.put(new Long((long)83), "La aplicación base no existe.");
      domain.put(new Long((long)84), "La tipo de activación de Usuarios es incorrecto, por favor contacte al administrador.");
      domain.put(new Long((long)85), "El usuario ya tiene una sesión activa, por favor contacte al administrador.");
      domain.put(new Long((long)86), "Error al intentar grabar una cookie '%1', verifique la configuración de su navegador..");
      domain.put(new Long((long)87), "El repositorio requiere tener habilitado tipo de autenticación 'local', por favor contacte al administrador.");
      domain.put(new Long((long)88), "Servidor de autenticación externa no válido, por favor contacte al administrador de la aplicación.");
      domain.put(new Long((long)89), "Token del servicio de autenticación externo no es válido, favor contacte al administrador de la aplicación.");
      domain.put(new Long((long)90), "Error en el tipo de autenticación externo, por favor contacte al administrador de la aplicación.");
      domain.put(new Long((long)91), "Error de acceso a Facebook (%1), por favor contacte al administrador de la aplicación.");
      domain.put(new Long((long)92), "Error en la respuesta dada por Facebook, intente nuevamente.");
      domain.put(new Long((long)93), "Error al volver de la autenticación externa (%1).");
      domain.put(new Long((long)94), "Error en la respuesta enviada por Twitter, autentíquese nuevamente.");
      domain.put(new Long((long)95), "Error en el token enviado por Twitter, autentíquese nuevamente.");
      domain.put(new Long((long)96), "Error en la verificación de Twitter, autentíquese nuevamente.");
      domain.put(new Long((long)97), "Error de acceso a Twitter (%1).");
      domain.put(new Long((long)98), "No se obtuvo el GUID del usuario, por favor contacte al administrador.");
      domain.put(new Long((long)99), "El tipo de autenticación ya existe, no puede estar duplicado.");
      domain.put(new Long((long)100), "El protocolo oauth no está habilitado, por favor contacte al administrador.");
      domain.put(new Long((long)101), "Error en el refresh token, por favor autentíquese nuevamente.");
      domain.put(new Long((long)102), "El token está revocado, autentíquese nuevamente.");
      domain.put(new Long((long)103), "El token ha expirado, autentíquese nuevamente.");
      domain.put(new Long((long)104), "El usuario debe estar autenticado.");
      domain.put(new Long((long)106), "Permiso de acceso no encontrado, autentíquese nuevamente.");
      domain.put(new Long((long)107), "Permiso de acceso revocado, autentíquese nuevamente.");
      domain.put(new Long((long)108), "Solicitud de autorización no encontrada, por favor contacte al administrador.");
      domain.put(new Long((long)109), "Solicitud de autorización revocado, por favor contacte al administrador.");
      domain.put(new Long((long)110), "Solicitud de autorización rechazada, por favor contacte al administrador.");
      domain.put(new Long((long)111), "Applicación revocada, por favor contacte al administrador.");
      domain.put(new Long((long)112), "Token no encontrado, autentíquese nuevamente.");
      domain.put(new Long((long)113), "Token revocado, autentíquese nuevamente.");
      domain.put(new Long((long)114), "Token no válido, autentíquese nuevamente.");
      domain.put(new Long((long)115), "El repositorio ya existe, por favor contacte al administrador del GAM.");
      domain.put(new Long((long)116), "Código secreto de la Applicación no válido, por favor contacte al administrador.");
      domain.put(new Long((long)117), "Permiso no encontrado, por favor contacte al administrador.");
      domain.put(new Long((long)118), "El nombre de usuario es requerido.");
      domain.put(new Long((long)119), "La sesión cambió el IP desde donde fue solicitada, autentíquese nuevamente.");
      domain.put(new Long((long)120), "Configuración no permitida porque ya existen correos electrónicos duplicados.");
      domain.put(new Long((long)121), "Error en la sesión del usaurio, autentíquese nuevamente.");
      domain.put(new Long((long)122), "Error en el token, autentíquese nuevamente.");
      domain.put(new Long((long)123), "El token de la aplicación no existe.");
      domain.put(new Long((long)124), "El token de la aplicación ya existe.");
      domain.put(new Long((long)125), "El identificador externo del Usuario ya existe, por favor ingrese otro.");
      domain.put(new Long((long)126), "El código externo del Rol ya existe, por favor seleccione otro.");
      domain.put(new Long((long)127), "No se puede cambiar la conexión que está utilizando Ud. en este momento.");
      domain.put(new Long((long)128), "No se puede eliminar la conexión que está utilizando Ud. en este momento.");
      domain.put(new Long((long)129), "Error del token de acceso de Facebook (%1), por favor contacte al administrador de la aplicación.");
      domain.put(new Long((long)130), "La cuenta Facebook no está verificada, por favor verifique su cuenta en www.facebook.com.");
      domain.put(new Long((long)131), "Error al acceder a la cuenta de %1: %2");
      domain.put(new Long((long)132), "El usuario no existe en el Repositorio, por favor contacte al adminstrador.");
      domain.put(new Long((long)133), "Ambiente de la aplicación no encontrado, por favor contacte al administrador.");
      domain.put(new Long((long)134), "El permiso de acceso ha expirado, autentíquese nuevamente.");
      domain.put(new Long((long)135), "El permiso del token ha expirado, intente autenticarse nuevamente.");
      domain.put(new Long((long)136), "El permiso del token no se encontró, intente autenticarse nuevamente.");
      domain.put(new Long((long)137), "El attributo de usuario no existe.");
      domain.put(new Long((long)138), "El GUID o ClientId de la aplicación ya existe, por favor seleccione otro.");
      domain.put(new Long((long)139), "No autorizado: Acceso denegado.");
      domain.put(new Long((long)140), "El nombre de la aplicación no puede ser nulo.");
      domain.put(new Long((long)141), "La contraseña es muy corta, seleccione otra.");
      domain.put(new Long((long)142), "La contraseña debe contener números (mínimo %1).");
      domain.put(new Long((long)143), "La contraseña debe contener mayúsculas (mínimo %1).");
      domain.put(new Long((long)144), "La contraseña debe contener caracterres especiales (mínimo %1).");
      domain.put(new Long((long)145), "La contraseña actual y la nueva deben ser diferentes, pruebe con otra.");
      domain.put(new Long((long)146), "Contraseña usada recientemente, utilice otra diferente.");
      domain.put(new Long((long)147), "El correo electrónico es requerido para que el usuario se pueda autenticar con el.");
      domain.put(new Long((long)148), "El correo electrónico es requerido ya que está configurado para que sea único.");
      domain.put(new Long((long)149), "El correo electrónico debe ser único para que el usuario se pueda autenticar con el.");
      domain.put(new Long((long)150), "El directotio %1 no existe, por favor contacte al administrador.");
      domain.put(new Long((long)151), "El token no está relacionado a esta aplicación, autentíquese nuevamente.");
      domain.put(new Long((long)152), "El nombre del permiso no es válido.");
      domain.put(new Long((long)153), "El permiso no fue encontrado.");
      domain.put(new Long((long)154), "El nombre del permiso ya existe, por favor elija un nombre diferente.");
      domain.put(new Long((long)160), "La contraseña fue recientemente cambiada, deberá esperar %1 minutos para volver a realizarlo.");
      domain.put(new Long((long)161), "Hay datos incompletos del usuario. Para continuar debe completarlos.");
      domain.put(new Long((long)162), "La sesión ha expirado, autentíquese nuevamente, si el problema continúa contacte al administrador.");
      domain.put(new Long((long)163), "La llave para completar los datos del usuario no existe, autentíquese nuevamente, si el problema persiste contacte al administrador.");
      domain.put(new Long((long)164), "La expiración de la llave para recuperar la contraseña no puede ser nula.");
      domain.put(new Long((long)167), "No se pudo obtener el Id. del Dispositivo, cierre la aplicación y vuelva a ingresar.");
      domain.put(new Long((long)168), "El token no puede ser renovado, autentíquese nuevamente.");
      domain.put(new Long((long)169), "Error en la configuración de la aplicación, verifique la propiedad Auto-registro del usuario anónimo.");
      domain.put(new Long((long)170), "El espacio de nombres ya existe y su uso está restringido.");
      domain.put(new Long((long)171), "El archivo de conexiones al GAM no admite nombres de conexiones repetidas (%1)");
      domain.put(new Long((long)172), "No se puede eliminar el repositorio administrador del GAM.");
      domain.put(new Long((long)173), "El token no es válido para ser finalizado (no existe o ya no es un token válido).");
      domain.put(new Long((long)174), "Aplicación GUID %1 no definida, por favor contacte al administrador.");
      domain.put(new Long((long)175), "El nombre de la Política de Seguridad no puede ser nulo.");
      domain.put(new Long((long)176), "El nombre del Rol no puede ser nulo.");
      domain.put(new Long((long)177), "El nombre de rol ya existe, por favor seleccione otro.");
      domain.put(new Long((long)178), "El nombre del Repositorio no puede ser nulo.");
      domain.put(new Long((long)179), "El nombre de la conexión no puede ser nula.");
      domain.put(new Long((long)180), "El nombre del usuario de la conexión no puede ser nulo.");
      domain.put(new Long((long)182), "La contraseña del usuario de la conexión es requerida.");
      domain.put(new Long((long)183), "No se puede eliminar el Rol predeterminado del Repositorio.");
      domain.put(new Long((long)184), "No se puede eliminar el Rol de los usuarios anónimos de Dispositivos Móviles.");
      domain.put(new Long((long)185), "Operación no válida sobre un Usuario de tipo Dispositivo.");
      domain.put(new Long((long)200), "No encontrado.");
      domain.put(new Long((long)201), "Tipo de acceso no válido.");
      domain.put(new Long((long)202), "Error de acceso a Goolge (%1), por favor contacte al administrador de la aplicación.");
      domain.put(new Long((long)203), "Error en la respuesta dada por Google, intente nuevamente.");
      domain.put(new Long((long)204), "Error del token de acceso de Google (%1), por favor contacte al administrador de la aplicación.");
      domain.put(new Long((long)205), "Error en la respuesta de Google: %1");
      domain.put(new Long((long)206), "La cuenta Google no está verificada, por favor verifique su cuenta.");
      domain.put(new Long((long)207), "El directorio {0} es inválido. Faltan algunos archivos.");
      domain.put(new Long((long)208), "Falta la Política de Seguridad predeterminada del Repositorio.");
      domain.put(new Long((long)211), "Versión del servicio de autorización no soportada, contacte al administrador.");
      domain.put(new Long((long)212), "Error al ejecutar el servicio de autorización (%1).");
      domain.put(new Long((long)213), "GAM_ExternalTokenInvalid");
      domain.put(new Long((long)219), "Objeto home no encontrado.");
      domain.put(new Long((long)220), "Debe ingresar la URL de inicio de sesión local para la aplicación.");
      domain.put(new Long((long)221), "Debe ingresar la URL de devolución de la llamada a la aplicación.");
      domain.put(new Long((long)222), "URL de retorno de la llamada no coincide con la configurada en la aplicación (%1).");
      domain.put(new Long((long)230), "La aplicación no permite la autenticación remota, contacte al administrador.");
      domain.put(new Long((long)231), "La clave de encriptación privada de la aplicación no es correcta, contacte al administrador.");
      domain.put(new Long((long)232), "Falta la solicitud del scope para los datos del usuario, contacte al administrador.");
      domain.put(new Long((long)233), "La aplicación cliente no tiene permiso para obtener los datos adicionales del usuario, contacte al administrador.");
      domain.put(new Long((long)234), "La aplicación cliente no tiene permiso para obtener los roles del usuario, contacte al administrador.");
      domain.put(new Long((long)235), "La aplicación ha recibido un scope inválido, contacte al administrador.");
      domain.put(new Long((long)236), "La aplicación cliente no fue encontarda (%1), contacte al administrador.");
      domain.put(new Long((long)237), "Menú no encontrado, por favor contacte al administrador.");
      domain.put(new Long((long)238), "El nombre del menú no puede ser vacío.");
      domain.put(new Long((long)239), "El nombre de la opción de menu no puede ser vacío.");
      domain.put(new Long((long)240), "Tipo de autenticación no habilitado o no existe (%1).");
      domain.put(new Long((long)241), "El nombre del tipo de autenticación no puede ser nulo.");
      domain.put(new Long((long)242), "No existe este tipo de autenticación definido en el repositorio.");
      domain.put(new Long((long)243), "El identificador del cliente del tipo de autenticación no puede ser nulo.");
      domain.put(new Long((long)244), "El código secreto del cliente del tipo de autenticación no puede ser nulo.");
      domain.put(new Long((long)245), "La URL local del sitio no puede ser nula.");
      domain.put(new Long((long)246), "La URL del servidor remoto no puede ser nula.");
      domain.put(new Long((long)247), "El nombre del servicio web no puede ser nulo.");
      domain.put(new Long((long)248), "El nombre del servidor no puede ser nulo.");
      domain.put(new Long((long)249), "GAM_AuthenticationTypeConsumerKeyCannotBeNull");
      domain.put(new Long((long)250), "GAM_AuthenticationTypeConsumerSecretCannotBeNull");
      domain.put(new Long((long)251), "Debe ingresar la URL de devolución de la llamada al proveedor del servicio de autenticación.");
      domain.put(new Long((long)252), "El nombre del archivo del servicio de autenticación no puede ser nulo.");
      domain.put(new Long((long)253), "El nombre de la clase del servicio de autenticación no puede ser nulo.");
      domain.put(new Long((long)260), "El tipo de autenticación tiene definido usuarios, no puede ser elimiando.");
      domain.put(new Long((long)261), "Este tipo de autenticación es el predeterminado del repositorio, no puede ser eliminado.");
      domain.put(new Long((long)270), "Error de acceso del tipo de autentición GAMRemote, consulte al administrador.");
      domain.put(new Long((long)271), "Error en la respuesta dada por el servidor de autenticación remota, consulte al administrador.");
      domain.put(new Long((long)272), "Error al intentar obtener el token servidor de autenticación remota, consulte al administrador.");
      domain.put(new Long((long)273), "Error en la respuesta de %1: %2");
      domain.put(new Long((long)274), "La cuenta %1 no está verificada, por favor confirme su cuenta en %2 o contacte al administrador.");
      domain.put(new Long((long)275), "GAM_GAMRemoteEncryptionKeyError");
      domain.put(new Long((long)280), "Error de acceso a %1 (%2), por favor contacte al administrador de la aplicación.");
      domain.put(new Long((long)281), "Error en la respuesta dada por %1 (%2), intente nuevamente.");
      domain.put(new Long((long)282), "Error del token de acceso de %1, por favor contacte al administrador de la aplicación.");
      domain.put(new Long((long)283), "Error al acceder a la cuenta de %1: %2");
      domain.put(new Long((long)284), "La cuenta en %1 no está verificada, por favor verifique su cuenta de %1.");
      domain.put(new Long((long)290), "Scope (%1) no encontrado en permisos de la aplicación, contacte al administrador.");
      domain.put(new Long((long)291), "Código de acceso no encontrado, intente autenticarse nuevamente o contacte al administrador.");
      domain.put(new Long((long)292), "Tipo de permiso no encontrado, contacte al administrador.");
      domain.put(new Long((long)295), "La cuenta de Twitter no está verificada, ingrese a su cuenta en www.twiter.com y verifíquela.");
      domain.put(new Long((long)296), "Error del token de acceso de Twitter (%1), por favor contacte al administrador de la aplicación.");
      domain.put(new Long((long)297), "Error al acceder a la cuenta de %1: %2");
      domain.put(new Long((long)300), "El espacio de nombres del usuario no es válido, por favor contacte al administrador.");
      domain.put(new Long((long)301), "El usuario autenticado (GUID) existe con otro namespace, contacte al adminisatrdor.");
      domain.put(new Long((long)302), "GAM_UserAlreadyExistWithDifferentAuthenticationType");
      domain.put(new Long((long)303), "No se encontró el valor en el atributo multivaluado del usuario.");
      domain.put(new Long((long)304), "El atributo del usuario debe ser multivaluado.");
      domain.put(new Long((long)305), "Se requiere ingresar un id para el atributo de usuario ingresado.");
      domain.put(new Long((long)320), "GAM_EventSubscriptionEntityNull");
      domain.put(new Long((long)321), "GAM_EventSubscriptionActionNull");
      domain.put(new Long((long)322), "GAM_EventSubscriptionClassNameNull");
      domain.put(new Long((long)323), "GAM_EventSubscriprionFileNameNull");
      domain.put(new Long((long)324), "GAM_EventSubscriptionAlreadyExists");
      domain.put(new Long((long)325), "GAM_EventSubscriptionNotExists");
      domain.put(new Long((long)330), "La contraseña del usuario administrador es requerida..");
      domain.put(new Long((long)331), "La contraseña del usuario administrador es requerida.");
      domain.put(new Long((long)332), "Se debe configurar una aplicación existente en el repositorio %1 (CopyFromRepositoryId)");
      domain.put(new Long((long)333), "Se debe configurar la propiedad CopyApplication para utilizar CopyFromApplicationId");
      domain.put(new Long((long)334), "Se deben poner las propiedades CopyApplication y CopyRoles en True para copiar los permisos (CopyApplicationRolePermissions).");
      domain.put(new Long((long)335), "Se debe configurar la propiedad AdministratorRoleId para utilizar CopyRoles en True");
      domain.put(new Long((long)336), "Se debe configurar un Role existente en la propiedad AdministratorRoleId");
   }

   public static String getDescription( com.genexus.internet.HttpContext httpContext ,
                                        long key )
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

   public static GXSimpleCollection<Long> getValues( )
   {
      GXSimpleCollection<Long> value = new GXSimpleCollection<Long>(Long.class, "internal", "");
      java.util.Iterator itr = domain.keySet().iterator();
      while(itr.hasNext())
      {
         value.add((Long) itr.next());
      }
      return value;
   }

}

