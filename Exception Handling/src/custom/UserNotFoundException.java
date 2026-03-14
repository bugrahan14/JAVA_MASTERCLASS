package custom;

/**
 * Domain'e özgü checked exception: kullanıcı bulunamadığında.
 * Clean code: anlamlı isim, mesaj + isteğe bağlı cause, sadece gerekli context (userId).
 */
public class UserNotFoundException extends Exception {

    private final String userId;

    public UserNotFoundException(String message) {
        super(message);
        this.userId = null;
    }

    public UserNotFoundException(String message, String userId) {
        super(message);
        this.userId = userId;
    }

    /**
     * Cause zincirini korumak için: alt katmandaki exception'ı (örn. SQLException) sararken kullanın.
     */
    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
        this.userId = null;
    }

    public UserNotFoundException(String message, String userId, Throwable cause) {
        super(message, cause);
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
