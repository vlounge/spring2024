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
                .layer("Extern").definedBy("..extern..")
                .layer("Domain").definedBy("..domain..")
                .layer("App").definedBy("..app..")
                // Add constraints
                .whereLayer("Extern").mayNotBeAccessedByAnyLayer()
                .whereLayer("App").mayOnlyBeAccessedByLayers("Extern")
                .whereLayer("Domain").mayOnlyBeAccessedByLayers("App","Extern");
        rule.check(classes);
    }

    @Test
    void testDomainLayerDoesNotContainExternal() {
        ArchRule rule = noClasses().that().resideInAPackage("..domain..")
                .should().accessClassesThat().resideInAPackage("..extern..");

        rule.check(classes);
    }
    
    @Test
    void testDomainLayerDoesNotContainApp() {
        ArchRule rule = noClasses().that().resideInAPackage("..domain..")
                .should().accessClassesThat().resideInAPackage("..app..");

        rule.check(classes);
    }
}