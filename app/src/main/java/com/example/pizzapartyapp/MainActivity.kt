package com.example.pizzapartyapp
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.example.pizzapartyapp.R.*

const val SLICES_PER_PIZZA = 8

/*
* This class is the activity which will run for the first time
* In our case this is the page of our pizza party app
* */
class MainActivity : AppCompatActivity() {
    /**
     * Total people attending the party
     */
    private lateinit var numAttendEditText: EditText

    /**
     * Total pizzas calculated
     */
    private lateinit var numPizzasTextView: TextView

    /**
     * The hungry ratio radio button - light, medium and ravenous
     */
    private lateinit var howHungryRadioGroup: RadioGroup


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        numAttendEditText = findViewById(id.number_of_people_edit_text)
        numPizzasTextView = findViewById(id.total_number_of_pizzas_text_view)
        howHungryRadioGroup = findViewById(id.how_hungry_radio_group)

    }


    fun calculateClick(view: View) {
        // Get the text of number of people at the party
        val numAttendStr = numAttendEditText.text.toString()

        // convert to int
        val numAttend = numAttendStr.toInt()

        val slicesPerPerson = when (howHungryRadioGroup.checkedRadioButtonId) {
            id.light_radio_button -> 2
            id.medium_radio_button -> 3
            else -> 4
        }

        // calculate number of pizzas needed
        val totalPizzas = kotlin.math.ceil(
            numAttend * slicesPerPerson /
                    SLICES_PER_PIZZA.toDouble()
        ).toInt()
        numPizzasTextView.text = "Total pizzas: $totalPizzas"

    }
}