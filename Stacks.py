# Implementation of Stacks in Python using Linked List
# Provides better performance for large stacks

class Node:
    def __init__(self, value):
        self.value = value
        self.next = None
    
class Stack:
    def __init__(self):
        self.top = None
    
    def push(self, item):
        new_node = Node(item)
        new_node.next = self.top
        self.top = new_node
    
    def pop(self):
        if not self.is_empty():
            item = self.top.value
            self.top = self.top.next
            return item
        else:
            raise Exception("pop from empty stack")
    
    def peek(self):
        if not self.is_empty():
            return self.top.value
        else:
            raise Exception("pop from empty stack")
    
    def size(self):
        count = 0
        curr = self.top

        while curr:
            count += 1
            curr = curr.next
        
        return count

    def is_empty(self):
        return True if self.size() == 0 else False
