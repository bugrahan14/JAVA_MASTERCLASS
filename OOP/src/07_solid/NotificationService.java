package solid;

/**
 * D - Dependency Inversion: Üst seviye abstraction'a bağımlı.
 * Somut sınıfa değil; bu arayüze bağımlılık.
 */
public interface NotificationService {

    void send(String message);
}
