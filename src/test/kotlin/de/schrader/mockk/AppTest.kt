package de.schrader.mockk

import io.mockk.every
import io.mockk.mockk
import org.junit.Test

class Dependency {
    fun calculateResult() = 42
}

class Subject(dependency: Dependency) {
    val result = dependency.calculateResult()
}

class AppTest {
    @Test fun mockDependency() {
        val dependencyMock = mockk<Dependency>()
        every { dependencyMock.calculateResult() } returns 1337
        val subject = Subject(dependencyMock)
        assert(subject.result == 1337)
    }
}
