import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.agendadeeventos.model.entities.Evento

@Composable
fun AddEventoScreen(
    navController: NavController,
    onSave: (Evento) -> Unit // A função que será chamada para salvar o evento
) {
    // Estado dos campos de entrada
    var nome by remember { mutableStateOf("") }
    var descricao by remember { mutableStateOf("") }
    var data by remember { mutableStateOf("") }
    var local by remember { mutableStateOf("") }

    // Acessando o contexto para o Toast
    val context = LocalContext.current

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Criar Novo Evento", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))
        // Campo de Nome do Evento
        OutlinedTextField(
            value = nome,
            onValueChange = { nome = it },
            label = { Text("Nome do Evento") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        // Campo de Descrição do Evento
        OutlinedTextField(
            value = descricao,
            onValueChange = { descricao = it },
            label = { Text("Descrição do Evento") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        // Campo de Data do Evento
        OutlinedTextField(
            value = data,
            onValueChange = { data = it },
            label = { Text("Data do Evento") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        // Campo de Local do Evento
        OutlinedTextField(
            value = local,
            onValueChange = { local = it },
            label = { Text("Local do Evento") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botão de Salvar Evento
        Button(
            onClick = {
                if (nome.isNotEmpty() && descricao.isNotEmpty() && data.isNotEmpty() && local.isNotEmpty()) {
                    // Criação do evento
                    val novoEvento = Evento(
                        id = eventos.size + 1, // Usando o tamanho da lista como id (garante ID único)
                        nome = nome,
                        descricao = descricao,
                        data = data,
                        local = local
                    )
                    onSave(novoEvento) // Passa o novo evento para ser salvo na lista de eventos
                    navController.navigate("eventos") {  // Navega para a tela de eventos
                        popUpTo("eventos") { inclusive = true }
                    }
                } else {
                    Toast.makeText(context, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Salvar Evento")
        }
    }
}