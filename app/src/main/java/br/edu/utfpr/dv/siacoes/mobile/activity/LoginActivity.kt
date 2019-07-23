package br.edu.utfpr.dv.siacoes.mobile.activity

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import br.edu.utfpr.dv.siacoes.mobile.R
import br.edu.utfpr.dv.siacoes.mobile.model.Credential
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import br.edu.utfpr.dv.siacoes.mobile.Session
import br.edu.utfpr.dv.siacoes.mobile.client.LoginClient

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)
    }

    fun clickLogin(view: View) {
        findViewById<ProgressBar>(R.id.loading).visibility = View.VISIBLE

        var credential = Credential()

        credential.login = findViewById<EditText>(R.id.username).text.toString()
        credential.password = findViewById<EditText>(R.id.password).text.toString()

        LoginClient().login(credential, {
            findViewById<ProgressBar>(R.id.loading).visibility = View.GONE
            Session().setAccessToken(it)

            if(findViewById<Switch>(R.id.stayConnected).isChecked) {
                saveLoginData(credential)
            }

            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            ActivityCompat.finishAffinity(this)
        }, {
            Session().setAccessToken("")
            showLoginFailed()
        })
    }

    private fun saveLoginData(credential: Credential) {
        val PREFS_FILENAME = "br.edu.utfpr.dv.siacoes.prefs"
        val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
        val prefs = EncryptedSharedPreferences.create(
            PREFS_FILENAME,
            masterKeyAlias,
            this,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )

        val editor = prefs.edit()
        editor.putString("login", credential.login)
        editor.putString("password", credential.password)
        editor.apply()
    }

    private fun showLoginFailed() {
        findViewById<ProgressBar>(R.id.loading).visibility = View.GONE

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Erro de Login")
        builder.setMessage("Usuário ou senha incorretos.")
        builder.setNeutralButton("OK"){_,_ ->
            //Toast.makeText(applicationContext,"You cancelled the dialog.",Toast.LENGTH_SHORT).show()
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}