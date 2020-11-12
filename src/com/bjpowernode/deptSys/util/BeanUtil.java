package com.bjpowernode.deptSys.util;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Company : BJPowernode
 * Date : 2020/7/27
 * Description :
 */
public class BeanUtil {


    //直接将页面表单数据给封装到Bean对象中，但是日期必须是"yyyy-MM-dd"
    public static <T> T formToBean(Class<T> clazz, Map<String,String[]> map){
        T t = null;
        try {
            t = clazz.newInstance();
            ConvertUtils.register(new Converter() {
                //o:页面输入的日期
                @Override
                public Object convert(Class aClass, Object o) {
                    //判断日期是否null ***** ""
                    if(o == null){
                        return null;
                    }
                    //指定页面输入的日期格式
                    String pattern = "yyyy-MM-dd";
                    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                    try {
                        return sdf.parse(o.toString());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    return null;
                }
            }, Date.class);
            BeanUtils.populate(t,map);
        } catch  (Exception e) {
            e.printStackTrace();
        }
         return t;
    }
}
