package com.example.loginresigtertemplate.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class CopyUtil {

    public CopyUtil() {
    }
    public static <T> T CopyMonomer(Object source,Class<T> tClass) {
        if(source == null){
            return null;
        }
        T object = null;
        try {
            object = tClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        BeanUtils.copyProperties(source,object);
        return object;
    }

    public static <T> List<T> CopyList(List source,Class<T> tClass){
        if(!CollectionUtils.isEmpty(source))
            return null;
        List<T> target = new ArrayList<>();
        for (Object o : source) {
            T object = CopyMonomer(o,tClass);
            target.add(object);
        }
        return target;
    }
}
