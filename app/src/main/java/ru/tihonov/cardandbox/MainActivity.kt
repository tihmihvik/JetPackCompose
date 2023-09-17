package ru.tihonov.cardandbox

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.shapes.Shape
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import ru.tihonov.cardandbox.ui.theme.CardAndBoxTheme

private lateinit var intent: Intent
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            fun gop() {
                intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.google.ru/")
                )
                startActivity(intent)
            }


            @Composable
            fun listItem(name: String, prof: String){
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    shape = RoundedCornerShape(15.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp),
                    border = BorderStroke(1.dp, Color.Black)
                ) {
                    Box {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                                contentDescription = "Картинка",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .padding(5.dp)
                                    .size(64.dp)
                                    .clip(CircleShape)
                            )
                            Column(
                                modifier = Modifier.padding(start = 16.dp)
                            ) {
                                Text(text = name)
                                Text(text = prof)
                                Button(onClick = {gop()}) {
                                    Text(text = "Перейти")
                                }
                            }
                        }
                    }
                }
            }
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
            ) {
                listItem("Miha", "Akter")
                listItem("Miha", "Akter")
                listItem("Miha", "Akter")
                listItem("Miha", "Akter")
                listItem("Miha", "Akter")
                listItem("Miha", "Akter")
                listItem("Miha", "Akter")
                listItem("Miha", "Akter")
                listItem("Miha", "Akter")
                listItem("Miha", "Akter")
            }

        }
    }
}

