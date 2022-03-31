package hn.edu.ujcv.pdm_2022_i_i3_2018120245

import platform.UIKit.UIDevice

actual class Platform actual constructor() {
    actual val platform: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}