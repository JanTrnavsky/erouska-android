package cz.covid19cz.erouska.screenObject

import androidx.test.espresso.matcher.ViewMatchers.withClassName
import androidx.test.espresso.matcher.ViewMatchers.withText
import cz.covid19cz.erouska.R
import cz.covid19cz.erouska.helpers.RETRY_TIMEOUT
import cz.covid19cz.erouska.helpers.checkDisplayed
import cz.covid19cz.erouska.helpers.checkMatchesString
import cz.covid19cz.erouska.helpers.click
import org.awaitility.Awaitility.await
import org.hamcrest.CoreMatchers.endsWith
import java.util.concurrent.TimeUnit

object HomeScreen {

    fun isErouskaActive() {

        await().ignoreExceptions().atMost(RETRY_TIMEOUT, TimeUnit.SECONDS).untilAsserted {
            checkDisplayed(R.id.app_running_title)
        }
    }
}