package com.example.myfirstproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ProfileBody()
        }
    }
}

@Composable
fun ProfileBody() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        // Top Bar
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                painter = painterResource(R.drawable.baseline_arrow_back_ios_24),
                contentDescription = null
            )
            Text("Uvica_Shrestha")
            Icon(
                painter = painterResource(R.drawable.baseline_arrow_back_ios_24),
                contentDescription = null
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Profile Stats
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = null
            )

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("100K")
                Text("Posts")
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("1M")
                Text("Followers")
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("50")
                Text("Following")
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Bio
        Column(modifier = Modifier.padding(start = 10.dp)) {
            Text("Bio")
            Text("Follow me")
            Text("Hello")
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Email Button
        OutlinedButton(onClick = {}) {
            Text("Email")
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Follow Button
        Button(
            onClick = {},
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(2.dp, Color.Magenta),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color.Black
            )
        ) {
            Text("Follow")
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Recently Played Header
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                "Recently Played",
                modifier = Modifier.weight(1f)
            )

            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.End
            ) {
                Icon(
                    painter = painterResource(R.drawable.baseline_arrow_forward_ios_24),
                    contentDescription = null
                )
                Icon(
                    painter = painterResource(R.drawable.baseline_arrow_back_ios_24),
                    contentDescription = null
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfile() {
    ProfileBody()
}
