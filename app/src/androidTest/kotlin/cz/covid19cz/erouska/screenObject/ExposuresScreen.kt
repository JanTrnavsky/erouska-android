package cz.covid19cz.erouska.screenObject

import cz.covid19cz.erouska.R
import cz.covid19cz.erouska.helpers.checkDisplayed
import cz.covid19cz.erouska.helpers.checkMatchesString

object ExposuresScreen {
    private const val NO_EXP_TEXT = "V posledních 14 dnech nebyla ve vaší blízkosti žádná osoba s potvrzenou nákazou virem COVID-19"
    private const val WE_WILL_NOTIFY_TEXT = "Na rizikové setkání vás upozorníme pomocí oznámení."

    fun verifyNoExposure() {
        checkDisplayed(R.id.no_exposures_img)
        checkMatchesString(R.id.spread_prevention_container, NO_EXP_TEXT)
        checkMatchesString(R.id.no_exposures_body, WE_WILL_NOTIFY_TEXT)
    }

    fun verifyPassedExposure() {
        checkDisplayed(R.id.no_exposures_img)
        checkMatchesString(R.id.spread_prevention_container, NO_EXP_TEXT)
        checkMatchesString(R.id.earlier_exposures_container, WE_WILL_NOTIFY_TEXT)
        checkDisplayed(R.id.earlier_exposures_container)
    }
}