package br.edu.utfpr.dv.siacoes.mobile.activity

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.app.ActivityCompat
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import br.edu.utfpr.dv.siacoes.mobile.R
import br.edu.utfpr.dv.siacoes.mobile.client.LoginClient
import br.edu.utfpr.dv.siacoes.mobile.model.Credential
import br.edu.utfpr.dv.siacoes.mobile.service.RetrofitInitializer

class SplashActivity : AppCompatActivity() {

    private var mDelayHandler: Handler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        mDelayHandler = Handler()
        mDelayHandler!!.post(mRunnable)
    }

    public override fun onDestroy() {

        if (mDelayHandler != null) {
            mDelayHandler!!.removeCallbacks(mRunnable)
        }

        super.onDestroy()
    }

    internal val mRunnable: Runnable = Runnable {
        if (!isFinishing) {
            startLogin()
            finish()
        }
    }

    fun startLogin() {
        val PREFS_FILENAME = "br.edu.utfpr.dv.siacoes.prefs"
        val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
        val prefs = EncryptedSharedPreferences.create(
            PREFS_FILENAME,
            masterKeyAlias,
            this,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )

        var credential = Credential()

        credential.login = prefs.getString("login", "")!!
        credential.password = prefs.getString("password", "")!!

        if(credential.login.isNotBlank() and credential.password.isNotBlank()) {
            LoginClient().login(credential, {
                RetrofitInitializer.requestToken = it
                goToMain()
            }, {
                RetrofitInitializer.requestToken = ""
                goToLogin()
            })
        } else {
            goToLogin()
        }

        ActivityCompat.finishAffinity(this)
    }

    fun goToLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
    }

    fun goToMain() {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
    }
}
