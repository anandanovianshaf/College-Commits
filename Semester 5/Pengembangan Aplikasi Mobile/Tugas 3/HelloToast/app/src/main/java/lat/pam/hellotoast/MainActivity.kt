package lat.pam.hellotoast

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

// Pastikan Anda mengimpor class R dari paket proyek Anda sendiri, BUKAN dari android.R
import lat.pam.hellotoast.R

class MainActivity : AppCompatActivity() {

    // Deklarasikan variabel mCount di sini agar nilainya tidak reset
    private var mCount: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Hubungkan variabel dengan komponen di layout XML
        val mShowCount = findViewById<TextView>(R.id.show_count)
        val buttonToast = findViewById<Button>(R.id.button_toast)
        val buttonCount = findViewById<Button>(R.id.button_count)
        val buttonSwitchPage = findViewById<Button>(R.id.button_switchpage)
        val buttonBrowser = findViewById<Button>(R.id.button_browser)

        // 2. Logika untuk tombol COUNT
        buttonCount.setOnClickListener {
            mCount++
            mShowCount.text = mCount.toString()
        }

        // 3. Logika untuk tombol TOAST
        buttonToast.setOnClickListener {
            val toastMessage = "Angka saat ini adalah " + mShowCount.text.toString()
            Toast.makeText(this, toastMessage, Toast.LENGTH_LONG).show()
        }

        // 4. Logika untuk tombol PINDAH HALAMAN (Explicit Intent)
        buttonSwitchPage.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        // 5. Logika untuk tombol BROWSER (Implicit Intent)
        buttonBrowser.setOnClickListener {
            val intentBrowse = Intent(Intent.ACTION_VIEW)
            intentBrowse.data = Uri.parse("https://www.google.com/")
            startActivity(intentBrowse)
        }
    }
}