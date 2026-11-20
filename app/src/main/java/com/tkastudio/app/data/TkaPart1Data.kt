package com.tkastudio.app.data

import com.tkastudio.app.model.QuizQuestion

val quizPart1Questions: List<QuizQuestion> = listOf(
        QuizQuestion(
            id = "p1-1",
            babId = "bab-1",
            topicId = "1.5",
            nomorAsli = 1,
            question = "Apa perbedaan utama antara List dan Dictionary di Python dalam hal cara mengakses datanya?",
            options = listOf(
                "List diakses dengan nama/key, Dictionary dengan angka/indeks",
                "List diakses dengan angka/indeks, Dictionary dengan nama/key",
                "Keduanya diakses dengan angka",
                "Keduanya diakses dengan huruf",
                "List tidak bisa diakses sama sekali"
            ),
            correctIndex = 1,
            explanation = "List menyimpan elemen berdasarkan urutan indeks numerik (mulai dari 0, misal `list[0]`), sedangkan Dictionary menyimpan pasangan key:value sehingga diakses lewat nama key-nya (`dict[\"buku\"]`)."
        ),
        QuizQuestion(
            id = "p1-2",
            babId = "bab-1",
            topicId = "1.5",
            nomorAsli = 2,
            question = "Bagaimana cara menginisialisasi list kosong di Python?",
            options = listOf(
                "list = {}",
                "list = ()",
                "list = []",
                "list = empty",
                "list = 0"
            ),
            correctIndex = 2,
            explanation = "Kurung siku `[]` mendefinisikan List kosong. Kurung kurawal `{}` adalah Dictionary kosong, dan kurung biasa `()` adalah Tuple."
        ),
        QuizQuestion(
            id = "p1-3",
            babId = "bab-2",
            topicId = "2.2",
            nomorAsli = 3,
            question = "Apa tujuan utama dari variabel `self.keranjang = []` dalam aplikasi kasir yang kita buat?",
            options = listOf(
                "Menyimpan seluruh daftar barang yang dijual",
                "Menyimpan riwayat chat (pesan) dengan AI",
                "Menyimpan daftar barang yang sedang ingin dibeli (State Management)",
                "Menghapus barang dari memori",
                "Menghubungkan ke API Gemini"
            ),
            correctIndex = 2,
            explanation = "`self.keranjang` bertugas sebagai State Management di objek `OrderSaatIni` untuk mencatat barang apa saja yang sudah ditambahkan pelanggan selama sesi belanja."
        ),
        QuizQuestion(
            id = "p1-4",
            babId = "bab-1",
            topicId = "1.5",
            nomorAsli = 4,
            question = "Jika kita memiliki list `katalog = ['Pensil', 'Buku']`, bagaimana cara mengakses kata `'Buku'`?",
            options = listOf(
                "katalog[0]",
                "katalog['Buku']",
                "katalog[1]",
                "katalog.get(1)",
                "katalog.Buku"
            ),
            correctIndex = 2,
            explanation = "Indeks List Python dimulai dari 0: `katalog[0]` adalah `'Pensil'`, dan `katalog[1]` adalah `'Buku'`."
        ),
        QuizQuestion(
            id = "p1-5",
            babId = "bab-1",
            topicId = "1.4",
            nomorAsli = 5,
            question = "Perintah apa yang digunakan untuk keluar dari perulangan `while True:` ketika pengguna mengetik kata `'keluar'`?",
            options = listOf(
                "stop",
                "exit()",
                "continue",
                "break",
                "return"
            ),
            correctIndex = 3,
            explanation = "`break` langsung menghentikan perulangan `while True` dan keluar dari blok loop. Berbeda dari `continue` yang hanya melompat ke iterasi selanjutnya."
        ),
        QuizQuestion(
            id = "p1-6",
            babId = "bab-1",
            topicId = "1.2",
            nomorAsli = 6,
            question = "Bagaimana cara menghitung subtotal belanja (harga satu jenis barang dikali jumlah barangnya)?",
            options = listOf(
                "subtotal = barang['harga'] + barang['qty']",
                "subtotal = barang['harga'] * barang['qty']",
                "subtotal = barang['harga'] - barang['qty']",
                "subtotal = barang['harga'] / barang['qty']",
                "subtotal = total * qty"
            ),
            correctIndex = 1,
            explanation = "Perkalian di Python memakai operator asteris tunggal `*`, yaitu harga satuan dikali kuantitas (`qty`)."
        ),
        QuizQuestion(
            id = "p1-7",
            babId = "bab-1",
            topicId = "1.2",
            nomorAsli = 7,
            question = "Dalam sistem kasir, variabel apa yang digunakan untuk mengakumulasi total harga dari seluruh barang di keranjang?",
            options = listOf(
                "total = 0",
                "qty",
                "nama_barang",
                "subtotal",
                "stok"
            ),
            correctIndex = 0,
            explanation = "Variabel akumulator `total = 0` diinisialisasi nol di awal sebelum loop berjalan, lalu nilainya ditambah `subtotal` tiap barang (`total += subtotal`)."
        ),
        QuizQuestion(
            id = "p1-8",
            babId = "bab-1",
            topicId = "1.4",
            nomorAsli = 8,
            question = "Di dalam fungsi `hapus_barang`, pendekatan apa yang paling aman untuk menghapus item tertentu dari keranjang yang berbentuk List?",
            options = listOf(
                "Gunakan metode .pop()",
                "Gunakan metode .delete()",
                "Ubah keranjang menjadi None",
                "Buat List baru, salin item yang TIDAK dihapus ke List baru, lalu timpa variabel keranjang lama",
                "Hapus file Python-nya"
            ),
            correctIndex = 3,
            explanation = "Menghapus elemen sambil melakukan loop di List yang sama bisa menggeser indeks dan menimbulkan bug. Memfilter ke `keranjang_baru = []` lalu menimpa `self.keranjang` jauh lebih aman."
        ),
        QuizQuestion(
            id = "p1-9",
            babId = "bab-2",
            topicId = "2.3",
            nomorAsli = 9,
            question = "Di Pydantic, jika kita menulis `harga: int`, apa yang terjadi jika ada yang mencoba memasukkan harga berupa teks huruf `'sepuluh ribu'`?",
            options = listOf(
                "Otomatis berubah menjadi angka",
                "Ditolak Pydantic dan error validasi",
                "Program akan tetap berjalan",
                "Teks akan diubah menjadi 0",
                "Pydantic akan menghapusnya"
            ),
            correctIndex = 1,
            explanation = "Pydantic menjalankan validasi tipe data otomatis. Karena `'sepuluh ribu'` tidak dapat diubah menjadi integer, Pydantic menolak dan melempar `ValidationError`."
        ),
        QuizQuestion(
            id = "p1-10",
            babId = "bab-4",
            topicId = "4.1",
            nomorAsli = 10,
            question = "Dalam studi kasus ini, jika pengguna ingin melihat katalog barang, bagaimana cara kerja sistem AI?",
            options = listOf(
                "AI mencari informasi di internet",
                "AI membaca Docstring, menyadari harus memanggil fungsi ai_lihat_katalog, menjalankan fungsi tersebut, membaca teks hasil return-nya, lalu menjawab ke pengguna",
                "AI langsung mencetak array katalog ke layar pengguna",
                "AI mengunduh database toko",
                "AI menanyakan ke database"
            ),
            correctIndex = 1,
            explanation = "Gemini membaca Docstring setiap fungsi di `tools`, memilih `ai_lihat_katalog`, menerima hasil string dari `return`, lalu menyusun jawaban natural ke pengguna."
        ),
        QuizQuestion(
            id = "p1-11",
            babId = "bab-1",
            topicId = "1.2",
            nomorAsli = 11,
            question = "Simbol operasi matematika apa yang digunakan di Python untuk penambahan ke variabel yang sama, yang merupakan singkatan dari `total = total + subtotal`?",
            options = listOf(
                "++",
                "--",
                "+=",
                "==",
                "+=="
            ),
            correctIndex = 2,
            explanation = "Operator assignment `+=` menambahkan nilai di sebelah kanan ke variabel di sebelah kiri lalu menyimpannya kembali ke variabel tersebut."
        ),
        QuizQuestion(
            id = "p1-12",
            babId = "bab-2",
            topicId = "2.3",
            nomorAsli = 12,
            question = "Di Pydantic, jika kita tidak menentukan nilai awal (default) untuk sebuah properti, maka properti tersebut menjadi...",
            options = listOf(
                "Opsional",
                "Wajib diisi saat objek dibuat (Required)",
                "Bernilai None",
                "Akan memicu peringatan saja",
                "Akan diisi 0 otomatis"
            ),
            correctIndex = 1,
            explanation = "Field tanpa nilai default di Pydantic `BaseModel` bersifat wajib (required) dan akan error jika tidak diberikan saat instansiasi."
        ),
        QuizQuestion(
            id = "p1-13",
            babId = "bab-1",
            topicId = "1.4",
            nomorAsli = 13,
            question = "Di Python, spasi atau indentasi di awal baris kode sangat penting. Indentasi digunakan untuk menunjukkan...",
            options = listOf(
                "Nama variabel",
                "Komentar kode",
                "Blok kode yang masuk ke If, For, atau fungsi",
                "Tipe data",
                "Kecepatan eksekusi"
            ),
            correctIndex = 2,
            explanation = "Berbeda dari bahasa lain yang memakai `{ }`, Python menggunakan indentasi (spasi menjorok ke dalam) untuk menentukan cakupan blok kode."
        ),
        QuizQuestion(
            id = "p1-14",
            babId = "bab-1",
            topicId = "1.5",
            nomorAsli = 14,
            question = "Jika kita memiliki dictionary `katalog = {'pensil': 2000, 'buku': 5000}`, bagaimana cara mengambil harga buku?",
            options = listOf(
                "katalog[1]",
                "katalog['buku']",
                "katalog.buku",
                "katalog[0]",
                "katalog('buku')"
            ),
            correctIndex = 1,
            explanation = "Nilai pada Dictionary diambil dengan menuliskan nama key di dalam kurung siku: `katalog['buku']`."
        ),
        QuizQuestion(
            id = "p1-15",
            babId = "bab-1",
            topicId = "1.4",
            nomorAsli = 15,
            question = "Apa arti dari struktur kode `while True:` di Python?",
            options = listOf(
                "Perulangan yang hanya berjalan satu kali",
                "Perulangan yang mengecek apakah error bernilai True",
                "Perulangan yang berjalan selamanya sampai 'break'",
                "Perulangan yang salah",
                "Kondisi If-Else biasa"
            ),
            correctIndex = 2,
            explanation = "Karena kondisinya selalu `True`, `while True:` membentuk infinite loop yang hanya berhenti jika menemui perintah `break`."
        ),
        QuizQuestion(
            id = "p1-16",
            babId = "bab-1",
            topicId = "1.3",
            nomorAsli = 16,
            question = "Tipe data apa yang tepat untuk properti `'harga'` jika harganya adalah bilangan bulat (misal: 5000)?",
            options = listOf(
                "str",
                "float",
                "int",
                "bool",
                "list"
            ),
            correctIndex = 2,
            explanation = "Angka bulat tanpa koma/desimal seperti 5000 direpresentasikan dengan tipe `int` (Integer)."
        ),
        QuizQuestion(
            id = "p1-17",
            babId = "bab-1",
            topicId = "1.4",
            nomorAsli = 17,
            question = "Pada fungsi `lihat_keranjang`, apa yang dilakukan oleh baris kode `if not self.keranjang:`?",
            options = listOf(
                "Mengecek apakah variabel keranjang itu ada/didefinisikan",
                "Mengecek apakah panjang keranjang adalah nol (kosong)",
                "Menghapus isi keranjang",
                "Mengubah nilai keranjang menjadi tidak ada",
                "Menambahkan error pada keranjang"
            ),
            correctIndex = 1,
            explanation = "Di Python, List kosong `[]` dianggap falsy. Jadi `if not self.keranjang:` bernilai `True` ketika keranjang masih kosong."
        ),
        QuizQuestion(
            id = "p1-18",
            babId = "bab-3",
            topicId = "3.3",
            nomorAsli = 18,
            question = "Apa istilah untuk teks panjang yang kita tulis di bagian `system_instruction` untuk memberikan 'kepribadian' atau aturan kerja bagi AI?",
            options = listOf(
                "Python Script",
                "System Prompt / Instruction",
                "Function Calling",
                "Pydantic Model",
                "Docstring"
            ),
            correctIndex = 1,
            explanation = "`system_instruction` berisi System Prompt yang mendefinisikan persona, peran, dan batasan perilaku AI sebelum menerima input user."
        ),
        QuizQuestion(
            id = "p1-19",
            babId = "bab-1",
            topicId = "1.7",
            nomorAsli = 19,
            question = "Jika kita memiliki kode `teks = 'Halo ' + 'Dunia'`, apa isi variabel `teks`?",
            options = listOf(
                "HaloDunia",
                "Halo Dunia",
                "Halo + Dunia",
                "Error",
                "Halo"
            ),
            correctIndex = 1,
            explanation = "Operator `+` menyambungkan kedua string secara apa adanya. Karena `'Halo '` memiliki spasi di belakangnya, di Python hasilnya adalah `'Halo Dunia'` (jika tanpa spasi `'Halo' + 'Dunia'`, barulah menjadi `'HaloDunia'`)."
        ),
        QuizQuestion(
            id = "p1-20",
            babId = "bab-4",
            topicId = "4.1",
            nomorAsli = 20,
            question = "Apa nama fitur di mana AI bisa mengeksekusi kode atau fungsi Python buatan kita sendiri (misal: fungsi `ai_tambah_barang`)?",
            options = listOf(
                "State Management",
                "Prompt Engineering",
                "Function Calling",
                "Data Validation",
                "Machine Learning"
            ),
            correctIndex = 2,
            explanation = "Function Calling memungkinkan LLM memilih dan memicu fungsi eksternal buatan kita saat memproses permintaan user."
        ),
        QuizQuestion(
            id = "p1-21",
            babId = "bab-1",
            topicId = "1.5",
            nomorAsli = 21,
            question = "Tipe data struktur di Python yang menyimpan data dalam format pasangan `key: value` adalah?",
            options = listOf(
                "List",
                "Dictionary",
                "Set",
                "Float",
                "Boolean"
            ),
            correctIndex = 1,
            explanation = "Dictionary (`{...}`) menyimpan data secara asosiatif dalam pasangan kunci (`key`) dan nilai (`value`)."
        ),
        QuizQuestion(
            id = "p1-22",
            babId = "bab-1",
            topicId = "1.5",
            nomorAsli = 22,
            question = "Fungsi/method apa yang digunakan untuk menambahkan item baru ke bagian akhir sebuah List di Python?",
            options = listOf(
                "add()",
                "insert()",
                "push()",
                "append()",
                "extend()"
            ),
            correctIndex = 3,
            explanation = "Method `.append(item)` selalu menambahkan satu elemen baru ke posisi paling belakang (akhir) sebuah List."
        ),
        QuizQuestion(
            id = "p1-23",
            babId = "bab-4",
            topicId = "4.2",
            nomorAsli = 23,
            question = "Mengapa kita tidak menyuruh AI untuk langsung melakukan perhitungan matematika (seperti 5 barang diskon 15%) dan memilih menyerahkan hitungannya pada program Python?",
            options = listOf(
                "Karena AI dilarang melakukan matematika",
                "Karena AI (LLM) sering salah hitung, jadi lebih aman dihitung di program Python",
                "Karena hitungan Python lebih lambat",
                "Karena Python punya library AI",
                "Agar kode Python terlihat lebih panjang"
            ),
            correctIndex = 1,
            explanation = "LLM memprediksi teks berdasarkan pola probabilistik sehingga rentan salah hitung. Program Python menghitung aritmetika secara deterministik dan akurat."
        ),
        QuizQuestion(
            id = "p1-24",
            babId = "bab-4",
            topicId = "4.1",
            nomorAsli = 24,
            question = "Bagaimana cara AI (Gemini) tahu fungsi apa saja yang bisa dia panggil, dan kapan harus memanggilnya?",
            options = listOf(
                "AI membaca seluruh file Python",
                "AI menebak dari nama variabel",
                "AI membaca Docstring (teks dalam tanda kutip tiga) pada fungsi yang kita daftarkan di parameter 'tools'",
                "AI mencarinya di Google",
                "AI sudah dilatih dari awal untuk kasir"
            ),
            correctIndex = 2,
            explanation = "Gemini mengandalkan Docstring (`\"\"\"...\"\"\"`) serta tipe parameter dari fungsi yang didaftarkan di parameter `tools=[...]` untuk memahami kapan tool dipanggil."
        ),
        QuizQuestion(
            id = "p1-25",
            babId = "bab-1",
            topicId = "1.8",
            nomorAsli = 25,
            question = "Fungsi/perintah `.lower()` pada variabel `nama_barang` (misal: `nama_barang = nama_barang.lower()`) berguna untuk apa?",
            options = listOf(
                "Mengecilkan ukuran variabel di memori",
                "Menghapus spasi di teks",
                "Mengubah semua huruf dalam teks menjadi huruf kecil agar pencarian lebih mudah",
                "Menghapus huruf vokal",
                "Mengurutkan teks sesuai abjad"
            ),
            correctIndex = 2,
            explanation = "Python bersifat case-sensitive. `.lower()` menyeragamkan input seperti `\"PeNsiL\"` atau `\"PENSIL\"` menjadi `\"pensil\"` agar pencarian cocok."
        ),
        QuizQuestion(
            id = "p1-26",
            babId = "bab-1",
            topicId = "1.6",
            nomorAsli = 26,
            question = "Apa perintah yang harus digunakan agar sebuah fungsi mengirimkan nilai (output) kembali ke bagian kode yang memanggilnya?",
            options = listOf(
                "print",
                "return",
                "output",
                "send",
                "echo"
            ),
            correctIndex = 1,
            explanation = "`return` mengembalikan hasil fungsi ke pemanggil (baik variabel Python lain maupun SDK AI), sedangkan `print` hanya menampilkan di layar."
        ),
        QuizQuestion(
            id = "p1-27",
            babId = "bab-1",
            topicId = "1.2",
            nomorAsli = 27,
            question = "Tanda pagar `#` di dalam kode Python digunakan untuk?",
            options = listOf(
                "Membuat variabel baru",
                "Mengeksekusi perintah khusus",
                "Membuat komentar/catatan di dalam kode",
                "Menambahkan library",
                "Mengakhiri baris program"
            ),
            correctIndex = 2,
            explanation = "Tanda `#` menandai komentar satu baris yang diabaikan oleh interpreter Python saat eksekusi."
        ),
        QuizQuestion(
            id = "p1-28",
            babId = "bab-2",
            topicId = "2.2",
            nomorAsli = 28,
            question = "Jika variabel `katalog` dibuat di dalam fungsi `__init__`, bagaimana cara mengakses variabel tersebut di dalam fungsi `tambah_barang` pada Class yang sama?",
            options = listOf(
                "katalog",
                "this.katalog",
                "OrderSaatIni.katalog",
                "self.katalog",
                "global katalog"
            ),
            correctIndex = 3,
            explanation = "Atribut objek yang disimpan sebagai `self.katalog` di `__init__` diakses oleh metode lain di Class yang sama melalui `self.katalog`."
        ),
        QuizQuestion(
            id = "p1-29",
            babId = "bab-1",
            topicId = "1.1",
            nomorAsli = 29,
            question = "Fungsi bawaan Python apa yang digunakan untuk menerima input teks dari pengguna di terminal?",
            options = listOf(
                "print()",
                "read()",
                "input()",
                "get()",
                "scan()"
            ),
            correctIndex = 2,
            explanation = "`input()` membaca teks yang diketikkan pengguna di terminal/konsol dan mengembalikannya sebagai string."
        ),
        QuizQuestion(
            id = "p1-30",
            babId = "bab-1",
            topicId = "1.5",
            nomorAsli = 30,
            question = "Jika kita menggunakan List untuk `self.katalog`, apa yang harus kita lakukan untuk mencari barang berdasarkan namanya di fungsi `tambah_barang`?",
            options = listOf(
                "Gunakan self.katalog[nama_barang]",
                "Gunakan metode self.katalog.find()",
                "Gunakan dictionary",
                "Lakukan perulangan (for loop) satu per satu pada List dan cek namanya",
                "Langsung return None"
            ),
            correctIndex = 3,
            explanation = "List tidak bisa diakses langsung dengan nama string seperti Dictionary. Kita harus looping `for item in self.katalog:` dan memeriksa `item.nama.lower() == nama_barang`."
        ),
        QuizQuestion(
            id = "p1-31",
            babId = "bab-2",
            topicId = "2.3",
            nomorAsli = 31,
            question = "Library/Modul apa di Python yang digunakan untuk memvalidasi tipe data pada sebuah Class secara otomatis (seperti yang kita gunakan untuk Class `Item`)?",
            options = listOf(
                "Pandas",
                "Pydantic",
                "Numpy",
                "Requests",
                "Flask"
            ),
            correctIndex = 1,
            explanation = "Pydantic (`from pydantic import BaseModel`) memvalidasi tipe data properti Class secara otomatis."
        ),
        QuizQuestion(
            id = "p1-32",
            babId = "bab-1",
            topicId = "1.3",
            nomorAsli = 32,
            question = "Apa arti dari tipe data `float`?",
            options = listOf(
                "Teks panjang",
                "Bilangan bulat",
                "Bilangan pecahan/desimal",
                "Benar/Salah",
                "Koleksi data"
            ),
            correctIndex = 2,
            explanation = "`float` (floating-point) menyimpan angka pecahan atau desimal yang memiliki titik desimal, misalnya `0.15` atau `2.5`."
        ),
        QuizQuestion(
            id = "p1-33",
            babId = "bab-4",
            topicId = "4.1",
            nomorAsli = 33,
            question = "Saat AI (Gemini) memanggil sebuah fungsi di Python (Function Calling), apa yang terjadi jika fungsi tersebut HANYA menggunakan `print` dan tidak menggunakan `return`?",
            options = listOf(
                "AI membaca tulisan di layar",
                "Fungsi tidak berjalan sama sekali",
                "AI menerima nilai kosong (None) dan bisa jadi salah menjawab",
                "Program Python langsung crash",
                "AI akan mencetak sendiri outputnya"
            ),
            correctIndex = 2,
            explanation = "Output `print()` hanya muncul di layar lokal dan tidak dikirim balik ke server Gemini, sehingga AI menerima `None` dan berisiko mengarang jawaban."
        ),
        QuizQuestion(
            id = "p1-34",
            babId = "bab-2",
            topicId = "2.3",
            nomorAsli = 34,
            question = "Jika kita ingin menyimpan beberapa kata kunci dalam properti `'tags'` (misal: `['coding', 'python']`), tipe data apa yang harus digunakan di Pydantic?",
            options = listOf(
                "str",
                "int",
                "bool",
                "list",
                "tuple"
            ),
            correctIndex = 3,
            explanation = "Kumpulan beberapa item di dalam kurung siku `['coding', 'python']` bertipe `list` (atau `list[str]`)."
        ),
        QuizQuestion(
            id = "p1-35",
            babId = "bab-2",
            topicId = "2.3",
            nomorAsli = 35,
            question = "Jika kita memiliki perulangan: `for item in self.katalog:`, dan katalog adalah sebuah List yang berisi objek Pydantic `'Item'`. Bagaimana cara kita mencetak nama dari barang tersebut?",
            options = listOf(
                "print(item['nama'])",
                "print(item.nama)",
                "print(self.katalog.nama)",
                "print(item[0])",
                "print(nama)"
            ),
            correctIndex = 1,
            explanation = "Karena `item` adalah instance objek Pydantic `Item` (bukan dictionary), atributnya diakses dengan notasi titik: `item.nama`."
        ),
        QuizQuestion(
            id = "p1-36",
            babId = "bab-1",
            topicId = "1.7",
            nomorAsli = 36,
            question = "Bagaimana cara kita menggabungkan (mengumpulkan) beberapa teks di dalam perulangan `for` agar bisa di-return sekaligus di akhir fungsi?",
            options = listOf(
                "Menggunakan perintah print() berulang kali",
                "Menyimpan ke dalam variabel List lalu return",
                "Menambahkan teks ke dalam satu variabel String menggunakan operator +=, lalu return variabel tersebut",
                "Tidak bisa, harus return satu per satu",
                "Menggunakan perintah yield()"
            ),
            correctIndex = 2,
            explanation = "Seperti pada `lihat_keranjang`, siapkan `hasil_teks = \"\"` lalu tambahkan baris demi baris memakai `hasil_teks += f\"...\"` dan di akhir `return hasil_teks`."
        ),
        QuizQuestion(
            id = "p1-37",
            babId = "bab-4",
            topicId = "4.3",
            nomorAsli = 37,
            question = "Jika kita memasukkan fungsi `buat_rekomendasi` ke dalam parameter `tools=[...]`, apa keunggulan fungsi ini dibandingkan fungsi lainnya?",
            options = listOf(
                "Bisa menambah barang ke keranjang",
                "Fungsi ini memanggil LLM model lain beda dari fungsi lain hanya menjalankan logika biasa",
                "Bisa menghapus katalog",
                "Tidak bisa error",
                "Lebih hemat baterai"
            ),
            correctIndex = 1,
            explanation = "Di dalam `buat_rekomendasi`, fungsi memanggil `client.models.generate_content(...)` lagi (pola Agent memanggil sub-Agent spesialis) sementara fungsi kasir lain hanya menjalankan logika Python biasa."
        ),
        QuizQuestion(
            id = "p1-38",
            babId = "bab-1",
            topicId = "1.3",
            nomorAsli = 38,
            question = "Tipe data apa yang tepat untuk properti `'tersedia'` yang hanya bisa bernilai `True` (Benar) atau `False` (Salah)?",
            options = listOf(
                "int",
                "str",
                "list",
                "bool",
                "dict"
            ),
            correctIndex = 3,
            explanation = "Nilai biner Benar/Salah (`True`/`False`) menggunakan tipe data Boolean (`bool`)."
        ),
        QuizQuestion(
            id = "p1-39",
            babId = "bab-2",
            topicId = "2.2",
            nomorAsli = 39,
            question = "Kata kunci apa yang wajib digunakan sebagai parameter pertama dalam metode di dalam sebuah Class Python untuk merujuk pada objek itu sendiri?",
            options = listOf(
                "self",
                "this",
                "itself",
                "me",
                "object"
            ),
            correctIndex = 0,
            explanation = "Konvensi wajib di Python untuk parameter pertama setiap method Class adalah `self`."
        ),
        QuizQuestion(
            id = "p1-40",
            babId = "bab-4",
            topicId = "4.2",
            nomorAsli = 40,
            question = "Apa fungsi dari blok `try... except Exception as e:` yang kita gunakan pada loop chat aplikasi kasir?",
            options = listOf(
                "Untuk mempercepat koneksi internet",
                "Untuk menangkap error agar tidak langsung crash",
                "Untuk mengirim error ke pengguna",
                "Untuk meretas API Gemini",
                "Hanya sebagai hiasan kode"
            ),
            correctIndex = 1,
            explanation = "Blok `try...except` menangani error runtime (misal koneksi API putus sementara) dengan aman sehingga loop percakapan tidak berhenti mendadak."
        ),
        QuizQuestion(
            id = "p1-41",
            babId = "bab-1",
            topicId = "1.5",
            nomorAsli = 41,
            question = "Tipe data struktur di Python yang menggunakan tanda kurung siku `[...]` adalah?",
            options = listOf(
                "Dictionary",
                "List",
                "Tuple",
                "String",
                "Integer"
            ),
            correctIndex = 1,
            explanation = "Kurung siku `[...]` digunakan untuk membuat tipe data List di Python."
        ),
        QuizQuestion(
            id = "p1-42",
            babId = "bab-2",
            topicId = "2.2",
            nomorAsli = 42,
            question = "Apa nama fungsi khusus yang pertama kali dijalankan secara otomatis saat kita membuat sebuah objek (instance) dari suatu Class di Python?",
            options = listOf(
                "__main__",
                "__init__",
                "__start__",
                "__setup__",
                "__run__"
            ),
            correctIndex = 1,
            explanation = "`__init__` adalah konstruktor Python yang otomatis berjalan setiap kali `NamaClass()` dipanggil untuk membuat instance."
        ),
        QuizQuestion(
            id = "p1-43",
            babId = "bab-2",
            topicId = "2.3",
            nomorAsli = 43,
            question = "Manakah di bawah ini yang merupakan contoh pendefinisian Class menggunakan Pydantic?",
            options = listOf(
                "class Item(BaseModel):",
                "class Item:",
                "class Item(Pydantic):",
                "def Item():",
                "struct Item:"
            ),
            correctIndex = 0,
            explanation = "Model Pydantic dibuat dengan mewarisi `BaseModel` dari modul `pydantic`, yaitu `class Item(BaseModel):`."
        ),
        QuizQuestion(
            id = "p1-44",
            babId = "bab-4",
            topicId = "4.2",
            nomorAsli = 44,
            question = "Mengapa kita perlu memberikan instruksi anti-halusinasi seperti `'Jangan mengarang harga atau stok sendiri'` pada prompt AI?",
            options = listOf(
                "Agar AI tidak error",
                "Agar AI tidak mogok kerja",
                "Karena AI cenderung menebak-nebak (halusinasi) informasi jika tidak dilarang secara eksplisit",
                "Agar AI berjalan lebih cepat",
                "Karena itu syarat dari Python"
            ),
            correctIndex = 2,
            explanation = "Jika tidak dibatasi di `system_instruction`, LLM sering mengarang harga atau barang fiktif agar terdengar membantu."
        ),
        QuizQuestion(
            id = "p1-45",
            babId = "bab-4",
            topicId = "4.2",
            nomorAsli = 45,
            question = "Ketika AI Kasir memberikan tagihan akhir (total) dengan benar kepada pembeli, dari manakah AI mendapatkan perhitungan tersebut?",
            options = listOf(
                "AI menghitung sendiri menggunakan kecerdasan buatannya",
                "AI mendapatkan angka tersebut dari teks (return) oleh program",
                "AI menebak berdasarkan harga pasaran",
                "AI menggunakan kalkulator online",
                "AI bertanya pada API kasir eksternal"
            ),
            correctIndex = 1,
            explanation = "Fungsi Python lokal (`lihat_keranjang`) menghitung totalnya secara akurat lalu me-return string struk kepada Gemini untuk disampaikan ke pembeli."
        ),
        QuizQuestion(
            id = "p1-46",
            babId = "bab-4",
            topicId = "4.1",
            nomorAsli = 46,
            question = "Dalam kode kita, ada fungsi bernama `ai_tambah_barang` yang isinya hanya memanggil `order_pertama.tambah_barang()`. Fungsi `ai_tambah_barang` ini sering disebut sebagai apa?",
            options = listOf(
                "Fungsi Constructor",
                "Fungsi Error",
                "Fungsi Wrapper (Bungkus)",
                "Fungsi Recursive",
                "Fungsi Main"
            ),
            correctIndex = 2,
            explanation = "Wrapper function membungkus pemanggilan method di dalam objek Class agar dapat didaftarkan sebagai fungsi biasa ke parameter `tools` milik Gemini."
        )
)
