package com.example.pizzapartyapp
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.example.pizzapartyapp.R.*

const val SLICES_PER_PIZZA = 8

class MainActivity : AppCompatActivity() {
    private lateinit var numAttendEditText: EditText
    private lateinit var numPizzasTextView: TextView
    private lateinit var howHungryRadioGroup: RadioGroup


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        numAttendEditText = findViewById(id.number_of_people_edit_text)
        numPizzasTextView = findViewById(id.total_number_of_pizzas_text_view)
        howHungryRadioGroup = findViewById(id.how_hungry_radio_group)

    }

    fun calculateClick(view: View) {
        val numAttendStr = numAttendEditText.text.toString()
        val numAttend = numAttendStr.toInt()
        val slicesPerPerson = when (howHungryRadioGroup.checkedRadioButtonId) {
            id.light_radio_button -> 2
            id.medium_radio_button -> 3
            else -> 4
        }
        val totalPizzas = kotlin.math.ceil(
            numAttend * slicesPerPerson /
                    SLICES_PER_PIZZA.toDouble()
        ).toInt()
        numPizzasTextView.text = "Total pizzas: $totalPizzas"

    }
}