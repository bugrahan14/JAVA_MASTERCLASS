package practice;

/**
 * Basit ödünç verme servisi: Müsaitlik kontrolü, ödünç ver / iade al.
 */
public class SimpleLendingService implements LendingService {

    @Override
    public boolean lend(Lendable item, Member member) {
        if (!item.isAvailable()) {
            return false;
        }
        item.setAvailable(false);
        return true;
    }

    @Override
    public boolean returnItem(Lendable item) {
        item.setAvailable(true);
        return true;
    }
}
