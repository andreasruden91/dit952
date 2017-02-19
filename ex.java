import java.util.*;

// NOTE: This is generally referred to as the Observer Pattern. And serves as a good introduction
//       to event driven programming.
//
// Let's imagine an event driven design, that has two events that fire:
// Event #1: One when a customer ENTERS our store.
// Event #2: One when a customer LEAVES our store.
//
// One programmer thinks it'd be nice to say Hi and Bye whenever someone enters/exits,
// so he writes a class that subscribes to the enter and exit events and prints a greeting.
//
// Another programmer decides to make a class that notifies the owners in the back when
// a customer enters, so they can head into the actual store and assist them.

class Customer { };

interface EnterListener {
    void invoke(Customer c);
}

interface ExitListener {
    void invoke(Customer c, int stayedForSeconds);
}

class Store {
    List<EnterListener> enterListeners = new ArrayList<>();
    List<ExitListener> exitListeners = new ArrayList<>();

    public void enter(Customer customer) {
        for (EnterListener l : enterListeners) {
            l.invoke(customer);
        }
    }

    public void exit(Customer c) {
        for (ExitListener l : exitListeners) {
            l.invoke(c, 100);
        }
    }

    public void addListener(EnterListener l) {
        enterListeners.add(l);
    }

    public void addListener(ExitListener l) {
        exitListeners.add(l);
    }
}

class GreetingSystem {
    public GreetingSystem(Store store) {
        // NOTE: Here we use lambdas, see below for a non lambda example

        store.addListener(
                (Customer c) -> System.out.println("Hello")
        );

        store.addListener(
                (Customer c, int stayTime) -> System.out.println("Bye")
        );
    }
}

// NOTE: Does not use lambda approach
class NotifyOwnersSystem implements EnterListener {
    public NotifyOwnersSystem(Store store) {
        store.addListener(this);
    }

    @Override
    public void invoke(Customer c) {
        System.out.println("Notifying people in the back, Customer entered!");
    }
}

public class ex {
    public static void main(String[] Args) {
        Store store = new Store();
        Customer c = new Customer();

        GreetingSystem gs = new GreetingSystem(store);
        NotifyOwnersSystem ns = new NotifyOwnersSystem(store);

        store.enter(c);

        store.exit(c);
    }
}