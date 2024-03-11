package com.vlad.springUrfuApp;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.Architectures;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;


public class ArchTest {

    private final JavaClasses classes = new ClassFileImporter().importPackages("com.vlad.springUrfuApp");

    @Test
    void testArchitecture() {
        ArchRule rule = Architectures.layeredArchitecture()
                .consideringAllDependencies()
                .layer("Api").definedBy("..api..")
                .layer("Service").definedBy("..service..")
                .layer("Persistence").definedBy("..persistence..")
                // Add constraints
                .whereLayer("Api").mayNotBeAccessedByAnyLayer()
                .whereLayer("Service").mayOnlyBeAccessedByLayers("Api")
                .whereLayer("Persistence").mayOnlyBeAccessedByLayers("Service");
        rule.check(classes);
    }

    @Test
    void testApiLayerDoesNotContainPersistence() {
        ArchRule rule = noClasses().that().resideInAPackage("..api..")
                .should().accessClassesThat().resideInAPackage("..persistence..");

        rule.check(classes);
    }
}