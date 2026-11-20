package com.tkastudio.app.data

import com.tkastudio.app.model.QuizQuestion

val quizPart2Questions: List<QuizQuestion> = listOf(
        QuizQuestion(
            id = "p2-1",
            babId = "bab-4",
            topicId = "4.3",
            nomorAsli = 1,
            question = "Apa alasan utama kita menggunakan pola Arsitektur Multi-Agent dibandingkan menggunakan satu Agent AI yang diberikan system prompt sangat panjang (Prompt Bloat)?",
            options = listOf(
                "Agar codingan terlihat lebih rumit",
                "Setiap agen Spesialis dapat memiliki instruksi uniknya sendiri, sehingga meningkatkan akurasi spesifik dan mencegah AI bingung (Prompt Confusion)",
                "Untuk menghemat listrik komputer",
                "Karena Gemini tidak sanggup prompt panjang",
                "Agar AI-nya bisa marah-marah"
            ),
            correctIndex = 1,
            explanation = "Memecah tugas (Separation of Concerns) ke beberapa agen spesialis membuat instruksi masing-masing fokus sehingga mencegah kebingungan AI akibat prompt yang terlalu padat."
        ),
        QuizQuestion(
            id = "p2-2",
            babId = "bab-3",
            topicId = "3.2",
            nomorAsli = 2,
            question = "Properti apa pada objek hasil generasi Gemini yang harus kita panggil untuk mendapatkan teks balasan murninya?",
            options = listOf(
                "response.message",
                "response.text",
                "response.data",
                "response.content",
                "response.body"
            ),
            correctIndex = 1,
            explanation = "SDK Gemini menyimpan hasil string balasan utama di dalam properti `.text` pada objek `response`."
        ),
        QuizQuestion(
            id = "p2-3",
            babId = "bab-4",
            topicId = "4.3",
            nomorAsli = 3,
            question = "Pada skenario Multi-Agent (Routing), apa peran khusus yang dipegang oleh `bos_router`?",
            options = listOf(
                "Menjawab langsung semua pertanyaan",
                "Memblokir pertanyaan sulit",
                "Bertindak sebagai resepsionis; ia membaca niat (intent) user dan mengarahkan panggilan ke fungsi (tool) spesialis yang tepat",
                "Menghapus database",
                "Melakukan kalkulasi matematika"
            ),
            correctIndex = 2,
            explanation = "`bos_router` tidak menyelesaikan pertanyaan secara langsung, melainkan menganalisis intent user lalu memanggil fungsi spesialis yang sesuai."
        ),
        QuizQuestion(
            id = "p2-4",
            babId = "bab-4",
            topicId = "4.1",
            nomorAsli = 4,
            question = "Apa fungsi sebenarnya dari kode `def ai_tambah_barang(...)` yang isinya hanya `return order_pertama.tambah_barang(...)`?",
            options = listOf(
                "Mempersulit kode program",
                "Fungsi Wrapper (Bungkus) yang menjembatani panggilan fungsi dari format AI menuju fungsi class OOP sesungguhnya",
                "Menggandakan data barang",
                "Menunda waktu eksekusi",
                "Hanya komentar pajangan"
            ),
            correctIndex = 1,
            explanation = "SDK Gemini membutuhkan fungsi top-level di parameter `tools`. Wrapper menjembatani fungsi top-level tersebut ke method instance `order_pertama`."
        ),
        QuizQuestion(
            id = "p2-5",
            babId = "bab-3",
            topicId = "3.1",
            nomorAsli = 5,
            question = "Pada Google Colab, di menu manakah kita biasanya menyimpan kunci rahasia seperti `GEMINI_API_KEY` agar aman dan tidak bocor di dalam kode?",
            options = listOf(
                "Menu File",
                "Menu Runtime",
                "Menu Secrets (Ikon Kunci 🔑)",
                "Menu Edit",
                "Menu Kernel"
            ),
            correctIndex = 2,
            explanation = "Menu Secrets (ikon kunci 🔑) menyimpan variabel rahasia di lingkungan Colab dan dipanggil aman lewat `userdata.get('GEMINI_API_KEY')`."
        ),
        QuizQuestion(
            id = "p2-6",
            babId = "bab-3",
            topicId = "3.1",
            nomorAsli = 6,
            question = "Baris kode `client = genai.Client(api_key=api_key)` pada modul Gemini SDK berfungsi untuk?",
            options = listOf(
                "Menutup aplikasi",
                "Menghapus API Key lama",
                "Menginisialisasi sesi/koneksi autentikasi ke layanan Gemini AI",
                "Membuat pengguna baru",
                "Membayar tagihan server"
            ),
            correctIndex = 2,
            explanation = "Objek `Client` adalah titik masuk utama untuk berkomunikasi dengan API Google GenAI menggunakan API key yang sah."
        ),
        QuizQuestion(
            id = "p2-7",
            babId = "bab-1",
            topicId = "1.7",
            nomorAsli = 7,
            question = "Apa arti dari Escape Character `\\n` (garis miring n) yang ada di string `\\n🧾 --- STRUK BELANJA ---`?",
            options = listOf(
                "Menghentikan program",
                "Menghapus huruf n",
                "Memaksa kursor mencetak baris baru (Enter / Newline)",
                "Menambah indentasi tab",
                "Menjadikan teks tebal"
            ),
            correctIndex = 2,
            explanation = "`\\n` adalah escape character newline yang memerintahkan teks setelahnya dicetak di baris baru."
        ),
        QuizQuestion(
            id = "p2-8",
            babId = "bab-1",
            topicId = "1.8",
            nomorAsli = 8,
            question = "Pada fungsi `cari_barang`, mengapa variabel inputan diubah menggunakan `nama_barang.lower()`?",
            options = listOf(
                "Agar muat di layar",
                "Python bersifat Case-Sensitive (membedakan huruf besar/kecil), sehingga 'Buku' dan 'buku' dianggap beda jika tidak di-lower",
                "Itu syarat keamanan server",
                "Agar terlihat lebih rapi di struk",
                "Agar huruf kapital dihapus"
            ),
            correctIndex = 1,
            explanation = "Tanpa `.lower()`, pencarian `\"Buku\"` terhadap key `\"buku\"` akan gagal karena Python membedakan huruf besar dan huruf kecil."
        ),
        QuizQuestion(
            id = "p2-9",
            babId = "bab-3",
            topicId = "3.4",
            nomorAsli = 9,
            question = "Pada fungsi Multi-turn Chat, apa yang terjadi jika kita tidak menyertakan array kosong pada parameter awal pemanggilan `start_chat(history=[])`?",
            options = listOf(
                "Program langsung error karena itu parameter wajib",
                "Chat akan tetap berjalan dengan history default yang dikelola API",
                "Gemini akan membuat error 404",
                "Komputer lokal akan hang",
                "Python otomatis menghapus history"
            ),
            correctIndex = 1,
            explanation = "Parameter `history` memiliki nilai default kosong di API, sehingga chat tetap berjalan normal mulai dari sesi baru meskipun tidak ditulis eksplisit."
        ),
        QuizQuestion(
            id = "p2-10",
            babId = "bab-2",
            topicId = "2.2",
            nomorAsli = 10,
            question = "Di Python, mengapa parameter `self` selalu ditulis sebagai parameter pertama di setiap method (fungsi) di dalam Class?",
            options = listOf(
                "Agar terlihat panjang",
                "Itu adalah nama fungsi rahasia",
                "Sebagai referensi ke objek (instance) itu sendiri, memungkinkan akses ke properti lain",
                "Untuk mendefinisikan tipe data string",
                "Itu opsional"
            ),
            correctIndex = 2,
            explanation = "`self` merujuk pada objek spesifik yang sedang aktif sehingga method bisa membaca/mengubah `self.katalog` maupun `self.keranjang`."
        ),
        QuizQuestion(
            id = "p2-11",
            babId = "bab-1",
            topicId = "1.4",
            nomorAsli = 11,
            question = "Apa yang akan terjadi pada sintaks `for barang in daftar_barang:` jika variabel `daftar_barang` kosong (Empty List)?",
            options = listOf(
                "Akan error IndexError",
                "Program akan Crash",
                "Blok perulangan (loop) akan langsung dilewati/diabaikan tanpa memicu error",
                "Akan berjalan sekali dengan nilai None",
                "Akan muncul peringatan Warning"
            ),
            correctIndex = 2,
            explanation = "Di Python, mengiterasi List kosong aman dilakukan: loop langsung selesai (0 iterasi) tanpa error."
        ),
        QuizQuestion(
            id = "p2-12",
            babId = "bab-3",
            topicId = "3.1",
            nomorAsli = 12,
            question = "Jika kita menjumpai pesan error `NameError: name 'client' is not defined`, apa penyebab paling logis dalam eksekusi sel (cell) di Colab?",
            options = listOf(
                "Internet terputus",
                "Cell yang berisi kode deklarasi variabel client belum dieksekusi",
                "Model AI sedang sibuk",
                "Laptop kehabisan baterai",
                "Ketikannya salah eja di server Google"
            ),
            correctIndex = 1,
            explanation = "`NameError` menandakan variabel `client` belum ada di memori runtime, biasanya karena cell pertama tempat inisialisasi `client` belum dijalankan."
        ),
        QuizQuestion(
            id = "p2-13",
            babId = "bab-4",
            topicId = "4.3",
            nomorAsli = 13,
            question = "Bagaimana `bos_router` (Gemini) mengetahui spesialis mana (misal Tutor MTK atau Teman Curhat) yang cocok untuk merespons pertanyaan siswa?",
            options = listOf(
                "Mencari di Google Search",
                "Membaca teks deskripsi (Docstring) di dalam setiap fungsi yang didaftarkan di tools",
                "Menebak asal-asalan",
                "Melalui analisis nama fungsi Python saja",
                "Karena sudah dilatih manual oleh pembuat program"
            ),
            correctIndex = 1,
            explanation = "Docstring (`\"\"\"...\"\"\"`) memberi tahu `bos_router` kapan harus memilih `panggil_konselor_karir`, `panggil_tutor_matematika`, atau `panggil_teman_curhat`."
        ),
        QuizQuestion(
            id = "p2-14",
            babId = "bab-3",
            topicId = "3.3",
            nomorAsli = 14,
            question = "Di System Instruction spesialis Konselor Karir, tertulis `'Jawab maksimal 3 kalimat'`. Praktik ini dikenal sebagai?",
            options = listOf(
                "Format Validation",
                "Length Constraint (Pembatasan Panjang Respon) pada Prompt Engineering",
                "Code Refactoring",
                "Token Banning",
                "Memory Clearing"
            ),
            correctIndex = 1,
            explanation = "Length Constraint membatasi panjang output model AI agar ringkas dan fokus tanpa kehilangan substansi jawaban."
        ),
        QuizQuestion(
            id = "p2-15",
            babId = "bab-4",
            topicId = "4.3",
            nomorAsli = 15,
            question = "Di fungsi spesialis seperti `panggil_konselor_karir`, apa yang dikembalikan (`return`) ke `bos_router`?",
            options = listOf(
                "Angka nilai IQ",
                "Teks response.text hasil pemikiran sub-model Gemini yang bertindak sebagai konselor",
                "Pesan Error",
                "Struk Pembayaran",
                "Boolean True/False"
            ),
            correctIndex = 1,
            explanation = "Agen spesialis memanggil `generate_content` lalu mengembalikan `response.text` via `return` agar `bos_router` bisa meneruskannya ke siswa."
        ),
        QuizQuestion(
            id = "p2-16",
            babId = "bab-4",
            topicId = "4.3",
            nomorAsli = 16,
            question = "Fungsi Python `enumerate(daftar_pertanyaan)` yang digunakan pada uji coba Multi-AI menghasilkan apa pada perulangan `for`?",
            options = listOf(
                "Hanya nomor urut",
                "Hanya pertanyaan",
                "Indeks nomor urut sekaligus nilai (value) dari elemen array tersebut",
                "Menghitung total elemen",
                "Membalikkan urutan array"
            ),
            correctIndex = 2,
            explanation = "`enumerate()` membungkus setiap elemen dengan nomor indeksnya sehingga dalam `for i, tanya in enumerate(...)` kita langsung mendapat `i` dan `tanya`."
        ),
        QuizQuestion(
            id = "p2-17",
            babId = "bab-1",
            topicId = "1.5",
            nomorAsli = 17,
            question = "Ketika kita mengakses properti `barang['stok']`, ini menandakan bahwa variabel `'barang'` berbentuk struktur data?",
            options = listOf(
                "String",
                "List",
                "Float",
                "Dictionary",
                "Tuple"
            ),
            correctIndex = 3,
            explanation = "Penggunaan key string di dalam kurung siku (`['stok']`) adalah ciri khas struktur data Dictionary."
        ),
        QuizQuestion(
            id = "p2-18",
            babId = "bab-1",
            topicId = "1.1",
            nomorAsli = 18,
            question = "Fungsi bawaan Python `len(keranjang)` yang terdapat di blok fungsi Multi-AI berguna untuk?",
            options = listOf(
                "Mencetak isi keranjang",
                "Menggandakan panjang keranjang",
                "Menghitung jumlah elemen (panjang list) yang ada di dalam keranjang saat itu",
                "Menghapus isi array sepenuhnya",
                "Menggabungkan dua array"
            ),
            correctIndex = 2,
            explanation = "`len()` mengembalikan bilangan bulat yang merepresentasikan jumlah elemen pada koleksi data seperti List atau Dictionary."
        ),
        QuizQuestion(
            id = "p2-19",
            babId = "bab-1",
            topicId = "1.5",
            nomorAsli = 19,
            question = "Pada baris `harga = self.katalog[nama_barang]`, jika `self.katalog` adalah Dictionary, maka sintaks tersebut bertujuan untuk?",
            options = listOf(
                "Mengubah harga katalog",
                "Mencari Value (harga) berdasarkan Key (nama barang)",
                "Membuat index baru pada Array",
                "Menjumlahkan dua variabel",
                "Mengembalikan index nomor urut"
            ),
            correctIndex = 1,
            explanation = "Dalam Dictionary `{\"buku\": 5000}`, mengakses `katalog[\"buku\"]` mengambil Value (`5000`) berdasarkan Key (`\"buku\"`)."
        ),
        QuizQuestion(
            id = "p2-20",
            babId = "bab-3",
            topicId = "3.5",
            nomorAsli = 20,
            question = "Jika kita mewajibkan AI memakai skema `RecipeTemplate`, apakah AI diizinkan merespons dengan teks bebas seperti paragraf curhat?",
            options = listOf(
                "Iya, boleh bebas",
                "Tergantung pertanyaannya",
                "Tidak, AI akan patuh merespons dalam format terstruktur yang hanya berisi keys sapaan, produk, dan recomendasi",
                "Iya, JSON bersifat opsional",
                "Hanya jika ditanya rumus"
            ),
            correctIndex = 2,
            explanation = "Structured Outputs mengikat keluaran LLM secara ketat pada skema `TypedDict` yang diberikan sehingga teks basa-basi bebas dihilangkan."
        ),
        QuizQuestion(
            id = "p2-21",
            babId = "bab-3",
            topicId = "3.4",
            nomorAsli = 21,
            question = "Mengapa dalam pemrograman AI (LLM), kita wajib terus mengirimkan seluruh `history` riwayat chat kepada API saat melakukan Multi-turn conversation?",
            options = listOf(
                "Untuk menghabiskan token API",
                "Karena secara alami, model LLM itu Stateless (punya penyakit memori jangka pendek) dan tidak menyimpan memori chat per user di server mereka",
                "Sebagai backup data",
                "Agar teks lebih tebal",
                "Aturan Pemerintah lokal"
            ),
            correctIndex = 1,
            explanation = "LLM bersifat stateless: server tidak mengingat percakapan sebelumnya secara otomatis kecuali riwayat (`history`) dikirim ulang bersama pesan baru."
        ),
        QuizQuestion(
            id = "p2-22",
            babId = "bab-3",
            topicId = "3.5",
            nomorAsli = 22,
            question = "Apa efek memasang `response_mime_type=\"application/json\"` pada konfigurasi Gemini?",
            options = listOf(
                "AI mengirim file video",
                "AI dipaksa menghasilkan teks berformat JSON yang kaku dan valid secara struktural",
                "AI merespons dengan format Markdown",
                "Mengompresi data",
                "Menyimpan data di MongoDB"
            ),
            correctIndex = 1,
            explanation = "MIME type `application/json` memaksa model hanya mengembalikan JSON valid tanpa teks pengantar maupun blok markdown."
        ),
        QuizQuestion(
            id = "p2-23",
            babId = "bab-4",
            topicId = "4.1",
            nomorAsli = 23,
            question = "Mengapa jika fungsi Wrapper hanya memanggil `print(hasil)` tanpa `return hasil`, AI akan berhalusinasi saat merespons user?",
            options = listOf(
                "AI tidak suka print",
                "AI hanya bisa menerima data kembali jika fungsi tersebut me-return nilai (output) ke API, bukan mencetaknya ke konsol",
                "Python akan mogok",
                "AI dilarang membaca string",
                "Karena print memakan kuota token"
            ),
            correctIndex = 1,
            explanation = "API Gemini hanya membaca nilai balik dari `return`. Jika tidak ada `return`, AI mendapat `None` lalu menebak-nebak jawabannya sendiri."
        ),
        QuizQuestion(
            id = "p2-24",
            babId = "bab-4",
            topicId = "4.1",
            nomorAsli = 24,
            question = "Saat mengatur `types.GenerateContentConfig()`, kita memasukkan fungsi-fungsi python buatan kita ke parameter apa agar dikenali AI?",
            options = listOf(
                "system_instruction",
                "temperature",
                "models",
                "tools",
                "response_schema"
            ),
            correctIndex = 3,
            explanation = "Parameter `tools=[...]` menerima daftar fungsi Python yang diizinkan untuk dipanggil oleh Gemini."
        ),
        QuizQuestion(
            id = "p2-25",
            babId = "bab-1",
            topicId = "1.2",
            nomorAsli = 25,
            question = "Pada fungsi `hitung_total`, program menggunakan logika accumulator lewat baris `total += harga`. Apa yang menjadi nilai `total` pada awalnya sebelum perulangan berjalan?",
            options = listOf(
                "10",
                "String kosong ('')",
                "100",
                "Angka 0 (Nol)",
                "Tidak terbatas (Infinity)"
            ),
            correctIndex = 3,
            explanation = "Variabel penjumlah (akumulator) harus diinisialisasi ke `0` sebelum loop berjalan agar hasil penjumlahan dimulai dari nol."
        ),
        QuizQuestion(
            id = "p2-26",
            babId = "bab-1",
            topicId = "1.5",
            nomorAsli = 26,
            question = "Dalam metode `.append({\"nama_barang\": nama_barang})`, di posisi mana item baru tersebut akan diletakkan di dalam struktur Array (List)?",
            options = listOf(
                "Di urutan paling depan (index 0)",
                "Di urutan tengah",
                "Di urutan paling akhir dari Array",
                "Posisi acak",
                "Di indeks negatif pertama"
            ),
            correctIndex = 2,
            explanation = "`.append()` selalu menyisipkan elemen baru di ujung belakang (indeks terakhir) sebuah List."
        ),
        QuizQuestion(
            id = "p2-27",
            babId = "bab-3",
            topicId = "3.4",
            nomorAsli = 27,
            question = "Pada objek riwayat pesan (`chat.history`), setiap pesannya memiliki atribut `role`. Apa dua 'role' standar yang bergantian di dalam riwayat tersebut?",
            options = listOf(
                "admin dan user",
                "client dan server",
                "user (pengguna) dan model (AI)",
                "bot dan human",
                "system dan user"
            ),
            correctIndex = 2,
            explanation = "Dalam riwayat chat Gemini, giliran pesan pengirim ber-role `user` dan balasan AI ber-role `model`."
        ),
        QuizQuestion(
            id = "p2-28",
            babId = "bab-1",
            topicId = "1.2",
            nomorAsli = 28,
            question = "Apa arti dari operator penugasan `total += subtotal`?",
            options = listOf(
                "Membuat variabel total baru",
                "Mengecek apakah total sama dengan subtotal",
                "Mengambil nilai variabel 'total' saat ini, menambahkannya dengan 'subtotal', lalu menyimpannya kembali ke 'total'",
                "Mengurangi nilai subtotal",
                "Membagi total"
            ),
            correctIndex = 2,
            explanation = "`total += subtotal` adalah bentuk singkat dari `total = total + subtotal`."
        ),
        QuizQuestion(
            id = "p2-29",
            babId = "bab-4",
            topicId = "4.1",
            nomorAsli = 29,
            question = "Dalam proses Function Calling, siapakah yang sebenarnya menjalankan perhitungan matematis (misal mengurangkan stok barang)?",
            options = listOf(
                "Komputer Google Server AI",
                "Model Gemini yang menghitungnya secara insting",
                "Komputer lokal atau runtime Python milik kita sendiri yang mengeksekusi fungsi aslinya",
                "Server Frontend Web",
                "Model Database Pydantic"
            ),
            correctIndex = 2,
            explanation = "Gemini hanya memilih nama fungsi dan argumennya; yang mengeksekusi kode Python tersebut tetap runtime Python milik kita sendiri."
        ),
        QuizQuestion(
            id = "p2-30",
            babId = "bab-3",
            topicId = "3.4",
            nomorAsli = 30,
            question = "Fungsi `model.start_chat(history=[])` berbeda dari `model.generate_content(...)` karena?",
            options = listOf(
                "Lebih lambat 5x lipat",
                "Digunakan khusus gambar",
                "Method ini menginisialisasi sesi chat yang otomatis menyimpan konteks riwayat obrolan (Multi-turn) sehingga AI ingat percakapan sebelumnya",
                "Otomatis menghasilkan JSON",
                "Bisa berjalan offline"
            ),
            correctIndex = 2,
            explanation = "`start_chat` (atau `client.chats.create`) mengelola `history` percakapan otomatis antar giliran pesan."
        ),
        QuizQuestion(
            id = "p2-31",
            babId = "bab-3",
            topicId = "3.1",
            nomorAsli = 31,
            question = "Pada blok error `NameError: name 'response' is not defined` di akhir file, apa arti dari pesan error ini?",
            options = listOf(
                "API tidak merespon",
                "Server ditutup",
                "Variabel 'response' dipanggil (di-print) sebelum variabel tersebut dibuat atau diisi data",
                "Google melarang akses",
                "Format teks salah"
            ),
            correctIndex = 2,
            explanation = "Error muncul ketika `print(response.text)` dijalankan padahal variabel `response` belum dideklarasikan di konteks tersebut."
        ),
        QuizQuestion(
            id = "p2-32",
            babId = "bab-1",
            topicId = "1.6",
            nomorAsli = 32,
            question = "Pada fungsi `hitung_total`, parameter diisi `(keranjang: List[int])`. Ini menunjukkan bahwa list keranjang hanya boleh berisi tipe data?",
            options = listOf(
                "Huruf teks (String)",
                "Bilangan bulat angka (Integer)",
                "Pecahan desimal (Float)",
                "Benar/Salah (Boolean)",
                "Fungsi (Method)"
            ),
            correctIndex = 1,
            explanation = "Type hint `List[int]` menandakan daftar (list) yang seluruh elemennya bertipe bilangan bulat (`int`)."
        ),
        QuizQuestion(
            id = "p2-33",
            babId = "bab-3",
            topicId = "3.3",
            nomorAsli = 33,
            question = "Pada saat inisialisasi AI Kasir, apa tujuan dari parameter `system_instruction`?",
            options = listOf(
                "Mengajarkan AI bahasa baru",
                "Menulis kode Python untuk dieksekusi",
                "Memberikan kepribadian, persona, pedoman kerja, dan batas aturan (guardrails) kepada model AI",
                "Menghapus memori cache server",
                "Menentukan warna latar chat"
            ),
            correctIndex = 2,
            explanation = "`system_instruction` mengatur peran (misal penjaga toko ramah), alur pemanggilan tools, dan larangan mengarang harga."
        ),
        QuizQuestion(
            id = "p2-34",
            babId = "bab-3",
            topicId = "3.1",
            nomorAsli = 34,
            question = "Apa makna dari layanan Cloud-based pada Google Colab?",
            options = listOf(
                "Hanya bisa diakses saat cuaca mendung",
                "Kode berjalan di server internet Google, bukan membebani RAM komputer lokal kita",
                "Kode disimpan di dalam harddisk lokal",
                "Hanya bisa dipakai di sistem operasi Mac",
                "Menyimpan data di ruang hampa"
            ),
            correctIndex = 1,
            explanation = "Google Colab mengeksekusi notebook di mesin virtual cloud milik Google lewat browser tanpa membebani CPU/RAM lokal."
        ),
        QuizQuestion(
            id = "p2-35",
            babId = "bab-1",
            topicId = "1.4",
            nomorAsli = 35,
            question = "Mengapa pada fungsi `hapus_barang`, kita tidak langsung menghapus data pada `self.keranjang`, melainkan membuat variabel baru `keranjang_baru = []`?",
            options = listOf(
                "Lebih hemat memori",
                "Menghapus elemen di array saat melakukan looping di array yang sama dapat menyebabkan indeks bergeser dan error/bug",
                "Array di Python tidak bisa dihapus",
                "Itu instruksi dari Gemini",
                "Agar AI tidak pusing"
            ),
            correctIndex = 1,
            explanation = "Memodifikasi panjang list yang sedang di-loop membuat indeks elemen berikutnya bergeser sehingga item bisa terlewat."
        ),
        QuizQuestion(
            id = "p2-36",
            babId = "bab-2",
            topicId = "2.1",
            nomorAsli = 36,
            question = "Jika kita sudah membuat variabel `order_pertama = OrderSaatIni()`, bagaimana cara memanggil fungsi yang ada di dalam class tersebut dari luar?",
            options = listOf(
                "tambah_barang(order_pertama)",
                "OrderSaatIni.tambah_barang()",
                "order_pertama.tambah_barang()",
                "self.tambah_barang()",
                "order_pertama -> tambah_barang"
            ),
            correctIndex = 2,
            explanation = "Method pada objek instance dipanggil memakai notasi titik (dot notation): `nama_objek.nama_method()`."
        ),
        QuizQuestion(
            id = "p2-37",
            babId = "bab-2",
            topicId = "2.2",
            nomorAsli = 37,
            question = "Dalam kode `class OrderSaatIni:`, apa peran dari sintaks `self.katalog`?",
            options = listOf(
                "Membuat variabel lokal sementara",
                "Menghapus katalog dari memori",
                "Mendeklarasikan bahwa variabel katalog adalah properti (atribut) yang melekat secara permanen pada instance class tersebut",
                "Menjalankan fungsi katalog",
                "Mengunci class"
            ),
            correctIndex = 2,
            explanation = "Menambahkan `self.` di depan nama variabel menjadikannya atribut instance yang bertahan selama objek hidup."
        ),
        QuizQuestion(
            id = "p2-38",
            babId = "bab-2",
            topicId = "2.3",
            nomorAsli = 38,
            question = "Di Pydantic, tipe data `List[Barang]` pada parameter fungsi mengartikan bahwa...",
            options = listOf(
                "Variabel itu adalah string panjang",
                "Variabel harus berupa array (List) yang seluruh isinya adalah objek dari class Barang",
                "Variabel bisa berisi apa saja",
                "Variabel adalah daftar harga acak",
                "Itu hanyalah komentar"
            ),
            correctIndex = 1,
            explanation = "`List[Barang]` memastikan setiap elemen di dalam array valid mengikuti skema class Pydantic `Barang`."
        ),
        QuizQuestion(
            id = "p2-39",
            babId = "bab-2",
            topicId = "2.3",
            nomorAsli = 39,
            question = "Saat mendeklarasikan `class Barang(BaseModel):`, darimana class `BaseModel` di-import?",
            options = listOf(
                "import google.ai",
                "from typing import BaseModel",
                "from pydantic import BaseModel",
                "import models",
                "from genai import BaseModel"
            ),
            correctIndex = 2,
            explanation = "`BaseModel` adalah kelas induk dari library `pydantic` untuk validasi data otomatis."
        ),
        QuizQuestion(
            id = "p2-40",
            babId = "bab-1",
            topicId = "1.7",
            nomorAsli = 40,
            question = "Sintaks `f\"{no}. {barang['nama_barang']}\"` dikenal sebagai Formatted String (F-String). Fungsi awalan `'f'` adalah?",
            options = listOf(
                "Fungsi File",
                "Fungsi Float",
                "Mengizinkan kita menyisipkan variabel langsung ke dalam teks menggunakan kurung kurawal {}",
                "Membuat format huruf miring",
                "Mencari string"
            ),
            correctIndex = 2,
            explanation = "F-String memungkinkan penyisipan ekspresi/variabel Python langsung di dalam string lewat tanda `{}`."
        ),
        QuizQuestion(
            id = "p2-41",
            babId = "bab-1",
            topicId = "1.6",
            nomorAsli = 41,
            question = "Jika kita mendefinisikan argumen fungsi `def invoice(diskon: int = 0)`, apa makna `= 0` di sana?",
            options = listOf(
                "Diskon tidak bisa digunakan",
                "Diskon wajib diisi 0",
                "Parameter diskon bersifat opsional; jika pengguna tidak memasukkan nilainya, sistem akan memakai 0 sebagai default",
                "Tipe datanya bukan int",
                "Menghapus diskon"
            ),
            correctIndex = 2,
            explanation = "Nilai `= 0` adalah default parameter, sehingga argumen `diskon` boleh dilewati saat pemanggilan fungsi."
        ),
        QuizQuestion(
            id = "p2-42",
            babId = "bab-1",
            topicId = "1.5",
            nomorAsli = 42,
            question = "Pada kode dictionary bertingkat (Nested Dict): `list_barang[\"pensil\"][\"stok\"]`. Bagaimana cara membacanya?",
            options = listOf(
                "Ambil indeks stok lalu pensil",
                "Buka array pensil dan array stok",
                "Cari key 'pensil' pada dictionary utama, lalu dari dalam isinya, cari lagi key 'stok'",
                "Ubah pensil menjadi stok",
                "Tambahkan pensil ke stok"
            ),
            correctIndex = 2,
            explanation = "Pengaksesan berantai: akses pertama masuk ke dictionary detail `\"pensil\"`, lalu akses kedua mengambil nilai key `\"stok\"`."
        ),
        QuizQuestion(
            id = "p2-43",
            babId = "bab-1",
            topicId = "1.7",
            nomorAsli = 43,
            question = "Pada Python, jika ingin membuat string yang memakan beberapa baris ke bawah (multiline), simbol apa yang paling sering digunakan?",
            options = listOf(
                "Petik tunggal (')",
                "Kurung kurawal {}",
                "Tanda pagar (##)",
                "Petik tiga (\"\"\") di awal dan akhir teks",
                "Garis bawah (_)"
            ),
            correctIndex = 3,
            explanation = "Triple quotes (`\"\"\"...\"\"\"`) mengizinkan penulisan string banyak baris langsung tanpa perlu `\\n` di setiap baris."
        ),
        QuizQuestion(
            id = "p2-44",
            babId = "bab-1",
            topicId = "1.5",
            nomorAsli = 44,
            question = "Pada kode `self.keranjang.append({ \"nama_barang\": nama_barang, ... })`, tipe data apa yang ditambahkan ke dalam List keranjang?",
            options = listOf(
                "String",
                "Integer",
                "Tuple",
                "Dictionary",
                "Boolean"
            ),
            correctIndex = 3,
            explanation = "Tanda kurung kurawal `{ \"key\": value }` di dalam `.append(...)` menunjukkan elemen yang dimasukkan adalah Dictionary."
        ),
        QuizQuestion(
            id = "p2-45",
            babId = "bab-1",
            topicId = "1.1",
            nomorAsli = 45,
            question = "Pada kode Python `pajak = int(total_sesudah_diskon * (pajak/100))`, apa fungsi dari pembungkus `int()` tersebut?",
            options = listOf(
                "Memperbesar nilai pajak",
                "Mengkalkulasi ulang diskon",
                "Memaksa hasil perhitungan desimal (Float) berubah menjadi bilangan bulat tanpa koma (Integer)",
                "Menghitung akar kuadrat",
                "Mencetak teks"
            ),
            correctIndex = 2,
            explanation = "Pembagian `(pajak/100)` menghasilkan Float, lalu `int(...)` memotong angka di belakang koma agar format uang Rupiah menjadi bulat."
        )
)
