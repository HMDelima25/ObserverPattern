import java.util.*;

public class NewsAgency implements Subject {
    // Maps news categories to lists of subscribed observers for targeted delivery
    private final Map<String, List<Observer>> categorySubscribers = new HashMap<>();
    private final Set<Observer> allSubscribers = new HashSet<>();

    @Override
    public void registerObserver(Observer observer, String category) {
        allSubscribers.add(observer);
        categorySubscribers.computeIfAbsent(category.toLowerCase(), k -> new ArrayList<>()).add(observer);
        System.out.println("[Subscription] " + observer.getName() + " successfully subscribed to category: " + category);
    }

    @Override
    public void removeObserver(Observer observer) {
        allSubscribers.remove(observer);
        for (List<Observer> subs : categorySubscribers.values()) {
            subs.remove(observer);
        }
        System.out.println("[Subscription] " + observer.getName() + " completely unsubscribed from all news services.");
    }

    @Override
    public void removeObserver(Observer observer, String category) {
        String catKey = category.toLowerCase();
        if (categorySubscribers.containsKey(catKey)) {
            categorySubscribers.get(catKey).remove(observer);
            System.out.println("[Subscription] " + observer.getName() + " unsubscribed from category: " + category);
        }
    }

    @Override
    public void notifyObservers(String category, String news) {
        String catKey = category.toLowerCase();
        List<Observer> subs = categorySubscribers.get(catKey);
        if (subs != null && !subs.isEmpty()) {
            for (Observer observer : subs) {
                observer.update(category, news);
            }
        } else {
            System.out.println("[System] No active subscribers found for category: " + category);
        }
    }

    public void publishNews(String category, String headline) {
        System.out.println("\n--------------------------------------------------");
        System.out.println("[BREAKING NEWS PUBLISHED] [" + category.toUpperCase() + "]: " + headline);
        System.out.println("--------------------------------------------------");
        notifyObservers(category, headline);
    }
}