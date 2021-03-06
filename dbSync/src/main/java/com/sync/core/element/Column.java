package com.sync.core.element;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONType;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@JSONType(seeAlso={
		StringColumn.class, BytesColumn.class,DateColumn.class,
		BoolColumn.class,DoubleColumn.class,LongColumn.class
})
public abstract class Column {

	private Type type;
	private String columnName;
	private Object rawData;

	private int byteSize;

	public Column(final String columnName,final Object object, final Type type, int byteSize) {
		this.columnName = columnName;
		this.rawData = object;
		this.type = type;
		this.byteSize = byteSize;
	}

	public void setColumnName(String columnName){ this.columnName = columnName;}

	public String getColumnName(){
		return this.columnName;
	}

	public Object getRawData() {
		return this.rawData;
	}

	public Type getType() {
		return this.type;
	}

	public int getByteSize() {
		return this.byteSize;
	}

	protected void setType(Type type) {
		this.type = type;
	}

	protected void setRawData(Object rawData) {
		this.rawData = rawData;
	}

	protected void setByteSize(int byteSize) {
		this.byteSize = byteSize;
	}

	public abstract Long asLong();

	public abstract Double asDouble();

	public abstract String asString();

	public abstract Date asDate();

	public abstract byte[] asBytes();

	public abstract Boolean asBoolean();

	public abstract BigDecimal asBigDecimal();

	public abstract BigInteger asBigInteger();

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

	public enum Type {
		BAD, NULL, INT, LONG, DOUBLE, STRING, BOOL, DATE, BYTES
	}
}
