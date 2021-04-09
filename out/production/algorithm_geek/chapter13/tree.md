### 平衡树：AVL，红黑树，伸展树，B-树

#### AVL：保证结点的大小顺序(二叉搜索树 + 平衡因子)
    旋转： RR --> L
          LL --> R
          LR --> LR
          RL --> RL
    缺点：结点需要存储额外信息，且调整次数频繁

#### 红黑树（近似平衡的二叉搜索树）：确保任何一个结点的左右子树的高度差小于两倍。
     1.每个结点要么是红色，要么是黑色
     2.根节点是黑色
     3.每个叶节点在(NIL结点,空结点)是黑色的
     4.不能有相邻接的两个红色结点
     5.从任一结点到其每个叶子的所有路径都包含相同数目的黑色结点

### 面试知识点
    1.AVL trees provide faster lookups than Red Black Trees because they are more strictly balanced.
    2.Red Black Trees provide faster insertion and removal operations than AVL trees as fewer rotations are done due to relatively relaxed balancing.
    3.AVL trees store balance factors or heights with each node,thus requires storage for an integer per node whereas Red Black Tree requires only 1 bit of information per node.
    4.Red Black Trees are used in most of the language libraries like map,multimap,multisetin C++ whereas AVL trees are used in databases where faster retrievals are required.
    读的多用AVL,写的多用红黑树