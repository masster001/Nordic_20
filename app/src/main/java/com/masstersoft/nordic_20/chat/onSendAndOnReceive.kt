package com.masstersoft.nordic_20.chat

interface onSendAndOnReceive {
    fun onSend(): Int
    fun onReceive(arg: String)
}