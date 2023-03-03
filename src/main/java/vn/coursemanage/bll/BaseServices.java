package vn.coursemanage.bll;

import vn.coursemanage.exception.FieldNotValidException;
import vn.coursemanage.exception.NotFoundRecordException;

import java.lang.reflect.Field;
import java.util.List;

abstract class BaseServices<T> {
    private Class<T> type;
    protected BaseServices(Class<T> type){
        this.type = type;
    }
    protected abstract List<T> findByField(String fieldName, String searchKey) throws FieldNotValidException, NotFoundRecordException;
    /**
     *  Check fieldName is existed in object
     */
    protected boolean isObjContainField(Class clazz, String fieldName) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getName().equalsIgnoreCase(fieldName)) return true;
        }
        return false;
    }
    public List<T> searchByField(String fieldName, String searchKey) throws NotFoundRecordException, FieldNotValidException {
        // check field is exist in Object class ??
        if (!isObjContainField(type, fieldName))
            throw new FieldNotValidException(fieldName + " isn't exist in class " + type.getSimpleName());

        List<T> result = findByField(fieldName,searchKey);
        if (result == null || result.size() == 0)
            throw new NotFoundRecordException("Can't find any record with search key is : " + searchKey);

        return result;
    }
}
