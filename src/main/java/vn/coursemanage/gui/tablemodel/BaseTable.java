package vn.coursemanage.gui.tablemodel;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.text.WordUtils;

import javax.swing.table.AbstractTableModel;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseTable<T> extends AbstractTableModel {
    private List<T> data;
    private Class<T> clazz;

    public void setData(List<T> data) {
        if(data != null)
        this.data = data;
        else this.data = new ArrayList<>();
    }

    private Field[] fields;

    private Field[] ignoreFields;

    public BaseTable(List<T> data,Class clazz, Field... fieldIgnores) {
        this.clazz = clazz;
        this.ignoreFields = fieldIgnores;
        this.data = data;
        setFields(fieldIgnores);
    }

    private void setFields(Field... fieldIgnores) {
        Field[] rawFieldChild = clazz.getDeclaredFields();
        Field[] rawFieldParent = clazz.getSuperclass().getDeclaredFields();
        Field[] rawField = ArrayUtils.addAll(rawFieldParent, rawFieldChild);

        this.fields = fieldIgnores == null || fieldIgnores.length == 0 ? rawField :
                Arrays.stream(ignoreFields).flatMap(ignore ->
                        Arrays.stream(rawField).filter(field -> !field.getName().equalsIgnoreCase(ignore.getName()))
                ).toArray(Field[]::new);
    }

    @Override
    public int getRowCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public int getColumnCount() {
        return fields.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Field field = fields[columnIndex];
        try {
            field.setAccessible(true);
            return field.get(data.get(rowIndex));
        } catch (IllegalAccessException | NullPointerException e) {
            return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        Field field = fields[column];
        field.setAccessible(true);
        return WordUtils.capitalizeFully(field.getName().replaceAll("(?<=.)(?=\\p{Lu})", " "));
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return (getValueAt(0, columnIndex) != null) ?
                getValueAt(0, columnIndex).getClass() : Object.class;
    }
}