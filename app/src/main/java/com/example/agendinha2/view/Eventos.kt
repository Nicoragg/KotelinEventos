package com.example.agendinha2.view

import kotlin.apply

@androidx.compose.runtime.Composable
fun Eventos(navController: androidx.navigation.NavController) {

}

fun compartilharEvento(context: android.content.Context, evento: Evento) {
    val compartilharIntent = android.content.Intent(android.content.Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(android.content.Intent.EXTRA_SUBJECT, "Evento: ${evento.titulo}")
        putExtra(android.content.Intent.EXTRA_TEXT, "Descrição: ${evento.descricao}\nLocal: ${evento.local}\nData e Hora: ${evento.dataHora}")
    }
    context.startActivity(
        android.content.Intent.createChooser(
            compartilharIntent,
            "Compartilhar via"
        )
    )
}
