package others;

/**
 * @author 小宇
 * @date {2023}-{08}-{12}:{12:00}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 相同的树
 */
public class t100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q!=null) return false;
        else if(p!=null && q==null) return false;
        else if(p==null && q==null) return true;
        else if(p.val!=q.val) return false;

        boolean res1 = isSameTree(p.left, q.left);
        boolean res2 = isSameTree(p.right, q.right);
        return res2&res1;
    }
}
