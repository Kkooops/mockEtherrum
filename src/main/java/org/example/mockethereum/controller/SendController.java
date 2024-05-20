package org.example.mockethereum.controller;

import org.example.mockethereum.entity.SingleMsg;
import org.example.mockethereum.gloabl.MsgBus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendController {
    @GetMapping("/sendSingleMsg/{content}/{sendAddress}/{receivedAddress}")
    public String sendSingleMsg(@PathVariable("content") String content, @PathVariable("sendAddress") String sendAddress, @PathVariable("receivedAddress") String receivedAddress) {
        MsgBus.INSTANCE.addNewSingleMsg(new SingleMsg(content, sendAddress, receivedAddress, false));
        return "result_code: 200";
    }

    @GetMapping("/getSingleMsg/{address}")
    public SingleMsg getSingleMsg(@PathVariable("address") String address) {
        return MsgBus.INSTANCE.getSingleMsgFromAddress(address);
    }

    @GetMapping("/dataExec/{content}/{sendAddress}/{receivedAddress}")
    public Boolean readSingleMsg(@PathVariable("content") String content, @PathVariable("sendAddress") String sendAddress, @PathVariable("receivedAddress") String receivedAddress) {
        return MsgBus.INSTANCE.singleMsgExecRead(new SingleMsg(content, sendAddress, receivedAddress, false));
    }
}
