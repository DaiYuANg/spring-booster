package org.nectar.visualvm.web

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import oshi.SystemInfo

class HardwareService : KoinComponent {
    private val si: SystemInfo by inject<SystemInfo>()
}
