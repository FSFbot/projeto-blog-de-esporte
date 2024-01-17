package com.blogesporte.esportes.Service;

import com.blogesporte.esportes.Repository.NotificationRepository;
import com.blogesporte.esportes.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class NotificationService {
    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Transactional(readOnly = true)
    public Notification findById(Long id) {
        return notificationRepository.findById(id).orElseThrow(() -> new NotificationNotFoundException(id));
    }

    @Transactional
    public Notification saveNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Transactional
    public void deleteNotification(Long id) {
        Notification notification = findById(id);
        notificationRepository.delete(notification);
    }

    @Transactional(readOnly = true)
    public List<Notification> findAllNotifications() {
        return notificationRepository.findAll();
    }

    // Additional business logic and validation methods...

}

class NotificationNotFoundException extends RuntimeException {
    NotificationNotFoundException(Long id) {
        super("Could not find notification " + id);
    }
}
