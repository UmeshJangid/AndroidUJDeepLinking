package com.ujcreation.deeplinksample

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val PREFERENCE_DEEP_LINK = "/home/UmeshPreferences"
    val INBOX_DEEP_LINK = "/inbox/UmeshLink"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = intent
        val action = intent.action
        val data = intent.data
        if (data != null) {
            if (data.lastPathSegment.toString().isNotEmpty()) {
                //  openDeepLink(intent.data)
                Log.e("deep", data.lastPathSegment)
                text2.setText(data.lastPathSegment.toString())
                Toast.makeText(this, data.lastPathSegment, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun openDeepLink(deepLink: Uri) {
        val path = deepLink.getPath()
        if (PREFERENCE_DEEP_LINK.equals(path)) {
            // Launch preferences
            //Launch Desired Activity
            //  startActivity(Intent(this, PushPreferencesActivity::class.java))
        } else if (INBOX_DEEP_LINK.equals(path)) {
            // Launch the inbox activity
            // startActivity(Intent(this, InboxActivity::class.java))
        } else {
            // Fall back to the main activity
            startActivity(Intent(this, MainActivity::class.java))
        }
    }


}
