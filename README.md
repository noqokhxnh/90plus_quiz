# Rules
   - Language: Use English for all code comments and documentation and reply by VietNamese.
   - Follow Java conventions for Android development.
   - Use meaningful names for variables, methods, and classes.
   - Keep code readable and well-formatted.
# Project Structure
app/
├── src/main/java/com/yourpackage/
│   ├── activities/
│   │   ├── MainActivity.java
│   │   ├── GameModeActivity.java
│   │   └── ProfileActivity.java
│   ├── fragments/
│   │   ├── Mode1Fragment.java
│   │   ├── Mode2Fragment.java
│   │   └── Mode3Fragment.java
│   ├── adapters/
│   │   ├── QuestionAdapter.java
│   │   ├── AnswerAdapter.java
│   │   └── SquadAdapter.java
│   ├── models/
│   │   ├── Player.java
│   │   ├── Question.java
│   │   ├── GameSession.java
│   │   └── User.java
│   ├── repositories/
│   │   ├── FirebaseRepository.java
│   │   └── ApiRepository.java
│   ├── services/
│   │   └── FootballApiService.java
│   └── utils/
│       ├── GameLogic.java
│       └── ScoreCalculator.java


# Core Technologies

Platform: Android Native Mobile App
Language: Java
IDE: Android Studio
Database: Firebase Firestore
Authentication: Firebase Auth
UI Framework: Native Android Views with RecyclerView
Animations: MotionLayout, Android Animation Framework, Animated Vector Drawable, GIF or Lottie for Android
Networking: Retrofit (recommended) or Volley
Image Loading: Glide or Picasso
Target SDK: API 21+ (Android 5.0+)

# 🎯 Game Modes
Mode 1: Find Football Player (Connect Game)

Concept: Guess the name of a football player based on the hints of other players they have played with
Mechanics:

Show 3-5 teammate hints
Increasing hint system (hints range from easy to difficult)
Multiple choice or text input for answers
Scores based on the number of hints used

Mode 2: Football Vocabulary Game

Concept: Daily football player crossword puzzle
Mechanics:

6 guesses of football player names
Letter feedback system (correct position, incorrect position, incorrect name)
Change target player daily
Result sharing feature

Mode 3: Team Building

Concept: Build a team with specific constraints
Mechanics:

The system generates a random footballformation (eg: 4-3-3, 4-4-2, 3-4-2-1,...)
The system displays a random club
The player fills in the name of the footballer in the blank box, if the footballer fits the missing position on the field, the system will fill the player in the diagram. Then the system displays another club until the player fills in the diagram


# Fooballer Database Structure:
- Player ID
- Full Name
- Position
- Nationality
- Current Club
- Former Clubs
- Career Statistics
- Image URL
# Mobile-Specific Features
- Android UI Components

   Activities: Main screens for each game mode
   Fragments: Reusable UI components within activities
   RecyclerView: For smooth scrolling lists and grids
   ViewPager2: For swipeable screens and onboarding
   ConstraintLayout: Responsive layouts for different screen sizes
   Material Design: Following Android design guidelines

- Mobile UX Considerations

   Touch Gestures: Swipe, tap, long press, drag & drop
   Screen Orientations: Portrait and landscape support
   Different Screen Sizes: Phone and tablet optimization
   Navigation: Bottom navigation or drawer navigation
   Offline Mode: Cache data for offline gameplay
   Push Notifications: Daily challenges and reminders

- Mobile Performance

   Memory Management: Efficient RecyclerView usage
   Battery Optimization: Background task management
   Network Optimization: Image compression and caching
   Storage: Internal storage for user data and cache

# Lottie Animations

Success animations: Goal celebrations, trophy animations
Loading animations: Football spinning, player running
Transition animations: Between game modes
Feedback animations: Correct/incorrect answers

#  Performance Considerations

Implement caching for frequently accessed data
Use pagination for large player lists
Optimize image loading with Glide
Implement proper memory management for RecyclerViews
Use ViewBinding for efficient UI updates

# Security & Best Practices

Implement Firebase security rules
Validate user inputs
Use ProGuard for code obfuscation
Implement rate limiting for API calls
Store sensitive data securely

## Gemini Added Memories
- The football-data.org API key is 1dc6a8038f804c579ad9ab40cdb12b4f

