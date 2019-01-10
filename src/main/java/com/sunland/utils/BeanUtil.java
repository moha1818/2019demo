package com.sunland.utils;

import org.apache.commons.beanutils.BeanUtils;

/**
 * Created by lq on 16/02/2.
 */

public class BeanUtil {
    public static void BeanCopyProperty(Object objectTarget, Object objectSrc) {
        try {
            BeanUtils.copyProperties(objectTarget, objectSrc);
        } catch (Exception ex) {
            System.out.println("============" + ex.getMessage());
        }
    }

}
