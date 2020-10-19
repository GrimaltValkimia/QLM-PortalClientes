/*
               File: K2BFSGConstants
        Description: K2BFSGConstants
             Author: GeneXus Java Generator version 15_0_12-126726
       Generated on: September 23, 2020 13:37:31.4
       Program type: Callable routine
          Main DBMS: MySQL
*/
package com.quilmesportal ;
import com.quilmesportal.*;
import com.genexus.*;

public final  class gxdomaink2bfsgconstants
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new String((String)"LoginAttempts"), "Login Attempts");
      domain.put(new String((String)"LastLoginAttempt"), "Last Login Attempt");
      domain.put(new String((String)"SessionCaptchaIteSessionCaptchaItem"), "Session Captcha Item");
      domain.put(new String((String)"SessionCaptchaActive"), "Session Captcha Active");
      domain.put(new String((String)"SessionUserName"), "SessionUserName");
      domain.put(new String((String)"SessionUserRememberMe"), "SessionUserRememberMe");
      domain.put(new String((String)"SessionContinueLogin"), "SessionContinueLogin");
      domain.put(new String((String)"LastPasswordRecoveryEmailDate"), "Last Password Recovery Email Date");
      domain.put(new String((String)"ConfSendPasswordMail"), "ConfSendPasswordMail");
      domain.put(new String((String)"ConfMailSubject"), "Conf Mail Subject");
      domain.put(new String((String)"ConfMailMessage"), "Conf Mail Message");
      domain.put(new String((String)"ConfSMTPServerName"), "ConfSMTPServerName");
      domain.put(new String((String)"ConfSMTPUserName"), "Conf SMTPUser Name");
      domain.put(new String((String)"ConfSMTPPassword"), "Conf SMTPPassword");
      domain.put(new String((String)"ConfSMTPPort"), "Conf SMTPPort");
      domain.put(new String((String)"ConfSMTPAuthentication"), "Conf SMTPAuthentication");
      domain.put(new String((String)"ConfSMTPSenderName"), "Conf SMTPSender Name");
      domain.put(new String((String)"ConfSMTPSenderAddress"), "Conf SMTPSender Address");
      domain.put(new String((String)"ConfMinMinutesBetweenEmails"), "Conf Min Minutes Between Emails");
      domain.put(new String((String)"ConfServerHost"), "Conf Server Host");
      domain.put(new String((String)"ConfServerPort"), "Conf Server Port");
      domain.put(new String((String)"ConfServerBaseURL"), "Conf Server Base URL");
      domain.put(new String((String)"FSGAuthCookie"), "AuthCookie");
      domain.put(new String((String)"JavaGenerator"), "JavaGenerator");
      domain.put(new String((String)"CSharpGenerator"), "CSharpGenerator");
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

