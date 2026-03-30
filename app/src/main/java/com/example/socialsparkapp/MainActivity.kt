package com.example.socialsparkapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Connects this activity to the layout file
        setContentView(R.layout.activity_main)

        // Linking UI elements from the layout to Kotlin variables
        val timeInput = findViewById<EditText>(R.id.timeInput)
        val resultText = findViewById<TextView>(R.id.resultText)
        val sparkButton = findViewById<Button>(R.id.sparkButton)
        val resetButton = findViewById<Button>(R.id.resetButton)

        // Runs when the "Get Social Spark" button is pressed
        sparkButton.setOnClickListener {

            val userInput = timeInput.text.toString().trim().lowercase()

            Log.d("SocialSpark", "User typed: $userInput")

            // Prevent empty input
            if (userInput.isEmpty()) {
                resultText.text = "Please type a time of day first."
                return@setOnClickListener
            }

            // Suggestion logic using if statements
            if (userInput == "morning") {

                resultText.text = "Send a Good Morning text to a family member."

            } else if (userInput == "mid-morning") {

                resultText.text = "Reach out to a colleague with a quick Thank You."

            } else if (userInput == "afternoon") {

                resultText.text = "Share a funny meme or interesting link with a friend."

            } else if (userInput == "afternoon snack time") {

                resultText.text = "Send a quick 'Thinking of you' message."

            } else if (userInput == "dinner") {

                resultText.text = "Call a friend or relative for a 5-minute catch up."

            } else if (userInput == "night" || userInput == "after dinner") {

                resultText.text = "Leave a thoughtful comment on a friend's post."

            } else {

                // Error message for invalid input
                resultText.text =
                    "Invalid time. Try Morning, Mid-morning, Afternoon, Dinner or Night."

                Log.e("SocialSpark", "User entered invalid time")

            }

        }

        // Reset button clears everything
        resetButton.setOnClickListener {

            timeInput.text.clear()
            resultText.text = ""

            Log.d("SocialSpark", "User pressed reset")

        }
    }
}