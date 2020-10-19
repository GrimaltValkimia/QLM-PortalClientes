/*
               File: reorg
        Description: Table Manager
             Author: GeneXus Java Generator version 15_0_12-126726
       Generated on: September 23, 2020 13:37:21.48
       Program type: Callable routine
          Main DBMS: MySQL
*/
package com.quilmesportal ;
import com.quilmesportal.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.util.*;

public final  class reorg extends GXProcedure
{
   public reorg( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( reorg.class ), "" );
   }

   public reorg( int remoteHandle ,
                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( )
   {
      execute_int();
   }

   private void execute_int( )
   {
      initialize();
      SetCreateDataBase( ) ;
      DBConnectionManager.StartCreateDataBase( ) ;
      CreateDataBase( ) ;
      if ( previousCheck() )
      {
         executeReorganization( ) ;
      }
   }

   private void CreateDataBase( )
   {
      DS = DBConnection.getDataStore( "Default", remoteHandle) ;
      ErrCode = DS.connectDontShowErrors() ;
      DataBaseName = DS.getDatabasename() ;
      DBURLName = DS.getJdbcdriverurl() ;
      if ( ErrCode != 0 )
      {
         DS.setDatabasename( "" );
         ErrCode = DS.connect() ;
         if ( ErrCode == 0 )
         {
            try
            {
               GXReorganization.addMsg( localUtil.getMessages().getMessage("GXM_dbcrea")+ " " +DataBaseName );
               cmdBuffer = "CREATE DATABASE " + "`" + DataBaseName + "`" ;
               ExecuteDirectSQL.execute(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               Count = (byte)(1) ;
            }
            catch ( Exception ex )
            {
               ErrCode = (short)(1) ;
               ErrMsg = DS.getErrDescription() ;
               GXReorganization.addMsg( ErrMsg );
            }
            ErrCode = DS.disconnect() ;
            DS.setJdbcdriverurl( DBURLName );
            ErrCode = DS.connectDontShowErrors() ;
            while ( ( ErrCode != 0 ) && ( Count > 0 ) && ( Count < 30 ) )
            {
               Res = GXutil.sleep( 1) ;
               if ( Count == 29 )
               {
                  ErrCode = DS.connect() ;
               }
               else
               {
                  ErrCode = DS.connectDontShowErrors() ;
               }
               Count = (byte)(Count+1) ;
            }
         }
         if ( ErrCode != 0 )
         {
            ErrMsg = DS.getErrDescription() ;
            GXReorganization.addMsg( ErrMsg );
            ErrCode = (short)(1) ;
         }
      }
      DBConnectionManager.EndCreateDataBase( ) ;
   }

   private void FirstActions( )
   {
      /* Load data into tables. */
   }

   public void CreatePerfilImpositivoConfigJurisdic( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Indices for table PerfilImpositivoConfigJurisdic */
      try
      {
         cmdBufferCreate = " CREATE TABLE `PerfilImpositivoConfigJurisdic` (`PICID`  bigint NOT NULL , `PICJurisdiccionId` ";
         cmdBufferCreate += "   smallint NOT NULL , PRIMARY KEY(`PICID`, `PICJurisdiccionId`))  ENGINE=InnoDB ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "PerfilImpositivoConfigJurisdic", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `PerfilImpositivoConfigJurisdic` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "PerfilImpositivoConfigJurisdic", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `PerfilImpositivoConfigJurisdic` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "PerfilImpositivoConfigJurisdic", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `PerfilImpositivoConfigJurisdic` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      try
      {
         cmdBuffer = " CREATE INDEX `IPERFILIMPOSITIVOCONFIGURACIO6` ON `PerfilImpositivoConfigJurisdic` ";
         cmdBuffer += "  (`PICJurisdiccionId` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         cmdBuffer = " DROP INDEX `IPERFILIMPOSITIVOCONFIGURACIO6` ON `PerfilImpositivoConfigJurisdic` ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         cmdBuffer = " CREATE INDEX `IPERFILIMPOSITIVOCONFIGURACIO6` ON `PerfilImpositivoConfigJurisdic` ";
         cmdBuffer += "  (`PICJurisdiccionId` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void CreatePerfilImpositivoConfig( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Indices for table PerfilImpositivoConfig */
      try
      {
         cmdBufferCreate = " CREATE TABLE `PerfilImpositivoConfig` (`PICID`  bigint NOT NULL  AUTO_INCREMENT, ";
         cmdBufferCreate += "  `PaisCodigo`  smallint NOT NULL , `AFIPTiposIVACodigo`  smallint , `PICTipoIIBB` ";
         cmdBufferCreate += "   char(1) , `PICPerfilImpVTAId`  smallint NOT NULL , `PICPerfilImpMDId`  smallint ";
         cmdBufferCreate += "  , `PICPerfilImpMDValida`  BOOL NOT NULL , `PICTipoDocId`  smallint NOT NULL , `PICValidacionTipo` ";
         cmdBufferCreate += "   char(2) NOT NULL , `PICTodasProvincias`  BOOL NOT NULL , `PICActivo`  BOOL NOT ";
         cmdBufferCreate += "  NULL , `PICAdjuntoReq1`  smallint , `PICAdjuntoReq2`  smallint , `PICAdjuntoReq3` ";
         cmdBufferCreate += "   smallint , PRIMARY KEY(`PICID`))  ENGINE=InnoDB ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "PerfilImpositivoConfig", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `PerfilImpositivoConfig` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "PerfilImpositivoConfig", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `PerfilImpositivoConfig` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "PerfilImpositivoConfig", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `PerfilImpositivoConfig` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      try
      {
         cmdBuffer = " CREATE UNIQUE INDEX `UPERFILIMPCONFIGUNIQUE` ON `PerfilImpositivoConfig` (`PaisCodigo` ";
         cmdBuffer += "  ,`AFIPTiposIVACodigo` ,`PICTipoIIBB` ,`PICPerfilImpVTAId` ,`PICPerfilImpMDId` ,`PICTipoDocId` ";
         cmdBuffer += "  ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         cmdBuffer = " DROP INDEX `UPERFILIMPCONFIGUNIQUE` ON `PerfilImpositivoConfig` ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         cmdBuffer = " CREATE UNIQUE INDEX `UPERFILIMPCONFIGUNIQUE` ON `PerfilImpositivoConfig` (`PaisCodigo` ";
         cmdBuffer += "  ,`AFIPTiposIVACodigo` ,`PICTipoIIBB` ,`PICPerfilImpVTAId` ,`PICPerfilImpMDId` ,`PICTipoDocId` ";
         cmdBuffer += "  ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      try
      {
         cmdBuffer = " CREATE INDEX `IPERFILIMPOSITIVOCONFIGURACIO2` ON `PerfilImpositivoConfig` (`PICPerfilImpVTAId` ";
         cmdBuffer += "  ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         cmdBuffer = " DROP INDEX `IPERFILIMPOSITIVOCONFIGURACIO2` ON `PerfilImpositivoConfig` ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         cmdBuffer = " CREATE INDEX `IPERFILIMPOSITIVOCONFIGURACIO2` ON `PerfilImpositivoConfig` (`PICPerfilImpVTAId` ";
         cmdBuffer += "  ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      try
      {
         cmdBuffer = " CREATE INDEX `IPERFILIMPOSITIVOCONFIGURACIO3` ON `PerfilImpositivoConfig` (`PICPerfilImpMDId` ";
         cmdBuffer += "  ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         cmdBuffer = " DROP INDEX `IPERFILIMPOSITIVOCONFIGURACIO3` ON `PerfilImpositivoConfig` ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         cmdBuffer = " CREATE INDEX `IPERFILIMPOSITIVOCONFIGURACIO3` ON `PerfilImpositivoConfig` (`PICPerfilImpMDId` ";
         cmdBuffer += "  ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      try
      {
         cmdBuffer = " CREATE INDEX `IPERFILIMPOSITIVOCONFIGURACIO4` ON `PerfilImpositivoConfig` (`PICTipoDocId` ";
         cmdBuffer += "  ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         cmdBuffer = " DROP INDEX `IPERFILIMPOSITIVOCONFIGURACIO4` ON `PerfilImpositivoConfig` ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         cmdBuffer = " CREATE INDEX `IPERFILIMPOSITIVOCONFIGURACIO4` ON `PerfilImpositivoConfig` (`PICTipoDocId` ";
         cmdBuffer += "  ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      try
      {
         cmdBuffer = " CREATE INDEX `UPERFILIMPCONFIGBUSQUEDA` ON `PerfilImpositivoConfig` (`PaisCodigo` ";
         cmdBuffer += "  ,`PICTipoDocId` ,`PICActivo` ,`PICTodasProvincias` ,`AFIPTiposIVACodigo` ,`PICTipoIIBB` ";
         cmdBuffer += "  ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         cmdBuffer = " DROP INDEX `UPERFILIMPCONFIGBUSQUEDA` ON `PerfilImpositivoConfig` ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         cmdBuffer = " CREATE INDEX `UPERFILIMPCONFIGBUSQUEDA` ON `PerfilImpositivoConfig` (`PaisCodigo` ";
         cmdBuffer += "  ,`PICTipoDocId` ,`PICActivo` ,`PICTodasProvincias` ,`AFIPTiposIVACodigo` ,`PICTipoIIBB` ";
         cmdBuffer += "  ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void CreateComportamientoRol( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Indices for table ComportamientoRol */
      try
      {
         cmdBufferCreate = " CREATE TABLE `ComportamientoRol` (`PaisCodigo`  smallint NOT NULL , `AplicacionId` ";
         cmdBufferCreate += "   bigint NOT NULL , `RolId`  bigint NOT NULL , `RolHabilitaAltaFueraDirecta`  BOOL ";
         cmdBufferCreate += "  NOT NULL , `RolHabilitaTerrFueraSubRegion`  BOOL NOT NULL , `RolHabilitaCodAdicionales` ";
         cmdBufferCreate += "   BOOL NOT NULL , PRIMARY KEY(`PaisCodigo`, `AplicacionId`, `RolId`))  ENGINE=InnoDB ";
         cmdBufferCreate += "  ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "ComportamientoRol", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `ComportamientoRol` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "ComportamientoRol", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `ComportamientoRol` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "ComportamientoRol", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `ComportamientoRol` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
   }

   public void CreateServicioSolicitud( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Indices for table ServicioSolicitud */
      try
      {
         cmdBufferCreate = " CREATE TABLE `ServicioSolicitud` (`ServicioSolicitudId`  bigint NOT NULL  AUTO_INCREMENT, ";
         cmdBufferCreate += "  `ServicioSolicitudOrigen`  char(100) NOT NULL , `ServicioSolicitudOrigenId`  varchar(60) ";
         cmdBufferCreate += "  NOT NULL , `ServicioSolicitudDato`  MEDIUMTEXT NOT NULL , `ServicioSolicitudFecha` ";
         cmdBufferCreate += "   datetime NOT NULL , `ServicioSolicitudEstadoFecha`  datetime NOT NULL , `ServicioSolicitudEstado` ";
         cmdBufferCreate += "   char(3) NOT NULL , `ServicioSolicitudOk`  BOOL NOT NULL , `ServicioSolicitudErrores` ";
         cmdBufferCreate += "   TEXT NOT NULL , `ServicioSolicitudResultado`  TEXT NOT NULL , `ServicioSolicitudPaisCodigo` ";
         cmdBufferCreate += "   smallint NOT NULL , PRIMARY KEY(`ServicioSolicitudId`))  ENGINE=InnoDB ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "ServicioSolicitud", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `ServicioSolicitud` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "ServicioSolicitud", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `ServicioSolicitud` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "ServicioSolicitud", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `ServicioSolicitud` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      try
      {
         cmdBuffer = " CREATE INDEX `USERVICIOSOLICITUDIDEXTERNO` ON `ServicioSolicitud` (`ServicioSolicitudPaisCodigo` ";
         cmdBuffer += "  ,`ServicioSolicitudOrigen` ,`ServicioSolicitudOrigenId` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         cmdBuffer = " DROP INDEX `USERVICIOSOLICITUDIDEXTERNO` ON `ServicioSolicitud` ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         cmdBuffer = " CREATE INDEX `USERVICIOSOLICITUDIDEXTERNO` ON `ServicioSolicitud` (`ServicioSolicitudPaisCodigo` ";
         cmdBuffer += "  ,`ServicioSolicitudOrigen` ,`ServicioSolicitudOrigenId` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      try
      {
         cmdBuffer = " CREATE INDEX `USERVICIOSOLICITUDESTADO` ON `ServicioSolicitud` (`ServicioSolicitudPaisCodigo` ";
         cmdBuffer += "  ,`ServicioSolicitudEstado` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         cmdBuffer = " DROP INDEX `USERVICIOSOLICITUDESTADO` ON `ServicioSolicitud` ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         cmdBuffer = " CREATE INDEX `USERVICIOSOLICITUDESTADO` ON `ServicioSolicitud` (`ServicioSolicitudPaisCodigo` ";
         cmdBuffer += "  ,`ServicioSolicitudEstado` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      try
      {
         cmdBuffer = " CREATE INDEX `USERVICIOSOLICITUDPAISID` ON `ServicioSolicitud` (`ServicioSolicitudPaisCodigo` ";
         cmdBuffer += "  ,`ServicioSolicitudId` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         cmdBuffer = " DROP INDEX `USERVICIOSOLICITUDPAISID` ON `ServicioSolicitud` ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         cmdBuffer = " CREATE INDEX `USERVICIOSOLICITUDPAISID` ON `ServicioSolicitud` (`ServicioSolicitudPaisCodigo` ";
         cmdBuffer += "  ,`ServicioSolicitudId` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void CreateClienteSolicitudCodAdicional( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Indices for table ClienteSolicitudCodAdicional */
      try
      {
         cmdBufferCreate = " CREATE TABLE `ClienteSolicitudCodAdicional` (`PBaCID`  bigint NOT NULL , `CliSolCodAdjTpocodId` ";
         cmdBufferCreate += "   char(15) NOT NULL , `CliSolCodAdjTpoCodAdd`  char(15) NOT NULL , `CliSolCodAdjValorCaracter` ";
         cmdBufferCreate += "   char(45) NOT NULL , `CliSolCodAdjValorNumerico`  NUMERIC(17,5) NOT NULL , `CliSolCodAdjValorFecha` ";
         cmdBufferCreate += "   date NOT NULL , `CliSolCodAdjAccion`  char(1) NOT NULL , PRIMARY KEY(`PBaCID`, ";
         cmdBufferCreate += "  `CliSolCodAdjTpocodId`, `CliSolCodAdjTpoCodAdd`))  ENGINE=InnoDB ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "ClienteSolicitudCodAdicional", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `ClienteSolicitudCodAdicional` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "ClienteSolicitudCodAdicional", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `ClienteSolicitudCodAdicional` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "ClienteSolicitudCodAdicional", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `ClienteSolicitudCodAdicional` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
   }

   public void CreateAdicionalPtpocoCategoria( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Indices for table AdicionalPtpocoCategoria */
      try
      {
         cmdBufferCreate = " CREATE TABLE `AdicionalPtpocoCategoria` (`PaisCodigo`  smallint NOT NULL , `AdicionalTpocodId` ";
         cmdBufferCreate += "   char(15) NOT NULL , `AdicionalTpoCodAdd`  char(15) NOT NULL , `AdicionalTpoCatRelaVigente` ";
         cmdBufferCreate += "   char(1) NOT NULL , PRIMARY KEY(`PaisCodigo`, `AdicionalTpocodId`, `AdicionalTpoCodAdd`)) ";
         cmdBufferCreate += "   ENGINE=InnoDB ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "AdicionalPtpocoCategoria", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `AdicionalPtpocoCategoria` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "AdicionalPtpocoCategoria", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `AdicionalPtpocoCategoria` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "AdicionalPtpocoCategoria", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `AdicionalPtpocoCategoria` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      try
      {
         cmdBuffer = " CREATE INDEX `IADICIONALPTPOCOCATEGORIA1` ON `AdicionalPtpocoCategoria` (`PaisCodigo` ";
         cmdBuffer += "  ,`AdicionalTpoCodAdd` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         cmdBuffer = " DROP INDEX `IADICIONALPTPOCOCATEGORIA1` ON `AdicionalPtpocoCategoria` ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         cmdBuffer = " CREATE INDEX `IADICIONALPTPOCOCATEGORIA1` ON `AdicionalPtpocoCategoria` (`PaisCodigo` ";
         cmdBuffer += "  ,`AdicionalTpoCodAdd` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void CreateAdicionalTpoCoa( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Indices for table AdicionalTpoCoa */
      try
      {
         cmdBufferCreate = " CREATE TABLE `AdicionalTpoCoa` (`PaisCodigo`  smallint NOT NULL , `AdicionalTpoCodAdd` ";
         cmdBufferCreate += "   char(15) NOT NULL , `AdicionalCodAddAbv`  char(15) NOT NULL , `AdicionalCodAddTxt` ";
         cmdBufferCreate += "   char(45) NOT NULL , `AdicionalCodAddTipoValor`  smallint NOT NULL , `AdicionalCodAddExpRegular` ";
         cmdBufferCreate += "   char(100) NOT NULL , `AdicionalCodAddVigente`  char(1) NOT NULL , PRIMARY KEY(`PaisCodigo`, ";
         cmdBufferCreate += "  `AdicionalTpoCodAdd`))  ENGINE=InnoDB ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "AdicionalTpoCoa", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `AdicionalTpoCoa` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "AdicionalTpoCoa", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `AdicionalTpoCoa` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "AdicionalTpoCoa", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `AdicionalTpoCoa` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
   }

   public void CreateAdicionalPTpoCo( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Indices for table AdicionalPTpoCo */
      try
      {
         cmdBufferCreate = " CREATE TABLE `AdicionalPTpoCo` (`PaisCodigo`  smallint NOT NULL , `AdicionalTpocodId` ";
         cmdBufferCreate += "   char(15) NOT NULL , `AdicionalTpocodAbv`  char(15) NOT NULL , `AdicionalTpocodTxt` ";
         cmdBufferCreate += "   char(45) NOT NULL , `AdicionalTpocodReqValores`  smallint NOT NULL , `AdicionalTpocodCategoriaCombo` ";
         cmdBufferCreate += "   BOOL NOT NULL , `AdicionalTpocodVigente`  char(1) NOT NULL , PRIMARY KEY(`PaisCodigo`, ";
         cmdBufferCreate += "  `AdicionalTpocodId`))  ENGINE=InnoDB ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "AdicionalPTpoCo", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `AdicionalPTpoCo` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "AdicionalPTpoCo", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `AdicionalPTpoCo` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "AdicionalPTpoCo", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `AdicionalPTpoCo` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
   }

   public void CreateEntidadServicio( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Definition of ServicioDescripcion changed to char length 255 decimals 0 */
      /* Indices for table EntidadServicio */
      try
      {
         cmdBufferCreate = " CREATE TABLE `EntidadServicio` (`PaisCodigo`  smallint NOT NULL , `EntidadNombre` ";
         cmdBufferCreate += "   char(5) NOT NULL , `ServicioNombre`  char(50) NOT NULL , `ServicioDescripcion` ";
         cmdBufferCreate += "   char(255) NOT NULL , `ServicioConfiguracionRequiere`  BOOL NOT NULL , `ServicioLocationHost` ";
         cmdBufferCreate += "   varchar(1000) NOT NULL , `ServicioLocationPuerto`  mediumint NOT NULL , `ServicioLocationBaseURL` ";
         cmdBufferCreate += "   varchar(1000) NOT NULL , `ServicioLocationSecure`  smallint NOT NULL , `ServicioLocationAutenticacion` ";
         cmdBufferCreate += "   smallint NOT NULL , `ServicioLocationAutenMetodo`  smallint NOT NULL , `ServicioLocationUsuario` ";
         cmdBufferCreate += "   char(50) NOT NULL , `ServicioLocationPassword`  char(50) NOT NULL , `ServicioLocationRealm` ";
         cmdBufferCreate += "   char(50) NOT NULL , `ServicioLocationTimeOut`  mediumint NOT NULL , `ServicioToken` ";
         cmdBufferCreate += "   varchar(2048) NOT NULL , `ServicioTokenSign`  varchar(1024) NOT NULL , `ServicioTokenFechaGeneracion` ";
         cmdBufferCreate += "   datetime NOT NULL , `ServicioTokenFechaExpiracion`  datetime NOT NULL , PRIMARY ";
         cmdBufferCreate += "  KEY(`PaisCodigo`, `EntidadNombre`, `ServicioNombre`))  ENGINE=InnoDB ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "EntidadServicio", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `EntidadServicio` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "EntidadServicio", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `EntidadServicio` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "EntidadServicio", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `EntidadServicio` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
   }

   public void CreateEntidad( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Indices for table Entidad */
      try
      {
         cmdBufferCreate = " CREATE TABLE `Entidad` (`PaisCodigo`  smallint NOT NULL , `EntidadNombre`  char(5) ";
         cmdBufferCreate += "  NOT NULL , `EntidadCertificado`  LONGBLOB NOT NULL , `EntidadCertificadoExtension` ";
         cmdBufferCreate += "   char(5) NOT NULL , `EntidadCertificadoFechaVenc`  date NOT NULL , `EntidadConfiguracion` ";
         cmdBufferCreate += "   varchar(4096) NOT NULL , `EntidadConfiguracionFormato`  smallint NOT NULL , `EntidadErroresMostrar` ";
         cmdBufferCreate += "   MEDIUMTEXT NOT NULL , PRIMARY KEY(`PaisCodigo`, `EntidadNombre`))  ENGINE=InnoDB ";
         cmdBufferCreate += "  ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "Entidad", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `Entidad` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "Entidad", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `Entidad` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "Entidad", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `Entidad` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
   }

   public void CreatePerfilImpoAFIPJurisdiccion( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Indices for table PerfilImpoAFIPJurisdiccion */
      try
      {
         cmdBufferCreate = " CREATE TABLE `PerfilImpoAFIPJurisdiccion` (`PaisCodigo`  smallint NOT NULL , `AFIPTiposIVACodigo` ";
         cmdBufferCreate += "   smallint NOT NULL , `PerfilImpoAFIPTpoIIBB`  char(1) NOT NULL , `PerfilImpoAFIPImpcliId` ";
         cmdBufferCreate += "   smallint NOT NULL , `PerfilImpoAFIPJurisdiccionId`  smallint NOT NULL , PRIMARY ";
         cmdBufferCreate += "  KEY(`PaisCodigo`, `AFIPTiposIVACodigo`, `PerfilImpoAFIPTpoIIBB`, `PerfilImpoAFIPImpcliId`, ";
         cmdBufferCreate += "  `PerfilImpoAFIPJurisdiccionId`))  ENGINE=InnoDB ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "PerfilImpoAFIPJurisdiccion", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `PerfilImpoAFIPJurisdiccion` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "PerfilImpoAFIPJurisdiccion", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `PerfilImpoAFIPJurisdiccion` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "PerfilImpoAFIPJurisdiccion", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `PerfilImpoAFIPJurisdiccion` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      try
      {
         cmdBuffer = " CREATE INDEX `IPERFILIMPOAFIPJURISDICCION2` ON `PerfilImpoAFIPJurisdiccion` (`PerfilImpoAFIPJurisdiccionId` ";
         cmdBuffer += "  ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         cmdBuffer = " DROP INDEX `IPERFILIMPOAFIPJURISDICCION2` ON `PerfilImpoAFIPJurisdiccion` ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         cmdBuffer = " CREATE INDEX `IPERFILIMPOAFIPJURISDICCION2` ON `PerfilImpoAFIPJurisdiccion` (`PerfilImpoAFIPJurisdiccionId` ";
         cmdBuffer += "  ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void CreatePerfilImpoAFIP( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Indices for table PerfilImpoAFIP */
      try
      {
         cmdBufferCreate = " CREATE TABLE `PerfilImpoAFIP` (`PaisCodigo`  smallint NOT NULL , `AFIPTiposIVACodigo` ";
         cmdBufferCreate += "   smallint NOT NULL , `PerfilImpoAFIPTpoIIBB`  char(1) NOT NULL , `PerfilImpoAFIPImpcliId` ";
         cmdBufferCreate += "   smallint NOT NULL , `PerfilImpoAFIPTodasProvincias`  BOOL NOT NULL , `PerfilImpoAFIPActivo` ";
         cmdBufferCreate += "   BOOL NOT NULL , PRIMARY KEY(`PaisCodigo`, `AFIPTiposIVACodigo`, `PerfilImpoAFIPTpoIIBB`, ";
         cmdBufferCreate += "  `PerfilImpoAFIPImpcliId`))  ENGINE=InnoDB ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "PerfilImpoAFIP", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `PerfilImpoAFIP` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "PerfilImpoAFIP", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `PerfilImpoAFIP` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "PerfilImpoAFIP", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `PerfilImpoAFIP` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      try
      {
         cmdBuffer = " CREATE INDEX `IPERFILIMPOAFIP2` ON `PerfilImpoAFIP` (`PerfilImpoAFIPImpcliId` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         cmdBuffer = " DROP INDEX `IPERFILIMPOAFIP2` ON `PerfilImpoAFIP` ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         cmdBuffer = " CREATE INDEX `IPERFILIMPOAFIP2` ON `PerfilImpoAFIP` (`PerfilImpoAFIPImpcliId` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void CreateAFIPTiposIVA( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Indices for table AFIPTiposIVA */
      try
      {
         cmdBufferCreate = " CREATE TABLE `AFIPTiposIVA` (`PaisCodigo`  smallint NOT NULL , `AFIPTiposIVACodigo` ";
         cmdBufferCreate += "   smallint NOT NULL , `AFIPTiposIVADescripcion`  char(60) NOT NULL , `AFIPTiposIVATRUCK` ";
         cmdBufferCreate += "   smallint NOT NULL , PRIMARY KEY(`PaisCodigo`, `AFIPTiposIVACodigo`))  ENGINE=InnoDB ";
         cmdBufferCreate += "  ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "AFIPTiposIVA", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `AFIPTiposIVA` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "AFIPTiposIVA", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `AFIPTiposIVA` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "AFIPTiposIVA", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `AFIPTiposIVA` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
   }

   public void CreateClienteBloqueadoTmp( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Indices for table ClienteBloqueadoTmp */
      try
      {
         cmdBufferCreate = " CREATE TABLE `ClienteBloqueadoTmp` (`CliBloqTmpWorkStation`  char(60) NOT NULL , ";
         cmdBufferCreate += "  `CliBloqTmpPaisCodigo`  smallint NOT NULL , `CliBloqTmpClienteId`  bigint NOT NULL ";
         cmdBufferCreate += "  , `CliBloqTmpClienteNombre`  char(60) NOT NULL , `CliBloqTmpFechaAlta`  datetime ";
         cmdBufferCreate += "  NOT NULL , `CliBloqTmpUsuarioAlta`  char(20) NOT NULL , `CliBloqTmpPBaCId`  bigint ";
         cmdBufferCreate += "  NOT NULL , `CliBLoqTmpBloqueoTruck`  char(1) NOT NULL , PRIMARY KEY(`CliBloqTmpWorkStation`, ";
         cmdBufferCreate += "  `CliBloqTmpPaisCodigo`, `CliBloqTmpClienteId`))  ENGINE=InnoDB ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "ClienteBloqueadoTmp", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `ClienteBloqueadoTmp` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "ClienteBloqueadoTmp", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `ClienteBloqueadoTmp` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "ClienteBloqueadoTmp", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `ClienteBloqueadoTmp` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
   }

   public void CreateAlcoholLicenciaLocalidad( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Indices for table AlcoholLicenciaLocalidad */
      try
      {
         cmdBufferCreate = " CREATE TABLE `AlcoholLicenciaLocalidad` (`AlcoholLicenciaPaisId`  smallint NOT NULL ";
         cmdBufferCreate += "  , `AlcoholLicenciaDeptoId`  smallint NOT NULL , `AlcoholLicenciaLocalidadId`  char(15) ";
         cmdBufferCreate += "  NOT NULL , PRIMARY KEY(`AlcoholLicenciaPaisId`, `AlcoholLicenciaDeptoId`, `AlcoholLicenciaLocalidadId`)) ";
         cmdBufferCreate += "   ENGINE=InnoDB ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "AlcoholLicenciaLocalidad", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `AlcoholLicenciaLocalidad` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "AlcoholLicenciaLocalidad", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `AlcoholLicenciaLocalidad` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "AlcoholLicenciaLocalidad", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `AlcoholLicenciaLocalidad` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
   }

   public void CreateAlcoholLicenciaDepartamento( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Indices for table AlcoholLicenciaDepartamento */
      try
      {
         cmdBufferCreate = " CREATE TABLE `AlcoholLicenciaDepartamento` (`AlcoholLicenciaPaisId`  smallint NOT ";
         cmdBufferCreate += "  NULL , `AlcoholLicenciaDeptoId`  smallint NOT NULL , `AlcoholLicenciaDeptoRequiere` ";
         cmdBufferCreate += "   BOOL NOT NULL , PRIMARY KEY(`AlcoholLicenciaPaisId`, `AlcoholLicenciaDeptoId`)) ";
         cmdBufferCreate += "   ENGINE=InnoDB ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "AlcoholLicenciaDepartamento", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `AlcoholLicenciaDepartamento` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "AlcoholLicenciaDepartamento", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `AlcoholLicenciaDepartamento` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "AlcoholLicenciaDepartamento", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `AlcoholLicenciaDepartamento` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
   }

   public void CreateAlcoholLicencia( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Indices for table AlcoholLicencia */
      try
      {
         cmdBufferCreate = " CREATE TABLE `AlcoholLicencia` (`AlcoholLicenciaPaisId`  smallint NOT NULL , `AlcoholLicenciaPaisRequiere` ";
         cmdBufferCreate += "   char(1) NOT NULL , `AlcoholLicenciaUsuarioId`  char(120) NOT NULL , `AlcoholLicenciaFechaCambio` ";
         cmdBufferCreate += "   datetime NOT NULL , PRIMARY KEY(`AlcoholLicenciaPaisId`))  ENGINE=InnoDB ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "AlcoholLicencia", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `AlcoholLicencia` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "AlcoholLicencia", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `AlcoholLicencia` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "AlcoholLicencia", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `AlcoholLicencia` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
   }

   public void CreateLogProcesoActiva( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Definition of LogProcesoActivaDescripcion changed to char length 255 decimals 0 */
      /* Indices for table LogProcesoActiva */
      try
      {
         cmdBufferCreate = " CREATE TABLE `LogProcesoActiva` (`LogProcesoActivaNombre`  char(60) NOT NULL , `LogProcesoActivaDescripcion` ";
         cmdBufferCreate += "   char(255) NOT NULL , `LogProcesoActivaActivo`  char(1) NOT NULL , `LogProcesoActivaUltimoCambio` ";
         cmdBufferCreate += "   datetime NOT NULL , PRIMARY KEY(`LogProcesoActivaNombre`))  ENGINE=InnoDB ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "LogProcesoActiva", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `LogProcesoActiva` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "LogProcesoActiva", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `LogProcesoActiva` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "LogProcesoActiva", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `LogProcesoActiva` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
   }

   public void CreateClienteSolicitudAdjunto( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Indices for table ClienteSolicitudAdjunto */
      try
      {
         cmdBufferCreate = " CREATE TABLE `ClienteSolicitudAdjunto` (`PBaCID`  bigint NOT NULL , `ClienteSolAdjTipo` ";
         cmdBufferCreate += "   smallint NOT NULL , `ClienteSolAdjTrnNro`  int NOT NULL , `ClienteSolAdjCliId` ";
         cmdBufferCreate += "   mediumint NOT NULL , `ClienteSolAdjArchivo`  LONGBLOB NOT NULL , `ClienteSolAdjNombre` ";
         cmdBufferCreate += "   char(80) NOT NULL , `ClienteSolAdjExtension`  char(5) NOT NULL , `ClienteSolAdjRevisionUsuario` ";
         cmdBufferCreate += "   char(20) NOT NULL , `ClienteSolAdjRevisionFecha`  datetime NOT NULL , `ClienteSolAdjEstado` ";
         cmdBufferCreate += "   char(1) NOT NULL , `ClienteSolAdjObservacion`  varchar(1024) NOT NULL , PRIMARY ";
         cmdBufferCreate += "  KEY(`PBaCID`, `ClienteSolAdjTipo`))  ENGINE=InnoDB ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "ClienteSolicitudAdjunto", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `ClienteSolicitudAdjunto` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "ClienteSolicitudAdjunto", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `ClienteSolicitudAdjunto` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "ClienteSolicitudAdjunto", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `ClienteSolicitudAdjunto` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      try
      {
         cmdBuffer = " CREATE INDEX `UCLIENTESOLICITUDADJUNTOBUSCA` ON `ClienteSolicitudAdjunto` (`ClienteSolAdjCliId` ";
         cmdBuffer += "  ,`PBaCID` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         cmdBuffer = " DROP INDEX `UCLIENTESOLICITUDADJUNTOBUSCA` ON `ClienteSolicitudAdjunto` ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         cmdBuffer = " CREATE INDEX `UCLIENTESOLICITUDADJUNTOBUSCA` ON `ClienteSolicitudAdjunto` (`ClienteSolAdjCliId` ";
         cmdBuffer += "  ,`PBaCID` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void CreateClienteAdjunto( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Indices for table ClienteAdjunto */
      try
      {
         cmdBufferCreate = " CREATE TABLE `ClienteAdjunto` (`ClienteAdjuntoEmpId`  smallint NOT NULL , `ClienteAdjuntoCliId` ";
         cmdBufferCreate += "   mediumint NOT NULL , `ClienteAdjuntoTipo`  smallint NOT NULL , `ClienteAdjuntoVersion` ";
         cmdBufferCreate += "   smallint NOT NULL , `ClienteAdjuntoSolicitudOrigen`  int NOT NULL , `ClienteAdjuntoArchivo` ";
         cmdBufferCreate += "   LONGBLOB NOT NULL , `ClienteAdjuntoNombre`  char(80) NOT NULL , `ClienteAdjuntoExtension` ";
         cmdBufferCreate += "   char(5) NOT NULL , `ClienteAdjuntoAltaUsuario`  char(20) NOT NULL , `ClienteAdjuntoAltaFecha` ";
         cmdBufferCreate += "   datetime NOT NULL , `ClienteAdjuntoRevisionUsuario`  char(20) NOT NULL , `ClienteAdjuntoRevisionFecha` ";
         cmdBufferCreate += "   datetime NOT NULL , `ClienteAdjuntoVigente`  char(1) NOT NULL , PRIMARY KEY(`ClienteAdjuntoEmpId`, ";
         cmdBufferCreate += "  `ClienteAdjuntoCliId`, `ClienteAdjuntoTipo`, `ClienteAdjuntoVersion`))  ENGINE=InnoDB ";
         cmdBufferCreate += "  ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "ClienteAdjunto", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `ClienteAdjunto` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "ClienteAdjunto", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `ClienteAdjunto` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "ClienteAdjunto", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `ClienteAdjunto` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      try
      {
         cmdBuffer = " CREATE INDEX `UCLIENTEADJUNTO` ON `ClienteAdjunto` (`ClienteAdjuntoEmpId` ,`ClienteAdjuntoCliId` ";
         cmdBuffer += "  ,`ClienteAdjuntoVigente` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         cmdBuffer = " DROP INDEX `UCLIENTEADJUNTO` ON `ClienteAdjunto` ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         cmdBuffer = " CREATE INDEX `UCLIENTEADJUNTO` ON `ClienteAdjunto` (`ClienteAdjuntoEmpId` ,`ClienteAdjuntoCliId` ";
         cmdBuffer += "  ,`ClienteAdjuntoVigente` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void CreateProcesoPaso( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Indices for table ProcesoPaso */
      try
      {
         cmdBufferCreate = " CREATE TABLE `ProcesoPaso` (`ProcesoId`  bigint NOT NULL , `ProcesoPasoId`  smallint ";
         cmdBufferCreate += "  NOT NULL , `ProcesoPasoInicio`  datetime NOT NULL , `ProcesoPasoDescripcion`  varchar(256) ";
         cmdBufferCreate += "  NOT NULL , `ProcesoPasoFin`  datetime NOT NULL , `ProcesoPasoConError`  BOOL NOT ";
         cmdBufferCreate += "  NULL , `ProcesoPasoErrores`  MEDIUMTEXT NOT NULL , PRIMARY KEY(`ProcesoId`, `ProcesoPasoId`)) ";
         cmdBufferCreate += "   ENGINE=InnoDB ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "ProcesoPaso", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `ProcesoPaso` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "ProcesoPaso", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `ProcesoPaso` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "ProcesoPaso", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `ProcesoPaso` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
   }

   public void CreateProceso( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Indices for table Proceso */
      try
      {
         cmdBufferCreate = " CREATE TABLE `Proceso` (`ProcesoId`  bigint NOT NULL  AUTO_INCREMENT, `ProcesoKey` ";
         cmdBufferCreate += "   char(100) NOT NULL , `ProcesoKeyDescripcion`  char(100) NOT NULL , `ProcesoInicio` ";
         cmdBufferCreate += "   datetime NOT NULL , `ProcesoStatus`  char(3) NOT NULL , `ProcesoStatusActualizacion` ";
         cmdBufferCreate += "   datetime NOT NULL , `ProcesoFin`  datetime NOT NULL , `ProcesoConError`  BOOL NOT ";
         cmdBufferCreate += "  NULL , `ProcesoUsuarioNombre`  char(50) NOT NULL , `ProcesoWrkStn`  char(20) NOT ";
         cmdBufferCreate += "  NULL , `ProcesoPermiteCancel`  BOOL NOT NULL , `ProcesoDato`  MEDIUMTEXT , `ProcesoUltimoPaso` ";
         cmdBufferCreate += "   smallint NOT NULL , PRIMARY KEY(`ProcesoId`))  ENGINE=InnoDB ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "Proceso", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `Proceso` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "Proceso", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `Proceso` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "Proceso", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `Proceso` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      try
      {
         cmdBuffer = " CREATE INDEX `UPROCESOKEY` ON `Proceso` (`ProcesoUsuarioNombre` ,`ProcesoKey` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         cmdBuffer = " DROP INDEX `UPROCESOKEY` ON `Proceso` ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         cmdBuffer = " CREATE INDEX `UPROCESOKEY` ON `Proceso` (`ProcesoUsuarioNombre` ,`ProcesoKey` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      try
      {
         cmdBuffer = " CREATE INDEX `UPROCESOUSUARIO` ON `Proceso` (`ProcesoUsuarioNombre` ,`ProcesoId` ";
         cmdBuffer += "  ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         cmdBuffer = " DROP INDEX `UPROCESOUSUARIO` ON `Proceso` ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         cmdBuffer = " CREATE INDEX `UPROCESOUSUARIO` ON `Proceso` (`ProcesoUsuarioNombre` ,`ProcesoId` ";
         cmdBuffer += "  ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      try
      {
         cmdBuffer = " CREATE INDEX `UPROCESOFECHA` ON `Proceso` (`ProcesoInicio` ,`ProcesoKey` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         cmdBuffer = " DROP INDEX `UPROCESOFECHA` ON `Proceso` ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         cmdBuffer = " CREATE INDEX `UPROCESOFECHA` ON `Proceso` (`ProcesoInicio` ,`ProcesoKey` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void CreateLogProceso( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Indices for table LogProceso */
      try
      {
         cmdBufferCreate = " CREATE TABLE `LogProceso` (`LogId`  bigint NOT NULL  AUTO_INCREMENT, `LogFecha`  ";
         cmdBufferCreate += "  datetime NOT NULL , `LogProceso`  char(128) NOT NULL , `LogTipo`  char(1) NOT NULL ";
         cmdBufferCreate += "  , `LogTexto`  varchar(256) NOT NULL , `LogContexto`  varchar(2048) NOT NULL , PRIMARY ";
         cmdBufferCreate += "  KEY(`LogId`))  ENGINE=InnoDB ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "LogProceso", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `LogProceso` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "LogProceso", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `LogProceso` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "LogProceso", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `LogProceso` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      try
      {
         cmdBuffer = " CREATE INDEX `ULOGPROCESOWW` ON `LogProceso` (`LogFecha` ,`LogProceso` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         cmdBuffer = " DROP INDEX `ULOGPROCESOWW` ON `LogProceso` ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         cmdBuffer = " CREATE INDEX `ULOGPROCESOWW` ON `LogProceso` (`LogFecha` ,`LogProceso` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void CreateEquivalencia( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Indices for table Equivalencia */
      try
      {
         cmdBufferCreate = " CREATE TABLE `Equivalencia` (`EquivalenciaId`  int NOT NULL  AUTO_INCREMENT, `EmpId` ";
         cmdBufferCreate += "   smallint NOT NULL , `EquivalenciaAmbito`  char(3) NOT NULL , `EquivalenciaOrigen` ";
         cmdBufferCreate += "   char(80) NOT NULL , `EquivalenciaRemplazo`  char(45) NOT NULL , PRIMARY KEY(`EquivalenciaId`)) ";
         cmdBufferCreate += "   ENGINE=InnoDB ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "Equivalencia", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `Equivalencia` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "Equivalencia", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `Equivalencia` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "Equivalencia", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `Equivalencia` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      try
      {
         cmdBuffer = " CREATE UNIQUE INDEX `UEQUIVALENCIAUNIQUE` ON `Equivalencia` (`EmpId` ,`EquivalenciaAmbito` ";
         cmdBuffer += "  ,`EquivalenciaOrigen` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         cmdBuffer = " DROP INDEX `UEQUIVALENCIAUNIQUE` ON `Equivalencia` ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         cmdBuffer = " CREATE UNIQUE INDEX `UEQUIVALENCIAUNIQUE` ON `Equivalencia` (`EmpId` ,`EquivalenciaAmbito` ";
         cmdBuffer += "  ,`EquivalenciaOrigen` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void CreateSubRegionAlcohol( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Indices for table SubRegionAlcohol */
      try
      {
         cmdBufferCreate = " CREATE TABLE `SubRegionAlcohol` (`EmpId`  smallint NOT NULL , `SubRegionId`  smallint ";
         cmdBufferCreate += "  NOT NULL , `SubRegionAlcoholObligatorio`  char(1) NOT NULL , PRIMARY KEY(`EmpId`, ";
         cmdBufferCreate += "  `SubRegionId`))  ENGINE=InnoDB ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "SubRegionAlcohol", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `SubRegionAlcohol` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "SubRegionAlcohol", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `SubRegionAlcohol` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "SubRegionAlcohol", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `SubRegionAlcohol` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
   }

   public void CreateClienteSolicitudTerrDiaVisita( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Indices for table ClienteSolicitudTerrDiaVisita */
      try
      {
         cmdBufferCreate = " CREATE TABLE `ClienteSolicitudTerrDiaVisita` (`PBaCID`  bigint NOT NULL , `PBaCTrrCategoria` ";
         cmdBufferCreate += "   char(3) NOT NULL , `PBaCTrrId`  mediumint NOT NULL , `PBaCTrrDia`  smallint NOT ";
         cmdBufferCreate += "  NULL , `PBacTrrDiaTpoFrec`  char(4) NOT NULL , `PBacTrrDiaCliVisAnt`  bigint NOT ";
         cmdBufferCreate += "  NULL , PRIMARY KEY(`PBaCID`, `PBaCTrrCategoria`, `PBaCTrrId`, `PBaCTrrDia`))  ENGINE=InnoDB ";
         cmdBufferCreate += "  ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "ClienteSolicitudTerrDiaVisita", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `ClienteSolicitudTerrDiaVisita` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "ClienteSolicitudTerrDiaVisita", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `ClienteSolicitudTerrDiaVisita` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "ClienteSolicitudTerrDiaVisita", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `ClienteSolicitudTerrDiaVisita` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
   }

   public void CreateClienteSolicitudTerr( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Indices for table ClienteSolicitudTerr */
      try
      {
         cmdBufferCreate = " CREATE TABLE `ClienteSolicitudTerr` (`PBaCID`  bigint NOT NULL , `PBaCTrrCategoria` ";
         cmdBufferCreate += "   char(3) NOT NULL , `PBaCTrrId`  mediumint NOT NULL , `PBaCTrrCentroDespacho`  char(3) ";
         cmdBufferCreate += "  NOT NULL , `PBaCTrrCanalVenta`  smallint NOT NULL , `PBaCTrrVisitaOrden`  smallint ";
         cmdBufferCreate += "  NOT NULL , `PBaCTrrVisitaFrecuencia`  smallint NOT NULL , `PBaCZonId`  char(4) , ";
         cmdBufferCreate += "  `PBaCRegId`  smallint , PRIMARY KEY(`PBaCID`, `PBaCTrrCategoria`, `PBaCTrrId`)) ";
         cmdBufferCreate += "   ENGINE=InnoDB ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "ClienteSolicitudTerr", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `ClienteSolicitudTerr` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "ClienteSolicitudTerr", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `ClienteSolicitudTerr` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "ClienteSolicitudTerr", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `ClienteSolicitudTerr` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
   }

   public void CreateClienteSolicitud( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Indices for table ClienteSolicitud */
      try
      {
         cmdBufferCreate = " CREATE TABLE `ClienteSolicitud` (`PBaCID`  bigint NOT NULL  AUTO_INCREMENT, `PBaCTrnNro` ";
         cmdBufferCreate += "   int NOT NULL , `PBaCTipTrn`  char(3) NOT NULL , `PBaCCliNom`  char(45) NOT NULL ";
         cmdBufferCreate += "  , `PBaCCliAbv`  char(15) NOT NULL , `PBaCCliDom`  char(45) NOT NULL , `DptId`  smallint ";
         cmdBufferCreate += "  NOT NULL , `PBaCCodPst`  char(10) NOT NULL , `Lcdid`  char(15) NOT NULL , `PBaCNroTel` ";
         cmdBufferCreate += "   char(15) NOT NULL , `PBaCFchApe`  date , `PBaCFchBaj`  date , `PBaCCodRUC`  char(20) ";
         cmdBufferCreate += "  NOT NULL , `PBaCTipoNegocio`  char(40) NOT NULL , `MTVEId`  smallint , `PBacFlgAutV` ";
         cmdBufferCreate += "   char(1) , `PBaCCodLic`  char(15) , `PBaCFchLic`  date , `PBaCFchUltA`  date , `PBaCHorUltA` ";
         cmdBufferCreate += "   char(8) , `CliIdPrf`  char(15) NOT NULL , `PBaCImpCliI`  smallint NOT NULL , `PBacNroDom` ";
         cmdBufferCreate += "   char(7) NOT NULL , `PBacDptDom`  char(7) NOT NULL , `PBaCNomFnt`  char(30) , `PBacNomPrp` ";
         cmdBufferCreate += "   char(45) , `CliDocTpo`  smallint NOT NULL , `PBaCCodMail`  char(30) NOT NULL , ";
         cmdBufferCreate += "  `PBaCCliAdy`  mediumint , `PBaCCooX`  char(45) , `PBaCCooY`  char(45) , `PBaCTpoIngB` ";
         cmdBufferCreate += "   char(1) , `PBaCNroBru`  char(15) , `PBaCCodCmp`  char(45) , `PBaCMsgId`  smallint ";
         cmdBufferCreate += "  , `PBaCMsgFac`  char(15) , `PBaCCzaTpoI`  smallint , `PBaCIdCbr`  char(15) , `PBaCFlgExc` ";
         cmdBufferCreate += "   char(1) , `PBaCTpoVin`  char(3) , `PBaCIdFaMov`  smallint , `PBaCIdSoMov`  smallint ";
         cmdBufferCreate += "  , `PBaCFchAniv`  date , `PBacFlgPagD`  char(1) , `PBacValTope`  smallint , `PBACTIPOCON` ";
         cmdBufferCreate += "   char(1) , `PBaCFchIniR`  date , `PBaCCodAnt`  char(10) , `PBaCMaxDias`  smallint ";
         cmdBufferCreate += "  , `PBaCNroJur`  char(15) , `PBaCFlgIcc`  char(1) , `PBaCNroTck`  char(10) , `PBaCIdGpoCo` ";
         cmdBufferCreate += "   mediumint , `PBaCTpoInfC`  smallint , `FmapgoId`  smallint , `PBaCIdPzo`  smallint ";
         cmdBufferCreate += "  , `PBaCCrdVal`  bigint , `PBaCFchModC`  date , `PBaCCplCval`  NUMERIC(13,2) , `PBaCCplFlgC` ";
         cmdBufferCreate += "   smallint , `PBaCFlgCtc`  char(1) , `PBaCSdoCtc`  NUMERIC(13,2) , `PBaCSdoDoc`  ";
         cmdBufferCreate += "  NUMERIC(13,2) , `PBaCTotDeb`  NUMERIC(13,2) , `PBaCTotCre`  NUMERIC(13,2) , `PBaCFchFUlt` ";
         cmdBufferCreate += "   date , `PBaCFchPUlt`  date , `PBaCValMayS`  NUMERIC(13,2) , `PBaCSts`  smallint ";
         cmdBufferCreate += "  , `PBaCTpoCon`  smallint , `ZonaEntregaDepCod`  smallint , `PBaCTxtGtia`  char(45) ";
         cmdBufferCreate += "  , `PBaCTotGtia`  NUMERIC(13,2) , `PaisCodigo`  smallint NOT NULL , `PBaCEmpId`  ";
         cmdBufferCreate += "  smallint , `PBacTpoEmp`  char(1) , `PBaCCliId`  mediumint NOT NULL , `PBaCIdCtc` ";
         cmdBufferCreate += "   mediumint , `PBaCRamId`  smallint , `PBaCCodAtn`  mediumint , `PBacFlgDesP`  char(1) ";
         cmdBufferCreate += "  , `PBacFlgPrm`  char(1) , `PBacTpoCndV`  mediumint , `PBaCTpoLprB`  smallint , `PBaCTpoLprM` ";
         cmdBufferCreate += "   smallint , `PBacValPriA`  smallint , `PBacIdMonDf`  char(3) , `CliValCat`  char(3) ";
         cmdBufferCreate += "  , `PBacCliPotencial`  char(15) , `PBacFchUltV`  date , `PBaCFchVigC`  date , `PBaCTpoCom` ";
         cmdBufferCreate += "   smallint , `PBaCFlgRem`  char(1) , `PBaCFlgCteE`  char(1) , `PBaCPrjPer`  NUMERIC(6,2) ";
         cmdBufferCreate += "  , `PBaCFlgEgc`  char(1) , `PBaCUltEgc`  smallint , `PBaCCodJur`  char(15) , `PBaCPerDesF` ";
         cmdBufferCreate += "   date , `PBaCPerHasF`  date , `PBaCIbtDesF`  date , `PBaCIbtHasF`  date , `PBaCFlgSeg` ";
         cmdBufferCreate += "   char(1) , `PBaCNImpInt`  char(15) , `PBaCVal1Clf`  mediumint , `PBaCVal2Clf`  mediumint ";
         cmdBufferCreate += "  , `PBaCVal3Clf`  mediumint , `PBaCIdBcoDf`  smallint , `PBaCNroPrv`  char(15) , ";
         cmdBufferCreate += "  `PBaCFlgCns`  char(1) , `PBaCTpoVnd`  char(1) , `PBaCFlgExp`  char(1) , `PBaCDocNro` ";
         cmdBufferCreate += "   char(20) NOT NULL , `PBaCMaySFch`  date , `PBaCPrjIngB`  NUMERIC(6,2) , `PBaCTrnFechaEnvio` ";
         cmdBufferCreate += "   datetime NOT NULL , `PBaCFechaUltimoCambio`  datetime NOT NULL , `PBaCFechaAlta` ";
         cmdBufferCreate += "   date NOT NULL , `PBaCUsuarioAltaId`  char(20) , `PBaConfirmEmail`  BOOL NOT NULL ";
         cmdBufferCreate += "  , `PBaCAltaCompleta`  BOOL NOT NULL , `PBaCObservaciones`  varchar(100) , `PBaCTrnNroAgrupador` ";
         cmdBufferCreate += "   int NOT NULL , `PBaCTipoOperacion`  char(3) , `PBaCTipoOperacionAgrupador`  char(3) ";
         cmdBufferCreate += "  NOT NULL , `PBaCSolicitudEstado`  char(3) , `PBaCDocumentosCheck`  char(1) NOT NULL ";
         cmdBufferCreate += "  , `PBaCUltimoMovimientoOK`  BOOL , `PBaCModificar`  char(1) NOT NULL , `PBaCAutorizar` ";
         cmdBufferCreate += "   char(1) NOT NULL , `PBaCSemanaInicio`  smallint NOT NULL , `PBaCClienteReferencia` ";
         cmdBufferCreate += "   mediumint , `PBaCDistribuidoresId`  char(80) , `PBaCBajaConformidad`  LONGBLOB ";
         cmdBufferCreate += "  , `PBaCBajaConformidadExtension`  char(5) NOT NULL , `PBaCSolReprocesadaId`  bigint ";
         cmdBufferCreate += "  , `PBaCSolReprocesadaTrnNroAgru`  int , `PBaCModoEnvioTruck`  char(1) NOT NULL , ";
         cmdBufferCreate += "  `PBaCClienteDatosAnterior`  TEXT , `PBaCClienteDatosAFIP`  MEDIUMTEXT , `PBaCIVAWSok` ";
         cmdBufferCreate += "   BOOL NOT NULL , `PBaCLicenciaAlcoholPendiente`  char(1) NOT NULL , `PBaCLicenciaAlcoholConfirmada` ";
         cmdBufferCreate += "   datetime NOT NULL , `PBaCLicenciaAlcoholOrigenPBaCI`  bigint NOT NULL , `PBaCOrigen` ";
         cmdBufferCreate += "   char(100) NOT NULL , `PBaCOrigenId`  varchar(60) NOT NULL , `PBaCOrigenUsuario` ";
         cmdBufferCreate += "   char(100) NOT NULL , `PBaCclienteB2B`  char(15) NOT NULL , `PBaCMDValida`  char(1) ";
         cmdBufferCreate += "  NOT NULL , `PBaCMDFechaValidacion`  datetime NOT NULL , PRIMARY KEY(`PBaCID`))  ";
         cmdBufferCreate += "  ENGINE=InnoDB ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "ClienteSolicitud", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `ClienteSolicitud` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "ClienteSolicitud", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `ClienteSolicitud` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "ClienteSolicitud", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `ClienteSolicitud` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      try
      {
         cmdBuffer = " CREATE INDEX `ICLIENTESOLICITUD1` ON `ClienteSolicitud` (`CliValCat` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         cmdBuffer = " DROP INDEX `ICLIENTESOLICITUD1` ON `ClienteSolicitud` ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         cmdBuffer = " CREATE INDEX `ICLIENTESOLICITUD1` ON `ClienteSolicitud` (`CliValCat` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      try
      {
         cmdBuffer = " CREATE INDEX `ICLIENTESOLICITUD2` ON `ClienteSolicitud` (`PaisCodigo` ,`ZonaEntregaDepCod` ";
         cmdBuffer += "  ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         cmdBuffer = " DROP INDEX `ICLIENTESOLICITUD2` ON `ClienteSolicitud` ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         cmdBuffer = " CREATE INDEX `ICLIENTESOLICITUD2` ON `ClienteSolicitud` (`PaisCodigo` ,`ZonaEntregaDepCod` ";
         cmdBuffer += "  ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      try
      {
         cmdBuffer = " CREATE INDEX `ICLIENTESOLICITUD3` ON `ClienteSolicitud` (`PaisCodigo` ,`MTVEId` ) ";
         cmdBuffer += "  ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         cmdBuffer = " DROP INDEX `ICLIENTESOLICITUD3` ON `ClienteSolicitud` ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         cmdBuffer = " CREATE INDEX `ICLIENTESOLICITUD3` ON `ClienteSolicitud` (`PaisCodigo` ,`MTVEId` ) ";
         cmdBuffer += "  ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      try
      {
         cmdBuffer = " CREATE INDEX `ICLIENTESOLICITUD4` ON `ClienteSolicitud` (`FmapgoId` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         cmdBuffer = " DROP INDEX `ICLIENTESOLICITUD4` ON `ClienteSolicitud` ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         cmdBuffer = " CREATE INDEX `ICLIENTESOLICITUD4` ON `ClienteSolicitud` (`FmapgoId` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      try
      {
         cmdBuffer = " CREATE INDEX `ICLIENTESOLICITUD5` ON `ClienteSolicitud` (`CliDocTpo` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         cmdBuffer = " DROP INDEX `ICLIENTESOLICITUD5` ON `ClienteSolicitud` ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         cmdBuffer = " CREATE INDEX `ICLIENTESOLICITUD5` ON `ClienteSolicitud` (`CliDocTpo` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      try
      {
         cmdBuffer = " CREATE INDEX `ICLIENTESOLICITUD6` ON `ClienteSolicitud` (`CliIdPrf` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         cmdBuffer = " DROP INDEX `ICLIENTESOLICITUD6` ON `ClienteSolicitud` ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         cmdBuffer = " CREATE INDEX `ICLIENTESOLICITUD6` ON `ClienteSolicitud` (`CliIdPrf` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      try
      {
         cmdBuffer = " CREATE INDEX `ICLIENTESOLICITUD7` ON `ClienteSolicitud` (`Lcdid` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         cmdBuffer = " DROP INDEX `ICLIENTESOLICITUD7` ON `ClienteSolicitud` ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         cmdBuffer = " CREATE INDEX `ICLIENTESOLICITUD7` ON `ClienteSolicitud` (`Lcdid` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      try
      {
         cmdBuffer = " CREATE INDEX `ICLIENTESOLICITUD8` ON `ClienteSolicitud` (`DptId` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         cmdBuffer = " DROP INDEX `ICLIENTESOLICITUD8` ON `ClienteSolicitud` ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         cmdBuffer = " CREATE INDEX `ICLIENTESOLICITUD8` ON `ClienteSolicitud` (`DptId` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      try
      {
         cmdBuffer = " CREATE INDEX `UCLIENTESOLICITUDNUMERO` ON `ClienteSolicitud` (`PaisCodigo` ,`PBaCTipTrn` ";
         cmdBuffer += "  ,`PBaCTrnNro` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         cmdBuffer = " DROP INDEX `UCLIENTESOLICITUDNUMERO` ON `ClienteSolicitud` ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         cmdBuffer = " CREATE INDEX `UCLIENTESOLICITUDNUMERO` ON `ClienteSolicitud` (`PaisCodigo` ,`PBaCTipTrn` ";
         cmdBuffer += "  ,`PBaCTrnNro` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      try
      {
         cmdBuffer = " CREATE INDEX `UCLIENTESOLICITUDAGRUPADOR` ON `ClienteSolicitud` (`PaisCodigo` ,`PBaCTrnNroAgrupador` ";
         cmdBuffer += "  ,`PBaCTrnNro` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         cmdBuffer = " DROP INDEX `UCLIENTESOLICITUDAGRUPADOR` ON `ClienteSolicitud` ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         cmdBuffer = " CREATE INDEX `UCLIENTESOLICITUDAGRUPADOR` ON `ClienteSolicitud` (`PaisCodigo` ,`PBaCTrnNroAgrupador` ";
         cmdBuffer += "  ,`PBaCTrnNro` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      try
      {
         cmdBuffer = " CREATE INDEX `UCLIENTESOLICITUDCLIENTE` ON `ClienteSolicitud` (`PBaCTipTrn` ,`PBaCEmpId` ";
         cmdBuffer += "  ,`PBaCCliId` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         cmdBuffer = " DROP INDEX `UCLIENTESOLICITUDCLIENTE` ON `ClienteSolicitud` ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         cmdBuffer = " CREATE INDEX `UCLIENTESOLICITUDCLIENTE` ON `ClienteSolicitud` (`PBaCTipTrn` ,`PBaCEmpId` ";
         cmdBuffer += "  ,`PBaCCliId` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      try
      {
         cmdBuffer = " CREATE INDEX `UCLIENTESOLICITUDESTADO` ON `ClienteSolicitud` (`PBaCSolicitudEstado` ";
         cmdBuffer += "  ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         cmdBuffer = " DROP INDEX `UCLIENTESOLICITUDESTADO` ON `ClienteSolicitud` ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         cmdBuffer = " CREATE INDEX `UCLIENTESOLICITUDESTADO` ON `ClienteSolicitud` (`PBaCSolicitudEstado` ";
         cmdBuffer += "  ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      try
      {
         cmdBuffer = " CREATE INDEX `UCLIENTESOLICITUDEMPRESA` ON `ClienteSolicitud` (`PBaCEmpId` ,`PBaCCliId` ";
         cmdBuffer += "  ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         cmdBuffer = " DROP INDEX `UCLIENTESOLICITUDEMPRESA` ON `ClienteSolicitud` ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         cmdBuffer = " CREATE INDEX `UCLIENTESOLICITUDEMPRESA` ON `ClienteSolicitud` (`PBaCEmpId` ,`PBaCCliId` ";
         cmdBuffer += "  ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      try
      {
         cmdBuffer = " CREATE INDEX `UCLIENTESOLICITUDORIGEN` ON `ClienteSolicitud` (`PaisCodigo` ,`PBaCOrigen` ";
         cmdBuffer += "  ,`PBaCOrigenId` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         cmdBuffer = " DROP INDEX `UCLIENTESOLICITUDORIGEN` ON `ClienteSolicitud` ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         cmdBuffer = " CREATE INDEX `UCLIENTESOLICITUDORIGEN` ON `ClienteSolicitud` (`PaisCodigo` ,`PBaCOrigen` ";
         cmdBuffer += "  ,`PBaCOrigenId` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void CreateDepartamentoLocalidad( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Indices for table DepartamentoLocalidad */
      try
      {
         cmdBufferCreate = " CREATE TABLE `DepartamentoLocalidad` (`PaisCodigo`  smallint NOT NULL , `DeptoTruckId` ";
         cmdBufferCreate += "   smallint NOT NULL , `LocalidadTruckId`  char(15) NOT NULL , `LocalidadDescripcion` ";
         cmdBufferCreate += "   char(45) NOT NULL , `LocalidadInhabilitada`  BOOL , PRIMARY KEY(`PaisCodigo`, `DeptoTruckId`, ";
         cmdBufferCreate += "  `LocalidadTruckId`))  ENGINE=InnoDB ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "DepartamentoLocalidad", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `DepartamentoLocalidad` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "DepartamentoLocalidad", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `DepartamentoLocalidad` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "DepartamentoLocalidad", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `DepartamentoLocalidad` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      try
      {
         cmdBuffer = " CREATE INDEX `IDEPARTAMENTOLOCALIDAD1` ON `DepartamentoLocalidad` (`LocalidadTruckId` ";
         cmdBuffer += "  ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         cmdBuffer = " DROP INDEX `IDEPARTAMENTOLOCALIDAD1` ON `DepartamentoLocalidad` ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         cmdBuffer = " CREATE INDEX `IDEPARTAMENTOLOCALIDAD1` ON `DepartamentoLocalidad` (`LocalidadTruckId` ";
         cmdBuffer += "  ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      try
      {
         cmdBuffer = " CREATE INDEX `UDEPARTAMENTOLOCALIDADPAISDESC` ON `DepartamentoLocalidad` (`PaisCodigo` ";
         cmdBuffer += "  ,`DeptoTruckId` ,`LocalidadDescripcion` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         cmdBuffer = " DROP INDEX `UDEPARTAMENTOLOCALIDADPAISDESC` ON `DepartamentoLocalidad` ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         cmdBuffer = " CREATE INDEX `UDEPARTAMENTOLOCALIDADPAISDESC` ON `DepartamentoLocalidad` (`PaisCodigo` ";
         cmdBuffer += "  ,`DeptoTruckId` ,`LocalidadDescripcion` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void CreateDepartamento( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Indices for table Departamento */
      try
      {
         cmdBufferCreate = " CREATE TABLE `Departamento` (`PaisCodigo`  smallint NOT NULL , `DeptoTruckId`  smallint ";
         cmdBufferCreate += "  NOT NULL , `DeptoDescripcion`  char(45) NOT NULL , `DeptoTruckLocalidadDefault` ";
         cmdBufferCreate += "   char(15) , `DeptoInhabilitado`  BOOL , PRIMARY KEY(`PaisCodigo`, `DeptoTruckId`)) ";
         cmdBufferCreate += "   ENGINE=InnoDB ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "Departamento", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `Departamento` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "Departamento", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `Departamento` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "Departamento", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `Departamento` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      try
      {
         cmdBuffer = " CREATE INDEX `IDEPARTAMENTO1` ON `Departamento` (`DeptoTruckId` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         cmdBuffer = " DROP INDEX `IDEPARTAMENTO1` ON `Departamento` ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         cmdBuffer = " CREATE INDEX `IDEPARTAMENTO1` ON `Departamento` (`DeptoTruckId` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      try
      {
         cmdBuffer = " CREATE INDEX `UDEPARTAMENTOPAISDESCGOOGLE` ON `Departamento` (`PaisCodigo` ,`DeptoDescripcion` ";
         cmdBuffer += "  ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         cmdBuffer = " DROP INDEX `UDEPARTAMENTOPAISDESCGOOGLE` ON `Departamento` ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         cmdBuffer = " CREATE INDEX `UDEPARTAMENTOPAISDESCGOOGLE` ON `Departamento` (`PaisCodigo` ,`DeptoDescripcion` ";
         cmdBuffer += "  ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void CreateAuditoria( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Indices for table Auditoria */
      try
      {
         cmdBufferCreate = " CREATE TABLE `Auditoria` (`AuditoriaId`  bigint NOT NULL  AUTO_INCREMENT, `AuditoriaEntidad` ";
         cmdBufferCreate += "   char(60) NOT NULL , `AuditoriaPK`  char(60) NOT NULL , `AuditoriaAccion`  char(3) ";
         cmdBufferCreate += "  NOT NULL , `AuditoriaUsuarioGUID`  char(40) NOT NULL , `AuditoriaUsuarioName`  char(30) ";
         cmdBufferCreate += "  NOT NULL , `AuditoriaFecha`  datetime NOT NULL , `AuditoriaDetalle`  varchar(500) ";
         cmdBufferCreate += "  NOT NULL , PRIMARY KEY(`AuditoriaId`))  ENGINE=InnoDB ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "Auditoria", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `Auditoria` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "Auditoria", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `Auditoria` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "Auditoria", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `Auditoria` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
   }

   public void CreateUserRegion( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Indices for table UserRegion */
      try
      {
         cmdBufferCreate = " CREATE TABLE `UserRegion` (`UserGUID`  char(40) NOT NULL , `EmpId`  smallint NOT ";
         cmdBufferCreate += "  NULL , `RegId`  smallint NOT NULL , `UserNick`  char(30) NOT NULL , `UserApyNom` ";
         cmdBufferCreate += "   char(100) NOT NULL , PRIMARY KEY(`UserGUID`, `EmpId`, `RegId`))  ENGINE=InnoDB ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "UserRegion", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `UserRegion` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "UserRegion", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `UserRegion` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "UserRegion", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `UserRegion` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      try
      {
         cmdBuffer = " CREATE INDEX `IUSERREGION1` ON `UserRegion` (`EmpId` ,`RegId` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         cmdBuffer = " DROP INDEX `IUSERREGION1` ON `UserRegion` ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         cmdBuffer = " CREATE INDEX `IUSERREGION1` ON `UserRegion` (`EmpId` ,`RegId` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void CreatePCLLocDist( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Indices for table PCLLocDist */
      try
      {
         cmdBufferCreate = " CREATE TABLE `PCLLocDist` (`PaisCodigo`  smallint NOT NULL , `LOCDISLcdId`  char(15) ";
         cmdBufferCreate += "  NOT NULL , `LOCDISCliId`  mediumint NOT NULL , PRIMARY KEY(`PaisCodigo`, `LOCDISLcdId`, ";
         cmdBufferCreate += "  `LOCDISCliId`))  ENGINE=InnoDB ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "PCLLocDist", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `PCLLocDist` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "PCLLocDist", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `PCLLocDist` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "PCLLocDist", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `PCLLocDist` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
   }

   public void CreateParametros( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Definition of ParametrosChar changed to char length 255 decimals 0 */
      /* Definition of ParametrosChar01 changed to char length 255 decimals 0 */
      /* Definition of ParametrosChar02 changed to char length 255 decimals 0 */
      /* Definition of ParametrosChar03 changed to char length 255 decimals 0 */
      /* Definition of ParametrosChar04 changed to char length 255 decimals 0 */
      /* Indices for table Parametros */
      try
      {
         cmdBufferCreate = " CREATE TABLE `Parametros` (`PaisCodigo`  smallint NOT NULL , `ParametrosId`  mediumint ";
         cmdBufferCreate += "  NOT NULL , `ParametrosSec`  smallint NOT NULL , `ParametrosDesc`  char(100) NOT ";
         cmdBufferCreate += "  NULL , `ParametrosNum`  NUMERIC(17,4) , `ParametrosChar`  char(255) , `ParametrosVarChar` ";
         cmdBufferCreate += "   varchar(1000) , `ParametrosDate`  date , `ParametrosDateTime`  datetime , `ParametrosChar01` ";
         cmdBufferCreate += "   char(255) , `ParametrosChar02`  char(255) , `ParametrosChar03`  char(255) , `ParametrosChar04` ";
         cmdBufferCreate += "   char(255) , `ParametrosGral`  BOOL NOT NULL , `ParametrosEncript`  BOOL NOT NULL ";
         cmdBufferCreate += "  , PRIMARY KEY(`PaisCodigo`, `ParametrosId`, `ParametrosSec`))  ENGINE=InnoDB ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "Parametros", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `Parametros` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "Parametros", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `Parametros` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "Parametros", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `Parametros` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
   }

   public void CreateBandejaAutorizacion( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Indices for table BandejaAutorizacion */
      try
      {
         cmdBufferCreate = " CREATE TABLE `BandejaAutorizacion` (`IdAprobacion`  bigint NOT NULL , `BandejaAutFchRegistro` ";
         cmdBufferCreate += "   datetime NOT NULL , `BaCTrnNro`  int NOT NULL , `BandejaAutTpoMovim`  char(2) NOT ";
         cmdBufferCreate += "  NULL , `BandejaAutNroTicket`  bigint NOT NULL , `BandejaAutRolAutoriz`  varchar(60) ";
         cmdBufferCreate += "  NOT NULL , `BandejaAutUserAccion`  varchar(60) , `BandejaAutFchAccion`  datetime ";
         cmdBufferCreate += "  , `BandejaAutAccion`  char(1) , PRIMARY KEY(`IdAprobacion`))  ENGINE=InnoDB ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "BandejaAutorizacion", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `BandejaAutorizacion` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "BandejaAutorizacion", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `BandejaAutorizacion` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "BandejaAutorizacion", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `BandejaAutorizacion` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
   }

   public void CreateCodigosAdicionales( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Indices for table CodigosAdicionales */
      try
      {
         cmdBufferCreate = " CREATE TABLE `CodigosAdicionales` (`IdCodigo`  int NOT NULL , `CodAdicionalAbv`  ";
         cmdBufferCreate += "  char(45) NOT NULL , `CodAdicionalTxt`  varchar(100) NOT NULL , `CodAdicionalGpoInfo` ";
         cmdBufferCreate += "   smallint NOT NULL , `CodAdicionalEstado`  char(1) NOT NULL , PRIMARY KEY(`IdCodigo`, ";
         cmdBufferCreate += "  `CodAdicionalAbv`))  ENGINE=InnoDB ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "CodigosAdicionales", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `CodigosAdicionales` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "CodigosAdicionales", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `CodigosAdicionales` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "CodigosAdicionales", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `CodigosAdicionales` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
   }

   public void CreatePCLMaTeZo( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Indices for table PCLMaTeZo */
      try
      {
         cmdBufferCreate = " CREATE TABLE `PCLMaTeZo` (`PaisCodigo`  smallint NOT NULL , `MTVEId`  smallint NOT ";
         cmdBufferCreate += "  NULL , `MTVECanalCod`  smallint NOT NULL , `MTVESubCanalCod`  smallint NOT NULL ";
         cmdBufferCreate += "  , `MTVESegmentoCod`  smallint NOT NULL , `MTVEVendedorCat`  char(3) NOT NULL , `MTVENegocioTipo` ";
         cmdBufferCreate += "   char(45) NOT NULL , `MTVEBuscaCercanoPor`  char(3) NOT NULL , `MTVERepartoEspecial` ";
         cmdBufferCreate += "   smallint NOT NULL , `MTVEVisibleCombo`  char(1) NOT NULL , `MTVEVentasMasHabilitado` ";
         cmdBufferCreate += "   BOOL NOT NULL , PRIMARY KEY(`PaisCodigo`, `MTVEId`))  ENGINE=InnoDB ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "PCLMaTeZo", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `PCLMaTeZo` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "PCLMaTeZo", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `PCLMaTeZo` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "PCLMaTeZo", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `PCLMaTeZo` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      try
      {
         cmdBuffer = " CREATE UNIQUE INDEX `IPCLMATEZO02` ON `PCLMaTeZo` (`PaisCodigo` ,`MTVESegmentoCod` ";
         cmdBuffer += "  ,`MTVECanalCod` ,`MTVESubCanalCod` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         cmdBuffer = " DROP INDEX `IPCLMATEZO02` ON `PCLMaTeZo` ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         cmdBuffer = " CREATE UNIQUE INDEX `IPCLMATEZO02` ON `PCLMaTeZo` (`PaisCodigo` ,`MTVESegmentoCod` ";
         cmdBuffer += "  ,`MTVECanalCod` ,`MTVESubCanalCod` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void CreatePCLZonVis( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Indices for table PCLZonVis */
      try
      {
         cmdBufferCreate = " CREATE TABLE `PCLZonVis` (`PaisCodigo`  smallint NOT NULL , `ZonaVisitaCodigo`  smallint ";
         cmdBufferCreate += "  NOT NULL , `ZonaVisitaDescripcion`  char(45) NOT NULL , `ZonaVisitaPoligono`  GEOMETRY ";
         cmdBufferCreate += "  NOT NULL , `ZonaVisitaBlob`  LONGBLOB NOT NULL , `ZonaVisitaTipo`  char(1) NOT NULL ";
         cmdBufferCreate += "  , `ZonaVisitaTipoIdDist`  mediumint , `ZonaVisitaRegId`  smallint NOT NULL , `ZonaVisitaMinDist` ";
         cmdBufferCreate += "   NUMERIC(11,4) NOT NULL , PRIMARY KEY(`PaisCodigo`, `ZonaVisitaCodigo`))  ENGINE=InnoDB ";
         cmdBufferCreate += "  ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "PCLZonVis", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `PCLZonVis` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "PCLZonVis", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `PCLZonVis` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "PCLZonVis", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `PCLZonVis` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      try
      {
         cmdBuffer = " CREATE INDEX `UPCLZONVIS01` ON `PCLZonVis` (`PaisCodigo` ,`ZonaVisitaRegId` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         cmdBuffer = " DROP INDEX `UPCLZONVIS01` ON `PCLZonVis` ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         cmdBuffer = " CREATE INDEX `UPCLZONVIS01` ON `PCLZonVis` (`PaisCodigo` ,`ZonaVisitaRegId` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void CreatePCLZonEnt( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Indices for table PCLZonEnt */
      try
      {
         cmdBufferCreate = " CREATE TABLE `PCLZonEnt` (`PaisCodigo`  smallint NOT NULL , `ZonaEntregaDepCod`  ";
         cmdBufferCreate += "  smallint NOT NULL , `ZonaEntregaDepDsc`  char(45) NOT NULL , `ZonaEntregaPoligono` ";
         cmdBufferCreate += "   GEOMETRY NOT NULL , `ZonaEntregaBlob`  LONGBLOB NOT NULL , `ZonaEntregaCliAdy` ";
         cmdBufferCreate += "   mediumint NOT NULL , `ZonaEntregaMinDist`  NUMERIC(11,4) NOT NULL , PRIMARY KEY(`PaisCodigo`, ";
         cmdBufferCreate += "  `ZonaEntregaDepCod`))  ENGINE=InnoDB ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "PCLZonEnt", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `PCLZonEnt` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "PCLZonEnt", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `PCLZonEnt` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "PCLZonEnt", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `PCLZonEnt` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
   }

   public void CreatePCLCodAte( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Indices for table PCLCodAte */
      try
      {
         cmdBufferCreate = " CREATE TABLE `PCLCodAte` (`PaisCodigo`  smallint NOT NULL , `AtencionCodigo`  smallint ";
         cmdBufferCreate += "  NOT NULL , `AtencionDesc`  char(30) NOT NULL , PRIMARY KEY(`PaisCodigo`, `AtencionCodigo`)) ";
         cmdBufferCreate += "   ENGINE=InnoDB ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "PCLCodAte", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `PCLCodAte` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "PCLCodAte", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `PCLCodAte` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "PCLCodAte", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `PCLCodAte` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
   }

   public void CreatePCLValDef( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Indices for table PCLValDef */
      try
      {
         cmdBufferCreate = " CREATE TABLE `PCLValDef` (`PaisCodigo`  smallint NOT NULL , `ValorDefaultCampo`  ";
         cmdBufferCreate += "  char(30) NOT NULL , `ValorDefaultObligatorio`  BOOL NOT NULL , `ValorDefaultTiene` ";
         cmdBufferCreate += "   BOOL NOT NULL , `ValorDefaultTipoDato`  char(1) NOT NULL , `ValorDefaultChar`  ";
         cmdBufferCreate += "  char(45) , `ValorDefaultNum`  NUMERIC(13,2) , `ValorDefaultDate`  date , `ValorDefaultDateTime` ";
         cmdBufferCreate += "   datetime , `ValorDefaultDescripcion`  char(80) , `ValorDefaultDescripAmpliada` ";
         cmdBufferCreate += "   varchar(200) , `ValorDefaultExpresionRegular`  varchar(128) NOT NULL , `ValorDefaultAltaEditable` ";
         cmdBufferCreate += "   BOOL NOT NULL , `ValorDefaultModificaEditable`  BOOL NOT NULL , PRIMARY KEY(`PaisCodigo`, ";
         cmdBufferCreate += "  `ValorDefaultCampo`))  ENGINE=InnoDB ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "PCLValDef", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `PCLValDef` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "PCLValDef", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `PCLValDef` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "PCLValDef", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `PCLValDef` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
   }

   public void CreatePCLTipoVta( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Indices for table PCLTipoVta */
      try
      {
         cmdBufferCreate = " CREATE TABLE `PCLTipoVta` (`PaisCodigo`  smallint NOT NULL , `TipoVtaFormaPago`  ";
         cmdBufferCreate += "  smallint NOT NULL , `TipoVtaDescPago`  char(30) NOT NULL , PRIMARY KEY(`PaisCodigo`, ";
         cmdBufferCreate += "  `TipoVtaFormaPago`))  ENGINE=InnoDB ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "PCLTipoVta", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `PCLTipoVta` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "PCLTipoVta", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `PCLTipoVta` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "PCLTipoVta", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `PCLTipoVta` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
   }

   public void CreatePCLPais( ) throws SQLException
   {
      String cmdBufferCreate = "" ;
      String cmdBuffer = "" ;
      /* Indices for table PCLPais */
      try
      {
         cmdBufferCreate = " CREATE TABLE `PCLPais` (`PaisCodigo`  smallint NOT NULL , `PaisNombre`  char(50) ";
         cmdBufferCreate += "  NOT NULL , `PaisLDAP`  char(2) NOT NULL , `PaisEmpresaId`  smallint NOT NULL , `PaisEsquema` ";
         cmdBufferCreate += "   char(4) NOT NULL , PRIMARY KEY(`PaisCodigo`))  ENGINE=InnoDB ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
            DropTableConstraints( "PCLPais", sSchemaVar) ;
            cmdBuffer = " DROP TABLE `PCLPais` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
               DropTableConstraints( "PCLPais", sSchemaVar) ;
               cmdBuffer = " DROP VIEW `PCLPais` ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
                  DropTableConstraints( "PCLPais", sSchemaVar) ;
                  cmdBuffer = " DROP FUNCTION `PCLPais` ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      try
      {
         cmdBuffer = " CREATE INDEX `UPCLPAISLDAP` ON `PCLPais` (`PaisLDAP` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         cmdBuffer = " DROP INDEX `UPCLPAISLDAP` ON `PCLPais` ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         cmdBuffer = " CREATE INDEX `UPCLPAISLDAP` ON `PCLPais` (`PaisLDAP` ) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void RIPCLTipoVtaPCLPais( ) throws SQLException
   {
      String cmdBuffer ;
      try
      {
         cmdBuffer = " ALTER TABLE `PCLTipoVta` ADD CONSTRAINT `IPCLTIPOVTA01` FOREIGN KEY (`PaisCodigo`) ";
         cmdBuffer += "  REFERENCES `PCLPais` (`PaisCodigo`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         try
         {
            cmdBuffer = " ALTER TABLE `PCLTipoVta` DROP FOREIGN KEY `IPCLTIPOVTA01` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
         }
         cmdBuffer = " ALTER TABLE `PCLTipoVta` ADD CONSTRAINT `IPCLTIPOVTA01` FOREIGN KEY (`PaisCodigo`) ";
         cmdBuffer += "  REFERENCES `PCLPais` (`PaisCodigo`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void RIPCLValDefPCLPais( ) throws SQLException
   {
      String cmdBuffer ;
      try
      {
         cmdBuffer = " ALTER TABLE `PCLValDef` ADD CONSTRAINT `IPCLVALDEF01` FOREIGN KEY (`PaisCodigo`) ";
         cmdBuffer += "  REFERENCES `PCLPais` (`PaisCodigo`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         try
         {
            cmdBuffer = " ALTER TABLE `PCLValDef` DROP FOREIGN KEY `IPCLVALDEF01` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
         }
         cmdBuffer = " ALTER TABLE `PCLValDef` ADD CONSTRAINT `IPCLVALDEF01` FOREIGN KEY (`PaisCodigo`) ";
         cmdBuffer += "  REFERENCES `PCLPais` (`PaisCodigo`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void RIPCLCodAtePCLPais( ) throws SQLException
   {
      String cmdBuffer ;
      try
      {
         cmdBuffer = " ALTER TABLE `PCLCodAte` ADD CONSTRAINT `IPCLCODATE01` FOREIGN KEY (`PaisCodigo`) ";
         cmdBuffer += "  REFERENCES `PCLPais` (`PaisCodigo`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         try
         {
            cmdBuffer = " ALTER TABLE `PCLCodAte` DROP FOREIGN KEY `IPCLCODATE01` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
         }
         cmdBuffer = " ALTER TABLE `PCLCodAte` ADD CONSTRAINT `IPCLCODATE01` FOREIGN KEY (`PaisCodigo`) ";
         cmdBuffer += "  REFERENCES `PCLPais` (`PaisCodigo`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void RIPCLZonEntPCLPais( ) throws SQLException
   {
      String cmdBuffer ;
      try
      {
         cmdBuffer = " ALTER TABLE `PCLZonEnt` ADD CONSTRAINT `IPCLZONENT01` FOREIGN KEY (`PaisCodigo`) ";
         cmdBuffer += "  REFERENCES `PCLPais` (`PaisCodigo`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         try
         {
            cmdBuffer = " ALTER TABLE `PCLZonEnt` DROP FOREIGN KEY `IPCLZONENT01` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
         }
         cmdBuffer = " ALTER TABLE `PCLZonEnt` ADD CONSTRAINT `IPCLZONENT01` FOREIGN KEY (`PaisCodigo`) ";
         cmdBuffer += "  REFERENCES `PCLPais` (`PaisCodigo`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void RIPCLZonVisPCLPais( ) throws SQLException
   {
      String cmdBuffer ;
      try
      {
         cmdBuffer = " ALTER TABLE `PCLZonVis` ADD CONSTRAINT `IZONASVISITA1` FOREIGN KEY (`PaisCodigo`) ";
         cmdBuffer += "  REFERENCES `PCLPais` (`PaisCodigo`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         try
         {
            cmdBuffer = " ALTER TABLE `PCLZonVis` DROP FOREIGN KEY `IZONASVISITA1` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
         }
         cmdBuffer = " ALTER TABLE `PCLZonVis` ADD CONSTRAINT `IZONASVISITA1` FOREIGN KEY (`PaisCodigo`) ";
         cmdBuffer += "  REFERENCES `PCLPais` (`PaisCodigo`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void RIPCLMaTeZoPCLPais( ) throws SQLException
   {
      String cmdBuffer ;
      try
      {
         cmdBuffer = " ALTER TABLE `PCLMaTeZo` ADD CONSTRAINT `IPCLMATEZO01` FOREIGN KEY (`PaisCodigo`) ";
         cmdBuffer += "  REFERENCES `PCLPais` (`PaisCodigo`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         try
         {
            cmdBuffer = " ALTER TABLE `PCLMaTeZo` DROP FOREIGN KEY `IPCLMATEZO01` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
         }
         cmdBuffer = " ALTER TABLE `PCLMaTeZo` ADD CONSTRAINT `IPCLMATEZO01` FOREIGN KEY (`PaisCodigo`) ";
         cmdBuffer += "  REFERENCES `PCLPais` (`PaisCodigo`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void RIParametrosPCLPais( ) throws SQLException
   {
      String cmdBuffer ;
      try
      {
         cmdBuffer = " ALTER TABLE `Parametros` ADD CONSTRAINT `IPARAMETROS4` FOREIGN KEY (`PaisCodigo`) ";
         cmdBuffer += "  REFERENCES `PCLPais` (`PaisCodigo`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         try
         {
            cmdBuffer = " ALTER TABLE `Parametros` DROP FOREIGN KEY `IPARAMETROS4` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
         }
         cmdBuffer = " ALTER TABLE `Parametros` ADD CONSTRAINT `IPARAMETROS4` FOREIGN KEY (`PaisCodigo`) ";
         cmdBuffer += "  REFERENCES `PCLPais` (`PaisCodigo`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void RIPCLLocDistPCLPais( ) throws SQLException
   {
      String cmdBuffer ;
      try
      {
         cmdBuffer = " ALTER TABLE `PCLLocDist` ADD CONSTRAINT `ILOCALIDADESDISTRIBUIDORES1` FOREIGN KEY ";
         cmdBuffer += "  (`PaisCodigo`) REFERENCES `PCLPais` (`PaisCodigo`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         try
         {
            cmdBuffer = " ALTER TABLE `PCLLocDist` DROP FOREIGN KEY `ILOCALIDADESDISTRIBUIDORES1` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
         }
         cmdBuffer = " ALTER TABLE `PCLLocDist` ADD CONSTRAINT `ILOCALIDADESDISTRIBUIDORES1` FOREIGN KEY ";
         cmdBuffer += "  (`PaisCodigo`) REFERENCES `PCLPais` (`PaisCodigo`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void RIDepartamentoPCLPais( ) throws SQLException
   {
      String cmdBuffer ;
      try
      {
         cmdBuffer = " ALTER TABLE `Departamento` ADD CONSTRAINT `IDEPARTAMENTO2` FOREIGN KEY (`PaisCodigo`) ";
         cmdBuffer += "  REFERENCES `PCLPais` (`PaisCodigo`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         try
         {
            cmdBuffer = " ALTER TABLE `Departamento` DROP FOREIGN KEY `IDEPARTAMENTO2` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
         }
         cmdBuffer = " ALTER TABLE `Departamento` ADD CONSTRAINT `IDEPARTAMENTO2` FOREIGN KEY (`PaisCodigo`) ";
         cmdBuffer += "  REFERENCES `PCLPais` (`PaisCodigo`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void RIDepartamentoLocalidadDepartamento( ) throws SQLException
   {
      String cmdBuffer ;
      try
      {
         cmdBuffer = " ALTER TABLE `DepartamentoLocalidad` ADD CONSTRAINT `IDEPARTAMENTOLOCALIDAD2` FOREIGN ";
         cmdBuffer += "  KEY (`PaisCodigo`, `DeptoTruckId`) REFERENCES `Departamento` (`PaisCodigo`, `DeptoTruckId`) ";
         cmdBuffer += "  ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         try
         {
            cmdBuffer = " ALTER TABLE `DepartamentoLocalidad` DROP FOREIGN KEY `IDEPARTAMENTOLOCALIDAD2` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
         }
         cmdBuffer = " ALTER TABLE `DepartamentoLocalidad` ADD CONSTRAINT `IDEPARTAMENTOLOCALIDAD2` FOREIGN ";
         cmdBuffer += "  KEY (`PaisCodigo`, `DeptoTruckId`) REFERENCES `Departamento` (`PaisCodigo`, `DeptoTruckId`) ";
         cmdBuffer += "  ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void RIClienteSolicitudPCLPais( ) throws SQLException
   {
      String cmdBuffer ;
      try
      {
         cmdBuffer = " ALTER TABLE `ClienteSolicitud` ADD CONSTRAINT `GX_002L0001` FOREIGN KEY (`PaisCodigo`) ";
         cmdBuffer += "  REFERENCES `PCLPais` (`PaisCodigo`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         try
         {
            cmdBuffer = " ALTER TABLE `ClienteSolicitud` DROP FOREIGN KEY `GX_002L0001` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
         }
         cmdBuffer = " ALTER TABLE `ClienteSolicitud` ADD CONSTRAINT `GX_002L0001` FOREIGN KEY (`PaisCodigo`) ";
         cmdBuffer += "  REFERENCES `PCLPais` (`PaisCodigo`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void RIClienteSolicitudPCLMaTeZo( ) throws SQLException
   {
      String cmdBuffer ;
      try
      {
         cmdBuffer = " ALTER TABLE `ClienteSolicitud` ADD CONSTRAINT `ICLIENTESOLICITUD3` FOREIGN KEY (`PaisCodigo`, ";
         cmdBuffer += "  `MTVEId`) REFERENCES `PCLMaTeZo` (`PaisCodigo`, `MTVEId`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         try
         {
            cmdBuffer = " ALTER TABLE `ClienteSolicitud` DROP FOREIGN KEY `ICLIENTESOLICITUD3` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
         }
         cmdBuffer = " ALTER TABLE `ClienteSolicitud` ADD CONSTRAINT `ICLIENTESOLICITUD3` FOREIGN KEY (`PaisCodigo`, ";
         cmdBuffer += "  `MTVEId`) REFERENCES `PCLMaTeZo` (`PaisCodigo`, `MTVEId`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void RIClienteSolicitudPCLZonEnt( ) throws SQLException
   {
      String cmdBuffer ;
      try
      {
         cmdBuffer = " ALTER TABLE `ClienteSolicitud` ADD CONSTRAINT `ICLIENTESOLICITUD2` FOREIGN KEY (`PaisCodigo`, ";
         cmdBuffer += "  `ZonaEntregaDepCod`) REFERENCES `PCLZonEnt` (`PaisCodigo`, `ZonaEntregaDepCod`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         try
         {
            cmdBuffer = " ALTER TABLE `ClienteSolicitud` DROP FOREIGN KEY `ICLIENTESOLICITUD2` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
         }
         cmdBuffer = " ALTER TABLE `ClienteSolicitud` ADD CONSTRAINT `ICLIENTESOLICITUD2` FOREIGN KEY (`PaisCodigo`, ";
         cmdBuffer += "  `ZonaEntregaDepCod`) REFERENCES `PCLZonEnt` (`PaisCodigo`, `ZonaEntregaDepCod`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void RIClienteSolicitudTerrClienteSolicitud( ) throws SQLException
   {
      String cmdBuffer ;
      try
      {
         cmdBuffer = " ALTER TABLE `ClienteSolicitudTerr` ADD CONSTRAINT `ICLIENTESOLICITUDTERR1` FOREIGN ";
         cmdBuffer += "  KEY (`PBaCID`) REFERENCES `ClienteSolicitud` (`PBaCID`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         try
         {
            cmdBuffer = " ALTER TABLE `ClienteSolicitudTerr` DROP FOREIGN KEY `ICLIENTESOLICITUDTERR1` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
         }
         cmdBuffer = " ALTER TABLE `ClienteSolicitudTerr` ADD CONSTRAINT `ICLIENTESOLICITUDTERR1` FOREIGN ";
         cmdBuffer += "  KEY (`PBaCID`) REFERENCES `ClienteSolicitud` (`PBaCID`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void RIClienteSolicitudTerrDiaVisitaClienteSolicitudTerr( ) throws SQLException
   {
      String cmdBuffer ;
      try
      {
         cmdBuffer = " ALTER TABLE `ClienteSolicitudTerrDiaVisita` ADD CONSTRAINT `ICLIENTESOLICITUDTERRDIAVISIT1` ";
         cmdBuffer += "  FOREIGN KEY (`PBaCID`, `PBaCTrrCategoria`, `PBaCTrrId`) REFERENCES `ClienteSolicitudTerr` ";
         cmdBuffer += "  (`PBaCID`, `PBaCTrrCategoria`, `PBaCTrrId`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         try
         {
            cmdBuffer = " ALTER TABLE `ClienteSolicitudTerrDiaVisita` DROP FOREIGN KEY `ICLIENTESOLICITUDTERRDIAVISIT1` ";
            cmdBuffer += "  ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
         }
         cmdBuffer = " ALTER TABLE `ClienteSolicitudTerrDiaVisita` ADD CONSTRAINT `ICLIENTESOLICITUDTERRDIAVISIT1` ";
         cmdBuffer += "  FOREIGN KEY (`PBaCID`, `PBaCTrrCategoria`, `PBaCTrrId`) REFERENCES `ClienteSolicitudTerr` ";
         cmdBuffer += "  (`PBaCID`, `PBaCTrrCategoria`, `PBaCTrrId`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void RIProcesoPasoProceso( ) throws SQLException
   {
      String cmdBuffer ;
      try
      {
         cmdBuffer = " ALTER TABLE `ProcesoPaso` ADD CONSTRAINT `IPROCESOPASO1` FOREIGN KEY (`ProcesoId`) ";
         cmdBuffer += "  REFERENCES `Proceso` (`ProcesoId`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         try
         {
            cmdBuffer = " ALTER TABLE `ProcesoPaso` DROP FOREIGN KEY `IPROCESOPASO1` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
         }
         cmdBuffer = " ALTER TABLE `ProcesoPaso` ADD CONSTRAINT `IPROCESOPASO1` FOREIGN KEY (`ProcesoId`) ";
         cmdBuffer += "  REFERENCES `Proceso` (`ProcesoId`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void RIClienteSolicitudAdjuntoClienteSolicitud( ) throws SQLException
   {
      String cmdBuffer ;
      try
      {
         cmdBuffer = " ALTER TABLE `ClienteSolicitudAdjunto` ADD CONSTRAINT `ICLIENTESOLICITUDADJUNTO1` ";
         cmdBuffer += "  FOREIGN KEY (`PBaCID`) REFERENCES `ClienteSolicitud` (`PBaCID`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         try
         {
            cmdBuffer = " ALTER TABLE `ClienteSolicitudAdjunto` DROP FOREIGN KEY `ICLIENTESOLICITUDADJUNTO1` ";
            cmdBuffer += "  ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
         }
         cmdBuffer = " ALTER TABLE `ClienteSolicitudAdjunto` ADD CONSTRAINT `ICLIENTESOLICITUDADJUNTO1` ";
         cmdBuffer += "  FOREIGN KEY (`PBaCID`) REFERENCES `ClienteSolicitud` (`PBaCID`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void RIAlcoholLicenciaPCLPais( ) throws SQLException
   {
      String cmdBuffer ;
      try
      {
         cmdBuffer = " ALTER TABLE `AlcoholLicencia` ADD CONSTRAINT `IALCOHOLLICENCIA` FOREIGN KEY (`AlcoholLicenciaPaisId`) ";
         cmdBuffer += "  REFERENCES `PCLPais` (`PaisCodigo`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         try
         {
            cmdBuffer = " ALTER TABLE `AlcoholLicencia` DROP FOREIGN KEY `IALCOHOLLICENCIA` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
         }
         cmdBuffer = " ALTER TABLE `AlcoholLicencia` ADD CONSTRAINT `IALCOHOLLICENCIA` FOREIGN KEY (`AlcoholLicenciaPaisId`) ";
         cmdBuffer += "  REFERENCES `PCLPais` (`PaisCodigo`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void RIAlcoholLicenciaDepartamentoAlcoholLicencia( ) throws SQLException
   {
      String cmdBuffer ;
      try
      {
         cmdBuffer = " ALTER TABLE `AlcoholLicenciaDepartamento` ADD CONSTRAINT `IALCOHOLLICENCIADEPARTAMENTO1` ";
         cmdBuffer += "  FOREIGN KEY (`AlcoholLicenciaPaisId`) REFERENCES `AlcoholLicencia` (`AlcoholLicenciaPaisId`) ";
         cmdBuffer += "  ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         try
         {
            cmdBuffer = " ALTER TABLE `AlcoholLicenciaDepartamento` DROP FOREIGN KEY `IALCOHOLLICENCIADEPARTAMENTO1` ";
            cmdBuffer += "  ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
         }
         cmdBuffer = " ALTER TABLE `AlcoholLicenciaDepartamento` ADD CONSTRAINT `IALCOHOLLICENCIADEPARTAMENTO1` ";
         cmdBuffer += "  FOREIGN KEY (`AlcoholLicenciaPaisId`) REFERENCES `AlcoholLicencia` (`AlcoholLicenciaPaisId`) ";
         cmdBuffer += "  ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void RIAlcoholLicenciaDepartamentoDepartamento( ) throws SQLException
   {
      String cmdBuffer ;
      try
      {
         cmdBuffer = " ALTER TABLE `AlcoholLicenciaDepartamento` ADD CONSTRAINT `IALCOHOLLICENCIADEPARTAMENTO` ";
         cmdBuffer += "  FOREIGN KEY (`AlcoholLicenciaPaisId`, `AlcoholLicenciaDeptoId`) REFERENCES `Departamento` ";
         cmdBuffer += "  (`PaisCodigo`, `DeptoTruckId`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         try
         {
            cmdBuffer = " ALTER TABLE `AlcoholLicenciaDepartamento` DROP FOREIGN KEY `IALCOHOLLICENCIADEPARTAMENTO` ";
            cmdBuffer += "  ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
         }
         cmdBuffer = " ALTER TABLE `AlcoholLicenciaDepartamento` ADD CONSTRAINT `IALCOHOLLICENCIADEPARTAMENTO` ";
         cmdBuffer += "  FOREIGN KEY (`AlcoholLicenciaPaisId`, `AlcoholLicenciaDeptoId`) REFERENCES `Departamento` ";
         cmdBuffer += "  (`PaisCodigo`, `DeptoTruckId`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void RIAlcoholLicenciaLocalidadAlcoholLicenciaDepartamento( ) throws SQLException
   {
      String cmdBuffer ;
      try
      {
         cmdBuffer = " ALTER TABLE `AlcoholLicenciaLocalidad` ADD CONSTRAINT `IALCOHOLLICENCIALOCALIDAD1` ";
         cmdBuffer += "  FOREIGN KEY (`AlcoholLicenciaPaisId`, `AlcoholLicenciaDeptoId`) REFERENCES `AlcoholLicenciaDepartamento` ";
         cmdBuffer += "  (`AlcoholLicenciaPaisId`, `AlcoholLicenciaDeptoId`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         try
         {
            cmdBuffer = " ALTER TABLE `AlcoholLicenciaLocalidad` DROP FOREIGN KEY `IALCOHOLLICENCIALOCALIDAD1` ";
            cmdBuffer += "  ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
         }
         cmdBuffer = " ALTER TABLE `AlcoholLicenciaLocalidad` ADD CONSTRAINT `IALCOHOLLICENCIALOCALIDAD1` ";
         cmdBuffer += "  FOREIGN KEY (`AlcoholLicenciaPaisId`, `AlcoholLicenciaDeptoId`) REFERENCES `AlcoholLicenciaDepartamento` ";
         cmdBuffer += "  (`AlcoholLicenciaPaisId`, `AlcoholLicenciaDeptoId`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void RIAlcoholLicenciaLocalidadDepartamentoLocalidad( ) throws SQLException
   {
      String cmdBuffer ;
      try
      {
         cmdBuffer = " ALTER TABLE `AlcoholLicenciaLocalidad` ADD CONSTRAINT `IALCOHOLLICENCIALOCALIDAD` ";
         cmdBuffer += "  FOREIGN KEY (`AlcoholLicenciaPaisId`, `AlcoholLicenciaDeptoId`, `AlcoholLicenciaLocalidadId`) ";
         cmdBuffer += "  REFERENCES `DepartamentoLocalidad` (`PaisCodigo`, `DeptoTruckId`, `LocalidadTruckId`) ";
         cmdBuffer += "  ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         try
         {
            cmdBuffer = " ALTER TABLE `AlcoholLicenciaLocalidad` DROP FOREIGN KEY `IALCOHOLLICENCIALOCALIDAD` ";
            cmdBuffer += "  ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
         }
         cmdBuffer = " ALTER TABLE `AlcoholLicenciaLocalidad` ADD CONSTRAINT `IALCOHOLLICENCIALOCALIDAD` ";
         cmdBuffer += "  FOREIGN KEY (`AlcoholLicenciaPaisId`, `AlcoholLicenciaDeptoId`, `AlcoholLicenciaLocalidadId`) ";
         cmdBuffer += "  REFERENCES `DepartamentoLocalidad` (`PaisCodigo`, `DeptoTruckId`, `LocalidadTruckId`) ";
         cmdBuffer += "  ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void RIAFIPTiposIVAPCLPais( ) throws SQLException
   {
      String cmdBuffer ;
      try
      {
         cmdBuffer = " ALTER TABLE `AFIPTiposIVA` ADD CONSTRAINT `IAFIPTIPOSIVA1` FOREIGN KEY (`PaisCodigo`) ";
         cmdBuffer += "  REFERENCES `PCLPais` (`PaisCodigo`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         try
         {
            cmdBuffer = " ALTER TABLE `AFIPTiposIVA` DROP FOREIGN KEY `IAFIPTIPOSIVA1` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
         }
         cmdBuffer = " ALTER TABLE `AFIPTiposIVA` ADD CONSTRAINT `IAFIPTIPOSIVA1` FOREIGN KEY (`PaisCodigo`) ";
         cmdBuffer += "  REFERENCES `PCLPais` (`PaisCodigo`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void RIPerfilImpoAFIPAFIPTiposIVA( ) throws SQLException
   {
      String cmdBuffer ;
      try
      {
         cmdBuffer = " ALTER TABLE `PerfilImpoAFIP` ADD CONSTRAINT `IPERFILIMPOAFIP1` FOREIGN KEY (`PaisCodigo`, ";
         cmdBuffer += "  `AFIPTiposIVACodigo`) REFERENCES `AFIPTiposIVA` (`PaisCodigo`, `AFIPTiposIVACodigo`) ";
         cmdBuffer += "  ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         try
         {
            cmdBuffer = " ALTER TABLE `PerfilImpoAFIP` DROP FOREIGN KEY `IPERFILIMPOAFIP1` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
         }
         cmdBuffer = " ALTER TABLE `PerfilImpoAFIP` ADD CONSTRAINT `IPERFILIMPOAFIP1` FOREIGN KEY (`PaisCodigo`, ";
         cmdBuffer += "  `AFIPTiposIVACodigo`) REFERENCES `AFIPTiposIVA` (`PaisCodigo`, `AFIPTiposIVACodigo`) ";
         cmdBuffer += "  ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void RIPerfilImpoAFIPJurisdiccionPerfilImpoAFIP( ) throws SQLException
   {
      String cmdBuffer ;
      try
      {
         cmdBuffer = " ALTER TABLE `PerfilImpoAFIPJurisdiccion` ADD CONSTRAINT `IPERFILIMPOAFIPJURISDICCION1` ";
         cmdBuffer += "  FOREIGN KEY (`PaisCodigo`, `AFIPTiposIVACodigo`, `PerfilImpoAFIPTpoIIBB`, `PerfilImpoAFIPImpcliId`) ";
         cmdBuffer += "  REFERENCES `PerfilImpoAFIP` (`PaisCodigo`, `AFIPTiposIVACodigo`, `PerfilImpoAFIPTpoIIBB`, ";
         cmdBuffer += "  `PerfilImpoAFIPImpcliId`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         try
         {
            cmdBuffer = " ALTER TABLE `PerfilImpoAFIPJurisdiccion` DROP FOREIGN KEY `IPERFILIMPOAFIPJURISDICCION1` ";
            cmdBuffer += "  ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
         }
         cmdBuffer = " ALTER TABLE `PerfilImpoAFIPJurisdiccion` ADD CONSTRAINT `IPERFILIMPOAFIPJURISDICCION1` ";
         cmdBuffer += "  FOREIGN KEY (`PaisCodigo`, `AFIPTiposIVACodigo`, `PerfilImpoAFIPTpoIIBB`, `PerfilImpoAFIPImpcliId`) ";
         cmdBuffer += "  REFERENCES `PerfilImpoAFIP` (`PaisCodigo`, `AFIPTiposIVACodigo`, `PerfilImpoAFIPTpoIIBB`, ";
         cmdBuffer += "  `PerfilImpoAFIPImpcliId`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void RIEntidadPCLPais( ) throws SQLException
   {
      String cmdBuffer ;
      try
      {
         cmdBuffer = " ALTER TABLE `Entidad` ADD CONSTRAINT `IENTIDAD1` FOREIGN KEY (`PaisCodigo`) REFERENCES ";
         cmdBuffer += "  `PCLPais` (`PaisCodigo`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         try
         {
            cmdBuffer = " ALTER TABLE `Entidad` DROP FOREIGN KEY `IENTIDAD1` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
         }
         cmdBuffer = " ALTER TABLE `Entidad` ADD CONSTRAINT `IENTIDAD1` FOREIGN KEY (`PaisCodigo`) REFERENCES ";
         cmdBuffer += "  `PCLPais` (`PaisCodigo`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void RIEntidadServicioEntidad( ) throws SQLException
   {
      String cmdBuffer ;
      try
      {
         cmdBuffer = " ALTER TABLE `EntidadServicio` ADD CONSTRAINT `IENTIDADSERVICIO1` FOREIGN KEY (`PaisCodigo`, ";
         cmdBuffer += "  `EntidadNombre`) REFERENCES `Entidad` (`PaisCodigo`, `EntidadNombre`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         try
         {
            cmdBuffer = " ALTER TABLE `EntidadServicio` DROP FOREIGN KEY `IENTIDADSERVICIO1` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
         }
         cmdBuffer = " ALTER TABLE `EntidadServicio` ADD CONSTRAINT `IENTIDADSERVICIO1` FOREIGN KEY (`PaisCodigo`, ";
         cmdBuffer += "  `EntidadNombre`) REFERENCES `Entidad` (`PaisCodigo`, `EntidadNombre`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void RIAdicionalPTpoCoPCLPais( ) throws SQLException
   {
      String cmdBuffer ;
      try
      {
         cmdBuffer = " ALTER TABLE `AdicionalPTpoCo` ADD CONSTRAINT `IADICIONALPTPOCO1` FOREIGN KEY (`PaisCodigo`) ";
         cmdBuffer += "  REFERENCES `PCLPais` (`PaisCodigo`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         try
         {
            cmdBuffer = " ALTER TABLE `AdicionalPTpoCo` DROP FOREIGN KEY `IADICIONALPTPOCO1` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
         }
         cmdBuffer = " ALTER TABLE `AdicionalPTpoCo` ADD CONSTRAINT `IADICIONALPTPOCO1` FOREIGN KEY (`PaisCodigo`) ";
         cmdBuffer += "  REFERENCES `PCLPais` (`PaisCodigo`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void RIAdicionalTpoCoaPCLPais( ) throws SQLException
   {
      String cmdBuffer ;
      try
      {
         cmdBuffer = " ALTER TABLE `AdicionalTpoCoa` ADD CONSTRAINT `IADICIONALTPOCOA1` FOREIGN KEY (`PaisCodigo`) ";
         cmdBuffer += "  REFERENCES `PCLPais` (`PaisCodigo`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         try
         {
            cmdBuffer = " ALTER TABLE `AdicionalTpoCoa` DROP FOREIGN KEY `IADICIONALTPOCOA1` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
         }
         cmdBuffer = " ALTER TABLE `AdicionalTpoCoa` ADD CONSTRAINT `IADICIONALTPOCOA1` FOREIGN KEY (`PaisCodigo`) ";
         cmdBuffer += "  REFERENCES `PCLPais` (`PaisCodigo`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void RIAdicionalPtpocoCategoriaAdicionalPTpoCo( ) throws SQLException
   {
      String cmdBuffer ;
      try
      {
         cmdBuffer = " ALTER TABLE `AdicionalPtpocoCategoria` ADD CONSTRAINT `IADICIONALPTPOCOCATEGORIA2` ";
         cmdBuffer += "  FOREIGN KEY (`PaisCodigo`, `AdicionalTpocodId`) REFERENCES `AdicionalPTpoCo` (`PaisCodigo`, ";
         cmdBuffer += "  `AdicionalTpocodId`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         try
         {
            cmdBuffer = " ALTER TABLE `AdicionalPtpocoCategoria` DROP FOREIGN KEY `IADICIONALPTPOCOCATEGORIA2` ";
            cmdBuffer += "  ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
         }
         cmdBuffer = " ALTER TABLE `AdicionalPtpocoCategoria` ADD CONSTRAINT `IADICIONALPTPOCOCATEGORIA2` ";
         cmdBuffer += "  FOREIGN KEY (`PaisCodigo`, `AdicionalTpocodId`) REFERENCES `AdicionalPTpoCo` (`PaisCodigo`, ";
         cmdBuffer += "  `AdicionalTpocodId`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void RIAdicionalPtpocoCategoriaAdicionalTpoCoa( ) throws SQLException
   {
      String cmdBuffer ;
      try
      {
         cmdBuffer = " ALTER TABLE `AdicionalPtpocoCategoria` ADD CONSTRAINT `IADICIONALPTPOCOCATEGORIA1` ";
         cmdBuffer += "  FOREIGN KEY (`PaisCodigo`, `AdicionalTpoCodAdd`) REFERENCES `AdicionalTpoCoa` (`PaisCodigo`, ";
         cmdBuffer += "  `AdicionalTpoCodAdd`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         try
         {
            cmdBuffer = " ALTER TABLE `AdicionalPtpocoCategoria` DROP FOREIGN KEY `IADICIONALPTPOCOCATEGORIA1` ";
            cmdBuffer += "  ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
         }
         cmdBuffer = " ALTER TABLE `AdicionalPtpocoCategoria` ADD CONSTRAINT `IADICIONALPTPOCOCATEGORIA1` ";
         cmdBuffer += "  FOREIGN KEY (`PaisCodigo`, `AdicionalTpoCodAdd`) REFERENCES `AdicionalTpoCoa` (`PaisCodigo`, ";
         cmdBuffer += "  `AdicionalTpoCodAdd`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void RIClienteSolicitudCodAdicionalClienteSolicitud( ) throws SQLException
   {
      String cmdBuffer ;
      try
      {
         cmdBuffer = " ALTER TABLE `ClienteSolicitudCodAdicional` ADD CONSTRAINT `ICLIENTESOLICITUDCODADICIONAL1` ";
         cmdBuffer += "  FOREIGN KEY (`PBaCID`) REFERENCES `ClienteSolicitud` (`PBaCID`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         try
         {
            cmdBuffer = " ALTER TABLE `ClienteSolicitudCodAdicional` DROP FOREIGN KEY `ICLIENTESOLICITUDCODADICIONAL1` ";
            cmdBuffer += "  ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
         }
         cmdBuffer = " ALTER TABLE `ClienteSolicitudCodAdicional` ADD CONSTRAINT `ICLIENTESOLICITUDCODADICIONAL1` ";
         cmdBuffer += "  FOREIGN KEY (`PBaCID`) REFERENCES `ClienteSolicitud` (`PBaCID`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void RIComportamientoRolPCLPais( ) throws SQLException
   {
      String cmdBuffer ;
      try
      {
         cmdBuffer = " ALTER TABLE `ComportamientoRol` ADD CONSTRAINT `ICOMPORTAMIENTOROL1` FOREIGN KEY ";
         cmdBuffer += "  (`PaisCodigo`) REFERENCES `PCLPais` (`PaisCodigo`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         try
         {
            cmdBuffer = " ALTER TABLE `ComportamientoRol` DROP FOREIGN KEY `ICOMPORTAMIENTOROL1` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
         }
         cmdBuffer = " ALTER TABLE `ComportamientoRol` ADD CONSTRAINT `ICOMPORTAMIENTOROL1` FOREIGN KEY ";
         cmdBuffer += "  (`PaisCodigo`) REFERENCES `PCLPais` (`PaisCodigo`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void RIPerfilImpositivoConfigPCLPais( ) throws SQLException
   {
      String cmdBuffer ;
      try
      {
         cmdBuffer = " ALTER TABLE `PerfilImpositivoConfig` ADD CONSTRAINT `GX_003H0001` FOREIGN KEY (`PaisCodigo`) ";
         cmdBuffer += "  REFERENCES `PCLPais` (`PaisCodigo`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         try
         {
            cmdBuffer = " ALTER TABLE `PerfilImpositivoConfig` DROP FOREIGN KEY `GX_003H0001` ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
         }
         cmdBuffer = " ALTER TABLE `PerfilImpositivoConfig` ADD CONSTRAINT `GX_003H0001` FOREIGN KEY (`PaisCodigo`) ";
         cmdBuffer += "  REFERENCES `PCLPais` (`PaisCodigo`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void RIPerfilImpositivoConfigAFIPTiposIVA( ) throws SQLException
   {
      String cmdBuffer ;
      try
      {
         cmdBuffer = " ALTER TABLE `PerfilImpositivoConfig` ADD CONSTRAINT `IPERFILIMPOSITIVOCONFIGURACIO1` ";
         cmdBuffer += "  FOREIGN KEY (`PaisCodigo`, `AFIPTiposIVACodigo`) REFERENCES `AFIPTiposIVA` (`PaisCodigo`, ";
         cmdBuffer += "  `AFIPTiposIVACodigo`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         try
         {
            cmdBuffer = " ALTER TABLE `PerfilImpositivoConfig` DROP FOREIGN KEY `IPERFILIMPOSITIVOCONFIGURACIO1` ";
            cmdBuffer += "  ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
         }
         cmdBuffer = " ALTER TABLE `PerfilImpositivoConfig` ADD CONSTRAINT `IPERFILIMPOSITIVOCONFIGURACIO1` ";
         cmdBuffer += "  FOREIGN KEY (`PaisCodigo`, `AFIPTiposIVACodigo`) REFERENCES `AFIPTiposIVA` (`PaisCodigo`, ";
         cmdBuffer += "  `AFIPTiposIVACodigo`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   public void RIPerfilImpositivoConfigJurisdicPerfilImpositivoConfig( ) throws SQLException
   {
      String cmdBuffer ;
      try
      {
         cmdBuffer = " ALTER TABLE `PerfilImpositivoConfigJurisdic` ADD CONSTRAINT `IPERFILIMPOSITIVOCONFIGURACIO7` ";
         cmdBuffer += "  FOREIGN KEY (`PICID`) REFERENCES `PerfilImpositivoConfig` (`PICID`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         try
         {
            cmdBuffer = " ALTER TABLE `PerfilImpositivoConfigJurisdic` DROP FOREIGN KEY `IPERFILIMPOSITIVOCONFIGURACIO7` ";
            cmdBuffer += "  ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
         }
         cmdBuffer = " ALTER TABLE `PerfilImpositivoConfigJurisdic` ADD CONSTRAINT `IPERFILIMPOSITIVOCONFIGURACIO7` ";
         cmdBuffer += "  FOREIGN KEY (`PICID`) REFERENCES `PerfilImpositivoConfig` (`PICID`) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   private void tablesCount( )
   {
   }

   private boolean previousCheck( )
   {
      if ( ! GXReorganization.isResumeMode( ) )
      {
         if ( GXutil.dbmsVersion( context, remoteHandle, "DEFAULT") < 5 )
         {
            GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_bad_DBMS_version", new Object[] {"5"}) ) ;
            return false ;
         }
      }
      if ( ! GXReorganization.mustRunCheck( ) )
      {
         return true ;
      }
      sSchemaVar = GXutil.databaseName( context, remoteHandle, "DEFAULT") ;
      if ( tableexist("PerfilImpositivoConfigJurisdic",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"PerfilImpositivoConfigJurisdic"}) ) ;
         return false ;
      }
      if ( tableexist("PerfilImpositivoConfig",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"PerfilImpositivoConfig"}) ) ;
         return false ;
      }
      if ( tableexist("ComportamientoRol",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"ComportamientoRol"}) ) ;
         return false ;
      }
      if ( tableexist("ServicioSolicitud",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"ServicioSolicitud"}) ) ;
         return false ;
      }
      if ( tableexist("ClienteSolicitudCodAdicional",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"ClienteSolicitudCodAdicional"}) ) ;
         return false ;
      }
      if ( tableexist("AdicionalPtpocoCategoria",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"AdicionalPtpocoCategoria"}) ) ;
         return false ;
      }
      if ( tableexist("AdicionalTpoCoa",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"AdicionalTpoCoa"}) ) ;
         return false ;
      }
      if ( tableexist("AdicionalPTpoCo",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"AdicionalPTpoCo"}) ) ;
         return false ;
      }
      if ( tableexist("EntidadServicio",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"EntidadServicio"}) ) ;
         return false ;
      }
      if ( tableexist("Entidad",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"Entidad"}) ) ;
         return false ;
      }
      if ( tableexist("PerfilImpoAFIPJurisdiccion",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"PerfilImpoAFIPJurisdiccion"}) ) ;
         return false ;
      }
      if ( tableexist("PerfilImpoAFIP",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"PerfilImpoAFIP"}) ) ;
         return false ;
      }
      if ( tableexist("AFIPTiposIVA",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"AFIPTiposIVA"}) ) ;
         return false ;
      }
      if ( tableexist("ClienteBloqueadoTmp",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"ClienteBloqueadoTmp"}) ) ;
         return false ;
      }
      if ( tableexist("AlcoholLicenciaLocalidad",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"AlcoholLicenciaLocalidad"}) ) ;
         return false ;
      }
      if ( tableexist("AlcoholLicenciaDepartamento",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"AlcoholLicenciaDepartamento"}) ) ;
         return false ;
      }
      if ( tableexist("AlcoholLicencia",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"AlcoholLicencia"}) ) ;
         return false ;
      }
      if ( tableexist("LogProcesoActiva",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"LogProcesoActiva"}) ) ;
         return false ;
      }
      if ( tableexist("ClienteSolicitudAdjunto",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"ClienteSolicitudAdjunto"}) ) ;
         return false ;
      }
      if ( tableexist("ClienteAdjunto",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"ClienteAdjunto"}) ) ;
         return false ;
      }
      if ( tableexist("ProcesoPaso",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"ProcesoPaso"}) ) ;
         return false ;
      }
      if ( tableexist("Proceso",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"Proceso"}) ) ;
         return false ;
      }
      if ( tableexist("LogProceso",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"LogProceso"}) ) ;
         return false ;
      }
      if ( tableexist("Equivalencia",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"Equivalencia"}) ) ;
         return false ;
      }
      if ( tableexist("SubRegionAlcohol",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"SubRegionAlcohol"}) ) ;
         return false ;
      }
      if ( tableexist("ClienteSolicitudTerrDiaVisita",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"ClienteSolicitudTerrDiaVisita"}) ) ;
         return false ;
      }
      if ( tableexist("ClienteSolicitudTerr",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"ClienteSolicitudTerr"}) ) ;
         return false ;
      }
      if ( tableexist("ClienteSolicitud",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"ClienteSolicitud"}) ) ;
         return false ;
      }
      if ( tableexist("DepartamentoLocalidad",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"DepartamentoLocalidad"}) ) ;
         return false ;
      }
      if ( tableexist("Departamento",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"Departamento"}) ) ;
         return false ;
      }
      if ( tableexist("Auditoria",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"Auditoria"}) ) ;
         return false ;
      }
      if ( tableexist("UserRegion",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"UserRegion"}) ) ;
         return false ;
      }
      if ( tableexist("PCLLocDist",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"PCLLocDist"}) ) ;
         return false ;
      }
      if ( tableexist("Parametros",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"Parametros"}) ) ;
         return false ;
      }
      if ( tableexist("BandejaAutorizacion",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"BandejaAutorizacion"}) ) ;
         return false ;
      }
      if ( tableexist("CodigosAdicionales",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"CodigosAdicionales"}) ) ;
         return false ;
      }
      if ( tableexist("PCLMaTeZo",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"PCLMaTeZo"}) ) ;
         return false ;
      }
      if ( tableexist("PCLZonVis",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"PCLZonVis"}) ) ;
         return false ;
      }
      if ( tableexist("PCLZonEnt",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"PCLZonEnt"}) ) ;
         return false ;
      }
      if ( tableexist("PCLCodAte",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"PCLCodAte"}) ) ;
         return false ;
      }
      if ( tableexist("PCLValDef",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"PCLValDef"}) ) ;
         return false ;
      }
      if ( tableexist("PCLTipoVta",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"PCLTipoVta"}) ) ;
         return false ;
      }
      if ( tableexist("PCLPais",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"PCLPais"}) ) ;
         return false ;
      }
      return true ;
   }

   private boolean tableexist( String sTableName ,
                               String sMySchemaName )
   {
      boolean result ;
      result = false ;
      /* Using cursor P00012 */
      pr_default.execute(0, new Object[] {sTableName, sMySchemaName});
      while ( (pr_default.getStatus(0) != 101) )
      {
         tablename = P00012_Atablename[0] ;
         ntablename = P00012_ntablename[0] ;
         schemaname = P00012_Aschemaname[0] ;
         nschemaname = P00012_nschemaname[0] ;
         result = true ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      return result ;
   }

   private void executeOnlyTablesReorganization( )
   {
      callSubmit( "CreatePerfilImpositivoConfigJurisdic" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PerfilImpositivoConfigJurisdic",""}) ,  1 , new Object[]{ });
      callSubmit( "CreatePerfilImpositivoConfig" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PerfilImpositivoConfig",""}) ,  2 , new Object[]{ });
      callSubmit( "CreateComportamientoRol" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"ComportamientoRol",""}) ,  3 , new Object[]{ });
      callSubmit( "CreateServicioSolicitud" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"ServicioSolicitud",""}) ,  4 , new Object[]{ });
      callSubmit( "CreateClienteSolicitudCodAdicional" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"ClienteSolicitudCodAdicional",""}) ,  5 , new Object[]{ });
      callSubmit( "CreateAdicionalPtpocoCategoria" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"AdicionalPtpocoCategoria",""}) ,  6 , new Object[]{ });
      callSubmit( "CreateAdicionalTpoCoa" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"AdicionalTpoCoa",""}) ,  7 , new Object[]{ });
      callSubmit( "CreateAdicionalPTpoCo" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"AdicionalPTpoCo",""}) ,  8 , new Object[]{ });
      callSubmit( "CreateEntidadServicio" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"EntidadServicio",""}) ,  9 , new Object[]{ });
      callSubmit( "CreateEntidad" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"Entidad",""}) ,  10 , new Object[]{ });
      callSubmit( "CreatePerfilImpoAFIPJurisdiccion" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PerfilImpoAFIPJurisdiccion",""}) ,  11 , new Object[]{ });
      callSubmit( "CreatePerfilImpoAFIP" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PerfilImpoAFIP",""}) ,  12 , new Object[]{ });
      callSubmit( "CreateAFIPTiposIVA" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"AFIPTiposIVA",""}) ,  13 , new Object[]{ });
      callSubmit( "CreateClienteBloqueadoTmp" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"ClienteBloqueadoTmp",""}) ,  14 , new Object[]{ });
      callSubmit( "CreateAlcoholLicenciaLocalidad" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"AlcoholLicenciaLocalidad",""}) ,  15 , new Object[]{ });
      callSubmit( "CreateAlcoholLicenciaDepartamento" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"AlcoholLicenciaDepartamento",""}) ,  16 , new Object[]{ });
      callSubmit( "CreateAlcoholLicencia" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"AlcoholLicencia",""}) ,  17 , new Object[]{ });
      callSubmit( "CreateLogProcesoActiva" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"LogProcesoActiva",""}) ,  18 , new Object[]{ });
      callSubmit( "CreateClienteSolicitudAdjunto" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"ClienteSolicitudAdjunto",""}) ,  19 , new Object[]{ });
      callSubmit( "CreateClienteAdjunto" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"ClienteAdjunto",""}) ,  20 , new Object[]{ });
      callSubmit( "CreateProcesoPaso" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"ProcesoPaso",""}) ,  21 , new Object[]{ });
      callSubmit( "CreateProceso" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"Proceso",""}) ,  22 , new Object[]{ });
      callSubmit( "CreateLogProceso" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"LogProceso",""}) ,  23 , new Object[]{ });
      callSubmit( "CreateEquivalencia" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"Equivalencia",""}) ,  24 , new Object[]{ });
      callSubmit( "CreateSubRegionAlcohol" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"SubRegionAlcohol",""}) ,  25 , new Object[]{ });
      callSubmit( "CreateClienteSolicitudTerrDiaVisita" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"ClienteSolicitudTerrDiaVisita",""}) ,  26 , new Object[]{ });
      callSubmit( "CreateClienteSolicitudTerr" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"ClienteSolicitudTerr",""}) ,  27 , new Object[]{ });
      callSubmit( "CreateClienteSolicitud" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"ClienteSolicitud",""}) ,  28 , new Object[]{ });
      callSubmit( "CreateDepartamentoLocalidad" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"DepartamentoLocalidad",""}) ,  29 , new Object[]{ });
      callSubmit( "CreateDepartamento" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"Departamento",""}) ,  30 , new Object[]{ });
      callSubmit( "CreateAuditoria" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"Auditoria",""}) ,  31 , new Object[]{ });
      callSubmit( "CreateUserRegion" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"UserRegion",""}) ,  32 , new Object[]{ });
      callSubmit( "CreatePCLLocDist" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PCLLocDist",""}) ,  33 , new Object[]{ });
      callSubmit( "CreateParametros" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"Parametros",""}) ,  34 , new Object[]{ });
      callSubmit( "CreateBandejaAutorizacion" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"BandejaAutorizacion",""}) ,  35 , new Object[]{ });
      callSubmit( "CreateCodigosAdicionales" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"CodigosAdicionales",""}) ,  36 , new Object[]{ });
      callSubmit( "CreatePCLMaTeZo" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PCLMaTeZo",""}) ,  37 , new Object[]{ });
      callSubmit( "CreatePCLZonVis" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PCLZonVis",""}) ,  38 , new Object[]{ });
      callSubmit( "CreatePCLZonEnt" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PCLZonEnt",""}) ,  39 , new Object[]{ });
      callSubmit( "CreatePCLCodAte" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PCLCodAte",""}) ,  40 , new Object[]{ });
      callSubmit( "CreatePCLValDef" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PCLValDef",""}) ,  41 , new Object[]{ });
      callSubmit( "CreatePCLTipoVta" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PCLTipoVta",""}) ,  42 , new Object[]{ });
      callSubmit( "CreatePCLPais" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PCLPais",""}) ,  43 , new Object[]{ });
   }

   private void executeOnlyRisReorganization( )
   {
      callSubmit( "RIPCLTipoVtaPCLPais" ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPCLTIPOVTA01`"}) ,  44 , new Object[]{ });
      callSubmit( "RIPCLValDefPCLPais" ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPCLVALDEF01`"}) ,  45 , new Object[]{ });
      callSubmit( "RIPCLCodAtePCLPais" ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPCLCODATE01`"}) ,  46 , new Object[]{ });
      callSubmit( "RIPCLZonEntPCLPais" ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPCLZONENT01`"}) ,  47 , new Object[]{ });
      callSubmit( "RIPCLZonVisPCLPais" ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IZONASVISITA1`"}) ,  48 , new Object[]{ });
      callSubmit( "RIPCLMaTeZoPCLPais" ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPCLMATEZO01`"}) ,  49 , new Object[]{ });
      callSubmit( "RIParametrosPCLPais" ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPARAMETROS4`"}) ,  50 , new Object[]{ });
      callSubmit( "RIPCLLocDistPCLPais" ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`ILOCALIDADESDISTRIBUIDORES1`"}) ,  51 , new Object[]{ });
      callSubmit( "RIDepartamentoPCLPais" ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IDEPARTAMENTO2`"}) ,  52 , new Object[]{ });
      callSubmit( "RIDepartamentoLocalidadDepartamento" ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IDEPARTAMENTOLOCALIDAD2`"}) ,  53 , new Object[]{ });
      callSubmit( "RIClienteSolicitudPCLPais" ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`GX_002L0001`"}) ,  54 , new Object[]{ });
      callSubmit( "RIClienteSolicitudPCLMaTeZo" ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`ICLIENTESOLICITUD3`"}) ,  55 , new Object[]{ });
      callSubmit( "RIClienteSolicitudPCLZonEnt" ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`ICLIENTESOLICITUD2`"}) ,  56 , new Object[]{ });
      callSubmit( "RIClienteSolicitudTerrClienteSolicitud" ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`ICLIENTESOLICITUDTERR1`"}) ,  57 , new Object[]{ });
      callSubmit( "RIClienteSolicitudTerrDiaVisitaClienteSolicitudTerr" ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`ICLIENTESOLICITUDTERRDIAVISIT1`"}) ,  58 , new Object[]{ });
      callSubmit( "RIProcesoPasoProceso" ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPROCESOPASO1`"}) ,  59 , new Object[]{ });
      callSubmit( "RIClienteSolicitudAdjuntoClienteSolicitud" ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`ICLIENTESOLICITUDADJUNTO1`"}) ,  60 , new Object[]{ });
      callSubmit( "RIAlcoholLicenciaPCLPais" ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IALCOHOLLICENCIA`"}) ,  61 , new Object[]{ });
      callSubmit( "RIAlcoholLicenciaDepartamentoAlcoholLicencia" ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IALCOHOLLICENCIADEPARTAMENTO1`"}) ,  62 , new Object[]{ });
      callSubmit( "RIAlcoholLicenciaDepartamentoDepartamento" ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IALCOHOLLICENCIADEPARTAMENTO`"}) ,  63 , new Object[]{ });
      callSubmit( "RIAlcoholLicenciaLocalidadAlcoholLicenciaDepartamento" ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IALCOHOLLICENCIALOCALIDAD1`"}) ,  64 , new Object[]{ });
      callSubmit( "RIAlcoholLicenciaLocalidadDepartamentoLocalidad" ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IALCOHOLLICENCIALOCALIDAD`"}) ,  65 , new Object[]{ });
      callSubmit( "RIAFIPTiposIVAPCLPais" ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IAFIPTIPOSIVA1`"}) ,  66 , new Object[]{ });
      callSubmit( "RIPerfilImpoAFIPAFIPTiposIVA" ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPERFILIMPOAFIP1`"}) ,  67 , new Object[]{ });
      callSubmit( "RIPerfilImpoAFIPJurisdiccionPerfilImpoAFIP" ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPERFILIMPOAFIPJURISDICCION1`"}) ,  68 , new Object[]{ });
      callSubmit( "RIEntidadPCLPais" ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IENTIDAD1`"}) ,  69 , new Object[]{ });
      callSubmit( "RIEntidadServicioEntidad" ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IENTIDADSERVICIO1`"}) ,  70 , new Object[]{ });
      callSubmit( "RIAdicionalPTpoCoPCLPais" ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IADICIONALPTPOCO1`"}) ,  71 , new Object[]{ });
      callSubmit( "RIAdicionalTpoCoaPCLPais" ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IADICIONALTPOCOA1`"}) ,  72 , new Object[]{ });
      callSubmit( "RIAdicionalPtpocoCategoriaAdicionalPTpoCo" ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IADICIONALPTPOCOCATEGORIA2`"}) ,  73 , new Object[]{ });
      callSubmit( "RIAdicionalPtpocoCategoriaAdicionalTpoCoa" ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IADICIONALPTPOCOCATEGORIA1`"}) ,  74 , new Object[]{ });
      callSubmit( "RIClienteSolicitudCodAdicionalClienteSolicitud" ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`ICLIENTESOLICITUDCODADICIONAL1`"}) ,  75 , new Object[]{ });
      callSubmit( "RIComportamientoRolPCLPais" ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`ICOMPORTAMIENTOROL1`"}) ,  76 , new Object[]{ });
      callSubmit( "RIPerfilImpositivoConfigPCLPais" ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`GX_003H0001`"}) ,  77 , new Object[]{ });
      callSubmit( "RIPerfilImpositivoConfigAFIPTiposIVA" ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPERFILIMPOSITIVOCONFIGURACIO1`"}) ,  78 , new Object[]{ });
      callSubmit( "RIPerfilImpositivoConfigJurisdicPerfilImpositivoConfig" ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPERFILIMPOSITIVOCONFIGURACIO7`"}) ,  79 , new Object[]{ });
   }

   private void executeTablesReorganization( )
   {
      executeOnlyTablesReorganization( ) ;
      executeOnlyRisReorganization( ) ;
      ReorgSubmitThreadPool.startProcess();
   }

   private void setPrecedence( )
   {
      setPrecedencetables( ) ;
      setPrecedenceris( ) ;
   }

   private void setPrecedencetables( )
   {
      GXReorganization.addMsg( 1 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PerfilImpositivoConfigJurisdic",""}) );
      ReorgSubmitThreadPool.addBlock( "CreatePerfilImpositivoConfigJurisdic" );
      ReorgSubmitThreadPool.addPrecedence( "CreatePerfilImpositivoConfigJurisdic" ,  "CreatePerfilImpositivoConfig" );
      GXReorganization.addMsg( 2 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PerfilImpositivoConfig",""}) );
      ReorgSubmitThreadPool.addBlock( "CreatePerfilImpositivoConfig" );
      ReorgSubmitThreadPool.addPrecedence( "CreatePerfilImpositivoConfig" ,  "CreatePCLPais" );
      ReorgSubmitThreadPool.addPrecedence( "CreatePerfilImpositivoConfig" ,  "CreateAFIPTiposIVA" );
      GXReorganization.addMsg( 3 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"ComportamientoRol",""}) );
      ReorgSubmitThreadPool.addBlock( "CreateComportamientoRol" );
      ReorgSubmitThreadPool.addPrecedence( "CreateComportamientoRol" ,  "CreatePCLPais" );
      GXReorganization.addMsg( 4 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"ServicioSolicitud",""}) );
      ReorgSubmitThreadPool.addBlock( "CreateServicioSolicitud" );
      GXReorganization.addMsg( 5 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"ClienteSolicitudCodAdicional",""}) );
      ReorgSubmitThreadPool.addBlock( "CreateClienteSolicitudCodAdicional" );
      ReorgSubmitThreadPool.addPrecedence( "CreateClienteSolicitudCodAdicional" ,  "CreateClienteSolicitud" );
      GXReorganization.addMsg( 6 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"AdicionalPtpocoCategoria",""}) );
      ReorgSubmitThreadPool.addBlock( "CreateAdicionalPtpocoCategoria" );
      ReorgSubmitThreadPool.addPrecedence( "CreateAdicionalPtpocoCategoria" ,  "CreateAdicionalPTpoCo" );
      ReorgSubmitThreadPool.addPrecedence( "CreateAdicionalPtpocoCategoria" ,  "CreateAdicionalTpoCoa" );
      GXReorganization.addMsg( 7 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"AdicionalTpoCoa",""}) );
      ReorgSubmitThreadPool.addBlock( "CreateAdicionalTpoCoa" );
      ReorgSubmitThreadPool.addPrecedence( "CreateAdicionalTpoCoa" ,  "CreatePCLPais" );
      GXReorganization.addMsg( 8 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"AdicionalPTpoCo",""}) );
      ReorgSubmitThreadPool.addBlock( "CreateAdicionalPTpoCo" );
      ReorgSubmitThreadPool.addPrecedence( "CreateAdicionalPTpoCo" ,  "CreatePCLPais" );
      GXReorganization.addMsg( 9 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"EntidadServicio",""}) );
      ReorgSubmitThreadPool.addBlock( "CreateEntidadServicio" );
      ReorgSubmitThreadPool.addPrecedence( "CreateEntidadServicio" ,  "CreateEntidad" );
      GXReorganization.addMsg( 10 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"Entidad",""}) );
      ReorgSubmitThreadPool.addBlock( "CreateEntidad" );
      ReorgSubmitThreadPool.addPrecedence( "CreateEntidad" ,  "CreatePCLPais" );
      GXReorganization.addMsg( 11 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PerfilImpoAFIPJurisdiccion",""}) );
      ReorgSubmitThreadPool.addBlock( "CreatePerfilImpoAFIPJurisdiccion" );
      ReorgSubmitThreadPool.addPrecedence( "CreatePerfilImpoAFIPJurisdiccion" ,  "CreatePerfilImpoAFIP" );
      GXReorganization.addMsg( 12 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PerfilImpoAFIP",""}) );
      ReorgSubmitThreadPool.addBlock( "CreatePerfilImpoAFIP" );
      ReorgSubmitThreadPool.addPrecedence( "CreatePerfilImpoAFIP" ,  "CreateAFIPTiposIVA" );
      GXReorganization.addMsg( 13 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"AFIPTiposIVA",""}) );
      ReorgSubmitThreadPool.addBlock( "CreateAFIPTiposIVA" );
      ReorgSubmitThreadPool.addPrecedence( "CreateAFIPTiposIVA" ,  "CreatePCLPais" );
      GXReorganization.addMsg( 14 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"ClienteBloqueadoTmp",""}) );
      ReorgSubmitThreadPool.addBlock( "CreateClienteBloqueadoTmp" );
      GXReorganization.addMsg( 15 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"AlcoholLicenciaLocalidad",""}) );
      ReorgSubmitThreadPool.addBlock( "CreateAlcoholLicenciaLocalidad" );
      ReorgSubmitThreadPool.addPrecedence( "CreateAlcoholLicenciaLocalidad" ,  "CreateAlcoholLicenciaDepartamento" );
      ReorgSubmitThreadPool.addPrecedence( "CreateAlcoholLicenciaLocalidad" ,  "CreateDepartamentoLocalidad" );
      GXReorganization.addMsg( 16 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"AlcoholLicenciaDepartamento",""}) );
      ReorgSubmitThreadPool.addBlock( "CreateAlcoholLicenciaDepartamento" );
      ReorgSubmitThreadPool.addPrecedence( "CreateAlcoholLicenciaDepartamento" ,  "CreateAlcoholLicencia" );
      ReorgSubmitThreadPool.addPrecedence( "CreateAlcoholLicenciaDepartamento" ,  "CreateDepartamento" );
      GXReorganization.addMsg( 17 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"AlcoholLicencia",""}) );
      ReorgSubmitThreadPool.addBlock( "CreateAlcoholLicencia" );
      ReorgSubmitThreadPool.addPrecedence( "CreateAlcoholLicencia" ,  "CreatePCLPais" );
      GXReorganization.addMsg( 18 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"LogProcesoActiva",""}) );
      ReorgSubmitThreadPool.addBlock( "CreateLogProcesoActiva" );
      GXReorganization.addMsg( 19 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"ClienteSolicitudAdjunto",""}) );
      ReorgSubmitThreadPool.addBlock( "CreateClienteSolicitudAdjunto" );
      ReorgSubmitThreadPool.addPrecedence( "CreateClienteSolicitudAdjunto" ,  "CreateClienteSolicitud" );
      GXReorganization.addMsg( 20 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"ClienteAdjunto",""}) );
      ReorgSubmitThreadPool.addBlock( "CreateClienteAdjunto" );
      GXReorganization.addMsg( 21 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"ProcesoPaso",""}) );
      ReorgSubmitThreadPool.addBlock( "CreateProcesoPaso" );
      ReorgSubmitThreadPool.addPrecedence( "CreateProcesoPaso" ,  "CreateProceso" );
      GXReorganization.addMsg( 22 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"Proceso",""}) );
      ReorgSubmitThreadPool.addBlock( "CreateProceso" );
      GXReorganization.addMsg( 23 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"LogProceso",""}) );
      ReorgSubmitThreadPool.addBlock( "CreateLogProceso" );
      GXReorganization.addMsg( 24 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"Equivalencia",""}) );
      ReorgSubmitThreadPool.addBlock( "CreateEquivalencia" );
      GXReorganization.addMsg( 25 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"SubRegionAlcohol",""}) );
      ReorgSubmitThreadPool.addBlock( "CreateSubRegionAlcohol" );
      GXReorganization.addMsg( 26 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"ClienteSolicitudTerrDiaVisita",""}) );
      ReorgSubmitThreadPool.addBlock( "CreateClienteSolicitudTerrDiaVisita" );
      ReorgSubmitThreadPool.addPrecedence( "CreateClienteSolicitudTerrDiaVisita" ,  "CreateClienteSolicitudTerr" );
      GXReorganization.addMsg( 27 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"ClienteSolicitudTerr",""}) );
      ReorgSubmitThreadPool.addBlock( "CreateClienteSolicitudTerr" );
      ReorgSubmitThreadPool.addPrecedence( "CreateClienteSolicitudTerr" ,  "CreateClienteSolicitud" );
      GXReorganization.addMsg( 28 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"ClienteSolicitud",""}) );
      ReorgSubmitThreadPool.addBlock( "CreateClienteSolicitud" );
      ReorgSubmitThreadPool.addPrecedence( "CreateClienteSolicitud" ,  "CreatePCLPais" );
      ReorgSubmitThreadPool.addPrecedence( "CreateClienteSolicitud" ,  "CreatePCLMaTeZo" );
      ReorgSubmitThreadPool.addPrecedence( "CreateClienteSolicitud" ,  "CreatePCLZonEnt" );
      GXReorganization.addMsg( 29 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"DepartamentoLocalidad",""}) );
      ReorgSubmitThreadPool.addBlock( "CreateDepartamentoLocalidad" );
      ReorgSubmitThreadPool.addPrecedence( "CreateDepartamentoLocalidad" ,  "CreateDepartamento" );
      GXReorganization.addMsg( 30 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"Departamento",""}) );
      ReorgSubmitThreadPool.addBlock( "CreateDepartamento" );
      ReorgSubmitThreadPool.addPrecedence( "CreateDepartamento" ,  "CreatePCLPais" );
      GXReorganization.addMsg( 31 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"Auditoria",""}) );
      ReorgSubmitThreadPool.addBlock( "CreateAuditoria" );
      GXReorganization.addMsg( 32 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"UserRegion",""}) );
      ReorgSubmitThreadPool.addBlock( "CreateUserRegion" );
      GXReorganization.addMsg( 33 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PCLLocDist",""}) );
      ReorgSubmitThreadPool.addBlock( "CreatePCLLocDist" );
      ReorgSubmitThreadPool.addPrecedence( "CreatePCLLocDist" ,  "CreatePCLPais" );
      GXReorganization.addMsg( 34 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"Parametros",""}) );
      ReorgSubmitThreadPool.addBlock( "CreateParametros" );
      ReorgSubmitThreadPool.addPrecedence( "CreateParametros" ,  "CreatePCLPais" );
      GXReorganization.addMsg( 35 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"BandejaAutorizacion",""}) );
      ReorgSubmitThreadPool.addBlock( "CreateBandejaAutorizacion" );
      GXReorganization.addMsg( 36 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"CodigosAdicionales",""}) );
      ReorgSubmitThreadPool.addBlock( "CreateCodigosAdicionales" );
      GXReorganization.addMsg( 37 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PCLMaTeZo",""}) );
      ReorgSubmitThreadPool.addBlock( "CreatePCLMaTeZo" );
      ReorgSubmitThreadPool.addPrecedence( "CreatePCLMaTeZo" ,  "CreatePCLPais" );
      GXReorganization.addMsg( 38 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PCLZonVis",""}) );
      ReorgSubmitThreadPool.addBlock( "CreatePCLZonVis" );
      ReorgSubmitThreadPool.addPrecedence( "CreatePCLZonVis" ,  "CreatePCLPais" );
      GXReorganization.addMsg( 39 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PCLZonEnt",""}) );
      ReorgSubmitThreadPool.addBlock( "CreatePCLZonEnt" );
      ReorgSubmitThreadPool.addPrecedence( "CreatePCLZonEnt" ,  "CreatePCLPais" );
      GXReorganization.addMsg( 40 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PCLCodAte",""}) );
      ReorgSubmitThreadPool.addBlock( "CreatePCLCodAte" );
      ReorgSubmitThreadPool.addPrecedence( "CreatePCLCodAte" ,  "CreatePCLPais" );
      GXReorganization.addMsg( 41 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PCLValDef",""}) );
      ReorgSubmitThreadPool.addBlock( "CreatePCLValDef" );
      ReorgSubmitThreadPool.addPrecedence( "CreatePCLValDef" ,  "CreatePCLPais" );
      GXReorganization.addMsg( 42 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PCLTipoVta",""}) );
      ReorgSubmitThreadPool.addBlock( "CreatePCLTipoVta" );
      ReorgSubmitThreadPool.addPrecedence( "CreatePCLTipoVta" ,  "CreatePCLPais" );
      GXReorganization.addMsg( 43 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PCLPais",""}) );
      ReorgSubmitThreadPool.addBlock( "CreatePCLPais" );
   }

   private void setPrecedenceris( )
   {
      GXReorganization.addMsg( 44 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPCLTIPOVTA01`"}) );
      ReorgSubmitThreadPool.addBlock( "RIPCLTipoVtaPCLPais" );
      ReorgSubmitThreadPool.addPrecedence( "RIPCLTipoVtaPCLPais" ,  "CreatePCLTipoVta" );
      ReorgSubmitThreadPool.addPrecedence( "RIPCLTipoVtaPCLPais" ,  "CreatePCLPais" );
      GXReorganization.addMsg( 45 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPCLVALDEF01`"}) );
      ReorgSubmitThreadPool.addBlock( "RIPCLValDefPCLPais" );
      ReorgSubmitThreadPool.addPrecedence( "RIPCLValDefPCLPais" ,  "CreatePCLValDef" );
      ReorgSubmitThreadPool.addPrecedence( "RIPCLValDefPCLPais" ,  "CreatePCLPais" );
      GXReorganization.addMsg( 46 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPCLCODATE01`"}) );
      ReorgSubmitThreadPool.addBlock( "RIPCLCodAtePCLPais" );
      ReorgSubmitThreadPool.addPrecedence( "RIPCLCodAtePCLPais" ,  "CreatePCLCodAte" );
      ReorgSubmitThreadPool.addPrecedence( "RIPCLCodAtePCLPais" ,  "CreatePCLPais" );
      GXReorganization.addMsg( 47 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPCLZONENT01`"}) );
      ReorgSubmitThreadPool.addBlock( "RIPCLZonEntPCLPais" );
      ReorgSubmitThreadPool.addPrecedence( "RIPCLZonEntPCLPais" ,  "CreatePCLZonEnt" );
      ReorgSubmitThreadPool.addPrecedence( "RIPCLZonEntPCLPais" ,  "CreatePCLPais" );
      GXReorganization.addMsg( 48 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IZONASVISITA1`"}) );
      ReorgSubmitThreadPool.addBlock( "RIPCLZonVisPCLPais" );
      ReorgSubmitThreadPool.addPrecedence( "RIPCLZonVisPCLPais" ,  "CreatePCLZonVis" );
      ReorgSubmitThreadPool.addPrecedence( "RIPCLZonVisPCLPais" ,  "CreatePCLPais" );
      GXReorganization.addMsg( 49 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPCLMATEZO01`"}) );
      ReorgSubmitThreadPool.addBlock( "RIPCLMaTeZoPCLPais" );
      ReorgSubmitThreadPool.addPrecedence( "RIPCLMaTeZoPCLPais" ,  "CreatePCLMaTeZo" );
      ReorgSubmitThreadPool.addPrecedence( "RIPCLMaTeZoPCLPais" ,  "CreatePCLPais" );
      GXReorganization.addMsg( 50 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPARAMETROS4`"}) );
      ReorgSubmitThreadPool.addBlock( "RIParametrosPCLPais" );
      ReorgSubmitThreadPool.addPrecedence( "RIParametrosPCLPais" ,  "CreateParametros" );
      ReorgSubmitThreadPool.addPrecedence( "RIParametrosPCLPais" ,  "CreatePCLPais" );
      GXReorganization.addMsg( 51 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`ILOCALIDADESDISTRIBUIDORES1`"}) );
      ReorgSubmitThreadPool.addBlock( "RIPCLLocDistPCLPais" );
      ReorgSubmitThreadPool.addPrecedence( "RIPCLLocDistPCLPais" ,  "CreatePCLLocDist" );
      ReorgSubmitThreadPool.addPrecedence( "RIPCLLocDistPCLPais" ,  "CreatePCLPais" );
      GXReorganization.addMsg( 52 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IDEPARTAMENTO2`"}) );
      ReorgSubmitThreadPool.addBlock( "RIDepartamentoPCLPais" );
      ReorgSubmitThreadPool.addPrecedence( "RIDepartamentoPCLPais" ,  "CreateDepartamento" );
      ReorgSubmitThreadPool.addPrecedence( "RIDepartamentoPCLPais" ,  "CreatePCLPais" );
      GXReorganization.addMsg( 53 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IDEPARTAMENTOLOCALIDAD2`"}) );
      ReorgSubmitThreadPool.addBlock( "RIDepartamentoLocalidadDepartamento" );
      ReorgSubmitThreadPool.addPrecedence( "RIDepartamentoLocalidadDepartamento" ,  "CreateDepartamentoLocalidad" );
      ReorgSubmitThreadPool.addPrecedence( "RIDepartamentoLocalidadDepartamento" ,  "CreateDepartamento" );
      GXReorganization.addMsg( 54 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`GX_002L0001`"}) );
      ReorgSubmitThreadPool.addBlock( "RIClienteSolicitudPCLPais" );
      ReorgSubmitThreadPool.addPrecedence( "RIClienteSolicitudPCLPais" ,  "CreateClienteSolicitud" );
      ReorgSubmitThreadPool.addPrecedence( "RIClienteSolicitudPCLPais" ,  "CreatePCLPais" );
      GXReorganization.addMsg( 55 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`ICLIENTESOLICITUD3`"}) );
      ReorgSubmitThreadPool.addBlock( "RIClienteSolicitudPCLMaTeZo" );
      ReorgSubmitThreadPool.addPrecedence( "RIClienteSolicitudPCLMaTeZo" ,  "CreateClienteSolicitud" );
      ReorgSubmitThreadPool.addPrecedence( "RIClienteSolicitudPCLMaTeZo" ,  "CreatePCLMaTeZo" );
      GXReorganization.addMsg( 56 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`ICLIENTESOLICITUD2`"}) );
      ReorgSubmitThreadPool.addBlock( "RIClienteSolicitudPCLZonEnt" );
      ReorgSubmitThreadPool.addPrecedence( "RIClienteSolicitudPCLZonEnt" ,  "CreateClienteSolicitud" );
      ReorgSubmitThreadPool.addPrecedence( "RIClienteSolicitudPCLZonEnt" ,  "CreatePCLZonEnt" );
      GXReorganization.addMsg( 57 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`ICLIENTESOLICITUDTERR1`"}) );
      ReorgSubmitThreadPool.addBlock( "RIClienteSolicitudTerrClienteSolicitud" );
      ReorgSubmitThreadPool.addPrecedence( "RIClienteSolicitudTerrClienteSolicitud" ,  "CreateClienteSolicitudTerr" );
      ReorgSubmitThreadPool.addPrecedence( "RIClienteSolicitudTerrClienteSolicitud" ,  "CreateClienteSolicitud" );
      GXReorganization.addMsg( 58 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`ICLIENTESOLICITUDTERRDIAVISIT1`"}) );
      ReorgSubmitThreadPool.addBlock( "RIClienteSolicitudTerrDiaVisitaClienteSolicitudTerr" );
      ReorgSubmitThreadPool.addPrecedence( "RIClienteSolicitudTerrDiaVisitaClienteSolicitudTerr" ,  "CreateClienteSolicitudTerrDiaVisita" );
      ReorgSubmitThreadPool.addPrecedence( "RIClienteSolicitudTerrDiaVisitaClienteSolicitudTerr" ,  "CreateClienteSolicitudTerr" );
      GXReorganization.addMsg( 59 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPROCESOPASO1`"}) );
      ReorgSubmitThreadPool.addBlock( "RIProcesoPasoProceso" );
      ReorgSubmitThreadPool.addPrecedence( "RIProcesoPasoProceso" ,  "CreateProcesoPaso" );
      ReorgSubmitThreadPool.addPrecedence( "RIProcesoPasoProceso" ,  "CreateProceso" );
      GXReorganization.addMsg( 60 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`ICLIENTESOLICITUDADJUNTO1`"}) );
      ReorgSubmitThreadPool.addBlock( "RIClienteSolicitudAdjuntoClienteSolicitud" );
      ReorgSubmitThreadPool.addPrecedence( "RIClienteSolicitudAdjuntoClienteSolicitud" ,  "CreateClienteSolicitudAdjunto" );
      ReorgSubmitThreadPool.addPrecedence( "RIClienteSolicitudAdjuntoClienteSolicitud" ,  "CreateClienteSolicitud" );
      GXReorganization.addMsg( 61 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IALCOHOLLICENCIA`"}) );
      ReorgSubmitThreadPool.addBlock( "RIAlcoholLicenciaPCLPais" );
      ReorgSubmitThreadPool.addPrecedence( "RIAlcoholLicenciaPCLPais" ,  "CreateAlcoholLicencia" );
      ReorgSubmitThreadPool.addPrecedence( "RIAlcoholLicenciaPCLPais" ,  "CreatePCLPais" );
      GXReorganization.addMsg( 62 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IALCOHOLLICENCIADEPARTAMENTO1`"}) );
      ReorgSubmitThreadPool.addBlock( "RIAlcoholLicenciaDepartamentoAlcoholLicencia" );
      ReorgSubmitThreadPool.addPrecedence( "RIAlcoholLicenciaDepartamentoAlcoholLicencia" ,  "CreateAlcoholLicenciaDepartamento" );
      ReorgSubmitThreadPool.addPrecedence( "RIAlcoholLicenciaDepartamentoAlcoholLicencia" ,  "CreateAlcoholLicencia" );
      GXReorganization.addMsg( 63 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IALCOHOLLICENCIADEPARTAMENTO`"}) );
      ReorgSubmitThreadPool.addBlock( "RIAlcoholLicenciaDepartamentoDepartamento" );
      ReorgSubmitThreadPool.addPrecedence( "RIAlcoholLicenciaDepartamentoDepartamento" ,  "CreateAlcoholLicenciaDepartamento" );
      ReorgSubmitThreadPool.addPrecedence( "RIAlcoholLicenciaDepartamentoDepartamento" ,  "CreateDepartamento" );
      GXReorganization.addMsg( 64 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IALCOHOLLICENCIALOCALIDAD1`"}) );
      ReorgSubmitThreadPool.addBlock( "RIAlcoholLicenciaLocalidadAlcoholLicenciaDepartamento" );
      ReorgSubmitThreadPool.addPrecedence( "RIAlcoholLicenciaLocalidadAlcoholLicenciaDepartamento" ,  "CreateAlcoholLicenciaLocalidad" );
      ReorgSubmitThreadPool.addPrecedence( "RIAlcoholLicenciaLocalidadAlcoholLicenciaDepartamento" ,  "CreateAlcoholLicenciaDepartamento" );
      GXReorganization.addMsg( 65 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IALCOHOLLICENCIALOCALIDAD`"}) );
      ReorgSubmitThreadPool.addBlock( "RIAlcoholLicenciaLocalidadDepartamentoLocalidad" );
      ReorgSubmitThreadPool.addPrecedence( "RIAlcoholLicenciaLocalidadDepartamentoLocalidad" ,  "CreateAlcoholLicenciaLocalidad" );
      ReorgSubmitThreadPool.addPrecedence( "RIAlcoholLicenciaLocalidadDepartamentoLocalidad" ,  "CreateDepartamentoLocalidad" );
      GXReorganization.addMsg( 66 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IAFIPTIPOSIVA1`"}) );
      ReorgSubmitThreadPool.addBlock( "RIAFIPTiposIVAPCLPais" );
      ReorgSubmitThreadPool.addPrecedence( "RIAFIPTiposIVAPCLPais" ,  "CreateAFIPTiposIVA" );
      ReorgSubmitThreadPool.addPrecedence( "RIAFIPTiposIVAPCLPais" ,  "CreatePCLPais" );
      GXReorganization.addMsg( 67 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPERFILIMPOAFIP1`"}) );
      ReorgSubmitThreadPool.addBlock( "RIPerfilImpoAFIPAFIPTiposIVA" );
      ReorgSubmitThreadPool.addPrecedence( "RIPerfilImpoAFIPAFIPTiposIVA" ,  "CreatePerfilImpoAFIP" );
      ReorgSubmitThreadPool.addPrecedence( "RIPerfilImpoAFIPAFIPTiposIVA" ,  "CreateAFIPTiposIVA" );
      GXReorganization.addMsg( 68 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPERFILIMPOAFIPJURISDICCION1`"}) );
      ReorgSubmitThreadPool.addBlock( "RIPerfilImpoAFIPJurisdiccionPerfilImpoAFIP" );
      ReorgSubmitThreadPool.addPrecedence( "RIPerfilImpoAFIPJurisdiccionPerfilImpoAFIP" ,  "CreatePerfilImpoAFIPJurisdiccion" );
      ReorgSubmitThreadPool.addPrecedence( "RIPerfilImpoAFIPJurisdiccionPerfilImpoAFIP" ,  "CreatePerfilImpoAFIP" );
      GXReorganization.addMsg( 69 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IENTIDAD1`"}) );
      ReorgSubmitThreadPool.addBlock( "RIEntidadPCLPais" );
      ReorgSubmitThreadPool.addPrecedence( "RIEntidadPCLPais" ,  "CreateEntidad" );
      ReorgSubmitThreadPool.addPrecedence( "RIEntidadPCLPais" ,  "CreatePCLPais" );
      GXReorganization.addMsg( 70 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IENTIDADSERVICIO1`"}) );
      ReorgSubmitThreadPool.addBlock( "RIEntidadServicioEntidad" );
      ReorgSubmitThreadPool.addPrecedence( "RIEntidadServicioEntidad" ,  "CreateEntidadServicio" );
      ReorgSubmitThreadPool.addPrecedence( "RIEntidadServicioEntidad" ,  "CreateEntidad" );
      GXReorganization.addMsg( 71 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IADICIONALPTPOCO1`"}) );
      ReorgSubmitThreadPool.addBlock( "RIAdicionalPTpoCoPCLPais" );
      ReorgSubmitThreadPool.addPrecedence( "RIAdicionalPTpoCoPCLPais" ,  "CreateAdicionalPTpoCo" );
      ReorgSubmitThreadPool.addPrecedence( "RIAdicionalPTpoCoPCLPais" ,  "CreatePCLPais" );
      GXReorganization.addMsg( 72 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IADICIONALTPOCOA1`"}) );
      ReorgSubmitThreadPool.addBlock( "RIAdicionalTpoCoaPCLPais" );
      ReorgSubmitThreadPool.addPrecedence( "RIAdicionalTpoCoaPCLPais" ,  "CreateAdicionalTpoCoa" );
      ReorgSubmitThreadPool.addPrecedence( "RIAdicionalTpoCoaPCLPais" ,  "CreatePCLPais" );
      GXReorganization.addMsg( 73 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IADICIONALPTPOCOCATEGORIA2`"}) );
      ReorgSubmitThreadPool.addBlock( "RIAdicionalPtpocoCategoriaAdicionalPTpoCo" );
      ReorgSubmitThreadPool.addPrecedence( "RIAdicionalPtpocoCategoriaAdicionalPTpoCo" ,  "CreateAdicionalPtpocoCategoria" );
      ReorgSubmitThreadPool.addPrecedence( "RIAdicionalPtpocoCategoriaAdicionalPTpoCo" ,  "CreateAdicionalPTpoCo" );
      GXReorganization.addMsg( 74 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IADICIONALPTPOCOCATEGORIA1`"}) );
      ReorgSubmitThreadPool.addBlock( "RIAdicionalPtpocoCategoriaAdicionalTpoCoa" );
      ReorgSubmitThreadPool.addPrecedence( "RIAdicionalPtpocoCategoriaAdicionalTpoCoa" ,  "CreateAdicionalPtpocoCategoria" );
      ReorgSubmitThreadPool.addPrecedence( "RIAdicionalPtpocoCategoriaAdicionalTpoCoa" ,  "CreateAdicionalTpoCoa" );
      GXReorganization.addMsg( 75 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`ICLIENTESOLICITUDCODADICIONAL1`"}) );
      ReorgSubmitThreadPool.addBlock( "RIClienteSolicitudCodAdicionalClienteSolicitud" );
      ReorgSubmitThreadPool.addPrecedence( "RIClienteSolicitudCodAdicionalClienteSolicitud" ,  "CreateClienteSolicitudCodAdicional" );
      ReorgSubmitThreadPool.addPrecedence( "RIClienteSolicitudCodAdicionalClienteSolicitud" ,  "CreateClienteSolicitud" );
      GXReorganization.addMsg( 76 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`ICOMPORTAMIENTOROL1`"}) );
      ReorgSubmitThreadPool.addBlock( "RIComportamientoRolPCLPais" );
      ReorgSubmitThreadPool.addPrecedence( "RIComportamientoRolPCLPais" ,  "CreateComportamientoRol" );
      ReorgSubmitThreadPool.addPrecedence( "RIComportamientoRolPCLPais" ,  "CreatePCLPais" );
      GXReorganization.addMsg( 77 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`GX_003H0001`"}) );
      ReorgSubmitThreadPool.addBlock( "RIPerfilImpositivoConfigPCLPais" );
      ReorgSubmitThreadPool.addPrecedence( "RIPerfilImpositivoConfigPCLPais" ,  "CreatePerfilImpositivoConfig" );
      ReorgSubmitThreadPool.addPrecedence( "RIPerfilImpositivoConfigPCLPais" ,  "CreatePCLPais" );
      GXReorganization.addMsg( 78 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPERFILIMPOSITIVOCONFIGURACIO1`"}) );
      ReorgSubmitThreadPool.addBlock( "RIPerfilImpositivoConfigAFIPTiposIVA" );
      ReorgSubmitThreadPool.addPrecedence( "RIPerfilImpositivoConfigAFIPTiposIVA" ,  "CreatePerfilImpositivoConfig" );
      ReorgSubmitThreadPool.addPrecedence( "RIPerfilImpositivoConfigAFIPTiposIVA" ,  "CreateAFIPTiposIVA" );
      GXReorganization.addMsg( 79 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPERFILIMPOSITIVOCONFIGURACIO7`"}) );
      ReorgSubmitThreadPool.addBlock( "RIPerfilImpositivoConfigJurisdicPerfilImpositivoConfig" );
      ReorgSubmitThreadPool.addPrecedence( "RIPerfilImpositivoConfigJurisdicPerfilImpositivoConfig" ,  "CreatePerfilImpositivoConfigJurisdic" );
      ReorgSubmitThreadPool.addPrecedence( "RIPerfilImpositivoConfigJurisdicPerfilImpositivoConfig" ,  "CreatePerfilImpositivoConfig" );
   }

   private void executeReorganization( )
   {
      if ( ErrCode == 0 )
      {
         tablesCount( ) ;
         if ( ! GXReorganization.getRecordCount( ) )
         {
            FirstActions( ) ;
            setPrecedence( ) ;
            executeTablesReorganization( ) ;
         }
      }
   }

   public synchronized void DropTableConstraints( String sTableName ,
                                                  String sMySchemaName ) throws SQLException
   {
      String cmdBuffer ;
      /* Using cursor P00023 */
      pr_default.execute(1, new Object[] {sTableName, sMySchemaName});
      while ( (pr_default.getStatus(1) != 101) )
      {
         tablename = P00023_Atablename[0] ;
         ntablename = P00023_ntablename[0] ;
         referencedtablename = P00023_Areferencedtablename[0] ;
         nreferencedtablename = P00023_nreferencedtablename[0] ;
         constid = P00023_Aconstid[0] ;
         nconstid = P00023_nconstid[0] ;
         schemaname = P00023_Aschemaname[0] ;
         nschemaname = P00023_nschemaname[0] ;
         cmdBuffer = "ALTER TABLE " + "" + tablename + "" + " DROP FOREIGN KEY " + "" + constid + "" ;
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         pr_default.readNext(1);
      }
      pr_default.close(1);
   }

   public void UtilsCleanup( )
   {
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void submitReorg( int submitId ,
                            Object [] submitParms ) throws SQLException
   {
      UserInformation submitUI = Application.getConnectionManager().createUserInformation(Namespace.getNamespace(context.getNAME_SPACE()));
      switch ( submitId )
      {
            case 1 :
               GXReorganization.replaceMsg( 1 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PerfilImpositivoConfigJurisdic",""})+" STARTED" );
               CreatePerfilImpositivoConfigJurisdic( ) ;
               GXReorganization.replaceMsg( 1 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PerfilImpositivoConfigJurisdic",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 2 :
               GXReorganization.replaceMsg( 2 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PerfilImpositivoConfig",""})+" STARTED" );
               CreatePerfilImpositivoConfig( ) ;
               GXReorganization.replaceMsg( 2 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PerfilImpositivoConfig",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 3 :
               GXReorganization.replaceMsg( 3 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"ComportamientoRol",""})+" STARTED" );
               CreateComportamientoRol( ) ;
               GXReorganization.replaceMsg( 3 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"ComportamientoRol",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 4 :
               GXReorganization.replaceMsg( 4 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"ServicioSolicitud",""})+" STARTED" );
               CreateServicioSolicitud( ) ;
               GXReorganization.replaceMsg( 4 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"ServicioSolicitud",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 5 :
               GXReorganization.replaceMsg( 5 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"ClienteSolicitudCodAdicional",""})+" STARTED" );
               CreateClienteSolicitudCodAdicional( ) ;
               GXReorganization.replaceMsg( 5 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"ClienteSolicitudCodAdicional",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 6 :
               GXReorganization.replaceMsg( 6 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"AdicionalPtpocoCategoria",""})+" STARTED" );
               CreateAdicionalPtpocoCategoria( ) ;
               GXReorganization.replaceMsg( 6 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"AdicionalPtpocoCategoria",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 7 :
               GXReorganization.replaceMsg( 7 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"AdicionalTpoCoa",""})+" STARTED" );
               CreateAdicionalTpoCoa( ) ;
               GXReorganization.replaceMsg( 7 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"AdicionalTpoCoa",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 8 :
               GXReorganization.replaceMsg( 8 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"AdicionalPTpoCo",""})+" STARTED" );
               CreateAdicionalPTpoCo( ) ;
               GXReorganization.replaceMsg( 8 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"AdicionalPTpoCo",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 9 :
               GXReorganization.replaceMsg( 9 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"EntidadServicio",""})+" STARTED" );
               CreateEntidadServicio( ) ;
               GXReorganization.replaceMsg( 9 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"EntidadServicio",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 10 :
               GXReorganization.replaceMsg( 10 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"Entidad",""})+" STARTED" );
               CreateEntidad( ) ;
               GXReorganization.replaceMsg( 10 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"Entidad",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 11 :
               GXReorganization.replaceMsg( 11 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PerfilImpoAFIPJurisdiccion",""})+" STARTED" );
               CreatePerfilImpoAFIPJurisdiccion( ) ;
               GXReorganization.replaceMsg( 11 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PerfilImpoAFIPJurisdiccion",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 12 :
               GXReorganization.replaceMsg( 12 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PerfilImpoAFIP",""})+" STARTED" );
               CreatePerfilImpoAFIP( ) ;
               GXReorganization.replaceMsg( 12 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PerfilImpoAFIP",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 13 :
               GXReorganization.replaceMsg( 13 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"AFIPTiposIVA",""})+" STARTED" );
               CreateAFIPTiposIVA( ) ;
               GXReorganization.replaceMsg( 13 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"AFIPTiposIVA",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 14 :
               GXReorganization.replaceMsg( 14 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"ClienteBloqueadoTmp",""})+" STARTED" );
               CreateClienteBloqueadoTmp( ) ;
               GXReorganization.replaceMsg( 14 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"ClienteBloqueadoTmp",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 15 :
               GXReorganization.replaceMsg( 15 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"AlcoholLicenciaLocalidad",""})+" STARTED" );
               CreateAlcoholLicenciaLocalidad( ) ;
               GXReorganization.replaceMsg( 15 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"AlcoholLicenciaLocalidad",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 16 :
               GXReorganization.replaceMsg( 16 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"AlcoholLicenciaDepartamento",""})+" STARTED" );
               CreateAlcoholLicenciaDepartamento( ) ;
               GXReorganization.replaceMsg( 16 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"AlcoholLicenciaDepartamento",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 17 :
               GXReorganization.replaceMsg( 17 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"AlcoholLicencia",""})+" STARTED" );
               CreateAlcoholLicencia( ) ;
               GXReorganization.replaceMsg( 17 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"AlcoholLicencia",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 18 :
               GXReorganization.replaceMsg( 18 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"LogProcesoActiva",""})+" STARTED" );
               CreateLogProcesoActiva( ) ;
               GXReorganization.replaceMsg( 18 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"LogProcesoActiva",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 19 :
               GXReorganization.replaceMsg( 19 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"ClienteSolicitudAdjunto",""})+" STARTED" );
               CreateClienteSolicitudAdjunto( ) ;
               GXReorganization.replaceMsg( 19 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"ClienteSolicitudAdjunto",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 20 :
               GXReorganization.replaceMsg( 20 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"ClienteAdjunto",""})+" STARTED" );
               CreateClienteAdjunto( ) ;
               GXReorganization.replaceMsg( 20 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"ClienteAdjunto",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 21 :
               GXReorganization.replaceMsg( 21 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"ProcesoPaso",""})+" STARTED" );
               CreateProcesoPaso( ) ;
               GXReorganization.replaceMsg( 21 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"ProcesoPaso",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 22 :
               GXReorganization.replaceMsg( 22 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"Proceso",""})+" STARTED" );
               CreateProceso( ) ;
               GXReorganization.replaceMsg( 22 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"Proceso",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 23 :
               GXReorganization.replaceMsg( 23 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"LogProceso",""})+" STARTED" );
               CreateLogProceso( ) ;
               GXReorganization.replaceMsg( 23 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"LogProceso",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 24 :
               GXReorganization.replaceMsg( 24 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"Equivalencia",""})+" STARTED" );
               CreateEquivalencia( ) ;
               GXReorganization.replaceMsg( 24 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"Equivalencia",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 25 :
               GXReorganization.replaceMsg( 25 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"SubRegionAlcohol",""})+" STARTED" );
               CreateSubRegionAlcohol( ) ;
               GXReorganization.replaceMsg( 25 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"SubRegionAlcohol",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 26 :
               GXReorganization.replaceMsg( 26 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"ClienteSolicitudTerrDiaVisita",""})+" STARTED" );
               CreateClienteSolicitudTerrDiaVisita( ) ;
               GXReorganization.replaceMsg( 26 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"ClienteSolicitudTerrDiaVisita",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 27 :
               GXReorganization.replaceMsg( 27 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"ClienteSolicitudTerr",""})+" STARTED" );
               CreateClienteSolicitudTerr( ) ;
               GXReorganization.replaceMsg( 27 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"ClienteSolicitudTerr",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 28 :
               GXReorganization.replaceMsg( 28 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"ClienteSolicitud",""})+" STARTED" );
               CreateClienteSolicitud( ) ;
               GXReorganization.replaceMsg( 28 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"ClienteSolicitud",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 29 :
               GXReorganization.replaceMsg( 29 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"DepartamentoLocalidad",""})+" STARTED" );
               CreateDepartamentoLocalidad( ) ;
               GXReorganization.replaceMsg( 29 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"DepartamentoLocalidad",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 30 :
               GXReorganization.replaceMsg( 30 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"Departamento",""})+" STARTED" );
               CreateDepartamento( ) ;
               GXReorganization.replaceMsg( 30 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"Departamento",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 31 :
               GXReorganization.replaceMsg( 31 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"Auditoria",""})+" STARTED" );
               CreateAuditoria( ) ;
               GXReorganization.replaceMsg( 31 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"Auditoria",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 32 :
               GXReorganization.replaceMsg( 32 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"UserRegion",""})+" STARTED" );
               CreateUserRegion( ) ;
               GXReorganization.replaceMsg( 32 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"UserRegion",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 33 :
               GXReorganization.replaceMsg( 33 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PCLLocDist",""})+" STARTED" );
               CreatePCLLocDist( ) ;
               GXReorganization.replaceMsg( 33 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PCLLocDist",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 34 :
               GXReorganization.replaceMsg( 34 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"Parametros",""})+" STARTED" );
               CreateParametros( ) ;
               GXReorganization.replaceMsg( 34 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"Parametros",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 35 :
               GXReorganization.replaceMsg( 35 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"BandejaAutorizacion",""})+" STARTED" );
               CreateBandejaAutorizacion( ) ;
               GXReorganization.replaceMsg( 35 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"BandejaAutorizacion",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 36 :
               GXReorganization.replaceMsg( 36 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"CodigosAdicionales",""})+" STARTED" );
               CreateCodigosAdicionales( ) ;
               GXReorganization.replaceMsg( 36 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"CodigosAdicionales",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 37 :
               GXReorganization.replaceMsg( 37 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PCLMaTeZo",""})+" STARTED" );
               CreatePCLMaTeZo( ) ;
               GXReorganization.replaceMsg( 37 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PCLMaTeZo",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 38 :
               GXReorganization.replaceMsg( 38 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PCLZonVis",""})+" STARTED" );
               CreatePCLZonVis( ) ;
               GXReorganization.replaceMsg( 38 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PCLZonVis",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 39 :
               GXReorganization.replaceMsg( 39 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PCLZonEnt",""})+" STARTED" );
               CreatePCLZonEnt( ) ;
               GXReorganization.replaceMsg( 39 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PCLZonEnt",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 40 :
               GXReorganization.replaceMsg( 40 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PCLCodAte",""})+" STARTED" );
               CreatePCLCodAte( ) ;
               GXReorganization.replaceMsg( 40 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PCLCodAte",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 41 :
               GXReorganization.replaceMsg( 41 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PCLValDef",""})+" STARTED" );
               CreatePCLValDef( ) ;
               GXReorganization.replaceMsg( 41 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PCLValDef",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 42 :
               GXReorganization.replaceMsg( 42 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PCLTipoVta",""})+" STARTED" );
               CreatePCLTipoVta( ) ;
               GXReorganization.replaceMsg( 42 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PCLTipoVta",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 43 :
               GXReorganization.replaceMsg( 43 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PCLPais",""})+" STARTED" );
               CreatePCLPais( ) ;
               GXReorganization.replaceMsg( 43 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"PCLPais",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 44 :
               GXReorganization.replaceMsg( 44 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPCLTIPOVTA01`"})+" STARTED" );
               RIPCLTipoVtaPCLPais( ) ;
               GXReorganization.replaceMsg( 44 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPCLTIPOVTA01`"})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 45 :
               GXReorganization.replaceMsg( 45 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPCLVALDEF01`"})+" STARTED" );
               RIPCLValDefPCLPais( ) ;
               GXReorganization.replaceMsg( 45 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPCLVALDEF01`"})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 46 :
               GXReorganization.replaceMsg( 46 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPCLCODATE01`"})+" STARTED" );
               RIPCLCodAtePCLPais( ) ;
               GXReorganization.replaceMsg( 46 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPCLCODATE01`"})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 47 :
               GXReorganization.replaceMsg( 47 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPCLZONENT01`"})+" STARTED" );
               RIPCLZonEntPCLPais( ) ;
               GXReorganization.replaceMsg( 47 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPCLZONENT01`"})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 48 :
               GXReorganization.replaceMsg( 48 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IZONASVISITA1`"})+" STARTED" );
               RIPCLZonVisPCLPais( ) ;
               GXReorganization.replaceMsg( 48 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IZONASVISITA1`"})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 49 :
               GXReorganization.replaceMsg( 49 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPCLMATEZO01`"})+" STARTED" );
               RIPCLMaTeZoPCLPais( ) ;
               GXReorganization.replaceMsg( 49 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPCLMATEZO01`"})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 50 :
               GXReorganization.replaceMsg( 50 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPARAMETROS4`"})+" STARTED" );
               RIParametrosPCLPais( ) ;
               GXReorganization.replaceMsg( 50 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPARAMETROS4`"})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 51 :
               GXReorganization.replaceMsg( 51 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`ILOCALIDADESDISTRIBUIDORES1`"})+" STARTED" );
               RIPCLLocDistPCLPais( ) ;
               GXReorganization.replaceMsg( 51 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`ILOCALIDADESDISTRIBUIDORES1`"})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 52 :
               GXReorganization.replaceMsg( 52 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IDEPARTAMENTO2`"})+" STARTED" );
               RIDepartamentoPCLPais( ) ;
               GXReorganization.replaceMsg( 52 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IDEPARTAMENTO2`"})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 53 :
               GXReorganization.replaceMsg( 53 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IDEPARTAMENTOLOCALIDAD2`"})+" STARTED" );
               RIDepartamentoLocalidadDepartamento( ) ;
               GXReorganization.replaceMsg( 53 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IDEPARTAMENTOLOCALIDAD2`"})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 54 :
               GXReorganization.replaceMsg( 54 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`GX_002L0001`"})+" STARTED" );
               RIClienteSolicitudPCLPais( ) ;
               GXReorganization.replaceMsg( 54 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`GX_002L0001`"})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 55 :
               GXReorganization.replaceMsg( 55 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`ICLIENTESOLICITUD3`"})+" STARTED" );
               RIClienteSolicitudPCLMaTeZo( ) ;
               GXReorganization.replaceMsg( 55 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`ICLIENTESOLICITUD3`"})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 56 :
               GXReorganization.replaceMsg( 56 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`ICLIENTESOLICITUD2`"})+" STARTED" );
               RIClienteSolicitudPCLZonEnt( ) ;
               GXReorganization.replaceMsg( 56 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`ICLIENTESOLICITUD2`"})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 57 :
               GXReorganization.replaceMsg( 57 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`ICLIENTESOLICITUDTERR1`"})+" STARTED" );
               RIClienteSolicitudTerrClienteSolicitud( ) ;
               GXReorganization.replaceMsg( 57 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`ICLIENTESOLICITUDTERR1`"})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 58 :
               GXReorganization.replaceMsg( 58 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`ICLIENTESOLICITUDTERRDIAVISIT1`"})+" STARTED" );
               RIClienteSolicitudTerrDiaVisitaClienteSolicitudTerr( ) ;
               GXReorganization.replaceMsg( 58 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`ICLIENTESOLICITUDTERRDIAVISIT1`"})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 59 :
               GXReorganization.replaceMsg( 59 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPROCESOPASO1`"})+" STARTED" );
               RIProcesoPasoProceso( ) ;
               GXReorganization.replaceMsg( 59 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPROCESOPASO1`"})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 60 :
               GXReorganization.replaceMsg( 60 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`ICLIENTESOLICITUDADJUNTO1`"})+" STARTED" );
               RIClienteSolicitudAdjuntoClienteSolicitud( ) ;
               GXReorganization.replaceMsg( 60 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`ICLIENTESOLICITUDADJUNTO1`"})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 61 :
               GXReorganization.replaceMsg( 61 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IALCOHOLLICENCIA`"})+" STARTED" );
               RIAlcoholLicenciaPCLPais( ) ;
               GXReorganization.replaceMsg( 61 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IALCOHOLLICENCIA`"})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 62 :
               GXReorganization.replaceMsg( 62 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IALCOHOLLICENCIADEPARTAMENTO1`"})+" STARTED" );
               RIAlcoholLicenciaDepartamentoAlcoholLicencia( ) ;
               GXReorganization.replaceMsg( 62 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IALCOHOLLICENCIADEPARTAMENTO1`"})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 63 :
               GXReorganization.replaceMsg( 63 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IALCOHOLLICENCIADEPARTAMENTO`"})+" STARTED" );
               RIAlcoholLicenciaDepartamentoDepartamento( ) ;
               GXReorganization.replaceMsg( 63 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IALCOHOLLICENCIADEPARTAMENTO`"})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 64 :
               GXReorganization.replaceMsg( 64 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IALCOHOLLICENCIALOCALIDAD1`"})+" STARTED" );
               RIAlcoholLicenciaLocalidadAlcoholLicenciaDepartamento( ) ;
               GXReorganization.replaceMsg( 64 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IALCOHOLLICENCIALOCALIDAD1`"})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 65 :
               GXReorganization.replaceMsg( 65 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IALCOHOLLICENCIALOCALIDAD`"})+" STARTED" );
               RIAlcoholLicenciaLocalidadDepartamentoLocalidad( ) ;
               GXReorganization.replaceMsg( 65 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IALCOHOLLICENCIALOCALIDAD`"})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 66 :
               GXReorganization.replaceMsg( 66 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IAFIPTIPOSIVA1`"})+" STARTED" );
               RIAFIPTiposIVAPCLPais( ) ;
               GXReorganization.replaceMsg( 66 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IAFIPTIPOSIVA1`"})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 67 :
               GXReorganization.replaceMsg( 67 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPERFILIMPOAFIP1`"})+" STARTED" );
               RIPerfilImpoAFIPAFIPTiposIVA( ) ;
               GXReorganization.replaceMsg( 67 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPERFILIMPOAFIP1`"})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 68 :
               GXReorganization.replaceMsg( 68 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPERFILIMPOAFIPJURISDICCION1`"})+" STARTED" );
               RIPerfilImpoAFIPJurisdiccionPerfilImpoAFIP( ) ;
               GXReorganization.replaceMsg( 68 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPERFILIMPOAFIPJURISDICCION1`"})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 69 :
               GXReorganization.replaceMsg( 69 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IENTIDAD1`"})+" STARTED" );
               RIEntidadPCLPais( ) ;
               GXReorganization.replaceMsg( 69 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IENTIDAD1`"})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 70 :
               GXReorganization.replaceMsg( 70 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IENTIDADSERVICIO1`"})+" STARTED" );
               RIEntidadServicioEntidad( ) ;
               GXReorganization.replaceMsg( 70 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IENTIDADSERVICIO1`"})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 71 :
               GXReorganization.replaceMsg( 71 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IADICIONALPTPOCO1`"})+" STARTED" );
               RIAdicionalPTpoCoPCLPais( ) ;
               GXReorganization.replaceMsg( 71 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IADICIONALPTPOCO1`"})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 72 :
               GXReorganization.replaceMsg( 72 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IADICIONALTPOCOA1`"})+" STARTED" );
               RIAdicionalTpoCoaPCLPais( ) ;
               GXReorganization.replaceMsg( 72 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IADICIONALTPOCOA1`"})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 73 :
               GXReorganization.replaceMsg( 73 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IADICIONALPTPOCOCATEGORIA2`"})+" STARTED" );
               RIAdicionalPtpocoCategoriaAdicionalPTpoCo( ) ;
               GXReorganization.replaceMsg( 73 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IADICIONALPTPOCOCATEGORIA2`"})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 74 :
               GXReorganization.replaceMsg( 74 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IADICIONALPTPOCOCATEGORIA1`"})+" STARTED" );
               RIAdicionalPtpocoCategoriaAdicionalTpoCoa( ) ;
               GXReorganization.replaceMsg( 74 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IADICIONALPTPOCOCATEGORIA1`"})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 75 :
               GXReorganization.replaceMsg( 75 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`ICLIENTESOLICITUDCODADICIONAL1`"})+" STARTED" );
               RIClienteSolicitudCodAdicionalClienteSolicitud( ) ;
               GXReorganization.replaceMsg( 75 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`ICLIENTESOLICITUDCODADICIONAL1`"})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 76 :
               GXReorganization.replaceMsg( 76 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`ICOMPORTAMIENTOROL1`"})+" STARTED" );
               RIComportamientoRolPCLPais( ) ;
               GXReorganization.replaceMsg( 76 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`ICOMPORTAMIENTOROL1`"})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 77 :
               GXReorganization.replaceMsg( 77 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`GX_003H0001`"})+" STARTED" );
               RIPerfilImpositivoConfigPCLPais( ) ;
               GXReorganization.replaceMsg( 77 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`GX_003H0001`"})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 78 :
               GXReorganization.replaceMsg( 78 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPERFILIMPOSITIVOCONFIGURACIO1`"})+" STARTED" );
               RIPerfilImpositivoConfigAFIPTiposIVA( ) ;
               GXReorganization.replaceMsg( 78 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPERFILIMPOSITIVOCONFIGURACIO1`"})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 79 :
               GXReorganization.replaceMsg( 79 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPERFILIMPOSITIVOCONFIGURACIO7`"})+" STARTED" );
               RIPerfilImpositivoConfigJurisdicPerfilImpositivoConfig( ) ;
               GXReorganization.replaceMsg( 79 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"`IPERFILIMPOSITIVOCONFIGURACIO7`"})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
      }
   }

   public void initialize( )
   {
      ErrMsg = "" ;
      DataBaseName = "" ;
      DBURLName = "" ;
      sSchemaVar = "" ;
      sTableName = "" ;
      sMySchemaName = "" ;
      tablename = "" ;
      ntablename = false ;
      schemaname = "" ;
      nschemaname = false ;
      scmdbuf = "" ;
      P00012_Atablename = new String[] {""} ;
      P00012_ntablename = new boolean[] {false} ;
      P00012_Aschemaname = new String[] {""} ;
      P00012_nschemaname = new boolean[] {false} ;
      referencedtablename = "" ;
      nreferencedtablename = false ;
      constid = "" ;
      nconstid = false ;
      P00023_Atablename = new String[] {""} ;
      P00023_ntablename = new boolean[] {false} ;
      P00023_Areferencedtablename = new String[] {""} ;
      P00023_nreferencedtablename = new boolean[] {false} ;
      P00023_Aconstid = new String[] {""} ;
      P00023_nconstid = new boolean[] {false} ;
      P00023_Aschemaname = new String[] {""} ;
      P00023_nschemaname = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.quilmesportal.reorg__default(),
         new Object[] {
             new Object[] {
            P00012_Atablename, P00012_Aschemaname
            }
            , new Object[] {
            P00023_Atablename, P00023_Areferencedtablename, P00023_Aconstid, P00023_Aschemaname
            }
         }
      );
      /* GeneXus formulas. */
   }

   protected byte Count ;
   protected byte Res ;
   protected short ErrCode ;
   protected String ErrMsg ;
   protected String DataBaseName ;
   protected String DBURLName ;
   protected String cmdBuffer ;
   protected String sSchemaVar ;
   protected String sTableName ;
   protected String sMySchemaName ;
   protected String scmdbuf ;
   protected boolean ntablename ;
   protected boolean nschemaname ;
   protected boolean nreferencedtablename ;
   protected boolean nconstid ;
   protected String tablename ;
   protected String schemaname ;
   protected String referencedtablename ;
   protected String constid ;
   protected com.genexus.db.DBConnection DS ;
   protected IDataStoreProvider pr_default ;
   protected String[] P00012_Atablename ;
   protected boolean[] P00012_ntablename ;
   protected String[] P00012_Aschemaname ;
   protected boolean[] P00012_nschemaname ;
   protected String[] P00023_Atablename ;
   protected boolean[] P00023_ntablename ;
   protected String[] P00023_Areferencedtablename ;
   protected boolean[] P00023_nreferencedtablename ;
   protected String[] P00023_Aconstid ;
   protected boolean[] P00023_nconstid ;
   protected String[] P00023_Aschemaname ;
   protected boolean[] P00023_nschemaname ;
}

final  class reorg__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00012", "SELECT table_name, table_schema FROM INFORMATION_SCHEMA.TABLES WHERE (table_name = ?) AND (table_schema = ?) ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100,0,false )
         ,new ForEachCursor("P00023", "SELECT DISTINCT TABLE_NAME, REFERENCED_TABLE_NAME, CONSTRAINT_NAME, TABLE_SCHEMA FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE WHERE (REFERENCED_TABLE_NAME = ?) AND (TABLE_SCHEMA = ?) ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100,0,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1) ;
               ((String[]) buf[1])[0] = rslt.getVarchar(2) ;
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1) ;
               ((String[]) buf[1])[0] = rslt.getVarchar(2) ;
               ((String[]) buf[2])[0] = rslt.getVarchar(3) ;
               ((String[]) buf[3])[0] = rslt.getVarchar(4) ;
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setString(1, (String)parms[0], 255);
               stmt.setString(2, (String)parms[1], 255);
               return;
            case 1 :
               stmt.setString(1, (String)parms[0], 255);
               stmt.setString(2, (String)parms[1], 255);
               return;
      }
   }

}

