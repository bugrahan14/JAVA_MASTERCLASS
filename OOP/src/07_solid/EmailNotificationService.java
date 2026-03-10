package solid;

/**
 * D - Dependency Inversion: Somut implementasyon.
 */
public class EmailNotificationService implements NotificationService {

    @Override
    public void send(String message) {
        System.out.println("Email: " + message);
    }
}
