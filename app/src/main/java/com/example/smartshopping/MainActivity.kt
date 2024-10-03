package com.example.smartshopping

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smartshopping.databinding.ActivityMainBinding
import androidx.recyclerview.widget.RecyclerView

//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: ShoppingListAdapter
    private val items = mutableListOf<ShoppingItem>()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Access views using binding
        binding.textView.text = "Hello!"

        // Initialize RecyclerView
        adapter = ShoppingListAdapter(items) { position ->
            deleteItem(position)
        }

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // Handle add button click
        binding.buttonAddItem.setOnClickListener {
            val itemName = binding.editTextItem.text.toString()
            if (itemName.isNotEmpty()) {
                addItem(itemName)
                binding.editTextItem.text.clear() // Clear input after adding item
            }
        }
    }

    private fun addItem(itemName: String) {
        items.add(ShoppingItem(itemName))
        adapter.notifyItemInserted(items.size - 1)
    }

    private fun deleteItem(position: Int) {
        items.removeAt(position)
        adapter.notifyItemRemoved(position)
    }
}

//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            SmartShoppingTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    SmartShoppingTheme {
//        Greeting("Android")
//    }
//}