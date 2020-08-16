package cz.covid19cz.erouska.tests

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import cz.covid19cz.erouska.screenObject.*
import cz.covid19cz.erouska.testRules.DisableAnimationsRule
import cz.covid19cz.erouska.ui.main.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ActivationTest {

    @get:Rule
    val disableAnimationsRule = DisableAnimationsRule()

    @get:Rule
    val activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun activation() {
        // activation
        WelcomeScreen.startActivation()
        BluetoothPermissionScreen.allowPermission()

        BatterySaverInfoScreen.finish()
        HomeScreen.isErouskaActive()

        NavigationPanelScreen.goToMyDataTab()

        // verify contacts screen and links there
        NavigationPanelScreen.goToContactsTab()
        ContactsScreen.verifyLinks()
    }

    /**
     * check links on welcome screen, help screen and about us screen
     */
    @Test
    fun linkTest() {
        // check if welcome screen link works
        WelcomeScreen.checkAuditLink()
        WelcomeScreen.goToHelpScreen()

        // check if Help screen link works
        HelpScreen.verifyLinks()
        HelpScreen.goToAboutApp()
        // verify one LinkedIn link on about app screen
        AboutAppScreen.verifyLinkedInLink()
    }
}