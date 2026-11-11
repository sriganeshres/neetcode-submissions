/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func isBalanced(root *TreeNode) bool {
    res, _ := dfs(root)
	return res
}

func dfs(root *TreeNode) (bool, int) {
	if root == nil {
		return true, 0
	}

	leftb, lefth := dfs(root.Left)
	rightb, righth := dfs(root.Right)

	balance := leftb && rightb && abs(lefth - righth) <= 1
	return balance, 1 + max(lefth, righth)	
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}

func abs(x int) int {
    if x < 0 {
        return -x
    }
    return x
}
