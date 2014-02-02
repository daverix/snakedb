package net.daverix.snakedb.mapping;

import net.daverix.snakedb.exception.FieldNotFoundException;

/**
 * Created by daverix on 2/1/14.
 */
public interface IFetchableValues {
    public byte[] getBlob(String fieldName) throws FieldNotFoundException;
    public String getString(String fieldName) throws FieldNotFoundException;

    public double getDouble(String fieldName) throws FieldNotFoundException;
    public float getFloat(String fieldName) throws FieldNotFoundException;

    public int getInt(String fieldName) throws FieldNotFoundException;
    public short getShort(String fieldName) throws FieldNotFoundException;
    public long getLong(String fieldName) throws FieldNotFoundException;
    public boolean getBoolean(String fieldName) throws FieldNotFoundException;
}
