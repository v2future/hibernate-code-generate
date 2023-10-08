package com.gantang.generatecode.dto;

import java.util.HashMap;
import java.util.Map;

import ch.qos.logback.core.db.dialect.DBUtil;
import com.gantang.generatecode.utils.DbUtils;

/**
 * 
 * @author jyp10@foxmail.com
 *
 */
public class PropertyTypeMapping {
	private static Map<String, String> TYPE_MAPPING_ORACLE = new HashMap<>();
	static {
		TYPE_MAPPING_ORACLE.put("VARCHAR2", "String");
		TYPE_MAPPING_ORACLE.put("NVARCHAR2", "String");
		TYPE_MAPPING_ORACLE.put("CHAR", "Boolean");
		TYPE_MAPPING_ORACLE.put("NUMBER", "Long");
		TYPE_MAPPING_ORACLE.put("DATE", "Date");
	}

	private static Map<String, String> TYPE_MAPPING_PG = new HashMap<>();
	static {
		TYPE_MAPPING_PG.put("text", "String");
		TYPE_MAPPING_PG.put("boolean", "Boolean");
		TYPE_MAPPING_PG.put("bigint", "Long");
		TYPE_MAPPING_PG.put("double precision", "Double");
		TYPE_MAPPING_PG.put("numeric", "Double");
		TYPE_MAPPING_PG.put("timestamp without time zone", "Date");

	}

	private static Map<String, String> TYPE_MAPPING_MYSQL = new HashMap<>();
	static {
		TYPE_MAPPING_MYSQL.put("char", "String");
		TYPE_MAPPING_MYSQL.put("varchar", "String");
		TYPE_MAPPING_MYSQL.put("int", "Integer");
		TYPE_MAPPING_MYSQL.put("number", "Long");
		TYPE_MAPPING_MYSQL.put("float", "Float");
		TYPE_MAPPING_MYSQL.put("double", "Double");
		TYPE_MAPPING_MYSQL.put("date", "Date");
	}

	public static String getJavaTypeMapping(String key) {
		if (DbUtils.isOracle()) {
			return TYPE_MAPPING_ORACLE.get(key);
		} else if (DbUtils.isPgSql()) {
			return TYPE_MAPPING_PG.get(convertKey(key));
		} else if (DbUtils.isMysql()) {
			for(String item : TYPE_MAPPING_MYSQL.keySet()) {
				if ( key.toLowerCase().startsWith(item)) {
					return TYPE_MAPPING_MYSQL.get(item);
				}
			}
			return null;
		}
		return null;
	}



	private static String convertKey(String key) {
		return key.startsWith("numeric") ? "numeric" : key;
	}
}
