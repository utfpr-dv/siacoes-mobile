package br.edu.utfpr.dv.siacoes.mobile.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import br.edu.utfpr.dv.siacoes.mobile.R
import br.edu.utfpr.dv.siacoes.mobile.activity.BaseActivity
import br.edu.utfpr.dv.siacoes.mobile.model.FinalDocument

class EditFinalDocumentAbstractFragment(private val finalDocument: FinalDocument) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_edit_final_document_abstract, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as BaseActivity).showLoading()

        activity?.findViewById<EditText>(R.id.text_abstract)?.setText(finalDocument.nativeAbstract)

        (activity as BaseActivity).hideLoading()
    }

}