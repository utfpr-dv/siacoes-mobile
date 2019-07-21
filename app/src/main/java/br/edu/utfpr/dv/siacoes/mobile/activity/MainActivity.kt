package br.edu.utfpr.dv.siacoes.mobile.activity

import android.os.Bundle
import br.edu.utfpr.dv.siacoes.mobile.R

class MainActivity : BaseActivity(null,false, false, false, null) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}
