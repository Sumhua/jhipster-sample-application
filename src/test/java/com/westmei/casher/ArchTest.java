package com.westmei.casher;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.westmei.casher");

        noClasses()
            .that()
            .resideInAnyPackage("com.westmei.casher.service..")
            .or()
            .resideInAnyPackage("com.westmei.casher.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..com.westmei.casher.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
