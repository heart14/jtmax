package xyz.sadli.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * About: Bean工具类
 * Other:
 * Created: lwf14 on 2022/12/1 23:51.
 * Editored:
 */
public class BeanUtils {

    /**
     * 视图类对象所在包名
     */
    public static final String VO_CLASS_PACKAGE = "xyz.sadli.vo";

    /**
     * 将Bean实例转换为对应的视图VO实例
     *
     * @param bean
     * @return
     */
    public static Object beanToVO(Object bean) {
        if (bean == null) {
            return null;
        }
        //获取源Bean的Class对象
        Class<?> srcClass = bean.getClass();
        //源Bean的全类名
        String className = srcClass.getName();
        //System.out.println("**" + className);

        //组装对应VO类的全类名
        String targetClassName = VO_CLASS_PACKAGE + className.substring(className.lastIndexOf(".")) + "VO";
        //System.out.println("**" + targetClassName);
        try {
            //获取目标VO的Class对象
            Class<?> targetClass = Class.forName(targetClassName);
            //System.out.println("**" + targetClass.getName());

            //获取目标VO的实例对象
            Object o = targetClass.newInstance();

            //获取源Bean的所有成员变量
            Field[] fields = srcClass.getDeclaredFields();
            for (Field field : fields) {
                //修改可见性为true
                field.setAccessible(true);
                //获取源Bean的字段名
                String fieldName = field.getName();
                //如果是serialVersionUID则跳过
                if ("serialVersionUID".equals(fieldName)) {
                    continue;
                }
                //获取源Bean该Field字段值
                Object fieldValue = field.get(bean);

                //获取该字段首字母
                String upperCase = fieldName.substring(0, 1).toUpperCase();
                //组装目标VO对应字段的set方法名
                String setMethodName = "set" + upperCase + fieldName.substring(1);
                try {
                    //获取目标VO对应字段的set方法
                    Method method = targetClass.getMethod(setMethodName, field.getType());
                    //invoke代理调用目标VO对应字段的set方法，设置该字段值
                    method.invoke(o, fieldValue);
                } catch (NoSuchMethodException e) {
                    //不存在对应字段的set方法则不进行设置
                    //e.printStackTrace();
                } catch (SecurityException e) {
                    e.printStackTrace();
                }

            }
            return o;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;


//        Field[] fromFields = beanClass.getDeclaredFields();
//        Assert.notEmpty(fromFields, ErrCodeEnums.BEAN2VO_EXCEPTION.getMsg());

//        try {
//            T t = clazz.newInstance();
//
//            for (Field fromField : fromFields) {
//                fromField.setAccessible(true);
//                String fieldName = fromField.getName();
//                Object fieldValue = fromField.get(fieldName);
//
//                Field targetField = clazz.getDeclaredField(fieldName);
//                if (targetField != null) {
//                    targetField.setAccessible(true);
//
//                    if (targetField.getType().isPrimitive()) {
//                        if (targetField.getType().equals(fieldValue.getClass())) {
//                            targetField.set(t, fieldValue);
//                        }
//                    } else if (targetField.getType().isAssignableFrom(fieldValue.getClass())) {
//                        targetField.set(t, fieldValue);
//                    }
//                }
//            }
//            return t;
//        } catch (IllegalAccessException | NoSuchFieldException | InstantiationException e1) {
//            e1.printStackTrace();
//        }
    }
}
