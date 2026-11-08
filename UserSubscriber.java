public class UserSubscriber implements Observer {
    private final String name;

    public UserSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String category, String news) {
        System.out.println("-> Notification received by " + name + " [" + category.toUpperCase() + "]: " + news);
    }

    @Override
    public String getName() {
        return name;
    }
}