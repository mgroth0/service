package matt.service.test


import matt.model.data.dir.YesOrNo
import matt.service.MattService
import matt.service.ServiceHub
import matt.service.action.NoActionAbilities
import matt.service.gradle.NoGradleService
import matt.test.assertions.JupiterTestAssertions.assertRunsInOneMinute
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test

class ServiceTests {

    @Test
    fun initObjects() =
        assertRunsInOneMinute {
            NoActionAbilities
            NoGradleService
        }

    @Test
    fun installMockService() =
        assertRunsInOneMinute {
            MockServiceHub().install(MockService())
        }

    @Test
    fun cannotInstallTwoServicesOnSameHub() =
        assertRunsInOneMinute {
            val hub = MockServiceHub()
            hub.install(MockService())
            assertThrows<Exception> {
                hub.install(MockService())
            }
        }

    @Test
    fun noActionAbilities() =
        assertRunsInOneMinute {
            assertThrows<Exception> {
                NoActionAbilities.input("a")
            }
            assertThrows<Exception> {
                NoActionAbilities.openFile("a")
            }
            assertThrows<Exception> {
                NoActionAbilities.confirm("a")
            }
            assertThrows<Exception> {
                NoActionAbilities.yesOrNo("a")
            }

            assertThrows<Exception> {
                NoActionAbilities.yesOrNoAllowAllCommands<Int>(mapOf())
            }


            assertThrows<Exception> {
                NoActionAbilities.enum(YesOrNo.entries, "a")
            }
        }
}


class MockService : MattService


class MockServiceHub : ServiceHub<MockService>()
