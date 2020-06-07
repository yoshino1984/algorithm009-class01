学习笔记

递归：
步骤：1、终结条件处理 2、当前层处理 3、下到一下层的逻辑 4、清理当前层部分逻辑
注意点：1、不要人肉递归 2、找最近重复性 3、数学归纳法思维

分治和回溯本质上就是递归的一个细分类目
分治：找重复性、分解问题split、组合结果merge）
template: 1.terminator 2.process(split your big problem) 3. drill down(subproblems) merge(subresult) 4. reverse states

回溯：
类似于枚举的方式尝试所有可能性，来查找到最终的结果集
可以通过提前判断的方式，减少计算量