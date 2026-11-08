public interface Subject {
    void registerObserver(Observer observer, String category);
    void removeObserver(Observer observer);
    void removeObserver(Observer observer, String category);
    void notifyObservers(String category, String news);
}