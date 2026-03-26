# HotelsApp

HotelsApp is an Android app built with Kotlin and Jetpack Compose for browsing a curated hotel catalog. The app loads hotel data from a bundled JSON asset, presents a searchable hotel list, and lets users open a dedicated details screen for each hotel.

## Features

- Browse a hotel list with image, city, and star rating.
- Search hotels by name, city, or country.
- Open a hotel details screen from the list.
- View hotel description, location, star rating, and hotel ID.
- Browse additional hotel images in a gallery section on the details screen.
- Handle loading and error states for both list and details flows.
- Use offline bundled data from `app/src/main/assets/Hotels.json`.

## Tech Stack

- Kotlin
- Jetpack Compose with Material 3
- Navigation Compose
- Hilt for dependency injection
- Coil for image loading
- Gson for JSON parsing
- Gradle Kotlin DSL

## Architecture

The app follows a simple clean architecture split into `presentation`, `domain`, and `data` layers.

- `presentation`: Compose UI, navigation, and `ViewModel` state management.
- `domain`: Core `Hotel` model, repository contract, and use cases.
- `data`: Asset-backed local data source, DTOs, mappers, and repository implementation.

Data flow:

`Hotels.json` -> `HotelLocalDataSource` -> `HotelRepositoryImpl` -> use cases -> `ViewModel` -> Compose UI

## App Flow

### Hotel List

- Loads hotels on startup.
- Displays a search field at the top of the screen.
- Filters the list in memory as the user types.
- Shows a card for each hotel with a preview image and rating.

### Hotel Details

- Receives the selected hotel ID through Navigation Compose.
- Loads the hotel from the repository through a use case.
- Shows a large header image, summary information, about section, and image gallery.
- Supports back navigation to the list screen.

## Project Structure

```text
app/src/main/java/com/example/hotelsapp/
  data/
  di/
  domain/
  presentation/
  ui/theme/
```

## How To Run

1. Open the project in Android Studio.
2. Let Gradle sync the project dependencies.
3. Run the `app` configuration on an emulator or physical Android device.

## Build Requirements

- Android Studio with current Android Gradle Plugin support
- JDK 11
- Minimum SDK 24
- Target SDK 36

## Notes

- The current implementation uses local asset data, so the app can be demonstrated without a backend.
- Retrofit and OkHttp are already included in the project dependencies and can support a future remote data source.
