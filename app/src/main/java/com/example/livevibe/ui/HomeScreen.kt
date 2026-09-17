package com.example.livevibe.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val darkBackground = Color(0xFF121212)
    val cardBackground = Color(0xFF1E1E1E)
    val purplePrimary = Color(0xFF8A2BE2)
    val purpleGradient = Brush.horizontalGradient(
        colors = listOf(Color(0xFF6C63FF), Color(0xFF8A2BE2), Color(0xFF9C27B0))
    )

    Scaffold(
        containerColor = darkBackground,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "LiveVibe",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* Ação de Pesquisa */ }) {
                        Icon(Icons.Default.Search, contentDescription = "Buscar", tint = Color.White)
                    }
                },
                actions = {
                    IconButton(onClick = { /* Ação de Notificações */ }) {
                        Icon(Icons.Default.Notifications, contentDescription = "Notificações", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = darkBackground)
            )
        },
        bottomBar = {
            // Barra de Navegação Inferior Customizada
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp),
                    shape = RoundedCornerShape(32.dp),
                    color = Color(0xFF1A1A1A),
                    shadowElevation = 8.dp
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = { }) {
                            Icon(Icons.Default.Home, contentDescription = "Home", tint = purplePrimary)
                        }
                        // Espaço para o botão central flutuante
                        Spacer(modifier = Modifier.width(48.dp))
                        IconButton(onClick = { }) {
                            Icon(Icons.Default.Person, contentDescription = "Perfil", tint = Color.Gray)
                        }
                    }
                }

                // Botão Central Flutuante (+)
                FloatingActionButton(
                    onClick = { /* Adicionar show/memória */ },
                    containerColor = purplePrimary,
                    contentColor = Color.White,
                    shape = CircleShape,
                    modifier = Modifier.size(56.dp)
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Adicionar", modifier = Modifier.size(28.dp))
                }
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Banner Comunidade LiveVibe
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Transparent)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(purpleGradient)
                            .padding(20.dp)
                    ) {
                        Column {
                            Text(
                                text = "Comunidade LiveVibe",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Veja o que os fãs estão postando",
                                color = Color.White.copy(alpha = 0.8f),
                                fontSize = 14.sp
                            )
                        }
                    }
                }
            }

            // Cards de Estatísticas (Shows, Artistas, Festivais)
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    StatCard(modifier = Modifier.weight(1f), title = "Shows", count = "0", bg = cardBackground)
                    StatCard(modifier = Modifier.weight(1f), title = "Artistas", count = "4", bg = cardBackground)
                    StatCard(modifier = Modifier.weight(1f), title = "Festivais", count = "0", bg = cardBackground)
                }
            }

            // Botão Explorar Lineups
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF251C3B))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "⛺ Explorar Lineups de Festivais",
                            color = Color.White,
                            fontWeight = FontWeight.Medium
                        )
                        Text(text = "›", color = Color.White, fontSize = 20.sp)
                    }
                }
            }

            // Título Contagem Regressiva
            item {
                Text(
                    text = "Contagem Regressiva",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }

            // Carrossel de Contagem Regressiva
            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    item {
                        CountdownCard(
                            artist = "Harry Styles",
                            location = "Estádio do MorumBIS",
                            timeLeft = "Faltam 10 dias",
                            bgColor = cardBackground
                        )
                    }
                    item {
                        CountdownCard(
                            artist = "BTS",
                            location = "Estádio do MorumBIS",
                            timeLeft = "Faltam 109 dias",
                            bgColor = cardBackground
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun StatCard(modifier: Modifier = Modifier, title: String, count: String, bg: Color) {
    Card(
        modifier = modifier.height(90.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = bg)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = count, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Spacer(modifier = Modifier.height(2.dp))
            Text(text = title, color = Color.Gray, fontSize = 12.sp)
        }
    }
}

@Composable
fun CountdownCard(artist: String, location: String, timeLeft: String, bgColor: Color) {
    Card(
        modifier = Modifier
            .width(180.dp)
            .height(220.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = bgColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.DarkGray)
            )
            Column {
                Text(text = artist, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                Text(text = location, color = Color.Gray, fontSize = 11.sp, maxLines = 1)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = timeLeft, color = Color(0xFFB388FF), fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
            }
        }
    }
}
