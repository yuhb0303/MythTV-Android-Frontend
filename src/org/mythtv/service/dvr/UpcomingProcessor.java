/**
 * 
 */
package org.mythtv.service.dvr;

import org.mythtv.db.dvr.ProgramConstants;
import org.mythtv.services.api.dvr.Program;
import org.mythtv.services.api.dvr.Programs;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

/**
 * @author Daniel Frey
 *
 */
public class UpcomingProcessor extends ProgramProcessor {

	protected static final String TAG = UpcomingProcessor.class.getSimpleName();

	public UpcomingProcessor( Context context ) {
		super( context );
		Log.v( TAG, "initialize : enter" );

		Log.v( TAG, "initialize : exit" );
	}

	public int processPrograms( Programs programs ) {
		Log.v( TAG, "processPrograms : enter" );

		int result = 0;
		
		if( null != programs ) {
			
			// add delete here
			int deleted = mContext.getContentResolver().delete( ProgramConstants.CONTENT_URI_UPCOMING, null, null );
			Log.v( TAG, "processPrograms : programs deleted=" + deleted );
			
			ContentValues[] contentValuesArray = convertProgramsToContentValuesArray( programs );
			result = mContext.getContentResolver().bulkInsert( ProgramConstants.CONTENT_URI_UPCOMING, contentValuesArray );
			Log.v( TAG, "processPrograms : programs added=" + result );
			
//			Cursor cursor = mContext.getContentResolver().query( ProgramConstants.CONTENT_URI_UPCOMING, null, null, null, ProgramConstants.FIELD_START_TIME );
//			while( cursor.moveToNext() ) {
//				long lStartTime = cursor.getLong( cursor.getColumnIndex( ProgramConstants.FIELD_START_TIME ) );
//				int iDuration = cursor.getInt( cursor.getColumnIndex( ProgramConstants.FIELD_DURATION ) );
//				String sTitle = cursor.getString( cursor.getColumnIndex( ProgramConstants.FIELD_TITLE ) );
//				String sStartDate = cursor.getString( cursor.getColumnIndex( ProgramConstants.FIELD_START_DATE ) );
//				String sSubTitle = cursor.getString( cursor.getColumnIndex( ProgramConstants.FIELD_SUB_TITLE ) );
//				String sCategory = cursor.getString( cursor.getColumnIndex( ProgramConstants.FIELD_CATEGORY ) );
//				String sChannelNumber = cursor.getString( cursor.getColumnIndex( ProgramConstants.FIELD_CHANNEL_NUMBER ) );
//				
//				Log.v( TAG, "processPrograms : Title=" + sTitle + ", channel=" + sChannelNumber + ", startDate=" + sStartDate + ", startTime=" + DateUtils.dateTimeFormatter.print( new DateTime( lStartTime ) ) );
//			}
			
		}
		
		Log.v( TAG, "processPrograms : exit" );
		return result;
	}
	
	// internal helpers
	
	private ContentValues[] convertProgramsToContentValuesArray( final Programs programs ) {
		
		if( null != programs ) {
			
			int i = 0;
			ContentValues contentValues;
			ContentValues[] contentValuesArray = new ContentValues[ programs.getPrograms().size() ];
			for( Program program : programs.getPrograms() ) {
				
				contentValues = convertProgramToContentValues( program );
				contentValuesArray[ i ] = contentValues;
				
				i++;
			}
			
			return contentValuesArray;
		}
		
		return null;
	}
	
}