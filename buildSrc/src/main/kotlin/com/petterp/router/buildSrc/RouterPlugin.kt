package com.petterp.router.buildSrc

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 *
 * @author petterp
 */
class RouterPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.extensions.create(EXTENSION, RouterExtension::class.java)
        // 当前project配置结束
        project.task(testTaskName)
        project.afterEvaluate {
            val routerExtension = project.properties[EXTENSION] as RouterExtension
            println("-------${routerExtension.wikiDir}")
        }
    }

    companion object {
        const val EXTENSION = "routerBuildSrc"
        const val testTaskName = "routerBuildSrcTask"
    }
}
