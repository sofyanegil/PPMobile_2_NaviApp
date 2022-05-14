package id.ac.unpas.naviapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Main() {
    val navController = rememberNavController()
    val title = remember { mutableStateOf(MainTab.DASHBOARD.name) }
    val tabs = MainTab.values()

    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 6.dp,
                backgroundColor = Color.White,
                modifier = Modifier.height(58.dp)
            )
            {
                Text(
                    text = title.value,
                    modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.CenterVertically),
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
        },

        bottomBar = {
            BottomNavigation(
                elevation = 15.dp
            ) {
                tabs.forEach { tab ->
                    BottomNavigationItem(
                        selected = tab.name == title.value,
                        selectedContentColor = Color.White, modifier = Modifier.padding(8.dp),
                        unselectedContentColor = Color.Red,
                        icon = {
                            Icon(
                                imageVector = tab.icon,
                                contentDescription = null,
                            )
                        },
                        label = {
                            Text(
                                modifier = Modifier.padding(5.dp),
                                text = stringResource(id = tab.title),
                                fontWeight = FontWeight.Bold,
                            )
                        },
                        onClick = {
                            navController.navigate(MainTab.getTabFromResource(tab.title).name)
                            title.value = MainTab.getTabFromResource(tab.title).name
                        },
                    )
                }
            }
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NavHost(navController = navController, startDestination = "dashboard") {
                composable("dashboard") { Dashboard() }
                composable("profile") { Profile() }
            }
        }
    }
}


