import time

class Node:
    def __init__(self, data=None):
        self.data = data
        self.next = None

class StackArray:
    def __init__(self):
        self.items = []

    def push(self, item):
        self.items.append(item)

    def pop(self):
        if self.items:
            return self.items.pop()

    def peek(self):
        if self.items:
            return self.items[-1]

    def is_empty(self):
        return not bool(self.items)

class StackLinkedList:
    def __init__(self):
        self.head = None

    def push(self, item):
        new_node = Node(item)
        new_node.next = self.head
        self.head = new_node

    def pop(self):
        if self.head:
            popped = self.head.data
            self.head = self.head.next
            return popped

    def peek(self):
        if self.head:
            return self.head.data

    def is_empty(self):
        return not bool(self.head)

class QueueArray:
    def __init__(self):
        self.items = []

    def enqueue(self, item):
        self.items.append(item)

    def dequeue(self):
        if self.items:
            return self.items.pop(0)

    def is_empty(self):
        return not bool(self.items)

class QueueLinkedList:
    def __init__(self):
        self.head = None
        self.tail = None

    def enqueue(self, item):
        new_node = Node(item)
        if not self.tail:
            self.head = new_node
        else:
            self.tail.next = new_node
        self.tail = new_node

    def dequeue(self):
        if self.head:
            dequeued = self.head.data
            self.head = self.head.next
            if not self.head:
                self.tail = None
            return dequeued

    def is_empty(self):
        return not bool(self.head)

def test_stack(container, num_elements):
    start_time = time.time()

    for i in range(num_elements):
        container.push(i)
    
    while not container.is_empty():
        container.pop()

    end_time = time.time()
    return end_time - start_time

def test_queue(container, num_elements):
    start_time = time.time()

    for i in range(num_elements):
        container.enqueue(i)
    
    while not container.is_empty():
        container.dequeue()

    end_time = time.time()
    return end_time - start_time

# Experiment
num_elements = 10000
iterations = 10
results = {'StackArray': [], 'StackLinkedList': [], 'QueueArray': [], 'QueueLinkedList': []}

for i in range(iterations):
    print(f"Iteration {i+1}/{iterations}")
    stack_array_time = test_stack(StackArray(), num_elements)
    stack_linked_list_time = test_stack(StackLinkedList(), num_elements)
    queue_array_time = test_queue(QueueArray(), num_elements)
    queue_linked_list_time = test_queue(QueueLinkedList(), num_elements)
    results['StackArray'].append(stack_array_time)
    results['StackLinkedList'].append(stack_linked_list_time)
    results['QueueArray'].append(queue_array_time)
    results['QueueLinkedList'].append(queue_linked_list_time)
    num_elements += 10000

print("Results:")
for container, times in results.items():
    print(f"{container}: {times}")
