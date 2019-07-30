package com.masstersoft.nordic_20.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.masstersoft.nordic_20.R
import kotlinx.android.synthetic.main.fragment_fragment_1.*

class Fragment_1 : Fragment() {

    var listener: NextFragmentInterface? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (activity is NextFragmentInterface) listener = activity as NextFragmentInterface
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_fragment_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    fun init() {
        btn1.setOnClickListener {
            if (listener != null) {
                (listener as NextFragmentInterface).nextFragment(Fragment_2())
            }
        }
    }
}