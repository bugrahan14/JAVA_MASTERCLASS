package practice;

import java.util.ArrayList;
import java.util.List;

/**
 * SOLID - D: LendingService interface'ine bağımlı; somut sınıfa değil.
 * Dependency injection ile servis dışarıdan verilir.
 * Polymorphism: Lendable listesi PhysicalBook ve EBook'u birlikte tutar.
 */
public class Library {

    private final LendingService lendingService;
    private final List<Lendable> items = new ArrayList<>();
    private final List<Member> members = new ArrayList<>();

    public Library(LendingService lendingService) {
        this.lendingService = lendingService;
    }

    public void addItem(Lendable item) {
        items.add(item);
    }

    public void registerMember(Member member) {
        members.add(member);
    }

    public boolean lend(String itemId, String memberId) {
        Lendable item = findItem(itemId);
        Member member = findMember(memberId);
        if (item == null || member == null) {
            return false;
        }
        return lendingService.lend(item, member);
    }

    public boolean returnItem(String itemId) {
        Lendable item = findItem(itemId);
        return item != null && lendingService.returnItem(item);
    }

    private Lendable findItem(String itemId) {
        for (Lendable item : items) {
            if (item.getItemId().equals(itemId)) {
                return item;
            }
        }
        return null;
    }

    private Member findMember(String memberId) {
        for (Member m : members) {
            if (m.getMemberId().equals(memberId)) {
                return m;
            }
        }
        return null;
    }

    public List<Lendable> getItems() {
        return new ArrayList<>(items);
    }
}
