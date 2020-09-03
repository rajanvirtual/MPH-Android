package com.myprohelper.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.myprohelper.R
import kotlinx.android.synthetic.main.fragment_add_widgets.*

class AddWidgetsFragment : Fragment(), View.OnClickListener {
    private var toolbar: Toolbar? = null


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setOnClickListener()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_widgets, container, false)
        updateToolbar()
        return view;

    }

    private fun updateToolbar() {

    }


    private fun setOnClickListener() {
        tv_done.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_done -> {

            }

        }
    }


}