package id.ac.unpas.naviapp

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

enum class MainTab(
    @StringRes val title: Int,
    val icon: ImageVector
) {

    DASHBOARD(R.string.dashboard, Icons.Filled.Home),
    PROFILE(R.string.profile, Icons.Filled.Person);

    companion object {
        fun getTabFromResource(@StringRes resource: Int): MainTab {
            return when (resource) {
                R.string.profile -> PROFILE
                else -> DASHBOARD
            }
        }
    }
}
