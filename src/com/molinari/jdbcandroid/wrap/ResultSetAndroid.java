package com.molinari.jdbcandroid.wrap;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;

public class ResultSetAndroid implements ResultSet {

	Cursor cursor = null;
	public ResultSetAndroid(final Cursor query) {
		cursor = query;
	}

	public Cursor getCursor() {
		return cursor;
	}

	public void setCursor(final SQLiteCursor cursor) {
		this.cursor = cursor;
	}

	@Override
	public boolean absolute(final int arg0) throws SQLException {
		return cursor.move(arg0);
	}

	@Override
	public void afterLast() throws SQLException {
		if (cursor != null) {
			cursor.moveToLast();
			cursor.moveToNext();
		}
	}

	@Override
	public void beforeFirst() throws SQLException {
		if (cursor != null) {
			cursor.moveToFirst();
			cursor.moveToPrevious();
		}
	}

	@Override
	public void cancelRowUpdates() throws SQLException {
		System.out.println("Non implementato");
	}

	@Override
	public void clearWarnings() throws SQLException {
		System.out.println("Non implementato");
	}

	@Override
	public void deleteRow() throws SQLException {
		System.out.println("Non implementato");
	}

	@Override
	public int findColumn(final String columnName) throws SQLException {
		return cursor.getColumnIndex(columnName);

	}

	@Override
	public boolean first() throws SQLException {
		return cursor.moveToFirst();
	}

	@Override
	public Array getArray(final int columnIndex) throws SQLException {
		System.out.println("Non implementato");
		return null;
	}

	@Override
	public Array getArray(final String colName) throws SQLException {
		System.out.println("Non implementato");
		return null;
	}

	@Override
	public InputStream getAsciiStream(final int columnIndex) throws SQLException {
		System.out.println("Non implementato");
		return null;
	}

	@Override
	public InputStream getAsciiStream(final String columnName) throws SQLException {
		System.out.println("Non implementato");
		return null;
	}

	@Override
	public BigDecimal getBigDecimal(final int columnIndex) throws SQLException {
		System.out.println("Non implementato");
		return null;
	}

	@Override
	public BigDecimal getBigDecimal(final String columnName) throws SQLException {
		System.out.println("Non implementato");
		return null;
	}

	@Override
	public BigDecimal getBigDecimal(final int columnIndex, final int scale) throws SQLException {
		System.out.println("Non implementato");
		return null;
	}

	@Override
	public BigDecimal getBigDecimal(final String columnName, final int scale) throws SQLException {
		System.out.println("Non implementato");
		return null;
	}

	@Override
	public InputStream getBinaryStream(final int columnIndex) throws SQLException {
		System.out.println("Non implementato");
		return null;
	}

	@Override
	public InputStream getBinaryStream(final String columnName) throws SQLException {
		System.out.println("Non implementato");
		return null;
	}

	@Override
	public Blob getBlob(final String columnName) throws SQLException {
		final int index = cursor.getColumnIndex(columnName);
		return new BlobAndroid(cursor.getBlob(index));
	}

	@Override
	public boolean getBoolean(int columnIndex) throws SQLException {
		if (columnIndex > 0) {
			columnIndex--;
		}
		return cursor.getInt(columnIndex) != 0;
	}

	@Override
	public boolean getBoolean(final String columnName) throws SQLException {
		final int index = cursor.getColumnIndex(columnName);
		return cursor.getInt(index) != 0;
	}

	@Override
	public byte getByte(final int columnIndex) throws SQLException {
		System.out.println("Non implementato");
		return 0;

	}

	@Override
	public byte getByte(final String columnName) throws SQLException {
		System.out.println("Non implementato");
		return 0;
	}

	@Override
	public byte[] getBytes(final int columnIndex) throws SQLException {
		System.out.println("Non implementato");
		return null;
	}

	@Override
	public byte[] getBytes(final String columnName) throws SQLException {
		System.out.println("Non implementato");
		return null;
	}

	@Override
	public Reader getCharacterStream(final int columnIndex) throws SQLException {
		System.out.println("Non implementato");
		return null;
	}

	@Override
	public Reader getCharacterStream(final String columnName) throws SQLException {
		System.out.println("Non implementato");
		return null;
	}

	@Override
	public Clob getClob(final int columnIndex) throws SQLException {
		System.out.println("Non implementato");
		return null;
	}

	@Override
	public Clob getClob(final String colName) throws SQLException {
		System.out.println("Non implementato");
		return null;
	}

	@Override
	public int getConcurrency() throws SQLException {
		System.out.println("Non implementato");
		return 0;
	}

	@Override
	public String getCursorName() throws SQLException {
		System.out.println("Non implementato");
		return null;
	}

	@Override
	public Date getDate(final int columnIndex) throws SQLException {
		System.out.println("Non implementato");
		return null;
	}

	@Override
	public Date getDate(final String columnName) throws SQLException {
		System.out.println("Non implementato");
		return null;
	}

	@Override
	public Date getDate(final int columnIndex, final Calendar cal) throws SQLException {
		System.out.println("Non implementato");
		return null;
	}

	@Override
	public Date getDate(final String columnName, final Calendar cal) throws SQLException {
		System.out.println("Non implementato");
		return null;
	}

	@Override
	public double getDouble(final String columnName) throws SQLException {
		return cursor.getDouble(findColumn(columnName));
	}

	@Override
	public int getFetchDirection() throws SQLException {
		return ResultSet.FETCH_FORWARD;
	}

	@Override
	public int getFetchSize() throws SQLException {
		return cursor.getCount();
	}

	@Override
	public float getFloat(final String columnName) throws SQLException {
		return cursor.getFloat(findColumn(columnName));
	}

	@Override
	public int getInt(final String columnName) throws SQLException {
		return cursor.getInt(findColumn(columnName));
	}

	@Override
	public long getLong(final String columnName) throws SQLException {
		return cursor.getLong(findColumn(columnName));
	}

	@Override
	public ResultSetMetaData getMetaData() throws SQLException {
		System.out.println("Non implementato");
		return null;
	}

	@Override
	public Object getObject(final int columnIndex) throws SQLException {
		System.out.println("Non implementato");
		return null;
	}

	@Override
	public Object getObject(final String columnName) throws SQLException {
		System.out.println("Non implementato");
		return null;
	}

	@Override
	public Object getObject(final int arg0, final Map<String, Class<?>> arg1) throws SQLException {
		System.out.println("Non implementato");
		return null;
	}

	@Override
	public Object getObject(final String arg0, final Map<String, Class<?>> arg1) throws SQLException {
		System.out.println("Non implementato");
		return null;
	}

	@Override
	public Ref getRef(final int columnIndex) throws SQLException {
		System.out.println("Non implementato");
		return null;
	}

	@Override
	public Ref getRef(final String colName) throws SQLException {
		System.out.println("Non implementato");
		return null;
	}

	@Override
	public int getRow() throws SQLException {
		return cursor.getPosition();

	}

	@Override
	public short getShort(final String columnName) throws SQLException {
		return cursor.getShort(findColumn(columnName));
	}

	@Override
	public Statement getStatement() throws SQLException {
		// TODO da implementare?
		System.out.println("Non implementato");
		return null;
	}

	@Override
	public String getString(final String columnName) throws SQLException {
		return cursor.getString(findColumn(columnName));
	}

	@Override
	public Time getTime(final int columnIndex) throws SQLException {
		System.out.println("Non implementato");
		return null;
	}

	@Override
	public Time getTime(final String columnName) throws SQLException {
		System.out.println("Non implementato");
		return null;
	}

	@Override
	public Time getTime(final int columnIndex, final Calendar cal) throws SQLException {
		System.out.println("Non implementato");
		return null;
	}

	@Override
	public Time getTime(final String columnName, final Calendar cal) throws SQLException {
		System.out.println("Non implementato");
		return null;
	}

	@Override
	public Timestamp getTimestamp(final int columnIndex) throws SQLException {
		System.out.println("Non implementato");
		return null;
	}

	@Override
	public Timestamp getTimestamp(final String columnName) throws SQLException {
		System.out.println("Non implementato");
		return null;
	}

	@Override
	public Timestamp getTimestamp(final int columnIndex, final Calendar cal) throws SQLException {
		System.out.println("Non implementato");
		return null;
	}

	@Override
	public Timestamp getTimestamp(final String columnName, final Calendar cal) throws SQLException {
		System.out.println("Non implementato");
		return null;
	}

	@Override
	public int getType() throws SQLException {
		System.out.println("Non implementato");
		return 0;
	}

	@Override
	public URL getURL(final int columnIndex) throws SQLException {
		System.out.println("Non implementato");
		return null;
	}

	@Override
	public URL getURL(final String columnName) throws SQLException {
		System.out.println("Non implementato");
		return null;
	}

	@Override
	public InputStream getUnicodeStream(final int columnIndex) throws SQLException {
		System.out.println("Non implementato");
		return null;
	}

	@Override
	public InputStream getUnicodeStream(final String columnName) throws SQLException {
		System.out.println("Non implementato");
		return null;
	}

	@Override
	public SQLWarning getWarnings() throws SQLException {
		System.out.println("Non implementato");
		return null;
	}

	@Override
	public void insertRow() throws SQLException {
	}

	@Override
	public boolean last() throws SQLException {
		return cursor.moveToLast();
	}

	@Override
	public void moveToCurrentRow() throws SQLException {
		System.out.println("Non implementato");
	}

	@Override
	public void moveToInsertRow() throws SQLException {
		System.out.println("Non implementato");
	}

	@Override
	public boolean next() throws SQLException {

		return cursor.moveToNext();
	}

	@Override
	public boolean previous() throws SQLException {
		return cursor.moveToPrevious();
	}

	@Override
	public void refreshRow() throws SQLException {
		System.out.println("Non implementato");
	}

	@Override
	public boolean relative(final int rows) throws SQLException {
		return cursor.moveToPosition(rows);
	}

	@Override
	public boolean rowDeleted() throws SQLException {
		System.out.println("Non implementato");
		return false;
	}

	@Override
	public boolean rowInserted() throws SQLException {
		System.out.println("Non implementato");
		return false;
	}

	@Override
	public boolean rowUpdated() throws SQLException {
		System.out.println("Non implementato");
		return false;
	}

	@Override
	public void setFetchDirection(final int d) throws SQLException {
		if (d != ResultSet.FETCH_FORWARD) {
			throw new SQLException("only FETCH_FORWARD direction supported");
		}
	}

	@Override
	public void setFetchSize(final int rows) throws SQLException {
		System.out.println("Non implementato");
	}

	@Override
	public void updateArray(final int columnIndex, final Array x) throws SQLException {
		System.out.println("Non implementato");
	}

	@Override
	public void updateArray(final String columnName, final Array x) throws SQLException {
		System.out.println("Non implementato");
	}

	@Override
	public void updateAsciiStream(final int columnIndex, final InputStream x, final int length) throws SQLException {
		System.out.println("Non implementato");
	}

	@Override
	public void updateAsciiStream(final String columnName, final InputStream x, final int length) throws SQLException {
		System.out.println("Non implementato");
	}

	@Override
	public void updateBigDecimal(final int columnIndex, final BigDecimal x) throws SQLException {
		System.out.println("Non implementato");
	}

	@Override
	public void updateBigDecimal(final String columnName, final BigDecimal x) throws SQLException {
		System.out.println("Non implementato");
	}

	@Override
	public void updateBinaryStream(final int columnIndex, final InputStream x, final int length) throws SQLException {
		System.out.println("Non implementato");
	}

	@Override
	public void updateBinaryStream(final String columnName, final InputStream x, final int length) throws SQLException {
		System.out.println("Non implementato");
	}

	@Override
	public void updateBlob(final int columnIndex, final Blob x) throws SQLException {
		System.out.println("Non implementato");
	}

	@Override
	public void updateBlob(final String columnName, final Blob x) throws SQLException {
		System.out.println("Non implementato");
	}

	@Override
	public void updateBoolean(final int columnIndex, final boolean x) throws SQLException {
		System.out.println("Non implementato");
	}

	@Override
	public void updateBoolean(final String columnName, final boolean x) throws SQLException {
		System.out.println("Non implementato");
	}

	@Override
	public void updateByte(final int columnIndex, final byte x) throws SQLException {
		System.out.println("Non implementato");
	}

	@Override
	public void updateByte(final String columnName, final byte x) throws SQLException {
		System.out.println("Non implementato");
	}

	@Override
	public void updateBytes(final int columnIndex, final byte[] x) throws SQLException {
		System.out.println("Non implementato");
	}

	@Override
	public void updateBytes(final String columnName, final byte[] x) throws SQLException {
		System.out.println("Non implementato");
	}

	@Override
	public void updateCharacterStream(final int columnIndex, final Reader x, final int length) throws SQLException {
		System.out.println("Non implementato");
	}

	@Override
	public void updateCharacterStream(final String columnName, final Reader reader, final int length) throws SQLException {
		System.out.println("Non implementato");
	}

	@Override
	public void updateClob(final int columnIndex, final Clob x) throws SQLException {
		System.out.println("Non implementato");
	}

	@Override
	public void updateClob(final String columnName, final Clob x) throws SQLException {
		System.out.println("Non implementato");
	}

	@Override
	public void updateDate(final int columnIndex, final Date x) throws SQLException {
		System.out.println("Non implementato");
	}

	@Override
	public void updateDate(final String columnName, final Date x) throws SQLException {
		System.out.println("Non implementato");
	}

	@Override
	public void updateDouble(final int columnIndex, final double x) throws SQLException {
		System.out.println("Non implementato");

	}

	@Override
	public void updateDouble(final String columnName, final double x) throws SQLException {
		System.out.println("Non implementato");
	}

	@Override
	public void updateFloat(final int columnIndex, final float x) throws SQLException {
		System.out.println("Non implementato");
	}

	@Override
	public void updateFloat(final String columnName, final float x) throws SQLException {
		System.out.println("Non implementato");
	}

	@Override
	public void updateInt(final int columnIndex, final int x) throws SQLException {
		System.out.println("Non implementato");

	}

	@Override
	public void updateInt(final String columnName, final int x) throws SQLException {
		System.out.println("Non implementato");
	}

	@Override
	public void updateLong(final int columnIndex, final long x) throws SQLException {
		System.out.println("Non implementato");
	}

	@Override
	public void updateLong(final String columnName, final long x) throws SQLException {
		System.out.println("Non implementato");
	}

	@Override
	public void updateNull(final int columnIndex) throws SQLException {
		System.out.println("Non implementato");
	}

	@Override
	public void updateNull(final String columnName) throws SQLException {
		System.out.println("Non implementato");
	}

	@Override
	public void updateObject(final int columnIndex, final Object x) throws SQLException {
		System.out.println("Non implementato");
	}

	@Override
	public void updateObject(final String columnName, final Object x) throws SQLException {
		System.out.println("Non implementato");
	}

	@Override
	public void updateObject(final int columnIndex, final Object x, final int scale) throws SQLException {
		System.out.println("Non implementato");
	}

	@Override
	public void updateObject(final String columnName, final Object x, final int scale) throws SQLException {
		System.out.println("Non implementato");

	}

	@Override
	public void updateRef(final int columnIndex, final Ref x) throws SQLException {
		System.out.println("Non implementato");

	}

	@Override
	public void updateRef(final String columnName, final Ref x) throws SQLException {
		System.out.println("Non implementato");

	}

	@Override
	public void updateRow() throws SQLException {
		System.out.println("Non implementato");

	}

	@Override
	public void updateShort(final int columnIndex, final short x) throws SQLException {
		System.out.println("Non implementato");

	}

	@Override
	public void updateShort(final String columnName, final short x) throws SQLException {
		System.out.println("Non implementato");

	}

	@Override
	public void updateString(final int columnIndex, final String x) throws SQLException {
		System.out.println("Non implementato");

	}

	@Override
	public void updateString(final String columnName, final String x) throws SQLException {
		System.out.println("Non implementato");

	}

	@Override
	public void updateTime(final int columnIndex, final Time x) throws SQLException {
		System.out.println("Non implementato");

	}

	@Override
	public void updateTime(final String columnName, final Time x) throws SQLException {
		System.out.println("Non implementato");

	}

	@Override
	public void updateTimestamp(final int columnIndex, final Timestamp x) throws SQLException {
		System.out.println("Non implementato");

	}

	@Override
	public void updateTimestamp(final String columnName, final Timestamp x) throws SQLException {
		System.out.println("Non implementato");

	}

	@Override
	public boolean wasNull() throws SQLException {
		System.out.println("Non implementato");
		return false;
	}

	@Override
	public void close() throws SQLException {
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
	}

	@Override
	public double getDouble(int columnIndex) throws SQLException {
		if (columnIndex > 0) {
			columnIndex -= 1;
		}
		return cursor.getDouble(columnIndex);
	}

	@Override
	public float getFloat(int columnIndex) throws SQLException {
		if (columnIndex > 0) {
			columnIndex -= 1;
		}
		return cursor.getFloat(columnIndex);
	}

	@Override
	public int getInt(int columnIndex) throws SQLException {
		if (columnIndex > 0) {
			columnIndex -= 1;
		}
		return cursor.getInt(columnIndex);
	}

	@Override
	public long getLong(int columnIndex) throws SQLException {
		if (columnIndex > 0) {
			columnIndex -= 1;
		}
		return cursor.getLong(columnIndex);
	}

	@Override
	public short getShort(final int columnIndex) throws SQLException {
		System.out.println("Non implementato");
		return 0;
	}

	@Override
	public String getString(int columnIndex) throws SQLException {
		if (columnIndex > 0) {
			columnIndex -= 1;
		}
		return cursor.getString(columnIndex);
	}

	@Override
	public boolean isAfterLast() throws SQLException {
		System.out.println("Non implementato");
		return false;
	}

	@Override
	public boolean isBeforeFirst() throws SQLException {
		System.out.println("Non implementato");
		return false;
	}

	@Override
	public boolean isFirst() throws SQLException {
		return cursor.isFirst();
	}

	@Override
	public boolean isLast() throws SQLException {
		return cursor.isLast();
	}

	@Override
	public Blob getBlob(int columnIndex) throws SQLException {
		if (columnIndex > 0) {
			columnIndex -= 1;
		}
		final byte[] b = cursor.getBlob(columnIndex);
		return new BlobAndroid(b);
	}

	public boolean isWrapperFor(final Class<?> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public <T> T unwrap(final Class<T> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public int getHoldability() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public Reader getNCharacterStream(final int arg0) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Reader getNCharacterStream(final String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNString(final int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNString(final String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isClosed() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public void updateAsciiStream(final int columnIndex, final InputStream x) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateAsciiStream(final String columnLabel, final InputStream x) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateAsciiStream(final int columnIndex, final InputStream x, final long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateAsciiStream(final String columnLabel, final InputStream x, final long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateBinaryStream(final int columnIndex, final InputStream x) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateBinaryStream(final String columnLabel, final InputStream x) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateBinaryStream(final int columnIndex, final InputStream x, final long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateBinaryStream(final String columnLabel, final InputStream x, final long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateBlob(final int columnIndex, final InputStream inputStream) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateBlob(final String columnLabel, final InputStream inputStream) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateBlob(final int columnIndex, final InputStream inputStream, final long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateBlob(final String columnLabel, final InputStream inputStream, final long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateCharacterStream(final int columnIndex, final Reader x) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateCharacterStream(final String columnLabel, final Reader reader) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateCharacterStream(final int columnIndex, final Reader x, final long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateCharacterStream(final String columnLabel, final Reader reader, final long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateClob(final int columnIndex, final Reader reader) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateClob(final String columnLabel, final Reader reader) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateClob(final int columnIndex, final Reader reader, final long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateClob(final String columnLabel, final Reader reader, final long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateNCharacterStream(final int columnIndex, final Reader x) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateNCharacterStream(final String columnLabel, final Reader reader) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateNCharacterStream(final int columnIndex, final Reader x, final long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateNCharacterStream(final String columnLabel, final Reader reader, final long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateNClob(final int columnIndex, final Reader reader) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateNClob(final String columnLabel, final Reader reader) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateNClob(final int columnIndex, final Reader reader, final long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateNClob(final String columnLabel, final Reader reader, final long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateNString(final int columnIndex, final String nString) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateNString(final String columnLabel, final String nString) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public NClob getNClob(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NClob getNClob(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RowId getRowId(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RowId getRowId(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SQLXML getSQLXML(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SQLXML getSQLXML(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateNClob(int columnIndex, NClob nClob) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateNClob(String columnLabel, NClob nClob)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateRowId(int columnIndex, RowId value) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateRowId(String columnLabel, RowId value)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSQLXML(int columnIndex, SQLXML xmlObject)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSQLXML(String columnLabel, SQLXML xmlObject)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
