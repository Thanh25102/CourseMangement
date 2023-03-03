package vn.coursemanage.bll;

import java.lang.reflect.Field;

public class BaseServices {

    //Check fieldName is exist in object
    protected boolean isObjContainField(Class clazz, String fieldName) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getName().equalsIgnoreCase(fieldName)) return true;
        }
        return false;
    }
}
