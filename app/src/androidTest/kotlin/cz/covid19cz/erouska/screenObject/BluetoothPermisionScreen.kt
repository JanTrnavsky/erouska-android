package cz.covid19cz.erouska.screenObject

import android.os.Build
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiSelector
import cz.covid19cz.erouska.R
import cz.covid19cz.erouska.helpers.checkDisplayed
import cz.covid19cz.erouska.helpers.click

object BluetoothPermissionScreen {
    private val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    fun allowPermission() {
        checkDisplayed(R.id.bluetooth_onboard_title)
        click(R.id.enable_bluetooth_btn)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val allowLocation = findUiObject("com.android.permissioncontroller:id/permission_allow_foreground_only_button")
            allowLocation.click()
        } else {
            val allowButton = findUiObject("com.android.packageinstaller:id/permission_allow_button")
            allowButton.click()
        }
    }

    private fun findUiObject(resourceId: String) = device.findObject(UiSelector().resourceId(resourceId))
}