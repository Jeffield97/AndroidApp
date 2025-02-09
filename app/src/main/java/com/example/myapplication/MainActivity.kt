package com.example.myapplication

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.view.UserListScreen
import com.example.myapplication.viewModel.UserViewModel

class MainActivity : ComponentActivity() {
    private val userViewModel: UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val usuarios = List(250) { "User $it" }
            // Eliminamos el contentPadding si no lo necesitamos
            Scaffold(modifier = Modifier.padding(10.dp)) { innerPadding ->
//                UserListScreen(viewModel = userViewModel)
                    ListUsers(
                        innerPadding,
                        usuarios = usuarios
                    );
            }
        }
    }
}

@Composable
fun ListUsers(innerPadding:PaddingValues,usuarios:List<String>) {
    LazyColumn(modifier = Modifier.padding(innerPadding)) {
        // items toma la lista de usuarios y define `usuario` como String
        items(usuarios) { usuario ->
            ListItem(usuario = usuario)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        // Lista de usuarios como List<String>
        val usuarios = List(250) { "Usuario $it" }

        // Scaffold con padding
        Scaffold(modifier = Modifier.padding(10.dp)) { innerPadding ->
            // LazyColumn para mostrar la lista
            ListUsers(
                innerPadding,
                usuarios = usuarios
            );
        }
    }
}


@Composable
fun ListItem(usuario: String) {

    Row (modifier = Modifier.padding(1.dp).background(color = Color.DarkGray).fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
        Image(
            painter = painterResource(id = R.mipmap.among_foreground),
            contentDescription = stringResource(id = R.string.app_name),
            Modifier.size(100.dp)
        )
        Text(
            text = usuario,
            modifier = Modifier.padding(8.dp),
            color = Color.White
        )
    }
}
