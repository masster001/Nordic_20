package com.masstersoft.nordic_20.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.masstersoft.nordic_20.R
import kotlinx.android.synthetic.main.receiver_layout.*

class ReceiverFragment : Fragment(), onSendAndOnReceive {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.receiver_layout, container, false)
    }

    override fun onReceive(arg: String) {
//        val result = "\n > $arg"
//        chat.append(result)
        chat.append("\n > $arg")
    }

    override fun onSend(): Int {
        return chat.text.length
    }
}