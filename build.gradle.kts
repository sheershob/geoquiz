buildscript {
    dependencies {
        classpath("com.google.gms:google-services:4.4.2")
        // Import the BoM for the Firebase platform
//        implementation(platform("com.google.firebase:firebase-bom:33.1.2"))

        // Add the dependency for the Firebase Authentication library
        // When using the BoM, you don't specify versions in Firebase library dependencies
//        implementation("com.google.firebase:firebase-auth")
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id ("com.google.gms.google-services") version "4.4.2" apply false
    id("com.android.application") version "8.2.1" apply false
    id("com.android.library") version "8.2.1" apply false
}
//apply plugin: 'com.google.gms.google-services'