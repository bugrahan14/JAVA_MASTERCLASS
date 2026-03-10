package practice;

/**
 * SOLID - D: Library bu arayüze bağımlı; somut işlem burada implement edilir.
 * Genişletilebilir: yeni kurallar yeni implementasyonla eklenir (Open/Closed).
 */
public interface LendingService {

    boolean lend(Lendable item, Member member);

    boolean returnItem(Lendable item);
}
