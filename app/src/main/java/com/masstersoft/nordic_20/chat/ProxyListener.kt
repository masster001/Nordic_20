package com.masstersoft.nordic_20.chat

interface ProxyListener {
    fun getCountListener(): OnSend?
    fun getReceiverListener(): OnReceive?
}