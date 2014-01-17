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
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.database.Cursor;

import com.molinari.jdbcandroid.interpreter.InterpretatoreSqlString;

public class PreparedStatementAndroid extends StatementAndroid implements PreparedStatement {

	private ConnectionAndroid connectionAndroid = null;
	private ResultSetAndroid rs = null;
	private String sql;
	ArrayList<Object> listaBinding = new ArrayList<Object>();

	public PreparedStatementAndroid(final ConnectionAndroid connectionAndroid, final String sql) {
		this.sql = sql;
		this.connectionAndroid = connectionAndroid;
	}

	private void setObj(int posizione, final Object object) {
		// prepared statements count from 1, we count from 0 (in array)
		if (posizione > 0) {
			posizione--;
		}
		//controllo la grandezza della lista per evitare che vada in outOfBoundException
		//se è più corto della posizione da aggiungere aggiungo valori null alla lista fino
		//a farla diventare della lunghezza giusta
		if (listaBinding.size() <= posizione) {
			for (int i = listaBinding.size(); i <= posizione; i++) {
				listaBinding.add(null);
			}
		}
		listaBinding.set(posizione, object);
	}

	private String[] bindingToString() {
		// convert our parameter list objects to strings
		final List<String> strList = new ArrayList<String>();

		for (final Object o : listaBinding) {
			strList.add(o.toString());
		}

		return strList.toArray(new String[strList.size()]);
	}

	@Override
	public void clearParameters() throws SQLException {
		throw new ExceptionDB(null, null);

	}

	@Override
	public boolean execute() throws SQLException {
		
		final String operazione = InterpretatoreSqlString.getOperazioneDaSqlString(sql);
		if (!operazione.equalsIgnoreCase("SELECT")) {
			
			String[] binding = bindingToString();
			for (int i = 0; i < binding.length; i++) {
				sql = sql.replaceFirst("?", binding[i]);
				
			}
			connectionAndroid.getDb().execSQL(sql);
			return false;
		} else {
			final Cursor cursore = connectionAndroid.getDb().rawQuery(sql, bindingToString());
			rs = new ResultSetAndroid(cursore);
			return true;
		}
	}

	@Override
	public ResultSet executeQuery() throws SQLException {
		Cursor cursore = null;
		if (listaBinding.size() == 0) {
			cursore = connectionAndroid.getDb().rawQuery(sql, null);
		} else {
			cursore = connectionAndroid.getDb().rawQuery(sql, bindingToString());
		}
		rs = new ResultSetAndroid(cursore);
		return rs;
	}

	@Override
	public int executeUpdate() throws SQLException {
		close();
		final String operazione = InterpretatoreSqlString.getOperazioneDaSqlString(sql);
		if (!operazione.equalsIgnoreCase("SELECT")) {
			
			String[] binding = bindingToString();
			for (int i = 0; i < binding.length; i++) {
				sql = sql.replaceFirst("?", binding[i]);
				
			}
			connectionAndroid.getDb().execSQL(sql);
			return 0;
		} else {
			throw new SQLException("Non puoi eseguire un'operazione di select con il metodo executeUpdate()");
		}
	}

	@Override
	public ResultSetMetaData getMetaData() throws SQLException {
		throw new ExceptionDB(null, null);
	}

	@Override
	public ParameterMetaData getParameterMetaData() throws SQLException {
		throw new ExceptionDB(null, null);
	}

	@Override
	public void setArray(final int arg0, final Array arg1) throws SQLException {
		throw new ExceptionDB(null, null);
	}

	@Override
	public void setAsciiStream(final int arg0, final InputStream arg1, final int arg2) throws SQLException {
		throw new ExceptionDB(null, null);
	}

	@Override
	public void setBigDecimal(final int arg0, final BigDecimal arg1) throws SQLException {
		throw new ExceptionDB(null, null);
	}

	@Override
	public void setBinaryStream(final int arg0, final InputStream arg1, final int arg2) throws SQLException {
		throw new ExceptionDB(null, null);
	}

	@Override
	public void setBlob(final int arg0, final Blob arg1) throws SQLException {
		throw new ExceptionDB(null, null);
	}

	@Override
	public void setBoolean(final int arg0, final boolean arg1) throws SQLException {
		throw new ExceptionDB(null, null);
	}

	@Override
	public void setByte(final int arg0, final byte arg1) throws SQLException {
		throw new ExceptionDB(null, null);
	}

	@Override
	public void setBytes(final int arg0, final byte[] arg1) throws SQLException {
		throw new ExceptionDB(null, null);
	}

	@Override
	public void setCharacterStream(final int arg0, final Reader arg1, final int arg2) throws SQLException {
		throw new ExceptionDB(null, null);
	}

	@Override
	public void setClob(final int arg0, final Clob arg1) throws SQLException {
		throw new ExceptionDB(null, null);
	}

	@Override
	public void setDate(final int arg0, final Date arg1) throws SQLException {
		throw new ExceptionDB(null, null);
	}

	@Override
	public void setDate(final int parameterIndex, final Date theDate, final Calendar cal) throws SQLException {
		throw new ExceptionDB(null, null);
	}

	@Override
	public void setDouble(final int parameterIndex, final double theDouble) throws SQLException {
		setObj(parameterIndex, new Double(theDouble));
		//		compileStatement.bindDouble(parameterIndex, theDouble);
	}

	@Override
	public void setFloat(final int parameterIndex, final float theFloat) throws SQLException {
		setObj(parameterIndex, new Float(theFloat));
		//		compileStatement.bindDouble(parameterIndex, new Double(theFloat));

	}

	@Override
	public void setInt(final int parameterIndex, final int theInt) throws SQLException {
		setObj(parameterIndex, new Integer(theInt));
		//		compileStatement.bindLong(parameterIndex, new Long(theInt));

	}

	@Override
	public void setLong(final int parameterIndex, final long theLong) throws SQLException {
		setObj(parameterIndex, new Long(theLong));
		//		compileStatement.bindLong(parameterIndex, theLong);
	}

	@Override
	public void setNull(final int parameterIndex, final int sqlType) throws SQLException {
		System.out.println("Operazione non supportata");

	}

	@Override
	public void setNull(final int paramIndex, final int sqlType, final String typeName) throws SQLException {
		System.out.println("Operazione non supportata");
	}

	@Override
	public void setObject(final int parameterIndex, final Object theObject) throws SQLException {
		System.out.println("Operazione non supportata");

	}

	@Override
	public void setObject(final int parameterIndex, final Object theObject, final int targetSqlType) throws SQLException {
		System.out.println("Operazione non supportata");

	}

	@Override
	public void setObject(final int parameterIndex, final Object theObject, final int targetSqlType, final int scale) throws SQLException {
		System.out.println("Operazione non supportata");

	}

	@Override
	public void setRef(final int parameterIndex, final Ref theRef) throws SQLException {
		System.out.println("Operazione non supportata");

	}

	@Override
	public void setShort(final int parameterIndex, final short theShort) throws SQLException {
		setObj(parameterIndex, new Short(theShort));
	}

	@Override
	public void setString(final int parameterIndex, final String theString) throws SQLException {
		setObj(parameterIndex, theString);
		//		compileStatement.bindString(parameterIndex, theString);
	}

	@Override
	public void setTime(final int parameterIndex, final Time theTime) throws SQLException {
		throw new ExceptionDB(null, null);
	}

	@Override
	public void setTime(final int parameterIndex, final Time theTime, final Calendar cal) throws SQLException {
		throw new ExceptionDB(null, null);
	}

	@Override
	public void setTimestamp(final int parameterIndex, final Timestamp theTimestamp) throws SQLException {
		throw new ExceptionDB(null, null);
	}

	@Override
	public void setTimestamp(final int parameterIndex, final Timestamp theTimestamp, final Calendar cal) throws SQLException {
		throw new ExceptionDB(null, null);
	}

	@Override
	public void setURL(final int parameterIndex, final URL theURL) throws SQLException {
		throw new ExceptionDB(null, null);
	}

	@Override
	public void setUnicodeStream(final int parameterIndex, final InputStream theInputStream, final int length) throws SQLException {
		throw new ExceptionDB(null, null);
	}

	@Override
	public void addBatch() throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isClosed() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPoolable() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setPoolable(boolean arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isWrapperFor(Class<?> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAsciiStream(int parameterIndex, InputStream inputStream)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAsciiStream(int parameterIndex, InputStream inputStream,
			long length) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBinaryStream(int parameterIndex, InputStream inputStream)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBinaryStream(int parameterIndex, InputStream inputStream,
			long length) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBlob(int parameterIndex, InputStream inputStream)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBlob(int parameterIndex, InputStream inputStream, long length)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCharacterStream(int parameterIndex, Reader reader)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCharacterStream(int parameterIndex, Reader reader,
			long length) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setClob(int parameterIndex, Reader reader) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setClob(int parameterIndex, Reader reader, long length)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNCharacterStream(int parameterIndex, Reader reader)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNCharacterStream(int parameterIndex, Reader reader,
			long length) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNClob(int parameterIndex, NClob value) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNClob(int parameterIndex, Reader reader) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNClob(int parameterIndex, Reader reader, long length)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNString(int parameterIndex, String theString)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRowId(int parameterIndex, RowId theRowId)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSQLXML(int parameterIndex, SQLXML xmlObject)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
