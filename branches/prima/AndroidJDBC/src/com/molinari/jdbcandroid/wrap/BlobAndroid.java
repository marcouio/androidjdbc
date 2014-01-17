package com.molinari.jdbcandroid.wrap;

import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;

import android.database.SQLException;

public class BlobAndroid implements Blob {

	private final byte[] b;

	public BlobAndroid(final byte[] b) {
		this.b = b;
	}

	@Override
	public long length() throws SQLException {
		return b.length;
	}

	@Override
	public byte[] getBytes(final long pos, final int length) throws SQLException {
		return b;
	}

	@Override
	public InputStream getBinaryStream() throws SQLException {
		throw new ExceptionDB(null, null);
	}

	@Override
	public long position(final byte[] pattern, final long start) throws SQLException {
		throw new ExceptionDB(null, null);
	}

	@Override
	public long position(final Blob pattern, final long start) throws SQLException {
		throw new ExceptionDB(null, null);
	}

	@Override
	public int setBytes(final long pos, final byte[] bytes) throws SQLException {
		throw new ExceptionDB(null, null);
	}

	@Override
	public int setBytes(final long pos, final byte[] bytes, final int offset, final int len) throws SQLException {
		throw new ExceptionDB(null, null);
	}

	@Override
	public OutputStream setBinaryStream(final long pos) throws SQLException {
		throw new ExceptionDB(null, null);
	}

	@Override
	public void truncate(final long len) throws SQLException {
		throw new ExceptionDB(null, null);
	}

	@Override
	public void free() throws java.sql.SQLException {
		throw new ExceptionDB(null, null);
		
	}

	@Override
	public InputStream getBinaryStream(long arg0, long arg1) throws java.sql.SQLException {
		throw new ExceptionDB(null, null);
	}

}
