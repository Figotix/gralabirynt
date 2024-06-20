# labirynthgame

Autor: Paweł Goleń, 39945

Gra Labirynt to podstawowa aplikacja na Androida, w której gracze przemieszczają się po labiryncie. Struktura labiryntu jest zdefiniowana za pomocą tablicy 2D, a każdy pokój w labiryncie ma określone drzwi, przez które można przejść. Celem gry jest dotarcie do pokoju wyjściowego przy jak najmniejszej liczbie ruchów.

Funkcje
Ekran startowy, ekran gry i ekran wyników.
Prosty labirynt 4x4.
Pokoje labiryntu mają przyciski do nawigacji w czterech kierunkach (góra, dół, lewo, prawo).
Przyciski są włączane lub wyłączane w zależności od możliwych wyjść z każdego pokoju.
Ekran wyników wyświetla liczbę ruchów potrzebnych do ukończenia labiryntu.
Instalacja
Aby uruchomić ten projekt lokalnie, wykonaj następujące kroki:

Sklonuj repozytorium:

sh
Skopiuj kod
git clone https://github.com/Figotix/labirynthgame.git
cd labirynth-game
Otwórz projekt w Android Studio.

Zbuduj i uruchom projekt na emulatorze lub fizycznym urządzeniu.

Użycie
MainActivity: Główne wejście do aplikacji. Zawiera przycisk do rozpoczęcia gry.
GameActivity: Główny ekran gry, gdzie gracze nawigują po labiryncie.
ResultActivity: Wyświetla wynik (liczbę ruchów) po dotarciu gracza do pokoju wyjściowego.
MainActivity
Plik: MainActivity.kt
Layout: activity_main.xml
GameActivity
Plik: GameActivity.kt
Layout: activity_game.xml
Opis: Implementuje logikę gry, w tym nawigację i liczenie ruchów.
ResultActivity
Plik: ResultActivity.kt
Layout: activity_result.xml
Opis: Wyświetla liczbę ruchów wykonanych przez gracza do ukończenia labiryntu.
Struktura Labiryntu
Labirynt jest zdefiniowany za pomocą tablicy 2D liczb całkowitych. Każda liczba używa wartości bitowych do wskazania możliwych wyjść:

1 (2^0): Lewo
2 (2^1): Prawo
4 (2^2): Góra
8 (2^3): Dół
Przykładowy labirynt:

kotlin
Skopiuj kod
private val labyrinth = arrayOf(
    intArrayOf(10, 8, 10, 9),
    intArrayOf(28, 1, 0, 12),
    intArrayOf(12, 10, 9, 13),
    intArrayOf(6, 5, 6, 5)
)