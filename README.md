# Crypto-Currency App 

## Overview 


Crypto-Currency App is an Android application that provides users with comprehensive information about various cryptocurrencies. Users can explore a vast list of cryptocurrencies, search for specific ones, and view detailed information, including official links, whitepapers, and more. The app efficiently utilizes local caching to enhance user experience by speeding up searches and enabling offline access to viewed cryptocurrencies.

## Features

- **Cryptocurrency List:**
  - Fetches a large list of cryptocurrencies from the Coinpaprika API.
  - Allows users to search and explore details of cryptocurrencies.
 
- **Pull-to-Refresh:**
  - Users can refresh the cryptocurrency list by swiping down, ensuring the latest data is readily available.

- **Local Caching:**
  - Caches the list of all cryptocurrencies for faster searching.
  - Stores detailed information about viewed cryptocurrencies for offline access.

- **Comprehensive Cryptocurrency Details:**
  - Provides detailed information about each cryptocurrency.
  - Allows navigation to official websites, social media pages, whitepapers, and more.

 ## Technologies and Architecture Used:

- Clean Architecture with MVVM
- Kotlin
- Jetpack Compose for UI
- Dagger Hilt for Dependency Injection
- Kotlin Coroutines & Flows
- Retrofit for Rest API integration
- Room Database for Local Caching
- Jetpack Navigation library for Navigation
