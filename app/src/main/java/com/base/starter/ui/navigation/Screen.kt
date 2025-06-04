package com.base.starter.ui.navigation

import kotlinx.serialization.Serializable

sealed interface Screen {
    @Serializable
    data object First : Screen

    @Serializable
    data object Second : Screen
}
