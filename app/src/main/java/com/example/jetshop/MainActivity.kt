package com.example.jetshop

import Event
import EventBus
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import com.example.jetshop.jetshop.presentation.ProductScreen.ProductScreen
import com.example.jetshop.ui.theme.JetShopTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetShopTheme {
                val lifecycle = LocalLifecycleOwner.current.lifecycle
                LaunchedEffect(key1 = lifecycle){
                    repeatOnLifecycle(state = Lifecycle.State.CREATED){
                        EventBus.events.collect(){event->
                            if(event is Event.Toast){
                                Toast.makeText(this@MainActivity, event.message, Toast.LENGTH_LONG)
                            }
                        }
                    }
                }
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProductScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetShopTheme {
        Greeting("Android")
    }
}