package com.tkastudio.app.data

import com.tkastudio.app.model.QuizQuestion

val kisiQuizQuestions: List<QuizQuestion> = listOf(
        QuizQuestion(
            id = "kisi-1.1-1",
            babId = "bab-1",
            topicId = "1.1",
            nomorAsli = null,
            question = "Fungsi bawaan `input()` menghentikan program sejenak. Apa tindakan yang diharapkan dari pemanggilan fungsi ini?",
            options = listOf(
                "Menghentikan aktivitas perekaman video di memori operasi utama",
                "Menahan prosesor agar suhunya menurun perlahan",
                "Menunggu hingga pengguna selesai mengetikkan respon melalui konsol",
                "Menunggu server internet memberikan persetujuan koneksi",
                "Memaksa perangkat keras mengeluarkan bunyi peringatan"
            ),
            correctIndex = 2,
            explanation = "`input()` membaca string dari standar input (keyboard pengguna) dan menjeda program hingga pengguna menekan Enter."
        ),
        QuizQuestion(
            id = "kisi-1.1-2",
            babId = "bab-1",
            topicId = "1.1",
            nomorAsli = null,
            question = "Jika kita mengeksekusi ekspresi `len([10, 20, 30])`, angka berapa yang akan dihasilkan oleh perintah tersebut?",
            options = listOf(
                "Angka 2 karena indeks array dimulai dari 0",
                "Angka 3 karena array tersebut memiliki tiga buah elemen",
                "Error sintaks fatal karena berisi integer",
                "Angka 60 karena program menjumlahkan seluruh elemen",
                "Angka 30 karena mengambil nilai terbesar"
            ),
            correctIndex = 1,
            explanation = "`len()` berasal dari kata length yang mengembalikan jumlah item di dalam list. Ada 3 elemen sehingga hasilnya 3."
        ),
        QuizQuestion(
            id = "kisi-1.1-3",
            babId = "bab-1",
            topicId = "1.1",
            nomorAsli = null,
            question = "Fungsi bawaan `int()` sangat berguna ketika kita menerima input harga dari pengguna. Apa tujuan fungsi ini?",
            options = listOf(
                "Memeriksa apakah input memiliki elemen duplikat",
                "Mengurutkan input dari angka terkecil hingga terbesar",
                "Memotong angka menjadi dua bagian pada setiap spasi",
                "Mengonversi input teks atau desimal menjadi angka bilangan bulat murni",
                "Mengubah angka menjadi teks string berformat mata uang"
            ),
            correctIndex = 3,
            explanation = "`int()` melakukan type casting ke bilangan bulat, misalnya string `\"10\"` menjadi `10` atau memotong desimal `2100.5` menjadi `2100`."
        ),
        QuizQuestion(
            id = "kisi-1.1-4",
            babId = "bab-1",
            topicId = "1.1",
            nomorAsli = null,
            question = "Apa perbedaan paling mendasar antara instruksi `print()` dan `return` di dalam sebuah fungsi Python?",
            options = listOf(
                "`print` menghasilkan teks tebal, `return` menghasilkan teks biasa",
                "`print` menghentikan fungsi, `return` melanjutkan ke baris berikutnya",
                "`print` sekadar mencetak ke layar, `return` mengembalikan nilai ke pemanggil fungsi",
                "`print` khusus untuk angka, `return` khusus untuk tipe data teks"
            ),
            correctIndex = 2,
            explanation = "`print()` hanya menampilkan teks ke konsol untuk dibaca manusia, sedangkan `return` mengirim nilai hasil fungsi kembali ke kode atau AI yang memanggilnya."
        ),
        QuizQuestion(
            id = "kisi-1.2-1",
            babId = "bab-1",
            topicId = "1.2",
            nomorAsli = null,
            question = "Perhatikan ekspresi `x += 5`. Apabila nilai awal variabel `x` adalah 10, apa yang terjadi pada `x`?",
            options = listOf(
                "Nilai x dibagi lima sehingga hasilnya 2",
                "Nilai x dikalikan lima sehingga menjadi 50",
                "Nilai x tidak berubah karena sintaks tidak valid",
                "Nilai x ditambah lima sehingga sekarang menjadi 15",
                "Nilai x ditimpa sepenuhnya menjadi 5"
            ),
            correctIndex = 3,
            explanation = "`x += 5` adalah shorthand dari `x = x + 5`. Karena awalnya 10, nilai baru `x` menjadi 15."
        ),
        QuizQuestion(
            id = "kisi-1.2-2",
            babId = "bab-1",
            topicId = "1.2",
            nomorAsli = null,
            question = "Dalam bahasa Python, operator ganda `//` (integer/floor division) berfungsi spesifik untuk?",
            options = listOf(
                "Menggabungkan dua tipe data numerik menjadi teks",
                "Mengembalikan ukuran panjang memori objek",
                "Melakukan pembagian yang selalu menghasilkan bilangan bulat ke bawah",
                "Menghitung akar kuadrat dari suatu bilangan",
                "Mencari nilai sisa dari hasil pembagian"
            ),
            correctIndex = 2,
            explanation = "Operator `//` membagi lalu membulatkan ke bawah menjadi bilangan bulat (`int`), misalnya `7 // 2` menghasilkan `3`."
        ),
        QuizQuestion(
            id = "kisi-1.2-3",
            babId = "bab-1",
            topicId = "1.2",
            nomorAsli = null,
            question = "Apa fungsi utama penggunaan operator modulus `%` dalam perhitungan Python (misal `5 % 2`)?",
            options = listOf(
                "Menghitung nilai persentase dari sebuah angka",
                "Mendapatkan hasil berupa sisa bagi dari suatu operasi pembagian",
                "Membagi dua angka dan membulatkan ke atas",
                "Memangkatkan angka pertama dengan angka kedua"
            ),
            correctIndex = 1,
            explanation = "Modulus `%` mengembalikan sisa hasil pembagian. Contohnya `5 % 2 = 1` karena 5 dibagi 2 bersisa 1."
        ),
        QuizQuestion(
            id = "kisi-1.2-4",
            babId = "bab-1",
            topicId = "1.2",
            nomorAsli = null,
            question = "Dalam evaluasi kondisi, operator logika `and` mengharuskan persyaratan apa agar hasil keseluruhannya bernilai `True`?",
            options = listOf(
                "Syarat sebelah kiri saja bernilai True",
                "Minimal terdapat satu syarat bernilai True",
                "Seluruh persyaratan di sebelah kiri dan kanan harus sama-sama True",
                "Tidak boleh ada variabel bertipe dictionary"
            ),
            correctIndex = 2,
            explanation = "Operator `and` hanya menghasilkan `True` jika kedua kondisi (kiri dan kanan) bernilai `True`. Jika salah satu `False`, hasilnya `False`."
        ),
        QuizQuestion(
            id = "kisi-1.3-1",
            babId = "bab-1",
            topicId = "1.3",
            nomorAsli = null,
            question = "Tipe data yang hanya bisa menyimpan dua nilai mutlak, yaitu `True` atau `False`, dinamakan?",
            options = listOf(
                "String (str)",
                "Integer (int)",
                "Float (float)",
                "Boolean (bool)",
                "Tuple"
            ),
            correctIndex = 3,
            explanation = "Boolean (`bool`) adalah tipe data logika yang hanya bernilai `True` (benar) atau `False` (salah)."
        ),
        QuizQuestion(
            id = "kisi-1.3-2",
            babId = "bab-1",
            topicId = "1.3",
            nomorAsli = null,
            question = "Tipe data `float` dalam ekosistem Python difungsikan khusus untuk menampung jenis data apa?",
            options = listOf(
                "Barisan karakter huruf yang diapit tanda kutip",
                "Kumpulan pasangan key dan value dalam kurung kurawal",
                "Angka pecahan atau desimal dengan pemisah tanda titik",
                "Bilangan bulat positif maupun negatif tanpa koma"
            ),
            correctIndex = 2,
            explanation = "`float` mewakili bilangan desimal/pecahan di Python, misalnya `0.1` atau `3.14`."
        ),
        QuizQuestion(
            id = "kisi-1.3-3",
            babId = "bab-1",
            topicId = "1.3",
            nomorAsli = null,
            question = "Dalam fungsi `invoice`, tipe data `int` pada parameter `pajak` diubah oleh ekspresi `(pajak / 100)`. Apa tipe hasil baginya?",
            options = listOf(
                "Menghasilkan error sistem logika",
                "Tetap menjadi bilangan bulat statis (int)",
                "Otomatis berubah menjadi tipe Float (desimal)",
                "Berubah menjadi List baru"
            ),
            correctIndex = 2,
            explanation = "Operator pembagian tunggal `/` di Python selalu menghasilkan `float` (misalnya `10 / 100` menjadi `0.1`), meskipun kedua angkanya `int`."
        ),
        QuizQuestion(
            id = "kisi-1.4-1",
            babId = "bab-1",
            topicId = "1.4",
            nomorAsli = null,
            question = "Sementara perintah `break` menghentikan loop secara total, perintah `continue` digunakan di dalam perulangan untuk?",
            options = listOf(
                "Mengulangi perulangan dari indeks pertama lagi",
                "Melompati sisa baris kode pada iterasi saat ini dan langsung lanjut ke iterasi berikutnya",
                "Mematikan seluruh program Python secara paksa",
                "Menahan program beberapa detik sebelum lanjut"
            ),
            correctIndex = 1,
            explanation = "`continue` hanya melewati sisa kode pada putaran saat ini dan langsung melompat ke iterasi berikutnya tanpa keluar dari loop."
        ),
        QuizQuestion(
            id = "kisi-1.4-2",
            babId = "bab-1",
            topicId = "1.4",
            nomorAsli = null,
            question = "Perulangan `while` di Python akan terus mengeksekusi blok kode di dalamnya selama?",
            options = listOf(
                "Syarat atau kondisi yang diujikan bernilai benar (True)",
                "Syarat atau kondisi bernilai salah (False)",
                "Daftar array yang dimasukkan sudah kosong",
                "Pengguna belum menekan tombol enter"
            ),
            correctIndex = 0,
            explanation = "Loop `while` mengevaluasi kondisinya sebelum tiap putaran; selama hasilnya `True`, blok kode terus dijalankan."
        ),
        QuizQuestion(
            id = "kisi-1.4-3",
            babId = "bab-1",
            topicId = "1.4",
            nomorAsli = null,
            question = "Apa yang terjadi pada sintaks `for barang in daftar_barang:` jika `daftar_barang` kosong (`[]`)?",
            options = listOf(
                "Akan muncul error IndexError",
                "Program akan crash seketika",
                "Blok perulangan langsung dilewati (0 iterasi) tanpa error",
                "Berjalan satu kali dengan nilai None"
            ),
            correctIndex = 2,
            explanation = "Iterasi `for` pada List kosong sangat aman di Python: blok loop dilewati begitu saja tanpa memicu error."
        ),
        QuizQuestion(
            id = "kisi-1.5-1",
            babId = "bab-1",
            topicId = "1.5",
            nomorAsli = null,
            question = "Tipe data struktur bersarang seperti `List of Dictionaries` sangat berguna untuk simulasi keranjang belanja. Bentuk fisiknya adalah?",
            options = listOf(
                "Kamus dengan kunci angka urut tanpa nilai",
                "Teks panjang berisi angka yang dipisah koma",
                "Sebuah List `[...]` di mana setiap elemennya berisi sebuah objek Dictionary `{...}`",
                "Tuple statis yang berisi nilai boolean"
            ),
            correctIndex = 2,
            explanation = "`[ {...}, {...} ]` adalah List of Dictionaries: list menyimpan urutan item, sedangkan tiap item berupa dictionary `{\"nama\": ..., \"harga\": ...}`."
        ),
        QuizQuestion(
            id = "kisi-1.5-2",
            babId = "bab-1",
            topicId = "1.5",
            nomorAsli = null,
            question = "Jika kita memiliki array `buah = [\"Apel\", \"Jeruk\", \"Mangga\"]`, indeks nomor berapa untuk mengambil `\"Apel\"`?",
            options = listOf(
                "Indeks 1 karena posisi awal",
                "Indeks 0 karena perhitungan indeks Python dimulai dari nol",
                "Indeks 2 karena dihitung mundur",
                "Indeks A sesuai abjad"
            ),
            correctIndex = 1,
            explanation = "Pengindeksan List di Python selalu dimulai dari `0` (zero-based indexing), sehingga `\"Apel\"` ada di `buah[0]`."
        ),
        QuizQuestion(
            id = "kisi-1.5-3",
            babId = "bab-1",
            topicId = "1.5",
            nomorAsli = null,
            question = "Pada dictionary bertingkat `list_barang[\"pensil\"][\"stok\"]`, bagaimana cara membacanya?",
            options = listOf(
                "Ambil indeks stok lalu pensil",
                "Cari key \"pensil\" pada dict utama, lalu dari isinya cari lagi key \"stok\"",
                "Ubah key pensil menjadi stok",
                "Gabungkan array pensil dan array stok"
            ),
            correctIndex = 1,
            explanation = "Ini akses berantai: `list_barang[\"pensil\"]` mengembalikan dictionary info pensil, lalu `[\"stok\"]` mengambil angka stok di dalamnya."
        ),
        QuizQuestion(
            id = "kisi-1.6-1",
            babId = "bab-1",
            topicId = "1.6",
            nomorAsli = null,
            question = "Kata kunci (`keyword`) apa yang wajib dituliskan saat membuat fungsi baru di Python?",
            options = listOf(
                "function",
                "create",
                "def",
                "make",
                "build"
            ),
            correctIndex = 2,
            explanation = "Python selalu menggunakan kata kunci `def` (define) di awal deklarasi fungsi, misalnya `def tambah_barang():`."
        ),
        QuizQuestion(
            id = "kisi-1.6-2",
            babId = "bab-1",
            topicId = "1.6",
            nomorAsli = null,
            question = "Sebuah argumen opsional dengan nilai dasar, misal `pajak: int = 10`, diletakkan di parameter fungsi. Apa persyaratan strukturalnya?",
            options = listOf(
                "Harus diletakkan di urutan paling depan sebelum parameter wajib",
                "Harus diurutkan di bagian akhir daftar argumen setelah parameter yang wajib diisi",
                "Hanya boleh bertipe float",
                "Dilarang memakai tipe data int"
            ),
            correctIndex = 1,
            explanation = "Di Python, seluruh parameter dengan nilai default (opsional) harus berada SETELAH parameter wajib (tanpa default)."
        ),
        QuizQuestion(
            id = "kisi-1.6-3",
            babId = "bab-1",
            topicId = "1.6",
            nomorAsli = null,
            question = "Dalam Type Hinting untuk argumen, `List[int]` mendikte bahwa data tersebut wajib berupa struktur?",
            options = listOf(
                "Dictionary dengan key berupa angka acak",
                "List/array yang seluruh elemen pembentuknya adalah bilangan bulat (Integer)",
                "List yang seluruh isinya adalah huruf string",
                "Variabel tunggal bertipe float"
            ),
            correctIndex = 1,
            explanation = "`List[int]` menandakan struktur list yang setiap anggotanya bertipe bilangan bulat (`int`)."
        ),
        QuizQuestion(
            id = "kisi-1.7-1",
            babId = "bab-1",
            topicId = "1.7",
            nomorAsli = null,
            question = "Dalam manipulasi string Python, operator `+` pada dua teks (misal `\"Halo \" + \"Dunia\"`) memiliki kegunaan?",
            options = listOf(
                "Menghapus huruf vokal pada string",
                "Memecah kalimat menjadi list kata",
                "Menggabungkan dua string secara berjejer (concatenation)",
                "Menghitung jumlah karakter kedua string"
            ),
            correctIndex = 2,
            explanation = "Operator `+` pada string melakukan concatenation (penyambungan teks secara berurutan)."
        ),
        QuizQuestion(
            id = "kisi-1.7-2",
            babId = "bab-1",
            topicId = "1.7",
            nomorAsli = null,
            question = "Pada Python, jika ingin membuat string panjang yang memakan beberapa baris ke bawah (multiline), simbol apa yang digunakan?",
            options = listOf(
                "Petik tunggal (')",
                "Kurung kurawal {}",
                "Tanda pagar (#)",
                "Petik tiga (\"\"\") di awal dan akhir teks"
            ),
            correctIndex = 3,
            explanation = "Triple-quotes (`\"\"\"...\"\"\"`) memungkinkan penulisan teks beberapa baris langsung tanpa perlu mengetik `\\n` berulang kali."
        ),
        QuizQuestion(
            id = "kisi-1.7-3",
            babId = "bab-1",
            topicId = "1.7",
            nomorAsli = null,
            question = "Apa fungsi dari awalan `f` pada sintaks `f\"{no}. {barang['nama_barang']}\"`?",
            options = listOf(
                "Menjadikan angka di dalamnya bertipe Float",
                "Menyisipkan nilai variabel langsung ke dalam teks lewat kurung kurawal `{}`",
                "Membuka file eksternal",
                "Mencari huruf tertentu di dalam teks"
            ),
            correctIndex = 1,
            explanation = "F-String (Formatted String) memudahkan interpolasi variabel langsung di dalam `{}` tanpa harus memotong string dengan `+`."
        ),
        QuizQuestion(
            id = "kisi-1.8-1",
            babId = "bab-1",
            topicId = "1.8",
            nomorAsli = null,
            question = "Jika kita memiliki variabel `teks = \"huruf\"`, perintah bawaan apa yang mengubah isinya menjadi huruf besar semua (`\"HURUF\"`)?",
            options = listOf(
                "teks.big()",
                "teks.upper()",
                "teks.capitalize()",
                "teks.large()"
            ),
            correctIndex = 1,
            explanation = "`.upper()` mengonversi seluruh huruf dalam string menjadi huruf kapital, sedangkan `.lower()` mengubahnya menjadi huruf kecil semua."
        ),
        QuizQuestion(
            id = "kisi-1.8-2",
            babId = "bab-1",
            topicId = "1.8",
            nomorAsli = null,
            question = "Untuk mencocokkan identitas string terlepas dari perbedaan huruf kapital user (misal `\"PeNsiL\"` vs `\"pensil\"`), metode apa yang lazim dipanggil?",
            options = listOf(
                "teks.match()",
                "teks.lower()",
                "int(teks)",
                "len(teks)"
            ),
            correctIndex = 1,
            explanation = "Normalisasi kapitalisasi dengan `.lower()` memastikan perbandingan teks tidak gagal hanya karena perbedaan huruf besar/kecil (case-sensitive)."
        ),
        QuizQuestion(
            id = "kisi-2.1-1",
            babId = "bab-2",
            topicId = "2.1",
            nomorAsli = null,
            question = "Definisi sebuah Cetak Biru (Blueprint) yang mengatur properti serta perilaku (metode) dari objek dalam Python disebut?",
            options = listOf(
                "Fungsi Perantara Klien",
                "Class Pemrograman",
                "Sistem Modul Eksternal",
                "Variabel Global"
            ),
            correctIndex = 1,
            explanation = "Class adalah cetak biru (blueprint) untuk menciptakan objek nyata (instance) beserta data dan method-nya."
        ),
        QuizQuestion(
            id = "kisi-2.1-2",
            babId = "bab-2",
            topicId = "2.1",
            nomorAsli = null,
            question = "Pada baris `order_pertama = OrderSaatIni()`, apa istilah pemrograman yang tepat untuk proses ini?",
            options = listOf(
                "Membuat objek baru (Class Instantiation)",
                "Mengimpor modul (Module Importing)",
                "Menghapus variabel (Garbage Collection)",
                "Mendefinisikan fungsi (Function Definition)"
            ),
            correctIndex = 0,
            explanation = "Membuat objek nyata dari sebuah blueprint Class disebut Instansiasi (Class Instantiation)."
        ),
        QuizQuestion(
            id = "kisi-2.2-1",
            babId = "bab-2",
            topicId = "2.2",
            nomorAsli = null,
            question = "Apa guna khusus dari blok deklarasi `def __init__(self):` pada sebuah Class Python?",
            options = listOf(
                "Mengubah bentuk class menjadi JSON secara paksa",
                "Berperan sebagai konstruktor untuk menginisialisasi nilai awal saat objek diciptakan",
                "Mengenkripsi bagian dalam kode program",
                "Menutup aplikasi setelah fungsi selesai"
            ),
            correctIndex = 1,
            explanation = "`__init__` adalah konstruktor yang otomatis dieksekusi sekali saat objek baru dibuat, misalnya untuk menyiapkan `self.katalog` dan `self.keranjang`."
        ),
        QuizQuestion(
            id = "kisi-2.2-2",
            babId = "bab-2",
            topicId = "2.2",
            nomorAsli = null,
            question = "Jika kita menempatkan variabel `katalog = {}` tanpa kata kunci `self.` di dalam `__init__`, variabel tersebut berisiko menjadi?",
            options = listOf(
                "Variabel global yang bisa diakses seluruh modul",
                "Variabel sementara (lokal) yang langsung hilang setelah fungsi `__init__` selesai",
                "Properti permanen yang otomatis tersimpan di cloud",
                "Konstanta yang tidak bisa diubah"
            ),
            correctIndex = 1,
            explanation = "Tanpa awalan `self.`, variabel hanya hidup secara lokal di dalam fungsi `__init__` dan tidak bisa diakses oleh method lain di Class yang sama."
        ),
        QuizQuestion(
            id = "kisi-2.2-3",
            babId = "bab-2",
            topicId = "2.2",
            nomorAsli = null,
            question = "Jika terdapat properti `self.keranjang` di `__init__`, bagaimana cara mengaksesnya dari metode lain di Class yang sama?",
            options = listOf(
                "OrderSaatIni.keranjang",
                "self.keranjang",
                "this.keranjang",
                "global keranjang"
            ),
            correctIndex = 1,
            explanation = "Parameter `self` merujuk pada instance objek yang sedang aktif, sehingga properti diakses melalui `self.keranjang`."
        ),
        QuizQuestion(
            id = "kisi-2.3-1",
            babId = "bab-2",
            topicId = "2.3",
            nomorAsli = null,
            question = "Pydantic sering diwarisi pada class Python melalui sintaks `class Model(BaseModel):`. Kegunaan esensialnya adalah?",
            options = listOf(
                "Memantau jumlah pengguna aktif realtime",
                "Mengeksekusi validasi aturan tipe data secara otomatis tanpa pengecekan manual",
                "Menerjemahkan dokumen PDF ke Markdown",
                "Menghubungkan Python ke database SQL secara otomatis"
            ),
            correctIndex = 1,
            explanation = "Pydantic memanfaatkan type hints Python untuk memvalidasi tipe data setiap properti secara otomatis saat objek dibuat."
        ),
        QuizQuestion(
            id = "kisi-2.3-2",
            babId = "bab-2",
            topicId = "2.3",
            nomorAsli = null,
            question = "Di Pydantic, jika kita TIDAK menentukan nilai awal (default) untuk sebuah properti (misal `harga: int`), properti tersebut menjadi?",
            options = listOf(
                "Opsional dan boleh dikosongkan",
                "Wajib diisi saat objek dibuat (Required)",
                "Otomatis bernilai None",
                "Otomatis bernilai 0"
            ),
            correctIndex = 1,
            explanation = "Field tanpa nilai default di `BaseModel` dianggap wajib ada (required); mengabaikannya akan memicu `ValidationError`."
        ),
        QuizQuestion(
            id = "kisi-2.3-3",
            babId = "bab-2",
            topicId = "2.3",
            nomorAsli = null,
            question = "Jika kita memiliki loop `for item in self.katalog:` dan `katalog` berisi objek Pydantic `Item`, bagaimana cara mencetak namanya?",
            options = listOf(
                "print(item['nama'])",
                "print(item.nama)",
                "print(self.katalog.nama)",
                "print(item[0])"
            ),
            correctIndex = 1,
            explanation = "Berbeda dari dictionary yang memakai `['nama']`, properti objek instance Pydantic diakses dengan notasi titik: `item.nama`."
        ),
        QuizQuestion(
            id = "kisi-3.1-1",
            babId = "bab-3",
            topicId = "3.1",
            nomorAsli = null,
            question = "Modul bawaan Google Colab apa yang digunakan untuk membaca nilai rahasia seperti `GEMINI_API_KEY` dari menu Secrets?",
            options = listOf(
                "google.colab.userdata",
                "google.secrets",
                "google.drive",
                "sys.api"
            ),
            correctIndex = 0,
            explanation = "Di Google Colab, `from google.colab import userdata` lalu `userdata.get('GEMINI_API_KEY')` dipakai untuk mengambil API Key dengan aman."
        ),
        QuizQuestion(
            id = "kisi-3.1-2",
            babId = "bab-3",
            topicId = "3.1",
            nomorAsli = null,
            question = "Jika muncul pesan error `NameError: name 'client' is not defined`, apa penyebab paling logis di Google Colab?",
            options = listOf(
                "Koneksi internet terputus sementara",
                "Cell yang berisi kode deklarasi variabel `client` belum dieksekusi",
                "Model AI sedang sibuk",
                "Laptop kehabisan RAM lokal"
            ),
            correctIndex = 1,
            explanation = "`NameError` berarti variabel dipanggil sebelum dideklarasikan—di Colab sering terjadi karena cell konfigurasi paling atas lupa di-Run."
        ),
        QuizQuestion(
            id = "kisi-3.1-3",
            babId = "bab-3",
            topicId = "3.1",
            nomorAsli = null,
            question = "Jupyter Notebook di Google Colab terdiri dari blok-blok cell. Tipe cell apa untuk menulis teks penjelasan berformat heading dan list?",
            options = listOf(
                "Code Cell",
                "Markdown Cell",
                "Output Cell",
                "Terminal Cell"
            ),
            correctIndex = 1,
            explanation = "Markdown Cell dipakai untuk dokumentasi, judul (`#`), dan penjelasan teks, sedangkan Code Cell dipakai untuk menjalankan kode Python."
        ),
        QuizQuestion(
            id = "kisi-3.2-1",
            babId = "bab-3",
            topicId = "3.2",
            nomorAsli = null,
            question = "Model AI yang dipanggil dengan konfigurasi `gemini-3.5-flash-lite` memiliki keunggulan utama pada aspek?",
            options = listOf(
                "Kecepatan respons (latency rendah) dan efisiensi biaya untuk tugas cepat",
                "Integrasi tanpa menulis kode sama sekali",
                "Kapasitas penyimpanan gambar tanpa batas",
                "Kemampuan menghitung puluhan digit tanpa pembulatan"
            ),
            correctIndex = 0,
            explanation = "Varian `flash-lite` dioptimalkan untuk respons super cepat (latency rendah) dan hemat kuota/biaya pada tugas interaktif."
        ),
        QuizQuestion(
            id = "kisi-3.2-2",
            babId = "bab-3",
            topicId = "3.2",
            nomorAsli = null,
            question = "Properti apa pada objek hasil generasi Gemini yang harus kita panggil untuk mendapatkan teks balasan murninya?",
            options = listOf(
                "response.message",
                "response.text",
                "response.data",
                "response.body"
            ),
            correctIndex = 1,
            explanation = "Objek respons Gemini menyimpan teks jawaban utama pada atribut `.text`, sehingga dicetak lewat `response.text`."
        ),
        QuizQuestion(
            id = "kisi-3.3-1",
            babId = "bab-3",
            topicId = "3.3",
            nomorAsli = null,
            question = "Objek `GenerateContentConfig` memuat argumen penting. Argumen mana yang mengatur kepribadian, peran, dan aturan kerja AI?",
            options = listOf(
                "max_token_capacity",
                "input_mime_type",
                "tools",
                "system_instruction"
            ),
            correctIndex = 3,
            explanation = "`system_instruction` memberikan persona, batasan aturan (guardrails), dan pedoman perilaku kepada model AI."
        ),
        QuizQuestion(
            id = "kisi-3.3-2",
            babId = "bab-3",
            topicId = "3.3",
            nomorAsli = null,
            question = "Pada instruksi Konselor Karir tertulis \"Jawab maksimal 3 kalimat\". Praktik pembatasan panjang balasan ini disebut?",
            options = listOf(
                "Code Refactoring",
                "Length Constraint pada Prompt Engineering",
                "Token Banning",
                "Memory Clearing"
            ),
            correctIndex = 1,
            explanation = "Length Constraint membatasi panjang keluaran agar AI menjawab ringkas dan tidak bertele-tele tanpa menghilangkan inti pesan."
        ),
        QuizQuestion(
            id = "kisi-3.4-1",
            babId = "bab-3",
            topicId = "3.4",
            nomorAsli = null,
            question = "Sifat alami LLM adalah `Stateless`. Apa arti spesifik dari sifat tersebut dalam konteks obrolan?",
            options = listOf(
                "Model tidak bisa menjawab lebih dari 10 kata",
                "Model tidak menyimpan memori percakapan di servernya secara otomatis",
                "Model hanya jalan jika terhubung ke kabel LAN",
                "Model mengingat semua user selamanya tanpa batas"
            ),
            correctIndex = 1,
            explanation = "Stateless berarti setiap request bersifat terpisah; pengembang (atau sesi `chat`) wajib mengirimkan ulang `history` percakapan sebelumnya."
        ),
        QuizQuestion(
            id = "kisi-3.4-2",
            babId = "bab-3",
            topicId = "3.4",
            nomorAsli = null,
            question = "Metode `chat.send_message()` pada sesi chat berbeda dengan `generate_content()` biasa karena metode tersebut?",
            options = listOf(
                "Menghapus pesan sebelumnya agar hemat RAM",
                "Otomatis menyisipkan pesan baru ke riwayat (history) dan menjaga konteks percakapan",
                "Memerlukan verifikasi sidik jari pengguna",
                "Hanya bisa memproses tipe data integer"
            ),
            correctIndex = 1,
            explanation = "`send_message()` otomatis mengelola context window (`history`) sehingga AI mengingat nama dan percakapan sebelumnya."
        ),
        QuizQuestion(
            id = "kisi-3.4-3",
            babId = "bab-3",
            topicId = "3.4",
            nomorAsli = null,
            question = "Pada objek riwayat pesan (`chat.history`), apa dua `role` standar yang bergantian muncul?",
            options = listOf(
                "admin dan user",
                "client dan server",
                "user (pengguna) dan model (AI)",
                "bot dan human"
            ),
            correctIndex = 2,
            explanation = "Riwayat obrolan Gemini selalu bergantian antara `user` (input pengguna) dan `model` (balasan AI)."
        ),
        QuizQuestion(
            id = "kisi-3.5-1",
            babId = "bab-3",
            topicId = "3.5",
            nomorAsli = null,
            question = "Untuk memastikan model memberikan jawaban JSON yang terstruktur murni tanpa basa-basi Markdown, konfigurasi apa yang dipasang?",
            options = listOf(
                "response_mime_type=\"application/json\"",
                "max_tokens=9999",
                "input_format=\"binary\"",
                "tools=[]"
            ),
            correctIndex = 0,
            explanation = "Menetapkan `response_mime_type=\"application/json\"` memaksa Gemini mengeluarkan teks JSON murni yang siap di-parse aplikasi."
        ),
        QuizQuestion(
            id = "kisi-3.5-2",
            babId = "bab-3",
            topicId = "3.5",
            nomorAsli = null,
            question = "Pada aplikasi backend, mengapa format response JSON sangat diutamakan dibandingkan teks bebas biasa?",
            options = listOf(
                "Karena JSON adalah satu-satunya teks yang bisa tampil di layar",
                "Data terstruktur mudah dibaca (parsing) dan diakses oleh kode antarmuka secara reliabel",
                "Karena ukuran file JSON selalu 10x lebih kecil dari teks terkompres",
                "Karena mencegah peretas mengubah warna CSS"
            ),
            correctIndex = 1,
            explanation = "JSON memiliki kunci dan nilai yang terprediksi sehingga aplikasi frontend/backend mudah memprosesnya tanpa salah baca."
        ),
        QuizQuestion(
            id = "kisi-4.1-1",
            babId = "bab-4",
            topicId = "4.1",
            nomorAsli = null,
            question = "Model LLM bergantung sepenuhnya pada tulisan Docstring (`\"\"\"...\"\"\"`) di sebuah fungsi Python untuk?",
            options = listOf(
                "Menghitung kecepatan CPU komputer lokal",
                "Memahami tujuan alat itu, argumen yang dibutuhkan, dan kapan harus memanggilnya",
                "Mengubah warna terminal saat dijalankan",
                "Memastikan fungsi bebas dari virus"
            ),
            correctIndex = 1,
            explanation = "Docstring adalah panduan bagi Gemini untuk memahami konteks (intent) dan kapan sebuah fungsi di `tools` harus di-trigger."
        ),
        QuizQuestion(
            id = "kisi-4.1-2",
            babId = "bab-4",
            topicId = "4.1",
            nomorAsli = null,
            question = "Mengapa fungsi bernama `ai_tambah_barang` yang isinya hanya memanggil `order_pertama.tambah_barang()` disebut Fungsi Wrapper?",
            options = listOf(
                "Karena fungsi itu berjalan otomatis saat error",
                "Karena membungkus method Class OOP agar bisa dipanggil langsung oleh SDK AI di parameter `tools`",
                "Karena menghapus seluruh data keranjang",
                "Karena memanggil dirinya sendiri secara rekursif"
            ),
            correctIndex = 1,
            explanation = "SDK AI membutuhkan fungsi top-level yang berdiri sendiri; Wrapper Function menjembatani panggilan AI menuju method di dalam objek Class."
        ),
        QuizQuestion(
            id = "kisi-4.1-3",
            babId = "bab-4",
            topicId = "4.1",
            nomorAsli = null,
            question = "Kegagalan menyertakan instruksi `return` pada fungsi tool yang dipanggil AI akan mengakibatkan Model AI?",
            options = listOf(
                "Membaca langsung tulisan `print()` yang tampil di layar terminal",
                "Menerima nilai kosong (None) sehingga AI berisiko berhalusinasi mengarang jawaban",
                "Menutup aplikasi komputer secara sepihak",
                "Mengulang instalasi library Python"
            ),
            correctIndex = 1,
            explanation = "AI tidak melihat output konsol `print()`; AI hanya menerima data yang dikirim lewat `return`. Tanpa `return`, AI mendapat `None`."
        ),
        QuizQuestion(
            id = "kisi-4.2-1",
            babId = "bab-4",
            topicId = "4.2",
            nomorAsli = null,
            question = "Mengapa kita tidak menyuruh AI langsung melakukan perhitungan matematika (seperti 5 barang diskon 15%) dan memilih menghitungnya di Python?",
            options = listOf(
                "Karena Python punya akses internet khusus kalkulator",
                "Karena LLM dilatih mengenali pola kata sehingga sering salah hitung; hitungan di Python 100% akurat",
                "Karena aturan hukum melarang AI berhitung",
                "Karena hitungan di Python lebih lambat dan aman"
            ),
            correctIndex = 1,
            explanation = "Model bahasa (LLM) memprediksi token teks, bukan mesin aritmetika. Menyerahkan kalkulasi ke fungsi Python menjamin angka tagihan selalu tepat."
        ),
        QuizQuestion(
            id = "kisi-4.2-2",
            babId = "bab-4",
            topicId = "4.2",
            nomorAsli = null,
            question = "Instruksi khusus Anti-Halusinasi seperti \"Jangan mengarang harga atau stok sendiri\" bertujuan meminimalisir AI melakukan apa?",
            options = listOf(
                "Mempercepat koneksi jaringan Colab",
                "Mengarang informasi palsu yang terdengar meyakinkan saat tidak memiliki data asli",
                "Mengubah nama variabel Python secara acak",
                "Menghapus riwayat percakapan user"
            ),
            correctIndex = 1,
            explanation = "Guardrail anti-halusinasi memaksa AI hanya berbicara berdasarkan fakta yang di-return oleh tools, bukan menebak-nebak."
        ),
        QuizQuestion(
            id = "kisi-4.3-1",
            babId = "bab-4",
            topicId = "4.3",
            nomorAsli = null,
            question = "Apa dampak negatif memberikan satu prompt raksasa yang mencakup terlalu banyak tugas sekaligus (Prompt Bloat)?",
            options = listOf(
                "Model AI otomatis menonaktifkan keamanan server",
                "Model AI mengalami kebingungan instruksi (Prompt Confusion) dan melupakan sebagian aturan",
                "Model AI membalas memakai bahasa mesin biner",
                "File Python menjadi tidak bisa dibuka"
            ),
            correctIndex = 1,
            explanation = "Prompt yang terlalu padat membuat LLM bingung memilih aturan yang harus diikuti. Memecahnya ke Multi-Agent membuat tiap spesialis fokus."
        ),
        QuizQuestion(
            id = "kisi-4.3-2",
            babId = "bab-4",
            topicId = "4.3",
            nomorAsli = null,
            question = "Dalam skenario Multi-Agent (Routing), apa peran khusus yang dipegang oleh `bos_router`?",
            options = listOf(
                "Menjawab langsung semua soal matematika berdasarkan hafalannya",
                "Bertindak sebagai resepsionis: membaca niat (intent) user dan meneruskan ke tool spesialis yang tepat",
                "Menghapus database barang setelah transaksi selesai",
                "Mengompresi riwayat obrolan menjadi file zip"
            ),
            correctIndex = 1,
            explanation = "`bos_router` tidak menjawab sendiri, melainkan menganalisis maksud user dan memilih tool spesialis (misal Tutor MTK atau Konselor Karir)."
        ),
        QuizQuestion(
            id = "kisi-4.3-3",
            babId = "bab-4",
            topicId = "4.3",
            nomorAsli = null,
            question = "Fungsi Python `enumerate(daftar_pertanyaan)` yang digunakan pada uji coba skenario Multi-AI menghasilkan apa pada perulangan `for`?",
            options = listOf(
                "Hanya nomor urut tanpa isi teks",
                "Indeks nomor urut sekaligus nilai (value) dari elemen list tersebut",
                "Membalikkan urutan elemen list",
                "Menghapus pertanyaan duplikat secara otomatis"
            ),
            correctIndex = 1,
            explanation = "`enumerate()` mengembalikan pasangan `(indeks, elemen)` di setiap iterasi, misalnya `(0, pertanyaan_1)`, `(1, pertanyaan_2)`."
        )
)
