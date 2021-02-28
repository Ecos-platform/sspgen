package no.ntnu.ihb.sspgen.dsl

import no.ntnu.ihb.sspgen.dsl.annotations.Scoped
import no.ntnu.ihb.sspgen.dsl.resources.FileResource
import no.ntnu.ihb.sspgen.dsl.resources.PythonfmuResource
import no.ntnu.ihb.sspgen.dsl.resources.Resource
import no.ntnu.ihb.sspgen.dsl.resources.UrlResource
import java.io.File
import java.net.URL

@Scoped
class ResourcesContext(
    private val resources: MutableList<Resource>
) {

    fun file(filePath: String) {
        val file = File(filePath)
        if (!file.exists()) throw NoSuchFileException(file)
        FileResource(file).also { resource ->
            resources.add(resource)
        }
    }

    fun url(urlString: String) {
        UrlResource(URL(urlString)).also { resource ->
            resources.add(resource)
        }
    }

    fun pythonfmu(source: String, vararg projectFiles: String) {
        val sourceFile = File(source)
        if (!sourceFile.exists()) throw NoSuchFileException(sourceFile)
        PythonfmuResource(sourceFile, projectFiles.map { File(it) }).also { resource ->
            resources.add(resource)
        }
    }

}
