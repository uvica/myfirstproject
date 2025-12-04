package com.example.myfirstproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.CardElevation
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

class CardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            cardBody()
        }
    }
}
data class StoredCardItem(
    val title: String,
    val subtitle: String,
    val line1: String,
    val line2: String,
    val color: Color,
    val locked: Boolean = false
)
val sampleCards = listOf(
    StoredCardItem("Dribbble", "Paidxx", "email@email.com", "Password", Color(0xFFFF9800), true),
    StoredCardItem("HJM", "173****8838", "Phone Number", "Verification Code", Color(0xFF42A5F5)),
    StoredCardItem("Tom", "Room 601", "Zhongnan City", "Taoyuan Road…", Color(0xFF9C27B0)),
    StoredCardItem("ICBC", "Debit Card", "1882 ** ** 8695", "12/19", Color(0xFF4CAF50)),
    StoredCardItem("Young", "Notes", "This is the story…", "", Color(0xFFE91E63))
)

@Composable
fun cardBody(){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(sampleCards) { card ->
            StoredCard(card)
        }
    }
}
@Composable
fun StoredCard(card: StoredCardItem){

    Card (
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(
            containerColor = card.color
        ),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    card.title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.weight(1f)
                )

                if (card.locked) {
                    Icon(
                        Icons.Default.Lock,
                        contentDescription = "Locked",
                        tint = Color.White
                    )
                }
            }
            if (card.subtitle.isNotEmpty()) {
                Text(
                    card.subtitle,
                    fontSize = 14.sp,
                    color = Color.White,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
            Spacer(modifier = Modifier.height(12.dp))

            Text(card.line1, color = Color.White)

            if (card.line2.isNotEmpty()) {
                Text(
                    card.line2,
                    color = Color.White,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }

}

@Preview
@Composable
fun PreviewCard() {
    cardBody()
}