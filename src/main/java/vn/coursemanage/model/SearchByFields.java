package vn.coursemanage.model;

public class SearchByFields {
    private Object searchKey;
    private String fieldName;

    public SearchByFields(Object searchKey, String fieldName) {
        this.searchKey = searchKey;
        this.fieldName = fieldName;
    }

    public Object getSearchKey() {
        return searchKey == null ? "" : searchKey;
    }

    public String getFieldName() {
        return fieldName;
    }

    @Override
    public String toString() {
        return "SearchByFields{" +
                "searchKey=" + searchKey +
                ", fieldName='" + fieldName + '\'' +
                '}';
    }
}
