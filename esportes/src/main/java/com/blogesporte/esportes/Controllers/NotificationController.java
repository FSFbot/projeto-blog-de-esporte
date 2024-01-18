package com.blogesporte.esportes.Controllers;
import com.blogesporte.esportes.DTO.NotificationDTO;
import com.blogesporte.esportes.Service.NotificationService;
import com.blogesporte.esportes.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificationDTO> getNotification(@PathVariable Long id) {
        Notification notification = notificationService.findById(id);
        NotificationDTO notificationDTO = new NotificationDTO();
        return ResponseEntity.ok(notificationDTO);
    }

    @PostMapping
    public ResponseEntity<NotificationDTO> createNotification(@RequestBody NotificationDTO notificationDTO) {
        Notification notification = new Notification();
                Notification savedNotification = notificationService.saveNotification(notification);
        NotificationDTO savedNotificationDTO = new NotificationDTO();
        return new ResponseEntity<>(savedNotificationDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotificationDTO> updateNotification(@PathVariable Long id, @RequestBody NotificationDTO notificationDTO) {
        Notification notification = new Notification();
                notification.setId(id);
        Notification updatedNotification = notificationService.saveNotification(notification);
        NotificationDTO updatedNotificationDTO = new NotificationDTO();
        return ResponseEntity.ok(updatedNotificationDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long id) {
        notificationService.deleteNotification(id);
        return ResponseEntity.noContent().build();
    }


}
