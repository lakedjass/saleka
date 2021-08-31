package com.saleka.application.notification;

import com.saleka.application.notification.message.Message;

public interface Notifier {
    public void notify(Message message);
}
