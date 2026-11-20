package com.tkastudio.app.data

import com.tkastudio.app.model.QuizQuestion

val quizPart3Questions: List<QuizQuestion> = listOf(
        QuizQuestion(
            id = "p3-1",
            babId = "bab-1",
            topicId = "1.4",
            nomorAsli = 1,
            question = "Dalam perulangan `for i in range(len(keranjang)):`, fungsi dari kombinasi sintaks tersebut bertujuan agar?",
            options = listOf(
                "Kita membalik urutan elemen mulai dari bilangan yang terbesar",
                "Kita bisa menambahkan jumlah elemen baru secara fleksibel",
                "Kita mendapatkan angka indeks urut (0, 1, 2) untuk iterasi list",
                "Kita menghitung total selisih panjang dua buah koleksi array"
            ),
            correctIndex = 2,
            explanation = "`len(keranjang)` memberi panjang list, lalu `range(...)` menghasilkan urutan angka `0, 1, 2, ...` untuk mengakses dua list paralel lewat indeks `i`."
        ),
        QuizQuestion(
            id = "p3-2",
            babId = "bab-1",
            topicId = "1.5",
            nomorAsli = 2,
            question = "Jika kita memanggil `list_barang.items()` pada perulangan, nilai kembalian (return) tiap iterasinya berjumlah berapa?",
            options = listOf(
                "Tidak ada nilai yang dikembalikan ke sistem",
                "Satu nilai saja berupa string kunci",
                "Dua nilai: Key dan Value pada elemen tersebut",
                "Tiga nilai: Indeks, Key, dan Value-nya"
            ),
            correctIndex = 2,
            explanation = "Method `.items()` pada Dictionary mengembalikan pasangan tuple berisi dua nilai pada tiap iterasi: `(key, value)`."
        ),
        QuizQuestion(
            id = "p3-3",
            babId = "bab-1",
            topicId = "1.7",
            nomorAsli = 3,
            question = "Apa fungsi sebenarnya dari sintaks F-String seperti `print(f\"Total: {total}\")`?",
            options = listOf(
                "Menghapus kurung kurawal pada output",
                "Mengubah variabel menjadi tipe float",
                "Mencetak teks dengan format tebal tebal",
                "Memasukkan nilai variabel ke dalam teks"
            ),
            correctIndex = 3,
            explanation = "Awalan `f` membuat Python mengevaluasi isi `{total}` dan menyisipkan nilai variabel tersebut langsung ke dalam string."
        ),
        QuizQuestion(
            id = "p3-4",
            babId = "bab-1",
            topicId = "1.4",
            nomorAsli = 4,
            question = "Bagaimana sistem Python membedakan blok kode yang ada di dalam percabangan `if` dengan yang di luar?",
            options = listOf(
                "Menggunakan kurung kurawal ganda {{ }}",
                "Menyisipkan karakter titik koma di bagian akhirnya",
                "Menggunakan kata kunci EndIf di baris penutup",
                "Melihat posisi spasi mundur (Indentasi) dari baris"
            ),
            correctIndex = 3,
            explanation = "Python menentukan batas blok `if`, `for`, dan `def` sepenuhnya melalui tingkat indentasi (spasi di awal baris)."
        ),
        QuizQuestion(
            id = "p3-5",
            babId = "bab-1",
            topicId = "1.5",
            nomorAsli = 5,
            question = "Jika kita mengeksekusi `self.keranjang.append(barang)`, apa yang terjadi pada array tersebut?",
            options = listOf(
                "Barang diletakkan di indeks awal",
                "Barang disisipkan di urutan tengah",
                "Barang menimpa elemen sebelumnya",
                "Barang ditambahkan pada posisi akhir"
            ),
            correctIndex = 3,
            explanation = "`.append()` selalu menambahkan item baru di ujung akhir (belakang) List tanpa menimpa isi sebelumnya."
        ),
        QuizQuestion(
            id = "p3-6",
            babId = "bab-3",
            topicId = "3.4",
            nomorAsli = 6,
            question = "Fungsi `integrator.send_message(\"teks\")` memiliki karakteristik utama apa dibandingkan fungsi generate biasa?",
            options = listOf(
                "Berfungsi menjaga riwayat (history) dalam percakapan",
                "Memutuskan koneksi dengan server setelah pesan terkirim",
                "Otomatis mengompresi data pesan menjadi biner log",
                "Hanya bisa menerima instruksi berbentuk tipe Integer"
            ),
            correctIndex = 0,
            explanation = "`send_message` milik objek `chats` otomatis merekam pertanyaan user dan jawaban model ke dalam `history` sehingga konteks obrolan terjaga."
        ),
        QuizQuestion(
            id = "p3-7",
            babId = "bab-3",
            topicId = "3.2",
            nomorAsli = 7,
            question = "Ketika kita menyimpan balasan di `response`, mengapa kita harus memanggil `response.text` untuk mencetaknya?",
            options = listOf(
                "Karena sistem Python mewajibkan pemanggilan properti text",
                "Karena objek response adalah sebuah fungsi matematika",
                "Karena tipe datanya harus dikonversi dari integer ke string",
                "Karena teks utama tersimpan di dalam properti text tersebut"
            ),
            correctIndex = 3,
            explanation = "Objek `response` berisi banyak metadata API; string balasan murni dari model tersimpan di dalam atribut `.text`."
        ),
        QuizQuestion(
            id = "p3-8",
            babId = "bab-1",
            topicId = "1.5",
            nomorAsli = 8,
            question = "Manakah sintaks yang paling tepat untuk mengecek apakah `'pensil'` ada di dalam dictionary `katalog`?",
            options = listOf(
                "if katalog.contains('pensil'):",
                "if 'pensil' in katalog:",
                "if katalog.has('pensil'):",
                "if 'pensil' == katalog.keys():"
            ),
            correctIndex = 1,
            explanation = "Python menggunakan operator keanggotaan `in` (atau `not in`) untuk mengecek apakah sebuah key ada di dalam Dictionary."
        ),
        QuizQuestion(
            id = "p3-9",
            babId = "bab-1",
            topicId = "1.6",
            nomorAsli = 9,
            question = "Apa arti dari type hint `-> str:` yang ditulis setelah definisi argumen sebuah fungsi `tambah_barang`?",
            options = listOf(
                "Fungsi akan menghapus seluruh tipe data string",
                "Fungsi diwajibkan untuk mengembalikan nilai string",
                "Fungsi ini bersifat statis (static string method)",
                "Fungsi hanya bisa menerima satu string saja"
            ),
            correctIndex = 1,
            explanation = "Notasi `-> str` adalah return type annotation yang menyatakan nilai kembalian (`return`) fungsi tersebut bertipe string."
        ),
        QuizQuestion(
            id = "p3-10",
            babId = "bab-2",
            topicId = "2.3",
            nomorAsli = 10,
            question = "Apa arti dari sintaks `List[Barang]` jika ditulis pada argumen fungsi di Python?",
            options = listOf(
                "Variabel bertipe List namun isinya diubah menjadi Float",
                "Variabel harus berupa List yang berisi objek dari class Barang",
                "Variabel akan menghapus data duplikat pada struktur data",
                "Variabel diwajibkan menjadi Array berisi string acak"
            ),
            correctIndex = 1,
            explanation = "`List[Barang]` memberi petunjuk tipe (dan aturan validasi bagi Gemini/Pydantic) bahwa isi array tersebut adalah objek `Barang`."
        ),
        QuizQuestion(
            id = "p3-11",
            babId = "bab-1",
            topicId = "1.1",
            nomorAsli = 11,
            question = "Mengapa kita mengembalikan nilai desimal pajak menjadi bulat dengan sintaks `int(...)` sebelum menampilkannya?",
            options = listOf(
                "Sebagai syarat utama penggunaan API Google Gemini",
                "Untuk menghindari bug memory leak pada perangkat lokal",
                "Agar tidak ada nilai pecahan koma pada format mata uang",
                "Agar server tidak menolak hasil perhitungan"
            ),
            correctIndex = 2,
            explanation = "Hasil persentase `(pajak/100)` bertipe float dan bisa menghasilkan `.0` atau `.5`. `int(...)` membuang koma agar tampilan Rupiah bulat."
        ),
        QuizQuestion(
            id = "p3-12",
            babId = "bab-2",
            topicId = "2.3",
            nomorAsli = 12,
            question = "Saat kita membuat model `class Barang(BaseModel):`, apa fungsi utama library Pydantic tersebut?",
            options = listOf(
                "Menjalankan perulangan array dengan lebih efisien",
                "Menghubungkan aplikasi Python dengan database SQL",
                "Melakukan validasi otomatis pada tipe data properti",
                "Mempercantik tampilan antarmuka (UI) pada terminal"
            ),
            correctIndex = 2,
            explanation = "Pydantic `BaseModel` otomatis memeriksa dan memvalidasi tipe data properti setiap kali objek dibuat."
        ),
        QuizQuestion(
            id = "p3-13",
            babId = "bab-4",
            topicId = "4.3",
            nomorAsli = 13,
            question = "Dalam pola 'Router/Bos' (Multi-Agent), bagaimana Bos mengoper tugas ke sub-agen/spesialis lainnya?",
            options = listOf(
                "Bos memilih dan menjalankan tool fungsi agen spesialis",
                "Bos mengirimkan sinyal ping ke alamat server lokal",
                "Bos menghentikan program lalu memanggil file terpisah",
                "Bos mengganti parameter model pada konfigurasi sistem"
            ),
            correctIndex = 0,
            explanation = "Agen Bos dibekali daftar fungsi spesialis pada `tools=[...]` lalu memilih dan menjalankan tool spesialis yang cocok dengan intent user."
        ),
        QuizQuestion(
            id = "p3-14",
            babId = "bab-4",
            topicId = "4.1",
            nomorAsli = 14,
            question = "Mengapa penggunaan fungsi bawaan `print(...)` tidak efektif jika diterapkan sebagai alat penyampai informasi kepada Model AI?",
            options = listOf(
                "AI tidak memahami bahasa pemrograman standar lokal Python",
                "Fungsi print akan menimbulkan error saat dibaca oleh server",
                "Fungsi print menghabiskan kapasitas kuota akses API harian",
                "AI hanya membaca Output yang di-Return, bukan Output Konsol"
            ),
            correctIndex = 3,
            explanation = "Nilai yang dicetak `print()` hanya tampil di layar manusia. Model AI hanya menerima data yang dikembalikan via pernyataan `return`."
        ),
        QuizQuestion(
            id = "p3-15",
            babId = "bab-1",
            topicId = "1.4",
            nomorAsli = 15,
            question = "Dalam pengujian kondisional `elif (jumlah_barang > barang[\"stok\"]):`, perintah percabangan ini baru akan diuji sistem apabila?",
            options = listOf(
                "Nilai jumlah_barang dan stok seimbang pada kalkulasi desimal",
                "Perulangan list telah mencapai batas elemen paling terakhir",
                "Sistem komputer mendeteksi ada anomali memori pada variabel",
                "Kondisi pada statemen IF sebelumnya bernilai Salah (False)"
            ),
            correctIndex = 3,
            explanation = "`elif` (else if) hanya dievaluasi oleh Python apabila seluruh kondisi `if`/`elif` sebelumnya bernilai `False`."
        ),
        QuizQuestion(
            id = "p3-16",
            babId = "bab-4",
            topicId = "4.1",
            nomorAsli = 16,
            question = "Apa yang akan dibaca oleh model Gemini untuk memahami kapan ia harus memanggil sebuah fungsi?",
            options = listOf(
                "Nama-nama argumen (parameter) di dalam kurung kurawal",
                "Teks komentar menggunakan karakter pagar (#)",
                "Deskripsi pada Docstring (petik tiga) di bawah nama fungsi",
                "Nama file Python tempat fungsi tersebut disimpan"
            ),
            correctIndex = 2,
            explanation = "Docstring (`\"\"\"...\"\"\"`) yang ditulis tepat di bawah `def ...` dibaca oleh Gemini sebagai deskripsi kegunaan tool tersebut."
        ),
        QuizQuestion(
            id = "p3-17",
            babId = "bab-4",
            topicId = "4.1",
            nomorAsli = 17,
            question = "Jika fungsi di class me-return string `\"Barang tidak ada\"`, ke mana nilai tersebut diteruskan saat dipanggil AI?",
            options = listOf(
                "Diteruskan kembali (return) ke server model AI",
                "Disimpan di dalam variabel global memori sistem",
                "Ditampilkan otomatis ke terminal user lokal",
                "Menyebabkan program berhenti karena error fatal"
            ),
            correctIndex = 0,
            explanation = "SDK Gemini menangkap nilai `return` dari fungsi tool dan mengirimkannya kembali ke model AI agar AI bisa merangkai respons ke user."
        ),
        QuizQuestion(
            id = "p3-18",
            babId = "bab-1",
            topicId = "1.6",
            nomorAsli = 18,
            question = "Jika kita memberikan nilai `diskon: int = 0` pada argumen fungsi, AI akan melihat argumen diskon ini sebagai?",
            options = listOf(
                "Parameter opsional yang tidak wajib disuplai nilai",
                "Parameter string yang disamarkan menjadi angka",
                "Parameter yang akan ditolak karena bernilai nol",
                "Parameter rahasia yang tidak boleh dipanggil AI"
            ),
            correctIndex = 0,
            explanation = "Adanya default `= 0` menandakan argumen bersifat opsional: jika user tidak menyebut diskon, AI tidak wajib mengisi argumen ini."
        ),
        QuizQuestion(
            id = "p3-19",
            babId = "bab-3",
            topicId = "3.5",
            nomorAsli = 19,
            question = "Dalam kode `class RecipeTemplate(typing.TypedDict):`, apa keunggulan utama struktur TypedDict ini?",
            options = listOf(
                "Menerjemahkan bahasa pemrograman Python ke Javascript",
                "Menentukan skema kaku untuk memaksa format output AI",
                "Mengurangi ukuran file program secara signifikan",
                "Menyimpan data secara permanen di harddisk lokal"
            ),
            correctIndex = 1,
            explanation = "`TypedDict` dipakai bersama `response_schema` untuk memaksa output JSON AI selalu mengikuti key dan tipe data yang telah ditentukan."
        ),
        QuizQuestion(
            id = "p3-20",
            babId = "bab-4",
            topicId = "4.1",
            nomorAsli = 20,
            question = "Pada API Gemini terbaru, di manakah kita memasukkan array/daftar fungsi agar bisa dikenali sistem?",
            options = listOf(
                "Di dalam system prompt menggunakan bahasa natural",
                "Di dalam argumen config pada parameter tools",
                "Di dalam argumen config pada parameter history",
                "Di dalam fungsi utama menggunakan prefix global"
            ),
            correctIndex = 1,
            explanation = "Daftar fungsi dimasukkan ke `config=types.GenerateContentConfig(tools=[...])`."
        ),
        QuizQuestion(
            id = "p3-21",
            babId = "bab-1",
            topicId = "1.2",
            nomorAsli = 21,
            question = "Tanda asteris ganda `**` tidak digunakan dalam materi ini, namun operasi apa yang dilambangkan oleh operator tunggal `*` pada `barang[\"qty\"] * barang[\"harga\"]`?",
            options = listOf(
                "Pencarian data (Regex)",
                "Pointer Variabel Memori",
                "Perkalian (Multiplication)",
                "Pemangkatan (Exponent)"
            ),
            correctIndex = 2,
            explanation = "Operator `*` tunggal melambangkan perkalian, sedangkan `**` melambangkan pemangkatan."
        ),
        QuizQuestion(
            id = "p3-22",
            babId = "bab-4",
            topicId = "4.1",
            nomorAsli = 22,
            question = "Pada fungsi API Multi-Agent, apa tujuan membuat wrapper `def ai_tambah_barang(nama, qty):`?",
            options = listOf(
                "Menjembatani SDK AI yang tidak bisa mengakses class",
                "Untuk memodifikasi tipe data string menjadi integer",
                "Mempercepat proses load data ke server backend",
                "Agar SDK Gemini tidak bisa membaca data sensitif"
            ),
            correctIndex = 0,
            explanation = "SDK Gemini membutuhkan fungsi top-level yang berdiri sendiri; wrapper meneruskan panggilan ke method di dalam objek Class."
        ),
        QuizQuestion(
            id = "p3-23",
            babId = "bab-3",
            topicId = "3.2",
            nomorAsli = 23,
            question = "Apa objek konfigurasi spesifik yang dipanggil saat menggunakan `types.GenerateContentConfig(...)`?",
            options = listOf(
                "Untuk mengubah bahasa pemrograman menjadi JSON",
                "Untuk menentukan desain visual dari output AI",
                "Untuk menghapus riwayat obrolan dari memori server",
                "Untuk mengatur parameter sistem, alat, dan format AI"
            ),
            correctIndex = 3,
            explanation = "`GenerateContentConfig` adalah objek konfigurasi untuk menyetel `system_instruction`, `tools`, `response_mime_type`, dan parameter model lainnya."
        ),
        QuizQuestion(
            id = "p3-24",
            babId = "bab-1",
            topicId = "1.5",
            nomorAsli = 24,
            question = "Pada dictionary `katalog = {'buku': 5000}`, bagaimana cara mengambil angka `5000` menggunakan key?",
            options = listOf(
                "katalog.find('buku')",
                "katalog.index('buku')",
                "katalog.value('buku')",
                "katalog.get('buku')"
            ),
            correctIndex = 3,
            explanation = "Selain `katalog['buku']`, method `.get('buku')` adalah cara aman pada Dictionary untuk mengambil value berdasarkan key tanpa KeyError."
        ),
        QuizQuestion(
            id = "p3-25",
            babId = "bab-2",
            topicId = "2.2",
            nomorAsli = 25,
            question = "Dalam metode class, mengapa parameter pertama hampir selalu ditulis menggunakan nama `self`?",
            options = listOf(
                "Untuk mengakses properti milik instans objek tersebut",
                "Untuk mencegah fungsi agar tidak error saat dipanggil",
                "Untuk menunjuk pada fungsi utama di luar",
                "Untuk mengembalikan nilai boolean secara default"
            ),
            correctIndex = 0,
            explanation = "`self` menjadi referensi ke objek (instance) tempat method dipanggil sehingga bisa mengakses `self.katalog` dan `self.keranjang`."
        ),
        QuizQuestion(
            id = "p3-26",
            babId = "bab-1",
            topicId = "1.4",
            nomorAsli = 26,
            question = "Dalam loop `for barang in self.keranjang:`, variabel `barang` merepresentasikan apa?",
            options = listOf(
                "Kunci (key) utama pada dictionary",
                "Panjang keseluruhan dari array",
                "Elemen array pada iterasi saat itu",
                "Indeks angka urutan pada array"
            ),
            correctIndex = 2,
            explanation = "Pada loop `for x in list:`, variabel `x` menampung langsung elemen (nilai/objek) yang sedang diproses pada iterasi tersebut."
        ),
        QuizQuestion(
            id = "p3-27",
            babId = "bab-1",
            topicId = "1.2",
            nomorAsli = 27,
            question = "Dalam sintaks `total += subtotal`, operasi matematika apa yang sebenarnya sedang dieksekusi?",
            options = listOf(
                "Nilai variabel total dikalikan dengan subtotal",
                "Nilai subtotal ditambah, lalu menimpa variabel awal",
                "Nilai total dijumlahkan, lalu disimpan di subtotal",
                "Nilai total ditambah subtotal, lalu menimpa total"
            ),
            correctIndex = 3,
            explanation = "`total += subtotal` identik dengan `total = total + subtotal`: jumlah keduanya disimpan kembali ke `total`."
        ),
        QuizQuestion(
            id = "p3-28",
            babId = "bab-2",
            topicId = "2.1",
            nomorAsli = 28,
            question = "Bagaimana cara mengeksekusi metode `tambah_barang` dari objek yang disimpan di `order_pertama`?",
            options = listOf(
                "tambah_barang(order_pertama, 'buku')",
                "order_pertama->tambah_barang('buku')",
                "OrderSaatIni.tambah_barang('buku')",
                "order_pertama.tambah_barang('buku')"
            ),
            correctIndex = 3,
            explanation = "Method instance selalu dipanggil dengan notasi titik: `nama_instance.nama_method(argumen)`."
        ),
        QuizQuestion(
            id = "p3-29",
            babId = "bab-3",
            topicId = "3.1",
            nomorAsli = 29,
            question = "Apa arti dari tipe pesan kesalahan (Error) `NameError: name 'client' is not defined`?",
            options = listOf(
                "Kata kunci 'client' dilarang untuk nama fungsi Python",
                "Kita mencoba memakai variabel yang belum pernah dibuat",
                "Library server mengalami kebocoran fungsi koneksi",
                "Nama pengguna tidak terdaftar di sistem server cloud"
            ),
            correctIndex = 1,
            explanation = "`NameError` berarti nama variabel tersebut belum didefinisikan (atau cell deklarasinya di Colab belum dijalankan)."
        ),
        QuizQuestion(
            id = "p3-30",
            babId = "bab-3",
            topicId = "3.2",
            nomorAsli = 30,
            question = "Sintaks `model=\"gemini-3.5-flash-lite\"` digunakan untuk mendefinisikan apa pada skrip Python tersebut?",
            options = listOf(
                "Batas waktu (timeout) sebelum API mengalami error",
                "Nama variabel lokal untuk menyimpan memori chat",
                "Jenis mesin/arsitektur LLM spesifik yang digunakan",
                "Tingkat kedalaman sistem analisis pada komputasi"
            ),
            correctIndex = 2,
            explanation = "Parameter `model` menentukan varian LLM Gemini mana yang akan memproses permintaan."
        ),
        QuizQuestion(
            id = "p3-31",
            babId = "bab-2",
            topicId = "2.1",
            nomorAsli = 31,
            question = "Pada baris `order_pertama = OrderSaatIni()`, apa istilah pemrograman yang tepat untuk baris ini?",
            options = listOf(
                "Membuat objek baru (Class Instantiation)",
                "Mengimpor modul (Module Importing)",
                "Menghapus variabel (Garbage Collection)",
                "Mendefinisikan fungsi (Function definition)"
            ),
            correctIndex = 0,
            explanation = "Membuat instance nyata dari sebuah blueprint Class disebut Class Instantiation."
        ),
        QuizQuestion(
            id = "p3-32",
            babId = "bab-1",
            topicId = "1.8",
            nomorAsli = 32,
            question = "Apa hasil dari eksekusi sintaks `nama_barang = 'PeNsiL'.lower()` pada program kasir?",
            options = listOf(
                "Menghasilkan string 'PENSIL'",
                "Menghasilkan string 'peNsil'",
                "Menghasilkan string 'Pensil'",
                "Menghasilkan string 'pensil'"
            ),
            correctIndex = 3,
            explanation = "Method `.lower()` mengubah seluruh karakter huruf menjadi huruf kecil semua: `'pensil'`."
        ),
        QuizQuestion(
            id = "p3-33",
            babId = "bab-1",
            topicId = "1.4",
            nomorAsli = 33,
            question = "Pada fungsi penghapusan, mengapa kita membuat `keranjang_baru = []` daripada menghapus yang lama?",
            options = listOf(
                "Untuk mengubah tipe data dari Tuple menjadi Array",
                "Karena array lama terkunci oleh sistem Python",
                "Agar proses perulangan berjalan lebih cepat dua kali",
                "Agar elemen yang tidak dihapus bisa dipindahkan aman"
            ),
            correctIndex = 3,
            explanation = "Menyalin item yang dipertahankan ke List baru menghindari pergeseran indeks saat looping List yang sama."
        ),
        QuizQuestion(
            id = "p3-34",
            babId = "bab-1",
            topicId = "1.7",
            nomorAsli = 34,
            question = "Bentuk string dengan tanda petik ganda tiga `\"\"\" ... \"\"\"` dimanfaatkan dalam konfigurasi API untuk?",
            options = listOf(
                "Membentuk teks panjang yang memakan beberapa baris (Multiline)",
                "Menyisipkan kode Javascript secara langsung ke dalam Python",
                "Mengesahkan struktur kode agar tidak terdeteksi oleh antivirus",
                "Menyembunyikan informasi kredensial yang sensitif pada file"
            ),
            correctIndex = 0,
            explanation = "Triple-quotes (`\"\"\"...\"\"\"`) dipakai untuk menulis teks panjang multi-baris seperti `system_instruction` dan Docstring."
        ),
        QuizQuestion(
            id = "p3-35",
            babId = "bab-1",
            topicId = "1.4",
            nomorAsli = 35,
            question = "Jika blok `if barang['nama_barang'] != nama_barang_dibuang:` bernilai Benar (True), apa arti kondisi tersebut?",
            options = listOf(
                "Nama barang tersebut bukan target yang ingin dibuang",
                "Nama barang terdeteksi memiliki format huruf kecil",
                "Nama barang pada iterasi itu sama persis ukurannya",
                "Nama barang adalah elemen utama yang akan dihapus"
            ),
            correctIndex = 0,
            explanation = "Operator `!=` berarti \"tidak sama dengan\". Jika True, barang tersebut BUKAN yang mau dihapus sehingga aman disalin ke `keranjang_baru`."
        ),
        QuizQuestion(
            id = "p3-36",
            babId = "bab-2",
            topicId = "2.2",
            nomorAsli = 36,
            question = "Jika kita hanya menulis `keranjang = []` di dalam `__init__` tanpa menggunakan awalan `self.`, apa dampaknya?",
            options = listOf(
                "Variabel hanya eksis dan hilang setelah fungsi selesai",
                "Variabel menjadi bersifat global untuk semua class",
                "Variabel bisa diakses metode lain tanpa masalah",
                "Variabel menjadi statis dan tidak bisa diubah nilainya"
            ),
            correctIndex = 0,
            explanation = "Tanpa `self.`, `keranjang` hanya menjadi variabel lokal milik `__init__` dan lenyap begitu `__init__` selesai dieksekusi."
        ),
        QuizQuestion(
            id = "p3-37",
            babId = "bab-1",
            topicId = "1.5",
            nomorAsli = 37,
            question = "Sintaks pengkondisian `if nama_barang not in self.katalog:` berfungsi utama untuk menangani hal apa?",
            options = listOf(
                "Menambahkan barang baru otomatis ke dalam katalog",
                "Mengubah nama barang menjadi format huruf kapital",
                "Menghindari error jika kunci dictionary tidak ada",
                "Mengecek apakah harga barang sudah kedaluwarsa"
            ),
            correctIndex = 2,
            explanation = "Mengecek `not in` terlebih dahulu mencegah `KeyError` ketika pengguna menanyakan barang yang tidak dijual di toko."
        ),
        QuizQuestion(
            id = "p3-38",
            babId = "bab-2",
            topicId = "2.3",
            nomorAsli = 38,
            question = "Jika kita menetapkan `harga: int` di Pydantic, lalu kita masukkan string teks `'Lima Ribu'`, apa yang Pydantic lakukan?",
            options = listOf(
                "Mengabaikan data dan mengubahnya menjadi nilai nol",
                "Menyimpannya tetap sebagai tipe data string teks",
                "Menolak data dan menghasilkan sistem error fatal",
                "Mencoba mengubah teks angka itu menjadi integer asli"
            ),
            correctIndex = 2,
            explanation = "Pydantic akan menolak input non-numerik untuk field `int` dan memicu `ValidationError`."
        ),
        QuizQuestion(
            id = "p3-39",
            babId = "bab-3",
            topicId = "3.5",
            nomorAsli = 39,
            question = "Manakah pernyataan yang benar terkait sintaks tipe `list[str]` di dalam pendefinisian schema TypedDict?",
            options = listOf(
                "Menerima dictionary dengan string sebagai kunci",
                "Menerima array/list yang berisi elemen string teks",
                "Hanya menerima satu buah string pendek",
                "Menerima list dengan gabungan angka dan string"
            ),
            correctIndex = 1,
            explanation = "`list[str]` berarti tipe data berupa List/array yang setiap elemennya bertipe string (`str`)."
        ),
        QuizQuestion(
            id = "p3-40",
            babId = "bab-3",
            topicId = "3.3",
            nomorAsli = 40,
            question = "Tujuan dari parameter `system_instruction` pada `GenerateContentConfig` adalah untuk...",
            options = listOf(
                "Mengirimkan pesan pertama pengguna ke server utama",
                "Menjalankan kode Python secara otomatis di background",
                "Memberi aturan dasar, persona, dan tata cara bagi AI",
                "Membatasi jumlah kata pada input dan output pengguna"
            ),
            correctIndex = 2,
            explanation = "`system_instruction` menetapkan peran, gaya bahasa, aturan pemakaian tools, dan batasan bagi model AI."
        ),
        QuizQuestion(
            id = "p3-41",
            babId = "bab-1",
            topicId = "1.3",
            nomorAsli = 41,
            question = "Dalam fungsi `invoice`, tipe data `int` pada parameter `pajak` diubah oleh ekspresi `(pajak/100)`. Apa yang terjadi?",
            options = listOf(
                "Ekspresi itu menghasilkan error sistem logika",
                "Integer akan tetap menjadi bilangan bulat statis",
                "Hasil baginya akan otomatis berubah menjadi tipe Float",
                "Pajak otomatis berubah menjadi array baru"
            ),
            correctIndex = 2,
            explanation = "Di Python 3, operator pembagian `/` selalu menghasilkan bilangan desimal (`float`), misalnya `10 / 100` menjadi `0.1`."
        ),
        QuizQuestion(
            id = "p3-42",
            babId = "bab-3",
            topicId = "3.4",
            nomorAsli = 42,
            question = "Dalam kode chat, `history=[]` dideklarasikan saat memulai sesi. Apa tujuan dari array kosong ini?",
            options = listOf(
                "Menghapus akun pengguna dari database server lokal",
                "Menginisialisasi sesi percakapan baru yang masih bersih",
                "Mengunci memori agar tidak bisa diakses pengguna",
                "Memberi tahu sistem bahwa riwayat sebelumnya telah gagal"
            ),
            correctIndex = 1,
            explanation = "`history=[]` menandakan sesi obrolan dimulai dari nol (tanpa riwayat percakapan sebelumnya)."
        ),
        QuizQuestion(
            id = "p3-43",
            babId = "bab-3",
            topicId = "3.5",
            nomorAsli = 43,
            question = "Apa yang terjadi jika API kita konfigurasi dengan `response_mime_type=\"application/json\"`?",
            options = listOf(
                "AI wajib memberikan jawaban berupa struktur data JSON murni",
                "AI mengabaikan prompt yang tidak memiliki kode bahasa JSON",
                "AI akan menyimpan riwayat percakapan dalam bentuk JSON",
                "AI hanya bisa memproses input yang berasal dari file JSON"
            ),
            correctIndex = 0,
            explanation = "Pengaturan MIME type tersebut memaksa model hanya menghasilkan output JSON murni yang valid secara sintaks."
        ),
        QuizQuestion(
            id = "p3-44",
            babId = "bab-2",
            topicId = "2.2",
            nomorAsli = 44,
            question = "Jika terdapat properti `self.keranjang` di `__init__`, bagaimana cara mengaksesnya dari metode lain?",
            options = listOf(
                "Dengan menuliskan OrderSaatIni.keranjang",
                "Dengan menuliskan self.keranjang",
                "Dengan menuliskan this.keranjang",
                "Dengan menuliskan global keranjang"
            ),
            correctIndex = 1,
            explanation = "Setiap method di Class yang sama memakai parameter `self` untuk membaca atau mengubah `self.keranjang`."
        ),
        QuizQuestion(
            id = "p3-45",
            babId = "bab-2",
            topicId = "2.2",
            nomorAsli = 45,
            question = "Apa fungsi wajib (konstruktor) yang pertama kali dipanggil secara otomatis saat objek Python dibuat?",
            options = listOf(
                "Fungsi def __build__(self):",
                "Fungsi def __start__(self):",
                "Fungsi def __main__(self):",
                "Fungsi def __init__(self):"
            ),
            correctIndex = 3,
            explanation = "`__init__(self)` adalah konstruktor bawaan Python yang selalu dieksekusi otomatis saat Class diinstansiasi."
        )
)
