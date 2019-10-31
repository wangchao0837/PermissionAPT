/*
 * Created by 动脑科技-Tim on 17-6-21 下午8:21
 * Copyright (c) 2017. All rights reserved
 *
 * Last modified 17-6-21 下午8:21
 */

package com.example

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

@Target(AnnotationTarget.FUNCTION)
@kotlin.annotation.Retention
annotation class OnNeverAsk(val values:Array<String>)