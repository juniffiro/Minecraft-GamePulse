package ua.juniffiro.ms.gamepulse.util;

import java.lang.annotation.Annotation;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 12/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class Annotated<T> {

    /*
        Utility for convenient class annotation.
     */

    private T annotation;

    public Annotated(Class<? extends Annotation> annoClass) {
        Class<?> clazz = getClass();
        if (clazz.isAnnotationPresent(annoClass)) {
            this.annotation = (T) clazz.getAnnotation(annoClass);
        }
    }

    public T getAnnotation() {
        return annotation;
    }
}
