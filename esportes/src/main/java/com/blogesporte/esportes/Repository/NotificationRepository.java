package com.blogesporte.esportes.Repository;

import com.blogesporte.esportes.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification,Long> {
}
