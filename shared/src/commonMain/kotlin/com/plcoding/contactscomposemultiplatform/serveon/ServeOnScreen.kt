package com.plcoding.contactscomposemultiplatform.serveon

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.plcoding.contactscomposemultiplatform.Koin
import com.plcoding.contactscomposemultiplatform.core.data.Assignment
import com.plcoding.contactscomposemultiplatform.core.presentation.LoadingSmall
import com.plcoding.contactscomposemultiplatform.core.viewModelOf
import com.plcoding.contactscomposemultiplatform.login.presentation.LoginScreen
import kotlinx.coroutines.delay
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.random.Random


class ServeOnScreen : Screen {
    override val key: ScreenKey
        get() = uniqueScreenKey

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel = Koin().viewModelOf("serve-on-screen", ::ServeOnViewModel)
        val employee by viewModel.employee.collectAsState(null)
        val todayServeOn by viewModel.serveOnTodayApiStateFlow.collectAsState(ServeOnTodayApiState.Default)

        var time by remember {
            mutableStateOf(Clock.System.now())
        }
        val localDate = time.toLocalDateTime(TimeZone.currentSystemDefault())

        val greetingText by remember {
            derivedStateOf {
                when (localDate.hour) {
                    in 4..10 -> "Selamat Pagi"
                    in 11..14 -> "Selamat Siang"
                    in 15..16 -> "Selamat Sore"
                    else -> "Selamat Malam"
                }
            }
        }

        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 21.dp)
                        .padding(top = 40.dp)
                ) {
                    Text(
                        "$greetingText, ${employee?.username}",
                        modifier = Modifier.fillMaxWidth(),
                        fontWeight = FontWeight.Black,
                        fontSize = 24.sp,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 2,
                    )
                    QuotesOfTheDay()
                }
                Column(
                    modifier = Modifier.height(400.dp),
                    verticalArrangement = Arrangement.Center,
                ) {
                    TimeDisplay(localDate)
                }

                when (todayServeOn) {
                    ServeOnTodayApiState.Loading -> {
                        LoadingSmall()
                    }

                    ServeOnTodayApiState.LoginExpire -> {
                        navigator.replaceAll(LoginScreen())
                    }

                    is ServeOnTodayApiState.Success -> {
                        val success = todayServeOn as ServeOnTodayApiState.Success

                        if (success.listOfServeOn.isNotEmpty()) {
                            ServeButton("Serve Off") {

                            }
                        } else {
                            Assignment(
                                list = success.assignment ?: listOf(),
                                otherServeOn = {

                                }, assignmentServeOn = {

                                })
                        }
                    }

                    is ServeOnTodayApiState.Error -> {
                        ReloadApiButton {
                            viewModel.onEvent(ServeOnEvent.ReloadTodayServeOn)
                        }
                    }

                    else -> {}
                }

                Disclaimer()
                RoadMap()
            }
        }

        LaunchedEffect(Unit) {
            while (true) {
                delay(1000)
                time = Clock.System.now()
            }
        }
    }

    @Composable
    private fun Disclaimer() {
        Column(
            modifier = Modifier.padding(horizontal = 21.dp).padding(top = 80.dp)
        ) {
            Text(
                text = "Disclaimer", modifier = Modifier.padding(bottom = 10.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text("1. Aplikasi ini telah dikembangkan menggunakan Kotlin Multiplatform (KMM) yang dapat dijalankan pada platform Android dan iOS, dengan potensi penggembangan di platform Desktop.")
            Box(Modifier.height(10.dp))
            Text("2. Tujuan utama pembuatan aplikasi ini adalah untuk melakukan penelitian terkait efektivitas dan potensi penghematan biaya yang dapat diberikan oleh KMM dalam pengembangan aplikasi dengan Kotlin.")
            Box(Modifier.height(10.dp))
            Text("3. Aplikasi ini dibuat melalui proses reverse engineering dari situs web iserve-agit.com. Harap dicatat bahwa logika bisnis dalam aplikasi ini mungkin tidak sepenuhnya sesuai dengan logika bisnis normal yang terdapat pada situs web tersebut.")
        }
    }

    @Composable
    private fun RoadMap() {
        Column(
            modifier = Modifier.padding(horizontal = 21.dp).padding(top = 40.dp)
        ) {
            Text(
                text = "Road Map", modifier = Modifier.padding(bottom = 10.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Row {
                Checkbox(true, null, enabled = false)
                Text("Basic Login")
            }
            Row {
                Checkbox(true, null, enabled = false)
                Text("Status Serve On / OFF")
            }
            Row {
                Checkbox(false, null, enabled = false)
                Text("Basic Serve On")
            }
            Row {
                Checkbox(false, null, enabled = false)
                Text("Basic Serve Off")
            }
            Row {
                Checkbox(false, null, enabled = false)
                Text("Assignment based Serve On")
            }
            Row {
                Checkbox(false, null, enabled = false)
                Text("Assignment based Serve Off")
            }
            Row {
                Checkbox(false, null, enabled = false)
                Text("Biormetric Login")
            }
            Row {
                Checkbox(false, null, enabled = false)
                Text("Notification To Serve On")
            }
            Row {
                Checkbox(false, null, enabled = false)
                Text("Notification To Serve Off")
            }
            Row {
                Checkbox(false, null, enabled = false)
                Text("Location Based Login")
            }
        }
    }

    @Composable
    private fun QuotesOfTheDay() {
        val quotes = listOf(
            "Believe you can, and you're embracing the power of self-confidence.",
            "Believe you can, and you're embarking on a journey of achievement.",
            "Believe you can, and you're striving for excellence.",
            "Believe you can, and you're opening doors to opportunity.",
            "Believe you can, and you're embracing the journey ahead.",
            "Believe you can, and you're reaching for the stars.",
            "Believe you can, and you're unleashing your full potential.",
            "Believe you can, and you've already taken the first step.",
            "Believe you can, and you're making the impossible possible.",
            "Believe you can, and you're halfway to success.",
            "Believe you can, and you're halfway there."
        )


        val randomQuoteSeed = Random(Clock.System.now().toEpochMilliseconds())
        val randomQuoteIndex = randomQuoteSeed.nextInt(quotes.size)
        Text(
            text = quotes[randomQuoteIndex],
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 10.dp)
        )
    }

    @Composable
    private fun ReloadApiButton(onReload: () -> Unit) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Gagal mengambil data")
            Button(onClick = {
                onReload()
            }) {
                Text("Mengulang")
            }
        }
    }

    @Composable
    private fun ServeButton(title: String, onServeClicked: () -> Unit) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {
                onServeClicked()
            }) {
                Text(
                    title,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }

    @Composable
    private fun TimeDisplay(localDateTime: LocalDateTime) {
        val displayDay = localDateTime.dayOfWeek.toString()
        val displayMonth = localDateTime.month.toString()
        val hour = localDateTime.hour
        val displayHour = if (hour < 10) {
            "0$hour"
        } else {
            hour.toString()
        }

        val timeMark = if (hour > 11) {
            "PM"
        } else {
            "AM"
        }

        val minute = localDateTime.minute
        val displayMinute = if (minute < 10) {
            "0$minute"
        } else {
            minute.toString()
        }

        val timeDisplay = buildString {
            append(displayHour)
            append(":")
            append(displayMinute)
            append(" ")
            append(timeMark)
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row {
                Text(
                    text = "$displayDay,",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Black,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = " ${localDateTime.dayOfMonth} $displayMonth ${localDateTime.year}",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Text(
                text = timeDisplay,
                fontSize = 40.sp,
                fontWeight = FontWeight.Black
            )
        }
    }


    @Composable
    private fun Assignment(
        list: List<Assignment>,
        otherServeOn: () -> Unit,
        assignmentServeOn: (data: Assignment) -> Unit
    ) {
        if (list.isEmpty()) {
            ServeButton("Serve On") {
                otherServeOn()
            }
        } else {
            Column(
                modifier = Modifier.padding(horizontal = 21.dp)
            ) {
                Text(
                    text = "Assignment For You", modifier = Modifier
                        .padding(horizontal = 18.dp)
                        .padding(bottom = 10.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                list.forEach {
                    Card {
                        Column(
                            horizontalAlignment = Alignment.End,
                            modifier = Modifier.padding(vertical = 17.dp, horizontal = 14.dp)
                        ) {
                            Text(
                                text = it.name ?: "-",
                                style = MaterialTheme.typography.titleMedium
                            )

                            Button(onClick = {
                                assignmentServeOn(it)
                            }) {
                                Text(text = "Serve On")
                            }
                        }
                    }
                }
            }
        }
    }
}