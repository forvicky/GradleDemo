package com.zdd.plugindemo   //这个包名要有，否则打包出来的jar包用的是默认包名


import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * 自定义插件
 */
class TestPlugin implements Plugin<Project>{


    /**
     * 插件被引入时要执行的方法
     * @param project 引入当前插件的Project
     */
    void apply(Project project){
        println '这是自定义 Plugin...'+project.name

        //创建扩展属性
        project.extensions.create('nlpReleaseInfo',
                ReleaseInfoExtension)
        //创建Task
        project.tasks.create('nlpReleaseInfoTask',
                ReleaseInfoTask)

        //创建Task
        project.tasks.create('nlpReleaseInfoXmlTask',
                ReleaseInfoXmlTask)
    }


}