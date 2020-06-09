//notation: js file can only use this kind of comments
//since comments will cause error when use in webview.loadurl,
//comments will be remove by java use regexp
(function() {
    if (window.NEJSBridge) {
        return;
    }

    if (!window.onerror) {
        window.onerror = function(msg, url, line) {
        console.log("NEJSBridge: ERROR:" + msg + "@" + url + ":" + line);
        }
    }

    window.NEJSBridge = {

        // JS Public: 注册JS方法
        registerHandler: registerHandler,

        // JS Public: JS调用native方法
        callHandler: callHandler,

        // iOS Native组件调用：JS调用Native时，获取JS的message queue
        // 格式[{"handlerName":"testNativeCallback","data":{"foo":"bar"},"callbackId":"cb_1_1496285340821"}]
        _fetchJSMessageQueueInIOS: _fetchJSMessageQueueInIOS,

        // android Native组件调用：JS调用Native时，获取JS的message queue
        // 提供给native调用,该函数作用:获取sendMessageQueue返回给native,由于android不能直接获取返回的内容,所以使用url shouldOverrideUrlLoading 的方式返回内容
        _fetchJSMessageQueueInAndroid: _fetchJSMessageQueueInAndroid,

        // Native组件调用：Native调用JS时，JS的处理
        _handleMessageFromNative: _handleMessageFromNative
    };

    var messagingIframe;

    // JS调用native的message queue：{"handlerName":"testNativeCallback","data":{"foo":"bar"},"callbackId":"cb_1_1496285340821"}
    var sendMessageQueue = [];

    // JS注册的handers。格式：{handlerName1:handlerName1 function, handlerName2:handlerName2 function }
    var messageHandlers = {};

    // URL Scheme，需与native保持一致
    var CUSTOM_PROTOCOL_SCHEME = 'nejb';
    var QUEUE_HAS_MESSAGE = 'nejb_queue_message';

    // JS调用native时，JS的Callbacks。格式：{ handlerName:handlerName, data:data, callbackId:callbackId }
    var responseCallbacks = {};
    var uniqueId = 1;

    function _createQueueReadyIframe(doc) {
        messagingIframe = doc.createElement('iframe');
        messagingIframe.style.display = 'none';
        doc.documentElement.appendChild(messagingIframe);
    }

    function registerHandler(handlerName, handler) {
        messageHandlers[handlerName] = handler;
    }

    function callHandler(handlerName, data, responseCallback) {

        if (arguments.length == 2 && typeof data == 'function') {
            responseCallback = data;
            data = null;
        }

        _doSend({
            handlerName: handlerName,
            data: data
        }, responseCallback);
    }

    //sendMessage add message, 触发native处理 sendMessage
    function _doSend(message, responseCallback) {
        if (responseCallback) {
            var callbackId = 'cb_' + (uniqueId++) + '_' + new Date().getTime();
            responseCallbacks[callbackId] = responseCallback;
            message.callbackId = callbackId;
        }

        sendMessageQueue.push(message);
        messagingIframe.src = CUSTOM_PROTOCOL_SCHEME + '://' + QUEUE_HAS_MESSAGE;
    }

    function _fetchJSMessageQueueInIOS() {
        var messageQueueString = JSON.stringify(sendMessageQueue);
        sendMessageQueue = [];
        return messageQueueString;
    }

    // 提供给native调用,该函数作用:获取sendMessageQueue返回给native,由于android不能直接获取返回的内容,所以使用url shouldOverrideUrlLoading 的方式返回内容
    function _fetchJSMessageQueueInAndroid() {
        var messageQueueString = JSON.stringify(sendMessageQueue);
        sendMessageQueue = [];
        //android can't read directly the return data, so we can reload iframe src to communicate with java
        messagingIframe.src = CUSTOM_PROTOCOL_SCHEME + '://return/_fetchJSMessageQueueInAndroid/' + encodeURIComponent(messageQueueString);
    }

    //提供给native使用,
    function _dispatchMessageFromNative(messageJSON) {
        setTimeout(function() {
            var message = JSON.parse(messageJSON);
            var responseCallback;
            //java call finished, now need to call js callback function
            if (message.responseId) {
                responseCallback = responseCallbacks[message.responseId];
                if (!responseCallback) {
                    return;
                }
                responseCallback(message.responseData);
                delete responseCallbacks[message.responseId];
            } else {
                //直接发送
                if (message.callbackId) {
                    var callbackResponseId = message.callbackId;
                    responseCallback = function(responseData) {
                        _doSend({
                            handlerName:message.handlerName,
                            responseId: callbackResponseId,
                            responseData: responseData
                        });
                    };
                }

                var handler = messageHandlers[message.handlerName];
                if (!handler) {
                    console.log("NEJSBridge: WARNING: no handler for message from ObjC:", message);
                } else {
                    handler(message.data, responseCallback);
                }
            }
        });
    }

    function _handleMessageFromNative(messageJSON) {
        _dispatchMessageFromNative(messageJSON);
    }

    var doc = document;
    _createQueueReadyIframe(doc);
    var readyEvent = doc.createEvent('Events');
    readyEvent.initEvent('NEJSBridgeReady');
    readyEvent.bridge = NEJSBridge;
    doc.dispatchEvent(readyEvent);

})();
