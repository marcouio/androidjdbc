package com.molinari.jdbcandroid.interpreter;

import java.util.HashMap;

public abstract class InterpretatoreSqlString {

	public static String getOperazioneDaSqlString(String sql) {
		sql = sql.toLowerCase();
		final String[] split = sql.split(" ");
		return split[0];
	}

	public static String[] trovaSuccessivoFromStringSQL(final String SQL, String nome, String splitter) {
		final String sql = SQL.toLowerCase();
		if (nome != null && splitter != null) {
			nome = nome.toLowerCase();
			splitter = splitter.toLowerCase();
			if (sql.contains(nome)) {
				final String[] sqlSplittato = sql.split(nome);
				String per = sqlSplittato[1];
				per = per.substring(1);
				int indice = per.indexOf(" ");
				indice = indice == -1 ? per.indexOf(splitter) : indice;
				indice = indice == -1 ? per.length() : indice;
				return new String[] { per.substring(0, indice) };
			}
		}
		return null;
	}

	public abstract String[] trovaTabelleFromStringSQL(final String SQL);

	public abstract HashMap<String, String>[] trovaWhereFromStringSQL(final String SQL);

	public static void main(final String[] args) {

	}

}
