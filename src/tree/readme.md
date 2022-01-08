### 144
前序遍历（迭代法）

![img.png](https://tva1.sinaimg.cn/large/008eGmZEly1gnbmss7603g30eq0d4b2a.gif)


### 145
中序遍历（迭代法）

![](https://tva1.sinaimg.cn/large/008eGmZEly1gnbmuj244bg30eq0d4kjm.gif)

### 145
后序遍历（迭代法）

![](https://img-blog.csdnimg.cn/20200808200338924.png)


### 如何构建二叉树
题目：105和106

前序和中序，中序和后续都可以确定一颗二叉树

前序和后序不能唯一确定一颗二叉树！，因为没有中序遍历无法确定左右部分，也就是无法分割。

解题步骤

第一步：如果数组大小为零的话，说明是空节点了。

第二步：如果不为空，那么取后序数组最后一个元素作为节点元素或者前序数组第一个元素作为节点。

第三步：找到后序数组最后一个元素或者前序数组第一个元素在中序数组的位置，作为切割点

第四步：切割中序数组，切成中序左数组和中序右数组 （顺序别搞反了，一定是先切中序数组）

第五步：切割后序数组或前序数组，切成后序左数组和后序右数组，或者前序左数组和前序右数组

第六步：递归处理左区间和右区间


构建树的递归伪代码
```java
public TreeNode build(参数){
    
    if(){
        return null;
    }
    
    if(){
        return new TreeNode(val1);
    }
    
    TreeNode node = new TreeNode(val2);
    
    node.left = build(参数);
    node.right = build(参数);
    
}
```