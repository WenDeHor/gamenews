package com.silkpath.gamenews.util;

import com.silkpath.gamenews.model.IdEntity;

public class ValidationUtil {

    public ValidationUtil() {
    }

    public static void checkNotFound(boolean found, String msg) {
        if (!found) {
            throw new NotFoundException("Not found entity with " + msg);
        }
    }

    public static <T> T checkNotFoundWithId(T object, int id) {
        return checkNotFound(object, "id=" + id);
    }

    public static void checkNotFoundWithId(boolean found, int id) {
        checkNotFound(found, "id=" + id);
    }

    public static <T> T checkNotFound(T object, String msg) {
        checkNotFound(object != null, msg);
        return object;
    }

    public static void checkNew(IdEntity entity) {
        if (!entity.isNew()) {
            throw new IllegalArgumentException(entity + " must be new (id=null)");
        }
    }

//    public static void assureIdConsistent(IdEntity entity, int id) {
//        if (entity.isNew()) {
//            entity.setId(id);
//        } else if (entity.getId() != id) {
//            throw new IllegalArgumentException(entity + " must be with id=" + id);
//        }
//    }
//
//      public static Throwable getRootCause(Throwable t) {
//        Throwable result = t;
//        Throwable cause;
//
//        while (null != (cause = result.getCause()) && (result != cause)) {
//            result = cause;
//        }
//        return result;
//    }
}
