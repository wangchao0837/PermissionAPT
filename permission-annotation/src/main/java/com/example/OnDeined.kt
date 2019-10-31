/*
 * Created by 动脑科技-Tim on 17-6-21 下午8:20
 * Copyright (c) 2017. All rights reserved
 *
 * Last modified 17-6-21 下午8:20
 */

package com.example

@Target(AnnotationTarget.FUNCTION)
@kotlin.annotation.Retention
annotation class OnDeined (val values:Array<String>)