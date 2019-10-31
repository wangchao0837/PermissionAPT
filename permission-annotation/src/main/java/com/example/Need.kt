/*
 * Created by 动脑科技-Tim on 17-6-21 下午8:11
 * Copyright (c) 2017. All rights reserved
 *
 * Last modified 17-6-21 下午8:11
 */

package com.example

import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Retention

/*
* Retention(保留)注解说明， 这种类型的注解会被保留到那个阶段，有三个值：
* 1.RetentionPolicy.SOURCE ----- 这种类型的Annotations只在源代码级别保留，编译时就会被忽略
* 2.RetentionPolicy.CLASS  ----- 这种类型的Annotations编译时会被保留，在class文件中存在，但JVM将会忽略
* 3.RetentionPolicy.RUNTIME ------ 这种类型的Annotations将被JVM保留，所以他们能在运行时被JVM或其他使用反射机制的代码读取和使用
* 注解的处理除了可以在运行时通过反射机制处理外，还可以在编译期进行处理。
* */

@Target(AnnotationTarget.FUNCTION)
@kotlin.annotation.Retention
annotation class Need(val values: Array<String>)
