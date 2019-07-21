package br.edu.utfpr.dv.siacoes.mobile.activity

import android.os.Bundle
import br.edu.utfpr.dv.siacoes.mobile.R

class AboutActivity : BaseActivity("Sobre o Sistema",false, false, false, null) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
    }

}