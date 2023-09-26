package com.example.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomePage()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage() {
    CalculatorTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            Scaffold(
                content = {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(5.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        ButtonRowWidget {
                            ButtonWidget(
                                label = "1",
                                modifier = Modifier.weight(1f),
                                startPadding = 10.dp
                            )
                            ButtonWidget(
                                label = "2",
                                modifier = Modifier.weight(1f), horizontalPadding = 5.dp
                            )
                            ButtonWidget(
                                label = "3",
                                modifier = Modifier.weight(1f),
                                endPadding = 10.dp
                            )
                        }

                        ButtonRowWidget {
                            ButtonWidget(
                                label = "4",
                                modifier = Modifier.weight(1f),
                                startPadding = 10.dp
                            )
                            ButtonWidget(
                                label = "5",
                                modifier = Modifier.weight(1f), horizontalPadding = 5.dp
                            )
                            ButtonWidget(
                                label = "6",
                                modifier = Modifier.weight(1f),
                                endPadding = 10.dp
                            )
                        }

                        ButtonRowWidget {
                            ButtonWidget(
                                label = "7",
                                modifier = Modifier.weight(1f),
                                startPadding = 10.dp
                            )
                            ButtonWidget(
                                label = "8",
                                modifier = Modifier.weight(1f), horizontalPadding = 5.dp
                            )
                            ButtonWidget(
                                label = "9",
                                modifier = Modifier.weight(1f),
                                endPadding = 10.dp
                            )
                        }
                    }
                }
            )
        }
    }
}

@Composable
fun ButtonRowWidget(content: @Composable () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        content()
    }
}

@Composable
fun ButtonWidget(
    modifier: Modifier = Modifier,
    label: String = "",
    startPadding: Dp? = null,
    topPadding: Dp? = null,
    endPadding: Dp? = null,
    bottomPadding: Dp? = null,
    horizontalPadding: Dp? = null,
    verticalPadding: Dp? = null
) {
    var start: Dp = startPadding ?: 0.dp
    var top: Dp = topPadding ?: 2.5.dp
    var end: Dp = endPadding ?: 0.dp
    var bottom: Dp = bottomPadding ?: 2.5.dp

    if (horizontalPadding != null) {
        start = horizontalPadding
        end = horizontalPadding
    }

    if (verticalPadding != null) {
        top = verticalPadding
        bottom = verticalPadding
    }

    Button(
        onClick = { /*TODO*/ },
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(start, top, end, bottom),
        shape = RoundedCornerShape(5.dp)
    ) {
        Text(text = label)
    }
}

@Preview(showBackground = true)
@Composable
fun HomePagePreview() {
    HomePage()
}