package com.zhw.annotion;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于注解mapper中需要批量操作的方法，默认为添加
 * @author 张帅令
 * 2017-12-12
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Batch {
	/**
	 * 方法索引
	 * @return
	 */
	int index() default 1;
}
