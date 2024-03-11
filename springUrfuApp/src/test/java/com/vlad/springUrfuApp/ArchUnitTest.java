package com.vlad.springUrfuApp;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.Architectures;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

/**
 * Тест для проверки связи между слоями для выбранной архитектуры.
 * Данный тест отпеределяет, что нет связей между слоем api
 * и слоем persistence напрямую, минуя слой service, наличие которых,
 * является нарушением.
 * */
@AnalyzeClasses(packages = "com.vlad.springUrfuApp")
public class ArchUnitTest {
    @Test
    public void myLayerAccessTest() {

        JavaClasses importedClasses = new ClassFileImporter()
                .importPackages("com.vlad.springUrfuApp.api");

        ArchRule apiRule= noClasses()
                .should()
                .accessClassesThat()
                .resideInAPackage("com.vlad.springUrfuApp.persistence");

        apiRule.check(importedClasses);
    }

}
