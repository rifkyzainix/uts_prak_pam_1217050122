package pam.tugas.uts_prak_pam

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class store_detail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_detail)
        val intent = intent
        val selectedStore: String? = intent.getStringExtra("selectedStore")
        val customerName: String? = intent.getStringExtra("customerName")

        val imageToko = findViewById<ImageView>(R.id.image_toko)
        val storeName = findViewById<TextView>(R.id.store_name)
        val findOnMaps = findViewById<TextView>(R.id.find_on_maps)
        val topbarText = findViewById<TextView>(R.id.topbar_text)
        val seeMenus = findViewById<Button>(R.id.see_menus)

        imageToko.setImageResource(R.drawable.img)
        storeName.text = selectedStore.toString()
        topbarText.text = "Hello, "+customerName.toString()

        findOnMaps.setOnClickListener {
            val location = "37.7749,-122.4194"
            val gmmIntentUri = Uri.parse("geo:0,0?q=$location")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            if (mapIntent.resolveActivity(packageManager) != null) {
                startActivity(mapIntent)
            }else{
                Toast.makeText(applicationContext,
                    "Google Maps is not installed",
                    Toast.LENGTH_LONG)
                    .show()
            }
        }

        seeMenus.setOnClickListener{
            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("selectedStore", selectedStore.toString())
            intent.putExtra("customerName", customerName.toString())
            //intent.putStringArrayListExtra()
            startActivity(intent)
        }

    }
}