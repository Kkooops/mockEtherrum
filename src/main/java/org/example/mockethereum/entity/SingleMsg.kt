package org.example.mockethereum.entity

data class SingleMsg(val content: String, val sendAddress: String, val receivedAddress: String, var isRead: Boolean)
