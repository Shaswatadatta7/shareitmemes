package com.shaswatadatta2000.shareitmemes

import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var currentImage: String? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadMeme()
        
    }

      fun loadMeme(){
        // Instantiate the RequestQueue.

        progressbar.visibility=View.VISIBLE

        val queue = Volley.newRequestQueue(this)
        val url = "https://meme-api.herokuapp.com/gimme"
        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
            Response.Listener { response ->
                 currentImage=response.getString("url")
                 Glide.with(this).load(currentImage).listener(object :RequestListener<Drawable>{
                     override fun onLoadFailed(
                         e: GlideException?,
                         model: Any?,
                         target: Target<Drawable>?,
                         isFirstResource: Boolean
                     ): Boolean {
                         progressbar.visibility=View.GONE
                         return false
                     }

                     override fun onResourceReady(
                         resource: Drawable?,
                         model: Any?,
                         target: Target<Drawable>?,
                         dataSource: DataSource?,
                         isFirstResource: Boolean
                     ): Boolean {
                         progressbar.visibility=View.GONE
                         return false
                     }
                 }).into(memeimage)
            },
            Response.ErrorListener { error ->
                Toast.makeText(this,"No working",Toast.LENGTH_LONG).show()
            }
        )



// Add the request to the RequestQueue.
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)
    }


    fun shareMeme(view: View) {
        // Create an intent with the action to send content
        val intent = Intent(Intent.ACTION_SEND)

        // Add the text content to be shared
        intent.putExtra(Intent.EXTRA_TEXT, "Share this URL with your friends: $currentImage")

        // Set the MIME type of the content to be shared
        intent.type = "text/plain"

        // Create a chooser to display available sharing options
        val chooser = Intent.createChooser(intent, "Share this meme URL with...")

        // Start the chooser activity to allow the user to select a sharing option
        startActivity(chooser)
    }

    fun nextmeme(view: View) {
        loadMeme()

    }
}


