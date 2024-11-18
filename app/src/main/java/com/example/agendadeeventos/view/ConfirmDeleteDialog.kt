package com.example.agendadeeventos.view

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun ConfirmDeleteDialog(
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(text = "Confirmar Exclusão")
        },
        text = {
            Text("Tem certeza que deseja excluir este item?")
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirm() // Chama a ação de exclusão
                    onDismiss() // Fecha o dialog
                }
            ) {
                Text("Confirmar")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancelar")
            }
        }
    )
}