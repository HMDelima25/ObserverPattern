public class Main {
    public static void main(String[] args) {
        // Initialize the News Agency (Publisher)
        NewsAgency agency = new NewsAgency();

        // Create Subscribers
        Observer alice = new UserSubscriber("Alice");
        Observer bob = new UserSubscriber("Bob");
        Observer charlie = new UserSubscriber("Charlie");

        System.out.println("=== Phase 1: Setting up Subscriptions ===");
        agency.registerObserver(alice, "Technology");
        agency.registerObserver(bob, "Technology");
        agency.registerObserver(bob, "Sports");
        agency.registerObserver(charlie, "Finance");

        System.out.println("\n=== Phase 2: Publishing Initial Breaking News ===");
        agency.publishNews("Technology", "Quantum Computing milestone achieved by research institute.");
        agency.publishNews("Sports", "Underdog team secures dramatic victory in championship finals.");

        System.out.println("\n=== Phase 3: Dynamic Updates (Unsubscribing / Modifying Preferences) ===");
        // Bob updates preferences by leaving Technology
        agency.removeObserver(bob, "Technology");

        // Charlie joins Technology
        agency.registerObserver(charlie, "Technology");

        System.out.println("\n=== Phase 4: Publishing News Post-Updates ===");
        agency.publishNews("Technology", "New open-source AI model released globally.");
        agency.publishNews("Finance", "Global markets surge following inflation report.");
    }
}