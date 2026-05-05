# Capstone Project - Phase 1: Requirements & Design
## Option B: The Smart Scheduler (Priority Queues & Heaps)

## Project Overview

For this capstone project I chose Option B which is the Smart Scheduler. The real world application I am modeling is a Customer Service Call Center ticketing system. In a call center not every support ticket is equal. A VIP customer with a critical system outage should be helped before a regular customer with a minor question even if that regular customer submitted their ticket first. This is exactly the problem a priority queue solves and it is something real tech companies like Salesforce, Zendesk, and Google use every day in their support systems.

## The Problem

The problem is managing a stream of incoming support tickets where some are more urgent than others. A regular queue follows FIFO order which means the first ticket in is the first ticket out regardless of urgency. This does not work for a real support system. A priority queue backed by a min heap solves this by always processing the highest priority ticket first no matter when it arrived.

## Data Structure Choice

I will use a Min-Heap based Priority Queue implemented with an ArrayList internally. Each entry will be a key-value pair where:
- Key = priority level (1 = most urgent, 4 = least urgent)
- Value = customer name and issue description

## Why a Heap over a Sorted or Unsorted List

Both unsorted and sorted list implementations force a trade-off where one operation is always O(n). The heap solves this by making both insert and removeMin O(log n).

 Unsorted List | O(1) | O(n) | O(n²) |
 Sorted List | O(n) | O(1) | O(n²) |
 Min-Heap | O(log n) | O(log n) | O(n log n) |

## Big-O Expectations

- **insert(ticket)** = O(log n) — add to end of heap then upheap to restore heap order property
- **removeMin()** = O(log n) — replace root with last element then downheap to restore heap order property
- **min()** = O(1) — highest priority ticket is always at the root
- **Processing all n tickets** = O(n log n)

The heap height is always O(log n) because of the Complete Binary Tree Property which guarantees all levels are full except possibly the last. This means upheap and downheap never travel more than O(log n) steps.

## Real World Scenario

Support tickets arrive with different priority levels:

Priority 1 = Critical (system outage, data loss)
Priority 2 = High (major feature broken, VIP customer)
Priority 3 = Medium (minor bug, general question)
Priority 4 = Low (feedback, feature request)

The scheduler always processes the lowest priority number first ensuring the most critical tickets are always handled first regardless of arrival order.

## Summary

A Min-Heap is the ideal data structure for this problem because it guarantees O(log n) for both insert and removeMin. This is far better than the O(n²) cost of using a sorted or unsorted list. As the number of support tickets scales to thousands or millions the heap stays efficient making it the right choice for a real world customer service system.
