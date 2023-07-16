package de.timmi6790.utility;

import static org.assertj.core.api.Assertions.assertThat;

import lombok.Getter;
import org.junit.jupiter.api.Test;

class ModuleManagerTest {
    @Test
    void getModule() {
        final ModuleManager moduleManager = new ModuleManager();

        final Class<TestModule> testModuleClass = TestModule.class;
        assertThat(moduleManager.getModule(testModuleClass)).isNotPresent();

        moduleManager.addModules(false, new TestModule());

        assertThat(moduleManager.getModule(testModuleClass)).isPresent();
    }

    @Test
    void addModules() {
        final ModuleManager moduleManager = new ModuleManager();

        final Class<TestModule> testModuleClass = TestModule.class;
        final Class<TestModule1> testModule1Class = TestModule1.class;

        assertThat(moduleManager.getModule(testModuleClass)).isNotPresent();
        assertThat(moduleManager.getModule(testModule1Class)).isNotPresent();

        moduleManager.addModules(false, new TestModule(), new TestModule1());

        assertThat(moduleManager.getModule(testModuleClass)).isPresent();
        assertThat(moduleManager.getModule(testModule1Class)).isPresent();
    }

    @Test
    void addModule() {
        final ModuleManager moduleManager = new ModuleManager();

        final Class<TestModule> testModuleClass = TestModule.class;
        assertThat(moduleManager.getModule(testModuleClass)).isNotPresent();

        moduleManager.addModules(false, new TestModule());

        assertThat(moduleManager.getModule(testModuleClass)).isPresent();
    }

    @Test
    void addModuleWithEventRegister() {
        final ModuleManager moduleManager = new ModuleManager();

        final EventTestModule eventTestModule = new EventTestModule();
        assertThat(eventTestModule.getEventCallCount()).isZero();

        moduleManager.addModules(true, eventTestModule);

        assertThat(eventTestModule.getEventCallCount()).isEqualTo(1);
    }

    @Test
    void initialize() {
        final ModuleManager moduleManager = new ModuleManager();

        final EventTestModule eventTestModule = new EventTestModule();
        assertThat(eventTestModule.getEventCallCount()).isZero();

        moduleManager.addModules(false, eventTestModule);

        assertThat(eventTestModule.getEventCallCount()).isZero();

        moduleManager.initialize();

        assertThat(eventTestModule.getEventCallCount()).isEqualTo(1);
    }

    private static class TestModule implements Module {
        // Nothing to do
    }

    private static class TestModule1 implements Module {
        // Nothing to do
    }

    private static class EventTestModule implements Module {
        @Getter
        private int eventCallCount = 0;

        @Override
        public void registerEvents() {
            this.eventCallCount++;
        }
    }
}
