学习笔记

哈希表、映射、集合
散列表（hash table），根据key来直接访问对应的元素，通过把key映射为表中的一个位置来访问记录，以加快查找的速度
集合可以使用哈希表的方式来进行实现
时间复杂度 查询、插入、删除的时间复杂度都为O(1)
适用于精确查询的场景，不适合范围区间查询的场景


树、二叉树、二叉搜索树
前中后序遍历： 根据根节点的访问顺序来区分
二叉搜索树的中序遍历即为升序遍历，查询、插入新节点、删除 均为O(logN)


堆、二叉堆、图
大顶堆和小顶堆
堆有多种实现，二叉堆（性能并不是最优的）只是其中一种，工程实践经常采用斐波拉契堆的实现方式

图
结构：分为向和无向 有权和无权 实现可以使用邻接矩阵或者邻接表来实现
相关的算法，基本：DFS和BFS 


HashMap总结（只针对get和put进行简单分析）：
hashMap结构：数组（可以动态扩容）加上链表的方式，链表在一定情况下可以进行树化，避免hash大量相同的情况下，导致的性能恶化（插入和查询恶化为O(N)）
1、get(Object key)方法
首先对key进行hash，找到对应的数组下标，获取存放在该位置的元素第一个节点first，然后对比first的key是否与key相等。
如果不相等，则检查first是否有下一个元素，判断first是否是TreeNode节点（是否树化的判断），走不同的链表（二叉树）遍历逻辑，继续尝试寻找key对应的对象

2、put(K key, V value)
首先对key进行hash获取hashval，检查数组下标对应的位置是否有元素，如果没有元素，则直接将节点设置进去
如果有节点，则判断该阶段是否是TreeNode节点，如果是则调用putTreeVal节点的方式
如果只是普通链表，则遍历链表直到末尾，插入节点，判断该链表是否过长（节点数达到8），过长则进行树化（treeifyBin）
插入完成后，该map内元素是否超过threshold，若果超过则需要进行 resize 扩容。

