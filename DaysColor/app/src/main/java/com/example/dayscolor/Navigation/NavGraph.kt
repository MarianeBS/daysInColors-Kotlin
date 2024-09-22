package com.example.dayscolor.Navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.dayscolor.Factory.RegistroDiaViewModelFactoryProvider
import com.example.dayscolor.Screens.CadastroScreen
import com.example.dayscolor.Screens.ConsultarScreen
import com.example.dayscolor.Screens.EditarScreen
import com.example.dayscolor.Screens.HomeScreen
import com.example.dayscolor.ViewModel.RegistroDiaViewModel


@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavItem.Home.route) {
        composable(BottomNavItem.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(BottomNavItem.Search.route) {
            val viewModel: RegistroDiaViewModel = viewModel(
                factory = RegistroDiaViewModelFactoryProvider.factory
            )
            CadastroScreen(viewModel = viewModel, navController = navController)
        }
        composable(BottomNavItem.Profile.route) {
            val viewModel: RegistroDiaViewModel = viewModel(
                factory = RegistroDiaViewModelFactoryProvider.factory
            )
            ConsultarScreen(viewModel = viewModel, navController = navController)
        }
        // Adiciona a rota para a tela de edição
        composable("editar/{registroId}") { backStackEntry ->
            val registroId = backStackEntry.arguments?.getString("registroId")?.toInt()
            val viewModel: RegistroDiaViewModel = viewModel(
                factory = RegistroDiaViewModelFactoryProvider.factory
            )
            if (registroId != null) {
                EditarScreen(viewModel = viewModel, registroId = registroId, navController = navController)
            }
        }
    }
}
