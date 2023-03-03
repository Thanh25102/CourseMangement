package vn.coursemanage.gui.tablemodel;

import org.apache.commons.text.WordUtils;

import javax.swing.table.AbstractTableModel;
import java.lang.reflect.Field;
import java.util.List;

public class BaseTable<T> extends AbstractTableModel {
    private List<T> data;

    private Field[] fields;

    public BaseTable(List<T> data) {
        this.data = data;
        fields = data.get(0).getClass().getDeclaredFields();
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
