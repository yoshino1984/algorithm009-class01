学习笔记

数组 Array
时间复杂度：
已知要删除元素的下标情况下插入、删除O(N)，
随机访问下标的查询O(1)

链表 LinkedList
时间复杂度：插入、删除O(1)，随机访问下标的查询O(N)

跳表 Skip List
适用于元素有序的情况
时间复杂度：插入、删除、查询O(logN)
空间复杂度：O(N)

解题的两种方式：
1、升维：一维的数据结构通过附加信息（比如有序 缓存）等变成多维的数据结构，可以更有效的对数据进行获取和操作
2、空间换时间

刻意练习方法：
1、五遍刷题法
2、刷题流程（1、5-10分钟读题和思考、有思路就自己写，没有直接看题解 2、默写背诵（高票答案）、熟悉自己写）


Stack：先入后出；添加、删除皆为 O(1)

Queue：先入先出；添加、删除皆为 O(1)

Deque：双端队列，简单理解为两端卡都可以近处的Queue；添加和删除都是O(1)操作

 
课后作业：
priorityQueue的Java源码实现分析
一个无界基于优先级堆的优先级队列，队列中元素按照自然排序有序，可以通过在构造时提供Comparator来改变排序规则
不允许null元素
方法列表：add、clear、comparator、contains、iterator、offer、remove、spliterator、toArray


