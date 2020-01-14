package com.zdd.plugindemo

import groovy.xml.MarkupBuilder
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * 自定义Task,实现维护版本信息功能
 */
class ReleaseInfoXmlTask extends DefaultTask {

    ReleaseInfoXmlTask() {
        group = 'zdd'
        description = 'create version xml'
    }

    /**
     * 执行于gradle执行阶段的代码
     */
    @TaskAction
    void doAction() {
        handlerVersionInfo()
    }

    private void handlerVersionInfo() {

        println '开始解析对应的xml文件...'

        String fileDirs = project.extensions.
                nlpReleaseInfo.fileDirs
        String fileName = project.extensions.
                nlpReleaseInfo.fileName

        def destDir = project.file(fileDirs)
        if (destDir != null && !destDir.exists()) {
            destDir.mkdirs()
        }

        println destDir.path

        def srcFile = new File(destDir, fileName)

        if (srcFile != null && !srcFile.exists()) {
            srcFile.createNewFile()
        }

        def releases = new XmlParser().parse(srcFile)
        releases.release.each { releaseNode ->
            //解析每个release结点的内容
            def name = releaseNode.versionName.text()
            def versionCode = releaseNode.versionCode.text()
            def versionInfo = releaseNode.versionInfo.text()
            //创建文件并写入结点数据
            def destFile = new File(destDir, "release-${name}.txt")

            println destFile.path

            if (destFile != null && !destFile.exists()) {
                destFile.createNewFile()
            }

            destFile.withWriter('utf-8') { writer -> writer.write("${name} -> ${versionCode} -> ${versionInfo}")
            }
        }

    }
}