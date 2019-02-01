package org.openmicroscopy.api.extensions

import org.gradle.api.Action
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project
import org.gradle.api.file.FileCollection
import org.openmicroscopy.api.extensions.specs.ApiSpecification

class ApiExtension implements ApiSpecification {

    final Project project

    final NamedDomainObjectContainer<SplitExtension> language

    FileCollection combinedFiles

    File outputDir

    ApiExtension(Project project, NamedDomainObjectContainer<SplitExtension> language) {
        this.project = project
        this.combinedFiles = project.files()
        this.language = language
    }

    void language(Action<? super NamedDomainObjectContainer<SplitExtension>> action) {
        action.execute(language)
    }

    void outputDir(String dir) {
        setOutputDir(dir)
    }

    void setOutputDir(String dir) {
        this.outputDir = new File(dir)
    }

}
