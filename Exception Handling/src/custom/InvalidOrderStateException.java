package custom;

/**
 * Domain'e özgü unchecked exception: sipariş geçersiz state'te işlem yapılmaya çalışıldığında.
 * Clean code: anlamlı isim, mesaj + cause, sadece gerekli context (orderId, mevcut state).
 */
public class InvalidOrderStateException extends RuntimeException {

    private final String orderId;
    private final String currentState;

    public InvalidOrderStateException(String message) {
        super(message);
        this.orderId = null;
        this.currentState = null;
    }

    public InvalidOrderStateException(String message, String orderId, String currentState) {
        super(message);
        this.orderId = orderId;
        this.currentState = currentState;
    }

    public InvalidOrderStateException(String message, Throwable cause) {
        super(message, cause);
        this.orderId = null;
        this.currentState = null;
    }

    public InvalidOrderStateException(String message, String orderId, String currentState, Throwable cause) {
        super(message, cause);
        this.orderId = orderId;
        this.currentState = currentState;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCurrentState() {
        return currentState;
    }
}
