plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.wh_transfer"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.wh_transfer"
        minSdk = 31
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    viewBinding {enable=true}
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    // zxing
    implementation("com.journeyapps:zxing-android-embedded:4.2.0")
    implementation("de.hdodenhof:circleimageview:3.1.0")

//    // Retrofit library
//    implementation("com.squareup.retrofit2:retrofit:2.6.4")
//    // Gson 변환기 library
//    implementation("com.squareup.retrofit2:converter-gson:2.6.4")
//    // Scalars 변환기 library
//    implementation("com.squareup.retrofit2:converter-scalars:2.6.4")

    implementation("com.android.volley:volley:1.2.1")



//    implementation("com.android.volley:volley:1.2.1")
}