/*
               File: Reorganization
        Description: No description for object
             Author: GeneXus Java Generator version 15_0_12-126726
       Generated on: September 23, 2020 13:37:31.66
       Program type: Callable routine
          Main DBMS: MySQL
*/
package com.quilmesportal ;
import com.quilmesportal.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.search.*;
import java.sql.*;

public final  class Reorganization extends GXReorganization
{
   ModelContext context;
   public static void main( String args[] )
   {
      new Reorganization().executeReorg(args, true);
   }

   public Reorganization( )
   {
      super(GXcfg.class);
   }

   public String getPackageDir( )
   {
      return "com\\quilmesportal\\" ;
   }

   public void init( )
   {
      Application.setApplet( this);
   }

   public void execute( )
   {
      context = new ModelContext(getClass());
      reorg r = new reorg(getHandle());
      setReorgProcedure(r);
      r.execute();
   }

}

