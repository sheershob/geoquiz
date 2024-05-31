# geoquiz
A  simple geography based quiz app developed using Android Studio in Java. It is designed to run on Android 8.0 (Oreo) and above.
There's a simple login page that asks you a mathematical question and your name. If answered incorrectly three times, the app closes. The name of the player is stored in Shared Preferences and is used in other activities.
The second activity asks the player to start the quiz.
Each activity of the quiz contains one question and four options, along with a 15 second timer. Upon clicking the correct option a correct sound effect is played and the button is coloured green and the next activity opens up. Similarly upon clicking the incorrect option an incorrect sound effect is played and the button is coloured red.
Each time the player answers correctly, the score is incremented and is sent to the next activity through Intents.putExtra() .
The last activity displays the score of the player and sends a notification thanking the player. It also stores the Name and Score the player in a .txt file.
