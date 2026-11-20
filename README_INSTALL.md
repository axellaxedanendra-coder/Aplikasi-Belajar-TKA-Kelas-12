# TKA Studio — Versi Android Native (Kotlin + Jetpack Compose)

Project Android Studio lengkap untuk belajar **PSAS TKA (Teknologi Kecerdasan Artifisial)** dalam tema **Dark Mode Monokrom Hitam-Putih**, mencakup:
- **4 Bab & 19 Nomor Kisi-kisi** (catatan kilat, poin ingat cepat, contoh kode Python/Gemini, dan jebakan ujian)
- **189 Soal Kuis** (53 soal Kisi-kisi + Part 1 46 soal + Part 2 45 soal + Part 3 45 soal) dengan **umpan balik instan benar/salah + alasan**
- **Drawer Navigasi Kiri** dengan seluruh dropdown Bab tertutup secara default & progres tersimpan otomatis offline (`SharedPreferences`)

## Cara 1: Build File .APK Otomatis di Cloud lewat GitHub (Tanpa Android Studio)

1. Buat repository baru di **GitHub** (misal: `tka-studio-android`).
2. Ekstrak `.zip` ini lalu upload **seluruh isi folder `TKAStudio-Android`** (pastikan folder `.github` ikut terupload) ke branch `main`.
3. Buka tab **Actions** di repository GitHub kamu — workflow **Build Android Debug APK** akan berjalan otomatis (~2–4 menit).
4. Setelah centang hijau, buka hasil run tersebut → bagian **Artifacts** → unduh **`TKAStudio-debug-apk`** (berisi `app-debug.apk`).
5. Kirim file `app-debug.apk` ke **WhatsApp** sebagai **Document**, lalu tap di HP Android untuk install!

## Cara 2: Build Lokal lewat Android Studio

1. **Ekstrak** file `.zip` ini ke sebuah folder.
2. Buka **Android Studio** -> pilih **Open** -> arahkan ke folder `TKAStudio-Android`.
3. Tunggu **Gradle Sync** selesai, lalu klik **Run (▶)** via USB atau **Build -> Build Bundle(s) / APK(s) -> Build APK(s)**.
