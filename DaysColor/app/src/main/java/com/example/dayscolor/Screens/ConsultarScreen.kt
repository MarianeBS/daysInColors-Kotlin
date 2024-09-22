package com.example.dayscolor.Screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.dayscolor.RoomDB.RegistroDia
import com.example.dayscolor.ViewModel.RegistroDiaViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@Composable
fun ConsultarScreen(viewModel: RegistroDiaViewModel, navController: NavHostController) {
    val registros by viewModel.getAllRegistros().collectAsState(initial = emptyList())

    // Se não houver registros, exibe uma mensagem
    if (registros.isEmpty()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Não há registros disponíveis.",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Gray
            )
        }
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(registros) { registro ->
                RegistroCard(
                    registro = registro,
                    onEditClick = {
                        navController.navigate("editar/${registro.id}") // Navega para a tela de edição com o ID do registro
                    },
                    onDeleteClick = { viewModel.deleteRegistro(registro) }
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}@Composable
fun RegistroCard(
    registro: RegistroDia,
    onEditClick: () -> Unit,
    onDeleteClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(12.dp),
        border = BorderStroke(2.dp, Color(0xFFFF0099)),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF3E5F5)
        )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .background(Color(0xFFEBD9EF), shape = RoundedCornerShape(16.dp))
                    .border(
                        width = 2.dp, // Ajuste a largura da borda conforme necessário
                        color = Color(0xFFFF0099), // Cor da borda
                        shape = RoundedCornerShape(12.dp) // Use o mesmo shape para borda
                    )
            ) {
                Text(
                    text = "Registro do Dia",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(16.dp),
                    color = Color(0xFFFF0099)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Data: ${registro.data}",
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 23.sp),
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFF0099)
            )

            Spacer(modifier = Modifier.height(8.dp))

            val cor = getColorByLabel(registro.cor)

            Text(
                text = "Cor: ${registro.cor}",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = cor
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Motivo: ${registro.motivo}",
                color = Color(0xFFFF0099),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Medium,
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Avaliação: ${registro.avaliacao}",
                style = MaterialTheme.typography.bodyLarge,
                color = Color(0xFFFF0099),
                fontWeight = FontWeight.Medium,
            )

            Spacer(modifier = Modifier.height(5.dp))

            // Botões de Editar e Excluir
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.End
            ) {
                IconButton(onClick = { onEditClick() }, modifier = Modifier.padding(end = 8.dp)) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Editar",
                        tint = Color(0xFFFF0099)
                    )
                }

                IconButton(onClick = { onDeleteClick() }) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Excluir",
                        tint = Color(0xFFFF0099)
                    )
                }
            }
        }
    }
}


// Função que retorna a cor baseada na descrição textual
fun getColorByLabel(label: String): Color {
    return when (label) {
        "Triste" -> Color(0xFF0008D1)
        "Estressante" -> Color(0xFFFF0303)
        "Animado" -> Color(0xFFFFD809)
        "Sem Graça" -> Color(0xFF737373)
        "Tranquilo" -> Color(0xFF7ED957)
        "Solitário" -> Color.Black
        "Engraçado" -> Color(0xFFFF914D)
        "Frustrante" -> Color(0xFFFF66C4)
        else -> Color.Gray
    }
}
