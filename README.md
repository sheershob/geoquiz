# geoquiz
A  simple geography-based quiz app developed using Android Studio in Java. It is designed to run on Android 8.0 (Oreo) and above.
There's a login and sign-up page that authenticates the user using email and password. This authentication is done using Firebase. The player's name is stored in Shared Preferences and used in other activities.
The third activity asks the player to start the quiz.
Each activity of the quiz contains one question and four options, along with a 15-second timer. Upon clicking the correct option a correct sound effect is played and the button is coloured green and the next activity opens up. Similarly upon clicking the incorrect option an incorrect sound effect is played and the button is coloured red.
Each time the player answers correctly, the score is incremented and sent to the next activity through Intents.putExtra() .
The last activity displays the player's score and sends a notification thanking the player. It also stores the Name and Score of the player in a .txt file.
