package com.tkastudio.app.data

import com.tkastudio.app.model.BabInfo
import com.tkastudio.app.model.KisiTopic

val babsList: List<BabInfo> = listOf(
    BabInfo(
        id = "bab-1",
        nomor = 1,
        title = "Dasar Pemrograman Python",
        subtitle = "8 Nomor Kisi-kisi",
        summary = "Fondasi sintaks Python, variabel, tipe data, percabangan, loop, list/dictionary, fungsi, dan string."
    ),
    BabInfo(
        id = "bab-2",
        nomor = 2,
        title = "OOP & Validasi Pydantic",
        subtitle = "3 Nomor Kisi-kisi",
        summary = "Blueprint Class, instance objek, kata kunci self, konstruktor __init__, dan validasi BaseModel."
    ),
    BabInfo(
        id = "bab-3",
        nomor = 3,
        title = "Integrasi API Gemini",
        subtitle = "5 Nomor Kisi-kisi",
        summary = "Setup Client & Secrets Colab, model config, System Prompt, chat history stateless, dan output JSON."
    ),
    BabInfo(
        id = "bab-4",
        nomor = 4,
        title = "Function Calling & Multi-Agent",
        subtitle = "3 Nomor Kisi-kisi",
        summary = "Mendaftarkan tools & Docstring, Wrapper Function, anti-halusinasi, dan arsitektur Router-Worker."
    )
)

val kisiTopicsList: List<KisiTopic> = listOf(
    KisiTopic(
        id = "1.1",
        babId = "bab-1",
        title = "Fungsi Bawaan Python",
        kisiDescription = "Fungsi Bawaan Python: print(), input(), len(), type(), int().",
        intiKonsep = "Fungsi siap pakai tanpa perlu import untuk cetak layar, baca ketikan user, hitung panjang, cek tipe, dan ubah teks/desimal ke bulat.",
        ingatCepat = listOf(
            "print() cuma tampil di layar — TIDAK mengirim nilai ke pemanggil/AI.",
            "input() menjeda program menunggu ketikan user; hasilnya selalu String.",
            "len([10, 20, 30]) hitung jumlah isi -> 3 (bukan 2!).",
            "int() potong koma di belakang (misal pajak Rupiah bulat) atau ubah \"10\" jadi 10."
        ),
        codeSnippet = "pajak = int(total_sesudah_diskon * (pajak / 100))\njumlah_item = len(keranjang)\nuser_input = input(\"Kamu: \")",
        codeCaption = "Potongan fungsi kasir & loop chat di notebook kelas.",
        jebakanUjian = "int(3.9) menghasilkan 3 (memotong desimal), bukan membulatkan ke atas."
    ),
    KisiTopic(
        id = "1.2",
        babId = "bab-1",
        title = "Variabel, Operator & Logika",
        kisiDescription = "Deklarasi Snake Case, operator matematika (+, -, *, /, //, %, **), dan logika (and, or, not).",
        intiKonsep = "Penamaan pakai huruf kecil + garis bawah (nama_barang). Python punya pembagian bulat (//), sisa bagi (%), dan shorthand +=.",
        ingatCepat = listOf(
            "total += subtotal artinya total = total + subtotal (mulai total = 0).",
            "// = bagi buang koma (7 // 2 -> 3), sedangkan % = sisa bagi (5 % 2 -> 1).",
            "/ tunggal selalu menghasilkan Float (10 / 100 -> 0.1).",
            "and butuh SEMUA True; or cukup SATU True; not membalikkan nilai."
        ),
        codeSnippet = "total = 0\nsubtotal = barang[\"harga\"] * barang[\"qty\"]\ntotal += subtotal   # sama dengan total = total + subtotal\nsisa = 5 % 2        # 1",
        codeCaption = "Pola akumulator total belanja & operator aritmetika.",
        jebakanUjian = "Hati-hati: di Python tidak ada operator ++ seperti Java/C++; gunakan += 1."
    ),
    KisiTopic(
        id = "1.3",
        babId = "bab-1",
        title = "Tipe Data Dasar & None",
        kisiDescription = "Tipe Data: String (str), Integer (int), Float (float), Boolean (bool), dan None.",
        intiKonsep = "Setiap data punya jenis: teks (str), bulat (int), desimal/titik (float), logika Benar/Salah (bool), atau kosong (None).",
        ingatCepat = listOf(
            "str = diapit tanda kutip (\"buku\"), int = bulat (5000), float = desimal (0.15).",
            "bool hanya dua nilai: True atau False (huruf depan wajib kapital).",
            "None = nilai kosong (muncul jika fungsi lupa dikasih return)."
        ),
        codeSnippet = "class Item(BaseModel):\n    nama: str        # teks\n    harga: int       # bulat\n    tersedia: bool   # True / False\n    tags: list       # kumpulan kata kunci",
        codeCaption = "Pemetaan tipe data di model katalog Item.",
        jebakanUjian = "Fungsi AI tanpa return otomatis mengembalikan None sehingga AI bisa halusinasi."
    ),
    KisiTopic(
        id = "1.4",
        babId = "bab-1",
        title = "Percabangan & Perulangan",
        kisiDescription = "Struktur Kontrol: if, elif, else, while, for, break, continue, pass.",
        intiKonsep = "Python membedakan isi blok lewat spasi menjorok (Indentasi). Loop for mengulang koleksi, while True jalan terus sampai break.",
        ingatCepat = listOf(
            "Indentasi (spasi kiri) adalah penentu blok if/for/def — bukan kurung kurawal { }.",
            "elif hanya diuji kalau kondisi if di atasnya bernilai False.",
            "break = stop total keluar loop; continue = lompati iterasi ini ke putaran berikut.",
            "for i in range(len(list)) beri indeks 0, 1, 2...; for x in [] aman (0 iterasi, tidak error)."
        ),
        codeSnippet = "while True:\n    user_input = input(\"Kamu: \")\n    if user_input.lower() in ['keluar', 'exit']:\n        break        # hentikan loop selamanya\n    if not user_input.strip():\n        continue     # lewati input kosong",
        codeCaption = "Loop chat interaktif + try/except di aplikasi kasir.",
        jebakanUjian = "Menghapus elemen List langsung di dalam loop yang sama bikin indeks geser — buat keranjang_baru = [] dulu."
    ),
    KisiTopic(
        id = "1.5",
        babId = "bab-1",
        title = "Struktur Data: List & Dictionary",
        kisiDescription = "Struktur Data: List [...], Dictionary {...}, Nested Dict, dan operasi umum.",
        intiKonsep = "List diakses pakai angka indeks mulai dari 0; Dictionary diakses pakai pasangan key: value.",
        ingatCepat = listOf(
            "List = [] (indeks 0, 1, 2...); .append(x) taruh item baru di paling akhir.",
            "Dictionary = {key: value}; ambil nilai pakai dict[\"key\"] atau dict.get(\"key\").",
            ".items() pada dict mengembalikan 2 nilai per iterasi: (Key, Value).",
            "Cek keberadaan key aman pakai: if \"pensil\" in katalog:"
        ),
        codeSnippet = "katalog = {\"pensil\": {\"harga\": 3000, \"stok\": 150}}\nharga = katalog[\"pensil\"][\"harga\"]   # Nested Dict -> 3000\nkeranjang = []                       # List kosong\nkeranjang.append({\"nama\": \"pensil\", \"qty\": 2})",
        codeCaption = "List of Dictionaries untuk keranjang & Nested Dict untuk stok.",
        jebakanUjian = "Jika lupa cek `not in katalog`, akses `katalog[\"pulpen\"]` akan melempar KeyError."
    ),
    KisiTopic(
        id = "1.6",
        babId = "bab-1",
        title = "Fungsi, Parameter Opsional & Return",
        kisiDescription = "Deklarasi (def), parameter default, *args, type hint (-> str, List[int]), dan return.",
        intiKonsep = "Fungsi didefinisikan dengan def. Parameter dengan nilai awal (= 0) menjadi opsional, dan return mengirim hasil keluar fungsi.",
        ingatCepat = listOf(
            "def nama_fungsi(wajib: str, diskon: int = 0) -> str:",
            "Parameter opsional (= 0) wajib ditaruh di bagian AKHIR setelah parameter wajib.",
            "-> str adalah Type Hint bahwa fungsi mengembalikan teks; List[int] = list isi bulat.",
            "return mengirim nilai ke pemanggil/AI, sedangkan print hanya muncul di konsol."
        ),
        codeSnippet = "def buat_invoice(daftar_barang: List[Barang], diskon: int = 0, pajak: int = 10) -> str:\n    # diskon & pajak bersifat opsional karena punya nilai default\n    return f\"Total akhir: {total_akhir}\"",
        codeCaption = "Fungsi dengan Type Hint dan parameter opsional.",
        jebakanUjian = "Menulis `def f(a=0, b)` tanpa default di belakangnya menyebabkan SyntaxError."
    ),
    KisiTopic(
        id = "1.7",
        babId = "bab-1",
        title = "String Formatting & Multiline",
        kisiDescription = "Penggunaan Formatted String (F-String), multiline \"\"\", escape \\n, dan concatenation +.",
        intiKonsep = "F-String (f\"...\") menyisipkan variabel langsung ke dalam teks lewat kurung kurawal {}.",
        ingatCepat = listOf(
            "f\"{no}. {barang['nama']}\" jauh lebih rapi daripada menggabungkan string dengan +.",
            "Petik tiga \"\"\" ... \"\"\" dipakai untuk teks panjang banyak baris (System Prompt / Docstring).",
            "\\n adalah escape character untuk turun baris baru (Enter).",
            "Operator + pada string menyambung teks berjejer (concatenation)."
        ),
        codeSnippet = "hasil_teks = \"===== STRUK =====\\n\"\nhasil_teks += f\"{no}. {barang['nama_barang']} = Rp{subtotal}\\n\"",
        codeCaption = "Mengumpulkan baris struk pakai +=, \\n, dan F-String.",
        jebakanUjian = "Tanpa huruf f di depan tanda kutip, `{total}` hanya tercetak sebagai teks biasa."
    ),
    KisiTopic(
        id = "1.8",
        babId = "bab-1",
        title = "Metode String Case-Insensitive",
        kisiDescription = "Penggunaan .lower() dan .upper() untuk pencarian teks yang tidak peka huruf besar/kecil.",
        intiKonsep = "Python bersifat Case-Sensitive (\"Buku\" != \"buku\"). Ubah semua huruf jadi kecil dulu dengan .lower() sebelum dibandingkan.",
        ingatCepat = listOf(
            "\"PeNsiL\".lower() -> \"pensil\" | \"huruf\".upper() -> \"HURUF\".",
            "Dipakai sebelum mencocokkan nama barang user ke katalog agar aman dari beda kapital.",
            ".lower() hanya samakan huruf besar/kecil — typo seperti \"pensi\" tetap tidak cocok."
        ),
        codeSnippet = "nama_barang = nama_barang.lower()\nif nama_barang not in self.katalog:\n    return f\"{nama_barang} tidak ada.\"",
        codeCaption = "Normalisasi input pencarian barang di OrderSaatIni.",
        jebakanUjian = "Jangan lupa simpan hasilnya (`x = x.lower()`); memanggil `x.lower()` saja tidak mengubah variabel `x`."
    ),
    KisiTopic(
        id = "2.1",
        babId = "bab-2",
        title = "Konsep Class & Instansiasi Objek",
        kisiDescription = "Pembuatan Class (Blueprint) dan Instansiasi (Pembuatan Objek nyata).",
        intiKonsep = "Class adalah cetak biru (blueprint), sedangkan Objek/Instance adalah barang jadi hasil cetakannya.",
        ingatCepat = listOf(
            "Class = cetakan (class OrderSaatIni:).",
            "Instansiasi = membuat objek baru: order_pertama = OrderSaatIni().",
            "Mengakses properti atau method objek pakai notasi titik: order_pertama.tambah_barang()."
        ),
        codeSnippet = "class OrderSaatIni:\n    ...\n\norder_pertama = OrderSaatIni()          # Class Instantiation\norder_pertama.tambah_barang(\"buku\", 2)  # Dot notation",
        codeCaption = "Membuat instance order_pertama dari blueprint OrderSaatIni.",
        jebakanUjian = "Di Python akses method selalu pakai titik (objek.method()), bukan panah -> seperti C++/PHP."
    ),
    KisiTopic(
        id = "2.2",
        babId = "bab-2",
        title = "Metode Class: self & Konstruktor __init__",
        kisiDescription = "Penggunaan kata kunci self dan fungsi konstruktor __init__.",
        intiKonsep = "__init__ otomatis jalan pertama kali saat objek lahir. self merujuk ke objek itu sendiri agar properti tetap hidup antar method.",
        ingatCepat = listOf(
            "def __init__(self): adalah konstruktor wajib yang jalan otomatis saat instansiasi.",
            "self selalu menjadi parameter PERTAMA setiap method di dalam Class.",
            "self.keranjang melekat permanen di objek; kalau tanpa self. (cuma keranjang = []), langsung hilang!",
            "Di method lain pada Class yang sama, panggilnya tetap self.katalog / self.keranjang."
        ),
        codeSnippet = "class OrderSaatIni:\n    def __init__(self):\n        self.katalog = {\"buku\": 5000, \"pensil\": 2000}\n        self.keranjang = []  # State Management belanja",
        codeCaption = "Inisialisasi state permanen objek melalui self di __init__.",
        jebakanUjian = "Bahasa lain pakai `this`, Python wajib pakai `self` pada definisi method."
    ),
    KisiTopic(
        id = "2.3",
        babId = "bab-2",
        title = "Validasi Data dengan Pydantic",
        kisiDescription = "Modul BaseModel, properti wajib vs opsional, List[Barang], dan validasi otomatis (ValidationError).",
        intiKonsep = "Pydantic (from pydantic import BaseModel) otomatis mengecek tipe data setiap properti objek sebelum diproses lebih lanjut.",
        ingatCepat = listOf(
            "Sintaks wajib: from pydantic import BaseModel -> class Barang(BaseModel):",
            "Properti tanpa nilai default (misal harga: int) sifatnya WAJIB diisi (Required).",
            "Jika harga: int diisi teks \"Lima Ribu\", Pydantic menolak & memunculkan ValidationError.",
            "List[Barang] mewajibkan list hanya berisi objek Class Barang; akses properti pakai item.nama."
        ),
        codeSnippet = "from pydantic import BaseModel\nfrom typing import List\n\nclass Barang(BaseModel):\n    nama: str\n    harga: int\n    tersedia: bool = True   # opsional karena ada default",
        codeCaption = "Skema model Pydantic dengan validasi otomatis.",
        jebakanUjian = "Elemen objek Pydantic di loop diakses pakai titik (`item.nama`), bukan kurung siku (`item[\"nama\"]`)."
    ),
    KisiTopic(
        id = "3.1",
        babId = "bab-3",
        title = "Konfigurasi Client & Secrets Colab",
        kisiDescription = "Inisialisasi genai.Client() dan penyimpanan GEMINI_API_KEY melalui Secrets Google Colab.",
        intiKonsep = "Google Colab berjalan di cloud Google. API Key disimpan aman di menu Secrets (ikon kunci) dan dibaca lewat google.colab.userdata.",
        ingatCepat = listOf(
            "userdata.get(\"GEMINI_API_KEY\") membaca kunci rahasia dari menu Secrets Colab.",
            "client = genai.Client(api_key=api_key) membuka koneksi autentikasi ke Gemini.",
            "Jika muncul NameError: name \"client\" is not defined -> cell deklarasi client belum dijalankan!"
        ),
        codeSnippet = "from google import genai\nfrom google.genai import types\nfrom google.colab import userdata\n\napi_key = userdata.get('GEMINI_API_KEY')\nclient = genai.Client(api_key=api_key)",
        codeCaption = "Cell inisialisasi wajib di paling atas notebook Colab.",
        jebakanUjian = "Jangan pernah hardcode API Key langsung di dalam kode agar tidak bocor saat dibagikan."
    ),
    KisiTopic(
        id = "3.2",
        babId = "bab-3",
        title = "Model, GenerateContentConfig & response.text",
        kisiDescription = "Pemilihan model (gemini-3.5-flash-lite / 2.5-flash), GenerateContentConfig, dan properti response.text.",
        intiKonsep = "Model diatur lewat parameter model=..., seluruh pengaturan (tools, persona, format JSON) dibungkus di types.GenerateContentConfig(...).",
        ingatCepat = listOf(
            "gemini-3.5-flash-lite unggul di kecepatan (latency rendah) & hemat biaya untuk tugas cepat.",
            "types.GenerateContentConfig(...) menampung system_instruction, tools, dan response_schema.",
            "Teks jawaban murni AI tersimpan di properti response.text (bukan response.message)."
        ),
        codeSnippet = "response = client.models.generate_content(\n    model=\"gemini-3.5-flash-lite\",\n    contents=pertanyaan,\n    config=types.GenerateContentConfig(...)\n)\nprint(response.text)",
        codeCaption = "Struktur pemanggilan generate_content SDK google-genai.",
        jebakanUjian = "Mencetak `print(response)` saja menampilkan metadata mentah; ambil teksnya lewat `response.text`."
    ),
    KisiTopic(
        id = "3.3",
        babId = "bab-3",
        title = "System Instructions & Length Constraint",
        kisiDescription = "Mengatur persona, pedoman kerja, dan batasan panjang balasan AI.",
        intiKonsep = "system_instruction adalah aturan dasar / kepribadian yang terus menempel ke AI sebelum membaca input user.",
        ingatCepat = listOf(
            "Gunakan petik tiga \"\"\"...\"\"\" karena instruksi sistem biasanya banyak baris.",
            "Contoh Length Constraint: \"Jawab maksimal 3 kalimat\" mencegah AI bertele-tele.",
            "Digunakan juga untuk guardrails agar AI wajib memanggil tools sebelum menjawab."
        ),
        codeSnippet = "config=types.GenerateContentConfig(\n    system_instruction=\"\"\"Kamu adalah Konselor Karir.\n    Berikan saran realistis dan logis.\n    Jawab maksimal 3 kalimat.\"\"\"\n)",
        codeCaption = "Persona + Length Constraint di System Instruction.",
        jebakanUjian = "Satu System Prompt yang terlalu gemuk dan banyak tugas sekaligus memicu Prompt Bloat / kebingungan AI."
    ),
    KisiTopic(
        id = "3.4",
        babId = "bab-3",
        title = "Multi-turn Chat & Sifat Stateless LLM",
        kisiDescription = "Penggunaan chats.create / start_chat(history=[]), send_message(), dan role user vs model.",
        intiKonsep = "LLM pada dasarnya Stateless (pelupa, tidak simpan obrolan di server). Sesi chat mengirim ulang riwayat secara otomatis agar AI ingat.",
        ingatCepat = listOf(
            "Stateless = AI lupa obrolan sebelumnya jika history tidak dikirim ulang.",
            "send_message() otomatis menyimpan pesan baru ke riwayat (berbeda dari generate biasa).",
            "history=[] menginisialisasi sesi chat baru yang bersih dari awal.",
            "Dua role standar di chat.history: \"user\" (pengguna) dan \"model\" (AI)."
        ),
        codeSnippet = "chat = client.chats.create(\n    model=\"gemini-3.5-flash-lite\",\n    config=types.GenerateContentConfig(system_instruction=\"Ramah\")\n)\nr1 = chat.send_message(\"Namaku Budi\")\nr2 = chat.send_message(\"Siapa namaku?\") # AI ingat: Budi",
        codeCaption = "Percakapan multi-turn menjaga konteks antar giliran.",
        jebakanUjian = "Kalau mengosongkan `tools=[]` pada chat, AI sengaja dilarang memanggil fungsi Python apa pun."
    ),
    KisiTopic(
        id = "3.5",
        babId = "bab-3",
        title = "Output JSON Terstruktur (TypedDict)",
        kisiDescription = "Pemaksaan format JSON murni dengan response_mime_type=\"application/json\" dan response_schema.",
        intiKonsep = "Memaksa AI membalas hanya dengan JSON baku sesuai skema TypedDict agar langsung bisa dibaca (parse) oleh backend/frontend tanpa basa-basi.",
        ingatCepat = listOf(
            "response_mime_type=\"application/json\" melarang AI menulis kalimat pembuka/Markdown.",
            "class RecipeTemplate(typing.TypedDict): menentukan key wajib dan tipe datanya.",
            "list[str] di schema artinya field wajib berupa array berisi teks string."
        ),
        codeSnippet = "class RecipeTemplate(typing.TypedDict):\n    sapaan: str\n    produk: list[str]\n    recomendasi: list[str]\n\n# config: response_mime_type=\"application/json\", response_schema=RecipeTemplate",
        codeCaption = "Structured Outputs memakai TypedDict di notebook kelas.",
        jebakanUjian = "Saat schema aktif, AI tidak boleh curhat atau keluar dari key yang sudah ditetapkan."
    ),
    KisiTopic(
        id = "4.1",
        babId = "bab-4",
        title = "Mekanika Function Calling & Wrapper",
        kisiDescription = "tools=[...], peran Docstring, Wrapper Function untuk Class OOP, dan kewajiban return.",
        intiKonsep = "AI membaca Docstring fungsi di tools=[...] untuk memutuskan kapan memanggilnya, lalu Python lokal kita yang benar-benar mengeksekusi fungsinya.",
        ingatCepat = listOf(
            "Docstring (\"\"\"...\"\"\") di bawah nama fungsi = buku panduan bagi AI kapan tool dipakai.",
            "Wrapper Function (ai_tambah_barang) menjembatani SDK AI yang tidak bisa akses method Class langsung.",
            "WAJIB return hasil! Kalau cuma print(), AI menerima None dan mengarang jawaban.",
            "Yang menghitung & mengubah data tetap runtime Python lokal kita, bukan server Google."
        ),
        codeSnippet = "def ai_tambah_barang(nama_barang: str, qty: int) -> str:\n    \"\"\"Gunakan HANYA jika pelanggan ingin beli/tambah barang.\"\"\"\n    return order_pertama.tambah_barang(nama_barang, qty)\n\n# Daftarkan di config: tools=[ai_tambah_barang, ...]",
        codeCaption = "Wrapper Function + Docstring sebagai jembatan ke Class OOP.",
        jebakanUjian = "Jika ada fungsi tool yang hanya `print(...)` tanpa `return`, AI tidak akan pernah menerima outputnya."
    ),
    KisiTopic(
        id = "4.2",
        babId = "bab-4",
        title = "Teknik Anti-Halusinasi & Akurasi Hitungan",
        kisiDescription = "Mencegah AI mengarang harga/stok dan menyerahkan perhitungan matematika ke Python.",
        intiKonsep = "LLM dilatih menebak pola kata, sehingga rawan salah hitung dan mengarang angka. Solusinya: larang eksplisit di prompt & hitung di Python.",
        ingatCepat = listOf(
            "Tulis larangan tegas: \"Jangan mengarang harga atau stok sendiri, andalkan tools\".",
            "Diskon, pajak, subtotal, dan total WAJIB dihitung oleh fungsi Python, bukan oleh AI.",
            "Bungkus loop chat dengan try...except Exception as e: agar error tidak bikin crash."
        ),
        codeSnippet = "system_instruction=\"\"\"\nJangan mengarang harga atau stok sendiri, selalu andalkan hasil tools!\n\"\"\"\n# Perhitungan akurat di Python:\npajak = int(total_sesudah_diskon * (pajak / 100))",
        codeCaption = "Guardrail anti-halusinasi & delegasi matematika ke Python.",
        jebakanUjian = "AI Kasir yang tampak pintar berhitung sebenarnya hanya membacakan angka hasil `return` fungsi Python."
    ),
    KisiTopic(
        id = "4.3",
        babId = "bab-4",
        title = "Arsitektur Multi-Agent (Router-Worker)",
        kisiDescription = "Pemisahan peran Bos (Router) penganalisis niat dan Worker (Spesialis) pelaksana tugas.",
        intiKonsep = "Daripada 1 AI dibebani prompt raksasa (Prompt Bloat), bagi jadi 1 Bos Router (resepsionis) dan beberapa agen Spesialis (alat tools).",
        ingatCepat = listOf(
            "Menghindari Prompt Bloat & Prompt Confusion -> akurasi tiap tugas lebih tinggi.",
            "bos_router membaca niat (intent) user lalu memanggil fungsi spesialis lewat Docstring.",
            "Worker (panggil_tutor_matematika, panggil_konselor_karir) adalah fungsi yang memanggil Gemini lagi dan me-return response.text.",
            "enumerate(daftar_pertanyaan) di uji coba menghasilkan (indeks, nilai) sekaligus."
        ),
        codeSnippet = "def panggil_tutor_matematika(pertanyaan: str) -> str:\n    \"\"\"Gunakan HANYA jika siswa tanya PR, rumus, atau hitungan.\"\"\"\n    res = client.models.generate_content(model=\"gemini-3.5-flash-lite\", contents=pertanyaan, ...)\n    return res.text\n\nbos_router = client.chats.create(..., config=types.GenerateContentConfig(\n    tools=[panggil_konselor_karir, panggil_tutor_matematika, panggil_teman_curhat]\n))",
        codeCaption = "Pola Bos Router memanggil sub-agen spesialis.",
        jebakanUjian = "Fungsi spesialis tetap butuh `return response.text` agar jawabannya sampai ke `bos_router` lalu ke user."
    )
)
