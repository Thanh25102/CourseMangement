package vn.coursemanage.gui.tablemodel;

import org.apache.commons.text.WordUtils;

import javax.swing.table.AbstractTableModel;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class BaseTable<T> extends AbstractTableModel {
    private List<T> data;

    private Field[] fields;

    private Field[] ignoreFields;

    public BaseTable(List<T> data, Field... fieldIgnores) {
        this.ignoreFields = fieldIgnores;
        this.data = data;

        Field[] rawField = data.get(0).getClass().getDeclaredFields();

        this.fields = Arrays.stream(ignoreFields).flatMap(ignore ->
                Arrays.stream(rawField).filter(field -> !field.getName().equalsIgnoreCase(ignore.getName()))
        ).toArray(Field[]::new);
    }

    @Override
    public int getRowCount() {
        return data.size();
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
            return field.get(data.get(0));
        } catch (IllegalAccessException e) {
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
