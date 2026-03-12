package innerclasses;

/**
 * Dört inner class türü: member, static nested, local, anonymous.
 */
public class InnerClassesDemo {

    public static void main(String[] args) {
        System.out.println("--- Member inner (ItemCollection + ItemIterator) ---");
        ItemCollection coll = new ItemCollection(new String[]{"A", "B", "C"});
        for (var it = coll.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }

        System.out.println("--- Static nested (User.Builder) ---");
        User user = User.builder().name("Ali").email("ali@test.com").build();
        System.out.println(user.getName() + " " + user.getEmail());

        System.out.println("--- Local class ---");
        LocalClassExample.run(10);

        System.out.println("--- Anonymous vs Lambda ---");
        AnonymousClassExample.runWithRunnable();
        AnonymousClassExample.runWithLambda();
    }
}
