package com.masstersoft.nordic_20.chat

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.masstersoft.nordic_20.R

class SenderFragment : Fragment() {

    var listener: ProxyListener? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (activity is ProxyListener)
            listener = activity as ProxyListener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.sender_layout, container, false)
        val send = root.findViewById(R.id.send) as Button
        val receive = root.findViewById(R.id.receive) as Button
        val info = root.findViewById<EditText>(R.id.info)

        send.setOnClickListener {
//            Toast.makeText(activity, "Button send clicked", Toast.LENGTH_SHORT)
//                .show()
            listener?.getReceiverListener()?.onReceive(info.text.toString())
            info.text.clear()

        }
        receive.setOnClickListener {
            Toast.makeText(activity,
                "Chat has about ${listener?.getCountListener()?.onSend()} items",
                Toast.LENGTH_SHORT)
                .show()
        }

        return root
    }


}