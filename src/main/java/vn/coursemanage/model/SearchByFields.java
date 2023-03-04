package vn.coursemanage.model;

public class SearchByFields {
    private String searchKey, fieldName;

    public SearchByFields(String searchKey, String fieldName) {
        this.searchKey = searchKey;
        this.fieldName = fieldName;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public String getFieldName() {
        return fieldName;
    }
}
