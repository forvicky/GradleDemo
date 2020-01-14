package com.zdd.plugindemo
/**
 * 与自定义PLugin进行参数传递
 */
class ReleaseInfoExtension {

    String versionCode
    String versionName
    String versionInfo
    String fileName
    String fileDirs

    ReleaseInfoExtension() {

    }

    @Override
    String toString() {
        """| versionCode = ${versionCode}
           | versionName = ${versionName}
           | versionInfo = ${versionInfo}
           | fileDirs = ${fileDirs}
           | fileName = ${fileName}
        """.stripMargin()
    }
}