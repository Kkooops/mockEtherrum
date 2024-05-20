package org.example.mockethereum.gloabl

import org.example.mockethereum.entity.GroupMsg
import org.example.mockethereum.entity.SingleMsg

object MsgBus {

    val singleMsgList = arrayListOf<SingleMsg>()

    val groupMsgList = arrayListOf<GroupMsg>()

    fun getSingleMsgFromAddress(address: String): SingleMsg? {
        singleMsgList.forEach { it ->
            if (it.receivedAddress == address && !it.isRead) {
                return it
            }
        }
        return null
    }

    fun getGroupMsgListFromAddress(address: String): GroupMsg? {
        groupMsgList.forEach { it ->
            if (it.receivedAddress == address && !it.isRead) {
                return it
            }
        }
        return null
    }

    fun addNewSingleMsg(msg: SingleMsg) {
        singleMsgList.add(msg)
    }

    fun addNewGroupMsg(msg: GroupMsg) {
        groupMsgList.add(msg)
    }

    fun singleMsgExecRead(msg: SingleMsg): Boolean {
        singleMsgList.forEach {
            if (it.content == msg.content && it.sendAddress == msg.sendAddress && it.receivedAddress == msg.receivedAddress && !it.isRead) {
                it.isRead = true
                return true
            }
        }
        return false
    }

    fun groupMsgExecRead(msg: GroupMsg): Boolean {
        groupMsgList.forEach {
            if (it.content == msg.content && it.sendAddress == msg.sendAddress && !it.isRead) {
                it.isRead = true
                return true
            }
        }
        return false
    }
}