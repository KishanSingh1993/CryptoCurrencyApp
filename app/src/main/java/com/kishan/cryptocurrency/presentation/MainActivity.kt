package com.kishan.cryptocurrency.presentation

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kishan.cryptocurrency.presentation.coin_detail.CoinDetailsScreen
import com.kishan.cryptocurrency.presentation.coin_list.CoinListScreen
import com.kishan.cryptocurrency.presentation.ui.CryptoCurrencyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoCurrencyAppTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.SplashScreen.route
                    ){
                        composable(Screen.SplashScreen.route){
                            SplashScreen(navController = navController)
                        }
                        composable(
                            route = Screen.CoinListScreen.route
                        ){
                            CoinListScreen(navController)
                    }
                        composable(
                            route = Screen.CoinDetailsScreen.route + "/{coinId}"
                        ){
                            CoinDetailsScreen()
                        }
                    }

                }
            }
        }
    }
}


