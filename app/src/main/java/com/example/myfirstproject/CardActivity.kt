package com.example.myfirstproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class CardDetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FrontPageCard()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FrontPageCard() {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text("Card", fontSize = 28.sp, fontWeight = FontWeight.Bold)
                        Text(
                            "Simple and easy to use app",
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {

            // ROW 1
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CategoryBox("Text", Color(0xFFF44336), R.drawable.text  )
                CategoryBox("Address", Color(0xFF03A9F4), R.drawable.address)           }

            // ROW 2
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CategoryBox("Character", Color(0xFFFFEB3B), R.drawable.character)
                CategoryBox("Bank Card", Color(0xFF673AB7), R.drawable.bankcard)
            }

            // ROW 3
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CategoryBox("Password", Color(0xFFFF9800), R.drawable.password)
                CategoryBox("Logistics", Color(0xFF009688), R.drawable.logistics)
            }

            Spacer(modifier = Modifier.height(24.dp))

            CategoryBox(
                name = "Settings",
                color = Color.LightGray,
                icon = R.drawable.outline_settings_24,
                isFullWidth = true
            )
        }
    }
}

@Composable
fun CategoryBox(
    name: String,
    color: Color,
    icon: Int,
    isFullWidth: Boolean = false
) {
    Box(
        modifier = Modifier
            .then(
                if (isFullWidth) Modifier.fillMaxWidth() else Modifier.width(160.dp)
            )
            .height(120.dp)
            .background(Color.White, RoundedCornerShape(16.dp))
            .clickable { }
            .padding(16.dp),
        contentAlignment = Alignment.TopStart
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = name,
                modifier = Modifier.size(72.dp)
            )

            Text(
                text = name,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFrontPageCard() {
    FrontPageCard()
}
