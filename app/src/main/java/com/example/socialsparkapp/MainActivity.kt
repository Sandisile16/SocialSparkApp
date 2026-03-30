package com.example.socialsparkapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // This function runs when the app opens
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Load the layout

        // Link UI elements from XML to Kotlin variables
        val timeInput = findViewById<EditText>(R.id.timeInput)
        val resultText = findViewById<TextView>(R.id.resultText)
        val sparkButton = findViewById<Button>(R.id.sparkButton)
        val resetButton = findViewById<Button>(R.id.resetButton)

        // When the user clicks the "Get Social Spark" button
        sparkButton.setOnClickListener {

            // Get the text the user typed and convert to lowercase for easy comparison
            val userInput = timeInput.text.toString().trim().lowercase()

            Log.d("SocialSpark", "User entered: $userInput") // Print user input to Logcat

            // Decide which suggestion to show based on the input
            if (userInput == "morning") {
                resultText.text = "Send a Good Morning text to a family member."
            } else if (userInput == "mid-morning") {
                resultText.text = "Reach out to a colleague with a quick Thank You."
            } else if (userInput == "afternoon") {
                resultText.text = "Share a funny meme or interesting link with a friend."
            } else if (userInput == "afternoon snack time") {
                resultText.text = "Send a quick 'Thinking of you' message."
            } else if (userInput == "dinner") {
                resultText.text = "Call a friend or relative for a quick 5-minute catch-up."
            } else if (userInput == "night" || userInput == "after dinner") {
                resultText.text = "Leave a thoughtful comment on a friend's post."
            } else {
                // If input does not match any option, show an error
                resultText.text = "Please enter a valid time like Morning, Afternoon, Dinner or Night."
                Log.e("SocialSpark", "Invalid input entered")
            }
        }

        // When the user clicks the "Reset" button
        resetButton.setOnClickListener {
            timeInput.text.clear() // Clear the input field
            resultText.text = ""   // Clear the suggestion text
            Log.d("SocialSpark", "Reset button pressed") // Log the reset action
        }
    }
}