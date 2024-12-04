package com.coolers.cloud.cloudShare.util;

import java.util.Collection;

public class BaseUtil {
    public static boolean isEmptyObject(Object object) {
        return object == null;
    }

    public static boolean isNotEmptyObject(Object object) {
        return object != null;
    }

    public static boolean isEmptyMathObject(Object object) {
        return object == null || (Integer) object == 0;
    }

    public static boolean isNotEmptyMathObject(Object object) {
        return object != null && (Integer) object == 0;
    }

    public static boolean isEmptyCollection(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isNotEmptyCollection(Collection collection) {
        return collection != null && !collection.isEmpty();
    }

}
