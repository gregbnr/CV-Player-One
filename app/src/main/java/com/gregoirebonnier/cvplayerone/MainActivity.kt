package com.gregoirebonnier.cvplayerone

import android.content.res.Configuration.UI_MODE_TYPE_NORMAL
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.gregoirebonnier.cvplayerone.application.CVPlayerOneApplication
import com.gregoirebonnier.cvplayerone.ui.ExperienceScreen
import com.gregoirebonnier.cvplayerone.ui.NavigationItem
import com.gregoirebonnier.cvplayerone.ui.ProfileScreen
import com.gregoirebonnier.cvplayerone.ui.SkillScreen
import com.gregoirebonnier.cvplayerone.ui.theme.CVPlayerOneTheme
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CVPlayerOneApplication()
        setContent {
            CVPlayerOneTheme {
                MainScreen()
            }
        }
    }

    val mainViewModel by inject<MainViewModel>()
}


/**
 *
 */
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },
        backgroundColor = MaterialTheme.colors.background
    ) {
        NavigationGraph(navController = navController)
    }
}


@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Profile,
        NavigationItem.Experiences,
        NavigationItem.Skills
    )
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.surface,
        contentColor = MaterialTheme.colors.primary
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painterResource(id = item.icon),
                        contentDescription = LocalContext.current.getString(item.title),
                        modifier = Modifier,
                    )
                },
                label = { Text(text = LocalContext.current.getString(item.title)) },
                selectedContentColor = MaterialTheme.colors.primary,
                unselectedContentColor = MaterialTheme.colors.background,
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {

                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Profile.route) {
        composable(NavigationItem.Profile.route) {
            ProfileScreen().MainScreen()
        }
        composable(NavigationItem.Experiences.route) {
            ExperienceScreen().MainScreen()
        }
        composable(NavigationItem.Skills.route) {
            SkillScreen().MainScreen()
        }
    }
}


@Preview(showBackground = true, uiMode = UI_MODE_TYPE_NORMAL)
@Composable
fun DefaultPreview() {
    CVPlayerOneTheme {
        MainScreen()
    }
}