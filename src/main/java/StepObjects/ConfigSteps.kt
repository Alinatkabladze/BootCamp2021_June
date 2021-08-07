package StepObject

import com.codeborne.selenide.Configuration

class ConfigSteps {
    init {
        Configuration.startMaximized = true
        Configuration.holdBrowserOpen = false
        Configuration.reopenBrowserOnFail = true
    }
}