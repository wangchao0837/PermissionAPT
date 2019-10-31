/*
 * Created by 动脑科技-Tim on 17-6-21 下午8:23
 * Copyright (c) 2017. All rights reserved
 *
 * Last modified 17-6-21 下午8:23
 */

package com.example

import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.ProcessingEnvironment
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.SourceVersion
import javax.lang.model.element.ExecutableElement
import javax.lang.model.element.TypeElement

class PermissionCompiler: AbstractProcessor() {

    override fun getSupportedAnnotationTypes(): Set<String> {
        return setOf(Need::class.java.canonicalName)
    }

     @Synchronized override fun init(processingEnvironment: ProcessingEnvironment) {
        super.init(processingEnvironment)
         FILER_UTILS = processingEnvironment.filer
         ELEMENT_UTILS = processingEnvironment.elementUtils
         TYPE_UTILS = processingEnvironment.typeUtils
    }

    //返回值代表是否还提供给其他注解处理器处理
    override fun process(set: MutableSet<out TypeElement>, roundEnvironment: RoundEnvironment): Boolean {

        //获得被注解了 @Need 的元素 元素是指： 代码中的元素，比如包，类或者方法
        roundEnvironment.getElementsAnnotatedWith(Need::class.java).groupBy {
            it.enclosingElement
        }.map {
            ClassBuilder(it.key as TypeElement, it.value.map { NeedMethod(it as ExecutableElement) })
        }.map {
            it.brewKotlin()
        }

        return false
    }

    override fun getSupportedSourceVersion(): SourceVersion {
        return SourceVersion.latestSupported()
    }

}
