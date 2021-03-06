package com.molinari.jdbcandroid.wrap;

import java.lang.reflect.Constructor;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.molinari.androidstructure.data.db.IDatabaseAndroid;

public abstract class ConnectionAndroid implements Connection {

	private SQLiteDatabase db = null;
	private final Context context;
	private boolean autoCommit = true;
	private IDatabaseAndroid openHelper = null;

	public ConnectionAndroid(final Context context, final boolean isWritable) {
		super();
		this.context = context;
		try {
			final Constructor<?> costruttore = getDatabaseClass().getConstructor(Context.class);
			openHelper = (IDatabaseAndroid) costruttore.newInstance(this.context);
			if (isWritable) {

				db = openHelper.getWritableDatabase();

			} else {
				db = openHelper.getReadableDatabase();
			}
		} catch (final Exception e) {
			Log.e(ConnectionAndroid.class.getName(), Log.getStackTraceString(e));
		}
	}
	
	public abstract Class<?> getDatabaseClass();

	public ConnectionAndroid(final Context context, final SQLiteDatabase db) {
		super();
		this.db = db;
		this.context = context;
	}

	public SQLiteDatabase getDb() {
		return db;
	}

	public void setDb(final SQLiteDatabase db) {
		this.db = db;
	}

	@Override
	public void clearWarnings() throws SQLException {
		throw new ExceptionDB(null, null);
	}

	@Override
	public void commit() throws SQLException {
		if (autoCommit) {
			throw new SQLException("database in auto-commit mode");
		}
		db.setTransactionSuccessful();
		db.endTransaction();
		db.beginTransaction();
	}

	@Override
	public Statement createStatement() throws SQLException {
		return new StatementAndroid(this);
	}

	@Override
	public Statement createStatement(final int resultSetType, final int resultSetConcurrency) throws SQLException {
		try {
			throw new ExceptionDB(null, null);
		} catch (final ExceptionDB e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public Statement createStatement(final int resultSetType, final int resultSetConcurrency, final int resultSetHoldability) throws SQLException {
		throw new ExceptionDB(null, null);
	}

	@Override
	public boolean getAutoCommit() throws SQLException {
		return autoCommit;
	}

	@Override
	public String getCatalog() throws SQLException {
		throw new ExceptionDB(null, null);
	}

	@Override
	public int getHoldability() throws SQLException {
		throw new ExceptionDB(null, null);
	}

	@Override
	public DatabaseMetaData getMetaData() throws SQLException {
		return new DatabaseMetaDataAndroid(this);
	}

	@Override
	public int getTransactionIsolation() throws SQLException {
		throw new ExceptionDB(null, null);
	}

	@Override
	public Map<String, Class<?>> getTypeMap() throws SQLException {
		System.out.println("Operazione non supportata");
		return null;
	}

	@Override
	public SQLWarning getWarnings() throws SQLException {
		System.out.println("Operazione non supportata");
		return null;
	}

	@Override
	public boolean isClosed() throws SQLException {
		return db == null || !db.isOpen();
	}

	@Override
	public boolean isReadOnly() throws SQLException {

		return db.isReadOnly();
	}

	@Override
	public String nativeSQL(final String sql) throws SQLException {
		System.out.println("Operazione non supportata");
		return null;
	}

	@Override
	public CallableStatement prepareCall(final String sql) throws SQLException {
		System.out.println("Operazione non supportata");
		return null;
	}

	@Override
	public CallableStatement prepareCall(final String sql, final int resultSetType, final int resultSetConcurrency) throws SQLException {
		System.out.println("Operazione non supportata");
		return null;
	}

	@Override
	public CallableStatement prepareCall(final String sql, final int resultSetType, final int resultSetConcurrency, final int resultSetHoldability) throws SQLException {
		System.out.println("Operazione non supportata");
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(final String sql) throws SQLException {
		return new PreparedStatementAndroid(this, sql);
	}

	@Override
	public PreparedStatement prepareStatement(final String sql, final int autoGeneratedKeys) throws SQLException {
		System.err.println("Operazione non supportata");
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(final String sql, final int[] columnIndexes) throws SQLException {
		System.out.println("Operazione non supportata");
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(final String sql, final String[] columnNames) throws SQLException {
		System.out.println("Operazione non supportata");
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(final String sql, final int resultSetType, final int resultSetConcurrency) throws SQLException {
		System.out.println("Operazione non supportata");
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(final String sql, final int resultSetType, final int resultSetConcurrency, final int resultSetHoldability) throws SQLException {
		System.out.println("Operazione non supportata");
		return null;
	}

	@Override
	public void releaseSavepoint(final Savepoint savepoint) throws SQLException {
		System.out.println("Operazione non supportata");

	}

	@Override
	public void rollback() throws SQLException {
		if (autoCommit) {
			throw new SQLException("database in auto-commit mode");
		}
		db.endTransaction();
		db.beginTransaction();

	}

	@Override
	public void rollback(final Savepoint savepoint) throws SQLException {
		System.out.println("Operazione non supportata");

	}

	@Override
	public void setAutoCommit(final boolean autoCommit) throws SQLException {
		if (this.autoCommit == autoCommit) {
			return;
		}
		this.autoCommit = autoCommit;
		if (autoCommit) {
			db.setTransactionSuccessful();
			db.endTransaction();
		} else {
			db.beginTransaction();
		}

	}

	@Override
	public void setCatalog(final String catalog) throws SQLException {
		System.out.println("Operazione non supportata");

	}

	@Override
	public void setHoldability(final int holdability) throws SQLException {
		System.out.println("Operazione non supportata");

	}

	@Override
	public void setReadOnly(final boolean readOnly) throws SQLException {
		System.out.println("Operazione non supportata");

	}

	@Override
	public Savepoint setSavepoint() throws SQLException {
		System.out.println("Operazione non supportata");
		return null;
	}

	@Override
	public Savepoint setSavepoint(final String name) throws SQLException {
		System.out.println("Operazione non supportata");
		return null;
	}

	@Override
	public void setTransactionIsolation(final int level) throws SQLException {
		System.out.println("Operazione non supportata");

	}

	@Override
	public void setTypeMap(final Map<String, Class<?>> arg0) throws SQLException {
		System.out.println("Operazione non supportata");

	}

	@Override
	public void close() throws SQLException {
		if (db != null && db.isOpen()) {
			db.close();
		}
		// db = null; ???
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
	public Array createArrayOf(String typeName, Object[] elements)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Blob createBlob() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Clob createClob() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NClob createNClob() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SQLXML createSQLXML() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Struct createStruct(String typeName, Object[] attributes)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Properties getClientInfo() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getClientInfo(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValid(int timeout) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setClientInfo(Properties properties)
			throws SQLClientInfoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setClientInfo(String name, String value)
			throws SQLClientInfoException {
		// TODO Auto-generated method stub
		
	}
}
