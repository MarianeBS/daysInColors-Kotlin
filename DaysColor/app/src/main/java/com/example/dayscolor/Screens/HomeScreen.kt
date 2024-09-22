package com.example.dayscolor.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.dayscolor.Navigation.BottomNavItem
import com.example.dayscolor.R

@Composable
fun HomeScreen(navController: NavHostController) {


    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Adiciona o logo
            Image(
                painter = painterResource(id = R.drawable.daysincolors), // Substitua "your_logo" pelo ID do seu logo
                contentDescription = "Logo",
                modifier = Modifier
                    .size(200.dp) // Ajuste o tamanho conforme necessário
                    .padding(bottom = 24.dp) // Espaço abaixo do logo
            )

            Text(
                text = "Como foi seu dia?",
                style = MaterialTheme.typography.headlineMedium
            )


            Spacer(modifier = Modifier.height(24.dp))

            // Botão para enviar o formulário
            Button(
                onClick = {
                    navController.navigate(BottomNavItem.Search.route) // Corrigido aqui

                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF0099), // Cor de fundo
                    contentColor = Color.White // Cor do texto
                ),
                shape = RoundedCornerShape(12.dp) // Bordas arredondadas
            ) {
                Text(text = "Registrar", fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
