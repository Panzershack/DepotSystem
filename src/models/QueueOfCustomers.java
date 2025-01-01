package models;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Manages the queue of customers.
 * Provides methods to enqueue, dequeue, and check the queue state.
 */
public class QueueOfCustomers {
    private Queue<Customer> queue;

    // Constructor
    public QueueOfCustomers() {
        this.queue = new LinkedList<>();
    }

    // Enqueue a customer
    public void enqueue(Customer customer) {
        queue.add(customer);
    }

    // Dequeue a customer
    public Customer dequeue() {
        return queue.poll();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Peek at the next customer in the queue
    public Customer peek() {
        return queue.peek();
    }

    // Get the entire queue
    public Queue<Customer> getQueue() {
        return queue;
    }
}
