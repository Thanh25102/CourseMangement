package vn.coursemanage.bll;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vn.coursemanage.exception.FieldNotValidException;
import vn.coursemanage.exception.NotFoundRecordException;
import vn.coursemanage.model.SearchByFields;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import vn.coursemanage.model.Person;

abstract class BaseServices<T> {
    private static final Logger LOGGER = LogManager.getLogger(BaseServices.class);
    private Class<T> type;

    protected BaseServices(Class<T> type) {
        this.type = type;
    }

    protected abstract List<T> findByField(String fieldName, String searchKey);
    protected abstract List<T> findByFields(List<SearchByFields> searchMap);

    /**
     * Check fieldName is existed in object
     */
    private boolean isObjContainField(Class clazz, String fieldName) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getName().equalsIgnoreCase(fieldName)) return true;
        }
        return false;
    }

    public List<T> searchByField(String fieldName, String searchKey) throws NotFoundRecordException, FieldNotValidException {
        // check field is exist in Object class ??
        if (!isObjContainField(type, fieldName)) {
            LOGGER.error("Field " + fieldName + " isn't exist in class :" + type.getSimpleName());
            throw new FieldNotValidException(fieldName + " isn't exist in class " + type.getSimpleName());
        }

        List<T> result = findByField(fieldName, searchKey);
        if (result == null || result.size() == 0) {
            LOGGER.error("Can't find any record with search key is : " + searchKey);
            throw new NotFoundRecordException("Can't find any record with search key is : " + searchKey);
        }

        return result;
    }

    public List<T> searchByFields(List<SearchByFields> searchMap) throws NotFoundRecordException, FieldNotValidException, NoSuchFieldException {
        for (SearchByFields search : searchMap) {
            // check field is exist in Object class ??
            if (!isObjContainField(type, search.getFieldName())) {
                LOGGER.error("Field " + search.getFieldName() + " isn't exist in class :" + type.getSimpleName());
                throw new FieldNotValidException(search.getFieldName() + " isn't exist in class " + type.getSimpleName());
            }     
        }

        List<T> result = findByFields(searchMap);
        if (result == null || result.size() == 0) {
            LOGGER.error("Can't find any record with keys");
            throw new NotFoundRecordException("Can't find any record with keys");
        }

        return result;
    }
}
